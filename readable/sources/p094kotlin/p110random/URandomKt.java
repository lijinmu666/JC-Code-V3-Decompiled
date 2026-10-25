package p094kotlin.p110random;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.UByteArray;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.UIntRange;
import p094kotlin.p112ranges.ULongRange;

@Metadata(m4987d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0012\u001a+\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0015\u0010\u0016\u001a)\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0017H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0018\u001a3\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001f¢\u0006\u0002\u0010#\u001aG\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"H\u0087\u0080\bb\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eb\u0002\b\u001fb\u0002\b ¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u00020)2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0011H\u0080\u0080\u0004¢\u0006\u0004\b-\u0010.¨\u0006/"}, m4988d2 = {"nextUInt", "Lkotlin/UInt;", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)I", "Lkotlin/SinceKotlin;", "version", "1.5", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lkotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/IgnorableReturnValue;", "size", BuildConfig.f24315FLAVOR, "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", BuildConfig.f24315FLAVOR, "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1#2:150\n*E\n"})
/* loaded from: classes.dex */
public final class URandomKt {
    /* renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m19735checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (Integer.compareUnsigned(i2, i) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(C1128UInt.m18635boximpl(i), C1128UInt.m18635boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m19736checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (Long.compareUnsigned(j2, j) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(C1130ULong.m18714boximpl(j), C1130ULong.m18714boximpl(j2)).toString());
        }
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(AbstractC1241Random abstractC1241Random, int i) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        return UByteArray.m18617constructorimpl(abstractC1241Random.nextBytes(i));
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @IgnorableReturnValue
    /* renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m19737nextUBytesEVgfTAA(AbstractC1241Random nextUBytes, byte[] array) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(m5061version = "1.3")
    @ExperimentalUnsignedTypes
    @IgnorableReturnValue
    /* renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m19738nextUBytesWvrt4B4(AbstractC1241Random nextUBytes, byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m19739nextUBytesWvrt4B4$default(AbstractC1241Random abstractC1241Random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m18623getSizeimpl(bArr);
        }
        return m19738nextUBytesWvrt4B4(abstractC1241Random, bArr, i, i2);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final int nextUInt(AbstractC1241Random abstractC1241Random) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        return C1128UInt.m18641constructorimpl(abstractC1241Random.mo6435nextInt());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m19740nextUInta8DCA5k(AbstractC1241Random nextUInt, int i, int i2) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m19735checkUIntRangeBoundsJ1ME1BU(i, i2);
        return C1128UInt.m18641constructorimpl(nextUInt.mo6438nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m19741nextUIntqCasIEU(AbstractC1241Random nextUInt, int i) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m19740nextUInta8DCA5k(nextUInt, 0, i);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final long nextULong(AbstractC1241Random abstractC1241Random) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        return C1130ULong.m18720constructorimpl(abstractC1241Random.nextLong());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m19742nextULongV1Xi4fY(AbstractC1241Random nextULong, long j) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m19743nextULongjmpaWc(nextULong, 0L, j);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m19743nextULongjmpaWc(AbstractC1241Random nextULong, long j, long j2) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m19736checkULongRangeBoundseb3DHEI(j, j2);
        return C1130ULong.m18720constructorimpl(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final int nextUInt(AbstractC1241Random abstractC1241Random, UIntRange range) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.mo6445isEmpty()) {
            return Integer.compareUnsigned(range.getLast(), -1) < 0 ? m19740nextUInta8DCA5k(abstractC1241Random, range.getFirst(), C1128UInt.m18641constructorimpl(range.getLast() + 1)) : Integer.compareUnsigned(range.getFirst(), 0) > 0 ? C1128UInt.m18641constructorimpl(m19740nextUInta8DCA5k(abstractC1241Random, C1128UInt.m18641constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(abstractC1241Random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final long nextULong(AbstractC1241Random abstractC1241Random, ULongRange range) {
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.mo6445isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Long.compareUnsigned(range.getLast(), -1L) < 0) {
            return m19743nextULongjmpaWc(abstractC1241Random, range.getFirst(), C1130ULong.m18720constructorimpl(range.getLast() + C1130ULong.m18720constructorimpl(1 & BodyPartID.bodyIdMax)));
        }
        if (Long.compareUnsigned(range.getFirst(), 0L) <= 0) {
            return nextULong(abstractC1241Random);
        }
        long jM19753getFirstsVKNKU = range.getFirst();
        long j = 1 & BodyPartID.bodyIdMax;
        return C1130ULong.m18720constructorimpl(m19743nextULongjmpaWc(abstractC1241Random, C1130ULong.m18720constructorimpl(jM19753getFirstsVKNKU - C1130ULong.m18720constructorimpl(j)), range.getLast()) + C1130ULong.m18720constructorimpl(j));
    }
}
