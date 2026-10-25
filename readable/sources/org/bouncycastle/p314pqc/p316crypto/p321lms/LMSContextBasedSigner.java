package org.bouncycastle.p314pqc.p316crypto.p321lms;

/* loaded from: classes2.dex */
public interface LMSContextBasedSigner {
    LMSContext generateLMSContext();

    byte[] generateSignature(LMSContext lMSContext);

    long getUsagesRemaining();
}
