package org.bouncycastle.p246its.operator;

import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.p246its.ITSCertificate;

/* loaded from: classes2.dex */
public interface ITSContentVerifierProvider {
    /* renamed from: get */
    ContentVerifier mo16014get(int i);

    ITSCertificate getAssociatedCertificate();

    boolean hasAssociatedCertificate();
}
