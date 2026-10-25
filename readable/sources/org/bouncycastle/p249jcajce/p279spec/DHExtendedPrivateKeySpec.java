package org.bouncycastle.p249jcajce.p279spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* loaded from: classes2.dex */
public class DHExtendedPrivateKeySpec extends DHPrivateKeySpec {

    /* renamed from: params */
    private final DHParameterSpec f21915params;

    public DHExtendedPrivateKeySpec(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        super(bigInteger, dHParameterSpec.getP(), dHParameterSpec.getG());
        this.f21915params = dHParameterSpec;
    }

    public DHParameterSpec getParams() {
        return this.f21915params;
    }
}
