package org.bouncycastle.p133asn1.p161nist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p167sec.SECNamedCurves;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParametersHolder;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class NISTNamedCurves {

    /* renamed from: objIds */
    static final Hashtable f18428objIds = new Hashtable();

    /* renamed from: names */
    static final Hashtable f18427names = new Hashtable();

    static {
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("K-571", SECObjectIdentifiers.sect571k1);
        defineCurve("K-409", SECObjectIdentifiers.sect409k1);
        defineCurve("K-283", SECObjectIdentifiers.sect283k1);
        defineCurve("K-233", SECObjectIdentifiers.sect233k1);
        defineCurve("K-163", SECObjectIdentifiers.sect163k1);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    public static void defineCurve(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        f18428objIds.put(str, aSN1ObjectIdentifier);
        f18427names.put(aSN1ObjectIdentifier, str);
    }

    public static X9ECParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14621getOID = m14621getOID(str);
        if (aSN1ObjectIdentifierM14621getOID != null) {
            return SECNamedCurves.getByOID(aSN1ObjectIdentifierM14621getOID);
        }
        return null;
    }

    public static X9ECParametersHolder getByNameLazy(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14621getOID = m14621getOID(str);
        if (aSN1ObjectIdentifierM14621getOID != null) {
            return SECNamedCurves.getByOIDLazy(aSN1ObjectIdentifierM14621getOID);
        }
        return null;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (f18427names.containsKey(aSN1ObjectIdentifier)) {
            return SECNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        return null;
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (f18427names.containsKey(aSN1ObjectIdentifier)) {
            return SECNamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        }
        return null;
    }

    /* renamed from: getName */
    public static String m14620getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) f18427names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return f18428objIds.keys();
    }

    /* renamed from: getOID */
    public static ASN1ObjectIdentifier m14621getOID(String str) {
        return (ASN1ObjectIdentifier) f18428objIds.get(C6250Strings.toUpperCase(str));
    }
}
