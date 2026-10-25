package org.bouncycastle.p249jcajce.provider.asymmetric.p253dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
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
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class BCDSTU4145PrivateKey implements ECPrivateKey, org.bouncycastle.p281jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;

    /* renamed from: d */
    private transient BigInteger f21462d;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21463ecSpec;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCDSTU4145PrivateKey() {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private ASN1BitString getPublicKeyDetails(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCDSTU4145PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void populateFromPrivKeyInfo(PrivateKeyInfo privateKeyInfo) {
        org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec;
        ECParameterSpec eCParameterSpec2;
        ASN1Encodable privateKey;
        X962Parameters x962Parameters = X962Parameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        if (!x962Parameters.isNamedCurve()) {
            if (x962Parameters.isImplicitlyCA()) {
                this.f21463ecSpec = null;
            } else {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(x962Parameters.getParameters());
                if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
                    X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
                    eCParameterSpec2 = new ECParameterSpec(C5617EC5Util.convertCurve(x9ECParameters.getCurve(), x9ECParameters.m14738getSeed()), C5617EC5Util.convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
                } else {
                    DSTU4145Params dSTU4145Params = DSTU4145Params.getInstance(aSN1Sequence);
                    if (dSTU4145Params.isNamedCurve()) {
                        ASN1ObjectIdentifier namedCurve = dSTU4145Params.getNamedCurve();
                        ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(namedCurve);
                        eCParameterSpec = new ECNamedCurveParameterSpec(namedCurve.m14433getId(), byOID.getCurve(), byOID.m15720getG(), byOID.m15723getN(), byOID.m15721getH(), byOID.m15724getSeed());
                    } else {
                        DSTU4145ECBinary eCBinary = dSTU4145Params.getECBinary();
                        byte[] bArrM14657getB = eCBinary.m14657getB();
                        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu4145le;
                        if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                            reverseBytes(bArrM14657getB);
                        }
                        DSTU4145BinaryField field = eCBinary.getField();
                        AbstractC5817ECCurve.F2m f2m = new AbstractC5817ECCurve.F2m(field.m14655getM(), field.m14652getK1(), field.m14653getK2(), field.m14654getK3(), eCBinary.m14656getA(), new BigInteger(1, bArrM14657getB), (BigInteger) null, (BigInteger) null);
                        byte[] bArrM14658getG = eCBinary.m14658getG();
                        if (privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                            reverseBytes(bArrM14658getG);
                        }
                        eCParameterSpec = new org.bouncycastle.p281jce.p282spec.ECParameterSpec(f2m, DSTU4145PointEncoder.decodePoint(f2m, bArrM14658getG), eCBinary.m14659getN());
                    }
                    this.f21463ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(eCParameterSpec.m16269getG()), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
                }
            }
            privateKey = privateKeyInfo.parsePrivateKey();
            if (!(privateKey instanceof ASN1Integer)) {
                this.f21462d = ASN1Integer.getInstance(privateKey).getValue();
                return;
            }
            org.bouncycastle.p133asn1.p167sec.ECPrivateKey eCPrivateKey = org.bouncycastle.p133asn1.p167sec.ECPrivateKey.getInstance(privateKey);
            this.f21462d = eCPrivateKey.m14639getKey();
            this.publicKey = eCPrivateKey.getPublicKey();
            return;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
        X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier2);
        if (namedCurveByOid == null) {
            ECDomainParameters byOID2 = DSTU4145NamedCurves.getByOID(aSN1ObjectIdentifier2);
            eCParameterSpec2 = new ECNamedCurveSpec(aSN1ObjectIdentifier2.m14433getId(), C5617EC5Util.convertCurve(byOID2.getCurve(), byOID2.m15724getSeed()), C5617EC5Util.convertPoint(byOID2.m15720getG()), byOID2.m15723getN(), byOID2.m15721getH());
        } else {
            eCParameterSpec2 = new ECNamedCurveSpec(C5618ECUtil.getCurveName(aSN1ObjectIdentifier2), C5617EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.m14738getSeed()), C5617EC5Util.convertPoint(namedCurveByOid.m14735getG()), namedCurveByOid.m14737getN(), namedCurveByOid.m14736getH());
        }
        this.f21463ecSpec = eCParameterSpec2;
        privateKey = privateKeyInfo.parsePrivateKey();
        if (!(privateKey instanceof ASN1Integer)) {
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
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

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f21463ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16092equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        return mo16093getD().equals(bCDSTU4145PrivateKey.mo16093getD()) && engineGetSpec().m16268equals(bCDSTU4145PrivateKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPrivateKey
    /* renamed from: getD */
    public BigInteger mo16093getD() {
        return this.f21462d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ad A[Catch: IOException -> 0x00dd, TryCatch #0 {IOException -> 0x00dd, blocks: (B:16:0x00a3, B:18:0x00ad, B:20:0x00d6, B:19:0x00c2), top: B:23:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c2 A[Catch: IOException -> 0x00dd, TryCatch #0 {IOException -> 0x00dd, blocks: (B:16:0x00a3, B:18:0x00ad, B:20:0x00d6, B:19:0x00c2), top: B:23:0x00a3 }] */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int orderBitLength;
        ECParameterSpec eCParameterSpec = this.f21463ecSpec;
        try {
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).m16267getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f21463ecSpec).m16267getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else {
                if (eCParameterSpec == null) {
                    x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
                    orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
                    org.bouncycastle.p133asn1.p167sec.ECPrivateKey eCPrivateKey = this.publicKey == null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, x962Parameters) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), x962Parameters);
                    return (!this.algorithm.equals("DSTU4145") ? new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive()) : new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive())).getEncoded(ASN1Encoding.f17902DER);
                }
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21463ecSpec.getGenerator()), this.withCompression), this.f21463ecSpec.getOrder(), BigInteger.valueOf(this.f21463ecSpec.getCofactor()), this.f21463ecSpec.getCurve().getSeed()));
            }
            return (!this.algorithm.equals("DSTU4145") ? new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive()) : new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive())).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
        orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.f21463ecSpec.getOrder(), getS());
        if (this.publicKey == null) {
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21463ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21463ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f21462d;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public boolean hasFriendlyName() {
        return this.attrCarrier.hasFriendlyName();
    }

    public int hashCode() {
        return engineGetSpec().hashCode() ^ mo16093getD().hashCode();
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setFriendlyName(String str) {
        this.attrCarrier.setFriendlyName(str);
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return C5618ECUtil.privateKeyToString(this.algorithm, this.f21462d, engineGetSpec());
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21462d = eCPrivateKeyParameters.m15727getD();
        this.f21463ecSpec = null;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f21462d = eCPrivateKeyParameters.m15727getD();
        if (eCParameterSpec == null) {
            this.f21463ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        } else {
            this.f21463ecSpec = eCParameterSpec;
        }
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f21462d = eCPrivateKeyParameters.m15727getD();
        this.f21463ecSpec = eCParameterSpec == null ? new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue()) : new ECParameterSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(eCParameterSpec.m16269getG()), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21462d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f21463ecSpec = eCPrivateKey.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21462d = eCPrivateKeySpec.getS();
        this.f21463ecSpec = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey bCDSTU4145PrivateKey) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21462d = bCDSTU4145PrivateKey.f21462d;
        this.f21463ecSpec = bCDSTU4145PrivateKey.f21463ecSpec;
        this.withCompression = bCDSTU4145PrivateKey.withCompression;
        this.attrCarrier = bCDSTU4145PrivateKey.attrCarrier;
        this.publicKey = bCDSTU4145PrivateKey.publicKey;
    }

    public BCDSTU4145PrivateKey(org.bouncycastle.p281jce.p282spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "DSTU4145";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21462d = eCPrivateKeySpec.m16273getD();
        this.f21463ecSpec = eCPrivateKeySpec.getParams() != null ? C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().m16272getSeed()), eCPrivateKeySpec.getParams()) : null;
    }
}
