package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public interface AEADCipher {
    /* renamed from: doFinal */
    int mo15224doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    /* renamed from: getMac */
    byte[] mo15225getMac();

    int getOutputSize(int i);

    int getUpdateOutputSize(int i);

    /* renamed from: init */
    void mo15226init(boolean z, CipherParameters cipherParameters);

    void processAADByte(byte b);

    void processAADBytes(byte[] bArr, int i, int i2);

    int processByte(byte b, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: reset */
    void mo15228reset();
}
