package org.bouncycastle.p194crypto.p215prng.p216drbg;

import java.util.Hashtable;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HashSP800DRBG implements SP80090DRBG {
    private static final int MAX_BITS_REQUEST = 262144;

    /* renamed from: ONE */
    private static final byte[] f20926ONE = {1};
    private static final long RESEED_MAX = 140737488355328L;
    private static final Hashtable seedlens;

    /* renamed from: _C */
    private byte[] f20927_C;

    /* renamed from: _V */
    private byte[] f20928_V;

    /* renamed from: _digest */
    private InterfaceC5277Digest f20929_digest;
    private EntropySource _entropySource;
    private long _reseedCounter;
    private int _securityStrength;
    private int _seedLength;

    static {
        Hashtable hashtable = new Hashtable();
        seedlens = hashtable;
        hashtable.put("SHA-1", Integers.m18296valueOf(440));
        hashtable.put("SHA-224", Integers.m18296valueOf(440));
        hashtable.put(XMSSKeyParameters.f23621SHA_256, Integers.m18296valueOf(440));
        hashtable.put(SPHINCSKeyParameters.SHA512_256, Integers.m18296valueOf(440));
        hashtable.put("SHA-512/224", Integers.m18296valueOf(440));
        hashtable.put("SHA-384", Integers.m18296valueOf(888));
        hashtable.put(XMSSKeyParameters.f23622SHA_512, Integers.m18296valueOf(888));
    }

    public HashSP800DRBG(InterfaceC5277Digest interfaceC5277Digest, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > C5379Utils.getMaxSecurityStrength(interfaceC5277Digest)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (entropySource.entropySize() < i) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this.f20929_digest = interfaceC5277Digest;
        this._entropySource = entropySource;
        this._securityStrength = i;
        this._seedLength = ((Integer) seedlens.get(interfaceC5277Digest.getAlgorithmName())).intValue();
        byte[] bArrM15855hash_df = C5379Utils.m15855hash_df(this.f20929_digest, C6238Arrays.concatenate(getEntropy(), bArr2, bArr), this._seedLength);
        this.f20928_V = bArrM15855hash_df;
        byte[] bArr3 = new byte[bArrM15855hash_df.length + 1];
        System.arraycopy(bArrM15855hash_df, 0, bArr3, 1, bArrM15855hash_df.length);
        this.f20927_C = C5379Utils.m15855hash_df(this.f20929_digest, bArr3, this._seedLength);
        this._reseedCounter = 1L;
    }

    /* renamed from: addTo */
    private void m15851addTo(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 1; i2 <= bArr2.length; i2++) {
            int i3 = (bArr[bArr.length - i2] & C1126UByte.MAX_VALUE) + (bArr2[bArr2.length - i2] & C1126UByte.MAX_VALUE) + i;
            i = i3 > 255 ? 1 : 0;
            bArr[bArr.length - i2] = (byte) i3;
        }
        for (int length = bArr2.length + 1; length <= bArr.length; length++) {
            int i4 = (bArr[bArr.length - length] & C1126UByte.MAX_VALUE) + i;
            i = i4 > 255 ? 1 : 0;
            bArr[bArr.length - length] = (byte) i4;
        }
    }

    /* renamed from: doHash */
    private void m15852doHash(byte[] bArr, byte[] bArr2) {
        this.f20929_digest.mo14970update(bArr, 0, bArr.length);
        this.f20929_digest.mo14967doFinal(bArr2, 0);
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    /* renamed from: hash */
    private byte[] m15853hash(byte[] bArr) {
        byte[] bArr2 = new byte[this.f20929_digest.getDigestSize()];
        m15852doHash(bArr, bArr2);
        return bArr2;
    }

    /* renamed from: hashgen */
    private byte[] m15854hashgen(byte[] bArr, int i) {
        int i2 = i / 8;
        int digestSize = i2 / this.f20929_digest.getDigestSize();
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = new byte[i2];
        int digestSize2 = this.f20929_digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        for (int i3 = 0; i3 <= digestSize; i3++) {
            m15852doHash(bArr2, bArr4);
            int i4 = i3 * digestSize2;
            int i5 = i2 - i4;
            if (i5 > digestSize2) {
                i5 = digestSize2;
            }
            System.arraycopy(bArr4, 0, bArr3, i4, i5);
            m15851addTo(bArr2, f20926ONE);
        }
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this._reseedCounter > RESEED_MAX) {
            return -1;
        }
        if (z) {
            mo15845reseed(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            byte[] bArr3 = this.f20928_V;
            byte[] bArr4 = new byte[bArr3.length + 1 + bArr2.length];
            bArr4[0] = 2;
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            System.arraycopy(bArr2, 0, bArr4, this.f20928_V.length + 1, bArr2.length);
            m15851addTo(this.f20928_V, m15853hash(bArr4));
        }
        byte[] bArrM15854hashgen = m15854hashgen(this.f20928_V, length);
        byte[] bArr5 = this.f20928_V;
        byte[] bArr6 = new byte[bArr5.length + 1];
        System.arraycopy(bArr5, 0, bArr6, 1, bArr5.length);
        bArr6[0] = 3;
        m15851addTo(this.f20928_V, m15853hash(bArr6));
        m15851addTo(this.f20928_V, this.f20927_C);
        m15851addTo(this.f20928_V, new byte[]{(byte) (r6 >> 24), (byte) (r6 >> 16), (byte) (r6 >> 8), (byte) this._reseedCounter});
        this._reseedCounter++;
        System.arraycopy(bArrM15854hashgen, 0, bArr, 0, bArr.length);
        return length;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int getBlockSize() {
        return this.f20929_digest.getDigestSize() * 8;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    /* renamed from: reseed */
    public void mo15845reseed(byte[] bArr) {
        byte[] bArrM15855hash_df = C5379Utils.m15855hash_df(this.f20929_digest, C6238Arrays.concatenate(f20926ONE, this.f20928_V, getEntropy(), bArr), this._seedLength);
        this.f20928_V = bArrM15855hash_df;
        byte[] bArr2 = new byte[bArrM15855hash_df.length + 1];
        bArr2[0] = 0;
        System.arraycopy(bArrM15855hash_df, 0, bArr2, 1, bArrM15855hash_df.length);
        this.f20927_C = C5379Utils.m15855hash_df(this.f20929_digest, bArr2, this._seedLength);
        this._reseedCounter = 1L;
    }
}
