package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

/* loaded from: classes2.dex */
class PolyVecMatrix {

    /* renamed from: matrix */
    private final PolyVecL[] f23330matrix;

    public PolyVecMatrix(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.f23330matrix = new PolyVecL[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.f23330matrix[i] = new PolyVecL(mLDSAEngine);
        }
    }

    private String addString() {
        StringBuilder sb;
        String string = "[";
        for (int i = 0; i < this.f23330matrix.length; i++) {
            String str = (string + "Outer Matrix " + i + " [") + this.f23330matrix[i].toString();
            if (i == this.f23330matrix.length - 1) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("]\n");
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("],\n");
            }
            string = sb.toString();
        }
        return string + "]\n";
    }

    public void expandMatrix(byte[] bArr) {
        int i = 0;
        while (true) {
            PolyVecL[] polyVecLArr = this.f23330matrix;
            if (i >= polyVecLArr.length) {
                return;
            }
            polyVecLArr[i].uniformBlocks(bArr, i << 8);
            i++;
        }
    }

    public void pointwiseMontgomery(PolyVecK polyVecK, PolyVecL polyVecL) {
        for (int i = 0; i < this.f23330matrix.length; i++) {
            polyVecK.getVectorIndex(i).pointwiseAccountMontgomery(this.f23330matrix[i], polyVecL);
        }
    }

    public String toString(String str) {
        return str.concat(": \n" + addString());
    }
}
