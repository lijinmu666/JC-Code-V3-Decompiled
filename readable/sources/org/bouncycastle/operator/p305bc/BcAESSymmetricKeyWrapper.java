package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p194crypto.p201engines.AESWrapEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public class BcAESSymmetricKeyWrapper extends BcSymmetricKeyWrapper {
    public BcAESSymmetricKeyWrapper(KeyParameter keyParameter) {
        super(C5992AESUtil.determineKeyEncAlg(keyParameter), new AESWrapEngine(), keyParameter);
    }
}
