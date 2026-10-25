package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.InterfaceC5795PBE;

/* loaded from: classes2.dex */
public class PBESecretKeyFactory extends BaseSecretKeyFactory implements InterfaceC5795PBE {

    /* renamed from: digest */
    private int f21899digest;
    private boolean forCipher;

    /* renamed from: ivSize */
    private int f21900ivSize;

    /* renamed from: keySize */
    private int f21901keySize;

    /* renamed from: scheme */
    private int f21902scheme;

    public PBESecretKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
        super(str, aSN1ObjectIdentifier);
        this.forCipher = z;
        this.f21902scheme = i;
        this.f21899digest = i2;
        this.f21901keySize = i3;
        this.f21900ivSize = i4;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PBEKeySpec)) {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
        PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
        if (pBEKeySpec.getSalt() == null) {
            return new BCPBEKey(this.f21871algName, this.f21872algOid, this.f21902scheme, this.f21899digest, this.f21901keySize, this.f21900ivSize, pBEKeySpec, null);
        }
        return new BCPBEKey(this.f21871algName, this.f21872algOid, this.f21902scheme, this.f21899digest, this.f21901keySize, this.f21900ivSize, pBEKeySpec, this.forCipher ? InterfaceC5795PBE.Util.makePBEParameters(pBEKeySpec, this.f21902scheme, this.f21899digest, this.f21901keySize, this.f21900ivSize) : InterfaceC5795PBE.Util.makePBEMacParameters(pBEKeySpec, this.f21902scheme, this.f21899digest, this.f21901keySize));
    }
}
