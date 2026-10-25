package org.bouncycastle.p133asn1.p172x500.p173style;

import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;

/* loaded from: classes2.dex */
public class RFC4519Style extends AbstractX500NameStyle {
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final X500NameStyle INSTANCE;
    public static final ASN1ObjectIdentifier businessCategory;

    /* renamed from: c */
    public static final ASN1ObjectIdentifier f18606c;

    /* renamed from: cn */
    public static final ASN1ObjectIdentifier f18607cn;

    /* renamed from: dc */
    public static final ASN1ObjectIdentifier f18608dc;
    public static final ASN1ObjectIdentifier description;
    public static final ASN1ObjectIdentifier destinationIndicator;
    public static final ASN1ObjectIdentifier distinguishedName;
    public static final ASN1ObjectIdentifier dnQualifier;
    public static final ASN1ObjectIdentifier enhancedSearchGuide;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber;
    public static final ASN1ObjectIdentifier generationQualifier;
    public static final ASN1ObjectIdentifier givenName;
    public static final ASN1ObjectIdentifier houseIdentifier;
    public static final ASN1ObjectIdentifier initials;
    public static final ASN1ObjectIdentifier internationalISDNNumber;

    /* renamed from: l */
    public static final ASN1ObjectIdentifier f18609l;

    /* renamed from: member */
    public static final ASN1ObjectIdentifier f18610member;

    /* renamed from: name */
    public static final ASN1ObjectIdentifier f18611name;

    /* renamed from: o */
    public static final ASN1ObjectIdentifier f18612o;

    /* renamed from: ou */
    public static final ASN1ObjectIdentifier f18613ou;

    /* renamed from: owner */
    public static final ASN1ObjectIdentifier f18614owner;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName;
    public static final ASN1ObjectIdentifier postOfficeBox;
    public static final ASN1ObjectIdentifier postalAddress;
    public static final ASN1ObjectIdentifier postalCode;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod;
    public static final ASN1ObjectIdentifier registeredAddress;
    public static final ASN1ObjectIdentifier roleOccupant;
    public static final ASN1ObjectIdentifier searchGuide;

    /* renamed from: seeAlso */
    public static final ASN1ObjectIdentifier f18615seeAlso;
    public static final ASN1ObjectIdentifier serialNumber;

    /* renamed from: sn */
    public static final ASN1ObjectIdentifier f18616sn;

    /* renamed from: st */
    public static final ASN1ObjectIdentifier f18617st;

    /* renamed from: street */
    public static final ASN1ObjectIdentifier f18618street;
    public static final ASN1ObjectIdentifier telephoneNumber;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
    public static final ASN1ObjectIdentifier telexNumber;

    /* renamed from: title */
    public static final ASN1ObjectIdentifier f18619title;

