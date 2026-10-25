package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.hash2curve.H2cUtils;
import org.bouncycastle.p194crypto.hash2curve.MessageExpansion;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XmdMessageExpansion implements MessageExpansion {

    /* renamed from: digest */
    private final InterfaceC5277Digest f20326digest;
    private final int hashOutputBytes;

    /* renamed from: s */
    private final int f20327s;

    public XmdMessageExpansion(InterfaceC5277Digest interfaceC5277Digest, int i, int i2) {
        this.f20326digest = interfaceC5277Digest;
        this.f20327s = i2;
        int digestSize = interfaceC5277Digest.getDigestSize();
        this.hashOutputBytes = digestSize;
        if (digestSize < ((int) Math.ceil((i * 2) / 8.0d))) {
            throw new IllegalArgumentException("Hash output size is too small for the security level of the curve");
        }
    }

    private static int getInputBlockSize(ExtendedDigest extendedDigest) {
        return extendedDigest.getByteLength() * 8;
    }

    /* renamed from: hash */
    private byte[] m15534hash(byte[] bArr) {
        InterfaceC5277Digest interfaceC5277DigestCloneDigest = DigestFactory.cloneDigest(this.f20326digest);
        interfaceC5277DigestCloneDigest.mo14970update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[this.f20326digest.getDigestSize()];
        interfaceC5277DigestCloneDigest.mo14967doFinal(bArr2, 0);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.hash2curve.MessageExpansion
    public byte[] expandMessage(byte[] bArr, byte[] bArr2, int i) {
        int iCeil = (int) Math.ceil(i / this.hashOutputBytes);
        if (iCeil > 255) {
            throw new IllegalArgumentException("Ell parameter must not be greater than 255. Current value = " + iCeil);
        }
        if (i > 65535) {
            throw new IllegalArgumentException("Output size must not be greater than 65535. Current value = " + i);
        }
        if (bArr2.length > 255) {
            throw new IllegalArgumentException("DST size must not be greater than 255. Current value = " + bArr2.length);
        }
        byte[] bArrConcatenate = C6238Arrays.concatenate(bArr2, H2cUtils.m15508i2osp(bArr2.length, 1));
        byte[] bArrConcatenate2 = C6238Arrays.concatenate(new byte[][]{H2cUtils.m15508i2osp(0, this.f20327s / 8), bArr, H2cUtils.m15508i2osp(i, 2), H2cUtils.m15508i2osp(0, 1), bArrConcatenate});
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, iCeil + 1, this.hashOutputBytes);
        byte[] bArrM15534hash = m15534hash(bArrConcatenate2);
        bArr3[0] = bArrM15534hash;
        byte[] bArrM15534hash2 = m15534hash(C6238Arrays.concatenate(bArrM15534hash, H2cUtils.m15508i2osp(1, 1), bArrConcatenate));
        bArr3[1] = bArrM15534hash2;
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArrM15534hash2);
        for (int i2 = 2; i2 <= iCeil; i2++) {
            byte[] bArrM15534hash3 = m15534hash(C6238Arrays.concatenate(H2cUtils.m15513xor(bArr3[0], bArr3[i2 - 1]), H2cUtils.m15508i2osp(i2, 1), bArrConcatenate));
            bArr3[i2] = bArrM15534hash3;
            bArrM18231clone = C6238Arrays.concatenate(bArrM18231clone, bArrM15534hash3);
        }
        return C6238Arrays.copyOfRange(bArrM18231clone, 0, i);
    }

    public XmdMessageExpansion(ExtendedDigest extendedDigest, int i) {
        this(extendedDigest, i, getInputBlockSize(extendedDigest));
    }
}
