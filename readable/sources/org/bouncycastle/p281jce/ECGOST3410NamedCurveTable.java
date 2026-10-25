package org.bouncycastle.p281jce;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;

/* loaded from: classes2.dex */
public class ECGOST3410NamedCurveTable {
    public static Enumeration getNames() {
        return ECGOST3410NamedCurves.getNames();
    }

    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID;
        X9ECParameters byNameX9 = ECGOST3410NamedCurves.getByNameX9(str);
        if (byNameX9 == null && (aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str)) != null) {
            byNameX9 = ECGOST3410NamedCurves.getByOIDX9(aSN1ObjectIdentifierTryFromID);
        }
        if (byNameX9 == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byNameX9.getCurve(), byNameX9.m14735getG(), byNameX9.m14737getN(), byNameX9.m14736getH(), byNameX9.m14738getSeed());
    }
}
