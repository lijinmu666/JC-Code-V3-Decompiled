package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

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
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p281jce.interfaces.ECPointEncoder;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCECPrivateKey implements ECPrivateKey, org.bouncycastle.p281jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder, InterfaceC5484BCKey {
    static final long serialVersionUID = 994553197664784084L;
    private String algorithm;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;

    /* renamed from: baseKey */
    private transient ECPrivateKeyParameters f21470baseKey;
    private transient ProviderConfiguration configuration;

    /* renamed from: d */
    private transient BigInteger f21471d;

    /* renamed from: ecSpec */
    private transient ECParameterSpec f21472ecSpec;
    private transient byte[] encoding;
    private transient PrivateKeyInfo privateKeyInfo;
    private transient ASN1BitString publicKey;
    private boolean withCompression;

    public BCECPrivateKey() {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private static ECPrivateKeyParameters convertToBaseKey(BCECPrivateKey bCECPrivateKey) {
        String strM16266getName;
        org.bouncycastle.p281jce.p282spec.ECParameterSpec parameters = bCECPrivateKey.getParameters();
        if (parameters == null) {
            parameters = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        }
        return (!(bCECPrivateKey.getParameters() instanceof ECNamedCurveParameterSpec) || (strM16266getName = ((ECNamedCurveParameterSpec) bCECPrivateKey.getParameters()).m16266getName()) == null) ? new ECPrivateKeyParameters(bCECPrivateKey.mo16093getD(), new ECDomainParameters(parameters.getCurve(), parameters.m16269getG(), parameters.m16271getN(), parameters.m16270getH(), parameters.m16272getSeed())) : new ECPrivateKeyParameters(bCECPrivateKey.mo16093getD(), new ECNamedDomainParameters(ECNamedCurveTable.m14728getOID(strM16266getName), parameters.getCurve(), parameters.m16269getG(), parameters.m16271getN(), parameters.m16270getH(), parameters.m16272getSeed()));
    }

    private PrivateKeyInfo getPrivateKeyInfo() {
        if (this.privateKeyInfo == null) {
            X962Parameters domainParametersFromName = C5518ECUtils.getDomainParametersFromName(this.f21472ecSpec, this.withCompression);
            ECParameterSpec eCParameterSpec = this.f21472ecSpec;
            int orderBitLength = eCParameterSpec == null ? C5618ECUtil.getOrderBitLength(this.configuration, null, getS()) : C5618ECUtil.getOrderBitLength(this.configuration, eCParameterSpec.getOrder(), getS());
            try {
                this.privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, domainParametersFromName), this.publicKey != null ? new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), this.publicKey, domainParametersFromName) : new org.bouncycastle.p133asn1.p167sec.ECPrivateKey(orderBitLength, getS(), domainParametersFromName));
            } catch (IOException unused) {
                return null;
            }
        }
        return this.privateKeyInfo;
    }

    private ASN1BitString getPublicKeyDetails(BCECPublicKey bCECPublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCECPublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo privateKeyInfo) {
        X962Parameters x962Parameters = X962Parameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        this.f21472ecSpec = C5617EC5Util.convertToSpec(x962Parameters, C5617EC5Util.getCurve(this.configuration, x962Parameters));
        ASN1Encodable privateKey = privateKeyInfo.parsePrivateKey();
        if (privateKey instanceof ASN1Integer) {
            this.f21471d = ASN1Integer.getInstance(privateKey).getValue();
        } else {
            org.bouncycastle.p133asn1.p167sec.ECPrivateKey eCPrivateKey = org.bouncycastle.p133asn1.p167sec.ECPrivateKey.getInstance(privateKey);
            this.f21471d = eCPrivateKey.m14639getKey();
            this.publicKey = eCPrivateKey.getPublicKey();
        }
        this.f21470baseKey = convertToBaseKey(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        byte[] bArr = (byte[]) objectInputStream.readObject();
        this.configuration = BouncyCastleProvider.CONFIGURATION;
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPrivateKeyParameters engineGetKeyParameters() {
        return this.f21470baseKey;
    }

    public org.bouncycastle.p281jce.p282spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.f21472ecSpec;
        return eCParameterSpec != null ? C5617EC5Util.convertSpec(eCParameterSpec) : this.configuration.getEcImplicitlyCa();
    }

    /* renamed from: equals */
    public boolean m16097equals(Object obj) {
        if (obj instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) obj;
            PrivateKeyInfo privateKeyInfo = getPrivateKeyInfo();
            PrivateKeyInfo privateKeyInfo2 = eCPrivateKey instanceof BCECPrivateKey ? ((BCECPrivateKey) eCPrivateKey).getPrivateKeyInfo() : PrivateKeyInfo.getInstance(eCPrivateKey.getEncoded());
            if (privateKeyInfo != null && privateKeyInfo2 != null) {
                try {
                    return C6238Arrays.constantTimeAreEqual(getS().toByteArray(), eCPrivateKey.getS().toByteArray()) & C6238Arrays.constantTimeAreEqual(privateKeyInfo.getPrivateKeyAlgorithm().getEncoded(), privateKeyInfo2.getPrivateKeyAlgorithm().getEncoded());
                } catch (IOException unused) {
                }
            }
        }
        return false;
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
        return this.f21471d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.encoding == null) {
            PrivateKeyInfo privateKeyInfo = getPrivateKeyInfo();
            if (privateKeyInfo == null) {
                return null;
            }
            try {
                this.encoding = privateKeyInfo.getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException unused) {
                return null;
            }
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey
    public org.bouncycastle.p281jce.p282spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.f21472ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return C5617EC5Util.convertSpec(eCParameterSpec);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f21472ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f21471d;
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
        return C5618ECUtil.privateKeyToString("EC", this.f21471d, engineGetSpec());
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = eCPrivateKeySpec.getS();
        this.f21472ecSpec = eCPrivateKeySpec.getParams();
        this.configuration = providerConfiguration;
        this.f21470baseKey = convertToBaseKey(this);
    }

    public BCECPrivateKey(String str, PrivateKeyInfo privateKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPrivKeyInfo(privateKeyInfo);
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = eCPrivateKeyParameters.m15727getD();
        this.configuration = providerConfiguration;
        this.f21470baseKey = eCPrivateKeyParameters;
        if (eCParameterSpec == null) {
            ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
            eCParameterSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        }
        this.f21472ecSpec = eCParameterSpec;
        this.publicKey = getPublicKeyDetails(bCECPublicKey);
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, org.bouncycastle.p281jce.p282spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = eCPrivateKeyParameters.m15727getD();
        this.configuration = providerConfiguration;
        this.f21470baseKey = eCPrivateKeyParameters;
        if (eCParameterSpec == null) {
            ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
            this.f21472ecSpec = new ECParameterSpec(C5617EC5Util.convertCurve(parameters.getCurve(), parameters.m15724getSeed()), C5617EC5Util.convertPoint(parameters.m15720getG()), parameters.m15723getN(), parameters.m15721getH().intValue());
        } else {
            this.f21472ecSpec = C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.m16272getSeed()), eCParameterSpec);
        }
        try {
            this.publicKey = getPublicKeyDetails(bCECPublicKey);
        } catch (Exception unused) {
            this.publicKey = null;
        }
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = eCPrivateKeyParameters.m15727getD();
        this.f21472ecSpec = null;
        this.configuration = providerConfiguration;
        this.f21470baseKey = eCPrivateKeyParameters;
    }

    public BCECPrivateKey(String str, BCECPrivateKey bCECPrivateKey) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = bCECPrivateKey.f21471d;
        this.f21472ecSpec = bCECPrivateKey.f21472ecSpec;
        this.withCompression = bCECPrivateKey.withCompression;
        this.attrCarrier = bCECPrivateKey.attrCarrier;
        this.publicKey = bCECPrivateKey.publicKey;
        this.configuration = bCECPrivateKey.configuration;
        this.f21470baseKey = bCECPrivateKey.f21470baseKey;
    }

    public BCECPrivateKey(String str, org.bouncycastle.p281jce.p282spec.ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithm = str;
        this.f21471d = eCPrivateKeySpec.m16273getD();
        this.f21472ecSpec = eCPrivateKeySpec.getParams() != null ? C5617EC5Util.convertSpec(C5617EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().m16272getSeed()), eCPrivateKeySpec.getParams()) : null;
        this.configuration = providerConfiguration;
        this.f21470baseKey = convertToBaseKey(this);
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21471d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f21472ecSpec = eCPrivateKey.getParams();
        this.configuration = providerConfiguration;
        this.f21470baseKey = convertToBaseKey(this);
    }
}
