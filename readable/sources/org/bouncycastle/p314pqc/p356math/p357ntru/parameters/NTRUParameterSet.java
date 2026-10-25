package org.bouncycastle.p314pqc.p356math.p357ntru.parameters;

import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;

/* loaded from: classes2.dex */
public abstract class NTRUParameterSet {

    /* renamed from: logQ */
    private final int f24146logQ;

    /* renamed from: n */
    private final int f24147n;
    private final int prfKeyBytes;
    private final int seedBytes;
    private final int sharedKeyBytes;

    public NTRUParameterSet(int i, int i2, int i3, int i4, int i5) {
        this.f24147n = i;
        this.f24146logQ = i2;
        this.seedBytes = i3;
        this.prfKeyBytes = i4;
        this.sharedKeyBytes = i5;
    }

    public abstract Polynomial createPolynomial();

    /* renamed from: logQ */
    public int m18200logQ() {
        return this.f24146logQ;
    }

    /* renamed from: n */
    public int m18201n() {
        return this.f24147n;
    }

    public int ntruCiphertextBytes() {
        return owcpaBytes();
    }

    public int ntruPublicKeyBytes() {
        return owcpaPublicKeyBytes();
    }

    public int ntruSecretKeyBytes() {
        return owcpaSecretKeyBytes() + this.prfKeyBytes;
    }

    public int owcpaBytes() {
        return ((this.f24146logQ * packDegree()) + 7) / 8;
    }

    public int owcpaMsgBytes() {
        return packTrinaryBytes() * 2;
    }

    public int owcpaPublicKeyBytes() {
        return ((this.f24146logQ * packDegree()) + 7) / 8;
    }

    public int owcpaSecretKeyBytes() {
        return (packTrinaryBytes() * 2) + owcpaPublicKeyBytes();
    }

    public int packDegree() {
        return this.f24147n - 1;
    }

    public int packTrinaryBytes() {
        return (packDegree() + 4) / 5;
    }

    public int prfKeyBytes() {
        return this.prfKeyBytes;
    }

    /* renamed from: q */
    public int m18202q() {
        return 1 << this.f24146logQ;
    }

    public abstract int sampleFgBytes();

    public int sampleFixedTypeBytes() {
        return (((this.f24147n - 1) * 30) + 7) / 8;
    }

    public int sampleIidBytes() {
        return this.f24147n - 1;
    }

    public abstract int sampleRmBytes();

    public int seedBytes() {
        return this.seedBytes;
    }

    public int sharedKeyBytes() {
        return this.sharedKeyBytes;
    }
}
