package org.bouncycastle.p194crypto.p205hpke;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.crypto.hpke.HKDF */
/* loaded from: classes2.dex */
class C5350HKDF {
    private static final byte[] VERSION_LABEL = getBytes("HPKE-v1");
    private final int hashLength;

    /* renamed from: kdf */
    private final HKDFBytesGenerator f20339kdf;

    public C5350HKDF(short s) {
        InterfaceC5277Digest sHA256Digest;
        if (s == 1) {
            sHA256Digest = new SHA256Digest();
        } else if (s == 2) {
            sHA256Digest = new SHA384Digest();
        } else {
            if (s != 3) {
                throw new IllegalArgumentException("invalid kdf id");
            }
            sHA256Digest = new SHA512Digest();
        }
        this.f20339kdf = new HKDFBytesGenerator(sHA256Digest);
        this.hashLength = sHA256Digest.getDigestSize();
    }

    private static byte[] getBytes(String str) {
        return C6250Strings.toByteArray(str);
    }

    /* renamed from: Expand */
    public byte[] m15543Expand(byte[] bArr, byte[] bArr2, int i) {
        if (i > 65536) {
            throw new IllegalArgumentException("Expand length cannot be larger than 2^16");
        }
        this.f20339kdf.mo14966init(HKDFParameters.skipExtractParameters(bArr, bArr2));
        byte[] bArr3 = new byte[i];
        this.f20339kdf.generateBytes(bArr3, 0, i);
        return bArr3;
    }

    /* renamed from: Extract */
    public byte[] m15544Extract(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[this.hashLength];
        }
        return this.f20339kdf.extractPRK(bArr, bArr2);
    }

    public byte[] LabeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) {
        if (i > 65536) {
            throw new IllegalArgumentException("Expand length cannot be larger than 2^16");
        }
        this.f20339kdf.mo14966init(HKDFParameters.skipExtractParameters(bArr, C6238Arrays.concatenate(C6238Arrays.concatenate(AbstractC6245Pack.shortToBigEndian((short) i), VERSION_LABEL, bArr2, getBytes(str)), bArr3)));
        byte[] bArr4 = new byte[i];
        this.f20339kdf.generateBytes(bArr4, 0, i);
        return bArr4;
    }

    public byte[] LabeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        if (bArr == null) {
            bArr = new byte[this.hashLength];
        }
        return this.f20339kdf.extractPRK(bArr, C6238Arrays.concatenate(VERSION_LABEL, bArr2, getBytes(str), bArr3));
    }

    public int getHashSize() {
        return this.hashLength;
    }
}
