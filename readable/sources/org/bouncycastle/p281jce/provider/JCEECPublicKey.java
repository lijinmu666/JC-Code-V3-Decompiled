package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p133asn1.p176x9.X9IntegerConverter;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p281jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JCEECPublicKey implements ECPublicKey, org.bouncycastle.p281jce.interfaces.ECPublicKey, ECPointEncoder {
    private String algorithm;

    /* renamed from: ecSpec */
    private ECParameterSpec f22003ecSpec;
    private GOST3410PublicKeyAlgParameters gostParams;

    /* renamed from: q */
    private AbstractC5820ECPoint f22004q;
    private boolean withCompression;

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f22003ecSpec = params;
        this.f22004q = C5617EC5Util.convertPoint(params, eCPublicKeySpec.getW());
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, C5617EC5Util.convertPoint(eCDomainParameters.m15720getG()), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH().intValue());
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        AbstractC5817ECCurve curve;
        ECParameterSpec eCParameterSpec;
        byte[] bytes;
        ASN1OctetString dEROctetString;
        byte b;
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        if (algorithm.getAlgorithm().m14446equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_2001)) {
            ASN1BitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
            this.algorithm = "ECGOST3410";
            try {
                byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
                byte[] bArr = new byte[65];
                bArr[0] = 4;
                for (int i = 1; i <= 32; i++) {
                    bArr[i] = octets[32 - i];
                    bArr[i + 32] = octets[64 - i];
                }
                GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(algorithm.getParameters());
                this.gostParams = gOST3410PublicKeyAlgParameters;
                ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()));
                AbstractC5817ECCurve curve2 = parameterSpec.getCurve();
                EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(curve2, parameterSpec.m16272getSeed());
                this.f22004q = curve2.decodePoint(bArr);
                this.f22003ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(this.gostParams.getPublicKeyParamSet()), ellipticCurveConvertCurve, C5617EC5Util.convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
                return;
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering public key");
            }
        }
        X962Parameters x962Parameters = X962Parameters.getInstance(algorithm.getParameters());
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.getParameters();
            X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
            curve = namedCurveByOid.getCurve();
            eCParameterSpec = new ECNamedCurveSpec(C5618ECUtil.getCurveName(aSN1ObjectIdentifier), C5617EC5Util.convertCurve(curve, namedCurveByOid.m14738getSeed()), C5617EC5Util.convertPoint(namedCurveByOid.m14735getG()), namedCurveByOid.m14737getN(), namedCurveByOid.m14736getH());
        } else {
            if (x962Parameters.isImplicitlyCA()) {
                this.f22003ecSpec = null;
                curve = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve();
                bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
                dEROctetString = new DEROctetString(bytes);
                if (bytes[0] == 4 && bytes[1] == bytes.length - 2 && (((b = bytes[2]) == 2 || b == 3) && new X9IntegerConverter().getByteLength(curve) >= bytes.length - 3)) {
                    try {
                        dEROctetString = (ASN1OctetString) ASN1Primitive.fromByteArray(bytes);
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
                this.f22004q = new X9ECPoint(curve, dEROctetString).getPoint();
            }
            X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
            curve = x9ECParameters.getCurve();
            eCParameterSpec = new ECParameterSpec(C5617EC5Util.convertCurve(curve, x9ECParameters.m14738getSeed()), C5617EC5Util.convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
        }
        this.f22003ecSpec = eCParameterSpec;
        bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        dEROctetString = new DEROctetString(bytes);
        if (bytes[0] == 4) {
            dEROctetString = (ASN1OctetString) ASN1Primitive.fromByteArray(bytes);
        }
        this.f22004q = new X9ECPoint(curve, dEROctetString).getPoint();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }

    public AbstractC5820ECPoint engineGetQ() {
        return this.f22004q;
    }

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f22003ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16241equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        return engineGetQ().m16333equals(jCEECPublicKey.engineGetQ()) && engineGetSpec().m16268equals(jCEECPublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        ASN1Encodable x962Parameters2;
        if (this.algorithm.equals("ECGOST3410")) {
            ASN1Encodable aSN1Encodable = this.gostParams;
            if (aSN1Encodable == null) {
                ECParameterSpec eCParameterSpec = this.f22003ecSpec;
                if (eCParameterSpec instanceof ECNamedCurveSpec) {
                    x962Parameters2 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.m14571getOID(((ECNamedCurveSpec) eCParameterSpec).m16267getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
                } else {
                    AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                    x962Parameters2 = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f22003ecSpec.getGenerator()), this.withCompression), this.f22003ecSpec.getOrder(), BigInteger.valueOf(this.f22003ecSpec.getCofactor()), this.f22003ecSpec.getCurve().getSeed()));
                }
                aSN1Encodable = x962Parameters2;
            }
            BigInteger bigInteger = this.f22004q.getAffineXCoord().toBigInteger();
            BigInteger bigInteger2 = this.f22004q.getAffineYCoord().toBigInteger();
            byte[] bArr = new byte[64];
            extractBytes(bArr, 0, bigInteger);
            extractBytes(bArr, 32, bigInteger2);
            try {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, aSN1Encodable), new DEROctetString(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.f22003ecSpec;
            if (eCParameterSpec2 instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec2).m16267getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f22003ecSpec).m16267getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else if (eCParameterSpec2 == null) {
                x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
            } else {
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve2 = C5617EC5Util.convertCurve(eCParameterSpec2.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve2, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve2, this.f22003ecSpec.getGenerator()), this.withCompression), this.f22003ecSpec.getOrder(), BigInteger.valueOf(this.f22003ecSpec.getCofactor()), this.f22003ecSpec.getCurve().getSeed()));
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), mo16095getQ().getEncoded(this.withCompression));
        }
        return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f22003ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f22003ecSpec;
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPublicKey
    /* renamed from: getQ */
    public AbstractC5820ECPoint mo16095getQ() {
        ECParameterSpec eCParameterSpec = this.f22003ecSpec;
        AbstractC5820ECPoint abstractC5820ECPoint = this.f22004q;
        return eCParameterSpec == null ? abstractC5820ECPoint.getDetachedPoint() : abstractC5820ECPoint;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return C5617EC5Util.convertPoint(this.f22004q);
    }

    public int hashCode() {
        return engineGetSpec().hashCode() ^ engineGetQ().hashCode();
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("EC Public Key");
        sb.append(strLineSeparator);
        sb.append("            X: ");
        sb.append(this.f22004q.getAffineXCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        sb.append("            Y: ");
        sb.append(this.f22004q.getAffineYCoord().toBigInteger().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.f22004q = eCPublicKeyParameters.m15728getQ();
        this.f22003ecSpec = null;
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f22004q = eCPublicKeyParameters.m15728getQ();
        if (eCParameterSpec == null) {
            this.f22003ecSpec = createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters);
        } else {
            this.f22003ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f22004q = eCPublicKeyParameters.m15728getQ();
        this.f22003ecSpec = eCParameterSpec == null ? createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters) : C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), eCParameterSpec);
    }

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = str;
        this.f22004q = jCEECPublicKey.f22004q;
        this.f22003ecSpec = jCEECPublicKey.f22003ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
    }

    public JCEECPublicKey(String str, org.bouncycastle.p281jce.p282spec.ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec eCParameterSpecConvertSpec;
        this.algorithm = str;
        this.f22004q = eCPublicKeySpec.m16274getQ();
        if (eCPublicKeySpec.getParams() != null) {
            eCParameterSpecConvertSpec = C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().m16272getSeed()), eCPublicKeySpec.getParams());
        } else {
            if (this.f22004q.getCurve() == null) {
                this.f22004q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.f22004q.getAffineXCoord().toBigInteger(), this.f22004q.getAffineYCoord().toBigInteger());
            }
            eCParameterSpecConvertSpec = null;
        }
        this.f22003ecSpec = eCParameterSpecConvertSpec;
    }

    public JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f22003ecSpec = params;
        this.f22004q = C5617EC5Util.convertPoint(params, eCPublicKey.getW());
    }

    public JCEECPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "EC";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }
}
