package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.IntrinsicConstEvaluation;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.UIntRange;
import p094kotlin.p112ranges.URangesKt;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000eJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u000eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u000f¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010:J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010:J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010:J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0005J\u0019\u0010Y\u001a\u00020ZH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b[\u0010\\J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\be\u0010\u0005J\u0019\u0010f\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010\\J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, m4988d2 = {"Lkotlin/UByte;", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "constructor-impl", "(B)B", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", BuildConfig.f24315FLAVOR, "other", "compareTo-7apg3OU", "(BB)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", BuildConfig.f24315FLAVOR, "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", BuildConfig.f24315FLAVOR, "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", BuildConfig.f24315FLAVOR, "toFloat-impl", "(B)F", "toDouble", BuildConfig.f24315FLAVOR, "toDouble-impl", "(B)D", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(B)Ljava/lang/String;", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
/* renamed from: kotlin.UByte */
/* loaded from: classes.dex */
public final class C1126UByte implements Comparable<C1126UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ C1126UByte(byte b) {
        this.data = b;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m18557and7apg3OU(byte b, byte b2) {
        return m18564constructorimpl((byte) (b & b2));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1126UByte m18558boximpl(byte b) {
        return new C1126UByte(b);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m18559compareTo7apg3OU(byte b) {
        return Intrinsics.m6319compare(getData() & MAX_VALUE, b & MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m18561compareToVKZWuLQ(byte b, long j) {
        return Long.compareUnsigned(C1130ULong.m18720constructorimpl(b & 255), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m18562compareToWZ4Q5Ns(byte b, int i) {
        return Integer.compareUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m18563compareToxj2QHRw(byte b, short s) {
        return Intrinsics.m6319compare(b & MAX_VALUE, s & 65535);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m18564constructorimpl(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m18565decw2LRezQ(byte b) {
        return m18564constructorimpl((byte) (b - 1));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m18566div7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m18567divVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(b & 255), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m18568divWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m18569divxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(s & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18570equalsimpl(byte b, Object obj) {
        return (obj instanceof C1126UByte) && b == ((C1126UByte) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18571equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m18572floorDiv7apg3OU(byte b, byte b2) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m18573floorDivVKZWuLQ(byte b, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(b & 255), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m18574floorDivWZ4Q5Ns(byte b, int i) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m18575floorDivxj2QHRw(byte b, short s) {
        return Integer.divideUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(s & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m18576hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m18577incw2LRezQ(byte b) {
        return m18564constructorimpl((byte) (b + 1));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m18578invw2LRezQ(byte b) {
        return m18564constructorimpl((byte) (~b));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m18579minus7apg3OU(byte b, byte b2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) - C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m18580minusVKZWuLQ(byte b, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(b & 255) - j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18581minusWZ4Q5Ns(byte b, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) - i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m18582minusxj2QHRw(byte b, short s) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) - C1128UInt.m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m18583mod7apg3OU(byte b, byte b2) {
        return m18564constructorimpl((byte) Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m18584modVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(b & 255), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m18585modWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m18586modxj2QHRw(byte b, short s) {
        return C1132UShort.m18827constructorimpl((short) Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(s & 65535)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m18587or7apg3OU(byte b, byte b2) {
        return m18564constructorimpl((byte) (b | b2));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m18588plus7apg3OU(byte b, byte b2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) + C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m18589plusVKZWuLQ(byte b, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(b & 255) + j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18590plusWZ4Q5Ns(byte b, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) + i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m18591plusxj2QHRw(byte b, short s) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) + C1128UInt.m18641constructorimpl(s & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m18592rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE), null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m18593rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m19789untilJ1ME1BU(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m18594rem7apg3OU(byte b, byte b2) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m18595remVKZWuLQ(byte b, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(b & 255), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m18596remWZ4Q5Ns(byte b, int i) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m18597remxj2QHRw(byte b, short s) {
        return Integer.remainderUnsigned(C1128UInt.m18641constructorimpl(b & MAX_VALUE), C1128UInt.m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m18598times7apg3OU(byte b, byte b2) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) * C1128UInt.m18641constructorimpl(b2 & MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m18599timesVKZWuLQ(byte b, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(b & 255) * j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m18600timesWZ4Q5Ns(byte b, int i) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) * i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m18601timesxj2QHRw(byte b, short s) {
        return C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(b & MAX_VALUE) * C1128UInt.m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m18602toByteimpl(byte b) {
        return b;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m18603toDoubleimpl(byte b) {
        return UnsignedKt.uintToDouble(b & MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m18604toFloatimpl(byte b) {
        return (float) UnsignedKt.uintToDouble(b & MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m18605toIntimpl(byte b) {
        return b & MAX_VALUE;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m18606toLongimpl(byte b) {
        return b & 255;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m18607toShortimpl(byte b) {
        return (short) (b & 255);
    }

    @IntrinsicConstEvaluation
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m18608toStringimpl(byte b) {
        return String.valueOf(b & MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m18609toUBytew2LRezQ(byte b) {
        return b;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m18610toUIntpVg5ArA(byte b) {
        return C1128UInt.m18641constructorimpl(b & MAX_VALUE);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m18611toULongsVKNKU(byte b) {
        return C1130ULong.m18720constructorimpl(b & 255);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m18612toUShortMh2AYeg(byte b) {
        return C1132UShort.m18827constructorimpl((short) (b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m18613xor7apg3OU(byte b, byte b2) {
        return m18564constructorimpl((byte) (b ^ b2));
    }

    @Override // java.lang.Comparable
    @IntrinsicConstEvaluation
    @InlineOnly
    public /* bridge */ /* synthetic */ int compareTo(C1126UByte c1126UByte) {
        return Intrinsics.m6319compare(getData() & MAX_VALUE, c1126UByte.getData() & MAX_VALUE);
    }

    /* renamed from: equals */
    public boolean m5079equals(Object other) {
        return m18570equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m18576hashCodeimpl(this.data);
    }

    @IntrinsicConstEvaluation
    public String toString() {
        return m18608toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m18560compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.m6319compare(b & MAX_VALUE, b2 & MAX_VALUE);
    }
}
