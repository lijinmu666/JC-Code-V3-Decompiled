package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HC128Engine implements StreamCipher {
    private boolean initialised;

    /* renamed from: iv */
    private byte[] f19904iv;

    /* renamed from: key */
    private byte[] f19905key;

    /* renamed from: p */
    private int[] f19906p = new int[512];

    /* renamed from: q */
    private int[] f19907q = new int[512];

    /* renamed from: cnt */
    private int f19902cnt = 0;

    /* renamed from: buf */
    private byte[] f19901buf = new byte[4];

    /* renamed from: idx */
    private int f19903idx = 0;

    /* renamed from: dim */
    private static int m15329dim(int i, int i2) {
        return m15339mod512(i - i2);
    }

    /* renamed from: f1 */
    private static int m15330f1(int i) {
        return (i >>> 3) ^ (rotateRight(i, 7) ^ rotateRight(i, 18));
    }

    /* renamed from: f2 */
    private static int m15331f2(int i) {
        return (i >>> 10) ^ (rotateRight(i, 17) ^ rotateRight(i, 19));
    }

    /* renamed from: g1 */
    private int m15332g1(int i, int i2, int i3) {
        return (rotateRight(i, 10) ^ rotateRight(i3, 23)) + rotateRight(i2, 8);
    }

    /* renamed from: g2 */
    private int m15333g2(int i, int i2, int i3) {
        return (rotateLeft(i, 10) ^ rotateLeft(i3, 23)) + rotateLeft(i2, 8);
    }

    /* renamed from: getByte */
    private byte m15334getByte() {
        if (this.f19903idx == 0) {
            int iM15340step = m15340step();
            byte[] bArr = this.f19901buf;
            bArr[0] = (byte) (iM15340step & 255);
            bArr[1] = (byte) ((iM15340step >> 8) & 255);
            bArr[2] = (byte) ((iM15340step >> 16) & 255);
            bArr[3] = (byte) ((iM15340step >> 24) & 255);
        }
        byte[] bArr2 = this.f19901buf;
        int i = this.f19903idx;
        byte b = bArr2[i];
        this.f19903idx = 3 & (i + 1);
        return b;
    }

    /* renamed from: h1 */
    private int m15335h1(int i) {
        int[] iArr = this.f19907q;
        return iArr[i & 255] + iArr[((i >> 16) & 255) + 256];
    }

    /* renamed from: h2 */
    private int m15336h2(int i) {
        int[] iArr = this.f19906p;
        return iArr[i & 255] + iArr[((i >> 16) & 255) + 256];
    }

    /* renamed from: init */
    private void m15337init() {
        if (this.f19905key.length != 16) {
            throw new IllegalArgumentException("The key must be 128 bits long");
        }
        if (this.f19904iv.length != 16) {
            throw new IllegalArgumentException("The IV must be 128 bits long");
        }
        this.f19903idx = 0;
        this.f19902cnt = 0;
        int[] iArr = new int[1280];
        for (int i = 0; i < 16; i++) {
            int i2 = i >> 2;
            iArr[i2] = ((this.f19905key[i] & C1126UByte.MAX_VALUE) << ((i & 3) * 8)) | iArr[i2];
        }
        System.arraycopy(iArr, 0, iArr, 4, 4);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f19904iv;
            if (i3 >= bArr.length || i3 >= 16) {
                break;
            }
            int i4 = (i3 >> 2) + 8;
            iArr[i4] = ((bArr[i3] & C1126UByte.MAX_VALUE) << ((i3 & 3) * 8)) | iArr[i4];
            i3++;
        }
        System.arraycopy(iArr, 8, iArr, 12, 4);
        for (int i5 = 16; i5 < 1280; i5++) {
            iArr[i5] = m15331f2(iArr[i5 - 2]) + iArr[i5 - 7] + m15330f1(iArr[i5 - 15]) + iArr[i5 - 16] + i5;
        }
        System.arraycopy(iArr, 256, this.f19906p, 0, 512);
        System.arraycopy(iArr, 768, this.f19907q, 0, 512);
        for (int i6 = 0; i6 < 512; i6++) {
            this.f19906p[i6] = m15340step();
        }
        for (int i7 = 0; i7 < 512; i7++) {
            this.f19907q[i7] = m15340step();
        }
        this.f19902cnt = 0;
    }

    /* renamed from: mod1024 */
    private static int m15338mod1024(int i) {
        return i & 1023;
    }

    /* renamed from: mod512 */
    private static int m15339mod512(int i) {
        return i & 511;
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private static int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: step */
    private int m15340step() {
        int iM15336h2;
        int i;
        int iM15339mod512 = m15339mod512(this.f19902cnt);
        if (this.f19902cnt < 512) {
            int[] iArr = this.f19906p;
            iArr[iM15339mod512] = iArr[iM15339mod512] + m15332g1(iArr[m15329dim(iM15339mod512, 3)], this.f19906p[m15329dim(iM15339mod512, 10)], this.f19906p[m15329dim(iM15339mod512, 511)]);
            iM15336h2 = m15335h1(this.f19906p[m15329dim(iM15339mod512, 12)]);
            i = this.f19906p[iM15339mod512];
        } else {
            int[] iArr2 = this.f19907q;
            iArr2[iM15339mod512] = iArr2[iM15339mod512] + m15333g2(iArr2[m15329dim(iM15339mod512, 3)], this.f19907q[m15329dim(iM15339mod512, 10)], this.f19907q[m15329dim(iM15339mod512, 511)]);
            iM15336h2 = m15336h2(this.f19907q[m15329dim(iM15339mod512, 12)]);
            i = this.f19907q[iM15339mod512];
        }
        int i2 = i ^ iM15336h2;
        this.f19902cnt = m15338mod1024(this.f19902cnt + 1);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-128";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m15334getByte());
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        m15337init();
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        return (byte) (m15334getByte() ^ b);
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("no IV passed");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        this.f19904iv = parametersWithIV.m15801getIV();
        CipherParameters parameters = parametersWithIV.getParameters();
        if (!(parameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Invalid parameter passed to HC128 init - " + cipherParameters.getClass().getName());
        }
        this.f19905key = ((KeyParameter) parameters).m15773getKey();
        m15337init();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, C5342Utils.getPurpose(z)));
        this.initialised = true;
    }
}
