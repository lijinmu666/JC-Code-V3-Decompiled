package p132okio.internal;

import java.io.EOFException;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Typography;
import p132okio.ByteString;
import p132okio.C5052Buffer;
import p132okio.C5054Options;
import p132okio.C5059Segment;
import p132okio.C5066Utf8;
import p132okio.C6370SegmentedByteString;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;
import p132okio.SegmentPool;
import p132okio.SegmentedByteString;
import p132okio._JvmPlatformKt;

@Metadata(m4987d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a?\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u001a\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u00140\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0007H\u0000\u001a%\u0010\u001d\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\r\u0010!\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0010H\u0080\b\u001a\r\u0010$\u001a\u00020%*\u00020\u0010H\u0080\b\u001a\r\u0010&\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010'\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\u0015\u0010(\u001a\u00020#*\u00020\u00102\u0006\u0010)\u001a\u00020\u0012H\u0080\b\u001a\r\u0010*\u001a\u00020+*\u00020\u0010H\u0080\b\u001a\u0015\u0010,\u001a\u00020+*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a)\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0012H\u0002\u001a\u0015\u00105\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u0015\u00106\u001a\u00020\t*\u00020\u00102\u0006\u00107\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u0001H\u0080\b\u001a%\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u00109\u001a\u00020\u0001*\u00020\u0010H\u0080\b\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u0001H\u0080\b\u001a%\u0010:\u001a\u00020\u0005*\u00020\u00102\u0006\u0010;\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\r\u0010?\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010@\u001a\u00020\u0012*\u00020\u0010H\u0080\b\u001a\r\u0010A\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010A\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010B\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0080\b\u001a\u001d\u0010<\u001a\u00020+*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010C\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020DH\u0080\b\u001a\u0015\u0010E\u001a\u00020\u000f*\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u000f\u0010F\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u000f*\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0080\b\u001a\r\u0010I\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a%\u0010J\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010N\u001a\u00020\u0010*\u00020\u00102\u0006\u0010O\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010P\u001a\u00020\u0012*\u00020\u00102\u0006\u00108\u001a\u00020QH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0010*\u00020\u00102\u0006\u00108\u001a\u00020Q2\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010R\u001a\u00020\u0010*\u00020\u00102\u0006\u0010S\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010T\u001a\u00020\u0010*\u00020\u00102\u0006\u0010U\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0010*\u00020\u00102\u0006\u0010W\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010X\u001a\u00020\u0010*\u00020\u00102\u0006\u00101\u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010-\u001a\u00020+*\u00020\u00102\u0006\u00108\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0012*\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0080\b\u001a%\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010S\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0080\b\u001a:\u0010Y\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010Z\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005H\u0000\u001a\u001d\u0010[\u001a\u00020\u0012*\u00020\u00102\u0006\u0010\\\u001a\u00020/2\u0006\u0010\u0015\u001a\u00020\u0012H\u0080\b\u001a-\u0010]\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010^\u001a\u00020\u0007*\u00020\u00102\b\u0010_\u001a\u0004\u0018\u00010`H\u0080\b\u001a\r\u0010a\u001a\u00020\u0005*\u00020\u0010H\u0080\b\u001a\r\u0010b\u001a\u00020\u0010*\u00020\u0010H\u0080\b\u001a\r\u0010c\u001a\u00020/*\u00020\u0010H\u0080\b\u001a\u0015\u0010c\u001a\u00020/*\u00020\u00102\u0006\u0010 \u001a\u00020\u0005H\u0080\b\u001a\u0014\u0010d\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\u0014\u0010g\u001a\u00020e*\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0000\u001a\r\u0010h\u001a\u00020\u0005*\u00020eH\u0080\b\u001a\u0015\u0010i\u001a\u00020\u0005*\u00020e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010j\u001a\u00020\u0012*\u00020e2\u0006\u0010k\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010l\u001a\u00020\u0012*\u00020e2\u0006\u0010m\u001a\u00020\u0005H\u0080\b\u001a\r\u0010n\u001a\u00020+*\u00020eH\u0080\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, m4988d2 = {"HEX_DIGIT_BYTES", BuildConfig.f24315FLAVOR, "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", BuildConfig.f24315FLAVOR, "rangeEquals", BuildConfig.f24315FLAVOR, "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "readUtf8Line", BuildConfig.f24315FLAVOR, "Lokio/Buffer;", "newline", BuildConfig.f24315FLAVOR, "seek", "T", "fromIndex", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "options", "Lokio/Options;", "selectTruncated", "commonCopyTo", "out", "offset", "byteCount", "commonCompleteSegmentByteCount", "commonReadByte", BuildConfig.f24315FLAVOR, "commonReadShort", BuildConfig.f24315FLAVOR, "commonReadInt", "commonReadLong", "commonGet", "pos", "commonClear", BuildConfig.f24315FLAVOR, "commonSkip", "commonWrite", "byteString", "Lokio/ByteString;", "commonWriteDecimalLong", "v", "countDigitsIn", "DigitCountToLargestValue", BuildConfig.f24315FLAVOR, "commonWriteHexadecimalUnsignedLong", "commonWritableSegment", "minimumCapacity", "source", "commonReadByteArray", "commonRead", "sink", "commonReadFully", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "commonSelect", "commonReadAll", "Lokio/Sink;", "commonReadUtf8", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "commonWriteAll", "Lokio/Source;", "commonWriteByte", "b", "commonWriteShort", "s", "commonWriteInt", "i", "commonWriteLong", "commonIndexOf", "toIndex", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonEquals", "other", BuildConfig.f24315FLAVOR, "commonHashCode", "commonCopy", "commonSnapshot", "commonReadUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "commonReadAndWriteUnsafe", "commonNext", "commonSeek", "commonResizeBuffer", "newSize", "commonExpandBuffer", "minByteCount", "commonClose", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-Buffer")
@SourceDebugExtension(m6344value = {"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1709:1\n109#1,20:1732\n109#1,20:1765\n109#1:1785\n111#1,18:1787\n109#1,20:1805\n75#2:1710\n75#2:1711\n75#2:1712\n75#2:1713\n75#2:1714\n75#2:1715\n75#2:1716\n75#2:1717\n75#2:1718\n75#2:1719\n75#2:1720\n75#2:1721\n84#2:1722\n84#2:1723\n78#2:1724\n78#2:1725\n78#2:1726\n78#2:1727\n78#2:1728\n78#2:1729\n78#2:1730\n78#2:1731\n87#2:1752\n90#2:1754\n75#2:1755\n75#2:1756\n75#2:1757\n75#2:1758\n75#2:1759\n75#2:1760\n75#2:1761\n75#2:1762\n75#2:1763\n75#2:1764\n90#2:1786\n87#2:1825\n1#3:1753\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n*L\n412#1:1732,20\n1261#1:1765,20\n1304#1:1785\n1304#1:1787,18\n1340#1:1805,20\n175#1:1710\n199#1:1711\n318#1:1712\n323#1:1713\n346#1:1714\n347#1:1715\n348#1:1716\n349#1:1717\n355#1:1718\n356#1:1719\n357#1:1720\n358#1:1721\n382#1:1722\n383#1:1723\n389#1:1724\n390#1:1725\n391#1:1726\n392#1:1727\n393#1:1728\n394#1:1729\n395#1:1730\n396#1:1731\n424#1:1752\n857#1:1754\n875#1:1755\n877#1:1756\n881#1:1757\n883#1:1758\n887#1:1759\n889#1:1760\n893#1:1761\n895#1:1762\n915#1:1763\n918#1:1764\n1316#1:1786\n1655#1:1825\n*E\n"})
/* renamed from: okio.internal.-Buffer */
/* loaded from: classes.dex */
public final class C5067Buffer {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    private static final long[] DigitCountToLargestValue = {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, LongCompanionObject.MAX_VALUE};

    public static final void commonClear(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        c5052Buffer.mo14226skip(c5052Buffer.m14225size());
    }

    public static final void commonClose(C5052Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        long jM14225size = c5052Buffer.m14225size();
        if (jM14225size == 0) {
            return 0L;
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        C5059Segment c5059Segment2 = c5059Segment.prev;
        Intrinsics.checkNotNull(c5059Segment2);
        return (c5059Segment2.limit >= 8192 || !c5059Segment2.owner) ? jM14225size : jM14225size - (r2 - c5059Segment2.pos);
    }

    public static final C5052Buffer commonCopy(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5052Buffer c5052Buffer2 = new C5052Buffer();
        if (c5052Buffer.m14225size() == 0) {
            return c5052Buffer2;
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        C5059Segment c5059SegmentSharedCopy = c5059Segment.sharedCopy();
        c5052Buffer2.head = c5059SegmentSharedCopy;
        c5059SegmentSharedCopy.prev = c5059SegmentSharedCopy;
        c5059SegmentSharedCopy.next = c5059SegmentSharedCopy;
        for (C5059Segment c5059Segment2 = c5059Segment.next; c5059Segment2 != c5059Segment; c5059Segment2 = c5059Segment2.next) {
            C5059Segment c5059Segment3 = c5059SegmentSharedCopy.prev;
            Intrinsics.checkNotNull(c5059Segment3);
            Intrinsics.checkNotNull(c5059Segment2);
            c5059Segment3.m14381push(c5059Segment2.sharedCopy());
        }
        c5052Buffer2.setSize$okio(c5052Buffer.m14225size());
        return c5052Buffer2;
    }

    public static final C5052Buffer commonCopyTo(C5052Buffer c5052Buffer, C5052Buffer out, long j, long j2) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        SegmentedByteString.checkOffsetAndCount(c5052Buffer.m14225size(), j, j2);
        if (j2 == 0) {
            return c5052Buffer;
        }
        out.setSize$okio(out.m14225size() + j2);
        C5059Segment c5059Segment = c5052Buffer.head;
        while (true) {
            Intrinsics.checkNotNull(c5059Segment);
            int i = c5059Segment.limit;
            int i2 = c5059Segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            c5059Segment = c5059Segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(c5059Segment);
            C5059Segment c5059SegmentSharedCopy = c5059Segment.sharedCopy();
            int i3 = c5059SegmentSharedCopy.pos + ((int) j);
            c5059SegmentSharedCopy.pos = i3;
            c5059SegmentSharedCopy.limit = Math.min(i3 + ((int) j2), c5059SegmentSharedCopy.limit);
            C5059Segment c5059Segment2 = out.head;
            if (c5059Segment2 == null) {
                c5059SegmentSharedCopy.prev = c5059SegmentSharedCopy;
                c5059SegmentSharedCopy.next = c5059SegmentSharedCopy;
                out.head = c5059SegmentSharedCopy;
            } else {
                Intrinsics.checkNotNull(c5059Segment2);
                C5059Segment c5059Segment3 = c5059Segment2.prev;
                Intrinsics.checkNotNull(c5059Segment3);
                c5059Segment3.m14381push(c5059SegmentSharedCopy);
            }
            j2 -= c5059SegmentSharedCopy.limit - c5059SegmentSharedCopy.pos;
            c5059Segment = c5059Segment.next;
            j = 0;
        }
        return c5052Buffer;
    }

    public static final boolean commonEquals(C5052Buffer c5052Buffer, Object obj) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer == obj) {
            return true;
        }
        if (!(obj instanceof C5052Buffer)) {
            return false;
        }
        C5052Buffer c5052Buffer2 = (C5052Buffer) obj;
        if (c5052Buffer.m14225size() != c5052Buffer2.m14225size()) {
            return false;
        }
        if (c5052Buffer.m14225size() == 0) {
            return true;
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        C5059Segment c5059Segment2 = c5052Buffer2.head;
        Intrinsics.checkNotNull(c5059Segment2);
        int i = c5059Segment.pos;
        int i2 = c5059Segment2.pos;
        long j = 0;
        while (j < c5052Buffer.m14225size()) {
            long jMin = Math.min(c5059Segment.limit - i, c5059Segment2.limit - i2);
            long j2 = 0;
            while (j2 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (c5059Segment.data[i] != c5059Segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == c5059Segment.limit) {
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                i = c5059Segment.pos;
            }
            if (i2 == c5059Segment2.limit) {
                c5059Segment2 = c5059Segment2.next;
                Intrinsics.checkNotNull(c5059Segment2);
                i2 = c5059Segment2.pos;
            }
            j += jMin;
        }
        return true;
    }

    public static final long commonExpandBuffer(C5052Buffer.UnsafeCursor unsafeCursor, int i) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (i <= 0) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
        }
        if (i > 8192) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
        }
        C5052Buffer c5052Buffer = unsafeCursor.buffer;
        if (c5052Buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long jM14225size = c5052Buffer.m14225size();
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(i);
        int i2 = 8192 - c5059SegmentWritableSegment$okio.limit;
        c5059SegmentWritableSegment$okio.limit = 8192;
        long j = i2;
        c5052Buffer.setSize$okio(jM14225size + j);
        unsafeCursor.setSegment$okio(c5059SegmentWritableSegment$okio);
        unsafeCursor.offset = jM14225size;
        unsafeCursor.data = c5059SegmentWritableSegment$okio.data;
        unsafeCursor.start = 8192 - i2;
        unsafeCursor.end = 8192;
        return j;
    }

    public static final byte commonGet(C5052Buffer c5052Buffer, long j) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        SegmentedByteString.checkOffsetAndCount(c5052Buffer.m14225size(), j, 1L);
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (c5052Buffer.m14225size() - j < j) {
            long jM14225size = c5052Buffer.m14225size();
            while (jM14225size > j) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            Intrinsics.checkNotNull(c5059Segment);
            return c5059Segment.data[(int) ((c5059Segment.pos + j) - jM14225size)];
        }
        long j2 = 0;
        while (true) {
            long j3 = (c5059Segment.limit - c5059Segment.pos) + j2;
            if (j3 > j) {
                Intrinsics.checkNotNull(c5059Segment);
                return c5059Segment.data[(int) ((c5059Segment.pos + j) - j2)];
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            j2 = j3;
        }
    }

    public static final int commonHashCode(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c5059Segment.limit;
            for (int i3 = c5059Segment.pos; i3 < i2; i3++) {
                i = (i * 31) + c5059Segment.data[i3];
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
        } while (c5059Segment != c5052Buffer.head);
        return i;
    }

    public static final long commonIndexOf(C5052Buffer c5052Buffer, byte b, long j, long j2) {
        C5059Segment c5059Segment;
        int i;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        long jM14225size = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + c5052Buffer.m14225size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > c5052Buffer.m14225size()) {
            j2 = c5052Buffer.m14225size();
        }
        if (j == j2 || (c5059Segment = c5052Buffer.head) == null) {
            return -1L;
        }
        if (c5052Buffer.m14225size() - j < j) {
            jM14225size = c5052Buffer.m14225size();
            while (jM14225size > j) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            while (jM14225size < j2) {
                byte[] bArr = c5059Segment.data;
                int iMin = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + j2) - jM14225size);
                i = (int) ((c5059Segment.pos + j) - jM14225size);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                j = jM14225size;
            }
            return -1L;
        }
        while (true) {
            long j3 = (c5059Segment.limit - c5059Segment.pos) + jM14225size;
            if (j3 > j) {
                break;
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jM14225size = j3;
        }
        while (jM14225size < j2) {
            byte[] bArr2 = c5059Segment.data;
            int iMin2 = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + j2) - jM14225size);
            i = (int) ((c5059Segment.pos + j) - jM14225size);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            jM14225size += c5059Segment.limit - c5059Segment.pos;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            j = jM14225size;
        }
        return -1L;
        return (i - c5059Segment.pos) + jM14225size;
    }

    public static final long commonIndexOfElement(C5052Buffer c5052Buffer, ByteString targetBytes, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long jM14225size = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment == null) {
            return -1L;
        }
        if (c5052Buffer.m14225size() - j < j) {
            jM14225size = c5052Buffer.m14225size();
            while (jM14225size > j) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            if (targetBytes.m14252size() == 2) {
                byte bM14242getByte = targetBytes.m14242getByte(0);
                byte bM14242getByte2 = targetBytes.m14242getByte(1);
                while (jM14225size < c5052Buffer.m14225size()) {
                    byte[] bArr = c5059Segment.data;
                    i = (int) ((c5059Segment.pos + j) - jM14225size);
                    int i3 = c5059Segment.limit;
                    while (i < i3) {
                        byte b = bArr[i];
                        if (b == bM14242getByte || b == bM14242getByte2) {
                            i2 = c5059Segment.pos;
                        } else {
                            i++;
                        }
                    }
                    jM14225size += c5059Segment.limit - c5059Segment.pos;
                    c5059Segment = c5059Segment.next;
                    Intrinsics.checkNotNull(c5059Segment);
                    j = jM14225size;
                }
            } else {
                byte[] bArrInternalArray$okio = targetBytes.internalArray$okio();
                while (jM14225size < c5052Buffer.m14225size()) {
                    byte[] bArr2 = c5059Segment.data;
                    i = (int) ((c5059Segment.pos + j) - jM14225size);
                    int i4 = c5059Segment.limit;
                    while (i < i4) {
                        byte b2 = bArr2[i];
                        for (byte b3 : bArrInternalArray$okio) {
                            if (b2 == b3) {
                                i2 = c5059Segment.pos;
                            }
                        }
                        i++;
                    }
                    jM14225size += c5059Segment.limit - c5059Segment.pos;
                    c5059Segment = c5059Segment.next;
                    Intrinsics.checkNotNull(c5059Segment);
                    j = jM14225size;
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = (c5059Segment.limit - c5059Segment.pos) + jM14225size;
            if (j2 > j) {
                break;
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jM14225size = j2;
        }
        if (targetBytes.m14252size() == 2) {
            byte bM14242getByte3 = targetBytes.m14242getByte(0);
            byte bM14242getByte4 = targetBytes.m14242getByte(1);
            while (jM14225size < c5052Buffer.m14225size()) {
                byte[] bArr3 = c5059Segment.data;
                i = (int) ((c5059Segment.pos + j) - jM14225size);
                int i5 = c5059Segment.limit;
                while (i < i5) {
                    byte b4 = bArr3[i];
                    if (b4 == bM14242getByte3 || b4 == bM14242getByte4) {
                        i2 = c5059Segment.pos;
                    } else {
                        i++;
                    }
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                j = jM14225size;
            }
        } else {
            byte[] bArrInternalArray$okio2 = targetBytes.internalArray$okio();
            while (jM14225size < c5052Buffer.m14225size()) {
                byte[] bArr4 = c5059Segment.data;
                i = (int) ((c5059Segment.pos + j) - jM14225size);
                int i6 = c5059Segment.limit;
                while (i < i6) {
                    byte b5 = bArr4[i];
                    for (byte b6 : bArrInternalArray$okio2) {
                        if (b5 == b6) {
                            i2 = c5059Segment.pos;
                        }
                    }
                    i++;
                }
                jM14225size += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                j = jM14225size;
            }
        }
        return -1L;
        return (i - i2) + jM14225size;
    }

    public static final int commonNext(C5052Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        long j = unsafeCursor.offset;
        C5052Buffer c5052Buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(c5052Buffer);
        if (j == c5052Buffer.m14225size()) {
            throw new IllegalStateException("no more bytes");
        }
        long j2 = unsafeCursor.offset;
        return unsafeCursor.m14235seek(j2 == -1 ? 0L : j2 + (unsafeCursor.end - unsafeCursor.start));
    }

    public static final boolean commonRangeEquals(C5052Buffer c5052Buffer, long j, ByteString bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (i2 >= 0 && j >= 0 && i2 + j <= c5052Buffer.m14225size() && i >= 0 && i + i2 <= bytes.m14252size()) {
            return i2 == 0 || commonIndexOf(c5052Buffer, bytes, j, j + 1, i, i2) != -1;
        }
        return false;
    }

    public static final int commonRead(C5052Buffer c5052Buffer, byte[] sink) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return c5052Buffer.mo14215read(sink, 0, sink.length);
    }

    public static final long commonReadAll(C5052Buffer c5052Buffer, InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long jM14225size = c5052Buffer.m14225size();
        if (jM14225size > 0) {
            sink.mo2303write(c5052Buffer, jM14225size);
        }
        return jM14225size;
    }

    public static final C5052Buffer.UnsafeCursor commonReadAndWriteUnsafe(C5052Buffer c5052Buffer, C5052Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = c5052Buffer;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    public static final byte commonReadByte(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() == 0) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        int i3 = i + 1;
        byte b = c5059Segment.data[i];
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - 1);
        if (i3 == i2) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i3;
        }
        return b;
    }

    public static final byte[] commonReadByteArray(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        return c5052Buffer.readByteArray(c5052Buffer.m14225size());
    }

    public static final ByteString commonReadByteString(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        return c5052Buffer.readByteString(c5052Buffer.m14225size());
    }

    public static final long commonReadDecimalLong(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() == 0) {
            throw new EOFException();
        }
        int i = 0;
        boolean z = false;
        long j = 0;
        long j2 = -7;
        boolean z2 = false;
        do {
            C5059Segment c5059Segment = c5052Buffer.head;
            Intrinsics.checkNotNull(c5059Segment);
            byte[] bArr = c5059Segment.data;
            int i2 = c5059Segment.pos;
            int i3 = c5059Segment.limit;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j < OVERFLOW_ZONE || (j == OVERFLOW_ZONE && i4 < j2)) {
                        C5052Buffer c5052BufferWriteByte = new C5052Buffer().writeDecimalLong(j).writeByte((int) b);
                        if (!z) {
                            c5052BufferWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + c5052BufferWriteByte.readUtf8());
                    }
                    j = (j * 10) + i4;
                } else {
                    if (b != 45 || i != 0) {
                        z2 = true;
                        break;
                    }
                    j2--;
                    z = true;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                c5052Buffer.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            } else {
                c5059Segment.pos = i2;
            }
            if (z2) {
                break;
            }
        } while (c5052Buffer.head != null);
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - i);
        if (i >= (z ? 2 : 1)) {
            return z ? j : -j;
        }
        if (c5052Buffer.m14225size() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + SegmentedByteString.toHexString(c5052Buffer.m14205getByte(0L)));
    }

    public static final void commonReadFully(C5052Buffer c5052Buffer, byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int iMo14215read = c5052Buffer.mo14215read(sink, i, sink.length - i);
            if (iMo14215read == -1) {
                throw new EOFException();
            }
            i += iMo14215read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac A[EDGE_INSN: B:43:0x00ac->B:37:0x00ac BREAK  A[LOOP:0: B:5:0x0012->B:45:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadHexadecimalUnsignedLong(C5052Buffer c5052Buffer) throws EOFException {
        int i;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            C5059Segment c5059Segment = c5052Buffer.head;
            Intrinsics.checkNotNull(c5059Segment);
            byte[] bArr = c5059Segment.data;
            int i3 = c5059Segment.pos;
            int i4 = c5059Segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else if (b >= 65 && b <= 70) {
                    i = b - 55;
                } else {
                    if (i2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + SegmentedByteString.toHexString(b));
                    }
                    z = true;
                    if (i3 != i4) {
                        c5052Buffer.head = c5059Segment.m14380pop();
                        SegmentPool.m14384recycle(c5059Segment);
                    } else {
                        c5059Segment.pos = i3;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new C5052Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (c5052Buffer.head != null);
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - i2);
        return j;
    }

    public static final int commonReadInt(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() < 4) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 4) {
            return (c5052Buffer.readByte() & C1126UByte.MAX_VALUE) | ((c5052Buffer.readByte() & C1126UByte.MAX_VALUE) << 24) | ((c5052Buffer.readByte() & C1126UByte.MAX_VALUE) << 16) | ((c5052Buffer.readByte() & C1126UByte.MAX_VALUE) << 8);
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i] & C1126UByte.MAX_VALUE) << 24) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & C1126UByte.MAX_VALUE) | i4;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - 4);
        if (i5 == i2) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i5;
        }
        return i6;
    }

    public static final long commonReadLong(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() < 8) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 8) {
            return ((c5052Buffer.mo14217readInt() & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & c5052Buffer.mo14217readInt());
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 7;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - 8);
        if (i4 == i2) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i4;
        }
        return j2;
    }

    public static final short commonReadShort(C5052Buffer c5052Buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() < 2) {
            throw new EOFException();
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        int i2 = c5059Segment.limit;
        if (i2 - i < 2) {
            return (short) ((c5052Buffer.readByte() & C1126UByte.MAX_VALUE) | ((c5052Buffer.readByte() & C1126UByte.MAX_VALUE) << 8));
        }
        byte[] bArr = c5059Segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & C1126UByte.MAX_VALUE) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & C1126UByte.MAX_VALUE) | i4;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - 2);
        if (i5 == i2) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        } else {
            c5059Segment.pos = i5;
        }
        return (short) i6;
    }

    public static final C5052Buffer.UnsafeCursor commonReadUnsafe(C5052Buffer c5052Buffer, C5052Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = c5052Buffer;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    public static final String commonReadUtf8(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (c5052Buffer.m14225size() < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        Intrinsics.checkNotNull(c5059Segment);
        int i = c5059Segment.pos;
        if (i + j > c5059Segment.limit) {
            return C5071_Utf8Kt.commonToUtf8String$default(c5052Buffer.readByteArray(j), 0, 0, 3, null);
        }
        int i2 = (int) j;
        String strCommonToUtf8String = C5071_Utf8Kt.commonToUtf8String(c5059Segment.data, i, i + i2);
        c5059Segment.pos += i2;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - j);
        if (c5059Segment.pos == c5059Segment.limit) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(C5052Buffer c5052Buffer) throws EOFException {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() == 0) {
            throw new EOFException();
        }
        byte bM14205getByte = c5052Buffer.m14205getByte(0L);
        if ((bM14205getByte & ByteCompanionObject.MIN_VALUE) == 0) {
            i = bM14205getByte & ByteCompanionObject.MAX_VALUE;
            i3 = 0;
            i2 = 1;
        } else if ((bM14205getByte & 224) == 192) {
            i = bM14205getByte & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bM14205getByte & 240) == 224) {
            i = bM14205getByte & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bM14205getByte & 248) != 240) {
                c5052Buffer.mo14226skip(1L);
                return C5066Utf8.REPLACEMENT_CODE_POINT;
            }
            i = bM14205getByte & 7;
            i2 = 4;
            i3 = PKIFailureInfo.notAuthorized;
        }
        long j = i2;
        if (c5052Buffer.m14225size() < j) {
            throw new EOFException("size < " + i2 + ": " + c5052Buffer.m14225size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(bM14205getByte) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bM14205getByte2 = c5052Buffer.m14205getByte(j2);
            if ((bM14205getByte2 & 192) != 128) {
                c5052Buffer.mo14226skip(j2);
                return C5066Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (bM14205getByte2 & C5066Utf8.REPLACEMENT_BYTE);
        }
        c5052Buffer.mo14226skip(j);
        return i > 1114111 ? C5066Utf8.REPLACEMENT_CODE_POINT : ((55296 > i || i >= 57344) && i >= i3) ? i : C5066Utf8.REPLACEMENT_CODE_POINT;
    }

    public static final String commonReadUtf8Line(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        long jMo14206indexOf = c5052Buffer.mo14206indexOf((byte) 10);
        if (jMo14206indexOf != -1) {
            return readUtf8Line(c5052Buffer, jMo14206indexOf);
        }
        if (c5052Buffer.m14225size() != 0) {
            return c5052Buffer.readUtf8(c5052Buffer.m14225size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long jMo14208indexOf = c5052Buffer.mo14208indexOf((byte) 10, 0L, j2);
        if (jMo14208indexOf != -1) {
            return readUtf8Line(c5052Buffer, jMo14208indexOf);
        }
        if (j2 < c5052Buffer.m14225size() && c5052Buffer.m14205getByte(j2 - 1) == 13 && c5052Buffer.m14205getByte(j2) == 10) {
            return readUtf8Line(c5052Buffer, j2);
        }
        C5052Buffer c5052Buffer2 = new C5052Buffer();
        c5052Buffer.m14202copyTo(c5052Buffer2, 0L, Math.min(32, c5052Buffer.m14225size()));
        throw new EOFException("\\n not found: limit=" + Math.min(c5052Buffer.m14225size(), j) + " content=" + c5052Buffer2.readByteString().mo14243hex() + Typography.ellipsis);
    }

    public static final long commonResizeBuffer(C5052Buffer.UnsafeCursor unsafeCursor, long j) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        C5052Buffer c5052Buffer = unsafeCursor.buffer;
        if (c5052Buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long jM14225size = c5052Buffer.m14225size();
        if (j <= jM14225size) {
            if (j < 0) {
                throw new IllegalArgumentException(("newSize < 0: " + j).toString());
            }
            long j2 = jM14225size - j;
            while (true) {
                if (j2 <= 0) {
                    break;
                }
                C5059Segment c5059Segment = c5052Buffer.head;
                Intrinsics.checkNotNull(c5059Segment);
                C5059Segment c5059Segment2 = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment2);
                int i = c5059Segment2.limit;
                long j3 = i - c5059Segment2.pos;
                if (j3 > j2) {
                    c5059Segment2.limit = i - ((int) j2);
                    break;
                }
                c5052Buffer.head = c5059Segment2.m14380pop();
                SegmentPool.m14384recycle(c5059Segment2);
                j2 -= j3;
            }
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
        } else if (j > jM14225size) {
            long j4 = j - jM14225size;
            boolean z = true;
            while (j4 > 0) {
                C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(1);
                int iMin = (int) Math.min(j4, 8192 - c5059SegmentWritableSegment$okio.limit);
                c5059SegmentWritableSegment$okio.limit += iMin;
                j4 -= iMin;
                if (z) {
                    unsafeCursor.setSegment$okio(c5059SegmentWritableSegment$okio);
                    unsafeCursor.offset = jM14225size;
                    unsafeCursor.data = c5059SegmentWritableSegment$okio.data;
                    int i2 = c5059SegmentWritableSegment$okio.limit;
                    unsafeCursor.start = i2 - iMin;
                    unsafeCursor.end = i2;
                    z = false;
                }
            }
        }
        c5052Buffer.setSize$okio(j);
        return jM14225size;
    }

    public static final int commonSeek(C5052Buffer.UnsafeCursor unsafeCursor, long j) {
        C5059Segment c5059SegmentM14381push;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        C5052Buffer c5052Buffer = unsafeCursor.buffer;
        if (c5052Buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j < -1 || j > c5052Buffer.m14225size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + c5052Buffer.m14225size());
        }
        if (j == -1 || j == c5052Buffer.m14225size()) {
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return -1;
        }
        long jM14225size = c5052Buffer.m14225size();
        C5059Segment segment = c5052Buffer.head;
        long j2 = 0;
        if (unsafeCursor.getSegment() != null) {
            long j3 = unsafeCursor.offset;
            int i = unsafeCursor.start;
            Intrinsics.checkNotNull(unsafeCursor.getSegment());
            long j4 = j3 - (i - r9.pos);
            if (j4 > j) {
                c5059SegmentM14381push = segment;
                segment = unsafeCursor.getSegment();
                jM14225size = j4;
            } else {
                c5059SegmentM14381push = unsafeCursor.getSegment();
                j2 = j4;
            }
        } else {
            c5059SegmentM14381push = segment;
        }
        if (jM14225size - j > j - j2) {
            while (true) {
                Intrinsics.checkNotNull(c5059SegmentM14381push);
                int i2 = c5059SegmentM14381push.limit;
                int i3 = c5059SegmentM14381push.pos;
                if (j < (i2 - i3) + j2) {
                    break;
                }
                j2 += i2 - i3;
                c5059SegmentM14381push = c5059SegmentM14381push.next;
            }
        } else {
            while (jM14225size > j) {
                Intrinsics.checkNotNull(segment);
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                jM14225size -= segment.limit - segment.pos;
            }
            j2 = jM14225size;
            c5059SegmentM14381push = segment;
        }
        if (unsafeCursor.readWrite) {
            Intrinsics.checkNotNull(c5059SegmentM14381push);
            if (c5059SegmentM14381push.shared) {
                C5059Segment c5059SegmentUnsharedCopy = c5059SegmentM14381push.unsharedCopy();
                if (c5052Buffer.head == c5059SegmentM14381push) {
                    c5052Buffer.head = c5059SegmentUnsharedCopy;
                }
                c5059SegmentM14381push = c5059SegmentM14381push.m14381push(c5059SegmentUnsharedCopy);
                C5059Segment c5059Segment = c5059SegmentM14381push.prev;
                Intrinsics.checkNotNull(c5059Segment);
                c5059Segment.m14380pop();
            }
        }
        unsafeCursor.setSegment$okio(c5059SegmentM14381push);
        unsafeCursor.offset = j;
        Intrinsics.checkNotNull(c5059SegmentM14381push);
        unsafeCursor.data = c5059SegmentM14381push.data;
        int i4 = c5059SegmentM14381push.pos + ((int) (j - j2));
        unsafeCursor.start = i4;
        int i5 = c5059SegmentM14381push.limit;
        unsafeCursor.end = i5;
        return i5 - i4;
    }

    public static final int commonSelect(C5052Buffer c5052Buffer, C5054Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int iSelectPrefix$default = selectPrefix$default(c5052Buffer, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        c5052Buffer.mo14226skip(options.getByteStrings()[iSelectPrefix$default].m14252size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        while (j > 0) {
            C5059Segment c5059Segment = c5052Buffer.head;
            if (c5059Segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, c5059Segment.limit - c5059Segment.pos);
            long j2 = iMin;
            c5052Buffer.setSize$okio(c5052Buffer.m14225size() - j2);
            j -= j2;
            int i = c5059Segment.pos + iMin;
            c5059Segment.pos = i;
            if (i == c5059Segment.limit) {
                c5052Buffer.head = c5059Segment.m14380pop();
                SegmentPool.m14384recycle(c5059Segment);
            }
        }
    }

    public static final ByteString commonSnapshot(C5052Buffer c5052Buffer) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (c5052Buffer.m14225size() <= 2147483647L) {
            return c5052Buffer.snapshot((int) c5052Buffer.m14225size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + c5052Buffer.m14225size()).toString());
    }

    public static final C5059Segment commonWritableSegment(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment != null) {
            Intrinsics.checkNotNull(c5059Segment);
            C5059Segment c5059Segment2 = c5059Segment.prev;
            Intrinsics.checkNotNull(c5059Segment2);
            return (c5059Segment2.limit + i > 8192 || !c5059Segment2.owner) ? c5059Segment2.m14381push(SegmentPool.m14385take()) : c5059Segment2;
        }
        C5059Segment c5059SegmentM14385take = SegmentPool.m14385take();
        c5052Buffer.head = c5059SegmentM14385take;
        c5059SegmentM14385take.prev = c5059SegmentM14385take;
        c5059SegmentM14385take.next = c5059SegmentM14385take;
        return c5059SegmentM14385take;
    }

    public static final C5052Buffer commonWrite(C5052Buffer c5052Buffer, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(c5052Buffer, i, i2);
        return c5052Buffer;
    }

    public static /* synthetic */ C5052Buffer commonWrite$default(C5052Buffer c5052Buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.m14252size();
        }
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(c5052Buffer, i, i2);
        return c5052Buffer;
    }

    public static final long commonWriteAll(C5052Buffer c5052Buffer, InterfaceC5062Source source) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long jMo2305read = source.mo2305read(c5052Buffer, 8192L);
            if (jMo2305read == -1) {
                return j;
            }
            j += jMo2305read;
        }
    }

    public static final C5052Buffer commonWriteByte(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(1);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        c5059SegmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 1);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteDecimalLong(C5052Buffer c5052Buffer, long j) {
        boolean z;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j == 0) {
            return c5052Buffer.writeByte(48);
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return c5052Buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        int iCountDigitsIn = countDigitsIn(j);
        if (z) {
            iCountDigitsIn++;
        }
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(iCountDigitsIn);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit + iCountDigitsIn;
        while (j != 0) {
            long j2 = 10;
            i--;
            bArr[i] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i - 1] = 45;
        }
        c5059SegmentWritableSegment$okio.limit += iCountDigitsIn;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + iCountDigitsIn);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteHexadecimalUnsignedLong(C5052Buffer c5052Buffer, long j) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j == 0) {
            return c5052Buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(i);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        c5059SegmentWritableSegment$okio.limit += i;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + i);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteInt(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(4);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        c5059SegmentWritableSegment$okio.limit = i2 + 4;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 4);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteLong(C5052Buffer c5052Buffer, long j) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(8);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i = c5059SegmentWritableSegment$okio.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        c5059SegmentWritableSegment$okio.limit = i + 8;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 8);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteShort(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(2);
        byte[] bArr = c5059SegmentWritableSegment$okio.data;
        int i2 = c5059SegmentWritableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        c5059SegmentWritableSegment$okio.limit = i2 + 2;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 2);
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteUtf8(C5052Buffer c5052Buffer, String string, int i, int i2) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
        }
        while (i < i2) {
            char cCharAt2 = string.charAt(i);
            if (cCharAt2 < 128) {
                C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(1);
                byte[] bArr = c5059SegmentWritableSegment$okio.data;
                int i3 = c5059SegmentWritableSegment$okio.limit - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = string.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = c5059SegmentWritableSegment$okio.limit;
                int i6 = (i3 + i) - i5;
                c5059SegmentWritableSegment$okio.limit = i5 + i6;
                c5052Buffer.setSize$okio(c5052Buffer.m14225size() + i6);
            } else {
                if (cCharAt2 < 2048) {
                    C5059Segment c5059SegmentWritableSegment$okio2 = c5052Buffer.writableSegment$okio(2);
                    byte[] bArr2 = c5059SegmentWritableSegment$okio2.data;
                    int i7 = c5059SegmentWritableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c5059SegmentWritableSegment$okio2.limit = i7 + 2;
                    c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    C5059Segment c5059SegmentWritableSegment$okio3 = c5052Buffer.writableSegment$okio(3);
                    byte[] bArr3 = c5059SegmentWritableSegment$okio3.data;
                    int i8 = c5059SegmentWritableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | InterfaceC5102BERTags.f17976FLAGS);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c5059SegmentWritableSegment$okio3.limit = i8 + 3;
                    c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 3);
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? string.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        c5052Buffer.writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + PKIFailureInfo.notAuthorized;
                        C5059Segment c5059SegmentWritableSegment$okio4 = c5052Buffer.writableSegment$okio(4);
                        byte[] bArr4 = c5059SegmentWritableSegment$okio4.data;
                        int i11 = c5059SegmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        c5059SegmentWritableSegment$okio4.limit = i11 + 4;
                        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return c5052Buffer;
    }

    public static final C5052Buffer commonWriteUtf8CodePoint(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (i < 128) {
            c5052Buffer.writeByte(i);
        } else if (i < 2048) {
            C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(2);
            byte[] bArr = c5059SegmentWritableSegment$okio.data;
            int i2 = c5059SegmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            c5059SegmentWritableSegment$okio.limit = i2 + 2;
            c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 2);
        } else if (55296 <= i && i < 57344) {
            c5052Buffer.writeByte(63);
        } else if (i < 65536) {
            C5059Segment c5059SegmentWritableSegment$okio2 = c5052Buffer.writableSegment$okio(3);
            byte[] bArr2 = c5059SegmentWritableSegment$okio2.data;
            int i3 = c5059SegmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | InterfaceC5102BERTags.f17976FLAGS);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            c5059SegmentWritableSegment$okio2.limit = i3 + 3;
            c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i));
            }
            C5059Segment c5059SegmentWritableSegment$okio3 = c5052Buffer.writableSegment$okio(4);
            byte[] bArr3 = c5059SegmentWritableSegment$okio3.data;
            int i4 = c5059SegmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            c5059SegmentWritableSegment$okio3.limit = i4 + 4;
            c5052Buffer.setSize$okio(c5052Buffer.m14225size() + 4);
        }
        return c5052Buffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countDigitsIn(long j) {
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        return iNumberOfLeadingZeros + (j > DigitCountToLargestValue[iNumberOfLeadingZeros] ? 1 : 0);
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(C5059Segment segment, int i, byte[] bytes, int i2, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != bytes[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (c5052Buffer.m14205getByte(j2) == 13) {
                String utf8 = c5052Buffer.readUtf8(j2);
                c5052Buffer.mo14226skip(2L);
                return utf8;
            }
        }
        String utf82 = c5052Buffer.readUtf8(j);
        c5052Buffer.mo14226skip(1L);
        return utf82;
    }

    /* renamed from: seek */
    public static final <T> T m14400seek(C5052Buffer c5052Buffer, long j, Function2<? super C5059Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment == null) {
            return lambda.mo2167invoke(null, -1L);
        }
        if (c5052Buffer.m14225size() - j < j) {
            long jM14225size = c5052Buffer.m14225size();
            while (jM14225size > j) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size -= c5059Segment.limit - c5059Segment.pos;
            }
            return lambda.mo2167invoke(c5059Segment, Long.valueOf(jM14225size));
        }
        long j2 = 0;
        while (true) {
            long j3 = (c5059Segment.limit - c5059Segment.pos) + j2;
            if (j3 > j) {
                return lambda.mo2167invoke(c5059Segment, Long.valueOf(j2));
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            j2 = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        if (r19 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int selectPrefix(C5052Buffer c5052Buffer, C5054Options options, boolean z) {
        int i;
        int i2;
        C5059Segment c5059Segment;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        C5059Segment c5059Segment2 = c5052Buffer.head;
        if (c5059Segment2 != null) {
            byte[] bArr = c5059Segment2.data;
            int i5 = c5059Segment2.pos;
            int i6 = c5059Segment2.limit;
            int[] trie$okio = options.getTrie();
            C5059Segment c5059Segment3 = c5059Segment2;
            int i7 = -1;
            int i8 = 0;
            loop0: while (true) {
                int i9 = i8 + 1;
                int i10 = trie$okio[i8];
                int i11 = i8 + 2;
                int i12 = trie$okio[i9];
                if (i12 != -1) {
                    i7 = i12;
                }
                if (c5059Segment3 == null) {
                    break;
                }
                if (i10 >= 0) {
                    i = i5 + 1;
                    int i13 = bArr[i5] & C1126UByte.MAX_VALUE;
                    int i14 = i11 + i10;
                    while (i11 != i14) {
                        if (i13 == trie$okio[i11]) {
                            i2 = trie$okio[i11 + i10];
                            if (i == i6) {
                                c5059Segment3 = c5059Segment3.next;
                                Intrinsics.checkNotNull(c5059Segment3);
                                i = c5059Segment3.pos;
                                bArr = c5059Segment3.data;
                                i6 = c5059Segment3.limit;
                                if (c5059Segment3 == c5059Segment2) {
                                    c5059Segment3 = null;
                                }
                            }
                        } else {
                            i11++;
                        }
                    }
                    return i7;
                }
                int i15 = i11 + (i10 * (-1));
                while (true) {
                    int i16 = i5 + 1;
                    int i17 = i11 + 1;
                    if ((bArr[i5] & C1126UByte.MAX_VALUE) != trie$okio[i11]) {
                        return i7;
                    }
                    boolean z2 = i17 == i15;
                    if (i16 == i6) {
                        Intrinsics.checkNotNull(c5059Segment3);
                        C5059Segment c5059Segment4 = c5059Segment3.next;
                        Intrinsics.checkNotNull(c5059Segment4);
                        i4 = c5059Segment4.pos;
                        byte[] bArr2 = c5059Segment4.data;
                        i3 = c5059Segment4.limit;
                        if (c5059Segment4 != c5059Segment2) {
                            c5059Segment = c5059Segment4;
                            bArr = bArr2;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            c5059Segment = null;
                        }
                    } else {
                        c5059Segment = c5059Segment3;
                        i3 = i6;
                        i4 = i16;
                    }
                    if (z2) {
                        i2 = trie$okio[i17];
                        i = i4;
                        i6 = i3;
                        c5059Segment3 = c5059Segment;
                        break;
                    }
                    i5 = i4;
                    i6 = i3;
                    c5059Segment3 = c5059Segment;
                    i11 = i17;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i8 = -i2;
                i5 = i;
            }
        } else {
            return z ? -2 : -1;
        }
    }

    public static /* synthetic */ int selectPrefix$default(C5052Buffer c5052Buffer, C5054Options c5054Options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(c5052Buffer, c5054Options, z);
    }

    public static final int commonRead(C5052Buffer c5052Buffer, byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i, i2);
        C5059Segment c5059Segment = c5052Buffer.head;
        if (c5059Segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, c5059Segment.limit - c5059Segment.pos);
        byte[] bArr = c5059Segment.data;
        int i3 = c5059Segment.pos;
        ArraysKt.copyInto(bArr, sink, i, i3, i3 + iMin);
        c5059Segment.pos += iMin;
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() - iMin);
        if (c5059Segment.pos == c5059Segment.limit) {
            c5052Buffer.head = c5059Segment.m14380pop();
            SegmentPool.m14384recycle(c5059Segment);
        }
        return iMin;
    }

    public static final byte[] commonReadByteArray(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (c5052Buffer.m14225size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        c5052Buffer.readFully(bArr);
        return bArr;
    }

    public static final ByteString commonReadByteString(C5052Buffer c5052Buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (c5052Buffer.m14225size() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(c5052Buffer.readByteArray(j));
        }
        ByteString byteStringSnapshot = c5052Buffer.snapshot((int) j);
        c5052Buffer.mo14226skip(j);
        return byteStringSnapshot;
    }

    public static final C5052Buffer commonWrite(C5052Buffer c5052Buffer, byte[] source) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return c5052Buffer.mo14231write(source, 0, source.length);
    }

    public static final C5052Buffer commonWrite(C5052Buffer c5052Buffer, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            C5059Segment c5059SegmentWritableSegment$okio = c5052Buffer.writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - c5059SegmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            ArraysKt.copyInto(source, c5059SegmentWritableSegment$okio.data, c5059SegmentWritableSegment$okio.limit, i, i4);
            c5059SegmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        c5052Buffer.setSize$okio(c5052Buffer.m14225size() + j);
        return c5052Buffer;
    }

    public static final void commonReadFully(C5052Buffer c5052Buffer, C5052Buffer sink, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (c5052Buffer.m14225size() >= j) {
            sink.mo2303write(c5052Buffer, j);
        } else {
            sink.mo2303write(c5052Buffer, c5052Buffer.m14225size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(C5052Buffer c5052Buffer, int i) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        if (i == 0) {
            return ByteString.f17785EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(c5052Buffer.m14225size(), 0L, i);
        C5059Segment c5059Segment = c5052Buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(c5059Segment);
            int i5 = c5059Segment.limit;
            int i6 = c5059Segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                c5059Segment = c5059Segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        C5059Segment c5059Segment2 = c5052Buffer.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(c5059Segment2);
            bArr[i7] = c5059Segment2.data;
            i2 += c5059Segment2.limit - c5059Segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = c5059Segment2.pos;
            c5059Segment2.shared = true;
            i7++;
            c5059Segment2 = c5059Segment2.next;
        }
        return new C6370SegmentedByteString(bArr, iArr);
    }

    public static final C5052Buffer commonWrite(C5052Buffer c5052Buffer, InterfaceC5062Source source, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long jMo2305read = source.mo2305read(c5052Buffer, j);
            if (jMo2305read == -1) {
                throw new EOFException();
            }
            j -= jMo2305read;
        }
        return c5052Buffer;
    }

    public static final long commonRead(C5052Buffer c5052Buffer, C5052Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (c5052Buffer.m14225size() == 0) {
            return -1L;
        }
        if (j > c5052Buffer.m14225size()) {
            j = c5052Buffer.m14225size();
        }
        sink.mo2303write(c5052Buffer, j);
        return j;
    }

    public static final void commonWrite(C5052Buffer c5052Buffer, C5052Buffer source, long j) {
        C5059Segment c5059Segment;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != c5052Buffer) {
            SegmentedByteString.checkOffsetAndCount(source.m14225size(), 0L, j);
            while (j > 0) {
                C5059Segment c5059Segment2 = source.head;
                Intrinsics.checkNotNull(c5059Segment2);
                int i = c5059Segment2.limit;
                Intrinsics.checkNotNull(source.head);
                if (j < i - r1.pos) {
                    C5059Segment c5059Segment3 = c5052Buffer.head;
                    if (c5059Segment3 != null) {
                        Intrinsics.checkNotNull(c5059Segment3);
                        c5059Segment = c5059Segment3.prev;
                    } else {
                        c5059Segment = null;
                    }
                    if (c5059Segment != null && c5059Segment.owner) {
                        if ((c5059Segment.limit + j) - (c5059Segment.shared ? 0 : c5059Segment.pos) <= 8192) {
                            C5059Segment c5059Segment4 = source.head;
                            Intrinsics.checkNotNull(c5059Segment4);
                            c5059Segment4.m14383writeTo(c5059Segment, (int) j);
                            source.setSize$okio(source.m14225size() - j);
                            c5052Buffer.setSize$okio(c5052Buffer.m14225size() + j);
                            return;
                        }
                    }
                    C5059Segment c5059Segment5 = source.head;
                    Intrinsics.checkNotNull(c5059Segment5);
                    source.head = c5059Segment5.m14382split((int) j);
                }
                C5059Segment c5059Segment6 = source.head;
                Intrinsics.checkNotNull(c5059Segment6);
                long j2 = c5059Segment6.limit - c5059Segment6.pos;
                source.head = c5059Segment6.m14380pop();
                C5059Segment c5059Segment7 = c5052Buffer.head;
                if (c5059Segment7 == null) {
                    c5052Buffer.head = c5059Segment6;
                    c5059Segment6.prev = c5059Segment6;
                    c5059Segment6.next = c5059Segment6;
                } else {
                    Intrinsics.checkNotNull(c5059Segment7);
                    C5059Segment c5059Segment8 = c5059Segment7.prev;
                    Intrinsics.checkNotNull(c5059Segment8);
                    c5059Segment8.m14381push(c5059Segment6).m14379compact();
                }
                source.setSize$okio(source.m14225size() - j2);
                c5052Buffer.setSize$okio(c5052Buffer.m14225size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public static final long commonIndexOf(C5052Buffer c5052Buffer, ByteString bytes, long j, long j2, int i, int i2) {
        C5059Segment c5059Segment;
        int i3;
        long j3 = j;
        long jM14225size = j2;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j4 = i2;
        SegmentedByteString.checkOffsetAndCount(bytes.m14252size(), i, j4);
        if (i2 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long jM14225size2 = 0;
        if (j3 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        if (j3 > jM14225size) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j3 + " > " + jM14225size).toString());
        }
        if (jM14225size > c5052Buffer.m14225size()) {
            jM14225size = c5052Buffer.m14225size();
        }
        long j5 = -1;
        if (j3 == jM14225size || (c5059Segment = c5052Buffer.head) == null) {
            return -1L;
        }
        if (c5052Buffer.m14225size() - j3 < j3) {
            jM14225size2 = c5052Buffer.m14225size();
            while (jM14225size2 > j3) {
                c5059Segment = c5059Segment.prev;
                Intrinsics.checkNotNull(c5059Segment);
                jM14225size2 -= c5059Segment.limit - c5059Segment.pos;
            }
            byte[] bArrInternalArray$okio = bytes.internalArray$okio();
            byte b = bArrInternalArray$okio[i];
            long jMin = Math.min(jM14225size, (c5052Buffer.m14225size() - j4) + 1);
            while (jM14225size2 < jMin) {
                byte[] bArr = c5059Segment.data;
                int iMin = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + jMin) - jM14225size2);
                i3 = (int) ((c5059Segment.pos + j3) - jM14225size2);
                while (i3 < iMin) {
                    if (bArr[i3] != b || !rangeEquals(c5059Segment, i3 + 1, bArrInternalArray$okio, i + 1, i2)) {
                        i3++;
                    }
                }
                jM14225size2 += c5059Segment.limit - c5059Segment.pos;
                c5059Segment = c5059Segment.next;
                Intrinsics.checkNotNull(c5059Segment);
                j3 = jM14225size2;
                j5 = -1;
            }
            return j5;
        }
        while (true) {
            long j6 = (c5059Segment.limit - c5059Segment.pos) + jM14225size2;
            if (j6 > j3) {
                break;
            }
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jM14225size2 = j6;
        }
        byte[] bArrInternalArray$okio2 = bytes.internalArray$okio();
        byte b2 = bArrInternalArray$okio2[i];
        long jMin2 = Math.min(jM14225size, (c5052Buffer.m14225size() - j4) + 1);
        while (jM14225size2 < jMin2) {
            byte[] bArr2 = c5059Segment.data;
            long j7 = jMin2;
            int iMin2 = (int) Math.min(c5059Segment.limit, (c5059Segment.pos + jMin2) - jM14225size2);
            i3 = (int) ((c5059Segment.pos + j3) - jM14225size2);
            while (i3 < iMin2) {
                if (bArr2[i3] != b2 || !rangeEquals(c5059Segment, i3 + 1, bArrInternalArray$okio2, i + 1, i2)) {
                    i3++;
                }
            }
            jM14225size2 += c5059Segment.limit - c5059Segment.pos;
            c5059Segment = c5059Segment.next;
            Intrinsics.checkNotNull(c5059Segment);
            jMin2 = j7;
            j3 = jM14225size2;
        }
        return -1L;
        return (i3 - c5059Segment.pos) + jM14225size2;
    }
}
