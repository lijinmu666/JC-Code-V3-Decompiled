package p132okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.internal.SegmentedByteString;

@Metadata(m4987d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0001H\u0016J\b\u0010\u0015\u001a\u00020\u0001H\u0016J\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0018J\u001d\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u001c\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0016J\u0015\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fH\u0010¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u001fH\u0010¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J%\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0010¢\u0006\u0002\b2J(\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J(\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J,\u00107\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J\u001a\u0010:\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u001fH\u0016J\u001a\u0010<\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020\u0001H\u0002J\r\u0010>\u001a\u00020\u0004H\u0010¢\u0006\u0002\b?J\u0013\u0010@\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010AH\u0096\u0002J\b\u0010B\u001a\u00020\u001fH\u0016J\b\u0010C\u001a\u00020\u000fH\u0016J\b\u0010D\u001a\u00020EH\u0002R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006F"}, m4988d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "directory", BuildConfig.f24315FLAVOR, "<init>", "([[B[I)V", "getSegments$okio", "()[[B", "[[B", "getDirectory$okio", "()[I", "string", BuildConfig.f24315FLAVOR, "charset", "Ljava/nio/charset/Charset;", "base64", "hex", "toAsciiLowercase", "toAsciiUppercase", CMSAttributeTableGenerator.f18937DIGEST, "algorithm", "digest$okio", "hmac", "key", "hmac$okio", "base64Url", "substring", "beginIndex", BuildConfig.f24315FLAVOR, "endIndex", "internalGet", BuildConfig.f24315FLAVOR, "pos", "internalGet$okio", "getSize", "getSize$okio", "toByteArray", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", BuildConfig.f24315FLAVOR, "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", BuildConfig.f24315FLAVOR, "other", "otherOffset", "copyInto", "target", "targetOffset", "indexOf", "fromIndex", "lastIndexOf", "toByteString", "internalArray", "internalArray$okio", "equals", BuildConfig.f24315FLAVOR, "hashCode", "toString", "writeReplace", "Ljava/lang/Object;", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n62#2,12:141\n62#2,12:153\n103#2:165\n104#2,26:167\n133#2,5:193\n140#2:198\n143#2,3:199\n62#2,8:202\n146#2,8:210\n70#2,4:218\n154#2:222\n62#2,12:223\n158#2:235\n84#2,10:236\n159#2,9:246\n94#2,4:255\n168#2,2:259\n177#2,4:261\n84#2,10:265\n181#2,3:275\n94#2,4:278\n184#2:282\n193#2,8:283\n84#2,10:291\n201#2,3:301\n94#2,4:304\n204#2:308\n213#2,5:309\n84#2,10:314\n218#2,3:324\n94#2,4:327\n221#2:331\n224#2,4:332\n232#2,6:336\n62#2,8:342\n238#2,7:350\n70#2,4:357\n245#2,2:361\n1#3:166\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165\n78#1:167,26\n80#1:193,5\n82#1:198\n84#1:199,3\n84#1:202,8\n84#1:210,8\n84#1:218,4\n84#1:222\n90#1:223,12\n96#1:235\n96#1:236,10\n96#1:246,9\n96#1:255,4\n96#1:259,2\n103#1:261,4\n103#1:265,10\n103#1:275,3\n103#1:278,4\n103#1:282\n110#1:283,8\n110#1:291,10\n110#1:301,3\n110#1:304,4\n110#1:308\n117#1:309,5\n117#1:314,10\n117#1:324,3\n117#1:327,4\n117#1:331\n131#1:332,4\n133#1:336,6\n133#1:342,8\n133#1:350,7\n133#1:357,4\n133#1:361,2\n78#1:166\n*E\n"})
/* renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6370SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6370SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f17785EMPTY.getData());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        Intrinsics.checkNotNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // p132okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // p132okio.ByteString
    /* renamed from: base64 */
    public String mo14240base64() {
        return toByteString().mo14240base64();
    }

    @Override // p132okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // p132okio.ByteString
    public void copyInto(int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        long j = byteCount;
        SegmentedByteString.checkOffsetAndCount(m14252size(), offset, j);
        SegmentedByteString.checkOffsetAndCount(target.length, targetOffset, j);
        int i = byteCount + offset;
        int iM14404segment = SegmentedByteString.m14404segment(this, offset);
        while (offset < i) {
            int i2 = iM14404segment == 0 ? 0 : getDirectory()[iM14404segment - 1];
            int i3 = getDirectory()[iM14404segment] - i2;
            int i4 = getDirectory()[getSegments().length + iM14404segment];
            int iMin = Math.min(i, i3 + i2) - offset;
            int i5 = i4 + (offset - i2);
            ArraysKt.copyInto(getSegments()[iM14404segment], target, targetOffset, i5, i5 + iMin);
            targetOffset += iMin;
            offset += iMin;
            iM14404segment++;
        }
    }

    @Override // p132okio.ByteString
    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            messageDigest.update(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNull(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // p132okio.ByteString
    /* renamed from: equals */
    public boolean mo14241equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.m14252size() == m14252size() && rangeEquals(0, byteString, 0, m14252size())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    /* renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // p132okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // p132okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            byte[] bArr = getSegments()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        setHashCode$okio(i2);
        return i2;
    }

    @Override // p132okio.ByteString
    /* renamed from: hex */
    public String mo14243hex() {
        return toByteString().mo14243hex();
    }

    @Override // p132okio.ByteString
    public ByteString hmac$okio(String algorithm, ByteString key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory()[length + i];
                int i4 = getDirectory()[i];
                mac.update(getSegments()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // p132okio.ByteString
    /* renamed from: indexOf */
    public int mo14247indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().mo14247indexOf(other, fromIndex);
    }

    @Override // p132okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // p132okio.ByteString
    public byte internalGet$okio(int pos) {
        SegmentedByteString.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int iM14404segment = SegmentedByteString.m14404segment(this, pos);
        return getSegments()[iM14404segment][(pos - (iM14404segment == 0 ? 0 : getDirectory()[iM14404segment - 1])) + getDirectory()[getSegments().length + iM14404segment]];
    }

    @Override // p132okio.ByteString
    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    @Override // p132okio.ByteString
    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > m14252size() - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int iM14404segment = SegmentedByteString.m14404segment(this, offset);
        while (offset < i) {
            int i2 = iM14404segment == 0 ? 0 : getDirectory()[iM14404segment - 1];
            int i3 = getDirectory()[iM14404segment] - i2;
            int i4 = getDirectory()[getSegments().length + iM14404segment];
            int iMin = Math.min(i, i3 + i2) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[iM14404segment], i4 + (offset - i2), iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iM14404segment++;
        }
        return true;
    }

    @Override // p132okio.ByteString
    /* renamed from: string */
    public String mo14253string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().mo14253string(charset);
    }

    @Override // p132okio.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (endIndex > m14252size()) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " > length(" + m14252size() + ')').toString());
        }
        int i = endIndex - beginIndex;
        if (i < 0) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex == m14252size()) {
            return this;
        }
        if (beginIndex == endIndex) {
            return ByteString.f17785EMPTY;
        }
        int iM14404segment = SegmentedByteString.m14404segment(this, beginIndex);
        int iM14404segment2 = SegmentedByteString.m14404segment(this, endIndex - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(getSegments(), iM14404segment, iM14404segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iM14404segment <= iM14404segment2) {
            int i2 = iM14404segment;
            int i3 = 0;
            while (true) {
                iArr[i3] = Math.min(getDirectory()[i2] - beginIndex, i);
                int i4 = i3 + 1;
                iArr[i3 + bArr.length] = getDirectory()[getSegments().length + i2];
                if (i2 == iM14404segment2) {
                    break;
                }
                i2++;
                i3 = i4;
            }
        }
        int i5 = iM14404segment != 0 ? getDirectory()[iM14404segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i5);
        return new C6370SegmentedByteString(bArr, iArr);
    }

    @Override // p132okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // p132okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // p132okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[m14252size()];
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(getSegments()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // p132okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // p132okio.ByteString
    /* renamed from: write */
    public void mo14255write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            out.write(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // p132okio.ByteString
    public void write$okio(C5052Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = offset + byteCount;
        int iM14404segment = SegmentedByteString.m14404segment(this, offset);
        while (offset < i) {
            int i2 = iM14404segment == 0 ? 0 : getDirectory()[iM14404segment - 1];
            int i3 = getDirectory()[iM14404segment] - i2;
            int i4 = getDirectory()[getSegments().length + iM14404segment];
            int iMin = Math.min(i, i3 + i2) - offset;
            int i5 = i4 + (offset - i2);
            C5059Segment c5059Segment = new C5059Segment(getSegments()[iM14404segment], i5, i5 + iMin, true, false);
            C5059Segment c5059Segment2 = buffer.head;
            if (c5059Segment2 == null) {
                c5059Segment.prev = c5059Segment;
                c5059Segment.next = c5059Segment;
                buffer.head = c5059Segment;
            } else {
                Intrinsics.checkNotNull(c5059Segment2);
                C5059Segment c5059Segment3 = c5059Segment2.prev;
                Intrinsics.checkNotNull(c5059Segment3);
                c5059Segment3.m14381push(c5059Segment);
            }
            offset += iMin;
            iM14404segment++;
        }
        buffer.setSize$okio(buffer.m14225size() + byteCount);
    }

    @Override // p132okio.ByteString
    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > m14252size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int iM14404segment = SegmentedByteString.m14404segment(this, offset);
        while (offset < i) {
            int i2 = iM14404segment == 0 ? 0 : getDirectory()[iM14404segment - 1];
            int i3 = getDirectory()[iM14404segment] - i2;
            int i4 = getDirectory()[getSegments().length + iM14404segment];
            int iMin = Math.min(i, i3 + i2) - offset;
            if (!SegmentedByteString.arrayRangeEquals(getSegments()[iM14404segment], i4 + (offset - i2), other, otherOffset, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iM14404segment++;
        }
        return true;
    }
}
