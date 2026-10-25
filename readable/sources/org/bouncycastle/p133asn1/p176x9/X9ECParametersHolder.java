package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public abstract class X9ECParametersHolder {

    /* renamed from: curve */
    private AbstractC5817ECCurve f18781curve;

    /* renamed from: params */
    private X9ECParameters f18782params;

    public AbstractC5817ECCurve createCurve() {
        return createParameters().getCurve();
    }

    public abstract X9ECParameters createParameters();

    public synchronized AbstractC5817ECCurve getCurve() {
        try {
            if (this.f18781curve == null) {
                this.f18781curve = createCurve();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18781curve;
    }

    public synchronized X9ECParameters getParameters() {
        try {
            if (this.f18782params == null) {
                this.f18782params = createParameters();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18782params;
    }
}
