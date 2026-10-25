package org.bouncycastle.p281jce.p282spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.GOST3410NamedParameters;
import org.bouncycastle.p133asn1.cryptopro.GOST3410ParamSetParameters;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p281jce.interfaces.GOST3410Params;

/* loaded from: classes2.dex */
public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    private String digestParamSetOID;
    private String encryptionParamSetOID;
    private String keyParamSetOID;
    private GOST3410PublicKeyParameterSetSpec keyParameters;

    public GOST3410ParameterSpec(String str) {
        this(str, CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.m14433getId(), null);
    }

    public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters) {
        return gOST3410PublicKeyAlgParameters.getEncryptionParamSet() != null ? new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().m14433getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().m14433getId(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet().m14433getId()) : gOST3410PublicKeyAlgParameters.getDigestParamSet() != null ? new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().m14433getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().m14433getId()) : new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().m14433getId(), null);
    }

    /* renamed from: equals */
    public boolean m16279equals(Object obj) {
        if (!(obj instanceof GOST3410ParameterSpec)) {
            return false;
        }
        GOST3410ParameterSpec gOST3410ParameterSpec = (GOST3410ParameterSpec) obj;
        if (!this.keyParameters.m16284equals(gOST3410ParameterSpec.keyParameters)) {
            return false;
        }
        String str = this.digestParamSetOID;
        String str2 = gOST3410ParameterSpec.digestParamSetOID;
        if (str != str2 && (str == null || !str.equals(str2))) {
            return false;
        }
        String str3 = this.encryptionParamSetOID;
        String str4 = gOST3410ParameterSpec.encryptionParamSetOID;
        return str3 == str4 || (str3 != null && str3.equals(str4));
    }

    @Override // org.bouncycastle.p281jce.interfaces.GOST3410Params
    public String getDigestParamSetOID() {
        return this.digestParamSetOID;
    }

    @Override // org.bouncycastle.p281jce.interfaces.GOST3410Params
    public String getEncryptionParamSetOID() {
        return this.encryptionParamSetOID;
    }

    @Override // org.bouncycastle.p281jce.interfaces.GOST3410Params
    public String getPublicKeyParamSetOID() {
        return this.keyParamSetOID;
    }

    @Override // org.bouncycastle.p281jce.interfaces.GOST3410Params
    public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters() {
        return this.keyParameters;
    }

    public int hashCode() {
        int iHashCode = this.keyParameters.hashCode() ^ this.digestParamSetOID.hashCode();
        String str = this.encryptionParamSetOID;
        return (str != null ? str.hashCode() : 0) ^ iHashCode;
    }

    public GOST3410ParameterSpec(String str, String str2) {
        this(str, str2, null);
    }

    public GOST3410ParameterSpec(String str, String str2, String str3) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
        if (aSN1ObjectIdentifierTryFromID == null && (aSN1ObjectIdentifierTryFromID = GOST3410NamedParameters.m14576getOID(str)) != null) {
            str = aSN1ObjectIdentifierTryFromID.m14433getId();
        }
        GOST3410ParamSetParameters byOID = aSN1ObjectIdentifierTryFromID != null ? GOST3410NamedParameters.getByOID(aSN1ObjectIdentifierTryFromID) : null;
        if (byOID == null) {
            throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
        }
        this.keyParameters = new GOST3410PublicKeyParameterSetSpec(byOID.m14578getP(), byOID.m14579getQ(), byOID.m14577getA());
        this.keyParamSetOID = str;
        this.digestParamSetOID = str2;
        this.encryptionParamSetOID = str3;
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec) {
        this.keyParameters = gOST3410PublicKeyParameterSetSpec;
        this.digestParamSetOID = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.m14433getId();
        this.encryptionParamSetOID = null;
    }
}
