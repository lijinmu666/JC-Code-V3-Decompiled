package org.bouncycastle.p249jcajce.provider.asymmetric.ecgost12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
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
public class BCECGOST3410_2012PublicKey implements ECPublicKey, org.bouncycastle.p281jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient ECPublicKeyParameters ecPublicKey;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21523ecSpec;
    private transient GOST3410PublicKeyAlgParameters gostParams;
    private boolean withCompression;

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.f21523ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, C5617EC5Util.convertPoint(eCDomainParameters.m15720getG()), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH().intValue());
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

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        ASN1BitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        this.algorithm = "ECGOST3410-2012";
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
            int i = algorithm.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512) ? 64 : 32;
            int i2 = i * 2;
            byte[] bArr = new byte[i2 + 1];
            bArr[0] = 4;
            for (int i3 = 1; i3 <= i; i3++) {
                bArr[i3] = octets[i - i3];
                bArr[i3 + i] = octets[i2 - i3];
            }
            GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = GOST3410PublicKeyAlgParameters.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            this.gostParams = gOST3410PublicKeyAlgParameters;
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.m14570getName(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet()));
            AbstractC5817ECCurve curve = parameterSpec.getCurve();
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(curve, parameterSpec.m16272getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(curve.decodePoint(bArr), C5618ECUtil.getDomainParameters((ProviderConfiguration) null, parameterSpec));
            this.f21523ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.m14570getName(this.gostParams.getPublicKeyParamSet()), ellipticCurveConvertCurve, C5617EC5Util.convertPoint(parameterSpec.m16269getG()), parameterSpec.m16271getN(), parameterSpec.m16270getH());
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
        ECParameterSpec eCParameterSpec = this.f21523ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16105equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PublicKey)) {
            return false;
        }
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = (BCECGOST3410_2012PublicKey) obj;
        return this.ecPublicKey.m15728getQ().m16333equals(bCECGOST3410_2012PublicKey.ecPublicKey.m15728getQ()) && engineGetSpec().m16268equals(bCECGOST3410_2012PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        int i;
        ASN1Encodable x962Parameters;
        BigInteger bigInteger = this.ecPublicKey.m15728getQ().getAffineXCoord().toBigInteger();
        BigInteger bigInteger2 = this.ecPublicKey.m15728getQ().getAffineYCoord().toBigInteger();
        boolean z = bigInteger.bitLength() > 256;
        ASN1Encodable gostParams = getGostParams();
        if (gostParams == null) {
            ECParameterSpec eCParameterSpec = this.f21523ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier aSN1ObjectIdentifierM14571getOID = ECGOST3410NamedCurves.m14571getOID(((ECNamedCurveSpec) eCParameterSpec).m16267getName());
                x962Parameters = z ? new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512) : (aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetB) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetC) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetD)) ? new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, null) : new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256);
            } else {
                AbstractC5817ECCurve abstractC5817ECCurveConvertCurve = C5617EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(abstractC5817ECCurveConvertCurve, new X9ECPoint(C5617EC5Util.convertPoint(abstractC5817ECCurveConvertCurve, this.f21523ecSpec.getGenerator()), this.withCompression), this.f21523ecSpec.getOrder(), BigInteger.valueOf(this.f21523ecSpec.getCofactor()), this.f21523ecSpec.getCurve().getSeed()));
            }
            gostParams = x962Parameters;
        }
        int i2 = 64;
        if (z) {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512;
            i = 64;
            i2 = 128;
        } else {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
            i = 32;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2 / 2;
        extractBytes(bArr, i3, 0, bigInteger);
        extractBytes(bArr, i3, i, bigInteger2);
        try {
            return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, gostParams), new DEROctetString(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public GOST3410PublicKeyAlgParameters getGostParams() {
        if (this.gostParams == null && (this.f21523ecSpec instanceof ECNamedCurveSpec)) {
            boolean z = this.ecPublicKey.m15728getQ().getAffineXCoord().toBigInteger().bitLength() > 256;
            ASN1ObjectIdentifier aSN1ObjectIdentifierM14571getOID = ECGOST3410NamedCurves.m14571getOID(((ECNamedCurveSpec) this.f21523ecSpec).m16267getName());
            this.gostParams = z ? new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512) : (aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetB) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetC) || aSN1ObjectIdentifierM14571getOID.m14446equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetD)) ? new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, null) : new GOST3410PublicKeyAlgParameters(aSN1ObjectIdentifierM14571getOID, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256);
        }
        return this.gostParams;
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21523ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21523ecSpec;
    }

    @Override // org.bouncycastle.p281jce.interfaces.ECPublicKey
    /* renamed from: getQ */
    public AbstractC5820ECPoint mo16095getQ() {
        ECParameterSpec eCParameterSpec = this.f21523ecSpec;
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

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (parameters instanceof ECGOST3410Parameters) {
            ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters;
            this.gostParams = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet(), eCGOST3410Parameters.getEncryptionParamSet());
        }
        if (eCParameterSpec == null) {
            this.f21523ecSpec = createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters);
        } else {
            this.f21523ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.f21523ecSpec = eCParameterSpec == null ? createSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), parameters) : C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), eCParameterSpec);
    }

    public BCECGOST3410_2012PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f21523ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(C5617EC5Util.convertPoint(params, eCPublicKey.getW()), C5617EC5Util.getDomainParameters(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f21523ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(C5617EC5Util.convertPoint(params, eCPublicKeySpec.getW()), C5617EC5Util.getDomainParameters(null, eCPublicKeySpec.getParams()));
    }

    public BCECGOST3410_2012PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "ECGOST3410-2012";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCECGOST3410_2012PublicKey(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.ecPublicKey = bCECGOST3410_2012PublicKey.ecPublicKey;
        this.f21523ecSpec = bCECGOST3410_2012PublicKey.f21523ecSpec;
        this.withCompression = bCECGOST3410_2012PublicKey.withCompression;
        this.gostParams = bCECGOST3410_2012PublicKey.gostParams;
    }

    public BCECGOST3410_2012PublicKey(org.bouncycastle.p281jce.p282spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "ECGOST3410-2012";
        if (eCPublicKeySpec.getParams() == null) {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.m16274getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.m16274getQ().getAffineYCoord().toBigInteger()), C5617EC5Util.getDomainParameters(providerConfiguration, null));
            this.f21523ecSpec = null;
        } else {
            EllipticCurve ellipticCurveConvertCurve = C5617EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().m16272getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.m16274getQ(), C5618ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.f21523ecSpec = C5617EC5Util.convertSpec(ellipticCurveConvertCurve, eCPublicKeySpec.getParams());
        }
    }
}
