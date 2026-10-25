package p094kotlin.p110random;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.PlatformImplementationsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦\u0080\u0004J\n\u0010\u0007\u001a\u00020\u0005H\u0096\u0080\u0004J\u0012\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0096\u0080\u0004J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0096\u0080\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0097\u0080\bb\u0002\b\u0017J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0097\u0080\bb\u0002\b\u0017J\u0012\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0096\u0080\u0004Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d¨\u0006\u001a"}, m4988d2 = {"Lkotlin/random/Random;", BuildConfig.f24315FLAVOR, "<init>", "()V", "nextBits", BuildConfig.f24315FLAVOR, "bitCount", "nextInt", "until", "from", "nextLong", BuildConfig.f24315FLAVOR, "nextBoolean", BuildConfig.f24315FLAVOR, "nextDouble", BuildConfig.f24315FLAVOR, "nextFloat", BuildConfig.f24315FLAVOR, "nextBytes", BuildConfig.f24315FLAVOR, "array", "fromIndex", "toIndex", "Lkotlin/IgnorableReturnValue;", "size", "Default", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,392:1\n1#2:393\n*E\n"})
/* renamed from: kotlin.random.Random */
/* loaded from: classes.dex */
public abstract class AbstractC1241Random {

    /* renamed from: Default, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AbstractC1241Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    @Metadata(m4987d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001$B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u00020\bH\u0082\u0080\u0004J\u001b\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0082\u0080\u0004¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0010H\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0096\u0080\u0004J\u001a\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0016H\u0096\u0080\u0004J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u001aH\u0096\u0080\u0004J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0097\u0080\bb\u0002\b J\u0012\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0010H\u0096\u0080\u0004J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0096\u0080\bR\u000f\u0010\u0006\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006%"}, m4988d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "defaultRandom", "writeReplace", BuildConfig.f24315FLAVOR, "readObject", BuildConfig.f24315FLAVOR, "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "nextBits", BuildConfig.f24315FLAVOR, "bitCount", "nextInt", "until", "from", "nextLong", BuildConfig.f24315FLAVOR, "nextBoolean", BuildConfig.f24315FLAVOR, "nextDouble", BuildConfig.f24315FLAVOR, "nextFloat", BuildConfig.f24315FLAVOR, "nextBytes", BuildConfig.f24315FLAVOR, "array", "Lkotlin/IgnorableReturnValue;", "size", "fromIndex", "toIndex", "Serialized", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.random.Random$Default, reason: from kotlin metadata */
    public static final class Companion extends AbstractC1241Random implements Serializable {

