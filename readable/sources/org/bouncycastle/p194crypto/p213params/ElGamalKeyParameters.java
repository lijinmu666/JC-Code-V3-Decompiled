package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class ElGamalKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private ElGamalParameters f20745params;

    public ElGamalKeyParameters(boolean z, ElGamalParameters elGamalParameters) {
        super(z);
        this.f20745params = elGamalParameters;
    }

    /* renamed from: equals */
    public boolean mo15741equals(Object obj) {
        if (!(obj instanceof ElGamalKeyParameters)) {
            return false;
        }
        ElGamalKeyParameters elGamalKeyParameters = (ElGamalKeyParameters) obj;
        ElGamalParameters elGamalParameters = this.f20745params;
        return elGamalParameters == null ? elGamalKeyParameters.getParameters() == null : elGamalParameters.m15742equals(elGamalKeyParameters.getParameters());
    }

    public ElGamalParameters getParameters() {
        return this.f20745params;
    }

    public int hashCode() {
        ElGamalParameters elGamalParameters = this.f20745params;
        if (elGamalParameters != null) {
            return elGamalParameters.hashCode();
        }
        return 0;
    }
}
