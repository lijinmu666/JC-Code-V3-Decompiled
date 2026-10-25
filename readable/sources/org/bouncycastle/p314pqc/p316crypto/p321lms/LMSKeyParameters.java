package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public abstract class LMSKeyParameters extends AsymmetricKeyParameter implements Encodable {
    public LMSKeyParameters(boolean z) {
        super(z);
    }

    public abstract byte[] getEncoded();
}
