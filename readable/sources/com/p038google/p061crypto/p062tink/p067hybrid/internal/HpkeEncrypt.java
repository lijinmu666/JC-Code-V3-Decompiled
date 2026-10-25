package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.p073proto.HpkeParams;
import com.p038google.p061crypto.p062tink.p073proto.HpkePublicKey;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;

/* loaded from: classes.dex */
final class HpkeEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_ASSOCIATED_DATA = new byte[0];

    /* renamed from: aead */
    private final HpkeAead f3083aead;

    /* renamed from: kdf */
    private final InterfaceC0401HpkeKdf f3084kdf;

    /* renamed from: kem */
    private final InterfaceC0402HpkeKem f3085kem;
    private final HpkePublicKey recipientPublicKey;

    private HpkeEncrypt(HpkePublicKey hpkePublicKey, InterfaceC0402HpkeKem interfaceC0402HpkeKem, InterfaceC0401HpkeKdf interfaceC0401HpkeKdf, HpkeAead hpkeAead) {
        this.recipientPublicKey = hpkePublicKey;
        this.f3085kem = interfaceC0402HpkeKem;
        this.f3084kdf = interfaceC0401HpkeKdf;
        this.f3083aead = hpkeAead;
    }

    public static HpkeEncrypt createHpkeEncrypt(HpkePublicKey hpkePublicKey) {
        if (hpkePublicKey.getPublicKey().m3943isEmpty()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        HpkeParams params = hpkePublicKey.getParams();
        return new HpkeEncrypt(hpkePublicKey, HpkePrimitiveFactory.createKem(params), HpkePrimitiveFactory.createKdf(params), HpkePrimitiveFactory.createAead(params));
    }

    @Override // com.p038google.p061crypto.p062tink.HybridEncrypt
    /* renamed from: encrypt */
    public byte[] mo3331encrypt(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        HpkeContext hpkeContextCreateSenderContext = HpkeContext.createSenderContext(this.recipientPublicKey, this.f3085kem, this.f3084kdf, this.f3083aead, bArr2);
        return C0853Bytes.m4229concat(hpkeContextCreateSenderContext.getEncapsulatedKey(), hpkeContextCreateSenderContext.m3465seal(bArr, EMPTY_ASSOCIATED_DATA));
    }
}
