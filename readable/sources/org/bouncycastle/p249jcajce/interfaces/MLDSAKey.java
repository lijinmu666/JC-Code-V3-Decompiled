package org.bouncycastle.p249jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;

/* loaded from: classes2.dex */
public interface MLDSAKey extends Key {
    MLDSAParameterSpec getParameterSpec();
}
