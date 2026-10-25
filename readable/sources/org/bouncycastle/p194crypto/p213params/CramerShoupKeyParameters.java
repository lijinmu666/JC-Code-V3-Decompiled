package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class CramerShoupKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private CramerShoupParameters f20680params;

    public CramerShoupKeyParameters(boolean z, CramerShoupParameters cramerShoupParameters) {
        super(z);
        this.f20680params = cramerShoupParameters;
    }

    /* renamed from: equals */
    public boolean mo15673equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupKeyParameters cramerShoupKeyParameters = (CramerShoupKeyParameters) obj;
        CramerShoupParameters cramerShoupParameters = this.f20680params;
        return cramerShoupParameters == null ? cramerShoupKeyParameters.getParameters() == null : cramerShoupParameters.m15674equals(cramerShoupKeyParameters.getParameters());
    }

    public CramerShoupParameters getParameters() {
        return this.f20680params;
    }

    public int hashCode() {
        int i = !isPrivate() ? 1 : 0;
        CramerShoupParameters cramerShoupParameters = this.f20680params;
        return cramerShoupParameters != null ? i ^ cramerShoupParameters.hashCode() : i;
    }
}
