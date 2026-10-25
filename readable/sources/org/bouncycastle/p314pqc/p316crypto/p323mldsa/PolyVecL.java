package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

/* loaded from: classes2.dex */
class PolyVecL {

    /* renamed from: vec */
    private final C6074Poly[] f23329vec;

    public PolyVecL() throws Exception {
        throw new Exception("Requires Parameter");
    }

    public void addPolyVecL(PolyVecL polyVecL) {
        for (int i = 0; i < this.f23329vec.length; i++) {
            getVectorIndex(i).m17689addPoly(polyVecL.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.f23329vec.length; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: copyTo */
    public void m17699copyTo(PolyVecL polyVecL) {
        int i = 0;
        while (true) {
            C6074Poly[] c6074PolyArr = this.f23329vec;
            if (i >= c6074PolyArr.length) {
                return;
            }
            c6074PolyArr[i].m17690copyTo(polyVecL.f23329vec[i]);
            i++;
        }
    }

    public C6074Poly getVectorIndex(int i) {
        return this.f23329vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.f23329vec.length; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public void pointwisePolyMontgomery(C6074Poly c6074Poly, PolyVecL polyVecL) {
        for (int i = 0; i < this.f23329vec.length; i++) {
            getVectorIndex(i).pointwiseMontgomery(c6074Poly, polyVecL.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            C6074Poly[] c6074PolyArr = this.f23329vec;
            if (i >= c6074PolyArr.length) {
                return;
            }
            c6074PolyArr[i].m17692polyNtt();
            i++;
        }
    }

    /* renamed from: reduce */
    public void m17700reduce() {
        for (int i = 0; i < this.f23329vec.length; i++) {
            getVectorIndex(i).m17693reduce();
        }
    }

    public String toString() {
        String str = "\n[";
        for (int i = 0; i < this.f23329vec.length; i++) {
            str = str + "Inner Matrix " + i + " " + getVectorIndex(i).toString();
            if (i != this.f23329vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformBlocks(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            C6074Poly[] c6074PolyArr = this.f23329vec;
            if (i2 >= c6074PolyArr.length) {
                return;
            }
            c6074PolyArr[i2].uniformBlocks(bArr, (short) (i + i2));
            i2++;
        }
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (i < this.f23329vec.length) {
            getVectorIndex(i).uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    public void uniformGamma1(byte[] bArr, short s) {
        for (int i = 0; i < this.f23329vec.length; i++) {
            getVectorIndex(i).uniformGamma1(bArr, (short) ((this.f23329vec.length * s) + i));
        }
    }

    public PolyVecL(MLDSAEngine mLDSAEngine) {
        int dilithiumL = mLDSAEngine.getDilithiumL();
        this.f23329vec = new C6074Poly[dilithiumL];
        for (int i = 0; i < dilithiumL; i++) {
            this.f23329vec[i] = new C6074Poly(mLDSAEngine);
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
