package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine;

/* loaded from: classes2.dex */
public final class Zuc128Mac implements InterfaceC5278Mac {

    /* renamed from: TOPBIT */
    private static final int f20510TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc128Engine theEngine = new InternalZuc128Engine();
    private final int[] theKeyStream = new int[2];

    /* renamed from: theMac */
    private int f20511theMac;
    private Zuc128CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc128Engine extends Zuc128CoreEngine {
        private InternalZuc128Engine() {
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    private int getFinalWord() {
        if (this.theByteIndex != 0) {
            return this.theEngine.createKeyStreamWord();
        }
        int i = this.theWordIndex + 1;
        int[] iArr = this.theKeyStream;
        int length = i % iArr.length;
        this.theWordIndex = length;
        return iArr[length];
    }

    private int getKeyStreamWord(int i) {
        int[] iArr = this.theKeyStream;
        int i2 = this.theWordIndex;
        int i3 = iArr[i2];
        if (i == 0) {
            return i3;
        }
        int i4 = iArr[(i2 + 1) % iArr.length];
        return (i4 >>> (32 - i)) | (i3 << i);
    }

    private void initKeyStream() {
        int i = 0;
        this.f20511theMac = 0;
        while (true) {
            int[] iArr = this.theKeyStream;
            if (i >= iArr.length - 1) {
                this.theWordIndex = iArr.length - 1;
                this.theByteIndex = 3;
                return;
            } else {
                iArr[i] = this.theEngine.createKeyStreamWord();
                i++;
            }
        }
    }

    private void shift4NextByte() {
        int i = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i;
        if (i == 0) {
            this.theKeyStream[this.theWordIndex] = this.theEngine.createKeyStreamWord();
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void updateMac(int i) {
        this.f20511theMac = getKeyStreamWord(i) ^ this.f20511theMac;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        shift4NextByte();
        int keyStreamWord = this.f20511theMac ^ getKeyStreamWord(this.theByteIndex * 8);
        this.f20511theMac = keyStreamWord;
        int finalWord = keyStreamWord ^ getFinalWord();
        this.f20511theMac = finalWord;
        Zuc128CoreEngine.encode32be(finalWord, bArr, i);
        mo14977reset();
        return getMacSize();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "Zuc128Mac";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 4;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        this.theEngine.mo14993init(true, cipherParameters);
        this.theState = (Zuc128CoreEngine) this.theEngine.mo14823copy();
        initKeyStream();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        Zuc128CoreEngine zuc128CoreEngine = this.theState;
        if (zuc128CoreEngine != null) {
            this.theEngine.mo14824reset(zuc128CoreEngine);
        }
        initKeyStream();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        shift4NextByte();
        int i = this.theByteIndex * 8;
        int i2 = 128;
        int i3 = 0;
        while (i2 > 0) {
            if ((b & i2) != 0) {
                updateMac(i + i3);
            }
            i2 >>= 1;
            i3++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            mo14978update(bArr[i + i3]);
        }
    }
}
