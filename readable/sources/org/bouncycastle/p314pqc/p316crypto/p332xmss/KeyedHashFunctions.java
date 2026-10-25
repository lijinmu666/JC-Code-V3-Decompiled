package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;

/* loaded from: classes2.dex */
final class KeyedHashFunctions {

    /* renamed from: digest */
    private final InterfaceC5277Digest f23605digest;
    private final int digestSize;

    public KeyedHashFunctions(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        if (aSN1ObjectIdentifier == null) {
            throw new NullPointerException("digest == null");
        }
        this.f23605digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
        this.digestSize = i;
    }

    private byte[] coreDigest(int i, byte[] bArr, byte[] bArr2) {
        byte[] bytesBigEndian = XMSSUtil.toBytesBigEndian(i, this.digestSize);
        this.f23605digest.mo14970update(bytesBigEndian, 0, bytesBigEndian.length);
        this.f23605digest.mo14970update(bArr, 0, bArr.length);
        this.f23605digest.mo14970update(bArr2, 0, bArr2.length);
        int i2 = this.digestSize;
        byte[] bArr3 = new byte[i2];
        InterfaceC5277Digest interfaceC5277Digest = this.f23605digest;
        if (interfaceC5277Digest instanceof InterfaceC5284Xof) {
            ((InterfaceC5284Xof) interfaceC5277Digest).mo14998doFinal(bArr3, 0, i2);
        } else {
            interfaceC5277Digest.mo14967doFinal(bArr3, 0);
        }
        return bArr3;
    }

    /* renamed from: F */
    public byte[] m17895F(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.digestSize;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i) {
            return coreDigest(0, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    /* renamed from: H */
    public byte[] m17896H(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.digestSize;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i * 2) {
            return coreDigest(1, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    /* renamed from: HMsg */
    public byte[] m17897HMsg(byte[] bArr, byte[] bArr2) {
        if (bArr.length == this.digestSize * 3) {
            return coreDigest(2, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong key length");
    }

    /* renamed from: PRF */
    public byte[] m17898PRF(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.digestSize) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return coreDigest(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }
}
