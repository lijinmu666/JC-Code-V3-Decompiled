package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;

    /* renamed from: left */
    private final ByteString f3754left;
    private final int leftLength;

    /* renamed from: right */
    private final ByteString f3755right;
    private final int totalLength;
    private final int treeDepth;

    public static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: balance */
        public ByteString m4120balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                byteStringPop = new RopeByteString(this.prefixesStack.pop(), byteStringPop);
            }
            return byteStringPop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                m4121insert(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.f3754left);
                doBalance(ropeByteString.f3755right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int getDepthBinForLength(int i) {
            int iBinarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        /* renamed from: insert */
        private void m4121insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.mo3944size());
            int iMinLength = RopeByteString.minLength(depthBinForLength + 1);
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().mo3944size() >= iMinLength) {
                this.prefixesStack.push(byteString);
                return;
            }
            int iMinLength2 = RopeByteString.minLength(depthBinForLength);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (true) {
                if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().mo3944size() >= iMinLength2) {
                    break;
                } else {
                    byteStringPop = new RopeByteString(this.prefixesStack.pop(), byteStringPop);
                }
            }
            RopeByteString ropeByteString = new RopeByteString(byteStringPop, byteString);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().mo3944size() >= RopeByteString.minLength(getDepthBinForLength(ropeByteString.mo3944size()) + 1)) {
                    break;
                } else {
                    ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
                }
            }
            this.prefixesStack.push(ropeByteString);
        }
    }

    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;

        /* renamed from: next */
        private ByteString.LeafByteString f3759next;

        private ByteString.LeafByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.f3754left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
            ByteString.LeafByteString leafByLeft;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.breadCrumbs;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByLeft = getLeafByLeft(this.breadCrumbs.pop().f3755right);
            } while (leafByLeft.m3943isEmpty());
            return leafByLeft;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3759next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            if (!(byteString instanceof RopeByteString)) {
                this.breadCrumbs = null;
                this.f3759next = (ByteString.LeafByteString) byteString;
                return;
            }
            RopeByteString ropeByteString = (RopeByteString) byteString;
            ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
            this.breadCrumbs = arrayDeque;
            arrayDeque.push(ropeByteString);
            this.f3759next = getLeafByLeft(ropeByteString.f3754left);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f3759next;
            if (leafByteString == null) {
                throw new NoSuchElementException();
            }
            this.f3759next = getNextNonEmptyLeaf();
            return leafByteString;
        }
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.mo3944size() == 0) {
            return byteString;
        }
        if (byteString.mo3944size() == 0) {
            return byteString2;
        }
        int iMo3944size = byteString.mo3944size() + byteString2.mo3944size();
        if (iMo3944size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.f3755right.mo3944size() + byteString2.mo3944size() < 128) {
                return new RopeByteString(ropeByteString.f3754left, concatenateBytes(ropeByteString.f3755right, byteString2));
            }
            if (ropeByteString.f3754left.getTreeDepth() > ropeByteString.f3755right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.f3754left, new RopeByteString(ropeByteString.f3755right, byteString2));
            }
        }
        return iMo3944size >= minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1) ? new RopeByteString(byteString, byteString2) : new Balancer().m4120balance(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int iMo3944size = byteString.mo3944size();
        int iMo3944size2 = byteString2.mo3944size();
        byte[] bArr = new byte[iMo3944size + iMo3944size2];
        byteString.m3941copyTo(bArr, 0, 0, iMo3944size);
        byteString2.m3941copyTo(bArr, 0, iMo3944size, iMo3944size2);
        return ByteString.m3935wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString next2 = pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iMo3944size = next.mo3944size() - i;
            int iMo3944size2 = next2.mo3944size() - i2;
            int iMin = Math.min(iMo3944size, iMo3944size2);
            if (!(i == 0 ? next.equalsRange(next2, i2, iMin) : next2.equalsRange(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.totalLength;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iMo3944size) {
                i = 0;
                next = pieceIterator.next();
            } else {
                i += iMin;
                next = next;
            }
            if (iMin == iMo3944size2) {
                next2 = pieceIterator2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    public static int minLength(int i) {
        int[] iArr = minLengthByDepth;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: byteAt */
    public byte mo3937byteAt(int i) {
        ByteString.checkIndex(i, this.totalLength);
        return internalByteAt(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: copyTo */
    public void mo3939copyTo(ByteBuffer byteBuffer) {
        this.f3754left.mo3939copyTo(byteBuffer);
        this.f3755right.mo3939copyTo(byteBuffer);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.f3754left.copyToInternal(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.f3755right.copyToInternal(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.f3754left.copyToInternal(bArr, i, i2, i6);
            this.f3755right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: equals */
    public boolean mo3942equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.mo3944size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int iPeekCachedHashCode = peekCachedHashCode();
        int iPeekCachedHashCode2 = byteString.peekCachedHashCode();
        if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public byte internalByteAt(int i) {
        int i2 = this.leftLength;
        return i < i2 ? this.f3754left.internalByteAt(i) : this.f3755right.internalByteAt(i - i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        int iPartialIsValidUtf8 = this.f3754left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.f3755right;
        return byteString.partialIsValidUtf8(iPartialIsValidUtf8, 0, byteString.mo3944size()) == 0;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((Iterable<ByteBuffer>) asReadOnlyByteBufferList(), true);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.f3754left.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f3755right.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f3755right.partialHash(this.f3754left.partialHash(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.f3754left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f3755right.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f3755right.partialIsValidUtf8(this.f3754left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: size */
    public int mo3944size() {
        return this.totalLength;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        int iCheckRange = ByteString.checkRange(i, i2, this.totalLength);
        if (iCheckRange == 0) {
            return ByteString.f3559EMPTY;
        }
        if (iCheckRange == this.totalLength) {
            return this;
        }
        int i3 = this.leftLength;
        return i2 <= i3 ? this.f3754left.substring(i, i2) : i >= i3 ? this.f3755right.substring(i - i3, i2 - i3) : new RopeByteString(this.f3754left.substring(i), this.f3755right.substring(0, i2 - this.leftLength));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return ByteString.m3935wrap(toByteArray());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: writeTo */
    public void mo3946writeTo(OutputStream outputStream) {
        this.f3754left.mo3946writeTo(outputStream);
        this.f3755right.mo3946writeTo(outputStream);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i, int i2) {
        int i3 = i + i2;
        int i4 = this.leftLength;
        if (i3 <= i4) {
            this.f3754left.writeToInternal(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.f3755right.writeToInternal(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.f3754left.writeToInternal(outputStream, i, i5);
            this.f3755right.writeToInternal(outputStream, 0, i2 - i5);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public void writeToReverse(ByteOutput byteOutput) {
        this.f3755right.writeToReverse(byteOutput);
        this.f3754left.writeToReverse(byteOutput);
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f3754left = byteString;
        this.f3755right = byteString2;
        int iMo3944size = byteString.mo3944size();
        this.leftLength = iMo3944size;
        this.totalLength = iMo3944size + byteString2.mo3944size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new ByteString.AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.RopeByteString.1

            /* renamed from: current */
            ByteString.ByteIterator f3756current = nextPiece();

            /* renamed from: pieces */
            final PieceIterator f3757pieces;

            {
                this.f3757pieces = new PieceIterator(RopeByteString.this);
            }

            /* JADX WARN: Type inference failed for: r1v4, types: [com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator] */
            private ByteString.ByteIterator nextPiece() {
                if (this.f3757pieces.hasNext()) {
                    return this.f3757pieces.next().iterator2();
                }
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3756current != null;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.f3756current;
                if (byteIterator == null) {
                    throw new NoSuchElementException();
                }
                byte bNextByte = byteIterator.nextByte();
                if (!this.f3756current.hasNext()) {
                    this.f3756current = nextPiece();
                }
                return bNextByte;
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: writeTo */
    public void mo3945writeTo(ByteOutput byteOutput) {
        this.f3754left.mo3945writeTo(byteOutput);
        this.f3755right.mo3945writeTo(byteOutput);
    }

    public class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;

        /* renamed from: mark */
        private int f3760mark;
        private PieceIterator pieceIterator;

        public RopeInputStream() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null) {
                int i = this.currentPieceIndex;
                int i2 = this.currentPieceSize;
                if (i == i2) {
                    this.currentPieceOffsetInRope += i2;
                    this.currentPieceIndex = 0;
                    if (!this.pieceIterator.hasNext()) {
                        this.currentPiece = null;
                        this.currentPieceSize = 0;
                    } else {
                        ByteString.LeafByteString next = this.pieceIterator.next();
                        this.currentPiece = next;
                        this.currentPieceSize = next.mo3944size();
                    }
                }
            }
        }

        private int availableInternal() {
            return RopeByteString.this.mo3944size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        private void initialize() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator;
            ByteString.LeafByteString next = pieceIterator.next();
            this.currentPiece = next;
            this.currentPieceSize = next.mo3944size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (i3 > 0) {
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece == null) {
                    break;
                }
                int iMin = Math.min(this.currentPieceSize - this.currentPieceIndex, i3);
                if (bArr != null) {
                    this.currentPiece.m3941copyTo(bArr, this.currentPieceIndex, i, iMin);
                    i += iMin;
                }
                this.currentPieceIndex += iMin;
                i3 -= iMin;
            }
            return i2 - i3;
        }

        @Override // java.io.InputStream
        public int available() {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f3760mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            int skipInternal = readSkipInternal(bArr, i, i2);
            if (skipInternal != 0 || (i2 <= 0 && availableInternal() != 0)) {
                return skipInternal;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            initialize();
            readSkipInternal(null, 0, this.f3760mark);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return readSkipInternal(null, 0, (int) j);
        }

        @Override // java.io.InputStream
        public int read() {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString leafByteString = this.currentPiece;
            if (leafByteString == null) {
                return -1;
            }
            int i = this.currentPieceIndex;
            this.currentPieceIndex = i + 1;
            return leafByteString.mo3937byteAt(i) & C1126UByte.MAX_VALUE;
        }
    }
}
