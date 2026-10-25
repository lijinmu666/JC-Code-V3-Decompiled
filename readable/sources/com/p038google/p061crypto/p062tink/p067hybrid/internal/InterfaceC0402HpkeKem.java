package com.p038google.p061crypto.p062tink.p067hybrid.internal;

/* renamed from: com.google.crypto.tink.hybrid.internal.HpkeKem */
/* loaded from: classes.dex */
interface InterfaceC0402HpkeKem {
    byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey);

    HpkeKemEncapOutput encapsulate(byte[] bArr);

    byte[] getKemId();
}
