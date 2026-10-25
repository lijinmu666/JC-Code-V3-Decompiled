package org.bouncycastle.p249jcajce.provider.asymmetric.p255ecgost;

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
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECGOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class BCECGOST3410PublicKey implements ECPublicKey, org.bouncycastle.p281jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient ECPublicKeyParameters ecPublicKey;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21512ecSpec;
    private transient ASN1Encodable gostParams;
    private boolean withCompression;

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.f21512ecSpec = null;
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
        ASN1ObjectIdentifier publicKeyParamSet;
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
            boolean z = subjectPublicKeyInfo.getAlgorithm().getParameters() instanceof ASN1ObjectIdentifier;
            ASN1Encodable parameters = subjectPublicKeyInfo.getAlgorithm().getParameters();
            if (z) {
                publicKeyParamSet = ASN1ObjectIdentifier.getInstance(parameters);
                this.gostParams = publicKeyParamSet;
            } else {
                GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(parameters);
                this.gostParams = gOST3410PublicKeyAlgParameters;
                publicKeyParamSet = gOST3410PublicKeyAlgParameters.getPublicKeyParamSet();
            }
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(publicKeyParamSet));
            AbstractC5817ECCurve curve = parameterSpec.getCurve();
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(curve, parameterSpec.m16272getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(curve.decodePoint(bArr), C5618ECUtil.getDomainParameters((ProviderConfiguration) null, parameterSpec));
            this.f21512ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(publicKeyParamSet), ellipticCurveConvertCurve, C5617EC5Util.convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f21512ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16102equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        return this.ecPublicKey.m15728getQ().m16333equals(bCECGOST3410PublicKey.ecPublicKey.m15728getQ()) && engineGetSpec().m16268equals(bCECGOST3410PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Encodable x962Parameters;
        ASN1Encodable gostParams = getGostParams();
        if (gostParams == null) {
            ECParameterSpec eCParameterSpec = this.f21512ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                x962Parameters = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.m14571getOID(((ECNamedCurveSpec) eCParameterSpec).m16267getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
            } else {
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21512ecSpec.getGenerator()), this.withCompression), this.f21512ecSpec.getOrder(), BigInteger.valueOf(this.f21512ecSpec.getCofactor()), this.f21512ecSpec.getCurve().getSeed()));
            }
            gostParams = x962Parameters;
        }
        BigInteger bigInteger = this.ecPublicKey.m15728getQ().getAffineXCoord().toBigInteger();
        BigInteger bigInteger2 = this.ecPublicKey.m15728getQ().getAffineYCoord().toBigInteger();
        byte[] bArr = new byte[64];
        extractBytes(bArr, 0, bigInteger);
        extractBytes(bArr, 32, bigInteger2);
        try {
            return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, gostParams), new DEROctetString(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public ASN1Encodable getGostParams() {
        if (this.gostParams == null) {
            ECParameterSpec eCParameterSpec = this.f21512ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                this.gostParams = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.m14571getOID(((ECNamedCurveSpec) eCParameterSpec).m16267getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
            }
        }
        return this.gostParams;
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21512ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21512ecSpec;
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPublicKey
    /* renamed from: getQ */
    public AbstractC5820ECPoint mo16095getQ() {
        ECParameterSpec eCParameterSpec = this.f21512ecSpec;
        AbstractC5820ECPoint abstractC5820ECPointM15728getQ = this.ecPublicKey.m15728getQ();
        return eCParameterSpec == null ? abstractC5820ECPointM15728getQ.getDetachedPoint() : abstractC5820ECPointM15728getQ;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return C5617EC5Util.convertPoint(this.ecPublicKey.m15728getQ());
    }

    public int hashCode() {
        return engineGetSpec().hashCode() ^ this.ecPublicKey.m15728getQ().hashCode();
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return C5618ECUtil.publicKeyToString(this.algorithm, this.ecPublicKey.m15728getQ(), engineGetSpec());
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        if (parameters instanceof ECGOST3410Parameters) {
            ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters;
            this.gostParams = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet(), eCGOST3410Parameters.getEncryptionParamSet());
        }
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.f21512ecSpec = createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters);
        } else {
            this.f21512ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.f21512ecSpec = eCParameterSpec == null ? createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters) : C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), eCParameterSpec);
    }

    public BCECGOST3410PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f21512ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(C5617EC5Util.convertPoint(params, eCPublicKey.getW()), C5617EC5Util.getDomainParameters(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f21512ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(C5617EC5Util.convertPoint(params, eCPublicKeySpec.getW()), C5617EC5Util.getDomainParameters(null, eCPublicKeySpec.getParams()));
    }

    public BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "ECGOST3410";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        this.algorithm = "ECGOST3410";
        this.ecPublicKey = bCECGOST3410PublicKey.ecPublicKey;
        this.f21512ecSpec = bCECGOST3410PublicKey.f21512ecSpec;
        this.withCompression = bCECGOST3410PublicKey.withCompression;
        this.gostParams = bCECGOST3410PublicKey.gostParams;
    }

    public BCECGOST3410PublicKey(org.bouncycastle.p281jce.p282spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "ECGOST3410";
        if (eCPublicKeySpec.getParams() == null) {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.m16274getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.m16274getQ().getAffineYCoord().toBigInteger()), C5617EC5Util.getDomainParameters(providerConfiguration, null));
            this.f21512ecSpec = null;
        } else {
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().m16272getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.m16274getQ(), C5618ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.f21512ecSpec = C5617EC5Util.convertSpec(ellipticCurveConvertCurve, eCPublicKeySpec.getParams());
        }
    }
}
