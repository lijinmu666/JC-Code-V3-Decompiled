package p132okio.internal;

import java.io.EOFException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.C1302CharsKt;
import p094kotlin.p117text.Typography;
import p132okio.BufferedSource;
import p132okio.ByteString;
import p132okio.C5052Buffer;
import p132okio.C5053Okio;
import p132okio.C5054Options;
import p132okio.C5065Timeout;
import p132okio.InterfaceC5060Sink;
import p132okio.PeekSource;
import p132okio.SegmentedByteString;
import p132okio.buffer;

@Metadata(m4987d1 = {"\u0000h\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0080\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0080\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0000\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0080\b\u001a\r\u0010!\u001a\u00020 *\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010'\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\u0015\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0080\b\u001a%\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0080\b\u001a:\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u0001H\u0000\u001a4\u0010/\u001a\u00020\u0007*\u00020\u00042\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0002\u001a\u001d\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00101\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0001H\u0080\b\u001a-\u00102\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010H\u0080\b\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0080\b\u001a\r\u00105\u001a\u00020\t*\u00020\u0002H\u0080\b\u001a\r\u00106\u001a\u000207*\u00020\u0002H\u0080\b\u001a\r\u00108\u001a\u00020\u001a*\u00020\u0002H\u0080\b¨\u00069"}, m4988d2 = {"commonRead", BuildConfig.f24315FLAVOR, "Lokio/RealBufferedSource;", "sink", "Lokio/Buffer;", "byteCount", "commonExhausted", BuildConfig.f24315FLAVOR, "commonRequire", BuildConfig.f24315FLAVOR, "commonRequest", "commonReadByte", BuildConfig.f24315FLAVOR, "commonReadByteString", "Lokio/ByteString;", "commonSelect", BuildConfig.f24315FLAVOR, "options", "Lokio/Options;", "commonReadByteArray", BuildConfig.f24315FLAVOR, "commonReadFully", "offset", "commonReadAll", "Lokio/Sink;", "commonReadUtf8", BuildConfig.f24315FLAVOR, "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonReadShort", BuildConfig.f24315FLAVOR, "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "commonIndexOf", "b", "fromIndex", "toIndex", "bytes", "bytesOffset", "isMatchPossibleByExpandingBuffer", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonPeek", "Lokio/BufferedSource;", "commonClose", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-RealBufferedSource")
@SourceDebugExtension(m6344value = {"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,472:1\n1#2:473\n63#3:474\n63#3:475\n63#3:476\n63#3:477\n63#3:478\n63#3:479\n63#3:480\n63#3:481\n63#3:482\n63#3:483\n63#3:484\n63#3:485\n63#3:486\n63#3:487\n63#3:488\n63#3:489\n63#3:490\n63#3:491\n63#3:492\n63#3:493\n63#3:494\n63#3:495\n63#3:496\n63#3:498\n63#3:499\n63#3:500\n63#3:501\n63#3:502\n63#3:503\n63#3:504\n63#3:505\n63#3:506\n63#3:507\n63#3:508\n63#3:509\n63#3:510\n63#3:511\n63#3:512\n63#3:513\n63#3:514\n63#3:515\n63#3:516\n63#3:517\n63#3:519\n63#3:520\n63#3:521\n63#3:522\n63#3:523\n63#3:524\n63#3:525\n63#3:526\n63#3:527\n63#3:528\n63#3:529\n63#3:530\n63#3:531\n63#3:532\n63#3:533\n63#3:534\n63#3:535\n63#3:536\n63#3:537\n63#3:538\n63#3:539\n63#3:540\n63#3:541\n63#3:543\n63#3:544\n63#3:545\n63#3:546\n90#4:497\n90#4:518\n90#4:542\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n*L\n42#1:474\n44#1:475\n48#1:476\n49#1:477\n54#1:478\n64#1:479\n65#1:480\n72#1:481\n76#1:482\n77#1:483\n82#1:484\n89#1:485\n96#1:486\n101#1:487\n109#1:488\n110#1:489\n115#1:490\n124#1:491\n125#1:492\n132#1:493\n138#1:494\n140#1:495\n144#1:496\n145#1:498\n153#1:499\n157#1:500\n162#1:501\n163#1:502\n166#1:503\n169#1:504\n170#1:505\n171#1:506\n177#1:507\n178#1:508\n183#1:509\n190#1:510\n191#1:511\n196#1:512\n204#1:513\n206#1:514\n207#1:515\n209#1:516\n212#1:517\n214#1:519\n222#1:520\n229#1:521\n234#1:522\n239#1:523\n244#1:524\n249#1:525\n254#1:526\n259#1:527\n267#1:528\n278#1:529\n286#1:530\n300#1:531\n307#1:532\n310#1:533\n311#1:534\n322#1:535\n327#1:536\n328#1:537\n349#1:538\n358#1:539\n362#1:540\n372#1:541\n425#1:543\n428#1:544\n429#1:545\n466#1:546\n144#1:497\n212#1:518\n406#1:542\n*E\n"})
/* renamed from: okio.internal.-RealBufferedSource, reason: invalid class name */
/* loaded from: classes.dex */
public final class RealBufferedSource {
    public static final void commonClose(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.closed) {
            return;
        }
        bufferVar.closed = true;
        bufferVar.source.close();
        bufferVar.bufferField.m14194clear();
    }

    public static final boolean commonExhausted(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        return bufferVar.bufferField.exhausted() && bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1;
    }

    public static final long commonIndexOf(buffer bufferVar, byte b, long j, long j2) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jMo14208indexOf = bufferVar.bufferField.mo14208indexOf(b, j, j2);
            if (jMo14208indexOf != -1) {
                return jMo14208indexOf;
            }
            long jM14225size = bufferVar.bufferField.m14225size();
            if (jM14225size >= j2 || bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                break;
            }
            j = Math.max(j, jM14225size);
        }
        return -1L;
    }

    public static final long commonIndexOfElement(buffer bufferVar, ByteString targetBytes, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = bufferVar.bufferField.indexOfElement(targetBytes, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long jM14225size = bufferVar.bufferField.m14225size();
            if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, jM14225size);
        }
    }

    public static final BufferedSource commonPeek(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return C5053Okio.m14316buffer(new PeekSource(bufferVar));
    }

    public static final boolean commonRangeEquals(buffer bufferVar, long j, ByteString bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        if (i2 >= 0 && j >= 0 && i >= 0 && i + i2 <= bytes.m14252size()) {
            return i2 == 0 || commonIndexOf(bufferVar, bytes, i, i2, j, j + 1) != -1;
        }
        return false;
    }

    public static final long commonRead(buffer bufferVar, C5052Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        if (bufferVar.bufferField.m14225size() == 0) {
            if (j == 0) {
                return 0L;
            }
            if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return bufferVar.bufferField.mo2305read(sink, Math.min(j, bufferVar.bufferField.m14225size()));
    }

    public static final long commonReadAll(buffer bufferVar, InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) != -1) {
            long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.mo2303write(bufferVar.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (bufferVar.bufferField.m14225size() <= 0) {
            return j;
        }
        long jM14225size = j + bufferVar.bufferField.m14225size();
        C5052Buffer c5052Buffer = bufferVar.bufferField;
        sink.mo2303write(c5052Buffer, c5052Buffer.m14225size());
        return jM14225size;
    }

    public static final byte commonReadByte(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(1L);
        return bufferVar.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(j);
        return bufferVar.bufferField.readByteArray(j);
    }

    public static final ByteString commonReadByteString(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(j);
        return bufferVar.bufferField.readByteString(j);
    }

    public static final long commonReadDecimalLong(buffer bufferVar) throws EOFException {
        byte bM14205getByte;
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!bufferVar.mo14218request(j2)) {
                break;
            }
            bM14205getByte = bufferVar.bufferField.m14205getByte(j);
            if ((bM14205getByte < 48 || bM14205getByte > 57) && !(j == 0 && bM14205getByte == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bM14205getByte, C1302CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return bufferVar.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(buffer bufferVar, byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            bufferVar.mo14219require(sink.length);
            bufferVar.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (bufferVar.bufferField.m14225size() > 0) {
                C5052Buffer c5052Buffer = bufferVar.bufferField;
                int iMo14215read = c5052Buffer.mo14215read(sink, i, (int) c5052Buffer.m14225size());
                if (iMo14215read == -1) {
                    throw new AssertionError();
                }
                i += iMo14215read;
            }
            throw e;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(buffer bufferVar) throws EOFException {
        byte bM14205getByte;
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!bufferVar.mo14218request(i2)) {
                break;
            }
            bM14205getByte = bufferVar.bufferField.m14205getByte(i);
            if ((bM14205getByte < 48 || bM14205getByte > 57) && ((bM14205getByte < 97 || bM14205getByte > 102) && (bM14205getByte < 65 || bM14205getByte > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bM14205getByte, C1302CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return bufferVar.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(4L);
        return bufferVar.bufferField.mo14217readInt();
    }

    public static final int commonReadIntLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(4L);
        return bufferVar.bufferField.readIntLe();
    }

    public static final long commonReadLong(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(8L);
        return bufferVar.bufferField.readLong();
    }

    public static final long commonReadLongLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(8L);
        return bufferVar.bufferField.readLongLe();
    }

    public static final short commonReadShort(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(2L);
        return bufferVar.bufferField.readShort();
    }

    public static final short commonReadShortLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(2L);
        return bufferVar.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(j);
        return bufferVar.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.mo14219require(1L);
        byte bM14205getByte = bufferVar.bufferField.m14205getByte(0L);
        if ((bM14205getByte & 224) == 192) {
            bufferVar.mo14219require(2L);
        } else if ((bM14205getByte & 240) == 224) {
            bufferVar.mo14219require(3L);
        } else if ((bM14205getByte & 248) == 240) {
            bufferVar.mo14219require(4L);
        }
        return bufferVar.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        long jMo14206indexOf = bufferVar.mo14206indexOf((byte) 10);
        if (jMo14206indexOf != -1) {
            return C5067Buffer.readUtf8Line(bufferVar.bufferField, jMo14206indexOf);
        }
        if (bufferVar.bufferField.m14225size() != 0) {
            return bufferVar.readUtf8(bufferVar.bufferField.m14225size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jMo14208indexOf = bufferVar.mo14208indexOf((byte) 10, 0L, j2);
        if (jMo14208indexOf != -1) {
            return C5067Buffer.readUtf8Line(bufferVar.bufferField, jMo14208indexOf);
        }
        if (j2 < LongCompanionObject.MAX_VALUE && bufferVar.mo14218request(j2) && bufferVar.bufferField.m14205getByte(j2 - 1) == 13 && bufferVar.mo14218request(1 + j2) && bufferVar.bufferField.m14205getByte(j2) == 10) {
            return C5067Buffer.readUtf8Line(bufferVar.bufferField, j2);
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        C5052Buffer c5052Buffer2 = bufferVar.bufferField;
        c5052Buffer2.m14202copyTo(c5052Buffer, 0L, Math.min(32, c5052Buffer2.m14225size()));
        throw new EOFException("\\n not found: limit=" + Math.min(bufferVar.bufferField.m14225size(), j) + " content=" + c5052Buffer.readByteString().mo14243hex() + Typography.ellipsis);
    }

    public static final boolean commonRequest(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        while (bufferVar.bufferField.m14225size() < j) {
            if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (!bufferVar.mo14218request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(buffer bufferVar, C5054Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = C5067Buffer.selectPrefix(bufferVar.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                bufferVar.bufferField.mo14226skip(options.getByteStrings()[iSelectPrefix].m14252size());
                return iSelectPrefix;
            }
        } while (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) != -1);
        return -1;
    }

    public static final void commonSkip(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (bufferVar.bufferField.m14225size() == 0 && bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, bufferVar.bufferField.m14225size());
            bufferVar.bufferField.mo14226skip(jMin);
            j -= jMin;
        }
    }

    public static final C5065Timeout commonTimeout(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return bufferVar.source.getTimeout();
    }

    public static final String commonToString(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return "buffer(" + bufferVar.source + ')';
    }

    private static final boolean isMatchPossibleByExpandingBuffer(C5052Buffer c5052Buffer, ByteString byteString, int i, int i2, long j, long j2) {
        if (c5052Buffer.m14225size() < j2) {
            return true;
        }
        int iMax = (int) Math.max(1L, (c5052Buffer.m14225size() - j2) + 1);
        int iMin = ((int) Math.min(i2, (c5052Buffer.m14225size() - j) + 1)) - 1;
        if (iMax > iMin) {
            return false;
        }
        while (!c5052Buffer.rangeEquals(c5052Buffer.m14225size() - iMin, byteString, i, iMin)) {
            if (iMin == iMax) {
                return false;
            }
            iMin--;
        }
        return true;
    }

    public static final byte[] commonReadByteArray(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteString();
    }

    public static final String commonReadUtf8(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readUtf8();
    }

    public static final void commonReadFully(buffer bufferVar, C5052Buffer sink, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            bufferVar.mo14219require(j);
            bufferVar.bufferField.readFully(sink, j);
        } catch (EOFException e) {
            sink.writeAll(bufferVar.bufferField);
            throw e;
        }
    }

    public static final long commonIndexOf(buffer bufferVar, ByteString bytes, int i, int i2, long j, long j2) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long j3 = i2;
        SegmentedByteString.checkOffsetAndCount(bytes.m14252size(), i, j3);
        if (bufferVar.closed) {
            throw new IllegalStateException("closed");
        }
        long jMax = j;
        while (true) {
            long jCommonIndexOf = C5067Buffer.commonIndexOf(bufferVar.bufferField, bytes, jMax, j2, i, i2);
            if (jCommonIndexOf != -1) {
                return jCommonIndexOf;
            }
            long jM14225size = (bufferVar.bufferField.m14225size() - j3) + 1;
            if (jM14225size >= j2 || !isMatchPossibleByExpandingBuffer(bufferVar.bufferField, bytes, i, i2, jMax, j2) || bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, jM14225size);
        }
    }

    public static final int commonRead(buffer bufferVar, byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(sink.length, i, j);
        if (bufferVar.bufferField.m14225size() == 0) {
            if (i2 == 0) {
                return 0;
            }
            if (bufferVar.source.mo2305read(bufferVar.bufferField, 8192L) == -1) {
                return -1;
            }
        }
        return bufferVar.bufferField.mo14215read(sink, i, (int) Math.min(j, bufferVar.bufferField.m14225size()));
    }
}
