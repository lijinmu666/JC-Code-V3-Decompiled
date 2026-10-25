package com.p038google.p061crypto.p062tink.p067hybrid.internal;

/* renamed from: com.google.crypto.tink.hybrid.internal.HpkeKdf */
/* loaded from: classes.dex */
interface InterfaceC0401HpkeKdf {
    byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i);

    byte[] getKdfId();

    byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i);

    byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3);
}
