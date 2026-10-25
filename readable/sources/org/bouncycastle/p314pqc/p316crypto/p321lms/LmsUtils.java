package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
class LmsUtils {
    public static void byteArray(byte[] bArr, int i, int i2, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14970update(bArr, i, i2);
    }

    public static int calculateStrength(LMSParameters lMSParameters) {
        if (lMSParameters == null) {
            throw new NullPointerException("lmsParameters cannot be null");
        }
        LMSigParameters lMSigParam = lMSParameters.getLMSigParam();
        return (1 << lMSigParam.m17653getH()) * lMSigParam.m17654getM();
    }

    /* renamed from: u16str */
    public static void m17658u16str(short s, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14969update((byte) (s >>> 8));
        interfaceC5277Digest.mo14969update((byte) s);
    }

    /* renamed from: u32str */
    public static void m17659u32str(int i, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14969update((byte) (i >>> 24));
        interfaceC5277Digest.mo14969update((byte) (i >>> 16));
        interfaceC5277Digest.mo14969update((byte) (i >>> 8));
        interfaceC5277Digest.mo14969update((byte) i);
    }

    public static void byteArray(byte[] bArr, InterfaceC5277Digest interfaceC5277Digest) {
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
    }
}
