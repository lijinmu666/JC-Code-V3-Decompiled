package org.bouncycastle.p133asn1.p176x9;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.internal.p231asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.p133asn1.p134anssi.ANSSINamedCurves;
import org.bouncycastle.p133asn1.p148gm.GMNamedCurves;
import org.bouncycastle.p133asn1.p161nist.NISTNamedCurves;
import org.bouncycastle.p133asn1.p167sec.SECNamedCurves;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;

/* loaded from: classes2.dex */
public class ECNamedCurveTable {
    private static void addEnumeration(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static X9ECParameters getByName(String str) {
        X9ECParameters byName = X962NamedCurves.getByName(str);
        if (byName == null) {
            byName = SECNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = NISTNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = TeleTrusTNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = ANSSINamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = ECGOST3410NamedCurves.getByNameX9(str);
        }
        return byName == null ? GMNamedCurves.getByName(str) : byName;
    }

    public static X9ECParametersHolder getByNameLazy(String str) {
        X9ECParametersHolder byNameLazy = X962NamedCurves.getByNameLazy(str);
        if (byNameLazy == null) {
            byNameLazy = SECNamedCurves.getByNameLazy(str);
        }
        if (byNameLazy == null) {
            byNameLazy = NISTNamedCurves.getByNameLazy(str);
        }
        if (byNameLazy == null) {
            byNameLazy = TeleTrusTNamedCurves.getByNameLazy(str);
        }
        if (byNameLazy == null) {
            byNameLazy = ANSSINamedCurves.getByNameLazy(str);
        }
        if (byNameLazy == null) {
            byNameLazy = ECGOST3410NamedCurves.getByNameLazy(str);
        }
        return byNameLazy == null ? GMNamedCurves.getByNameLazy(str) : byNameLazy;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID == null) {
            byOID = SECNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = ANSSINamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = ECGOST3410NamedCurves.getByOIDX9(aSN1ObjectIdentifier);
        }
        return byOID == null ? GMNamedCurves.getByOID(aSN1ObjectIdentifier) : byOID;
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder byOIDLazy = X962NamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        if (byOIDLazy == null) {
            byOIDLazy = SECNamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        }
        if (byOIDLazy == null) {
            byOIDLazy = TeleTrusTNamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        }
        if (byOIDLazy == null) {
            byOIDLazy = ANSSINamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        }
        if (byOIDLazy == null) {
            byOIDLazy = ECGOST3410NamedCurves.getByOIDLazy(aSN1ObjectIdentifier);
        }
        return byOIDLazy == null ? GMNamedCurves.getByOIDLazy(aSN1ObjectIdentifier) : byOIDLazy;
    }

    /* renamed from: getName */
    public static String m14727getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String strM14731getName = X962NamedCurves.m14731getName(aSN1ObjectIdentifier);
        if (strM14731getName == null) {
            strM14731getName = SECNamedCurves.m14642getName(aSN1ObjectIdentifier);
        }
        if (strM14731getName == null) {
            strM14731getName = NISTNamedCurves.m14620getName(aSN1ObjectIdentifier);
        }
        if (strM14731getName == null) {
            strM14731getName = TeleTrusTNamedCurves.m14645getName(aSN1ObjectIdentifier);
        }
        if (strM14731getName == null) {
            strM14731getName = ANSSINamedCurves.m14481getName(aSN1ObjectIdentifier);
        }
        if (strM14731getName == null) {
            strM14731getName = ECGOST3410NamedCurves.m14570getName(aSN1ObjectIdentifier);
        }
        if (strM14731getName == null) {
            strM14731getName = GMNamedCurves.m14612getName(aSN1ObjectIdentifier);
        }
        return strM14731getName == null ? CustomNamedCurves.m15213getName(aSN1ObjectIdentifier) : strM14731getName;
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        addEnumeration(vector, X962NamedCurves.getNames());
        addEnumeration(vector, SECNamedCurves.getNames());
        addEnumeration(vector, NISTNamedCurves.getNames());
        addEnumeration(vector, TeleTrusTNamedCurves.getNames());
        addEnumeration(vector, ANSSINamedCurves.getNames());
        addEnumeration(vector, ECGOST3410NamedCurves.getNames());
        addEnumeration(vector, GMNamedCurves.getNames());
        return vector.elements();
    }

    /* renamed from: getOID */
    public static ASN1ObjectIdentifier m14728getOID(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14732getOID = X962NamedCurves.m14732getOID(str);
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = SECNamedCurves.m14643getOID(str);
        }
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = NISTNamedCurves.m14621getOID(str);
        }
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = TeleTrusTNamedCurves.m14646getOID(str);
        }
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = ANSSINamedCurves.m14482getOID(str);
        }
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = ECGOST3410NamedCurves.m14571getOID(str);
        }
        if (aSN1ObjectIdentifierM14732getOID == null) {
            aSN1ObjectIdentifierM14732getOID = GMNamedCurves.m14613getOID(str);
        }
        return (aSN1ObjectIdentifierM14732getOID == null && str.equals("curve25519")) ? CryptlibObjectIdentifiers.curvey25519 : aSN1ObjectIdentifierM14732getOID;
    }
}
