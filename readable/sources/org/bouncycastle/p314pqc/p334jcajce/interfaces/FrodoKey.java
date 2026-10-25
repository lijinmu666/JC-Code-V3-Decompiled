package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FrodoParameterSpec;

/* loaded from: classes2.dex */
public interface FrodoKey extends Key {
    FrodoParameterSpec getParameterSpec();
}
