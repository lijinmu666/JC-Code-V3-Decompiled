package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.CSHAKEDigest;
import org.bouncycastle.p194crypto.p199digests.EncodableDigest;
import org.bouncycastle.p194crypto.p199digests.XofUtils;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Memoable;

/* renamed from: org.bouncycastle.crypto.macs.KMAC */
/* loaded from: classes2.dex */
public class C5362KMAC implements InterfaceC5278Mac, InterfaceC5284Xof, Memoable, EncodableDigest {

    /* renamed from: padding */
    private static final byte[] f20461padding = new byte[100];
    private int bitLength;

    /* renamed from: cshake */
    private final CSHAKEDigest f20462cshake;
    private boolean firstOutput;
    private boolean initialised;

    /* renamed from: key */
    private byte[] f20463key;
    private int outputLength;

    public C5362KMAC(int i, byte[] bArr) {
        this.f20462cshake = new CSHAKEDigest(i, C6250Strings.toByteArray("KMAC"), bArr);
        this.bitLength = i;
        this.outputLength = (i * 2) / 8;
    }

    /* renamed from: bytePad */
    private void m15586bytePad(byte[] bArr, int i) {
        byte[] bArrLeftEncode = XofUtils.leftEncode(i);
        mo14979update(bArrLeftEncode, 0, bArrLeftEncode.length);
        byte[] bArrM15588encode = m15588encode(bArr);
        mo14979update(bArrM15588encode, 0, bArrM15588encode.length);
        int length = i - ((bArrLeftEncode.length + bArrM15588encode.length) % i);
        if (length <= 0 || length == i) {
            return;
        }
        while (true) {
            byte[] bArr2 = f20461padding;
            if (length <= bArr2.length) {
                mo14979update(bArr2, 0, length);
                return;
            } else {
                mo14979update(bArr2, 0, bArr2.length);
                length -= bArr2.length;
            }
        }
    }

    /* renamed from: copyIn */
    private void m15587copyIn(C5362KMAC c5362kmac) {
        this.f20462cshake.mo14824reset(c5362kmac.f20462cshake);
        this.bitLength = c5362kmac.bitLength;
        this.outputLength = c5362kmac.outputLength;
        this.initialised = c5362kmac.initialised;
        this.firstOutput = c5362kmac.firstOutput;
    }

    /* renamed from: encode */
    private static byte[] m15588encode(byte[] bArr) {
        return C6238Arrays.concatenate(XofUtils.leftEncode(bArr.length * 8), bArr);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new C5362KMAC(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(getMacSize() * 8);
            this.f20462cshake.mo14970update(bArrRightEncode, 0, bArrRightEncode.length);
        }
        int iMo14998doFinal = this.f20462cshake.mo14998doFinal(bArr, i, getMacSize());
        mo14977reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(0L);
            this.f20462cshake.mo14970update(bArrRightEncode, 0, bArrRightEncode.length);
            this.firstOutput = false;
        }
        return this.f20462cshake.doOutput(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "KMAC" + this.f20462cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.f20462cshake.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialised");
        }
        byte[] encodedState = this.f20462cshake.getEncodedState();
        byte[] bArr = new byte[10];
        AbstractC6245Pack.intToBigEndian(this.bitLength, bArr, 0);
        AbstractC6245Pack.intToBigEndian(this.outputLength, bArr, 4);
        bArr[8] = this.initialised;
        bArr[9] = this.firstOutput;
        byte[] bArr2 = this.f20463key;
        byte[] bArr3 = new byte[bArr2.length + 1 + encodedState.length + 10];
        bArr3[0] = (byte) bArr2.length;
        System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
        System.arraycopy(encodedState, 0, bArr3, this.f20463key.length + 1, encodedState.length);
        System.arraycopy(bArr, 0, bArr3, this.f20463key.length + 1 + encodedState.length, 10);
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        byte[] bArrM18231clone = C6238Arrays.m18231clone(((KeyParameter) cipherParameters).m15773getKey());
        this.f20463key = bArrM18231clone;
        if (bArrM18231clone.length > 255) {
            throw new IllegalArgumentException("key length must be between 0 and 2040 bits");
        }
        this.initialised = true;
        mo14977reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.f20462cshake.mo14968reset();
        byte[] bArr = this.f20463key;
        if (bArr != null) {
            m15586bytePad(bArr, this.bitLength == 128 ? 168 : 136);
        }
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.f20462cshake.mo14969update(b);
    }

    public C5362KMAC(C5362KMAC c5362kmac) {
        this.f20462cshake = new CSHAKEDigest(c5362kmac.f20462cshake);
        this.bitLength = c5362kmac.bitLength;
        this.outputLength = c5362kmac.outputLength;
        this.f20463key = c5362kmac.f20463key;
        this.initialised = c5362kmac.initialised;
        this.firstOutput = c5362kmac.firstOutput;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(i2 * 8);
            this.f20462cshake.mo14970update(bArrRightEncode, 0, bArrRightEncode.length);
        }
        int iMo14998doFinal = this.f20462cshake.mo14998doFinal(bArr, i, i2);
        mo14977reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15587copyIn((C5362KMAC) memoable);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.f20462cshake.mo14970update(bArr, i, i2);
    }

    public C5362KMAC(byte[] bArr) {
        byte[] bArr2 = new byte[bArr[0] & 255];
        this.f20463key = bArr2;
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        this.f20462cshake = new CSHAKEDigest(C6238Arrays.copyOfRange(bArr, this.f20463key.length + 1, bArr.length - 10));
        this.bitLength = AbstractC6245Pack.bigEndianToInt(bArr, bArr.length - 10);
        this.outputLength = AbstractC6245Pack.bigEndianToInt(bArr, bArr.length - 6);
        this.initialised = bArr[bArr.length + (-2)] != 0;
        this.firstOutput = bArr[bArr.length - 1] != 0;
    }
}
