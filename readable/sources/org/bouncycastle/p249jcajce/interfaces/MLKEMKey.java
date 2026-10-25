package org.bouncycastle.p249jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;

/* loaded from: classes2.dex */
public interface MLKEMKey extends Key {
    MLKEMParameterSpec getParameterSpec();
}
