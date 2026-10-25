package p094kotlin;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.IntrinsicConstEvaluation;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p112ranges.ULongRange;
import p094kotlin.p112ranges.URangesKt;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0084\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0084\u0001B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001bJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b$\u0010\u001dJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b%\u0010\u001fJ!\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b&\u0010!J!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001bJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b)\u0010\u001dJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b*\u0010\u001fJ!\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b+\u0010!J!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001bJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b.\u0010\u001dJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b/\u0010\u001fJ!\u0010,\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b0\u0010!J!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001bJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b3\u0010\u001dJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b4\u0010\u001fJ!\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b5\u0010!J!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001bJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b8\u0010\u001dJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b9\u0010\u001fJ!\u00106\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b:\u0010!J!\u0010;\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b<\u0010=J!\u0010;\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b>\u0010?J!\u0010;\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b@\u0010\u0016J!\u0010;\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bA\u0010!J\u0015\u0010B\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bC\u0010\u0005J\u0015\u0010D\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bE\u0010\u0005J\u001d\u0010F\u001a\u00020G2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bH\u0010IJ=\u0010J\u001a\u00020G2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bL\u0012\b\bM\u0012\u0004\b\b(Nb\u0010\bO\u0012\f\bP\u0012\b\b\fJ\u0004\b\t0Qb\u0002\b\u0010¢\u0006\u0004\bK\u0010IJ!\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u000bH\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bT\u0010\u001fJ!\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u000bH\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bV\u0010\u001fJ!\u0010W\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bX\u0010!J!\u0010Y\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bZ\u0010!J!\u0010[\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\\\u0010!J\u0019\u0010]\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b^\u0010\u0005J\u0019\u0010_\u001a\u00020`H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020dH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\be\u0010fJ\u0019\u0010g\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bh\u0010iJ\u0019\u0010j\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bk\u0010\u0005J\u0019\u0010l\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bm\u0010bJ\u0019\u0010n\u001a\u00020\u0011H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bo\u0010fJ\u0019\u0010p\u001a\u00020\u0014H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bq\u0010iJ\u0019\u0010r\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bs\u0010\u0005J\u0019\u0010t\u001a\u00020uH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0019\u0010x\u001a\u00020yH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bz\u0010{J\u0015\u0010|\u001a\u00020}H\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b~\u0010\u007fJ\u0017\u0010\u0080\u0001\u001a\u00030\u0081\u00012\t\u0010\f\u001a\u0005\u0018\u00010\u0082\u0001HÖ\u0083\u0004J\u000b\u0010\u0083\u0001\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\r\bL\u0012\t\bM\u0012\u0005\b\b(\u0086\u0001Ê\u0001\u0003\b\u0087\u0001¨\u0006\u0085\u0001"}, m4988d2 = {"Lkotlin/ULong;", BuildConfig.f24315FLAVOR, "data", BuildConfig.f24315FLAVOR, "constructor-impl", "(J)J", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", BuildConfig.f24315FLAVOR, "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", BuildConfig.f24315FLAVOR, "toByte-impl", "(J)B", "toShort", BuildConfig.f24315FLAVOR, "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", BuildConfig.f24315FLAVOR, "toFloat-impl", "(J)F", "toDouble", BuildConfig.f24315FLAVOR, "toDouble-impl", "(J)D", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
/* renamed from: kotlin.ULong */
/* loaded from: classes.dex */
public final class C1130ULong implements Comparable<C1130ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ C1130ULong(long j) {
        this.data = j;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m18713andVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j & j2);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1130ULong m18714boximpl(long j) {
        return new C1130ULong(j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m18715compareTo7apg3OU(long j, byte b) {
        return Long.compareUnsigned(j, m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m18716compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(getData(), j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m18718compareToWZ4Q5Ns(long j, int i) {
        return Long.compareUnsigned(j, m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m18719compareToxj2QHRw(long j, short s) {
        return Long.compareUnsigned(j, m18720constructorimpl(s & 65535));
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m18720constructorimpl(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m18721decsVKNKU(long j) {
        return m18720constructorimpl(j - 1);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m18722div7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m18723divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m18899ulongDivideeb3DHEI(j, j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m18724divWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m18725divxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m18720constructorimpl(s & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18726equalsimpl(long j, Object obj) {
        return (obj instanceof C1130ULong) && j == ((C1130ULong) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18727equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m18728floorDiv7apg3OU(long j, byte b) {
        return Long.divideUnsigned(j, m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m18729floorDivVKZWuLQ(long j, long j2) {
        return Long.divideUnsigned(j, j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m18730floorDivWZ4Q5Ns(long j, int i) {
        return Long.divideUnsigned(j, m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m18731floorDivxj2QHRw(long j, short s) {
        return Long.divideUnsigned(j, m18720constructorimpl(s & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m18732hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    @InlineOnly
    /* renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m18733incsVKNKU(long j) {
        return m18720constructorimpl(j + 1);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m18734invsVKNKU(long j) {
        return m18720constructorimpl(~j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m18735minus7apg3OU(long j, byte b) {
        return m18720constructorimpl(j - m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m18736minusVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j - j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m18737minusWZ4Q5Ns(long j, int i) {
        return m18720constructorimpl(j - m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m18738minusxj2QHRw(long j, short s) {
        return m18720constructorimpl(j - m18720constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m18739mod7apg3OU(long j, byte b) {
        return C1126UByte.m18564constructorimpl((byte) Long.remainderUnsigned(j, m18720constructorimpl(b & 255)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m18740modVKZWuLQ(long j, long j2) {
        return Long.remainderUnsigned(j, j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m18741modWZ4Q5Ns(long j, int i) {
        return C1128UInt.m18641constructorimpl((int) Long.remainderUnsigned(j, m18720constructorimpl(i & BodyPartID.bodyIdMax)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m18742modxj2QHRw(long j, short s) {
        return C1132UShort.m18827constructorimpl((short) Long.remainderUnsigned(j, m18720constructorimpl(s & 65535)));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m18743orVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j | j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m18744plus7apg3OU(long j, byte b) {
        return m18720constructorimpl(j + m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m18745plusVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j + j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m18746plusWZ4Q5Ns(long j, int i) {
        return m18720constructorimpl(j + m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m18747plusxj2QHRw(long j, short s) {
        return m18720constructorimpl(j + m18720constructorimpl(s & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m18748rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m18749rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt.m19791untileb3DHEI(j, j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m18750rem7apg3OU(long j, byte b) {
        return Long.remainderUnsigned(j, m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m18751remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m18900ulongRemaindereb3DHEI(j, j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m18752remWZ4Q5Ns(long j, int i) {
        return Long.remainderUnsigned(j, m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m18753remxj2QHRw(long j, short s) {
        return Long.remainderUnsigned(j, m18720constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m18754shlsVKNKU(long j, int i) {
        return m18720constructorimpl(j << i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m18755shrsVKNKU(long j, int i) {
        return m18720constructorimpl(j >>> i);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m18756times7apg3OU(long j, byte b) {
        return m18720constructorimpl(j * m18720constructorimpl(b & 255));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m18757timesVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j * j2);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m18758timesWZ4Q5Ns(long j, int i) {
        return m18720constructorimpl(j * m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m18759timesxj2QHRw(long j, short s) {
        return m18720constructorimpl(j * m18720constructorimpl(s & 65535));
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m18760toByteimpl(long j) {
        return (byte) j;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m18761toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m18762toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m18763toIntimpl(long j) {
        return (int) j;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m18764toLongimpl(long j) {
        return j;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m18765toShortimpl(long j) {
        return (short) j;
    }

    @IntrinsicConstEvaluation
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m18766toStringimpl(long j) {
        return UnsignedKt.ulongToString(j, 10);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m18767toUBytew2LRezQ(long j) {
        return C1126UByte.m18564constructorimpl((byte) j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m18768toUIntpVg5ArA(long j) {
        return C1128UInt.m18641constructorimpl((int) j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m18769toULongsVKNKU(long j) {
        return j;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m18770toUShortMh2AYeg(long j) {
        return C1132UShort.m18827constructorimpl((short) j);
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m18771xorVKZWuLQ(long j, long j2) {
        return m18720constructorimpl(j ^ j2);
    }

    @Override // java.lang.Comparable
    @IntrinsicConstEvaluation
    @InlineOnly
    public /* bridge */ /* synthetic */ int compareTo(C1130ULong c1130ULong) {
        return UnsignedKt.ulongCompare(getData(), c1130ULong.getData());
    }

    /* renamed from: equals */
    public boolean m5093equals(Object other) {
        return m18726equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m18732hashCodeimpl(this.data);
    }

    @IntrinsicConstEvaluation
    public String toString() {
        return m18766toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m18717compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }
}
