package org.bouncycastle.p249jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.p249jcajce.p279spec.SLHDSAParameterSpec;

/* loaded from: classes2.dex */
public interface SLHDSAKey extends Key {
    SLHDSAParameterSpec getParameterSpec();
}
