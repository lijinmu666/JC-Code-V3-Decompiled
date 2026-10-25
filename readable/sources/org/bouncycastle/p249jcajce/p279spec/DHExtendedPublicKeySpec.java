package org.bouncycastle.p249jcajce.p279spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* loaded from: classes2.dex */
public class DHExtendedPublicKeySpec extends DHPublicKeySpec {

    /* renamed from: params */
    private final DHParameterSpec f21916params;

    public DHExtendedPublicKeySpec(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        super(bigInteger, dHParameterSpec.getP(), dHParameterSpec.getG());
        this.f21916params = dHParameterSpec;
    }

    public DHParameterSpec getParams() {
        return this.f21916params;
    }
}
