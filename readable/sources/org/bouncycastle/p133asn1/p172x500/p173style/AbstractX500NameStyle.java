package org.bouncycastle.p133asn1.p172x500.p173style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1ParsingException;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p172x500.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;

/* loaded from: classes2.dex */
public abstract class AbstractX500NameStyle implements X500NameStyle {
    private int calcHashCode(ASN1Encodable aSN1Encodable) {
        return IETFUtils.canonicalString(aSN1Encodable).hashCode();
    }

    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    private boolean foundMatch(boolean z, C5188RDN c5188rdn, C5188RDN[] c5188rdnArr) {
        if (z) {
            for (int length = c5188rdnArr.length - 1; length >= 0; length--) {
                C5188RDN c5188rdn2 = c5188rdnArr[length];
                if (c5188rdn2 != null && rdnAreEqual(c5188rdn, c5188rdn2)) {
                    c5188rdnArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i != c5188rdnArr.length; i++) {
                C5188RDN c5188rdn3 = c5188rdnArr[i];
                if (c5188rdn3 != null && rdnAreEqual(c5188rdn, c5188rdn3)) {
                    c5188rdnArr[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        if (x500Name.m14667size() != x500Name2.m14667size()) {
            return false;
        }
        C5188RDN[] c5188rdnArrM14665getRDNs = x500Name.m14665getRDNs();
        C5188RDN[] c5188rdnArrM14665getRDNs2 = x500Name2.m14665getRDNs();
        boolean z = (c5188rdnArrM14665getRDNs[0].getFirst() == null || c5188rdnArrM14665getRDNs2[0].getFirst() == null) ? false : !r0.m14663getType().m14446equals((ASN1Primitive) r1.m14663getType());
        for (int i = 0; i != c5188rdnArrM14665getRDNs.length; i++) {
            if (!foundMatch(z, c5188rdnArrM14665getRDNs[i], c5188rdnArrM14665getRDNs2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public int calculateHashCode(X500Name x500Name) {
        C5188RDN[] c5188rdnArrM14665getRDNs = x500Name.m14665getRDNs();
        int iHashCode = 0;
        for (int i = 0; i != c5188rdnArrM14665getRDNs.length; i++) {
            if (c5188rdnArrM14665getRDNs[i].isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = c5188rdnArrM14665getRDNs[i].getTypesAndValues();
                for (int i2 = 0; i2 != typesAndValues.length; i2++) {
                    iHashCode = (iHashCode ^ typesAndValues[i2].m14663getType().hashCode()) ^ calcHashCode(typesAndValues[i2].getValue());
                }
            } else {
                AttributeTypeAndValue first = c5188rdnArrM14665getRDNs[i].getFirst();
                iHashCode = (iHashCode ^ first.m14663getType().hashCode()) ^ calcHashCode(first.getValue());
            }
        }
        return iHashCode;
    }

    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return new DERUTF8String(str);
    }

    public boolean rdnAreEqual(C5188RDN c5188rdn, C5188RDN c5188rdn2) {
        return IETFUtils.rDNAreEqual(c5188rdn, c5188rdn2);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return encodeStringValue(aSN1ObjectIdentifier, str);
        }
        try {
            return IETFUtils.valueFromHexString(str, 1);
        } catch (IOException unused) {
            throw new ASN1ParsingException("can't recode value for oid " + aSN1ObjectIdentifier.m14433getId());
        }
    }
}
