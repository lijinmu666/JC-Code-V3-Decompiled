package org.bouncycastle.p194crypto.p207kems.p208mlkem;

/* renamed from: org.bouncycastle.crypto.kems.mlkem.Reduce */
/* loaded from: classes2.dex */
class C5357Reduce {
    public static short barrettReduce(short s) {
        return (short) (s - ((short) (((short) ((s * 20159) >> 26)) * 3329)));
    }

    public static int checkModulus(short s) {
        return s - 3329;
    }

    public static short condSubQ(short s) {
        short s2 = (short) (s - 3329);
        return (short) (s2 + ((s2 >> 15) & 3329));
    }

    public static short montgomeryReduce(int i) {
        return (short) ((i - (((short) (62209 * i)) * 3329)) >> 16);
    }
}
