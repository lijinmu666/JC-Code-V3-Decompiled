package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.p073proto.EnumC0629HpkeKem;
import com.p038google.p061crypto.p062tink.p073proto.HpkeParams;
import com.p038google.p061crypto.p062tink.p073proto.HpkePrivateKey;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class HpkeDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];

    /* renamed from: aead */
    private final HpkeAead f3080aead;
    private final int encapsulatedKeyLength;

    /* renamed from: kdf */
    private final InterfaceC0401HpkeKdf f3081kdf;

    /* renamed from: kem */
    private final InterfaceC0402HpkeKem f3082kem;
    private final HpkeKemPrivateKey recipientPrivateKey;

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeDecrypt$1 */
    public static /* synthetic */ class C04001 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[EnumC0629HpkeKem.m3660values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[EnumC0629HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private HpkeDecrypt(HpkeKemPrivateKey hpkeKemPrivateKey, InterfaceC0402HpkeKem interfaceC0402HpkeKem, InterfaceC0401HpkeKdf interfaceC0401HpkeKdf, HpkeAead hpkeAead, int i) {
        this.recipientPrivateKey = hpkeKemPrivateKey;
        this.f3082kem = interfaceC0402HpkeKem;
        this.f3081kdf = interfaceC0401HpkeKdf;
        this.f3080aead = hpkeAead;
        this.encapsulatedKeyLength = i;
    }

    public static HpkeDecrypt createHpkeDecrypt(HpkePrivateKey hpkePrivateKey) {
        if (!hpkePrivateKey.hasPublicKey()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!hpkePrivateKey.getPublicKey().hasParams()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (hpkePrivateKey.getPrivateKey().m3943isEmpty()) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        HpkeParams params = hpkePrivateKey.getPublicKey().getParams();
        return new HpkeDecrypt(HpkeKemKeyFactory.createPrivate(hpkePrivateKey), HpkePrimitiveFactory.createKem(params), HpkePrimitiveFactory.createKdf(params), HpkePrimitiveFactory.createAead(params), encodingSizeInBytes(params.mo3668getKem()));
    }

    private static int encodingSizeInBytes(EnumC0629HpkeKem enumC0629HpkeKem) {
        int i = C04001.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[enumC0629HpkeKem.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 65;
        }
        if (i == 3) {
            return 97;
        }
        if (i == 4) {
            return 133;
        }
        throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + enumC0629HpkeKem.name());
    }

    @Override // com.p038google.p061crypto.p062tink.HybridDecrypt
    /* renamed from: decrypt */
    public byte[] mo3330decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.encapsulatedKeyLength;
        if (length < i) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        return HpkeContext.createRecipientContext(bArrCopyOf, this.recipientPrivateKey, this.f3082kem, this.f3081kdf, this.f3080aead, bArr3).m3464open(Arrays.copyOfRange(bArr, this.encapsulatedKeyLength, bArr.length), EMPTY_ASSOCIATED_DATA);
    }
}
