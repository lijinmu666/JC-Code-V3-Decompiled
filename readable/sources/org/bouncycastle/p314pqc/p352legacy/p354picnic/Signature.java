package org.bouncycastle.p314pqc.p352legacy.p354picnic;

/* loaded from: classes2.dex */
class Signature {
    final byte[] challengeBits;

    /* renamed from: proofs */
    final C6215Proof[] f23977proofs;

    /* renamed from: salt */
    final byte[] f23978salt = new byte[32];

    /* renamed from: org.bouncycastle.pqc.legacy.picnic.Signature$Proof */
    public static class C6215Proof {
        final byte[] communicatedBits;
        final int[] inputShare;

        /* renamed from: seed1 */
        final byte[] f23979seed1;

        /* renamed from: seed2 */
        final byte[] f23980seed2;
        final byte[] view3Commitment;
        final byte[] view3UnruhG;

        public C6215Proof(PicnicEngine picnicEngine) {
            int i = picnicEngine.seedSizeBytes;
            this.f23979seed1 = new byte[i];
            this.f23980seed2 = new byte[i];
            this.inputShare = new int[picnicEngine.stateSizeWords];
            this.communicatedBits = new byte[picnicEngine.andSizeBytes];
            this.view3Commitment = new byte[picnicEngine.digestSizeBytes];
            int i2 = picnicEngine.UnruhGWithInputBytes;
            if (i2 > 0) {
                this.view3UnruhG = new byte[i2];
            } else {
                this.view3UnruhG = null;
            }
        }
    }

    public Signature(PicnicEngine picnicEngine) {
        this.challengeBits = new byte[C6219Utils.numBytes(picnicEngine.numMPCRounds * 2)];
        this.f23977proofs = new C6215Proof[picnicEngine.numMPCRounds];
        int i = 0;
        while (true) {
            C6215Proof[] c6215ProofArr = this.f23977proofs;
            if (i >= c6215ProofArr.length) {
                return;
            }
            c6215ProofArr[i] = new C6215Proof(picnicEngine);
            i++;
        }
    }
}
