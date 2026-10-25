package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class HashFunctions {

    /* renamed from: hashc */
    private static final byte[] f23569hashc = C6250Strings.toByteArray("expand 32-byte to 64-byte state!");

    /* renamed from: dig256 */
    private final InterfaceC5277Digest f23570dig256;

    /* renamed from: dig512 */
    private final InterfaceC5277Digest f23571dig512;

    /* renamed from: perm */
    private final C6100Permute f23572perm;

    public HashFunctions(InterfaceC5277Digest interfaceC5277Digest) {
        this(interfaceC5277Digest, null);
    }

    public InterfaceC5277Digest getMessageHash() {
        return this.f23571dig512;
    }

    public int hash_2n_n(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = new byte[64];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr3[i3] = bArr2[i2 + i3];
            bArr3[i3 + 32] = f23569hashc[i3];
        }
        this.f23572perm.chacha_permute(bArr3, bArr3);
        for (int i4 = 0; i4 < 32; i4++) {
            bArr3[i4] = (byte) (bArr3[i4] ^ bArr2[(i2 + i4) + 32]);
        }
        this.f23572perm.chacha_permute(bArr3, bArr3);
        for (int i5 = 0; i5 < 32; i5++) {
            bArr[i + i5] = bArr3[i5];
        }
        return 0;
    }

    public int hash_2n_n_mask(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        byte[] bArr4 = new byte[64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr4[i4] = (byte) (bArr2[i2 + i4] ^ bArr3[i3 + i4]);
        }
        return hash_2n_n(bArr, i, bArr4, 0);
    }

    public int hash_n_n(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = new byte[64];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr3[i3] = bArr2[i2 + i3];
            bArr3[i3 + 32] = f23569hashc[i3];
        }
        this.f23572perm.chacha_permute(bArr3, bArr3);
        for (int i4 = 0; i4 < 32; i4++) {
            bArr[i + i4] = bArr3[i4];
        }
        return 0;
    }

    public int hash_n_n_mask(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        byte[] bArr4 = new byte[32];
        for (int i4 = 0; i4 < 32; i4++) {
            bArr4[i4] = (byte) (bArr2[i2 + i4] ^ bArr3[i3 + i4]);
        }
        return hash_n_n(bArr, i, bArr4, 0);
    }

    public int varlen_hash(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.f23570dig256.mo14970update(bArr2, 0, i2);
        this.f23570dig256.mo14967doFinal(bArr, i);
        return 0;
    }

    public HashFunctions(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2) {
        this.f23572perm = new C6100Permute();
        this.f23570dig256 = interfaceC5277Digest;
        this.f23571dig512 = interfaceC5277Digest2;
    }
}
