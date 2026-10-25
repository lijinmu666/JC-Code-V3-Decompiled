package org.bouncycastle.p194crypto.hash2curve;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.hash2curve.p204impl.XmdMessageExpansion;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class OPRFHashToScalar {

    /* renamed from: L */
    private final int f20299L;

    /* renamed from: curve */
    private final AbstractC5817ECCurve f20300curve;
    private final MessageExpansion messageExpansion;

    public OPRFHashToScalar(AbstractC5817ECCurve abstractC5817ECCurve, InterfaceC5277Digest interfaceC5277Digest, int i, int i2) {
        this.f20300curve = abstractC5817ECCurve;
        this.f20299L = (int) Math.ceil((abstractC5817ECCurve.getOrder().subtract(BigInteger.ONE).bitLength() + i) / 8.0d);
        this.messageExpansion = new XmdMessageExpansion(interfaceC5277Digest, i, i2);
    }

    /* renamed from: process */
    public BigInteger m15525process(byte[] bArr, byte[] bArr2) {
        return new BigInteger(1, this.messageExpansion.expandMessage(bArr, bArr2, this.f20299L)).mod(this.f20300curve.getOrder());
    }

    public OPRFHashToScalar(AbstractC5817ECCurve abstractC5817ECCurve, ExtendedDigest extendedDigest, int i) {
        this.f20300curve = abstractC5817ECCurve;
        this.f20299L = (int) Math.ceil((abstractC5817ECCurve.getOrder().subtract(BigInteger.ONE).bitLength() + i) / 8.0d);
        this.messageExpansion = new XmdMessageExpansion(extendedDigest, i);
    }
}
