package com.p038google.p061crypto.p062tink.p067hybrid.p068subtle;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;

/* loaded from: classes.dex */
public class AeadOrDaead {

    /* renamed from: aead */
    private final InterfaceC0305Aead f3094aead;
    private final DeterministicAead deterministicAead;

    public AeadOrDaead(InterfaceC0305Aead interfaceC0305Aead) {
        this.f3094aead = interfaceC0305Aead;
        this.deterministicAead = null;
    }

    /* renamed from: decrypt */
    public byte[] m3466decrypt(byte[] bArr, byte[] bArr2) {
        InterfaceC0305Aead interfaceC0305Aead = this.f3094aead;
        return interfaceC0305Aead != null ? interfaceC0305Aead.mo3322decrypt(bArr, bArr2) : this.deterministicAead.decryptDeterministically(bArr, bArr2);
    }

    /* renamed from: encrypt */
    public byte[] m3467encrypt(byte[] bArr, byte[] bArr2) {
        InterfaceC0305Aead interfaceC0305Aead = this.f3094aead;
        return interfaceC0305Aead != null ? interfaceC0305Aead.mo3323encrypt(bArr, bArr2) : this.deterministicAead.encryptDeterministically(bArr, bArr2);
    }

    public AeadOrDaead(DeterministicAead deterministicAead) {
        this.f3094aead = null;
        this.deterministicAead = deterministicAead;
    }
}
