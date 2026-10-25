package org.bouncycastle.p281jce;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveParameterSpec;

/* loaded from: classes2.dex */
public class ECNamedCurveTable {
    public static Enumeration getNames() {
        return org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable.getNames();
    }

    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
        X9ECParameters byOID = aSN1ObjectIdentifierTryFromID != null ? CustomNamedCurves.getByOID(aSN1ObjectIdentifierTryFromID) : CustomNamedCurves.getByName(str);
        if (byOID == null) {
            byOID = aSN1ObjectIdentifierTryFromID != null ? org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable.getByOID(aSN1ObjectIdentifierTryFromID) : org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable.getByName(str);
        }
        if (byOID == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byOID.getCurve(), byOID.m14735getG(), byOID.m14737getN(), byOID.m14736getH(), byOID.m14738getSeed());
    }
}
