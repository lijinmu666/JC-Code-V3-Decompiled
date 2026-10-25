package org.bouncycastle.p284math.p285ec.p291rfc7748;

import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5863Ed25519;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: org.bouncycastle.math.ec.rfc7748.X25519 */
/* loaded from: classes2.dex */
public abstract class AbstractC5860X25519 {

    /* renamed from: C_A */
    private static final int f22375C_A = 486662;

    /* renamed from: C_A24 */
    private static final int f22376C_A24 = 121666;
    public static final int POINT_SIZE = 32;
    public static final int SCALAR_SIZE = 32;

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X25519$F */
    public static class F extends X25519Field {
        private F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X25519$Friend */
    public static class Friend {
        private static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !C6238Arrays.areAllZeroes(bArr3, i3, 32);
    }

    public static void clampPrivateKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        bArr[0] = (byte) (bArr[0] & 248);
        byte b = (byte) (bArr[31] & ByteCompanionObject.MAX_VALUE);
        bArr[31] = b;
        bArr[31] = (byte) (b | 64);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = X25519Field.decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & (-8);
        int i3 = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = i3;
        iArr[7] = i3 | 1073741824;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
        clampPrivateKey(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] iArrM16794create = X25519Field.m16794create();
        int[] iArrM16794create2 = X25519Field.m16794create();
        X25519Field.m16789apm(iArr, iArr2, iArrM16794create, iArrM16794create2);
        X25519Field.m16814sqr(iArrM16794create, iArrM16794create);
        X25519Field.m16814sqr(iArrM16794create2, iArrM16794create2);
        X25519Field.m16809mul(iArrM16794create, iArrM16794create2, iArr);
        X25519Field.m16815sub(iArrM16794create, iArrM16794create2, iArrM16794create);
        X25519Field.m16808mul(iArrM16794create, f22376C_A24, iArr2);
        X25519Field.m16786add(iArr2, iArrM16794create2, iArr2);
        X25519Field.m16809mul(iArr2, iArrM16794create, iArr2);
    }

    public static void precompute() {
        AbstractC5863Ed25519.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[8];
        decodeScalar(bArr, i, iArr);
        int[] iArrM16794create = X25519Field.m16794create();
        X25519Field.decode255(bArr2, i2, iArrM16794create, 0);
        int[] iArrM16794create2 = X25519Field.m16794create();
        X25519Field.m16793copy(iArrM16794create, 0, iArrM16794create2, 0);
        int[] iArrM16794create3 = X25519Field.m16794create();
        iArrM16794create3[0] = 1;
        int[] iArrM16794create4 = X25519Field.m16794create();
        iArrM16794create4[0] = 1;
        int[] iArrM16794create5 = X25519Field.m16794create();
        int[] iArrM16794create6 = X25519Field.m16794create();
        int[] iArrM16794create7 = X25519Field.m16794create();
        int i4 = 254;
        int i5 = 1;
        while (true) {
            X25519Field.m16789apm(iArrM16794create4, iArrM16794create5, iArrM16794create6, iArrM16794create4);
            X25519Field.m16789apm(iArrM16794create2, iArrM16794create3, iArrM16794create5, iArrM16794create2);
            X25519Field.m16809mul(iArrM16794create6, iArrM16794create2, iArrM16794create6);
            X25519Field.m16809mul(iArrM16794create4, iArrM16794create5, iArrM16794create4);
            X25519Field.m16814sqr(iArrM16794create5, iArrM16794create5);
            X25519Field.m16814sqr(iArrM16794create2, iArrM16794create2);
            X25519Field.m16815sub(iArrM16794create5, iArrM16794create2, iArrM16794create7);
            X25519Field.m16808mul(iArrM16794create7, f22376C_A24, iArrM16794create3);
            X25519Field.m16786add(iArrM16794create3, iArrM16794create2, iArrM16794create3);
            X25519Field.m16809mul(iArrM16794create3, iArrM16794create7, iArrM16794create3);
            X25519Field.m16809mul(iArrM16794create2, iArrM16794create5, iArrM16794create2);
            X25519Field.m16789apm(iArrM16794create6, iArrM16794create4, iArrM16794create4, iArrM16794create5);
            X25519Field.m16814sqr(iArrM16794create4, iArrM16794create4);
            X25519Field.m16814sqr(iArrM16794create5, iArrM16794create5);
            X25519Field.m16809mul(iArrM16794create5, iArrM16794create, iArrM16794create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            X25519Field.m16795cswap(i7, iArrM16794create2, iArrM16794create4);
            X25519Field.m16795cswap(i7, iArrM16794create3, iArrM16794create5);
            if (i4 < 3) {
                break;
            } else {
                i5 = i6;
            }
        }
        for (int i8 = 0; i8 < 3; i8++) {
            pointDouble(iArrM16794create2, iArrM16794create3);
        }
        X25519Field.m16804inv(iArrM16794create3, iArrM16794create3);
        X25519Field.m16809mul(iArrM16794create2, iArrM16794create3, iArrM16794create2);
        X25519Field.normalize(iArrM16794create2);
        X25519Field.m16802encode(iArrM16794create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArrM16794create = X25519Field.m16794create();
        int[] iArrM16794create2 = X25519Field.m16794create();
        AbstractC5863Ed25519.scalarMultBaseYZ(Friend.INSTANCE, bArr, i, iArrM16794create, iArrM16794create2);
        X25519Field.m16789apm(iArrM16794create2, iArrM16794create, iArrM16794create, iArrM16794create2);
        X25519Field.m16804inv(iArrM16794create2, iArrM16794create2);
        X25519Field.m16809mul(iArrM16794create, iArrM16794create2, iArrM16794create);
        X25519Field.normalize(iArrM16794create);
        X25519Field.m16802encode(iArrM16794create, bArr2, i2);
    }
}
