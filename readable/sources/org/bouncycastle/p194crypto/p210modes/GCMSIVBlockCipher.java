package org.bouncycastle.p194crypto.p210modes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.p211gcm.GCMMultiplier;
import org.bouncycastle.p194crypto.p210modes.p211gcm.Tables4kGCMMultiplier;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6243Longs;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class GCMSIVBlockCipher implements AEADBlockCipher {

    /* renamed from: ADD */
    private static final byte f20579ADD = -31;
    private static final int AEAD_COMPLETE = 2;

    /* renamed from: BUFLEN */
    private static final int f20580BUFLEN = 16;
    private static final int HALFBUFLEN = 8;

    /* renamed from: INIT */
    private static final int f20581INIT = 1;

    /* renamed from: MASK */
    private static final byte f20582MASK = -128;
    private static final int MAX_DATALEN = 2147483623;
    private static final int NONCELEN = 12;
    private boolean forEncryption;
    private byte[] macBlock;
    private final GCMSIVHasher theAEADHasher;
    private final BlockCipher theCipher;
    private final GCMSIVHasher theDataHasher;
    private GCMSIVCache theEncData;
    private int theFlags;
    private final byte[] theGHash;
    private byte[] theInitialAEAD;
    private final GCMMultiplier theMultiplier;
    private byte[] theNonce;
    private GCMSIVCache thePlain;
    private final byte[] theReverse;

    public static class GCMSIVCache extends ByteArrayOutputStream {
        public void clearBuffer() {
            C6238Arrays.m18249fill(getBuffer(), (byte) 0);
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public class GCMSIVHasher {
        private int numActive;
        private long numHashed;
        private final byte[] theBuffer;

        /* renamed from: theByte */
        private final byte[] f20583theByte;

        private GCMSIVHasher() {
            this.theBuffer = new byte[16];
            this.f20583theByte = new byte[1];
        }

        public void completeHash() {
            if (this.numActive > 0) {
                C6238Arrays.m18249fill(GCMSIVBlockCipher.this.theReverse, (byte) 0);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, this.numActive, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.m15603gHASH(gCMSIVBlockCipher.theReverse);
            }
        }

        public long getBytesProcessed() {
            return this.numHashed;
        }

        /* renamed from: reset */
        public void m15605reset() {
            this.numActive = 0;
            this.numHashed = 0L;
        }

        public void updateHash(byte b) {
            byte[] bArr = this.f20583theByte;
            bArr[0] = b;
            updateHash(bArr, 0, 1);
        }

        public void updateHash(byte[] bArr, int i, int i2) {
            int i3;
            int i4 = this.numActive;
            int i5 = 16 - i4;
            if (i4 <= 0 || i2 < i5) {
                i3 = i2;
                i5 = 0;
            } else {
                System.arraycopy(bArr, i, this.theBuffer, i4, i5);
                GCMSIVBlockCipher.fillReverse(this.theBuffer, 0, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher.m15603gHASH(gCMSIVBlockCipher.theReverse);
                i3 = i2 - i5;
                this.numActive = 0;
            }
            while (i3 >= 16) {
                GCMSIVBlockCipher.fillReverse(bArr, i + i5, 16, GCMSIVBlockCipher.this.theReverse);
                GCMSIVBlockCipher gCMSIVBlockCipher2 = GCMSIVBlockCipher.this;
                gCMSIVBlockCipher2.m15603gHASH(gCMSIVBlockCipher2.theReverse);
                i5 += 16;
                i3 -= 16;
            }
            if (i3 > 0) {
                System.arraycopy(bArr, i + i5, this.theBuffer, this.numActive, i3);
                this.numActive += i3;
            }
            this.numHashed += i2;
        }
    }

    public GCMSIVBlockCipher() {
        this(AESEngine.newInstance());
    }

    private static int bufLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private byte[] calculateTag() {
        this.theDataHasher.completeHash();
        byte[] bArrCompletePolyVal = completePolyVal();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 12; i++) {
            bArrCompletePolyVal[i] = (byte) (bArrCompletePolyVal[i] ^ this.theNonce[i]);
        }
        bArrCompletePolyVal[15] = (byte) (bArrCompletePolyVal[15] & ByteCompanionObject.MAX_VALUE);
        this.theCipher.processBlock(bArrCompletePolyVal, 0, bArr, 0);
        return bArr;
    }

    private void checkAEADStatus(int i) {
        int i2 = this.theFlags;
        if ((i2 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i2 & 2) != 0) {
            throw new IllegalStateException("AEAD data cannot be processed after ordinary data");
        }
        if (C6243Longs.compareUnsigned(this.theAEADHasher.getBytesProcessed(), MAX_DATALEN - i) > 0) {
            throw new IllegalStateException("AEAD byte count exceeded");
        }
    }

    private static void checkBuffer(byte[] bArr, int i, int i2, boolean z) {
        int iBufLength = bufLength(bArr);
        int i3 = i + i2;
        if (i2 < 0 || i < 0 || i3 < 0 || i3 > iBufLength) {
            if (!z) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    private void checkStatus(int i) {
        long j;
        int i2 = this.theFlags;
        if ((i2 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i2 & 2) == 0) {
            this.theAEADHasher.completeHash();
            this.theFlags |= 2;
        }
        long size = this.thePlain.size();
        if (this.forEncryption) {
            j = 2147483623;
        } else {
            size = this.theEncData.size();
            j = 2147483639;
        }
        if (C6243Longs.compareUnsigned(size, j - i) > 0) {
            throw new IllegalStateException("byte count exceeded");
        }
    }

    private byte[] completePolyVal() {
        byte[] bArr = new byte[16];
        gHashLengths();
        fillReverse(this.theGHash, 0, 16, bArr);
        return bArr;
    }

    private void decryptPlain() throws InvalidCipherTextException, IOException {
        byte[] buffer = this.theEncData.getBuffer();
        int size = this.theEncData.size();
        int i = size - 16;
        if (i < 0) {
            throw new InvalidCipherTextException("Data too short");
        }
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(buffer, i, size);
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArrCopyOfRange);
        bArrM18231clone[15] = (byte) (bArrM18231clone[15] | (-128));
        byte[] bArr = new byte[16];
        int i2 = 0;
        while (i > 0) {
            this.theCipher.processBlock(bArrM18231clone, 0, bArr, 0);
            int iMin = Math.min(16, i);
            xorBlock(bArr, buffer, i2, iMin);
            this.thePlain.write(bArr, 0, iMin);
            this.theDataHasher.updateHash(bArr, 0, iMin);
            i -= iMin;
            i2 += iMin;
            incrementCounter(bArrM18231clone);
        }
        byte[] bArrCalculateTag = calculateTag();
        if (!C6238Arrays.constantTimeAreEqual(bArrCalculateTag, bArrCopyOfRange)) {
            mo15228reset();
            throw new InvalidCipherTextException("mac check failed");
        }
        byte[] bArr2 = this.macBlock;
        System.arraycopy(bArrCalculateTag, 0, bArr2, 0, bArr2.length);
    }

    private void deriveKeys(KeyParameter keyParameter) {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        int keyLength = keyParameter.getKeyLength();
        byte[] bArr4 = new byte[keyLength];
        System.arraycopy(this.theNonce, 0, bArr, 4, 12);
        this.theCipher.mo14946init(true, keyParameter);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 8, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.theCipher.processBlock(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 8, 8);
        if (keyLength == 32) {
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 16, 8);
            bArr[0] = (byte) (bArr[0] + 1);
            this.theCipher.processBlock(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 24, 8);
        }
        this.theCipher.mo14946init(true, new KeyParameter(bArr4));
        fillReverse(bArr3, 0, 16, bArr2);
        m15604mulX(bArr2);
        this.theMultiplier.mo15617init(bArr2);
        this.theFlags |= 1;
    }

    private int encryptPlain(byte[] bArr, byte[] bArr2, int i) {
        byte[] buffer = this.thePlain.getBuffer();
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        bArrM18231clone[15] = (byte) (bArrM18231clone[15] | (-128));
        byte[] bArr3 = new byte[16];
        int size = this.thePlain.size();
        int i2 = 0;
        while (size > 0) {
            this.theCipher.processBlock(bArrM18231clone, 0, bArr3, 0);
            int iMin = Math.min(16, size);
            xorBlock(bArr3, buffer, i2, iMin);
            System.arraycopy(bArr3, 0, bArr2, i + i2, iMin);
            size -= iMin;
            i2 += iMin;
            incrementCounter(bArrM18231clone);
        }
        return this.thePlain.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillReverse(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        int i4 = 15;
        while (i3 < i2) {
            bArr2[i4] = bArr[i + i3];
            i3++;
            i4--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: gHASH */
    public void m15603gHASH(byte[] bArr) {
        xorBlock(this.theGHash, bArr);
        this.theMultiplier.multiplyH(this.theGHash);
    }

    private void gHashLengths() {
        byte[] bArr = new byte[16];
        AbstractC6245Pack.longToBigEndian(this.theDataHasher.getBytesProcessed() * 8, bArr, 0);
        AbstractC6245Pack.longToBigEndian(this.theAEADHasher.getBytesProcessed() * 8, bArr, 8);
        m15603gHASH(bArr);
    }

    private static void incrementCounter(byte[] bArr) {
        for (int i = 0; i < 4; i++) {
            byte b = (byte) (bArr[i] + 1);
            bArr[i] = b;
            if (b != 0) {
                return;
            }
        }
    }

    /* renamed from: mulX */
    private static void m15604mulX(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            bArr[i2] = (byte) (i | ((b >> 1) & 127));
            i = (b & 1) == 0 ? 0 : -128;
        }
        if (i != 0) {
            bArr[0] = (byte) (bArr[0] ^ f20579ADD);
        }
    }

    private void resetStreams() {
        GCMSIVCache gCMSIVCache = this.thePlain;
        if (gCMSIVCache != null) {
            gCMSIVCache.clearBuffer();
        }
        this.theAEADHasher.m15605reset();
        this.theDataHasher.m15605reset();
        this.thePlain = new GCMSIVCache();
        this.theEncData = this.forEncryption ? null : new GCMSIVCache();
        this.theFlags &= -3;
        C6238Arrays.m18249fill(this.theGHash, (byte) 0);
        byte[] bArr = this.theInitialAEAD;
        if (bArr != null) {
            this.theAEADHasher.updateHash(bArr, 0, bArr.length);
        }
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IOException {
        checkStatus(0);
        checkBuffer(bArr, i, getOutputSize(0), true);
        if (!this.forEncryption) {
            decryptPlain();
            int size = this.thePlain.size();
            System.arraycopy(this.thePlain.getBuffer(), 0, bArr, i, size);
            resetStreams();
            return size;
        }
        byte[] bArrCalculateTag = calculateTag();
        int iEncryptPlain = encryptPlain(bArrCalculateTag, bArr, i) + 16;
        System.arraycopy(bArrCalculateTag, 0, bArr, i + this.thePlain.size(), 16);
        byte[] bArr2 = this.macBlock;
        System.arraycopy(bArrCalculateTag, 0, bArr2, 0, bArr2.length);
        resetStreams();
        return iEncryptPlain;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return this.theCipher.getAlgorithmName() + "-GCM-SIV";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        return C6238Arrays.m18231clone(this.macBlock);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return i + this.thePlain.size() + 16;
        }
        int size = i + this.theEncData.size();
        if (size > 16) {
            return size - 16;
        }
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.theCipher;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrM15801getIV;
        KeyParameter keyParameterM15664getKey;
        byte[] associatedText;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            associatedText = aEADParameters.getAssociatedText();
            bArrM15801getIV = aEADParameters.getNonce();
            keyParameterM15664getKey = aEADParameters.m15664getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM-SIV");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
            associatedText = null;
        }
        if (bArrM15801getIV == null || bArrM15801getIV.length != 12) {
            throw new IllegalArgumentException("Invalid nonce");
        }
        if (keyParameterM15664getKey == null || !(keyParameterM15664getKey.getKeyLength() == 16 || keyParameterM15664getKey.getKeyLength() == 32)) {
            throw new IllegalArgumentException("Invalid key");
        }
        this.forEncryption = z;
        this.theInitialAEAD = associatedText;
        this.theNonce = bArrM15801getIV;
        deriveKeys(keyParameterM15664getKey);
        resetStreams();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        checkAEADStatus(1);
        this.theAEADHasher.updateHash(b);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        checkAEADStatus(i2);
        checkBuffer(bArr, i, i2, false);
        this.theAEADHasher.updateHash(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) throws IOException {
        checkStatus(1);
        if (!this.forEncryption) {
            this.theEncData.write(b);
            return 0;
        }
        this.thePlain.write(b);
        this.theDataHasher.updateHash(b);
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        checkStatus(i2);
        checkBuffer(bArr, i, i2, false);
        if (this.forEncryption) {
            this.thePlain.write(bArr, i, i2);
            this.theDataHasher.updateHash(bArr, i, i2);
        } else {
            this.theEncData.write(bArr, i, i2);
        }
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        resetStreams();
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new Tables4kGCMMultiplier());
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3 + i]);
        }
    }

    public GCMSIVBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        this.theGHash = new byte[16];
        this.theReverse = new byte[16];
        this.macBlock = new byte[16];
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Cipher required with a block size of 16.");
        }
        this.theCipher = blockCipher;
        this.theMultiplier = gCMMultiplier;
        this.theAEADHasher = new GCMSIVHasher();
        this.theDataHasher = new GCMSIVHasher();
    }
}
