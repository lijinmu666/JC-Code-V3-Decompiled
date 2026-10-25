package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

/* loaded from: classes2.dex */
class PolyVecK {

    /* renamed from: vec */
    private final C6074Poly[] f23328vec;

    public PolyVecK(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.f23328vec = new C6074Poly[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.f23328vec[i] = new C6074Poly(mLDSAEngine);
        }
    }

    public void addPolyVecK(PolyVecK polyVecK) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).m17689addPoly(polyVecK.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.f23328vec.length; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    public void conditionalAddQ() {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).conditionalAddQ();
        }
    }

    public void decompose(PolyVecK polyVecK) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).decompose(polyVecK.getVectorIndex(i));
        }
    }

    public C6074Poly getVectorIndex(int i) {
        return this.f23328vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public int makeHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        int iPolyMakeHint = 0;
        for (int i = 0; i < this.f23328vec.length; i++) {
            iPolyMakeHint += getVectorIndex(i).polyMakeHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
        return iPolyMakeHint;
    }

    /* renamed from: packW1 */
    public void m17696packW1(MLDSAEngine mLDSAEngine, byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.f23328vec.length; i2++) {
            getVectorIndex(i2).m17691packW1(bArr, (mLDSAEngine.getDilithiumPolyW1PackedBytes() * i2) + i);
        }
    }

    public void pointwisePolyMontgomery(C6074Poly c6074Poly, PolyVecK polyVecK) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).pointwiseMontgomery(c6074Poly, polyVecK.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            C6074Poly[] c6074PolyArr = this.f23328vec;
            if (i >= c6074PolyArr.length) {
                return;
            }
            c6074PolyArr[i].m17692polyNtt();
            i++;
        }
    }

    public void power2Round(PolyVecK polyVecK) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).power2Round(polyVecK.getVectorIndex(i));
        }
    }

    /* renamed from: reduce */
    public void m17697reduce() {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).m17693reduce();
        }
    }

    public void setVectorIndex(int i, C6074Poly c6074Poly) {
        this.f23328vec[i] = c6074Poly;
    }

    public void shiftLeft() {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).shiftLeft();
        }
    }

    public void subtract(PolyVecK polyVecK) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).subtract(polyVecK.getVectorIndex(i));
        }
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.f23328vec.length; i++) {
            str = str + i + " " + getVectorIndex(i).toString();
            if (i != this.f23328vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (true) {
            C6074Poly[] c6074PolyArr = this.f23328vec;
            if (i >= c6074PolyArr.length) {
                return;
            }
            c6074PolyArr[i].uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    /* renamed from: useHint */
    public void m17698useHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        for (int i = 0; i < this.f23328vec.length; i++) {
            getVectorIndex(i).polyUseHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
