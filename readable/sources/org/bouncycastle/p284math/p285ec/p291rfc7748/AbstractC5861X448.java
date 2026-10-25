package org.bouncycastle.p284math.p285ec.p291rfc7748;

import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5864Ed448;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: org.bouncycastle.math.ec.rfc7748.X448 */
/* loaded from: classes2.dex */
public abstract class AbstractC5861X448 {

    /* renamed from: C_A */
    private static final int f22382C_A = 156326;

    /* renamed from: C_A24 */
    private static final int f22383C_A24 = 39082;
    public static final int POINT_SIZE = 56;
    public static final int SCALAR_SIZE = 56;

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X448$F */
    public static class F extends X448Field {
        private F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc7748.X448$Friend */
    public static class Friend {
        private static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !C6238Arrays.areAllZeroes(bArr3, i3, 56);
    }

    public static void clampPrivateKey(byte[] bArr) {
        if (bArr.length != 56) {
            throw new IllegalArgumentException("k");
        }
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | ByteCompanionObject.MIN_VALUE);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 14; i2++) {
            iArr[i2] = X448Field.decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & (-4);
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        if (bArr.length != 56) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
        clampPrivateKey(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] iArrM16825create = X448Field.m16825create();
        int[] iArrM16825create2 = X448Field.m16825create();
        X448Field.m16818add(iArr, iArr2, iArrM16825create);
        X448Field.m16846sub(iArr, iArr2, iArrM16825create2);
        X448Field.m16845sqr(iArrM16825create, iArrM16825create);
        X448Field.m16845sqr(iArrM16825create2, iArrM16825create2);
        X448Field.m16840mul(iArrM16825create, iArrM16825create2, iArr);
        X448Field.m16846sub(iArrM16825create, iArrM16825create2, iArrM16825create);
        X448Field.m16839mul(iArrM16825create, f22383C_A24, iArr2);
        X448Field.m16818add(iArr2, iArrM16825create2, iArr2);
        X448Field.m16840mul(iArr2, iArrM16825create, iArr2);
    }

    public static void precompute() {
        AbstractC5864Ed448.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[14];
        decodeScalar(bArr, i, iArr);
        int[] iArrM16825create = X448Field.m16825create();
        X448Field.decode448(bArr2, i2, iArrM16825create, 0);
        int[] iArrM16825create2 = X448Field.m16825create();
        X448Field.m16824copy(iArrM16825create, 0, iArrM16825create2, 0);
        int[] iArrM16825create3 = X448Field.m16825create();
        iArrM16825create3[0] = 1;
        int[] iArrM16825create4 = X448Field.m16825create();
        iArrM16825create4[0] = 1;
        int[] iArrM16825create5 = X448Field.m16825create();
        int[] iArrM16825create6 = X448Field.m16825create();
        int[] iArrM16825create7 = X448Field.m16825create();
        int i4 = 447;
        int i5 = 1;
        while (true) {
            X448Field.m16818add(iArrM16825create4, iArrM16825create5, iArrM16825create6);
            X448Field.m16846sub(iArrM16825create4, iArrM16825create5, iArrM16825create4);
            X448Field.m16818add(iArrM16825create2, iArrM16825create3, iArrM16825create5);
            X448Field.m16846sub(iArrM16825create2, iArrM16825create3, iArrM16825create2);
            X448Field.m16840mul(iArrM16825create6, iArrM16825create2, iArrM16825create6);
            X448Field.m16840mul(iArrM16825create4, iArrM16825create5, iArrM16825create4);
            X448Field.m16845sqr(iArrM16825create5, iArrM16825create5);
            X448Field.m16845sqr(iArrM16825create2, iArrM16825create2);
            X448Field.m16846sub(iArrM16825create5, iArrM16825create2, iArrM16825create7);
            X448Field.m16839mul(iArrM16825create7, f22383C_A24, iArrM16825create3);
            X448Field.m16818add(iArrM16825create3, iArrM16825create2, iArrM16825create3);
            X448Field.m16840mul(iArrM16825create3, iArrM16825create7, iArrM16825create3);
            X448Field.m16840mul(iArrM16825create2, iArrM16825create5, iArrM16825create2);
            X448Field.m16846sub(iArrM16825create6, iArrM16825create4, iArrM16825create5);
            X448Field.m16818add(iArrM16825create6, iArrM16825create4, iArrM16825create4);
            X448Field.m16845sqr(iArrM16825create4, iArrM16825create4);
            X448Field.m16845sqr(iArrM16825create5, iArrM16825create5);
            X448Field.m16840mul(iArrM16825create5, iArrM16825create, iArrM16825create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            X448Field.m16826cswap(i7, iArrM16825create2, iArrM16825create4);
            X448Field.m16826cswap(i7, iArrM16825create3, iArrM16825create5);
            if (i4 < 2) {
                break;
            } else {
                i5 = i6;
            }
        }
        for (int i8 = 0; i8 < 2; i8++) {
            pointDouble(iArrM16825create2, iArrM16825create3);
        }
        X448Field.m16835inv(iArrM16825create3, iArrM16825create3);
        X448Field.m16840mul(iArrM16825create2, iArrM16825create3, iArrM16825create2);
        X448Field.normalize(iArrM16825create2);
        X448Field.m16833encode(iArrM16825create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArrM16825create = X448Field.m16825create();
        int[] iArrM16825create2 = X448Field.m16825create();
        AbstractC5864Ed448.scalarMultBaseXY(Friend.INSTANCE, bArr, i, iArrM16825create, iArrM16825create2);
        X448Field.m16835inv(iArrM16825create, iArrM16825create);
        X448Field.m16840mul(iArrM16825create, iArrM16825create2, iArrM16825create);
        X448Field.m16845sqr(iArrM16825create, iArrM16825create);
        X448Field.normalize(iArrM16825create);
        X448Field.m16833encode(iArrM16825create, bArr2, i2);
    }
}
