package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class DHKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private DHParameters f20695params;

    public DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.f20695params = dHParameters;
    }

    /* renamed from: equals */
    public boolean mo15689equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        DHParameters dHParameters = this.f20695params;
        return dHParameters == null ? dHKeyParameters.getParameters() == null : dHParameters.m15690equals(dHKeyParameters.getParameters());
    }

    public DHParameters getParameters() {
        return this.f20695params;
    }

    public int hashCode() {
        int i = !isPrivate() ? 1 : 0;
        DHParameters dHParameters = this.f20695params;
        return dHParameters != null ? i ^ dHParameters.hashCode() : i;
    }
}
