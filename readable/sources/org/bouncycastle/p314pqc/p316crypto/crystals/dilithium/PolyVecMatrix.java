package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

/* loaded from: classes2.dex */
class PolyVecMatrix {
    private final int dilithiumK;
    private final int dilithiumL;

    /* renamed from: mat */
    private final PolyVecL[] f23106mat;

    public PolyVecMatrix(DilithiumEngine dilithiumEngine) {
        int dilithiumK = dilithiumEngine.getDilithiumK();
        this.dilithiumK = dilithiumK;
        this.dilithiumL = dilithiumEngine.getDilithiumL();
        this.f23106mat = new PolyVecL[dilithiumK];
        for (int i = 0; i < this.dilithiumK; i++) {
            this.f23106mat[i] = new PolyVecL(dilithiumEngine);
        }
    }

    private String addString() {
        StringBuilder sb;
        String string = "[";
        for (int i = 0; i < this.dilithiumK; i++) {
            String str = (string + "Outer Matrix " + i + " [") + this.f23106mat[i].toString();
            if (i == this.dilithiumK - 1) {
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
        for (int i = 0; i < this.dilithiumK; i++) {
            for (int i2 = 0; i2 < this.dilithiumL; i2++) {
                this.f23106mat[i].getVectorIndex(i2).uniformBlocks(bArr, (short) ((i << 8) + i2));
            }
        }
    }

    public void pointwiseMontgomery(PolyVecK polyVecK, PolyVecL polyVecL) {
        for (int i = 0; i < this.dilithiumK; i++) {
            polyVecK.getVectorIndex(i).pointwiseAccountMontgomery(this.f23106mat[i], polyVecL);
        }
    }

    public String toString(String str) {
        return str.concat(": \n" + addString());
    }
}