        @Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u00020\bH\u0082\u0080\u0004R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, m4988d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", BuildConfig.f24315FLAVOR, "readResolve", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        /* renamed from: kotlin.random.Random$Default$Serialized */
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return AbstractC1241Random.INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public int nextBits(int bitCount) {
            return AbstractC1241Random.defaultRandom.nextBits(bitCount);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public boolean nextBoolean() {
            return AbstractC1241Random.defaultRandom.nextBoolean();
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        @IgnorableReturnValue
        public byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return AbstractC1241Random.defaultRandom.nextBytes(array);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public double nextDouble() {
            return AbstractC1241Random.defaultRandom.nextDouble();
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public float nextFloat() {
            return AbstractC1241Random.defaultRandom.nextFloat();
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        /* renamed from: nextInt */
        public int mo6435nextInt() {
            return AbstractC1241Random.defaultRandom.mo6435nextInt();
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public long nextLong() {
            return AbstractC1241Random.defaultRandom.nextLong();
        }

        private Companion() {
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public byte[] nextBytes(int size) {
            return AbstractC1241Random.defaultRandom.nextBytes(size);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public double nextDouble(double until) {
            return AbstractC1241Random.defaultRandom.nextDouble(until);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        /* renamed from: nextInt */
        public int mo6436nextInt(int until) {
            return AbstractC1241Random.defaultRandom.mo6436nextInt(until);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public long nextLong(long until) {
            return AbstractC1241Random.defaultRandom.nextLong(until);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
            Intrinsics.checkNotNullParameter(array, "array");
            return AbstractC1241Random.defaultRandom.nextBytes(array, fromIndex, toIndex);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public double nextDouble(double from, double until) {
            return AbstractC1241Random.defaultRandom.nextDouble(from, until);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        /* renamed from: nextInt */
        public int mo6438nextInt(int from, int until) {
            return AbstractC1241Random.defaultRandom.mo6438nextInt(from, until);
        }

        @Override // p094kotlin.p110random.AbstractC1241Random
        public long nextLong(long from, long until) {
            return AbstractC1241Random.defaultRandom.nextLong(from, until);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(AbstractC1241Random abstractC1241Random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return abstractC1241Random.nextBytes(bArr, i, i2);
    }

    public abstract int nextBits(int bitCount);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @IgnorableReturnValue
    public byte[] nextBytes(byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (fromIndex < 0 || fromIndex > array.length || toIndex < 0 || toIndex > array.length) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
        }
        int i = (toIndex - fromIndex) / 4;
        for (int i2 = 0; i2 < i; i2++) {
            int iMo6435nextInt = mo6435nextInt();
            array[fromIndex] = (byte) iMo6435nextInt;
            array[fromIndex + 1] = (byte) (iMo6435nextInt >>> 8);
            array[fromIndex + 2] = (byte) (iMo6435nextInt >>> 16);
            array[fromIndex + 3] = (byte) (iMo6435nextInt >>> 24);
            fromIndex += 4;
        }
        int i3 = toIndex - fromIndex;
        int iNextBits = nextBits(i3 * 8);
        for (int i4 = 0; i4 < i3; i4++) {
            array[fromIndex + i4] = (byte) (iNextBits >>> (i4 * 8));
        }
        return array;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    /* renamed from: nextInt */
    public int mo6435nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (mo6435nextInt() << 32) + mo6435nextInt();
    }

    public double nextDouble(double until) {
        return nextDouble(0.0d, until);
    }

    /* renamed from: nextInt */
    public int mo6436nextInt(int until) {
        return mo6438nextInt(0, until);
    }

    public long nextLong(long until) {
        return nextLong(0L, until);
    }

    public double nextDouble(double from, double until) {
        double dNextDouble;
        RandomKt.checkRangeBounds(from, until);
        double d = until - from;
        if (Double.isInfinite(d) && Math.abs(from) <= Double.MAX_VALUE && Math.abs(until) <= Double.MAX_VALUE) {
            double d2 = 2;
            double dNextDouble2 = nextDouble() * ((until / d2) - (from / d2));
            dNextDouble = from + dNextDouble2 + dNextDouble2;
        } else {
            dNextDouble = from + (nextDouble() * d);
        }
        return dNextDouble >= until ? Math.nextAfter(until, Double.NEGATIVE_INFINITY) : dNextDouble;
    }

    /* renamed from: nextInt */
    public int mo6438nextInt(int from, int until) {
        int iMo6435nextInt;
        int i;
        int iNextBits;
        RandomKt.checkRangeBounds(from, until);
        int i2 = until - from;
        if (i2 > 0 || i2 == Integer.MIN_VALUE) {
            if (((-i2) & i2) == i2) {
                iNextBits = nextBits(RandomKt.fastLog2(i2));
            } else {
                do {
                    iMo6435nextInt = mo6435nextInt() >>> 1;
                    i = iMo6435nextInt % i2;
                } while ((iMo6435nextInt - i) + (i2 - 1) < 0);
                iNextBits = i;
            }
            return from + iNextBits;
        }
        while (true) {
            int iMo6435nextInt2 = mo6435nextInt();
            if (from <= iMo6435nextInt2 && iMo6435nextInt2 < until) {
                return iMo6435nextInt2;
            }
        }
    }

    public long nextLong(long from, long until) {
        long jNextLong;
        long j;
        long jNextBits;
        int iMo6435nextInt;
        RandomKt.checkRangeBounds(from, until);
        long j2 = until - from;
        if (j2 > 0) {
            if (((-j2) & j2) == j2) {
                int i = (int) j2;
                int i2 = (int) (j2 >>> 32);
                if (i != 0) {
                    iMo6435nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i2 == 1) {
                    iMo6435nextInt = mo6435nextInt();
                } else {
                    jNextBits = (nextBits(RandomKt.fastLog2(i2)) << 32) + (mo6435nextInt() & BodyPartID.bodyIdMax);
                }
                jNextBits = iMo6435nextInt & BodyPartID.bodyIdMax;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j = jNextLong % j2;
                } while ((jNextLong - j) + (j2 - 1) < 0);
                jNextBits = j;
            }
            return from + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (from <= jNextLong2 && jNextLong2 < until) {
                return jNextLong2;
            }
        }
    }

    @IgnorableReturnValue
    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int size) {
        return nextBytes(new byte[size]);
    }
}
