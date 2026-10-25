package org.bouncycastle.p249jcajce.provider.p267digest;

import java.security.DigestException;
import java.security.MessageDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
public class BCMessageDigest extends MessageDigest {

    /* renamed from: digest */
    protected InterfaceC5277Digest f21665digest;
    protected int digestSize;

    public BCMessageDigest(InterfaceC5277Digest interfaceC5277Digest) {
        super(interfaceC5277Digest.getAlgorithmName());
        this.f21665digest = interfaceC5277Digest;
        this.digestSize = interfaceC5277Digest.getDigestSize();
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        int i3 = this.digestSize;
        if (i2 < i3) {
            throw new DigestException("partial digests not returned");
        }
        if (bArr.length - i < i3) {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
        this.f21665digest.mo14967doFinal(bArr, i);
        return this.digestSize;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.digestSize;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.f21665digest.mo14968reset();
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        this.f21665digest.mo14969update(b);
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArr = new byte[this.digestSize];
        this.f21665digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21665digest.mo14970update(bArr, i, i2);
    }
}
