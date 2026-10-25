package org.bouncycastle.p133asn1.p172x500.p173style;

import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* renamed from: org.bouncycastle.asn1.x500.style.BCStyle */
/* loaded from: classes2.dex */
public class C5189BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;

    /* renamed from: C */
    public static final ASN1ObjectIdentifier f18590C;

    /* renamed from: CN */
    public static final ASN1ObjectIdentifier f18591CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;

    /* renamed from: DC */
    public static final ASN1ObjectIdentifier f18592DC;
    public static final ASN1ObjectIdentifier DESCRIPTION;
    public static final ASN1ObjectIdentifier DMD_NAME;
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;

    /* renamed from: E */
    public static final ASN1ObjectIdentifier f18593E;
    public static final ASN1ObjectIdentifier EmailAddress;

    /* renamed from: GENDER */
    public static final ASN1ObjectIdentifier f18594GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final X500NameStyle INSTANCE;
    public static final ASN1ObjectIdentifier JURISDICTION_C;
    public static final ASN1ObjectIdentifier JURISDICTION_L;
    public static final ASN1ObjectIdentifier JURISDICTION_ST;

    /* renamed from: L */
    public static final ASN1ObjectIdentifier f18595L;

    /* renamed from: NAME */
    public static final ASN1ObjectIdentifier f18596NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;

    /* renamed from: O */
    public static final ASN1ObjectIdentifier f18597O;
    public static final ASN1ObjectIdentifier ORGANIZATION_IDENTIFIER;

    /* renamed from: OU */
    public static final ASN1ObjectIdentifier f18598OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;

    /* renamed from: ROLE */
    public static final ASN1ObjectIdentifier f18599ROLE;
    public static final ASN1ObjectIdentifier SERIALNUMBER;

    /* renamed from: SN */
    public static final ASN1ObjectIdentifier f18600SN;

    /* renamed from: ST */
    public static final ASN1ObjectIdentifier f18601ST;

    /* renamed from: STREET */
    public static final ASN1ObjectIdentifier f18602STREET;

    /* renamed from: SURNAME */
    public static final ASN1ObjectIdentifier f18603SURNAME;

    /* renamed from: T */
    public static final ASN1ObjectIdentifier f18604T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;

    /* renamed from: UID */
    public static final ASN1ObjectIdentifier f18605UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    protected final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
    protected final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern = new ASN1ObjectIdentifier("2.5.4.6").m14434intern();
        f18590C = aSN1ObjectIdentifierM14434intern;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern2 = new ASN1ObjectIdentifier("2.5.4.10").m14434intern();
        f18597O = aSN1ObjectIdentifierM14434intern2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern3 = new ASN1ObjectIdentifier("2.5.4.11").m14434intern();
        f18598OU = aSN1ObjectIdentifierM14434intern3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern4 = new ASN1ObjectIdentifier("2.5.4.12").m14434intern();
        f18604T = aSN1ObjectIdentifierM14434intern4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern5 = new ASN1ObjectIdentifier("2.5.4.3").m14434intern();
        f18591CN = aSN1ObjectIdentifierM14434intern5;
        f18600SN = new ASN1ObjectIdentifier("2.5.4.5").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern6 = new ASN1ObjectIdentifier("2.5.4.9").m14434intern();
        f18602STREET = aSN1ObjectIdentifierM14434intern6;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern7 = new ASN1ObjectIdentifier("2.5.4.5").m14434intern();
        SERIALNUMBER = aSN1ObjectIdentifierM14434intern7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern8 = new ASN1ObjectIdentifier("2.5.4.7").m14434intern();
        f18595L = aSN1ObjectIdentifierM14434intern8;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern9 = new ASN1ObjectIdentifier("2.5.4.8").m14434intern();
        f18601ST = aSN1ObjectIdentifierM14434intern9;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern10 = new ASN1ObjectIdentifier("2.5.4.4").m14434intern();
        f18603SURNAME = aSN1ObjectIdentifierM14434intern10;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern11 = new ASN1ObjectIdentifier("2.5.4.42").m14434intern();
        GIVENNAME = aSN1ObjectIdentifierM14434intern11;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern12 = new ASN1ObjectIdentifier("2.5.4.43").m14434intern();
        INITIALS = aSN1ObjectIdentifierM14434intern12;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern13 = new ASN1ObjectIdentifier("2.5.4.44").m14434intern();
        GENERATION = aSN1ObjectIdentifierM14434intern13;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern14 = new ASN1ObjectIdentifier("2.5.4.45").m14434intern();
        UNIQUE_IDENTIFIER = aSN1ObjectIdentifierM14434intern14;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern15 = new ASN1ObjectIdentifier("2.5.4.13").m14434intern();
        DESCRIPTION = aSN1ObjectIdentifierM14434intern15;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern16 = new ASN1ObjectIdentifier("2.5.4.15").m14434intern();
        BUSINESS_CATEGORY = aSN1ObjectIdentifierM14434intern16;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern17 = new ASN1ObjectIdentifier("2.5.4.17").m14434intern();
        POSTAL_CODE = aSN1ObjectIdentifierM14434intern17;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern18 = new ASN1ObjectIdentifier("2.5.4.46").m14434intern();
        DN_QUALIFIER = aSN1ObjectIdentifierM14434intern18;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern19 = new ASN1ObjectIdentifier("2.5.4.65").m14434intern();
        PSEUDONYM = aSN1ObjectIdentifierM14434intern19;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern20 = new ASN1ObjectIdentifier("2.5.4.72").m14434intern();
        f18599ROLE = aSN1ObjectIdentifierM14434intern20;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.f18744id_pda;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern21 = aSN1ObjectIdentifier.m14432branch("1").m14434intern();
        DATE_OF_BIRTH = aSN1ObjectIdentifierM14434intern21;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern22 = aSN1ObjectIdentifier.m14432branch("2").m14434intern();
        PLACE_OF_BIRTH = aSN1ObjectIdentifierM14434intern22;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern23 = aSN1ObjectIdentifier.m14432branch("3").m14434intern();
        f18594GENDER = aSN1ObjectIdentifierM14434intern23;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern24 = aSN1ObjectIdentifier.m14432branch("4").m14434intern();
        COUNTRY_OF_CITIZENSHIP = aSN1ObjectIdentifierM14434intern24;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern25 = aSN1ObjectIdentifier.m14432branch("5").m14434intern();
        COUNTRY_OF_RESIDENCE = aSN1ObjectIdentifierM14434intern25;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern26 = new ASN1ObjectIdentifier("1.3.36.8.3.14").m14434intern();
        NAME_AT_BIRTH = aSN1ObjectIdentifierM14434intern26;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern27 = new ASN1ObjectIdentifier("2.5.4.16").m14434intern();
        POSTAL_ADDRESS = aSN1ObjectIdentifierM14434intern27;
        DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = X509ObjectIdentifiers.id_at_name;
        f18596NAME = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = X509ObjectIdentifiers.id_at_organizationIdentifier;
        ORGANIZATION_IDENTIFIER = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier7;
        f18593E = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        f18592DC = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        f18605UID = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.3");
        JURISDICTION_C = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.2");
        JURISDICTION_ST = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("1.3.6.1.4.1.311.60.2.1.1");
        JURISDICTION_L = aSN1ObjectIdentifier12;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifierM14434intern, "C");
        hashtable.put(aSN1ObjectIdentifierM14434intern2, "O");
        hashtable.put(aSN1ObjectIdentifierM14434intern4, "T");
        hashtable.put(aSN1ObjectIdentifierM14434intern3, "OU");
        hashtable.put(aSN1ObjectIdentifierM14434intern5, "CN");
        hashtable.put(aSN1ObjectIdentifierM14434intern8, "L");
        hashtable.put(aSN1ObjectIdentifierM14434intern9, "ST");
        hashtable.put(aSN1ObjectIdentifierM14434intern7, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier5, "E");
        hashtable.put(aSN1ObjectIdentifier8, "DC");
        hashtable.put(aSN1ObjectIdentifier9, "UID");
        hashtable.put(aSN1ObjectIdentifierM14434intern6, "STREET");
        hashtable.put(aSN1ObjectIdentifierM14434intern10, "SURNAME");
        hashtable.put(aSN1ObjectIdentifierM14434intern11, "GIVENNAME");
        hashtable.put(aSN1ObjectIdentifierM14434intern12, "INITIALS");
        hashtable.put(aSN1ObjectIdentifierM14434intern13, "GENERATION");
        hashtable.put(aSN1ObjectIdentifierM14434intern15, "DESCRIPTION");
        hashtable.put(aSN1ObjectIdentifierM14434intern20, "ROLE");
        hashtable.put(aSN1ObjectIdentifier7, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier6, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifierM14434intern14, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifierM14434intern18, "DN");
        hashtable.put(aSN1ObjectIdentifierM14434intern19, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifierM14434intern27, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifierM14434intern26, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifierM14434intern24, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifierM14434intern25, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifierM14434intern23, "Gender");
        hashtable.put(aSN1ObjectIdentifierM14434intern22, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifierM14434intern21, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifierM14434intern17, "PostalCode");
        hashtable.put(aSN1ObjectIdentifierM14434intern16, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier2, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier3, "Name");
        hashtable.put(aSN1ObjectIdentifier4, "organizationIdentifier");
        hashtable.put(aSN1ObjectIdentifier10, "jurisdictionCountry");
        hashtable.put(aSN1ObjectIdentifier11, "jurisdictionState");
        hashtable.put(aSN1ObjectIdentifier12, "jurisdictionLocality");
        hashtable2.put("c", aSN1ObjectIdentifierM14434intern);
        hashtable2.put("o", aSN1ObjectIdentifierM14434intern2);
        hashtable2.put("t", aSN1ObjectIdentifierM14434intern4);
        hashtable2.put("ou", aSN1ObjectIdentifierM14434intern3);
        hashtable2.put("cn", aSN1ObjectIdentifierM14434intern5);
        hashtable2.put("l", aSN1ObjectIdentifierM14434intern8);
        hashtable2.put("st", aSN1ObjectIdentifierM14434intern9);
        hashtable2.put("sn", aSN1ObjectIdentifierM14434intern10);
        hashtable2.put("serialnumber", aSN1ObjectIdentifierM14434intern7);
        hashtable2.put("street", aSN1ObjectIdentifierM14434intern6);
        hashtable2.put("emailaddress", aSN1ObjectIdentifier5);
        hashtable2.put("dc", aSN1ObjectIdentifier8);
        hashtable2.put("e", aSN1ObjectIdentifier5);
        hashtable2.put("uid", aSN1ObjectIdentifier9);
        hashtable2.put("surname", aSN1ObjectIdentifierM14434intern10);
        hashtable2.put("givenname", aSN1ObjectIdentifierM14434intern11);
        hashtable2.put("initials", aSN1ObjectIdentifierM14434intern12);
        hashtable2.put("generation", aSN1ObjectIdentifierM14434intern13);
        hashtable2.put("description", aSN1ObjectIdentifierM14434intern15);
        hashtable2.put("role", aSN1ObjectIdentifierM14434intern20);
        hashtable2.put("unstructuredaddress", aSN1ObjectIdentifier7);
        hashtable2.put("unstructuredname", aSN1ObjectIdentifier6);
        hashtable2.put("uniqueidentifier", aSN1ObjectIdentifierM14434intern14);
        hashtable2.put("dn", aSN1ObjectIdentifierM14434intern18);
        hashtable2.put("pseudonym", aSN1ObjectIdentifierM14434intern19);
        hashtable2.put("postaladdress", aSN1ObjectIdentifierM14434intern27);
        hashtable2.put("nameatbirth", aSN1ObjectIdentifierM14434intern26);
        hashtable2.put("countryofcitizenship", aSN1ObjectIdentifierM14434intern24);
        hashtable2.put("countryofresidence", aSN1ObjectIdentifierM14434intern25);
        hashtable2.put("gender", aSN1ObjectIdentifierM14434intern23);
        hashtable2.put("placeofbirth", aSN1ObjectIdentifierM14434intern22);
        hashtable2.put("dateofbirth", aSN1ObjectIdentifierM14434intern21);
        hashtable2.put("postalcode", aSN1ObjectIdentifierM14434intern17);
        hashtable2.put("businesscategory", aSN1ObjectIdentifierM14434intern16);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifier2);
        hashtable2.put("name", aSN1ObjectIdentifier3);
        hashtable2.put("organizationidentifier", aSN1ObjectIdentifier4);
        hashtable2.put("jurisdictioncountry", aSN1ObjectIdentifier10);
        hashtable2.put("jurisdictionstate", aSN1ObjectIdentifier11);
        hashtable2.put("jurisdictionlocality", aSN1ObjectIdentifier12);
        INSTANCE = new C5189BCStyle();
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.p173style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) EmailAddress) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) f18592DC)) ? new DERIA5String(str) : aSN1ObjectIdentifier.m14446equals((ASN1Primitive) DATE_OF_BIRTH) ? new ASN1GeneralizedTime(str) : (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) f18590C) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) SERIALNUMBER) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) DN_QUALIFIER) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TELEPHONE_NUMBER) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) JURISDICTION_C)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public C5188RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) this.defaultSymbols.get(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public String toString(X500Name x500Name) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (C5188RDN c5188rdn : x500Name.m14665getRDNs()) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            IETFUtils.appendRDN(sb, c5188rdn, this.defaultSymbols);
        }
        return sb.toString();
    }
}
