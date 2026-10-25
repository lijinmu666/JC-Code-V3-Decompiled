package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.IntrinsicConstEvaluation;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.UIntRange;
import p094kotlin.p112ranges.URangesKt;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000fJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b \u0010\u000fJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000fJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000fJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000fJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000fJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u0010¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bP\u0010<J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bR\u0010<J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bT\u0010<J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020XH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\\\u0010\u0005J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\be\u0010ZJ\u0019\u0010f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bg\u0010\u0005J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, m4988d2 = {"Lkotlin/UShort;", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "constructor-impl", "(S)S", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", BuildConfig.f24315FLAVOR, "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/internal/InlineOnly;", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", BuildConfig.f24315FLAVOR, "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", BuildConfig.f24315FLAVOR, "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", BuildConfig.f24315FLAVOR, "toFloat-impl", "(S)F", "toDouble", BuildConfig.f24315FLAVOR, "toDouble-impl", "(S)D", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(S)Ljava/lang/String;", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
/* renamed from: kotlin.UShort */
/* loaded from: classes.dex */
public final class C1132UShort implements Comparable<C1132UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ C1132UShort(short s) {
        this.data = s;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m18820andxj2QHRw(short s, short s2) {
        return m18827constructorimpl((short) (s & s2));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1132UShort m18821boximpl(short s) {
        return new C1132UShort(s);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m18822compareTo7apg3OU(short s, byte b) {
        return Intrinsics.m6319compare(s & 65535, b & C1126UByte.MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m18823compareToVKZWuLQ(short s, long j) {
        return Long.compareUnsigned(C1130ULong.m18720constructorimpl(s & 65535), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m18824compareToWZ4Q5Ns(short s, int i) {
        return Integer.compareUnsigned(C1128UInt.m18641constructorimpl(s & 65535), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m18825compareToxj2QHRw(short s) {
        return Intrinsics.m6319compare(getData() & 65535, s & 65535);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m18827constructorimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m18828decMh2AYeg(short s) {
        return m18827constructorimpl((short) (s - 1));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m18829div7apg3OU(short s, byte b) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m18830divVKZWuLQ(short s, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(s & 65535), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m18831divWZ4Q5Ns(short s, int i) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m18832divxj2QHRw(short s, short s2) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18833equalsimpl(short s, Object obj) {
        return (obj instanceof C1132UShort) && s == ((C1132UShort) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18834equalsimpl0(short s, short s2) {
        return s == s2;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m18835floorDiv7apg3OU(short s, byte b) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m18836floorDivVKZWuLQ(short s, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(s & 65535), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m18837floorDivWZ4Q5Ns(short s, int i) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m18838floorDivxj2QHRw(short s, short s2) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m18839hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    @InlineOnly
    /* renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m18840incMh2AYeg(short s) {
        return m18827constructorimpl((short) (s + 1));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m18841invMh2AYeg(short s) {
        return m18827constructorimpl((short) (~s));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m18842minus7apg3OU(short s, byte b) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) - C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m18843minusVKZWuLQ(short s, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(s & 65535) - j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18844minusWZ4Q5Ns(short s, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) - i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m18845minusxj2QHRw(short s, short s2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) - C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m18846mod7apg3OU(short s, byte b) {
        return C1126UByte.m18564constructorimpl((byte) Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m18847modVKZWuLQ(short s, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(s & 65535), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m18848modWZ4Q5Ns(short s, int i) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m18849modxj2QHRw(short s, short s2) {
        return m18827constructorimpl((short) Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m18850orxj2QHRw(short s, short s2) {
        return m18827constructorimpl((short) (s | s2));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m18851plus7apg3OU(short s, byte b) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) + C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m18852plusVKZWuLQ(short s, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(s & 65535) + j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18853plusWZ4Q5Ns(short s, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) + i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m18854plusxj2QHRw(short s, short s2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) + C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m18855rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535), null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m18856rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m19789untilJ1ME1BU(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m18857rem7apg3OU(short s, byte b) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m18858remVKZWuLQ(short s, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(s & 65535), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m18859remWZ4Q5Ns(short s, int i) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m18860remxj2QHRw(short s, short s2) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m18861times7apg3OU(short s, byte b) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) * C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m18862timesVKZWuLQ(short s, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(s & 65535) * j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m18863timesWZ4Q5Ns(short s, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) * i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m18864timesxj2QHRw(short s, short s2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(s & 65535) * C1128UInt.m18641constructorimpl(s2 & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m18865toByteimpl(short s) {
        return (byte) s;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m18866toDoubleimpl(short s) {
        return UnsignedKt.uintToDouble(s & 65535);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m18867toFloatimpl(short s) {
        return (float) UnsignedKt.uintToDouble(s & 65535);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m18868toIntimpl(short s) {
        return s & 65535;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m18869toLongimpl(short s) {
        return s & 65535;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m18870toShortimpl(short s) {
        return s;
    }

    @IntrinsicConstEvaluation
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m18871toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m18872toUBytew2LRezQ(short s) {
        return C1126UByte.m18564constructorimpl((byte) s);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m18873toUIntpVg5ArA(short s) {
        return C1128UInt.m18641constructorimpl(s & 65535);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m18874toULongsVKNKU(short s) {
        return C1130ULong.m18720constructorimpl(s & 65535);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m18875toUShortMh2AYeg(short s) {
        return s;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m18876xorxj2QHRw(short s, short s2) {
        return m18827constructorimpl((short) (s ^ s2));
    }

    @Override // java.lang.Comparable
    @IntrinsicConstEvaluation
    @InlineOnly
    public /* bridge */ /* synthetic */ int compareTo(C1132UShort c1132UShort) {
        return Intrinsics.m6319compare(getData() & 65535, c1132UShort.getData() & 65535);
    }

    /* renamed from: equals */
    public boolean m5101equals(Object other) {
        return m18833equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m18839hashCodeimpl(this.data);
    }

    @IntrinsicConstEvaluation
    public String toString() {
        return m18871toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m18826compareToxj2QHRw(short s, short s2) {
        return Intrinsics.m6319compare(s & 65535, s2 & 65535);
    }
}
