package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;

@CheckReturnValue
/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;

    /* renamed from: EMPTY */
    public static final ByteString f3559EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final ByteArrayCopier byteArrayCopier;

    /* renamed from: hash */
    private int f3560hash = 0;

    public static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i, int i2) {
            super(bArr);
            ByteString.checkRange(i, i + i2, bArr.length);
            this.bytesOffset = i;
            this.bytesLength = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: byteAt */
        public byte mo3937byteAt(int i) {
            ByteString.checkIndex(i, mo3944size());
            return this.f3565bytes[this.bytesOffset + i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f3565bytes, getOffsetIntoBytes() + i, bArr, i2, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public byte internalByteAt(int i) {
            return this.f3565bytes[this.bytesOffset + i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: size */
        public int mo3944size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.m3935wrap(toByteArray());
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i, int i2);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {

        /* renamed from: buffer */
        private final byte[] f3563buffer;

        /* renamed from: output */
        private final CodedOutputStream f3564output;

        /* renamed from: build */
        public ByteString m3948build() {
            this.f3564output.checkNoSpaceLeft();
            return new LiteralByteString(this.f3563buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.f3564output;
        }

        private CodedBuilder(int i) {
            byte[] bArr = new byte[i];
            this.f3563buffer = bArr;
            this.f3564output = CodedOutputStream.newInstance(bArr);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public abstract boolean equalsRange(ByteString byteString, int i, int i2);

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public void writeToReverse(ByteOutput byteOutput) {
            mo3945writeTo(byteOutput);
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: bytes */
        protected final byte[] f3565bytes;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f3565bytes = bArr;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.f3565bytes, getOffsetIntoBytes(), mo3944size()).asReadOnlyBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: byteAt */
        public byte mo3937byteAt(int i) {
            return this.f3565bytes[i];
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: copyTo */
        public final void mo3939copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.f3565bytes, getOffsetIntoBytes(), mo3944size());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f3565bytes, i, bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: equals */
        public final boolean mo3942equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || mo3944size() != ((ByteString) obj).mo3944size()) {
                return false;
            }
            if (mo3944size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int iPeekCachedHashCode = peekCachedHashCode();
            int iPeekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
                return equalsRange(literalByteString, 0, mo3944size());
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString byteString, int i, int i2) {
            if (i2 > byteString.mo3944size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + mo3944size());
            }
            int i3 = i + i2;
            if (i3 > byteString.mo3944size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + byteString.mo3944size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i, i3).mo3942equals(substring(0, i2));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.f3565bytes;
            byte[] bArr2 = literalByteString.f3565bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public byte internalByteAt(int i) {
            return this.f3565bytes[i];
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return C0801Utf8.isValidUtf8(this.f3565bytes, offsetIntoBytes, mo3944size() + offsetIntoBytes);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.f3565bytes, getOffsetIntoBytes(), mo3944size(), true);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.f3565bytes, getOffsetIntoBytes(), mo3944size());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final int partialHash(int i, int i2, int i3) {
            return Internal.partialHash(i, this.f3565bytes, getOffsetIntoBytes() + i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final int partialIsValidUtf8(int i, int i2, int i3) {
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            return C0801Utf8.partialIsValidUtf8(i, this.f3565bytes, offsetIntoBytes, i3 + offsetIntoBytes);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: size */
        public int mo3944size() {
            return this.f3565bytes.length;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final ByteString substring(int i, int i2) {
            int iCheckRange = ByteString.checkRange(i, i2, mo3944size());
            return iCheckRange == 0 ? ByteString.f3559EMPTY : new BoundedByteString(this.f3565bytes, getOffsetIntoBytes() + i, iCheckRange);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.f3565bytes, getOffsetIntoBytes(), mo3944size(), charset);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: writeTo */
        public final void mo3946writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        public final void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
            outputStream.write(this.f3565bytes, getOffsetIntoBytes() + i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
        /* renamed from: writeTo */
        public final void mo3945writeTo(ByteOutput byteOutput) {
            byteOutput.writeLazy(this.f3565bytes, getOffsetIntoBytes(), mo3944size());
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        byteArrayCopier = C0715Android.isOnAndroidDevice() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r3v1, types: [com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? Iterator2 = byteString.iterator2();
                ?? Iterator22 = byteString2.iterator2();
                while (Iterator2.hasNext() && Iterator22.hasNext()) {
                    int iCompareTo = Integer.valueOf(ByteString.m3933toInt(Iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.m3933toInt(Iterator22.nextByte())));
                    if (iCompareTo != 0) {
                        return iCompareTo;
                    }
                }
                return Integer.valueOf(byteString.mo3944size()).compareTo(Integer.valueOf(byteString2.mo3944size()));
            }
        };
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i) {
        if (i < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return balancedConcat(it, i2).m3938concat(balancedConcat(it, i - i2));
    }

    public static void checkIndex(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    @CanIgnoreReturnValue
    public static int checkRange(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        checkRange(i, i + i2, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i, i2));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.f3692UTF_8));
    }

    /* renamed from: empty */
    public static final ByteString m3931empty() {
        return f3559EMPTY;
    }

    private static int extractHexDigit(String str, int i) {
        int iHexDigit = hexDigit(str.charAt(i));
        if (iHexDigit != -1) {
            return iHexDigit;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i) + " at index " + i);
    }

    /* renamed from: fromHex */
    public static ByteString m3932fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 != 0) {
            throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (extractHexDigit(str, i2 + 1) | (extractHexDigit(str, i2) << 4));
        }
        return new LiteralByteString(bArr);
    }

    private static int hexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    public static CodedBuilder newCodedBuilder(int i) {
        return new CodedBuilder(i);
    }

    public static C0726Output newOutput(int i) {
        return new C0726Output(i);
    }

    private static ByteString readChunk(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i2);
    }

    public static ByteString readFrom(InputStream inputStream) {
        return readFrom(inputStream, 256, 8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toInt */
    public static int m3933toInt(byte b) {
        return b & C1126UByte.MAX_VALUE;
    }

    private String truncateAndEscapeForDisplay() {
        if (mo3944size() <= 50) {
            return TextFormatEscaper.escapeBytes(this);
        }
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    /* renamed from: wrap */
    public static ByteString m3934wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return m3936wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    /* renamed from: byteAt */
    public abstract byte mo3937byteAt(int i);

    /* renamed from: concat */
    public final ByteString m3938concat(ByteString byteString) {
        if (Integer.MAX_VALUE - mo3944size() >= byteString.mo3944size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + mo3944size() + "+" + byteString.mo3944size());
    }

    /* renamed from: copyTo */
    public abstract void mo3939copyTo(ByteBuffer byteBuffer);

    /* renamed from: copyTo */
    public void m3940copyTo(byte[] bArr, int i) {
        m3941copyTo(bArr, 0, i, mo3944size());
    }

    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public final boolean endsWith(ByteString byteString) {
        return mo3944size() >= byteString.mo3944size() && substring(mo3944size() - byteString.mo3944size()).mo3942equals(byteString);
    }

    /* renamed from: equals */
    public abstract boolean mo3942equals(Object obj);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int iPartialHash = this.f3560hash;
        if (iPartialHash == 0) {
            int iMo3944size = mo3944size();
            iPartialHash = partialHash(iMo3944size, 0, iMo3944size);
            if (iPartialHash == 0) {
                iPartialHash = 1;
            }
            this.f3560hash = iPartialHash;
        }
        return iPartialHash;
    }

    public abstract byte internalByteAt(int i);

    public abstract boolean isBalanced();

    /* renamed from: isEmpty */
    public final boolean m3943isEmpty() {
        return mo3944size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i, int i2, int i3);

    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    public final int peekCachedHashCode() {
        return this.f3560hash;
    }

    /* renamed from: size */
    public abstract int mo3944size();

    public final boolean startsWith(ByteString byteString) {
        return mo3944size() >= byteString.mo3944size() && substring(0, byteString.mo3944size()).mo3942equals(byteString);
    }

    public final ByteString substring(int i) {
        return substring(i, mo3944size());
    }

    public abstract ByteString substring(int i, int i2);

    public final byte[] toByteArray() {
        int iMo3944size = mo3944size();
        if (iMo3944size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[iMo3944size];
        copyToInternal(bArr, 0, 0, iMo3944size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e);
            throw unsupportedEncodingException;
        }
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.f3692UTF_8);
    }

    /* renamed from: writeTo */
    public abstract void mo3945writeTo(ByteOutput byteOutput);

    /* renamed from: writeTo */
    public abstract void mo3946writeTo(OutputStream outputStream);

    /* renamed from: writeTo */
    public final void m3947writeTo(OutputStream outputStream, int i, int i2) {
        checkRange(i, i + i2, mo3944size());
        if (i2 > 0) {
            writeToInternal(outputStream, i, i2);
        }
    }

    public abstract void writeToInternal(OutputStream outputStream, int i, int i2);

    public abstract void writeToReverse(ByteOutput byteOutput);

    public static C0726Output newOutput() {
        return new C0726Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i) {
        return readFrom(inputStream, i, i);
    }

    @Deprecated
    /* renamed from: copyTo */
    public final void m3941copyTo(byte[] bArr, int i, int i2, int i3) {
        checkRange(i, i + i3, mo3944size());
        checkRange(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            copyToInternal(bArr, i, i2, i3);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.1

            /* renamed from: limit */
            private final int f3561limit;
            private int position = 0;

            {
                this.f3561limit = ByteString.this.mo3944size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < this.f3561limit;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i = this.position;
                if (i >= this.f3561limit) {
                    throw new NoSuchElementException();
                }
                this.position = i + 1;
                return ByteString.this.internalByteAt(i);
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i, int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString chunk = readChunk(inputStream, i);
            if (chunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(chunk);
            i = Math.min(i * 2, i2);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ByteString$Output */
    public static final class C0726Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

        /* renamed from: buffer */
        private byte[] f3566buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        public C0726Output(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = i;
            this.flushedBuffers = new ArrayList<>();
            this.f3566buffer = new byte[i];
        }

        private byte[] copyArray(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        private void flushFullBuffer(int i) {
            this.flushedBuffers.add(new LiteralByteString(this.f3566buffer));
            int length = this.flushedBuffersTotalBytes + this.f3566buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.f3566buffer = new byte[Math.max(this.initialCapacity, Math.max(i, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i = this.bufferPos;
            byte[] bArr = this.f3566buffer;
            if (i >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.f3566buffer));
                this.f3566buffer = EMPTY_BYTE_ARRAY;
            } else if (i > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        /* renamed from: reset */
        public synchronized void m3949reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        /* renamed from: size */
        public synchronized int m3950size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(m3950size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            try {
                if (this.bufferPos == this.f3566buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.f3566buffer;
                int i2 = this.bufferPos;
                this.bufferPos = i2 + 1;
                bArr[i2] = (byte) i;
            } catch (Throwable th) {
                throw th;
            }
        }

        /* renamed from: writeTo */
        public void m3951writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.flushedBuffers;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.f3566buffer;
                i = this.bufferPos;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.mo3946writeTo(outputStream);
            }
            outputStream.write(copyArray(bArr, i));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            try {
                byte[] bArr2 = this.f3566buffer;
                int length = bArr2.length;
                int i3 = this.bufferPos;
                if (i2 <= length - i3) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this.bufferPos += i2;
                } else {
                    int length2 = bArr2.length - i3;
                    System.arraycopy(bArr, i, bArr2, i3, length2);
                    int i4 = i2 - length2;
                    flushFullBuffer(i4);
                    System.arraycopy(bArr, i + length2, this.f3566buffer, 0, i4);
                    this.bufferPos = i4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i) {
        checkRange(0, i, byteBuffer.remaining());
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    /* renamed from: wrap */
    public static ByteString m3935wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return mo3944size() == 0 ? BuildConfig.f24315FLAVOR : toStringInternal(charset);
    }

    /* renamed from: wrap */
    public static ByteString m3936wrap(byte[] bArr, int i, int i2) {
        return new BoundedByteString(bArr, i, i2);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo3944size()), truncateAndEscapeForDisplay());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return f3559EMPTY;
        }
        return balancedConcat(iterable.iterator(), size);
    }
}
