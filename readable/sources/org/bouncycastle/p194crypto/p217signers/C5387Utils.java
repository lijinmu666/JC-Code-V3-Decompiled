package org.bouncycastle.p194crypto.p217signers;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.DSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410KeyParameters;

/* renamed from: org.bouncycastle.crypto.signers.Utils */
/* loaded from: classes2.dex */
class C5387Utils {
    public static CryptoServiceProperties getDefaultProperties(String str, int i, CipherParameters cipherParameters, boolean z) {
        return new DefaultServiceProperties(str, i, cipherParameters, getPurpose(z));
    }

    public static CryptoServicePurpose getPurpose(boolean z) {
        return z ? CryptoServicePurpose.SIGNING : CryptoServicePurpose.VERIFYING;
    }

    public static CryptoServiceProperties getDefaultProperties(String str, DSAKeyParameters dSAKeyParameters, boolean z) {
        return new DefaultServiceProperties(str, ConstraintUtils.bitsOfSecurityFor(dSAKeyParameters.getParameters().m15705getP()), dSAKeyParameters, getPurpose(z));
    }

    public static CryptoServiceProperties getDefaultProperties(String str, ECKeyParameters eCKeyParameters, boolean z) {
        return new DefaultServiceProperties(str, ConstraintUtils.bitsOfSecurityFor(eCKeyParameters.getParameters().getCurve()), eCKeyParameters, getPurpose(z));
    }

    public static CryptoServiceProperties getDefaultProperties(String str, GOST3410KeyParameters gOST3410KeyParameters, boolean z) {
        return new DefaultServiceProperties(str, ConstraintUtils.bitsOfSecurityFor(gOST3410KeyParameters.getParameters().m15751getP()), gOST3410KeyParameters, getPurpose(z));
    }
}
