package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMOtsParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSigParameters;

/* loaded from: classes2.dex */
public class LMSParameterSpec implements AlgorithmParameterSpec {
    private final LMOtsParameters lmOtsParameters;
    private final LMSigParameters lmSigParams;

    public LMSParameterSpec(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters) {
        this.lmSigParams = lMSigParameters;
        this.lmOtsParameters = lMOtsParameters;
    }

    public LMOtsParameters getOtsParams() {
        return this.lmOtsParameters;
    }

    public LMSigParameters getSigParams() {
        return this.lmSigParams;
    }
}
