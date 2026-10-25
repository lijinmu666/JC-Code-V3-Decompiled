package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p199digests.DSTU7564Digest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class DSTU7564Mac implements InterfaceC5278Mac {
    private static final int BITS_IN_BYTE = 8;

    /* renamed from: engine */
    private DSTU7564Digest f20435engine;
    private long inputLength;

    /* renamed from: macSize */
    private int f20436macSize;
    private byte[] paddedKey = null;
    private byte[] invertedKey = null;

    public DSTU7564Mac(int i) {
        this.f20435engine = new DSTU7564Digest(i);
        this.f20436macSize = i / 8;
    }

    /* renamed from: pad */
    private void m15581pad() {
        int byteLength = this.f20435engine.getByteLength() - ((int) (this.inputLength % this.f20435engine.getByteLength()));
        if (byteLength < 13) {
            byteLength += this.f20435engine.getByteLength();
        }
        byte[] bArr = new byte[byteLength];
        bArr[0] = ByteCompanionObject.MIN_VALUE;
        AbstractC6245Pack.longToLittleEndian(this.inputLength * 8, bArr, byteLength - 12);
        this.f20435engine.mo14970update(bArr, 0, byteLength);
    }

    /* renamed from: padKey */
    private byte[] m15582padKey(byte[] bArr) {
        int length = (((bArr.length + this.f20435engine.getByteLength()) - 1) / this.f20435engine.getByteLength()) * this.f20435engine.getByteLength();
        if (length - bArr.length < 13) {
            length += this.f20435engine.getByteLength();
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr.length] = ByteCompanionObject.MIN_VALUE;
        AbstractC6245Pack.intToLittleEndian(bArr.length * 8, bArr2, length - 12);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        if (this.paddedKey == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (bArr.length - i < this.f20436macSize) {
            throw new OutputLengthException("Output buffer too short");
        }
        m15581pad();
        DSTU7564Digest dSTU7564Digest = this.f20435engine;
        byte[] bArr2 = this.invertedKey;
        dSTU7564Digest.mo14970update(bArr2, 0, bArr2.length);
        this.inputLength = 0L;
        int iMo14967doFinal = this.f20435engine.mo14967doFinal(bArr, i);
        mo14977reset();
        return iMo14967doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "DSTU7564Mac";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20436macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        this.paddedKey = null;
        mo14977reset();
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Bad parameter passed");
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        this.invertedKey = new byte[bArrM15773getKey.length];
        this.paddedKey = m15582padKey(bArrM15773getKey);
        int i = 0;
        while (true) {
            byte[] bArr = this.invertedKey;
            if (i >= bArr.length) {
                DSTU7564Digest dSTU7564Digest = this.f20435engine;
                byte[] bArr2 = this.paddedKey;
                dSTU7564Digest.mo14970update(bArr2, 0, bArr2.length);
                return;
            }
            bArr[i] = (byte) (~bArrM15773getKey[i]);
            i++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.inputLength = 0L;
        this.f20435engine.mo14968reset();
        byte[] bArr = this.paddedKey;
        if (bArr != null) {
            this.f20435engine.mo14970update(bArr, 0, bArr.length);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20435engine.mo14969update(b);
        this.inputLength++;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        }
        if (this.paddedKey != null) {
            this.f20435engine.mo14970update(bArr, i, i2);
            this.inputLength += i2;
        } else {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
    }
}
