package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SPHINCSPlusParameterSpec;

@Deprecated
/* loaded from: classes2.dex */
public interface SPHINCSPlusKey extends Key {
    SPHINCSPlusParameterSpec getParameterSpec();
}
