package org.bouncycastle.p314pqc.p352legacy.p354picnic;

/* loaded from: classes2.dex */
class Signature2 {
    int[] challengeC;
    byte[] challengeHash;
    int[] challengeP;

    /* renamed from: cvInfo */
    byte[] f23981cvInfo;
    int cvInfoLen;
    byte[] iSeedInfo;
    int iSeedInfoLen;

    /* renamed from: proofs */
    C6216Proof2[] f23982proofs;

    /* renamed from: salt */
    byte[] f23983salt = new byte[32];

    /* renamed from: org.bouncycastle.pqc.legacy.picnic.Signature2$Proof2 */
    public static class C6216Proof2 {

        /* renamed from: C */
        byte[] f23984C;

        /* renamed from: aux */
        byte[] f23985aux;

        /* renamed from: input */
        byte[] f23986input;

        /* renamed from: msgs */
        byte[] f23987msgs;
        byte[] seedInfo = null;
        int seedInfoLen = 0;

        public C6216Proof2(PicnicEngine picnicEngine) {
            this.f23984C = new byte[picnicEngine.digestSizeBytes];
            this.f23986input = new byte[picnicEngine.stateSizeBytes];
            int i = picnicEngine.andSizeBytes;
            this.f23985aux = new byte[i];
            this.f23987msgs = new byte[i];
        }
    }

    public Signature2(PicnicEngine picnicEngine) {
        this.challengeHash = new byte[picnicEngine.digestSizeBytes];
        int i = picnicEngine.numOpenedRounds;
        this.challengeC = new int[i];
        this.challengeP = new int[i];
        this.f23982proofs = new C6216Proof2[picnicEngine.numMPCRounds];
    }
}