    /* renamed from: uid */
    public static final ASN1ObjectIdentifier f18620uid;
    public static final ASN1ObjectIdentifier uniqueMember;
    public static final ASN1ObjectIdentifier userPassword;
    public static final ASN1ObjectIdentifier x121Address;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier;
    protected final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
    protected final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern = new ASN1ObjectIdentifier("2.5.4.15").m14434intern();
        businessCategory = aSN1ObjectIdentifierM14434intern;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern2 = new ASN1ObjectIdentifier("2.5.4.6").m14434intern();
        f18606c = aSN1ObjectIdentifierM14434intern2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern3 = new ASN1ObjectIdentifier("2.5.4.3").m14434intern();
        f18607cn = aSN1ObjectIdentifierM14434intern3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern4 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").m14434intern();
        f18608dc = aSN1ObjectIdentifierM14434intern4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern5 = new ASN1ObjectIdentifier("2.5.4.13").m14434intern();
        description = aSN1ObjectIdentifierM14434intern5;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern6 = new ASN1ObjectIdentifier("2.5.4.27").m14434intern();
        destinationIndicator = aSN1ObjectIdentifierM14434intern6;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern7 = new ASN1ObjectIdentifier("2.5.4.49").m14434intern();
        distinguishedName = aSN1ObjectIdentifierM14434intern7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern8 = new ASN1ObjectIdentifier("2.5.4.46").m14434intern();
        dnQualifier = aSN1ObjectIdentifierM14434intern8;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern9 = new ASN1ObjectIdentifier("2.5.4.47").m14434intern();
        enhancedSearchGuide = aSN1ObjectIdentifierM14434intern9;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern10 = new ASN1ObjectIdentifier("2.5.4.23").m14434intern();
        facsimileTelephoneNumber = aSN1ObjectIdentifierM14434intern10;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern11 = new ASN1ObjectIdentifier("2.5.4.44").m14434intern();
        generationQualifier = aSN1ObjectIdentifierM14434intern11;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern12 = new ASN1ObjectIdentifier("2.5.4.42").m14434intern();
        givenName = aSN1ObjectIdentifierM14434intern12;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern13 = new ASN1ObjectIdentifier("2.5.4.51").m14434intern();
        houseIdentifier = aSN1ObjectIdentifierM14434intern13;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern14 = new ASN1ObjectIdentifier("2.5.4.43").m14434intern();
        initials = aSN1ObjectIdentifierM14434intern14;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern15 = new ASN1ObjectIdentifier("2.5.4.25").m14434intern();
        internationalISDNNumber = aSN1ObjectIdentifierM14434intern15;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern16 = new ASN1ObjectIdentifier("2.5.4.7").m14434intern();
        f18609l = aSN1ObjectIdentifierM14434intern16;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern17 = new ASN1ObjectIdentifier("2.5.4.31").m14434intern();
        f18610member = aSN1ObjectIdentifierM14434intern17;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern18 = new ASN1ObjectIdentifier("2.5.4.41").m14434intern();
        f18611name = aSN1ObjectIdentifierM14434intern18;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern19 = new ASN1ObjectIdentifier("2.5.4.10").m14434intern();
        f18612o = aSN1ObjectIdentifierM14434intern19;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern20 = new ASN1ObjectIdentifier("2.5.4.11").m14434intern();
        f18613ou = aSN1ObjectIdentifierM14434intern20;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern21 = new ASN1ObjectIdentifier("2.5.4.32").m14434intern();
        f18614owner = aSN1ObjectIdentifierM14434intern21;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern22 = new ASN1ObjectIdentifier("2.5.4.19").m14434intern();
        physicalDeliveryOfficeName = aSN1ObjectIdentifierM14434intern22;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern23 = new ASN1ObjectIdentifier("2.5.4.16").m14434intern();
        postalAddress = aSN1ObjectIdentifierM14434intern23;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern24 = new ASN1ObjectIdentifier("2.5.4.17").m14434intern();
        postalCode = aSN1ObjectIdentifierM14434intern24;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern25 = new ASN1ObjectIdentifier("2.5.4.18").m14434intern();
        postOfficeBox = aSN1ObjectIdentifierM14434intern25;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern26 = new ASN1ObjectIdentifier("2.5.4.28").m14434intern();
        preferredDeliveryMethod = aSN1ObjectIdentifierM14434intern26;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern27 = new ASN1ObjectIdentifier("2.5.4.26").m14434intern();
        registeredAddress = aSN1ObjectIdentifierM14434intern27;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern28 = new ASN1ObjectIdentifier("2.5.4.33").m14434intern();
        roleOccupant = aSN1ObjectIdentifierM14434intern28;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern29 = new ASN1ObjectIdentifier("2.5.4.14").m14434intern();
        searchGuide = aSN1ObjectIdentifierM14434intern29;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern30 = new ASN1ObjectIdentifier("2.5.4.34").m14434intern();
        f18615seeAlso = aSN1ObjectIdentifierM14434intern30;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern31 = new ASN1ObjectIdentifier("2.5.4.5").m14434intern();
        serialNumber = aSN1ObjectIdentifierM14434intern31;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern32 = new ASN1ObjectIdentifier("2.5.4.4").m14434intern();
        f18616sn = aSN1ObjectIdentifierM14434intern32;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern33 = new ASN1ObjectIdentifier("2.5.4.8").m14434intern();
        f18617st = aSN1ObjectIdentifierM14434intern33;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern34 = new ASN1ObjectIdentifier("2.5.4.9").m14434intern();
        f18618street = aSN1ObjectIdentifierM14434intern34;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern35 = new ASN1ObjectIdentifier("2.5.4.20").m14434intern();
        telephoneNumber = aSN1ObjectIdentifierM14434intern35;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern36 = new ASN1ObjectIdentifier("2.5.4.22").m14434intern();
        teletexTerminalIdentifier = aSN1ObjectIdentifierM14434intern36;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern37 = new ASN1ObjectIdentifier("2.5.4.21").m14434intern();
        telexNumber = aSN1ObjectIdentifierM14434intern37;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern38 = new ASN1ObjectIdentifier("2.5.4.12").m14434intern();
        f18619title = aSN1ObjectIdentifierM14434intern38;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern39 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").m14434intern();
        f18620uid = aSN1ObjectIdentifierM14434intern39;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern40 = new ASN1ObjectIdentifier("2.5.4.50").m14434intern();
        uniqueMember = aSN1ObjectIdentifierM14434intern40;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern41 = new ASN1ObjectIdentifier("2.5.4.35").m14434intern();
        userPassword = aSN1ObjectIdentifierM14434intern41;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern42 = new ASN1ObjectIdentifier("2.5.4.24").m14434intern();
        x121Address = aSN1ObjectIdentifierM14434intern42;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern43 = new ASN1ObjectIdentifier("2.5.4.45").m14434intern();
        x500UniqueIdentifier = aSN1ObjectIdentifierM14434intern43;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifierM14434intern, "businessCategory");
        hashtable.put(aSN1ObjectIdentifierM14434intern2, "c");
        hashtable.put(aSN1ObjectIdentifierM14434intern3, "cn");
        hashtable.put(aSN1ObjectIdentifierM14434intern4, "dc");
        hashtable.put(aSN1ObjectIdentifierM14434intern5, "description");
        hashtable.put(aSN1ObjectIdentifierM14434intern6, "destinationIndicator");
        hashtable.put(aSN1ObjectIdentifierM14434intern7, "distinguishedName");
        hashtable.put(aSN1ObjectIdentifierM14434intern8, "dnQualifier");
        hashtable.put(aSN1ObjectIdentifierM14434intern9, "enhancedSearchGuide");
        hashtable.put(aSN1ObjectIdentifierM14434intern10, "facsimileTelephoneNumber");
        hashtable.put(aSN1ObjectIdentifierM14434intern11, "generationQualifier");
        hashtable.put(aSN1ObjectIdentifierM14434intern12, "givenName");
        hashtable.put(aSN1ObjectIdentifierM14434intern13, "houseIdentifier");
        hashtable.put(aSN1ObjectIdentifierM14434intern14, "initials");
        hashtable.put(aSN1ObjectIdentifierM14434intern15, "internationalISDNNumber");
        hashtable.put(aSN1ObjectIdentifierM14434intern16, "l");
        hashtable.put(aSN1ObjectIdentifierM14434intern17, "member");
        hashtable.put(aSN1ObjectIdentifierM14434intern18, "name");
        hashtable.put(aSN1ObjectIdentifierM14434intern19, "o");
        hashtable.put(aSN1ObjectIdentifierM14434intern20, "ou");
        hashtable.put(aSN1ObjectIdentifierM14434intern21, "owner");
        hashtable.put(aSN1ObjectIdentifierM14434intern22, "physicalDeliveryOfficeName");
        hashtable.put(aSN1ObjectIdentifierM14434intern23, "postalAddress");
        hashtable.put(aSN1ObjectIdentifierM14434intern24, "postalCode");
        hashtable.put(aSN1ObjectIdentifierM14434intern25, "postOfficeBox");
        hashtable.put(aSN1ObjectIdentifierM14434intern26, "preferredDeliveryMethod");
        hashtable.put(aSN1ObjectIdentifierM14434intern27, "registeredAddress");
        hashtable.put(aSN1ObjectIdentifierM14434intern28, "roleOccupant");
        hashtable.put(aSN1ObjectIdentifierM14434intern29, "searchGuide");
        hashtable.put(aSN1ObjectIdentifierM14434intern30, "seeAlso");
        hashtable.put(aSN1ObjectIdentifierM14434intern31, "serialNumber");
        hashtable.put(aSN1ObjectIdentifierM14434intern32, "sn");
        hashtable.put(aSN1ObjectIdentifierM14434intern33, "st");
        hashtable.put(aSN1ObjectIdentifierM14434intern34, "street");
        hashtable.put(aSN1ObjectIdentifierM14434intern35, "telephoneNumber");
        hashtable.put(aSN1ObjectIdentifierM14434intern36, "teletexTerminalIdentifier");
        hashtable.put(aSN1ObjectIdentifierM14434intern37, "telexNumber");
        hashtable.put(aSN1ObjectIdentifierM14434intern38, "title");
        hashtable.put(aSN1ObjectIdentifierM14434intern39, "uid");
        hashtable.put(aSN1ObjectIdentifierM14434intern40, "uniqueMember");
        hashtable.put(aSN1ObjectIdentifierM14434intern41, "userPassword");
        hashtable.put(aSN1ObjectIdentifierM14434intern42, "x121Address");
        hashtable.put(aSN1ObjectIdentifierM14434intern43, "x500UniqueIdentifier");
        hashtable2.put("businesscategory", aSN1ObjectIdentifierM14434intern);
        hashtable2.put("c", aSN1ObjectIdentifierM14434intern2);
        hashtable2.put("cn", aSN1ObjectIdentifierM14434intern3);
        hashtable2.put("dc", aSN1ObjectIdentifierM14434intern4);
        hashtable2.put("description", aSN1ObjectIdentifierM14434intern5);
        hashtable2.put("destinationindicator", aSN1ObjectIdentifierM14434intern6);
        hashtable2.put("distinguishedname", aSN1ObjectIdentifierM14434intern7);
        hashtable2.put("dnqualifier", aSN1ObjectIdentifierM14434intern8);
        hashtable2.put("enhancedsearchguide", aSN1ObjectIdentifierM14434intern9);
        hashtable2.put("facsimiletelephonenumber", aSN1ObjectIdentifierM14434intern10);
        hashtable2.put("generationqualifier", aSN1ObjectIdentifierM14434intern11);
        hashtable2.put("givenname", aSN1ObjectIdentifierM14434intern12);
        hashtable2.put("houseidentifier", aSN1ObjectIdentifierM14434intern13);
        hashtable2.put("initials", aSN1ObjectIdentifierM14434intern14);
        hashtable2.put("internationalisdnnumber", aSN1ObjectIdentifierM14434intern15);
        hashtable2.put("l", aSN1ObjectIdentifierM14434intern16);
        hashtable2.put("member", aSN1ObjectIdentifierM14434intern17);
        hashtable2.put("name", aSN1ObjectIdentifierM14434intern18);
        hashtable2.put("o", aSN1ObjectIdentifierM14434intern19);
        hashtable2.put("ou", aSN1ObjectIdentifierM14434intern20);
        hashtable2.put("owner", aSN1ObjectIdentifierM14434intern21);
        hashtable2.put("physicaldeliveryofficename", aSN1ObjectIdentifierM14434intern22);
        hashtable2.put("postaladdress", aSN1ObjectIdentifierM14434intern23);
        hashtable2.put("postalcode", aSN1ObjectIdentifierM14434intern24);
        hashtable2.put("postofficebox", aSN1ObjectIdentifierM14434intern25);
        hashtable2.put("preferreddeliverymethod", aSN1ObjectIdentifierM14434intern26);
        hashtable2.put("registeredaddress", aSN1ObjectIdentifierM14434intern27);
        hashtable2.put("roleoccupant", aSN1ObjectIdentifierM14434intern28);
        hashtable2.put("searchguide", aSN1ObjectIdentifierM14434intern29);
        hashtable2.put("seealso", aSN1ObjectIdentifierM14434intern30);
        hashtable2.put("serialnumber", aSN1ObjectIdentifierM14434intern31);
        hashtable2.put("sn", aSN1ObjectIdentifierM14434intern32);
        hashtable2.put("st", aSN1ObjectIdentifierM14434intern33);
        hashtable2.put("street", aSN1ObjectIdentifierM14434intern34);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifierM14434intern35);
        hashtable2.put("teletexterminalidentifier", aSN1ObjectIdentifierM14434intern36);
        hashtable2.put("telexnumber", aSN1ObjectIdentifierM14434intern37);
        hashtable2.put("title", aSN1ObjectIdentifierM14434intern38);
        hashtable2.put("uid", aSN1ObjectIdentifierM14434intern39);
        hashtable2.put("uniquemember", aSN1ObjectIdentifierM14434intern40);
        hashtable2.put("userpassword", aSN1ObjectIdentifierM14434intern41);
        hashtable2.put("x121address", aSN1ObjectIdentifierM14434intern42);
        hashtable2.put("x500uniqueidentifier", aSN1ObjectIdentifierM14434intern43);
        INSTANCE = new RFC4519Style();
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.p173style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return aSN1ObjectIdentifier.m14446equals((ASN1Primitive) f18608dc) ? new DERIA5String(str) : (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) f18606c) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) serialNumber) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) dnQualifier) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) telephoneNumber)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.bouncycastle.p133asn1.p172x500.X500NameStyle
    public C5188RDN[] fromString(String str) {
        C5188RDN[] c5188rdnArrRDNsFromString = IETFUtils.rDNsFromString(str, this);
        C5188RDN[] c5188rdnArr = new C5188RDN[c5188rdnArrRDNsFromString.length];
        for (int i = 0; i != c5188rdnArrRDNsFromString.length; i++) {
            c5188rdnArr[(r5 - i) - 1] = c5188rdnArrRDNsFromString[i];
        }
        return c5188rdnArr;
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
        C5188RDN[] c5188rdnArrM14665getRDNs = x500Name.m14665getRDNs();
        boolean z = true;
        for (int length = c5188rdnArrM14665getRDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            IETFUtils.appendRDN(sb, c5188rdnArrM14665getRDNs[length], this.defaultSymbols);
        }
        return sb.toString();
    }
}
