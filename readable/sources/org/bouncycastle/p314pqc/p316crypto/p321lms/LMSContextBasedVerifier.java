package org.bouncycastle.p314pqc.p316crypto.p321lms;

/* loaded from: classes2.dex */
public interface LMSContextBasedVerifier {
    LMSContext generateLMSContext(byte[] bArr);

    /* renamed from: verify */
    boolean mo17619verify(LMSContext lMSContext);
}
