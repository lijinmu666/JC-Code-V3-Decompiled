package org.bouncycastle.p281jce.interfaces;

import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeyParameterSetSpec;

/* loaded from: classes2.dex */
public interface GOST3410Params {
    String getDigestParamSetOID();

    String getEncryptionParamSetOID();

    String getPublicKeyParamSetOID();

    GOST3410PublicKeyParameterSetSpec getPublicKeyParameters();
}
