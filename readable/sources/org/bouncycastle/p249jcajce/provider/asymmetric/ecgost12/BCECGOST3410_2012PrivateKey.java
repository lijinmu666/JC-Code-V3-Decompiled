package org.bouncycastle.p249jcajce.provider.asymmetric.ecgost12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
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
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCECGOST3410_2012PrivateKey implements ECPrivateKey, org.bouncycastle.p281jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;

    /* renamed from: d */
    private transient BigInteger f21521d;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21522ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECGOST3410_2012PrivateKey() {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void extractBytes(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    private ASN1BitString getPublicKeyDetails(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        return SubjectPublicKeyInfo.getInstance(bCECGOST3410_2012PublicKey.getEncoded()).getPublicKeyData();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void populateFromPrivKeyInfo(PrivateKeyInfo privateKeyInfo) {
        ECParameterSpec eCParameterSpec;
        ASN1Encodable privateKey;
        BigInteger value;
        ASN1Primitive aSN1Primitive = privateKeyInfo.getPrivateKeyAlgorithm().getParameters().toASN1Primitive();
        if (!(aSN1Primitive instanceof ASN1Sequence) || ASN1Sequence.getInstance(aSN1Primitive).mo14450size() > 3) {
            X962Parameters x962Parameters = X962Parameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
            if (x962Parameters.isNamedCurve()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(x962Parameters.getParameters());
                X9ECParameters namedCurveByOid = C5618ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
                if (namedCurveByOid == null) {
                    X9ECParameters byOIDX9 = ECGOST3410NamedCurves.getByOIDX9(aSN1ObjectIdentifier);
                    eCParameterSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(aSN1ObjectIdentifier), C5617EC5Util.convertCurve(byOIDX9.getCurve(), byOIDX9.m14738getSeed()), C5617EC5Util.convertPoint(byOIDX9.m14735getG()), byOIDX9.m14737getN(), byOIDX9.m14736getH());
                } else {
                    eCParameterSpec = new ECNamedCurveSpec(C5618ECUtil.getCurveName(aSN1ObjectIdentifier), C5617EC5Util.convertCurve(namedCurveByOid.getCurve(), namedCurveByOid.m14738getSeed()), C5617EC5Util.convertPoint(namedCurveByOid.m14735getG()), namedCurveByOid.m14737getN(), namedCurveByOid.m14736getH());
                }
            } else if (x962Parameters.isImplicitlyCA()) {
                this.f21522ecSpec = null;
                privateKey = privateKeyInfo.parsePrivateKey();
                if (privateKey instanceof ASN1Integer) {
                    org.bouncycastle.p133asn1.p167sec.ECPrivateKey eCPrivateKey = org.bouncycastle.p133asn1.p167sec.ECPrivateKey.getInstance(privateKey);
                    this.f21521d = eCPrivateKey.m14639getKey();
                    this.publicKey = eCPrivateKey.getPublicKey();
                    return;
                }
                value = ASN1Integer.getInstance(privateKey).getValue();
            } else {
                X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
                eCParameterSpec = new ECParameterSpec(C5617EC5Util.convertCurve(x9ECParameters.getCurve(), x9ECParameters.m14738getSeed()), C5617EC5Util.convertPoint(x9ECParameters.m14735getG()), x9ECParameters.m14737getN(), x9ECParameters.m14736getH().intValue());
            }
            this.f21522ecSpec = eCParameterSpec;
            privateKey = privateKeyInfo.parsePrivateKey();
            if (privateKey instanceof ASN1Integer) {
            }
        } else {
            GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
            this.gostParams = gOST3410PublicKeyAlgParameters;
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()));
            this.f21522ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(this.gostParams.getPublicKeyParamSet()), C5617EC5Util.convertCurve(parameterSpec.getCurve(), parameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
            ASN1OctetString privateKey2 = privateKeyInfo.getPrivateKey();
            if (privateKey2.getOctets().length == 32 || privateKey2.getOctets().length == 64) {
                value = new BigInteger(1, C6238Arrays.m18267reverse(privateKey2.getOctets()));
            } else {
                ASN1Encodable privateKey3 = privateKeyInfo.parsePrivateKey();
                if (!(privateKey3 instanceof ASN1Integer)) {
                    this.f21521d = new BigInteger(1, C6238Arrays.m18267reverse(ASN1OctetString.getInstance(privateKey3).getOctets()));
                    return;
                }
                value = ASN1Integer.getInstance(privateKey3).getPositiveValue();
            }
        }
        this.f21521d = value;
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
        ECParameterSpec eCParameterSpec = this.f21522ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16104equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PrivateKey)) {
            return false;
        }
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = (BCECGOST3410_2012PrivateKey) obj;
        return mo16093getD().equals(bCECGOST3410_2012PrivateKey.mo16093getD()) && engineGetSpec().m16268equals(bCECGOST3410_2012PrivateKey.engineGetSpec());
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
        return this.f21521d;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int orderBitLength;
        boolean z = this.f21521d.bitLength() > 256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = z ? RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512 : RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
        int i = z ? 64 : 32;
        if (this.gostParams != null) {
            byte[] bArr = new byte[i];
            extractBytes(bArr, i, 0, getS());
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, this.gostParams), new DEROctetString(bArr)).getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException unused) {
                return null;
            }
        }
        ECParameterSpec eCParameterSpec = this.f21522ecSpec;
        try {
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = C5618ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).m16267getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f21522ecSpec).m16267getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else {
                if (eCParameterSpec == null) {
                    x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
                    orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
                    return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, x962Parameters.toASN1Primitive()), (this.publicKey == null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, x962Parameters) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), x962Parameters)).toASN1Primitive()).getEncoded(ASN1Encoding.f17902DER);
                }
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21522ecSpec.getGenerator()), this.withCompression), this.f21522ecSpec.getOrder(), BigInteger.valueOf(this.f21522ecSpec.getCofactor()), this.f21522ecSpec.getCurve().getSeed()));
            }
            return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, x962Parameters.toASN1Primitive()), (this.publicKey == null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, x962Parameters) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), x962Parameters)).toASN1Primitive()).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused2) {
            return null;
        }
        orderBitLength = C5618ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.f21522ecSpec.getOrder(), getS());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21522ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21522ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f21521d;
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
        return C5618ECUtil.privateKeyToString(this.algorithm, this.f21521d, engineGetSpec());
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21521d = eCPrivateKeyParameters.m15727getD();
        this.f21522ecSpec = null;
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f21521d = eCPrivateKeyParameters.m15727getD();
        if (eCParameterSpec == null) {
            this.f21522ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        } else {
            this.f21522ecSpec = eCParameterSpec;
        }
        this.gostParams = bCECGOST3410_2012PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.f21521d = eCPrivateKeyParameters.m15727getD();
        this.f21522ecSpec = eCParameterSpec == null ? new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue()) : new ECParameterSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), C5617EC5Util.convertPoint(eCParameterSpec.m16269getG()), eCParameterSpec.m16271getN(), eCParameterSpec.m16270getH().intValue());
        this.gostParams = bCECGOST3410_2012PublicKey.getGostParams();
        this.publicKey = getPublicKeyDetails(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21521d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f21522ecSpec = eCPrivateKey.getParams();
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21521d = eCPrivateKeySpec.getS();
        this.f21522ecSpec = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410_2012PrivateKey(PrivateKeyInfo privateKeyInfo) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCECGOST3410_2012PrivateKey(BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21521d = bCECGOST3410_2012PrivateKey.f21521d;
        this.f21522ecSpec = bCECGOST3410_2012PrivateKey.f21522ecSpec;
        this.withCompression = bCECGOST3410_2012PrivateKey.withCompression;
        this.attrCarrier = bCECGOST3410_2012PrivateKey.attrCarrier;
        this.publicKey = bCECGOST3410_2012PrivateKey.publicKey;
        this.gostParams = bCECGOST3410_2012PrivateKey.gostParams;
    }

    public BCECGOST3410_2012PrivateKey(org.bouncycastle.p281jce.p282spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21521d = eCPrivateKeySpec.m16273getD();
        this.f21522ecSpec = eCPrivateKeySpec.getParams() != null ? C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().m16272getSeed()), eCPrivateKeySpec.getParams()) : null;
    }
}
