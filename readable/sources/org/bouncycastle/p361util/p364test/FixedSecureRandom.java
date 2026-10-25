package org.bouncycastle.p361util.p364test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.encoders.C6255Hex;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class FixedSecureRandom extends SecureRandom {
    private static final boolean isAndroidStyle;
    private static final boolean isClasspathStyle;
    private static final boolean isRegularStyle;

    /* renamed from: _data */
    private byte[] f24261_data;

    /* renamed from: _index */
    private int f24262_index;

    /* renamed from: REGULAR */
    private static java.math.BigInteger f24260REGULAR = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);

    /* renamed from: ANDROID */
    private static java.math.BigInteger f24259ANDROID = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
    private static java.math.BigInteger CLASSPATH = new java.math.BigInteger("3020104ffffffff05060708111111", 16);

    public static class BigInteger extends C6259Source {
        public BigInteger(int i, String str) {
            super(FixedSecureRandom.expandToBitLength(i, C6255Hex.m18338decode(str)));
        }

        public BigInteger(int i, byte[] bArr) {
            super(FixedSecureRandom.expandToBitLength(i, bArr));
        }

        public BigInteger(String str) {
            this(C6255Hex.m18338decode(str));
        }

        public BigInteger(byte[] bArr) {
            super(bArr);
        }
    }

    /* renamed from: org.bouncycastle.util.test.FixedSecureRandom$Data */
    public static class C6258Data extends C6259Source {
        public C6258Data(byte[] bArr) {
            super(bArr);
        }
    }

    public static class DummyProvider extends Provider {
        public DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class RandomChecker extends SecureRandom {

        /* renamed from: data */
        byte[] f24263data;

        /* renamed from: index */
        int f24264index;

        public RandomChecker() {
            super(null, new DummyProvider());
            this.f24263data = C6255Hex.m18338decode("01020304ffffffff0506070811111111");
            this.f24264index = 0;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.f24263data, this.f24264index, bArr, 0, bArr.length);
            this.f24264index += bArr.length;
        }
    }

    /* renamed from: org.bouncycastle.util.test.FixedSecureRandom$Source */
    public static class C6259Source {

        /* renamed from: data */
        byte[] f24265data;

        public C6259Source(byte[] bArr) {
            this.f24265data = bArr;
        }
    }

    static {
        java.math.BigInteger bigInteger = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger bigInteger2 = new java.math.BigInteger(120, new RandomChecker());
        isAndroidStyle = bigInteger.equals(f24259ANDROID);
        isRegularStyle = bigInteger.equals(f24260REGULAR);
        isClasspathStyle = bigInteger2.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new C6259Source[]{new C6258Data(bArr)});
    }

    private static C6258Data[] buildDataArray(byte[][] bArr) {
        C6258Data[] c6258DataArr = new C6258Data[bArr.length];
        for (int i = 0; i != bArr.length; i++) {
            c6258DataArr[i] = new C6258Data(bArr[i]);
        }
        return c6258DataArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] expandToBitLength(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4 = (i + 7) / 8;
        if (i4 <= bArr.length) {
            if (isAndroidStyle && i < bArr.length * 8 && (i2 = i % 8) != 0) {
                AbstractC6245Pack.intToBigEndian(AbstractC6245Pack.bigEndianToInt(bArr, 0) << (8 - i2), bArr, 0);
            }
            return bArr;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
        if (isAndroidStyle && (i3 = i % 8) != 0) {
            AbstractC6245Pack.intToBigEndian(AbstractC6245Pack.bigEndianToInt(bArr2, 0) << (8 - i3), bArr2, 0);
        }
        return bArr2;
    }

    private int nextValue() {
        byte[] bArr = this.f24261_data;
        int i = this.f24262_index;
        this.f24262_index = i + 1;
        return bArr[i] & C1126UByte.MAX_VALUE;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this.f24262_index == this.f24261_data.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this.f24261_data, this.f24262_index, bArr, 0, bArr.length);
        this.f24262_index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        return nextValue() | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8);
    }

    @Override // java.util.Random
    public long nextLong() {
        return (nextValue() << 56) | (nextValue() << 48) | (nextValue() << 40) | (nextValue() << 32) | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    public FixedSecureRandom(C6259Source[] c6259SourceArr) throws IOException {
        super(null, new DummyProvider());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        if (!isRegularStyle) {
            if (!isAndroidStyle) {
                throw new IllegalStateException("Unrecognized BigInteger implementation");
            }
            for (int i2 = 0; i2 != c6259SourceArr.length; i2++) {
                try {
                    C6259Source c6259Source = c6259SourceArr[i2];
                    if (c6259Source instanceof BigInteger) {
                        byte[] bArr = c6259Source.f24265data;
                        int length = bArr.length - (bArr.length % 4);
                        int i3 = 0;
                        while (i3 < length) {
                            i3 += 4;
                            byteArrayOutputStream.write(bArr, bArr.length - i3, 4);
                        }
                        if (bArr.length - length != 0) {
                            for (int i4 = 0; i4 != 4 - (bArr.length - length); i4++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i5 = 0; i5 != bArr.length - length; i5++) {
                            byteArrayOutputStream.write(bArr[length + i5]);
                        }
                    } else {
                        byteArrayOutputStream.write(c6259Source.f24265data);
                    }
                } catch (IOException unused) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else if (isClasspathStyle) {
            while (i != c6259SourceArr.length) {
                try {
                    C6259Source c6259Source2 = c6259SourceArr[i];
                    if (c6259Source2 instanceof BigInteger) {
                        byte[] bArr2 = c6259Source2.f24265data;
                        int length2 = bArr2.length - (bArr2.length % 4);
                        for (int length3 = (bArr2.length - length2) - 1; length3 >= 0; length3--) {
                            byteArrayOutputStream.write(bArr2[length3]);
                        }
                        for (int length4 = bArr2.length - length2; length4 < bArr2.length; length4 += 4) {
                            byteArrayOutputStream.write(bArr2, length4, 4);
                        }
                    } else {
                        byteArrayOutputStream.write(c6259Source2.f24265data);
                    }
                    i++;
                } catch (IOException unused2) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            while (i != c6259SourceArr.length) {
                try {
                    byteArrayOutputStream.write(c6259SourceArr[i].f24265data);
                    i++;
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        }
        this.f24261_data = byteArrayOutputStream.toByteArray();
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(buildDataArray(bArr));
    }
}
