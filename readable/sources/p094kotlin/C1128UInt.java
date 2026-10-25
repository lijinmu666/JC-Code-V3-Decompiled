package p094kotlin;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.IntrinsicConstEvaluation;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p112ranges.UIntRange;
import p094kotlin.p112ranges.URangesKt;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0081\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0081\u0001B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0019\u0010\u000eJ!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0014J!\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001f\u0010\u000eJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u0012J!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0014J!\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u001dJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b$\u0010\u000eJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u0012J!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0014J!\u0010#\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u001dJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b)\u0010\u000eJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u0012J!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0014J!\u0010(\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u001dJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b.\u0010\u000eJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u0012J!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0014J!\u0010-\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u001dJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b3\u0010\u000eJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u0012J!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0014J!\u00102\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u001dJ!\u00107\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b8\u00109J!\u00107\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b:\u0010;J!\u00107\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b<\u0010\u0014J!\u00107\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u001dJ\u0015\u0010>\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b?\u0010\u0005J\u0015\u0010@\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bA\u0010\u0005J\u001d\u0010B\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bD\u0010EJ=\u0010F\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bH\u0012\b\bI\u0012\u0004\b\b(Jb\u0010\bK\u0012\f\bL\u0012\b\b\fJ\u0004\b\t0Mb\u0002\b\u000f¢\u0006\u0004\bG\u0010EJ!\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010\u0014J!\u0010Q\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010\u0014J!\u0010S\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010\u0014J!\u0010U\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0014J!\u0010W\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0014J\u0019\u0010Y\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bZ\u0010\u0005J\u0019\u0010[\u001a\u00020\\H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020`H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bd\u0010\u0005J\u0019\u0010e\u001a\u00020fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010hJ\u0019\u0010i\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bj\u0010^J\u0019\u0010k\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bl\u0010bJ\u0019\u0010m\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010\u0005J\u0019\u0010o\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bp\u0010hJ\u0019\u0010q\u001a\u00020rH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bs\u0010tJ\u0019\u0010u\u001a\u00020vH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bw\u0010xJ\u0015\u0010y\u001a\u00020zH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b{\u0010|J\u0014\u0010}\u001a\u00020~2\b\u0010\u000b\u001a\u0004\u0018\u00010\u007fHÖ\u0083\u0004J\u000b\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\r\bH\u0012\t\bI\u0012\u0005\b\b(\u0083\u0001Ê\u0001\u0003\b\u0084\u0001¨\u0006\u0082\u0001"}, m4988d2 = {"Lkotlin/UInt;", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "constructor-impl", "(I)I", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", BuildConfig.f24315FLAVOR, "toByte-impl", "(I)B", "toShort", BuildConfig.f24315FLAVOR, "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", BuildConfig.f24315FLAVOR, "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", BuildConfig.f24315FLAVOR, "toFloat-impl", "(I)F", "toDouble", BuildConfig.f24315FLAVOR, "toDouble-impl", "(I)D", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
/* renamed from: kotlin.UInt */
/* loaded from: classes.dex */
public final class C1128UInt implements Comparable<C1128UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ C1128UInt(int i) {
        this.data = i;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m18634andWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i & i2);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1128UInt m18635boximpl(int i) {
        return new C1128UInt(i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m18636compareTo7apg3OU(int i, byte b) {
        return Integer.compareUnsigned(i, m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m18637compareToVKZWuLQ(int i, long j) {
        return Long.compareUnsigned(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m18638compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(getData(), i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m18640compareToxj2QHRw(int i, short s) {
        return Integer.compareUnsigned(i, m18641constructorimpl(s & 65535));
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m18641constructorimpl(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m18642decpVg5ArA(int i) {
        return m18641constructorimpl(i - 1);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m18643div7apg3OU(int i, byte b) {
        return Integer.divideUnsigned(i, m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m18644divVKZWuLQ(int i, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m18645divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m18897uintDivideJ1ME1BU(i, i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m18646divxj2QHRw(int i, short s) {
        return Integer.divideUnsigned(i, m18641constructorimpl(s & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18647equalsimpl(int i, Object obj) {
        return (obj instanceof C1128UInt) && i == ((C1128UInt) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18648equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m18649floorDiv7apg3OU(int i, byte b) {
        return Integer.divideUnsigned(i, m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m18650floorDivVKZWuLQ(int i, long j) {
        return Long.divideUnsigned(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m18651floorDivWZ4Q5Ns(int i, int i2) {
        return Integer.divideUnsigned(i, i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m18652floorDivxj2QHRw(int i, short s) {
        return Integer.divideUnsigned(i, m18641constructorimpl(s & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m18653hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m18654incpVg5ArA(int i) {
        return m18641constructorimpl(i + 1);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m18655invpVg5ArA(int i) {
        return m18641constructorimpl(~i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m18656minus7apg3OU(int i, byte b) {
        return m18641constructorimpl(i - m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m18657minusVKZWuLQ(int i, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax) - j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18658minusWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i - i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m18659minusxj2QHRw(int i, short s) {
        return m18641constructorimpl(i - m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m18660mod7apg3OU(int i, byte b) {
        return C1126UByte.m18564constructorimpl((byte) Integer.remainderUnsigned(i, m18641constructorimpl(b & C1126UByte.MAX_VALUE)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m18661modVKZWuLQ(int i, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m18662modWZ4Q5Ns(int i, int i2) {
        return Integer.remainderUnsigned(i, i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m18663modxj2QHRw(int i, short s) {
        return C1132UShort.m18827constructorimpl((short) Integer.remainderUnsigned(i, m18641constructorimpl(s & 65535)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m18664orWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i | i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m18665plus7apg3OU(int i, byte b) {
        return m18641constructorimpl(i + m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m18666plusVKZWuLQ(int i, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax) + j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m18667plusWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i + i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m18668plusxj2QHRw(int i, short s) {
        return m18641constructorimpl(i + m18641constructorimpl(s & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m18669rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m18670rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m19789untilJ1ME1BU(i, i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m18671rem7apg3OU(int i, byte b) {
        return Integer.remainderUnsigned(i, m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m18672remVKZWuLQ(int i, long j) {
        return Long.remainderUnsigned(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m18673remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m18898uintRemainderJ1ME1BU(i, i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m18674remxj2QHRw(int i, short s) {
        return Integer.remainderUnsigned(i, m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m18675shlpVg5ArA(int i, int i2) {
        return m18641constructorimpl(i << i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m18676shrpVg5ArA(int i, int i2) {
        return m18641constructorimpl(i >>> i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m18677times7apg3OU(int i, byte b) {
        return m18641constructorimpl(i * m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m18678timesVKZWuLQ(int i, long j) {
        return C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax) * j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m18679timesWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i * i2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m18680timesxj2QHRw(int i, short s) {
        return m18641constructorimpl(i * m18641constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m18681toByteimpl(int i) {
        return (byte) i;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m18682toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m18683toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m18684toIntimpl(int i) {
        return i;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m18685toLongimpl(int i) {
        return i & BodyPartID.bodyIdMax;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m18686toShortimpl(int i) {
        return (short) i;
    }

    @IntrinsicConstEvaluation
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m18687toStringimpl(int i) {
        return String.valueOf(i & BodyPartID.bodyIdMax);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m18688toUBytew2LRezQ(int i) {
        return C1126UByte.m18564constructorimpl((byte) i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m18689toUIntpVg5ArA(int i) {
        return i;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m18690toULongsVKNKU(int i) {
        return C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m18691toUShortMh2AYeg(int i) {
        return C1132UShort.m18827constructorimpl((short) i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m18692xorWZ4Q5Ns(int i, int i2) {
        return m18641constructorimpl(i ^ i2);
    }

    @Override // java.lang.Comparable
    @IntrinsicConstEvaluation
    @InlineOnly
    public /* bridge */ /* synthetic */ int compareTo(C1128UInt c1128UInt) {
        return UnsignedKt.uintCompare(getData(), c1128UInt.getData());
    }

    /* renamed from: equals */
    public boolean m5085equals(Object other) {
        return m18647equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m18653hashCodeimpl(this.data);
    }

    @IntrinsicConstEvaluation
    public String toString() {
        return m18687toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m18639compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }
}
