package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class ECJPAKECurves {
    public static final ECJPAKECurve NIST_P256 = getCurve("P-256");
    public static final ECJPAKECurve NIST_P384 = getCurve("P-384");
    public static final ECJPAKECurve NIST_P521 = getCurve("P-521");

    private static ECJPAKECurve getCurve(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        return new ECJPAKECurve((AbstractC5817ECCurve.AbstractFp) byName.getCurve(), byName.m14735getG());
    }
}
