package org.bouncycastle.p194crypto.p199digests;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;

/* loaded from: classes2.dex */
public class Haraka256Digest extends HarakaBase {

    /* renamed from: buffer */
    private final byte[] f19393buffer;

    /* renamed from: off */
    private int f19394off;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19395purpose;

    public Haraka256Digest() {
        this(CryptoServicePurpose.ANY);
    }

    private int haraka256256(byte[] bArr, byte[] bArr2, int i) {
        Class cls = Byte.TYPE;
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) cls, 2, 16);
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) cls, 2, 16);
        System.arraycopy(bArr, 0, bArr3[0], 0, 16);
        System.arraycopy(bArr, 16, bArr3[1], 0, 16);
        byte[] bArr5 = bArr3[0];
        byte[][] bArr6 = HarakaBase.f19399RC;
        bArr3[0] = HarakaBase.m15079aesEnc(bArr5, bArr6[0]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[1]);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr3[0], bArr6[2]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[3]);
        m15077mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr4[0], bArr6[4]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr4[1], bArr6[5]);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr3[0], bArr6[6]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[7]);
        m15077mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr4[0], bArr6[8]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr4[1], bArr6[9]);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr3[0], bArr6[10]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[11]);
        m15077mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr4[0], bArr6[12]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr4[1], bArr6[13]);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr3[0], bArr6[14]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[15]);
        m15077mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr4[0], bArr6[16]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr4[1], bArr6[17]);
        bArr3[0] = HarakaBase.m15079aesEnc(bArr3[0], bArr6[18]);
        bArr3[1] = HarakaBase.m15079aesEnc(bArr3[1], bArr6[19]);
        m15077mix256(bArr3, bArr4);
        C6240Bytes.m18274xor(16, bArr4[0], 0, bArr, 0, bArr2, i);
        C6240Bytes.m18274xor(16, bArr4[1], 0, bArr, 16, bArr2, i + 16);
        return 32;
    }

    /* renamed from: mix256 */
    private void m15077mix256(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 0, bArr2[0], 0, 4);
        System.arraycopy(bArr[1], 0, bArr2[0], 4, 4);
        System.arraycopy(bArr[0], 4, bArr2[0], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[0], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[1], 0, 4);
        System.arraycopy(bArr[1], 8, bArr2[1], 4, 4);
        System.arraycopy(bArr[0], 12, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 12, bArr2[1], 12, 4);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        if (this.f19394off != 32) {
            throw new IllegalStateException("input must be exactly 32 bytes");
        }
        if (bArr.length - i < 32) {
            throw new IllegalArgumentException("output too short to receive digest");
        }
        int iHaraka256256 = haraka256256(this.f19393buffer, bArr, i);
        mo14968reset();
        return iHaraka256256;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "Haraka-256";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19394off = 0;
        C6238Arrays.m18227clear(this.f19393buffer);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        int i = this.f19394off;
        if (i > 31) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        byte[] bArr = this.f19393buffer;
        this.f19394off = i + 1;
        bArr[i] = b;
    }

    public Haraka256Digest(CryptoServicePurpose cryptoServicePurpose) {
        this.f19395purpose = cryptoServicePurpose;
        this.f19393buffer = new byte[32];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize() * 4, cryptoServicePurpose));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3 = this.f19394off;
        if (i3 > 32 - i2) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        System.arraycopy(bArr, i, this.f19393buffer, i3, i2);
        this.f19394off += i2;
    }

    public Haraka256Digest(Haraka256Digest haraka256Digest) {
        CryptoServicePurpose cryptoServicePurpose = haraka256Digest.f19395purpose;
        this.f19395purpose = cryptoServicePurpose;
        this.f19393buffer = C6238Arrays.m18231clone(haraka256Digest.f19393buffer);
        this.f19394off = haraka256Digest.f19394off;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize() * 4, cryptoServicePurpose));
    }
}
