package org.bouncycastle.p249jcajce.provider.asymmetric.p255ecgost;

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
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class BCECGOST3410PrivateKey implements ECPrivateKey, org.bouncycastle.p281jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;

    /* renamed from: d */
    private transient BigInteger f21510d;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21511ecSpec;
    private transient ASN1Encodable gostParams;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECGOST3410PrivateKey() {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
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

    private ASN1BitString getPublicKeyDetails(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECGOST3410PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void populateFromPrivKeyInfo(PrivateKeyInfo privateKeyInfo) {
        ECNamedCurveSpec eCNamedCurveSpec;
        ASN1Encodable privateKey;
        BigInteger value;
        ASN1Encodable parameters = privateKeyInfo.getPrivateKeyAlgorithm().getParameters();
        ASN1Primitive aSN1Primitive = parameters.toASN1Primitive();
        if ((aSN1Primitive instanceof ASN1Sequence) && (ASN1Sequence.getInstance(aSN1Primitive).mo14450size() == 2 || ASN1Sequence.getInstance(aSN1Primitive).mo14450size() == 3)) {
            GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(parameters);
            this.gostParams = gOST3410PublicKeyAlgParameters;
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()));
            this.f21511ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()), C5617EC5Util.convertCurve(parameterSpec.getCurve(), parameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
            ASN1Encodable privateKey2 = privateKeyInfo.parsePrivateKey();
            if (privateKey2 instanceof ASN1Integer) {
                value = ASN1Integer.getInstance(privateKey2).getPositiveValue();
            } else {
                byte[] octets = ASN1OctetString.getInstance(privateKey2).getOctets();
                byte[] bArr = new byte[octets.length];
                for (int i = 0; i != octets.length; i++) {
                    bArr[i] = octets[(octets.length - 1) - i];
                }
                value = new BigInteger(1, bArr);
            }
        } else {
            X962Parameters x962Parameters = X962Parameters.getInstance(parameters);
            if (x962Parameters.isNamedCurve()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
                X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
                if (namedCurveByOid == null) {
                    throw new IllegalStateException();
                }
                eCNamedCurveSpec = new ECNamedCurveSpec(C5618ECUtil.getCurveName(aSN1ObjectIdentifier), C5617EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.m14738getSeed()), C5617EC5Util.convertPoint(namedCurveByOid.m14735getG()), namedCurveByOid.m14737getN(), namedCurveByOid.m14736getH());
            } else if (x962Parameters.isImplicitlyCA()) {
                eCNamedCurveSpec = null;
            } else {
                X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
                this.f21511ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(x9ECParameters.getCurve(), x9ECParameters.m14738getSeed()), C5617EC5Util.convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
                privateKey = privateKeyInfo.parsePrivateKey();
                if (privateKey instanceof ASN1Integer) {
                    org.bouncycastle.p133asn1.p167sec.ECPrivateKey eCPrivateKey = org.bouncycastle.p133asn1.p167sec.ECPrivateKey.getInstance(privateKey);
                    this.f21510d = eCPrivateKey.m14639getKey();
                    this.publicKey = eCPrivateKey.getPublicKey();
                    return;
                }
                value = ASN1Integer.getInstance(privateKey).getValue();
            }
            this.f21511ecSpec = eCNamedCurveSpec;
            privateKey = privateKeyInfo.parsePrivateKey();
            if (privateKey instanceof ASN1Integer) {
            }
        }
        this.f21510d = value;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f21511ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16101equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        return mo16093getD().equals(bCECGOST3410PrivateKey.mo16093getD()) && engineGetSpec().m16268equals(bCECGOST3410PrivateKey.engineGetSpec());
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
        return this.f21510d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int orderBitLength;
        if (this.gostParams != null) {
            byte[] bArr = new byte[32];
            extractBytes(bArr, 0, getS());
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, this.gostParams), new DEROctetString(bArr)).getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException unused) {
                return null;
            }
        }
        ECParameterSpec eCParameterSpec = this.f21511ecSpec;
        try {
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).m16267getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f21511ecSpec).m16267getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else {
                if (eCParameterSpec == null) {
                    x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
                    orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
                    return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, x962Parameters.toASN1Primitive()), (this.publicKey == null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, x962Parameters) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), x962Parameters)).toASN1Primitive()).getEncoded(ASN1Encoding.f17902DER);
                }
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21511ecSpec.getGenerator()), this.withCompression), this.f21511ecSpec.getOrder(), BigInteger.valueOf(this.f21511ecSpec.getCofactor()), this.f21511ecSpec.getCurve().getSeed()));
            }
            return new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, x962Parameters.toASN1Primitive()), (this.publicKey == null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, x962Parameters) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), x962Parameters)).toASN1Primitive()).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused2) {
            return null;
        }
        orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.f21511ecSpec.getOrder(), getS());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21511ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21511ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f21510d;
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
        return C5618ECUtil.privateKeyToString(this.algorithm, this.f21510d, engineGetSpec());
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21510d = eCPrivateKeyParameters.m15727getD();
        this.f21511ecSpec = null;
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21510d = eCPrivateKeyParameters.m15727getD();
        if (eCParameterSpec == null) {
            ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
            eCParameterSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        }
        this.f21511ecSpec = eCParameterSpec;
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21510d = eCPrivateKeyParameters.m15727getD();
        if (eCParameterSpec == null) {
            ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
            this.f21511ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        } else {
            this.f21511ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(eCParameterSpec.m16269getG()), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
        }
        this.gostParams = bCECGOST3410PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21510d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f21511ecSpec = eCPrivateKey.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21510d = eCPrivateKeySpec.getS();
        this.f21511ecSpec = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21510d = bCECGOST3410PrivateKey.f21510d;
        this.f21511ecSpec = bCECGOST3410PrivateKey.f21511ecSpec;
        this.withCompression = bCECGOST3410PrivateKey.withCompression;
        this.attrCarrier = bCECGOST3410PrivateKey.attrCarrier;
        this.publicKey = bCECGOST3410PrivateKey.publicKey;
        this.gostParams = bCECGOST3410PrivateKey.gostParams;
    }

    public BCECGOST3410PrivateKey(org.bouncycastle.p281jce.p282spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21510d = eCPrivateKeySpec.m16273getD();
        this.f21511ecSpec = eCPrivateKeySpec.getParams() != null ? C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().m16272getSeed()), eCPrivateKeySpec.getParams()) : null;
    }
}
