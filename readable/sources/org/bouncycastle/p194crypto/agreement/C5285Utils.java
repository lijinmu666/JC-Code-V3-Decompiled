package org.bouncycastle.p194crypto.agreement;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.DHKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;

/* renamed from: org.bouncycastle.crypto.agreement.Utils */
/* loaded from: classes2.dex */
class C5285Utils {
    public static CryptoServiceProperties getDefaultProperties(String str, DHKeyParameters dHKeyParameters) {
        return new DefaultServiceProperties(str, ConstraintUtils.bitsOfSecurityFor(dHKeyParameters.getParameters().m15695getP()), dHKeyParameters, CryptoServicePurpose.AGREEMENT);
    }

    public static CryptoServiceProperties getDefaultProperties(String str, ECKeyParameters eCKeyParameters) {
        return new DefaultServiceProperties(str, ConstraintUtils.bitsOfSecurityFor(eCKeyParameters.getParameters().getCurve()), eCKeyParameters, CryptoServicePurpose.AGREEMENT);
    }

    public static CryptoServiceProperties getDefaultProperties(String str, X25519PrivateKeyParameters x25519PrivateKeyParameters) {
        return new DefaultServiceProperties(str, 128, x25519PrivateKeyParameters, CryptoServicePurpose.AGREEMENT);
    }

    public static CryptoServiceProperties getDefaultProperties(String str, X448PrivateKeyParameters x448PrivateKeyParameters) {
        return new DefaultServiceProperties(str, InterfaceC5102BERTags.f17976FLAGS, x448PrivateKeyParameters, CryptoServicePurpose.AGREEMENT);
    }
}
