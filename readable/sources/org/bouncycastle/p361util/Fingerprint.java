package org.bouncycastle.p361util;

import org.bouncycastle.p194crypto.p199digests.SHA512tDigest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;

/* loaded from: classes2.dex */
public class Fingerprint {
    private static char[] encodingTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] fingerprint;

    public Fingerprint(byte[] bArr) {
        this(bArr, 160);
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        return calculateFingerprint(bArr, 160);
    }

    @Deprecated
    public static byte[] calculateFingerprintSHA512_160(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest(160);
        sHA512tDigest.mo14970update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.getDigestSize()];
        sHA512tDigest.mo14967doFinal(bArr2, 0);
        return bArr2;
    }

    /* renamed from: equals */
    public boolean m18284equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return C6238Arrays.areEqual(((Fingerprint) obj).fingerprint, this.fingerprint);
        }
        return false;
    }

    public byte[] getFingerprint() {
        return C6238Arrays.m18231clone(this.fingerprint);
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != this.fingerprint.length; i++) {
            if (i > 0) {
                sb.append(":");
            }
            sb.append(encodingTable[(this.fingerprint[i] >>> 4) & 15]);
            sb.append(encodingTable[this.fingerprint[i] & 15]);
        }
        return sb.toString();
    }

    public Fingerprint(byte[] bArr, int i) {
        this.fingerprint = calculateFingerprint(bArr, i);
    }

    public static byte[] calculateFingerprint(byte[] bArr, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        int i2 = i / 8;
        byte[] bArr2 = new byte[i2];
        sHAKEDigest.mo14998doFinal(bArr2, 0, i2);
        return bArr2;
    }

    @Deprecated
    public Fingerprint(byte[] bArr, boolean z) {
        if (z) {
            this.fingerprint = calculateFingerprintSHA512_160(bArr);
        } else {
            this.fingerprint = calculateFingerprint(bArr);
        }
    }
}
