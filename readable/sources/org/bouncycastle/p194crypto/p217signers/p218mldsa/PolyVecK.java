package org.bouncycastle.p194crypto.p217signers.p218mldsa;

/* loaded from: classes2.dex */
class PolyVecK {

    /* renamed from: vec */
    private final C5390Poly[] f21059vec;

    public PolyVecK(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.f21059vec = new C5390Poly[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.f21059vec[i] = new C5390Poly(mLDSAEngine);
        }
    }

    public void addPolyVecK(PolyVecK polyVecK) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).m15868addPoly(polyVecK.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.f21059vec.length; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    public void conditionalAddQ() {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).conditionalAddQ();
        }
    }

    public void decompose(PolyVecK polyVecK) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).decompose(polyVecK.getVectorIndex(i));
        }
    }

    public C5390Poly getVectorIndex(int i) {
        return this.f21059vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public int makeHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        int iPolyMakeHint = 0;
        for (int i = 0; i < this.f21059vec.length; i++) {
            iPolyMakeHint += getVectorIndex(i).polyMakeHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
        return iPolyMakeHint;
    }

    /* renamed from: packW1 */
    public void m15875packW1(MLDSAEngine mLDSAEngine, byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.f21059vec.length; i2++) {
            getVectorIndex(i2).m15870packW1(bArr, (mLDSAEngine.getDilithiumPolyW1PackedBytes() * i2) + i);
        }
    }

    public void pointwisePolyMontgomery(C5390Poly c5390Poly, PolyVecK polyVecK) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).pointwiseMontgomery(c5390Poly, polyVecK.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            C5390Poly[] c5390PolyArr = this.f21059vec;
            if (i >= c5390PolyArr.length) {
                return;
            }
            c5390PolyArr[i].m15871polyNtt();
            i++;
        }
    }

    public void power2Round(PolyVecK polyVecK) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).power2Round(polyVecK.getVectorIndex(i));
        }
    }

    /* renamed from: reduce */
    public void m15876reduce() {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).m15872reduce();
        }
    }

    public void setVectorIndex(int i, C5390Poly c5390Poly) {
        this.f21059vec[i] = c5390Poly;
    }

    public void shiftLeft() {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).shiftLeft();
        }
    }

    public void subtract(PolyVecK polyVecK) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).subtract(polyVecK.getVectorIndex(i));
        }
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.f21059vec.length; i++) {
            str = str + i + " " + getVectorIndex(i).toString();
            if (i != this.f21059vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (true) {
            C5390Poly[] c5390PolyArr = this.f21059vec;
            if (i >= c5390PolyArr.length) {
                return;
            }
            c5390PolyArr[i].uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    /* renamed from: useHint */
    public void m15877useHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        for (int i = 0; i < this.f21059vec.length; i++) {
            getVectorIndex(i).polyUseHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
