package org.bouncycastle.p133asn1.p172x500.p173style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.ASN1UniversalString;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.bouncycastle.p133asn1.p172x500.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500NameBuilder;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class IETFUtils {
    private static void addMultiValuedRDN(X500NameBuilder x500NameBuilder, X500NameTokenizer x500NameTokenizer) {
        String strNextToken = x500NameTokenizer.nextToken();
        if (strNextToken == null) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        if (!x500NameTokenizer.hasMoreTokens()) {
            m14672addRDN(x500NameBuilder, strNextToken);
            return;
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        X500NameStyle style = x500NameBuilder.getStyle();
        do {
            collectAttributeTypeAndValue(style, vector, vector2, strNextToken);
            strNextToken = x500NameTokenizer.nextToken();
        } while (strNextToken != null);
        x500NameBuilder.addMultiValuedRDN(toOIDArray(vector), toValueArray(vector2));
    }

    /* renamed from: addRDN */
    private static void m14672addRDN(X500NameBuilder x500NameBuilder, String str) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str, '=');
        x500NameBuilder.m14668addRDN(x500NameBuilder.getStyle().attrNameToOID(nextToken(x500NameTokenizer, true).trim()), unescape(nextToken(x500NameTokenizer, false)));
    }

    /* renamed from: addRDNs */
    private static void m14673addRDNs(X500NameBuilder x500NameBuilder, X500NameTokenizer x500NameTokenizer) {
        while (true) {
            String strNextToken = x500NameTokenizer.nextToken();
            if (strNextToken == null) {
                return;
            }
            if (strNextToken.indexOf(43) >= 0) {
                addMultiValuedRDN(x500NameBuilder, new X500NameTokenizer(strNextToken, '+'));
            } else {
                m14672addRDN(x500NameBuilder, strNextToken);
            }
        }
    }

    public static void appendRDN(StringBuffer stringBuffer, C5188RDN c5188rdn, Hashtable hashtable) {
        if (!c5188rdn.isMultiValued()) {
            AttributeTypeAndValue first = c5188rdn.getFirst();
            if (first != null) {
                appendTypeAndValue(stringBuffer, first, hashtable);
                return;
            }
            return;
        }
        AttributeTypeAndValue[] typesAndValues = c5188rdn.getTypesAndValues();
        boolean z = true;
        for (int i = 0; i != typesAndValues.length; i++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append('+');
            }
            appendTypeAndValue(stringBuffer, typesAndValues[i], hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String strM14433getId = (String) hashtable.get(attributeTypeAndValue.m14663getType());
        if (strM14433getId == null) {
            strM14433getId = attributeTypeAndValue.m14663getType().m14433getId();
        }
        stringBuffer.append(strM14433getId);
        stringBuffer.append('=');
        stringBuffer.append(valueToString(attributeTypeAndValue.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.m14663getType().m14446equals((ASN1Primitive) attributeTypeAndValue2.m14663getType()) && canonicalString(attributeTypeAndValue.getValue()).equals(canonicalString(attributeTypeAndValue2.getValue()));
    }

    public static String canonicalString(ASN1Encodable aSN1Encodable) {
        return canonicalize(valueToString(aSN1Encodable));
    }

    public static String canonicalize(String str) {
        int i = 0;
        if (str.length() > 0 && str.charAt(0) == '#') {
            ASN1Encodable aSN1EncodableDecodeObject = decodeObject(str);
            if (aSN1EncodableDecodeObject instanceof ASN1String) {
                str = ((ASN1String) aSN1EncodableDecodeObject).getString();
            }
        }
        String lowerCase = C6250Strings.toLowerCase(str);
        int length = lowerCase.length();
        if (length < 2) {
            return lowerCase;
        }
        int i2 = length - 1;
        while (i < i2 && lowerCase.charAt(i) == '\\' && lowerCase.charAt(i + 1) == ' ') {
            i += 2;
        }
        int i3 = i + 1;
        int i4 = i2;
        while (i4 > i3 && lowerCase.charAt(i4 - 1) == '\\' && lowerCase.charAt(i4) == ' ') {
            i4 -= 2;
        }
        if (i > 0 || i4 < i2) {
            lowerCase = lowerCase.substring(i, i4 + 1);
        }
        return stripInternalSpaces(lowerCase);
    }

    private static void collectAttributeTypeAndValue(X500NameStyle x500NameStyle, Vector vector, Vector vector2, String str) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str, '=');
        String strNextToken = nextToken(x500NameTokenizer, true);
        String strNextToken2 = nextToken(x500NameTokenizer, false);
        ASN1ObjectIdentifier aSN1ObjectIdentifierAttrNameToOID = x500NameStyle.attrNameToOID(strNextToken.trim());
        String strUnescape = unescape(strNextToken2);
        vector.addElement(aSN1ObjectIdentifierAttrNameToOID);
        vector2.addElement(strUnescape);
    }

    private static int convertHex(char c) {
        return ('0' > c || c > '9') ? ('a' > c || c > 'f') ? c - '7' : c - 'W' : c - '0';
    }

    public static ASN1ObjectIdentifier decodeAttrName(String str, Hashtable hashtable) {
        if (str.regionMatches(true, 0, "OID.", 0, 4)) {
            return new ASN1ObjectIdentifier(str.substring(4));
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
        if (aSN1ObjectIdentifierTryFromID != null) {
            return aSN1ObjectIdentifierTryFromID;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(C6250Strings.toLowerCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    private static ASN1Primitive decodeObject(String str) {
        try {
            return ASN1Primitive.fromByteArray(C6255Hex.decodeStrict(str, 1, str.length() - 1));
        } catch (IOException e) {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier aSN1ObjectIdentifier, Hashtable hashtable) {
        Enumeration enumerationElements = hashtable.elements();
        int i = 0;
        int i2 = 0;
        while (enumerationElements.hasMoreElements()) {
            if (aSN1ObjectIdentifier.mo14431equals(enumerationElements.nextElement())) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (aSN1ObjectIdentifier.mo14431equals(hashtable.get(str))) {
                strArr[i] = str;
                i++;
            }
        }
        return strArr;
    }

    private static boolean isHexDigit(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F');
    }

    private static String nextToken(X500NameTokenizer x500NameTokenizer, boolean z) {
        String strNextToken = x500NameTokenizer.nextToken();
        if (strNextToken == null || x500NameTokenizer.hasMoreTokens() != z) {
            throw new IllegalArgumentException("badly formatted directory string");
        }
        return strNextToken;
    }

    public static boolean rDNAreEqual(C5188RDN c5188rdn, C5188RDN c5188rdn2) {
        if (c5188rdn.m14664size() != c5188rdn2.m14664size()) {
            return false;
        }
        AttributeTypeAndValue[] typesAndValues = c5188rdn.getTypesAndValues();
        AttributeTypeAndValue[] typesAndValues2 = c5188rdn2.getTypesAndValues();
        if (typesAndValues.length != typesAndValues2.length) {
            return false;
        }
        for (int i = 0; i != typesAndValues.length; i++) {
            if (!atvAreEqual(typesAndValues[i], typesAndValues2[i])) {
                return false;
            }
        }
        return true;
    }

    public static C5188RDN[] rDNsFromString(String str, X500NameStyle x500NameStyle) {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        m14673addRDNs(x500NameBuilder, new X500NameTokenizer(str));
        return x500NameBuilder.buildRDNs();
    }

    public static String stripInternalSpaces(String str) {
        if (str.indexOf("  ") < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append(cCharAt);
        for (int i = 1; i < str.length(); i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt != ' ' || cCharAt2 != ' ') {
                sb.append(cCharAt2);
                cCharAt = cCharAt2;
            }
        }
        return sb.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i = 0; i != size; i++) {
            aSN1ObjectIdentifierArr[i] = (ASN1ObjectIdentifier) vector.elementAt(i);
        }
        return aSN1ObjectIdentifierArr;
    }

    private static String[] toValueArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String unescape(String str) {
        int i;
        if (str.length() == 0) {
            return str;
        }
        if (str.indexOf(92) < 0 && str.indexOf(34) < 0) {
            return str.trim();
        }
        StringBuilder sb = new StringBuilder(str.length());
        if (str.charAt(0) == '\\' && str.charAt(1) == '#') {
            sb.append("\\#");
            i = 2;
        } else {
            i = 0;
        }
        boolean z = false;
        int length = 0;
        boolean z2 = false;
        boolean z3 = false;
        char c = 0;
        while (i != str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ') {
                z3 = true;
            }
            if (cCharAt == '\"') {
                if (z) {
                    sb.append(cCharAt);
                    z = false;
                } else {
                    z2 = !z2;
                }
            } else if (cCharAt == '\\' && !z && !z2) {
                length = sb.length();
                z = true;
            } else if (cCharAt != ' ' || z || z3) {
                if (z && isHexDigit(cCharAt)) {
                    if (c != 0) {
                        sb.append((char) ((convertHex(c) * 16) + convertHex(cCharAt)));
                        z = false;
                        c = 0;
                    } else {
                        c = cCharAt;
                    }
                }
            }
            i++;
        }
        if (sb.length() > 0) {
            while (sb.charAt(sb.length() - 1) == ' ' && length != sb.length() - 1) {
                sb.setLength(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static ASN1Encodable valueFromHexString(String str, int i) {
        int length = (str.length() - i) / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 != length; i2++) {
            int i3 = (i2 * 2) + i;
            char cCharAt = str.charAt(i3);
            char cCharAt2 = str.charAt(i3 + 1);
            bArr[i2] = (byte) (convertHex(cCharAt2) | (convertHex(cCharAt) << 4));
        }
        return ASN1Primitive.fromByteArray(bArr);
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof ASN1UniversalString)) {
            try {
                sb.append('#');
                sb.append(C6255Hex.toHexString(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER)));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                sb.append('\\');
            }
            sb.append(string);
        }
        int length = sb.length();
        int i2 = (sb.length() >= 2 && sb.charAt(0) == '\\' && sb.charAt(1) == '#') ? 2 : 0;
        while (i2 != length) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt != '\"' && cCharAt != '\\' && cCharAt != '+' && cCharAt != ',') {
                switch (cCharAt) {
                    case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i2++;
                }
            }
            sb.insert(i2, "\\");
            i2 += 2;
            length++;
        }
        if (sb.length() > 0) {
            while (sb.length() > i && sb.charAt(i) == ' ') {
                sb.insert(i, "\\");
                i += 2;
            }
        }
        for (int length2 = sb.length() - 1; length2 >= i && sb.charAt(length2) == ' '; length2--) {
            sb.insert(length2, '\\');
        }
        return sb.toString();
    }

    public static void appendRDN(StringBuilder sb, C5188RDN c5188rdn, Hashtable hashtable) {
        if (!c5188rdn.isMultiValued()) {
            AttributeTypeAndValue first = c5188rdn.getFirst();
            if (first != null) {
                appendTypeAndValue(sb, first, hashtable);
                return;
            }
            return;
        }
        AttributeTypeAndValue[] typesAndValues = c5188rdn.getTypesAndValues();
        boolean z = true;
        for (int i = 0; i != typesAndValues.length; i++) {
            if (z) {
                z = false;
            } else {
                sb.append('+');
            }
            appendTypeAndValue(sb, typesAndValues[i], hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuilder sb, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String strM14433getId = (String) hashtable.get(attributeTypeAndValue.m14663getType());
        if (strM14433getId == null) {
            strM14433getId = attributeTypeAndValue.m14663getType().m14433getId();
        }
        sb.append(strM14433getId);
        sb.append('=');
        sb.append(valueToString(attributeTypeAndValue.getValue()));
    }
}
