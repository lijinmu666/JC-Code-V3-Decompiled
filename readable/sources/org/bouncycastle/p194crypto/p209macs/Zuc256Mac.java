package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine;
import org.bouncycastle.p194crypto.p201engines.Zuc256CoreEngine;

/* loaded from: classes2.dex */
public final class Zuc256Mac implements InterfaceC5278Mac {

    /* renamed from: TOPBIT */
    private static final int f20512TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc256Engine theEngine;
    private final int[] theKeyStream;

    /* renamed from: theMac */
    private final int[] f20513theMac;
    private final int theMacLength;
    private Zuc256CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc256Engine extends Zuc256CoreEngine {
        public InternalZuc256Engine(int i) {
            super(i);
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    public Zuc256Mac(int i) {
        this.theEngine = new InternalZuc256Engine(i);
        this.theMacLength = i;
        int i2 = i / 32;
        this.f20513theMac = new int[i2];
        this.theKeyStream = new int[i2 + 1];
    }

    private int getKeyStreamWord(int i, int i2) {
        int[] iArr = this.theKeyStream;
        int i3 = this.theWordIndex;
        int i4 = iArr[(i3 + i) % iArr.length];
        if (i2 == 0) {
            return i4;
        }
        int i5 = iArr[((i3 + i) + 1) % iArr.length];
        return (i5 >>> (32 - i2)) | (i4 << i2);
    }

    private void initKeyStream() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f20513theMac;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = this.theEngine.createKeyStreamWord();
            i2++;
        }
        while (true) {
            int[] iArr2 = this.theKeyStream;
            if (i >= iArr2.length - 1) {
                this.theWordIndex = iArr2.length - 1;
                this.theByteIndex = 3;
                return;
            } else {
                iArr2[i] = this.theEngine.createKeyStreamWord();
                i++;
            }
        }
    }

    private void shift4Final() {
        int i = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i;
        if (i == 0) {
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
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
        int i2 = 0;
        while (true) {
            int[] iArr = this.f20513theMac;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ getKeyStreamWord(i2, i);
            i2++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        shift4Final();
        updateMac(this.theByteIndex * 8);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f20513theMac;
            if (i2 >= iArr.length) {
                mo14977reset();
                return getMacSize();
            }
            Zuc128CoreEngine.encode32be(iArr[i2], bArr, (i2 * 4) + i);
            i2++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "Zuc256Mac-" + this.theMacLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.theMacLength / 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        this.theEngine.mo14993init(true, cipherParameters);
        this.theState = (Zuc256CoreEngine) this.theEngine.mo14823copy();
        initKeyStream();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        Zuc256CoreEngine zuc256CoreEngine = this.theState;
        if (zuc256CoreEngine != null) {
            this.theEngine.mo14824reset(zuc256CoreEngine);
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
