package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;

/* loaded from: classes2.dex */
public class GOST3410ParameterSpec implements AlgorithmParameterSpec {
    private final ASN1ObjectIdentifier digestParamSet;
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410ParameterSpec(String str) {
        this(m16197getOid(str), getDigestOid(str), null);
    }

    private static ASN1ObjectIdentifier getDigestOid(String str) {
        return str.indexOf("12-512") > 0 ? RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512 : str.indexOf("12-256") > 0 ? RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256 : CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet;
    }

    /* renamed from: getOid */
    private static ASN1ObjectIdentifier m16197getOid(String str) {
        return ECGOST3410NamedCurves.m14571getOID(str);
    }

    public ASN1ObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public ASN1ObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    public String getPublicKeyParamSetName() {
        return ECGOST3410NamedCurves.m14570getName(getPublicKeyParamSet());
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this(aSN1ObjectIdentifier, aSN1ObjectIdentifier2, null);
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
        this.publicKeyParamSet = aSN1ObjectIdentifier;
        this.digestParamSet = aSN1ObjectIdentifier2;
        this.encryptionParamSet = aSN1ObjectIdentifier3;
    }
}
