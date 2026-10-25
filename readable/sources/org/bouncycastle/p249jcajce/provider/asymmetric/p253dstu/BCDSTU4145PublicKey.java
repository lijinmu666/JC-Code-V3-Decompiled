package org.bouncycastle.p249jcajce.provider.asymmetric.p253dstu;

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
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p170ua.DSTU4145BinaryField;
import org.bouncycastle.p133asn1.p170ua.DSTU4145ECBinary;
import org.bouncycastle.p133asn1.p170ua.DSTU4145NamedCurves;
import org.bouncycastle.p133asn1.p170ua.DSTU4145Params;
import org.bouncycastle.p133asn1.p170ua.DSTU4145PointEncoder;
import org.bouncycastle.p133asn1.p170ua.UAObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class BCDSTU4145PublicKey implements ECPublicKey, org.bouncycastle.p281jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient DSTU4145Params dstuParams;
    private transient ECPublicKeyParameters ecPublicKey;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21464ecSpec;
    private boolean withCompression;

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.f21464ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, C5617EC5Util.convertPoint(eCDomainParameters.m15720getG()), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH().intValue());
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec;
        X9ECParameters x9ECParameters;
        ECParameterSpec eCParameterSpecConvertToSpec;
        ASN1BitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        this.algorithm = "DSTU4145";
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu4145le;
            if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                reverseBytes(octets);
            }
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
                x9ECParameters = X9ECParameters.getInstance(aSN1Sequence);
                eCParameterSpec = new org.bouncycastle.p281jce.p282spec.ECParameterSpec(x9ECParameters.getCurve(), x9ECParameters.m14735getG(), x9ECParameters.m14737getN(), x9ECParameters.m14736getH(), x9ECParameters.m14738getSeed());
            } else {
                DSTU4145Params dSTU4145Params = DSTU4145Params.getInstance(aSN1Sequence);
                this.dstuParams = dSTU4145Params;
                if (dSTU4145Params.isNamedCurve()) {
                    ASN1ObjectIdentifier namedCurve = this.dstuParams.getNamedCurve();
                    ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(namedCurve);
                    eCParameterSpec = new ECNamedCurveParameterSpec(namedCurve.m14433getId(), byOID.getCurve(), byOID.m15720getG(), byOID.m15723getN(), byOID.m15721getH(), byOID.m15724getSeed());
                } else {
                    DSTU4145ECBinary eCBinary = this.dstuParams.getECBinary();
                    byte[] bArrM14657getB = eCBinary.m14657getB();
                    if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                        reverseBytes(bArrM14657getB);
                    }
                    DSTU4145BinaryField field = eCBinary.getField();
                    AbstractC5817ECCurve.F2m f2m = new AbstractC5817ECCurve.F2m(field.m14655getM(), field.m14652getK1(), field.m14653getK2(), field.m14654getK3(), eCBinary.m14656getA(), new BigInteger(1, bArrM14657getB), (BigInteger) null, (BigInteger) null);
                    byte[] bArrM14658getG = eCBinary.m14658getG();
                    if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                        reverseBytes(bArrM14658getG);
                    }
                    eCParameterSpec = new org.bouncycastle.p281jce.p282spec.ECParameterSpec(f2m, DSTU4145PointEncoder.decodePoint(f2m, bArrM14658getG), eCBinary.m14659getN());
                }
                x9ECParameters = null;
            }
            AbstractC5817ECCurve curve = eCParameterSpec.getCurve();
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(curve, eCParameterSpec.m16272getSeed());
            if (this.dstuParams != null) {
                ECPoint eCPointConvertPoint = C5617EC5Util.convertPoint(eCParameterSpec.m16269getG());
                eCParameterSpecConvertToSpec = this.dstuParams.isNamedCurve() ? new ECNamedCurveSpec(this.dstuParams.getNamedCurve().m14433getId(), ellipticCurveConvertCurve, eCPointConvertPoint, eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH()) : new ECParameterSpec(ellipticCurveConvertCurve, eCPointConvertPoint, eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
            } else {
                eCParameterSpecConvertToSpec = C5617EC5Util.convertToSpec(x9ECParameters);
            }
            this.f21464ecSpec = eCParameterSpecConvertToSpec;
            this.ecPublicKey = new ECPublicKeyParameters(DSTU4145PointEncoder.decodePoint(curve, octets), C5617EC5Util.getDomainParameters(null, this.f21464ecSpec));
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void reverseBytes(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f21464ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16094equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        return this.ecPublicKey.m15728getQ().m16333equals(bCDSTU4145PublicKey.ecPublicKey.m15728getQ()) && engineGetSpec().m16268equals(bCDSTU4145PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Encodable x962Parameters = this.dstuParams;
        if (x962Parameters == null) {
            ECParameterSpec eCParameterSpec = this.f21464ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                x962Parameters = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f21464ecSpec).m16267getName()));
            } else {
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21464ecSpec.getGenerator()), this.withCompression), this.f21464ecSpec.getOrder(), BigInteger.valueOf(this.f21464ecSpec.getCofactor()), this.f21464ecSpec.getCurve().getSeed()));
            }
        }
        try {
            return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters), new DEROctetString(DSTU4145PointEncoder.encodePoint(this.ecPublicKey.m15728getQ()))));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21464ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21464ecSpec;
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPublicKey
    /* renamed from: getQ */
    public AbstractC5820ECPoint mo16095getQ() {
        AbstractC5820ECPoint abstractC5820ECPointM15728getQ = this.ecPublicKey.m15728getQ();
        return this.f21464ecSpec == null ? abstractC5820ECPointM15728getQ.getDetachedPoint() : abstractC5820ECPointM15728getQ;
    }

    /* renamed from: getSbox */
    public byte[] m16096getSbox() {
        DSTU4145Params dSTU4145Params = this.dstuParams;
        return dSTU4145Params != null ? dSTU4145Params.m14661getDKE() : DSTU4145Params.getDefaultDKE();
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

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.f21464ecSpec = createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters);
        } else {
            this.f21464ecSpec = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.f21464ecSpec = eCParameterSpec == null ? createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters) : C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), eCParameterSpec);
        this.ecPublicKey = eCPublicKeyParameters;
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "DSTU4145";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f21464ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(C5617EC5Util.convertPoint(params, eCPublicKeySpec.getW()), C5617EC5Util.getDomainParameters(null, this.f21464ecSpec));
    }

    public BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "DSTU4145";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.algorithm = "DSTU4145";
        this.ecPublicKey = bCDSTU4145PublicKey.ecPublicKey;
        this.f21464ecSpec = bCDSTU4145PublicKey.f21464ecSpec;
        this.withCompression = bCDSTU4145PublicKey.withCompression;
        this.dstuParams = bCDSTU4145PublicKey.dstuParams;
    }

    public BCDSTU4145PublicKey(org.bouncycastle.p281jce.p282spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "DSTU4145";
        if (eCPublicKeySpec.getParams() == null) {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.m16274getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.m16274getQ().getAffineYCoord().toBigInteger()), C5617EC5Util.getDomainParameters(providerConfiguration, null));
            this.f21464ecSpec = null;
        } else {
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().m16272getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.m16274getQ(), C5618ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.f21464ecSpec = C5617EC5Util.convertSpec(ellipticCurveConvertCurve, eCPublicKeySpec.getParams());
        }
    }
}
