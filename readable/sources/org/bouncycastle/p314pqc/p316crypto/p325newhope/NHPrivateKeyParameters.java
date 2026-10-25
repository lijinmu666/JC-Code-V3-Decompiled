package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NHPrivateKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: secData */
    final short[] f23364secData;

    public NHPrivateKeyParameters(short[] sArr) {
        super(true);
        this.f23364secData = C6238Arrays.m18238clone(sArr);
    }

    public short[] getSecData() {
        return C6238Arrays.m18238clone(this.f23364secData);
    }
}
