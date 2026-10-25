package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;

/* loaded from: classes2.dex */
class PolynomialPair {

    /* renamed from: a */
    private final Polynomial f23386a;

    /* renamed from: b */
    private final Polynomial f23387b;

    public PolynomialPair(Polynomial polynomial, Polynomial polynomial2) {
        this.f23386a = polynomial;
        this.f23387b = polynomial2;
    }

    /* renamed from: f */
    public Polynomial m17764f() {
        return this.f23386a;
    }

    /* renamed from: g */
    public Polynomial m17765g() {
        return this.f23387b;
    }

    /* renamed from: m */
    public Polynomial m17766m() {
        return this.f23387b;
    }

    /* renamed from: r */
    public Polynomial m17767r() {
        return this.f23386a;
    }
}
