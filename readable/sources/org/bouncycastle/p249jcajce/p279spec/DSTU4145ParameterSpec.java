package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.ECParameterSpec;
import org.bouncycastle.p133asn1.p170ua.DSTU4145Params;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5617EC5Util;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSTU4145ParameterSpec extends ECParameterSpec {

    /* renamed from: dke */
    private final byte[] f21917dke;
    private final ECDomainParameters parameters;

    public DSTU4145ParameterSpec(ECDomainParameters eCDomainParameters) {
        this(eCDomainParameters, C5617EC5Util.convertToSpec(eCDomainParameters), DSTU4145Params.getDefaultDKE());
    }

    /* renamed from: equals */
    public boolean m16188equals(Object obj) {
        if (obj instanceof DSTU4145ParameterSpec) {
            return this.parameters.m15719equals(((DSTU4145ParameterSpec) obj).parameters);
        }
        return false;
    }

    /* renamed from: getDKE */
    public byte[] m16189getDKE() {
        return C6238Arrays.m18231clone(this.f21917dke);
    }

    public int hashCode() {
        return this.parameters.hashCode();
    }

    private DSTU4145ParameterSpec(ECDomainParameters eCDomainParameters, ECParameterSpec eCParameterSpec, byte[] bArr) {
        super(eCParameterSpec.getCurve(), eCParameterSpec.getGenerator(), eCParameterSpec.getOrder(), eCParameterSpec.getCofactor());
        this.parameters = eCDomainParameters;
        this.f21917dke = C6238Arrays.m18231clone(bArr);
    }
}
