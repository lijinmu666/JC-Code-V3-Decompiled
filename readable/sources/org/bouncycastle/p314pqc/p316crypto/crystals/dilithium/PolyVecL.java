package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

/* loaded from: classes2.dex */
class PolyVecL {
    private int dilithiumK;
    private int dilithiumL;

    /* renamed from: engine */
    private DilithiumEngine f23103engine;

    /* renamed from: mode */
    private int f23104mode;
    private int polyVecBytes;

    /* renamed from: vec */
    C6060Poly[] f23105vec;

    public PolyVecL() throws Exception {
        throw new Exception("Requires Parameter");
    }

    public void addPolyVecL(PolyVecL polyVecL) {
        for (int i = 0; i < this.dilithiumL; i++) {
            getVectorIndex(i).m17527addPoly(polyVecL.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.dilithiumL; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    public void copyPolyVecL(PolyVecL polyVecL) {
        for (int i = 0; i < this.dilithiumL; i++) {
            for (int i2 = 0; i2 < 256; i2++) {
                polyVecL.getVectorIndex(i).setCoeffIndex(i2, getVectorIndex(i).getCoeffIndex(i2));
            }
        }
    }

    public void expandMatrix(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.dilithiumL; i2++) {
            this.f23105vec[i2].uniformBlocks(bArr, (short) ((i << 8) + i2));
        }
    }

    public C6060Poly getVectorIndex(int i) {
        return this.f23105vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.dilithiumL; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public void pointwisePolyMontgomery(C6060Poly c6060Poly, PolyVecL polyVecL) {
        for (int i = 0; i < this.dilithiumL; i++) {
            getVectorIndex(i).pointwiseMontgomery(c6060Poly, polyVecL.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        for (int i = 0; i < this.dilithiumL; i++) {
            this.f23105vec[i].m17528polyNtt();
        }
    }

    /* renamed from: reduce */
    public void m17536reduce() {
        for (int i = 0; i < this.dilithiumL; i++) {
            getVectorIndex(i).m17529reduce();
        }
    }

    public String toString() {
        String str = "\n[";
        for (int i = 0; i < this.dilithiumL; i++) {
            str = str + "Inner Matrix " + i + " " + getVectorIndex(i).toString();
            if (i != this.dilithiumL - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (i < this.dilithiumL) {
            getVectorIndex(i).uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    public void uniformGamma1(byte[] bArr, short s) {
        for (int i = 0; i < this.dilithiumL; i++) {
            getVectorIndex(i).uniformGamma1(bArr, (short) ((this.dilithiumL * s) + i));
        }
    }

    public PolyVecL(DilithiumEngine dilithiumEngine) {
        this.f23103engine = dilithiumEngine;
        this.f23104mode = dilithiumEngine.getDilithiumMode();
        this.dilithiumL = dilithiumEngine.getDilithiumL();
        this.dilithiumK = dilithiumEngine.getDilithiumK();
        this.f23105vec = new C6060Poly[this.dilithiumL];
        for (int i = 0; i < this.dilithiumL; i++) {
            this.f23105vec[i] = new C6060Poly(dilithiumEngine);
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
