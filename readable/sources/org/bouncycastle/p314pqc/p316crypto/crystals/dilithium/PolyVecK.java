package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

/* loaded from: classes2.dex */
class PolyVecK {
    private int dilithiumK;
    private int dilithiumL;

    /* renamed from: engine */
    private DilithiumEngine f23100engine;

    /* renamed from: mode */
    private int f23101mode;
    private int polyVecBytes;

    /* renamed from: vec */
    C6060Poly[] f23102vec;

    public PolyVecK() throws Exception {
        throw new Exception("Requires Parameter");
    }

    public void addPolyVecK(PolyVecK polyVecK) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).m17527addPoly(polyVecK.getVectorIndex(i));
        }
    }

    public boolean checkNorm(int i) {
        for (int i2 = 0; i2 < this.dilithiumK; i2++) {
            if (getVectorIndex(i2).checkNorm(i)) {
                return true;
            }
        }
        return false;
    }

    public void conditionalAddQ() {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).conditionalAddQ();
        }
    }

    public void decompose(PolyVecK polyVecK) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).decompose(polyVecK.getVectorIndex(i));
        }
    }

    public C6060Poly getVectorIndex(int i) {
        return this.f23102vec[i];
    }

    public void invNttToMont() {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).invNttToMont();
        }
    }

    public int makeHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        int iPolyMakeHint = 0;
        for (int i = 0; i < this.dilithiumK; i++) {
            iPolyMakeHint += getVectorIndex(i).polyMakeHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
        return iPolyMakeHint;
    }

    /* renamed from: packW1 */
    public byte[] m17533packW1() {
        byte[] bArr = new byte[this.dilithiumK * this.f23100engine.getDilithiumPolyW1PackedBytes()];
        for (int i = 0; i < this.dilithiumK; i++) {
            System.arraycopy(getVectorIndex(i).m17530w1Pack(), 0, bArr, this.f23100engine.getDilithiumPolyW1PackedBytes() * i, this.f23100engine.getDilithiumPolyW1PackedBytes());
        }
        return bArr;
    }

    public void pointwisePolyMontgomery(C6060Poly c6060Poly, PolyVecK polyVecK) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).pointwiseMontgomery(c6060Poly, polyVecK.getVectorIndex(i));
        }
    }

    public void polyVecNtt() {
        for (int i = 0; i < this.dilithiumK; i++) {
            this.f23102vec[i].m17528polyNtt();
        }
    }

    public void power2Round(PolyVecK polyVecK) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).power2Round(polyVecK.getVectorIndex(i));
        }
    }

    /* renamed from: reduce */
    public void m17534reduce() {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).m17529reduce();
        }
    }

    public void setVectorIndex(int i, C6060Poly c6060Poly) {
        this.f23102vec[i] = c6060Poly;
    }

    public void shiftLeft() {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).shiftLeft();
        }
    }

    public void subtract(PolyVecK polyVecK) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).subtract(polyVecK.getVectorIndex(i));
        }
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.dilithiumK; i++) {
            str = str + i + " " + getVectorIndex(i).toString();
            if (i != this.dilithiumK - 1) {
                str = str + ",\n";
            }
        }
        return str + "]";
    }

    public void uniformEta(byte[] bArr, short s) {
        int i = 0;
        while (i < this.dilithiumK) {
            getVectorIndex(i).uniformEta(bArr, s);
            i++;
            s = (short) (s + 1);
        }
    }

    /* renamed from: useHint */
    public void m17535useHint(PolyVecK polyVecK, PolyVecK polyVecK2) {
        for (int i = 0; i < this.dilithiumK; i++) {
            getVectorIndex(i).polyUseHint(polyVecK.getVectorIndex(i), polyVecK2.getVectorIndex(i));
        }
    }

    public PolyVecK(DilithiumEngine dilithiumEngine) {
        this.f23100engine = dilithiumEngine;
        this.f23101mode = dilithiumEngine.getDilithiumMode();
        this.dilithiumK = dilithiumEngine.getDilithiumK();
        this.dilithiumL = dilithiumEngine.getDilithiumL();
        this.f23102vec = new C6060Poly[this.dilithiumK];
        for (int i = 0; i < this.dilithiumK; i++) {
            this.f23102vec[i] = new C6060Poly(dilithiumEngine);
        }
    }

    public String toString(String str) {
        return str + ": " + toString();
    }
}
