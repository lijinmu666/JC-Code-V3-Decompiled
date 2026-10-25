package com.p038google.p061crypto.p062tink.p067hybrid.internal;

/* loaded from: classes.dex */
interface HpkeAead {
    byte[] getAeadId();

    int getKeyLength();

    int getNonceLength();

    /* renamed from: open */
    byte[] mo3459open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* renamed from: seal */
    byte[] mo3460seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);
}
