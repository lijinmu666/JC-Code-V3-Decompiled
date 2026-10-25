package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class IESKEMParameterSpec implements AlgorithmParameterSpec {
    private final byte[] recipientInfo;
    private final boolean usePointCompression;

    public IESKEMParameterSpec(byte[] bArr) {
        this(bArr, false);
    }

    public byte[] getRecipientInfo() {
        return C6238Arrays.m18231clone(this.recipientInfo);
    }

    public boolean hasUsePointCompression() {
        return this.usePointCompression;
    }

    public IESKEMParameterSpec(byte[] bArr, boolean z) {
        this.recipientInfo = C6238Arrays.m18231clone(bArr);
        this.usePointCompression = z;
    }
}
