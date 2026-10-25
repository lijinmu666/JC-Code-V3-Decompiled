package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.Blake2bDigest;
import org.bouncycastle.p194crypto.p213params.Argon2Parameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6243Longs;

/* loaded from: classes2.dex */
public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;

    /* renamed from: M32L */
    private static final long f20186M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777215;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = new byte[4];
    private int laneLength;

    /* renamed from: memory */
    private C5344Block[] f20187memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    /* renamed from: org.bouncycastle.crypto.generators.Argon2BytesGenerator$Block */
    public static class C5344Block {

        /* renamed from: SIZE */
        private static final int f20188SIZE = 128;

        /* renamed from: v */
        private final long[] f20189v;

        private C5344Block() {
            this.f20189v = new long[128];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: clear */
        public C5344Block m15480clear() {
            C6238Arrays.m18256fill(this.f20189v, 0L);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyBlock(C5344Block c5344Block) {
            System.arraycopy(c5344Block.f20189v, 0, this.f20189v, 0, 128);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: xor */
        public void m15481xor(C5344Block c5344Block, C5344Block c5344Block2) {
            long[] jArr = this.f20189v;
            long[] jArr2 = c5344Block.f20189v;
            long[] jArr3 = c5344Block2.f20189v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr2[i] ^ jArr3[i];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: xorWith */
        public void m15482xorWith(C5344Block c5344Block) {
            long[] jArr = this.f20189v;
            long[] jArr2 = c5344Block.f20189v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr[i] ^ jArr2[i];
            }
        }

        public void fromBytes(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("input shorter than blocksize");
            }
            AbstractC6245Pack.littleEndianToLong(bArr, 0, this.f20189v);
        }

        /* renamed from: toBytes */
        public void m15484toBytes(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("output shorter than blocksize");
            }
            AbstractC6245Pack.longToLittleEndian(this.f20189v, bArr, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: xorWith */
        public void m15483xorWith(C5344Block c5344Block, C5344Block c5344Block2) {
            long[] jArr = this.f20189v;
            long[] jArr2 = c5344Block.f20189v;
            long[] jArr3 = c5344Block2.f20189v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr[i] ^ (jArr2[i] ^ jArr3[i]);
            }
        }
    }

    public static class FillBlock {

        /* renamed from: R */
        C5344Block f20190R;

        /* renamed from: Z */
        C5344Block f20191Z;
        C5344Block addressBlock;
        C5344Block inputBlock;

        private FillBlock() {
            this.f20190R = new C5344Block();
            this.f20191Z = new C5344Block();
            this.addressBlock = new C5344Block();
            this.inputBlock = new C5344Block();
        }

        private void applyBlake() {
            for (int i = 0; i < 8; i++) {
                int i2 = i * 16;
                Argon2BytesGenerator.roundFunction(this.f20191Z, i2, i2 + 1, i2 + 2, i2 + 3, i2 + 4, i2 + 5, i2 + 6, i2 + 7, i2 + 8, i2 + 9, i2 + 10, i2 + 11, i2 + 12, i2 + 13, i2 + 14, i2 + 15);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i3 * 2;
                Argon2BytesGenerator.roundFunction(this.f20191Z, i4, i4 + 1, i4 + 16, i4 + 17, i4 + 32, i4 + 33, i4 + 48, i4 + 49, i4 + 64, i4 + 65, i4 + 80, i4 + 81, i4 + 96, i4 + 97, i4 + 112, i4 + 113);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlock(C5344Block c5344Block, C5344Block c5344Block2) {
            this.f20191Z.copyBlock(c5344Block);
            applyBlake();
            c5344Block2.m15481xor(c5344Block, this.f20191Z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlockWithXor(C5344Block c5344Block, C5344Block c5344Block2, C5344Block c5344Block3) {
            this.f20190R.m15481xor(c5344Block, c5344Block2);
            this.f20191Z.copyBlock(this.f20190R);
            applyBlake();
            c5344Block3.m15483xorWith(this.f20190R, this.f20191Z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlock(C5344Block c5344Block, C5344Block c5344Block2, C5344Block c5344Block3) {
            this.f20190R.m15481xor(c5344Block, c5344Block2);
            this.f20191Z.copyBlock(this.f20190R);
            applyBlake();
            c5344Block3.m15481xor(this.f20190R, this.f20191Z);
        }
    }

    public static class Position {

        /* renamed from: lane */
        int f20192lane;

        /* renamed from: pass */
        int f20193pass;

        /* renamed from: slice */
        int f20194slice;
    }

    /* renamed from: F */
    private static void m15475F(long[] jArr, int i, int i2, int i3, int i4) {
        quarterRound(jArr, i, i2, i4, 32);
        quarterRound(jArr, i3, i4, i2, 24);
        quarterRound(jArr, i, i2, i4, 16);
        quarterRound(jArr, i3, i4, i2, 63);
    }

    private static void addByteString(byte[] bArr, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr2) {
        if (bArr2 == null) {
            interfaceC5277Digest.mo14970update(ZERO_BYTES, 0, 4);
            return;
        }
        AbstractC6245Pack.intToLittleEndian(bArr2.length, bArr, 0);
        interfaceC5277Digest.mo14970update(bArr, 0, 4);
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
    }

    /* renamed from: digest */
    private void m15476digest(byte[] bArr, byte[] bArr2, int i, int i2) {
        C5344Block c5344Block = this.f20187memory[this.laneLength - 1];
        for (int i3 = 1; i3 < this.parameters.getLanes(); i3++) {
            int i4 = this.laneLength;
            c5344Block.m15482xorWith(this.f20187memory[(i3 * i4) + (i4 - 1)]);
        }
        c5344Block.m15484toBytes(bArr);
        m15477hash(bArr, bArr2, i, i2);
    }

    private void fillFirstBlocks(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[72];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i = 0; i < this.parameters.getLanes(); i++) {
            AbstractC6245Pack.intToLittleEndian(i, bArr2, 68);
            AbstractC6245Pack.intToLittleEndian(i, bArr3, 68);
            m15477hash(bArr2, bArr, 0, 1024);
            this.f20187memory[this.laneLength * i].fromBytes(bArr);
            m15477hash(bArr3, bArr, 0, 1024);
            this.f20187memory[(this.laneLength * i) + 1].fromBytes(bArr);
        }
    }

    private void fillMemoryBlocks() {
        FillBlock fillBlock = new FillBlock();
        Position position = new Position();
        for (int i = 0; i < this.parameters.getIterations(); i++) {
            position.f20193pass = i;
            for (int i2 = 0; i2 < 4; i2++) {
                position.f20194slice = i2;
                for (int i3 = 0; i3 < this.parameters.getLanes(); i3++) {
                    position.f20192lane = i3;
                    fillSegment(fillBlock, position);
                }
            }
        }
    }

    private void fillSegment(FillBlock fillBlock, Position position) {
        C5344Block c5344Block;
        C5344Block c5344Block2;
        boolean zIsDataIndependentAddressing = isDataIndependentAddressing(position);
        int startingIndex = getStartingIndex(position);
        int i = (position.f20192lane * this.laneLength) + (position.f20194slice * this.segmentLength) + startingIndex;
        int prevOffset = getPrevOffset(i);
        if (zIsDataIndependentAddressing) {
            C5344Block c5344BlockM15480clear = fillBlock.addressBlock.m15480clear();
            C5344Block c5344BlockM15480clear2 = fillBlock.inputBlock.m15480clear();
            initAddressBlocks(fillBlock, position, c5344BlockM15480clear2, c5344BlockM15480clear);
            c5344Block = c5344BlockM15480clear;
            c5344Block2 = c5344BlockM15480clear2;
        } else {
            c5344Block = null;
            c5344Block2 = null;
        }
        boolean zIsWithXor = isWithXor(position);
        int i2 = startingIndex;
        int i3 = i;
        int i4 = prevOffset;
        while (i2 < this.segmentLength) {
            long pseudoRandom = getPseudoRandom(fillBlock, i2, c5344Block, c5344Block2, i4, zIsDataIndependentAddressing);
            int refLane = getRefLane(position, pseudoRandom);
            int refColumn = getRefColumn(position, i2, pseudoRandom, refLane == position.f20192lane);
            C5344Block[] c5344BlockArr = this.f20187memory;
            C5344Block c5344Block3 = c5344BlockArr[i4];
            C5344Block c5344Block4 = c5344BlockArr[(this.laneLength * refLane) + refColumn];
            C5344Block c5344Block5 = c5344BlockArr[i3];
            if (zIsWithXor) {
                fillBlock.fillBlockWithXor(c5344Block3, c5344Block4, c5344Block5);
            } else {
                fillBlock.fillBlock(c5344Block3, c5344Block4, c5344Block5);
            }
            i2++;
            i4 = i3;
            i3++;
        }
    }

    private int getPrevOffset(int i) {
        return i % this.laneLength == 0 ? (i + r1) - 1 : i - 1;
    }

    private long getPseudoRandom(FillBlock fillBlock, int i, C5344Block c5344Block, C5344Block c5344Block2, int i2, boolean z) {
        if (!z) {
            return this.f20187memory[i2].f20189v[0];
        }
        int i3 = i % 128;
        if (i3 == 0) {
            nextAddresses(fillBlock, c5344Block2, c5344Block);
        }
        return c5344Block.f20189v[i3];
    }

    private int getRefColumn(Position position, int i, long j, boolean z) {
        int i2;
        int i3;
        int i4 = position.f20193pass;
        int i5 = 0;
        int i6 = position.f20194slice;
        if (i4 != 0) {
            int i7 = this.segmentLength;
            int i8 = this.laneLength;
            int i9 = ((i6 + 1) * i7) % i8;
            int i10 = i8 - i7;
            if (z) {
                i2 = (i10 + i) - 1;
            } else {
                i2 = i10 + (i != 0 ? 0 : -1);
            }
            i5 = i9;
            i3 = i2;
        } else if (z) {
            i3 = ((i6 * this.segmentLength) + i) - 1;
        } else {
            i3 = (i6 * this.segmentLength) + (i != 0 ? 0 : -1);
        }
        long j2 = j & 4294967295L;
        return ((int) (i5 + ((i3 - 1) - ((i3 * ((j2 * j2) >>> 32)) >>> 32)))) % this.laneLength;
    }

    private int getRefLane(Position position, long j) {
        int lanes = (int) ((j >>> 32) % this.parameters.getLanes());
        return (position.f20193pass == 0 && position.f20194slice == 0) ? position.f20192lane : lanes;
    }

    private static int getStartingIndex(Position position) {
        return (position.f20193pass == 0 && position.f20194slice == 0) ? 2 : 0;
    }

    /* renamed from: hash */
    private void m15477hash(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] bArr3 = new byte[4];
        AbstractC6245Pack.intToLittleEndian(i2, bArr3, 0);
        if (i2 <= 64) {
            Blake2bDigest blake2bDigest = new Blake2bDigest(i2 * 8);
            blake2bDigest.mo14970update(bArr3, 0, 4);
            blake2bDigest.mo14970update(bArr, 0, bArr.length);
            blake2bDigest.mo14967doFinal(bArr2, i);
            return;
        }
        Blake2bDigest blake2bDigest2 = new Blake2bDigest(512);
        byte[] bArr4 = new byte[64];
        blake2bDigest2.mo14970update(bArr3, 0, 4);
        blake2bDigest2.mo14970update(bArr, 0, bArr.length);
        blake2bDigest2.mo14967doFinal(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i, 32);
        int i3 = i + 32;
        int i4 = 2;
        int i5 = ((i2 + 31) / 32) - 2;
        while (i4 <= i5) {
            blake2bDigest2.mo14970update(bArr4, 0, 64);
            blake2bDigest2.mo14967doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i3, 32);
            i4++;
            i3 += 32;
        }
        Blake2bDigest blake2bDigest3 = new Blake2bDigest((i2 - (i5 * 32)) * 8);
        blake2bDigest3.mo14970update(bArr4, 0, 64);
        blake2bDigest3.mo14967doFinal(bArr2, i3);
    }

    private void initAddressBlocks(FillBlock fillBlock, Position position, C5344Block c5344Block, C5344Block c5344Block2) {
        c5344Block.f20189v[0] = intToLong(position.f20193pass);
        c5344Block.f20189v[1] = intToLong(position.f20192lane);
        c5344Block.f20189v[2] = intToLong(position.f20194slice);
        c5344Block.f20189v[3] = intToLong(this.f20187memory.length);
        c5344Block.f20189v[4] = intToLong(this.parameters.getIterations());
        c5344Block.f20189v[5] = intToLong(this.parameters.m15667getType());
        if (position.f20193pass == 0 && position.f20194slice == 0) {
            nextAddresses(fillBlock, c5344Block, c5344Block2);
        }
    }

    private void initialize(byte[] bArr, byte[] bArr2, int i) {
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);
        AbstractC6245Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), i, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.m15667getType()}, bArr, 0);
        blake2bDigest.mo14970update(bArr, 0, 24);
        addByteString(bArr, blake2bDigest, bArr2);
        addByteString(bArr, blake2bDigest, this.parameters.m15666getSalt());
        addByteString(bArr, blake2bDigest, this.parameters.getSecret());
        addByteString(bArr, blake2bDigest, this.parameters.getAdditional());
        byte[] bArr3 = new byte[72];
        blake2bDigest.mo14967doFinal(bArr3, 0);
        fillFirstBlocks(bArr, bArr3);
    }

    private long intToLong(int i) {
        return i & 4294967295L;
    }

    private boolean isDataIndependentAddressing(Position position) {
        if (this.parameters.m15667getType() != 1) {
            return this.parameters.m15667getType() == 2 && position.f20193pass == 0 && position.f20194slice < 2;
        }
        return true;
    }

    private boolean isWithXor(Position position) {
        return (position.f20193pass == 0 || this.parameters.getVersion() == 16) ? false : true;
    }

    private void nextAddresses(FillBlock fillBlock, C5344Block c5344Block, C5344Block c5344Block2) {
        long[] jArr = c5344Block.f20189v;
        jArr[6] = jArr[6] + 1;
        fillBlock.fillBlock(c5344Block, c5344Block2);
        fillBlock.fillBlock(c5344Block2, c5344Block2);
    }

    private static void quarterRound(long[] jArr, int i, int i2, int i3, int i4) {
        long j = jArr[i];
        long j2 = jArr[i2];
        long j3 = j + j2 + ((j & 4294967295L) * 2 * (4294967295L & j2));
        long jRotateRight = C6243Longs.rotateRight(jArr[i3] ^ j3, i4);
        jArr[i] = j3;
        jArr[i3] = jRotateRight;
    }

    /* renamed from: reset */
    private void m15478reset() {
        if (this.f20187memory == null) {
            return;
        }
        int i = 0;
        while (true) {
            C5344Block[] c5344BlockArr = this.f20187memory;
            if (i >= c5344BlockArr.length) {
                return;
            }
            C5344Block c5344Block = c5344BlockArr[i];
            if (c5344Block != null) {
                c5344Block.m15480clear();
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void roundFunction(C5344Block c5344Block, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        long[] jArr = c5344Block.f20189v;
        m15475F(jArr, i, i5, i9, i13);
        m15475F(jArr, i2, i6, i10, i14);
        m15475F(jArr, i3, i7, i11, i15);
        m15475F(jArr, i4, i8, i12, i16);
        m15475F(jArr, i, i6, i11, i16);
        m15475F(jArr, i2, i7, i12, i13);
        m15475F(jArr, i3, i8, i9, i14);
        m15475F(jArr, i4, i5, i10, i15);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2) {
        return generateBytes(bArr, bArr2, 0, bArr2.length);
    }

    /* renamed from: init */
    public void m15479init(Argon2Parameters argon2Parameters) {
        if (argon2Parameters.getVersion() != 16 && argon2Parameters.getVersion() != 19) {
            throw new UnsupportedOperationException("unknown Argon2 version");
        }
        if (argon2Parameters.m15667getType() != 0 && argon2Parameters.m15667getType() != 1 && argon2Parameters.m15667getType() != 2) {
            throw new UnsupportedOperationException("unknown Argon2 type");
        }
        if (argon2Parameters.getLanes() < 1) {
            throw new IllegalStateException("lanes must be at least 1");
        }
        if (argon2Parameters.getLanes() > MAX_PARALLELISM) {
            throw new IllegalStateException("lanes must be at most 16777215");
        }
        if (argon2Parameters.getIterations() < 1) {
            throw new IllegalStateException("iterations is less than: 1");
        }
        this.parameters = argon2Parameters;
        int iMax = Math.max(argon2Parameters.getMemory(), argon2Parameters.getLanes() * 8) / (argon2Parameters.getLanes() * 4);
        this.segmentLength = iMax;
        this.laneLength = iMax * 4;
        this.f20187memory = new C5344Block[argon2Parameters.getLanes() * this.laneLength];
        int i = 0;
        while (true) {
            C5344Block[] c5344BlockArr = this.f20187memory;
            if (i >= c5344BlockArr.length) {
                return;
            }
            c5344BlockArr[i] = new C5344Block();
            i++;
        }
    }

    public int generateBytes(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (i2 < 4) {
            throw new IllegalStateException("output length less than 4");
        }
        byte[] bArr3 = new byte[1024];
        initialize(bArr3, bArr, i2);
        fillMemoryBlocks();
        m15476digest(bArr3, bArr2, i, i2);
        m15478reset();
        return i2;
    }

    public int generateBytes(char[] cArr, byte[] bArr) {
        return generateBytes(this.parameters.getCharToByteConverter().mo14954convert(cArr), bArr);
    }

    public int generateBytes(char[] cArr, byte[] bArr, int i, int i2) {
        return generateBytes(this.parameters.getCharToByteConverter().mo14954convert(cArr), bArr, i, i2);
    }
}
