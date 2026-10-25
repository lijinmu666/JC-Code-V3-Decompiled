package org.bouncycastle.p194crypto.p217signers.p218mldsa;

/* loaded from: classes2.dex */
class PolyVecL {

    /* renamed from: vec */
    private final C5390Poly[] f21060vec;

    public PolyVecL() throws Exception {
        throw new Exception("Requires Parameter");
    }

    public void addPolyVecL(PolyVecL polyVecL) {
        for (int i = 0; i < this.f21060vec.length; i++) {
            getVectorIndex(i).m15868addPoly(polyVecL.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.f21060vec.length; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: copyTo */
    public void m15878copyTo(PolyVecL polyVecL) {
        int i = 0;
        while (true) {
            C5390Poly[] c5390PolyArr = this.f21060vec;
            if (i >= c5390PolyArr.length) {
                return;
            }
            c5390PolyArr[i].m15869copyTo(polyVecL.f21060vec[i]);
            i++;
        }
    }

    public C5390Poly getVectorIndex(int i) {
        return this.f21060vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.f21060vec.length; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public void pointwisePolyMontgomery(C5390Poly c5390Poly, PolyVecL polyVecL) {
        for (int i = 0; i < this.f21060vec.length; i++) {
            getVectorIndex(i).pointwiseMontgomery(c5390Poly, polyVecL.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        int i = 0;
        while (true) {
            C5390Poly[] c5390PolyArr = this.f21060vec;
            if (i >= c5390PolyArr.length) {
                return;
            }
            c5390PolyArr[i].m15871polyNtt();
            i++;
        }
    }

    /* renamed from: reduce */
    public void m15879reduce() {
        for (int i = 0; i < this.f21060vec.length; i++) {
            getVectorIndex(i).m15872reduce();
        }
    }

    public String toString() {
        String str = "\n[";
        for (int i = 0; i < this.f21060vec.length; i++) {
            str = str + "Inner Matrix " + i + " " + getVectorIndex(i).toString();
            if (i != this.f21060vec.length - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformBlocks(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            C5390Poly[] c5390PolyArr = this.f21060vec;
            if (i2 >= c5390PolyArr.length) {
                return;
            }
            c5390PolyArr[i2].uniformBlocks(bArr, (short) (i + i2));
            i2++;
        }
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (i < this.f21060vec.length) {
            getVectorIndex(i).uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    public void uniformGamma1(byte[] bArr, short s) {
        for (int i = 0; i < this.f21060vec.length; i++) {
            getVectorIndex(i).uniformGamma1(bArr, (short) ((this.f21060vec.length * s) + i));
        }
    }

    public PolyVecL(MLDSAEngine mLDSAEngine) {
        int dilithiumL = mLDSAEngine.getDilithiumL();
        this.f21060vec = new C5390Poly[dilithiumL];
        for (int i = 0; i < dilithiumL; i++) {
            this.f21060vec[i] = new C5390Poly(mLDSAEngine);
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
