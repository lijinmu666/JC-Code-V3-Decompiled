package org.bouncycastle.p281jce.interfaces;

import javax.crypto.interfaces.DHKey;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;

/* loaded from: classes2.dex */
public interface ElGamalKey extends DHKey {
    ElGamalParameterSpec getParameters();
}
