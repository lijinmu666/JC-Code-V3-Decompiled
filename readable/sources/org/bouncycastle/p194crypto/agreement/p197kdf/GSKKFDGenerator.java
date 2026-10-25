package org.bouncycastle.p194crypto.agreement.p197kdf;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.DigestDerivationFunction;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GSKKFDGenerator implements DigestDerivationFunction {

    /* renamed from: buf */
    private byte[] f19222buf;

    /* renamed from: counter */
    private int f19223counter;

    /* renamed from: digest */
    private final InterfaceC5277Digest f19224digest;

    /* renamed from: r */
    private byte[] f19225r;

    /* renamed from: z */
    private byte[] f19226z;

    public GSKKFDGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19224digest = interfaceC5277Digest;
        this.f19222buf = new byte[interfaceC5277Digest.getDigestSize()];
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("output buffer too small");
        }
        InterfaceC5277Digest interfaceC5277Digest = this.f19224digest;
        byte[] bArr2 = this.f19226z;
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
        int i3 = this.f19223counter;
        this.f19223counter = i3 + 1;
        byte[] bArrIntToBigEndian = AbstractC6245Pack.intToBigEndian(i3);
        this.f19224digest.mo14970update(bArrIntToBigEndian, 0, bArrIntToBigEndian.length);
        byte[] bArr3 = this.f19225r;
        if (bArr3 != null) {
            this.f19224digest.mo14970update(bArr3, 0, bArr3.length);
        }
        this.f19224digest.mo14967doFinal(this.f19222buf, 0);
        System.arraycopy(this.f19222buf, 0, bArr, i, i2);
        C6238Arrays.m18227clear(this.f19222buf);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.DigestDerivationFunction
    public InterfaceC5277Digest getDigest() {
        return this.f19224digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof GSKKDFParameters)) {
            throw new IllegalArgumentException("unkown parameters type");
        }
        GSKKDFParameters gSKKDFParameters = (GSKKDFParameters) derivationParameters;
        this.f19226z = gSKKDFParameters.m15029getZ();
        this.f19223counter = gSKKDFParameters.getStartCounter();
        this.f19225r = gSKKDFParameters.getNonce();
    }
}
