package org.bouncycastle.p194crypto.agreement.p198srp;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.SRP6GroupParameters;

/* loaded from: classes2.dex */
public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f19255N;

    /* renamed from: digest */
    protected InterfaceC5277Digest f19256digest;

    /* renamed from: g */
    protected BigInteger f19257g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f19257g.modPow(SRP6Util.calculateX(this.f19256digest, this.f19255N, bArr, bArr2, bArr3), this.f19255N);
    }

    /* renamed from: init */
    public void m15036init(BigInteger bigInteger, BigInteger bigInteger2, InterfaceC5277Digest interfaceC5277Digest) {
        this.f19255N = bigInteger;
        this.f19257g = bigInteger2;
        this.f19256digest = interfaceC5277Digest;
    }

    /* renamed from: init */
    public void m15037init(SRP6GroupParameters sRP6GroupParameters, InterfaceC5277Digest interfaceC5277Digest) {
        this.f19255N = sRP6GroupParameters.m15826getN();
        this.f19257g = sRP6GroupParameters.m15825getG();
        this.f19256digest = interfaceC5277Digest;
    }
}
