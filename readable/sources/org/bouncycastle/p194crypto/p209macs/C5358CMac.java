package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.macs.CMac */
/* loaded from: classes2.dex */
public class C5358CMac implements InterfaceC5278Mac {

    /* renamed from: Lu */
    private byte[] f20426Lu;

    /* renamed from: Lu2 */
    private byte[] f20427Lu2;

    /* renamed from: ZEROES */
    private byte[] f20428ZEROES;

    /* renamed from: buf */
    private byte[] f20429buf;

    /* renamed from: bufOff */
    private int f20430bufOff;

    /* renamed from: cipher */
    private BlockCipher f20431cipher;

    /* renamed from: mac */
    private byte[] f20432mac;

    /* renamed from: macSize */
    private int f20433macSize;

    /* renamed from: poly */
    private byte[] f20434poly;

    public C5358CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private byte[] doubleLu(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = (-shiftLeft(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b = bArr2[length];
        byte[] bArr3 = this.f20434poly;
        bArr2[length] = (byte) (b ^ (bArr3[1] & i));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & i) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((bArr3[3] & i) ^ bArr2[length3]);
        return bArr2;
    }

    private static byte[] lookupPoly(int i) {
        int i2 = i * 8;
        int i3 = 135;
        switch (i2) {
            case 64:
            case 320:
                i3 = 27;
                break;
            case 128:
            case 192:
                break;
            case 160:
                i3 = 45;
                break;
            case InterfaceC5102BERTags.f17976FLAGS /* 224 */:
                i3 = 777;
                break;
            case 256:
                i3 = 1061;
                break;
            case 384:
                i3 = 4109;
                break;
            case 448:
                i3 = 2129;
                break;
            case 512:
                i3 = 293;
                break;
            case 768:
                i3 = 655377;
                break;
            case 1024:
                i3 = 524355;
                break;
            case 2048:
                i3 = 548865;
                break;
            default:
                throw new IllegalArgumentException("Unknown block size for CMAC: " + i2);
        }
        return AbstractC6245Pack.intToBigEndian(i3);
    }

    private static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            int i2 = bArr[length] & C1126UByte.MAX_VALUE;
            bArr2[length] = (byte) (i | (i2 << 1));
            i = (i2 >>> 7) & 1;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.f20430bufOff == this.f20431cipher.getBlockSize()) {
            bArr2 = this.f20426Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.f20429buf, this.f20430bufOff);
            bArr2 = this.f20427Lu2;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.f20432mac;
            if (i2 >= bArr3.length) {
                this.f20431cipher.processBlock(this.f20429buf, 0, bArr3, 0);
                System.arraycopy(this.f20432mac, 0, bArr, i, this.f20433macSize);
                mo14977reset();
                return this.f20433macSize;
            }
            byte[] bArr4 = this.f20429buf;
            bArr4[i2] = (byte) (bArr4[i2] ^ bArr2[i2]);
            i2++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20431cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20433macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        validate(cipherParameters);
        this.f20431cipher.mo14946init(true, cipherParameters);
        byte[] bArr = this.f20428ZEROES;
        byte[] bArr2 = new byte[bArr.length];
        this.f20431cipher.processBlock(bArr, 0, bArr2, 0);
        byte[] bArrDoubleLu = doubleLu(bArr2);
        this.f20426Lu = bArrDoubleLu;
        this.f20427Lu2 = doubleLu(bArrDoubleLu);
        mo14977reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20429buf;
            if (i >= bArr.length) {
                this.f20430bufOff = 0;
                this.f20431cipher.mo14947reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        int i = this.f20430bufOff;
        byte[] bArr = this.f20429buf;
        if (i == bArr.length) {
            this.f20431cipher.processBlock(bArr, 0, this.f20432mac, 0);
            this.f20430bufOff = 0;
        }
        byte[] bArr2 = this.f20429buf;
        int i2 = this.f20430bufOff;
        this.f20430bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public void validate(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    public C5358CMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        }
        this.f20431cipher = CBCBlockCipher.newInstance(blockCipher);
        this.f20433macSize = i / 8;
        this.f20434poly = lookupPoly(blockCipher.getBlockSize());
        this.f20432mac = new byte[blockCipher.getBlockSize()];
        this.f20429buf = new byte[blockCipher.getBlockSize()];
        this.f20428ZEROES = new byte[blockCipher.getBlockSize()];
        this.f20430bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.f20431cipher.getBlockSize();
        int i3 = this.f20430bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20429buf, i3, i4);
            this.f20431cipher.processBlock(this.f20429buf, 0, this.f20432mac, 0);
            this.f20430bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.f20431cipher.processBlock(bArr, i, this.f20432mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20429buf, this.f20430bufOff, i2);
        this.f20430bufOff += i2;
    }
}
