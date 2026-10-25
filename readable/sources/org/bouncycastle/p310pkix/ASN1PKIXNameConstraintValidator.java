package org.bouncycastle.p310pkix;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.IETFUtils;
import org.bouncycastle.p133asn1.p172x500.p173style.RFC4519Style;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralSubtree;
import org.bouncycastle.p133asn1.p174x509.NameConstraintValidator;
import org.bouncycastle.p133asn1.p174x509.NameConstraintValidatorException;
import org.bouncycastle.p133asn1.p174x509.OtherName;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class ASN1PKIXNameConstraintValidator implements NameConstraintValidator {
    private Set permittedSubtreesDN;
    private Set permittedSubtreesDNS;
    private Set permittedSubtreesEmail;
    private Set permittedSubtreesIP;
    private Set permittedSubtreesOtherName;
    private Set permittedSubtreesURI;
    private Set excludedSubtreesDN = new HashSet();
    private Set excludedSubtreesDNS = new HashSet();
    private Set excludedSubtreesEmail = new HashSet();
    private Set excludedSubtreesURI = new HashSet();
    private Set excludedSubtreesIP = new HashSet();
    private Set excludedSubtreesOtherName = new HashSet();

    /* renamed from: addLine */
    private static void m17428addLine(StringBuilder sb, String str) {
        sb.append(str);
        sb.append(C6250Strings.lineSeparator());
    }

    private static void checkExcludedDN(Set set, ASN1Sequence aSN1Sequence) throws NameConstraintValidatorException {
        if (isDNConstrained(set, aSN1Sequence)) {
            throw new NameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
        }
    }

    private static void checkExcludedDNS(Set set, String str) throws NameConstraintValidatorException {
        if (isDNSConstrained(set, str)) {
            throw new NameConstraintValidatorException("DNS is from an excluded subtree.");
        }
    }

    private static void checkExcludedIP(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (isIPConstrained(set, bArr)) {
            throw new NameConstraintValidatorException("IP is from an excluded subtree.");
        }
    }

    private static void checkExcludedOtherName(Set set, OtherName otherName) throws NameConstraintValidatorException {
        if (isOtherNameConstrained(set, otherName)) {
            throw new NameConstraintValidatorException("OtherName is from an excluded subtree.");
        }
    }

    private static void checkExcludedURI(Set set, String str) throws NameConstraintValidatorException {
        if (isURIConstrained(set, str)) {
            throw new NameConstraintValidatorException("URI is from an excluded subtree.");
        }
    }

    private static void checkPermittedDN(Set set, ASN1Sequence aSN1Sequence) throws NameConstraintValidatorException {
        if (set != null) {
            if ((!set.isEmpty() || aSN1Sequence.mo14450size() != 0) && !isDNConstrained(set, aSN1Sequence)) {
                throw new NameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
            }
        }
    }

    private static void checkPermittedDNS(Set set, String str) throws NameConstraintValidatorException {
        if (set != null) {
            if ((str.length() != 0 || set.size() != 0) && !isDNSConstrained(set, str)) {
                throw new NameConstraintValidatorException("DNS is not from a permitted subtree.");
            }
        }
    }

    private static void checkPermittedIP(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (set != null) {
            if ((bArr.length != 0 || set.size() != 0) && !isIPConstrained(set, bArr)) {
                throw new NameConstraintValidatorException("IP is not from a permitted subtree.");
            }
        }
    }

    private static void checkPermittedOtherName(Set set, OtherName otherName) throws NameConstraintValidatorException {
        if (set != null && !isOtherNameConstrained(set, otherName)) {
            throw new NameConstraintValidatorException("Subject OtherName is not from a permitted subtree.");
        }
    }

    private static void checkPermittedURI(Set set, String str) throws NameConstraintValidatorException {
        if (set != null) {
            if ((str.length() != 0 || set.size() != 0) && !isURIConstrained(set, str)) {
                throw new NameConstraintValidatorException("URI is not from a permitted subtree.");
            }
        }
    }

    private static boolean collectionsAreEqual(Collection collection, Collection collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (Object obj : collection) {
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                if (m17429equals(obj, it.next())) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    private static int compareTo(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & C1126UByte.MAX_VALUE;
            int i3 = bArr2[i] & C1126UByte.MAX_VALUE;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
        }
        return 0;
    }

    private static String extractHostFromURL(String str) {
        String strSubstring = str.substring(str.indexOf(58) + 1);
        int iIndexOf = strSubstring.indexOf("//");
        if (iIndexOf != -1) {
            strSubstring = strSubstring.substring(iIndexOf + 2);
        }
        int iLastIndexOf = strSubstring.lastIndexOf(58);
        if (iLastIndexOf != -1) {
            strSubstring = strSubstring.substring(0, iLastIndexOf);
        }
        String strSubstring2 = strSubstring.substring(strSubstring.indexOf(58) + 1);
        String strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(64) + 1);
        int iIndexOf2 = strSubstring3.indexOf(47);
        return iIndexOf2 != -1 ? strSubstring3.substring(0, iIndexOf2) : strSubstring3;
    }

    private static byte[][] extractIPsAndSubnetMasks(byte[] bArr, byte[] bArr2) {
        int length = bArr.length / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, length, bArr4, 0, length);
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, length);
        System.arraycopy(bArr2, length, bArr6, 0, length);
        return new byte[][]{bArr3, bArr4, bArr5, bArr6};
    }

    private static String extractNameAsString(ASN1Encodable aSN1Encodable) {
        return ASN1IA5String.getInstance(aSN1Encodable).getString();
    }

    private static int hashCollection(Collection collection) {
        int iHashCode = 0;
        if (collection == null) {
            return 0;
        }
        for (Object obj : collection) {
            iHashCode += obj instanceof byte[] ? C6238Arrays.hashCode((byte[]) obj) : obj.hashCode();
        }
        return iHashCode;
    }

    private static Set intersectDN(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(((GeneralSubtree) it.next()).m14694getBase().m14690getName());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) it2.next();
                    if (withinDNSubtree(aSN1Sequence, aSN1Sequence2)) {
                        hashSet.add(aSN1Sequence);
                    } else if (withinDNSubtree(aSN1Sequence2, aSN1Sequence)) {
                        hashSet.add(aSN1Sequence2);
                    }
                }
            } else if (aSN1Sequence != null) {
                hashSet.add(aSN1Sequence);
            }
        }
        return hashSet;
    }

    private static Set intersectDNS(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String strExtractNameAsString = extractNameAsString((GeneralSubtree) it.next());
            if (set == null) {
                hashSet.add(strExtractNameAsString);
            } else {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (isDNSConstrained(strExtractNameAsString, str)) {
                        hashSet.add(str);
                    } else if (withinDomain(strExtractNameAsString, str)) {
                        hashSet.add(strExtractNameAsString);
                    }
                }
            }
        }
        return hashSet;
    }

    private static Set intersectEmail(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String strExtractNameAsString = extractNameAsString((GeneralSubtree) it.next());
            if (set == null) {
                hashSet.add(strExtractNameAsString);
            } else {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectEmail(strExtractNameAsString, (String) it2.next(), hashSet);
                }
            }
        }
        return hashSet;
    }

    private static Set intersectIP(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            byte[] octets = ASN1OctetString.getInstance(((GeneralSubtree) it.next()).m14694getBase().m14690getName()).getOctets();
            if (set == null) {
                hashSet.add(octets);
            } else {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    byte[] bArrIntersectIPRange = intersectIPRange((byte[]) it2.next(), octets);
                    if (bArrIntersectIPRange != null) {
                        hashSet.add(bArrIntersectIPRange);
                    }
                }
            }
        }
        return hashSet;
    }

    private static byte[] intersectIPRange(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return null;
        }
        byte[][] bArrExtractIPsAndSubnetMasks = extractIPsAndSubnetMasks(bArr, bArr2);
        byte[] bArr3 = bArrExtractIPsAndSubnetMasks[0];
        byte[] bArr4 = bArrExtractIPsAndSubnetMasks[1];
        byte[] bArr5 = bArrExtractIPsAndSubnetMasks[2];
        byte[] bArr6 = bArrExtractIPsAndSubnetMasks[3];
        byte[][] bArrMinMaxIPs = minMaxIPs(bArr3, bArr4, bArr5, bArr6);
        byte[] bArr7 = bArrMinMaxIPs[0];
        byte[] bArr8 = bArrMinMaxIPs[1];
        byte[] bArr9 = bArrMinMaxIPs[2];
        if (compareTo(m17430max(bArr7, bArr9), m17431min(bArr8, bArrMinMaxIPs[3])) == 1) {
            return null;
        }
        return ipWithSubnetMask(m17432or(bArr7, bArr9), m17432or(bArr4, bArr6));
    }

    private static Set intersectOtherName(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            OtherName otherName = OtherName.getInstance(((GeneralSubtree) it.next()).m14694getBase().m14690getName());
            if (otherName != null) {
                if (set == null) {
                    hashSet.add(otherName);
                } else {
                    Iterator it2 = set.iterator();
                    while (it2.hasNext()) {
                        intersectOtherName(otherName, OtherName.getInstance(it2.next()), hashSet);
                    }
                }
            }
        }
        return hashSet;
    }

    private static Set intersectURI(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String strExtractNameAsString = extractNameAsString((GeneralSubtree) it.next());
            if (set == null) {
                hashSet.add(strExtractNameAsString);
            } else {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectURI((String) it2.next(), strExtractNameAsString, hashSet);
                }
            }
        }
        return hashSet;
    }

    private static byte[] ipWithSubnetMask(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.concatenate(bArr, bArr2);
    }

    private static boolean isDNConstrained(Set set, ASN1Sequence aSN1Sequence) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (withinDNSubtree(aSN1Sequence, (ASN1Sequence) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDNSConstrained(String str, String str2) {
        return str2.equalsIgnoreCase(str) || withinDomain(str2, str);
    }

    private static boolean isEmailConstrained(String str, String str2) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf > 0) {
            return str2.equalsIgnoreCase(str);
        }
        String strSubstring = str2.substring(str2.indexOf(64) + 1);
        return iIndexOf == 0 ? strSubstring.equalsIgnoreCase(str.substring(1)) : str.startsWith(".") ? withinDomain(strSubstring, str) : strSubstring.equalsIgnoreCase(str);
    }

    private static boolean isIPConstrained(Set set, byte[] bArr) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isIPConstrained((byte[]) it.next(), bArr)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOtherNameConstrained(Set set, OtherName otherName) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isOtherNameConstrained(OtherName.getInstance(it.next()), otherName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isURIConstrained(String str, String str2) {
        String strExtractHostFromURL = extractHostFromURL(str2);
        return str.startsWith(".") ? withinDomain(strExtractHostFromURL, str) : strExtractHostFromURL.equalsIgnoreCase(str);
    }

    /* renamed from: max */
    private static byte[] m17430max(byte[] bArr, byte[] bArr2) {
        return compareTo(bArr, bArr2) > 0 ? bArr : bArr2;
    }

    /* renamed from: min */
    private static byte[] m17431min(byte[] bArr, byte[] bArr2) {
        return compareTo(bArr, bArr2) < 0 ? bArr : bArr2;
    }

    private static byte[][] minMaxIPs(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int length = bArr.length;
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        byte[] bArr7 = new byte[length];
        byte[] bArr8 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr5[i] = (byte) (bArr[i] & bArr2[i]);
            byte b = bArr[i];
            byte b2 = bArr2[i];
            bArr6[i] = (byte) ((b & b2) | (~b2));
            bArr7[i] = (byte) (bArr3[i] & bArr4[i]);
            byte b3 = bArr3[i];
            byte b4 = bArr4[i];
            bArr8[i] = (byte) ((b3 & b4) | (~b4));
        }
        return new byte[][]{bArr5, bArr6, bArr7, bArr8};
    }

    /* renamed from: or */
    private static byte[] m17432or(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] | bArr2[i]);
        }
        return bArr3;
    }

    private static String stringifyIP(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length / 2; i++) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(Integer.toString(bArr[i] & C1126UByte.MAX_VALUE));
        }
        sb.append("/");
        boolean z = true;
        for (int length = bArr.length / 2; length < bArr.length; length++) {
            if (z) {
                z = false;
            } else {
                sb.append(".");
            }
            sb.append(Integer.toString(bArr[length] & C1126UByte.MAX_VALUE));
        }
        return sb.toString();
    }

    private static String stringifyIPCollection(Set set) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(stringifyIP((byte[]) it.next()));
        }
        sb.append("]");
        return sb.toString();
    }

    private static String stringifyOtherNameCollection(Set set) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            OtherName otherName = OtherName.getInstance(it.next());
            sb.append(otherName.getTypeID().m14433getId());
            sb.append(":");
            try {
                sb.append(C6255Hex.toHexString(otherName.getValue().toASN1Primitive().getEncoded()));
            } catch (IOException e) {
                sb.append(e.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: unionDN */
    private static Set m17433unionDN(Set set, ASN1Sequence aSN1Sequence) {
        if (set.isEmpty()) {
            if (aSN1Sequence != null) {
                set.add(aSN1Sequence);
            }
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(it.next());
            if (withinDNSubtree(aSN1Sequence, aSN1Sequence2)) {
                hashSet.add(aSN1Sequence2);
            } else {
                if (!withinDNSubtree(aSN1Sequence2, aSN1Sequence)) {
                    hashSet.add(aSN1Sequence2);
                }
                hashSet.add(aSN1Sequence);
            }
        }
        return hashSet;
    }

    private static Set unionDNS(Set set, String str) {
        if (set.isEmpty()) {
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!isDNSConstrained(str, str2)) {
                boolean zWithinDomain = withinDomain(str, str2);
                hashSet.add(str2);
                if (zWithinDomain) {
                }
            }
            hashSet.add(str);
        }
        return hashSet;
    }

    private static Set unionEmail(Set set, String str) {
        if (set.isEmpty()) {
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            unionEmail((String) it.next(), str, hashSet);
        }
        return hashSet;
    }

    /* renamed from: unionIP */
    private static Set m17434unionIP(Set set, byte[] bArr) {
        if (set.isEmpty()) {
            if (bArr != null) {
                set.add(bArr);
            }
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.addAll(unionIPRange((byte[]) it.next(), bArr));
        }
        return hashSet;
    }

    private static Set unionIPRange(byte[] bArr, byte[] bArr2) {
        HashSet hashSet = new HashSet();
        boolean zAreEqual = C6238Arrays.areEqual(bArr, bArr2);
        hashSet.add(bArr);
        if (!zAreEqual) {
            hashSet.add(bArr2);
        }
        return hashSet;
    }

    private static Set unionOtherName(Set set, OtherName otherName) {
        HashSet hashSet = set != null ? new HashSet(set) : new HashSet();
        hashSet.add(otherName);
        return hashSet;
    }

    private static Set unionURI(Set set, String str) {
        if (set.isEmpty()) {
            set.add(str);
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            unionURI((String) it.next(), str, hashSet);
        }
        return hashSet;
    }

    private static boolean withinDNSubtree(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.mo14450size() < 1 || aSN1Sequence2.mo14450size() > aSN1Sequence.mo14450size()) {
            return false;
        }
        C5188RDN c5188rdn = C5188RDN.getInstance(aSN1Sequence2.getObjectAt(0));
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= aSN1Sequence.mo14450size()) {
                i = i2;
                break;
            }
            if (IETFUtils.rDNAreEqual(c5188rdn, C5188RDN.getInstance(aSN1Sequence.getObjectAt(i)))) {
                break;
            }
            i2 = i;
            i++;
        }
        if (aSN1Sequence2.mo14450size() > aSN1Sequence.mo14450size() - i) {
            return false;
        }
        for (int i3 = 0; i3 < aSN1Sequence2.mo14450size(); i3++) {
            C5188RDN c5188rdn2 = C5188RDN.getInstance(aSN1Sequence2.getObjectAt(i3));
            C5188RDN c5188rdn3 = C5188RDN.getInstance(aSN1Sequence.getObjectAt(i + i3));
            if (c5188rdn2.m14664size() != c5188rdn3.m14664size() || !c5188rdn2.getFirst().m14663getType().m14446equals((ASN1Primitive) c5188rdn3.getFirst().m14663getType())) {
                return false;
            }
            if (c5188rdn2.m14664size() == 1 && c5188rdn2.getFirst().m14663getType().m14446equals((ASN1Primitive) RFC4519Style.serialNumber)) {
                if (!c5188rdn3.getFirst().getValue().toString().startsWith(c5188rdn2.getFirst().getValue().toString())) {
                    return false;
                }
            } else if (!IETFUtils.rDNAreEqual(c5188rdn2, c5188rdn3)) {
                return false;
            }
        }
        return true;
    }

    private static boolean withinDomain(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        String[] strArrM18307split = C6250Strings.m18307split(str2, '.');
        String[] strArrM18307split2 = C6250Strings.m18307split(str, '.');
        if (strArrM18307split2.length <= strArrM18307split.length) {
            return false;
        }
        int length = strArrM18307split2.length - strArrM18307split.length;
        if (strArrM18307split2[length - 1].equals(BuildConfig.f24315FLAVOR)) {
            return false;
        }
        for (int i = 0; i < strArrM18307split.length; i++) {
            if (!strArrM18307split[i].equalsIgnoreCase(strArrM18307split2[length + i])) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        GeneralName generalNameM14694getBase = generalSubtree.m14694getBase();
        ASN1Encodable aSN1EncodableM14690getName = generalNameM14694getBase.m14690getName();
        int tagNo = generalNameM14694getBase.getTagNo();
        if (tagNo == 0) {
            this.excludedSubtreesOtherName = unionOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 1) {
            this.excludedSubtreesEmail = unionEmail(this.excludedSubtreesEmail, extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 2) {
            this.excludedSubtreesDNS = unionDNS(this.excludedSubtreesDNS, extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 4) {
            this.excludedSubtreesDN = m17433unionDN(this.excludedSubtreesDN, ASN1Sequence.getInstance(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 6) {
            this.excludedSubtreesURI = unionURI(this.excludedSubtreesURI, extractNameAsString(aSN1EncodableM14690getName));
        } else {
            if (tagNo == 7) {
                this.excludedSubtreesIP = m17434unionIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(aSN1EncodableM14690getName).getOctets());
                return;
            }
            throw new IllegalStateException("Unknown tag encountered: " + generalNameM14694getBase.getTagNo());
        }
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void checkExcluded(GeneralName generalName) throws NameConstraintValidatorException {
        ASN1Encodable aSN1EncodableM14690getName = generalName.m14690getName();
        int tagNo = generalName.getTagNo();
        if (tagNo == 0) {
            checkExcludedOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 1) {
            checkExcludedEmail(extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 2) {
            checkExcludedDNS(this.excludedSubtreesDNS, extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 4) {
            checkExcludedDN(X500Name.getInstance(aSN1EncodableM14690getName));
        } else if (tagNo == 6) {
            checkExcludedURI(this.excludedSubtreesURI, extractNameAsString(aSN1EncodableM14690getName));
        } else {
            if (tagNo != 7) {
                return;
            }
            checkExcludedIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(aSN1EncodableM14690getName).getOctets());
        }
    }

    public void checkExcludedEmail(String str) throws NameConstraintValidatorException {
        checkExcludedEmail(this.excludedSubtreesEmail, str);
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void checkPermitted(GeneralName generalName) throws NameConstraintValidatorException {
        ASN1Encodable aSN1EncodableM14690getName = generalName.m14690getName();
        int tagNo = generalName.getTagNo();
        if (tagNo == 0) {
            checkPermittedOtherName(this.permittedSubtreesOtherName, OtherName.getInstance(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 1) {
            checkPermittedEmail(extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 2) {
            checkPermittedDNS(this.permittedSubtreesDNS, extractNameAsString(aSN1EncodableM14690getName));
            return;
        }
        if (tagNo == 4) {
            checkPermittedDN(X500Name.getInstance(aSN1EncodableM14690getName));
        } else if (tagNo == 6) {
            checkPermittedURI(this.permittedSubtreesURI, extractNameAsString(aSN1EncodableM14690getName));
        } else {
            if (tagNo != 7) {
                return;
            }
            checkPermittedIP(this.permittedSubtreesIP, ASN1OctetString.getInstance(aSN1EncodableM14690getName).getOctets());
        }
    }

    public void checkPermittedEmail(String str) throws NameConstraintValidatorException {
        checkPermittedEmail(this.permittedSubtreesEmail, str);
    }

    /* renamed from: equals */
    public boolean m17435equals(Object obj) {
        if (!(obj instanceof ASN1PKIXNameConstraintValidator)) {
            return false;
        }
        ASN1PKIXNameConstraintValidator aSN1PKIXNameConstraintValidator = (ASN1PKIXNameConstraintValidator) obj;
        return collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesDN, this.excludedSubtreesDN) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesDNS, this.excludedSubtreesDNS) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesEmail, this.excludedSubtreesEmail) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesIP, this.excludedSubtreesIP) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesURI, this.excludedSubtreesURI) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.excludedSubtreesOtherName, this.excludedSubtreesOtherName) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesDN, this.permittedSubtreesDN) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesDNS, this.permittedSubtreesDNS) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesEmail, this.permittedSubtreesEmail) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesIP, this.permittedSubtreesIP) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesURI, this.permittedSubtreesURI) && collectionsAreEqual(aSN1PKIXNameConstraintValidator.permittedSubtreesOtherName, this.permittedSubtreesOtherName);
    }

    public int hashCode() {
        return hashCollection(this.excludedSubtreesDN) + hashCollection(this.excludedSubtreesDNS) + hashCollection(this.excludedSubtreesEmail) + hashCollection(this.excludedSubtreesIP) + hashCollection(this.excludedSubtreesURI) + hashCollection(this.excludedSubtreesOtherName) + hashCollection(this.permittedSubtreesDN) + hashCollection(this.permittedSubtreesDNS) + hashCollection(this.permittedSubtreesEmail) + hashCollection(this.permittedSubtreesIP) + hashCollection(this.permittedSubtreesURI) + hashCollection(this.permittedSubtreesOtherName);
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void intersectEmptyPermittedSubtree(int i) {
        if (i == 0) {
            this.permittedSubtreesOtherName = new HashSet();
            return;
        }
        if (i == 1) {
            this.permittedSubtreesEmail = new HashSet();
            return;
        }
        if (i == 2) {
            this.permittedSubtreesDNS = new HashSet();
            return;
        }
        if (i == 4) {
            this.permittedSubtreesDN = new HashSet();
            return;
        }
        if (i == 6) {
            this.permittedSubtreesURI = new HashSet();
        } else {
            if (i == 7) {
                this.permittedSubtreesIP = new HashSet();
                return;
            }
            throw new IllegalStateException("Unknown tag encountered: " + i);
        }
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        intersectPermittedSubtree(new GeneralSubtree[]{generalSubtree});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m17428addLine(sb, "permitted:");
        if (this.permittedSubtreesDN != null) {
            m17428addLine(sb, "DN:");
            m17428addLine(sb, this.permittedSubtreesDN.toString());
        }
        if (this.permittedSubtreesDNS != null) {
            m17428addLine(sb, "DNS:");
            m17428addLine(sb, this.permittedSubtreesDNS.toString());
        }
        if (this.permittedSubtreesEmail != null) {
            m17428addLine(sb, "Email:");
            m17428addLine(sb, this.permittedSubtreesEmail.toString());
        }
        if (this.permittedSubtreesURI != null) {
            m17428addLine(sb, "URI:");
            m17428addLine(sb, this.permittedSubtreesURI.toString());
        }
        if (this.permittedSubtreesIP != null) {
            m17428addLine(sb, "IP:");
            m17428addLine(sb, stringifyIPCollection(this.permittedSubtreesIP));
        }
        if (this.permittedSubtreesOtherName != null) {
            m17428addLine(sb, "OtherName:");
            m17428addLine(sb, stringifyOtherNameCollection(this.permittedSubtreesOtherName));
        }
        m17428addLine(sb, "excluded:");
        if (!this.excludedSubtreesDN.isEmpty()) {
            m17428addLine(sb, "DN:");
            m17428addLine(sb, this.excludedSubtreesDN.toString());
        }
        if (!this.excludedSubtreesDNS.isEmpty()) {
            m17428addLine(sb, "DNS:");
            m17428addLine(sb, this.excludedSubtreesDNS.toString());
        }
        if (!this.excludedSubtreesEmail.isEmpty()) {
            m17428addLine(sb, "Email:");
            m17428addLine(sb, this.excludedSubtreesEmail.toString());
        }
        if (!this.excludedSubtreesURI.isEmpty()) {
            m17428addLine(sb, "URI:");
            m17428addLine(sb, this.excludedSubtreesURI.toString());
        }
        if (!this.excludedSubtreesIP.isEmpty()) {
            m17428addLine(sb, "IP:");
            m17428addLine(sb, stringifyIPCollection(this.excludedSubtreesIP));
        }
        if (!this.excludedSubtreesOtherName.isEmpty()) {
            m17428addLine(sb, "OtherName:");
            m17428addLine(sb, stringifyOtherNameCollection(this.excludedSubtreesOtherName));
        }
        return sb.toString();
    }

    private static void checkExcludedEmail(Set set, String str) throws NameConstraintValidatorException {
        if (isEmailConstrained(set, str)) {
            throw new NameConstraintValidatorException("Email address is from an excluded subtree.");
        }
    }

    private static void checkPermittedEmail(Set set, String str) throws NameConstraintValidatorException {
        if (set != null) {
            if ((str.length() != 0 || set.size() != 0) && !isEmailConstrained(set, str)) {
                throw new NameConstraintValidatorException("Subject email address is not from a permitted subtree.");
            }
        }
    }

    /* renamed from: equals */
    private static boolean m17429equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? C6238Arrays.areEqual((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    private static String extractNameAsString(GeneralSubtree generalSubtree) {
        return extractNameAsString(generalSubtree.m14694getBase().m14690getName());
    }

    private static void intersectEmail(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(strSubstring, str2)) {
                    return;
                }
            } else if (!strSubstring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(".")) {
                if (str2.indexOf(64) != -1) {
                    if (!withinDomain(str2.substring(str2.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(".")) {
                    if (!isDNSConstrained(str2, str)) {
                        if (!withinDomain(str2, str)) {
                            return;
                        }
                    }
                } else if (!withinDomain(str2, str)) {
                    return;
                }
                set.add(str2);
                return;
            }
            if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
                set.add(str2);
                return;
            } else if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
        }
        set.add(str);
    }

    private static void intersectOtherName(OtherName otherName, OtherName otherName2, Set set) {
        if (otherName.mo14431equals(otherName2)) {
            set.add(otherName);
        }
    }

    private static void intersectURI(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (!str.equalsIgnoreCase(str2)) {
                    return;
                }
            } else if (str2.startsWith(".")) {
                if (!withinDomain(strSubstring, str2)) {
                    return;
                }
            } else if (!strSubstring.equalsIgnoreCase(str2)) {
                return;
            }
        } else {
            if (str.startsWith(".")) {
                if (str2.indexOf(64) != -1) {
                    if (!withinDomain(str2.substring(str2.indexOf(64) + 1), str)) {
                        return;
                    }
                } else if (str2.startsWith(".")) {
                    if (!isDNSConstrained(str2, str)) {
                        if (!withinDomain(str2, str)) {
                            return;
                        }
                    }
                } else if (!withinDomain(str2, str)) {
                    return;
                }
                set.add(str2);
                return;
            }
            if (str2.indexOf(64) != -1) {
                if (!str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                    return;
                }
                set.add(str2);
                return;
            } else if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                    return;
                }
            } else if (!str.equalsIgnoreCase(str2)) {
                return;
            }
        }
        set.add(str);
    }

    private static boolean isDNSConstrained(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isDNSConstrained((String) it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmailConstrained(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isEmailConstrained((String) it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIPConstrained(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        if (length != bArr.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr4[i] = (byte) (bArr[i] & bArr3[i]);
            bArr5[i] = (byte) (bArr2[i] & bArr3[i]);
        }
        return C6238Arrays.areEqual(bArr4, bArr5);
    }

    private static boolean isOtherNameConstrained(OtherName otherName, OtherName otherName2) {
        return otherName.mo14431equals(otherName2);
    }

    private static boolean isURIConstrained(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isURIConstrained((String) it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (withinDomain(r5.substring(r5.indexOf(64) + 1), r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (withinDomain(r5, r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        r6.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        if (withinDomain(r5, r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
    
        if (r5.substring(r5.indexOf(64) + 1).equalsIgnoreCase(r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
    
        if (r4.equalsIgnoreCase(r5) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r4.equalsIgnoreCase(r5) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void unionEmail(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) == -1) {
                if (!str2.startsWith(".") ? !strSubstring.equalsIgnoreCase(str2) : !withinDomain(strSubstring, str2)) {
                }
            }
            set.add(str);
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) == -1) {
                if (str2.startsWith(".")) {
                    if (!isDNSConstrained(str2, str)) {
                    }
                }
            }
        } else if (str2.indexOf(64) == -1) {
            if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                }
            }
            set.add(str);
        }
        set.add(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (withinDomain(r5.substring(r5.indexOf(64) + 1), r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (withinDomain(r5, r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        r6.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        if (withinDomain(r5, r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
    
        if (r5.substring(r5.indexOf(64) + 1).equalsIgnoreCase(r4) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
    
        if (r4.equalsIgnoreCase(r5) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r4.equalsIgnoreCase(r5) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void unionURI(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String strSubstring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) == -1) {
                if (!str2.startsWith(".") ? !strSubstring.equalsIgnoreCase(str2) : !withinDomain(strSubstring, str2)) {
                }
            }
            set.add(str);
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) == -1) {
                if (str2.startsWith(".")) {
                    if (!isDNSConstrained(str2, str)) {
                    }
                }
            }
        } else if (str2.indexOf(64) == -1) {
            if (str2.startsWith(".")) {
                if (!withinDomain(str, str2)) {
                }
            }
            set.add(str);
        }
        set.add(str2);
    }

    public void checkExcludedDN(X500Name x500Name) throws NameConstraintValidatorException {
        checkExcludedDN(this.excludedSubtreesDN, ASN1Sequence.getInstance(x500Name));
    }

    public void checkPermittedDN(X500Name x500Name) throws NameConstraintValidatorException {
        checkPermittedDN(this.permittedSubtreesDN, ASN1Sequence.getInstance(x500Name));
    }

    @Override // org.bouncycastle.p133asn1.p174x509.NameConstraintValidator
    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        HashMap map = new HashMap();
        for (int i = 0; i != generalSubtreeArr.length; i++) {
            GeneralSubtree generalSubtree = generalSubtreeArr[i];
            Integer numM18296valueOf = Integers.m18296valueOf(generalSubtree.m14694getBase().getTagNo());
            Set hashSet = (Set) map.get(numM18296valueOf);
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(numM18296valueOf, hashSet);
            }
            hashSet.add(generalSubtree);
        }
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            Set set = (Set) entry.getValue();
            if (iIntValue == 0) {
                this.permittedSubtreesOtherName = intersectOtherName(this.permittedSubtreesOtherName, set);
            } else if (iIntValue == 1) {
                this.permittedSubtreesEmail = intersectEmail(this.permittedSubtreesEmail, set);
            } else if (iIntValue == 2) {
                this.permittedSubtreesDNS = intersectDNS(this.permittedSubtreesDNS, set);
            } else if (iIntValue == 4) {
                this.permittedSubtreesDN = intersectDN(this.permittedSubtreesDN, set);
            } else if (iIntValue == 6) {
                this.permittedSubtreesURI = intersectURI(this.permittedSubtreesURI, set);
            } else {
                if (iIntValue != 7) {
                    throw new IllegalStateException("Unknown tag encountered: " + iIntValue);
                }
                this.permittedSubtreesIP = intersectIP(this.permittedSubtreesIP, set);
            }
        }
    }
}
