package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface X509AttributeIdentifiers {

    @Deprecated
    public static final ASN1ObjectIdentifier RoleSyntax = new ASN1ObjectIdentifier("2.5.4.72");

    /* renamed from: id_aca */
    public static final ASN1ObjectIdentifier f18713id_aca;
    public static final ASN1ObjectIdentifier id_aca_accessIdentity;
    public static final ASN1ObjectIdentifier id_aca_authenticationInfo;
    public static final ASN1ObjectIdentifier id_aca_chargingIdentity;
    public static final ASN1ObjectIdentifier id_aca_encAttrs;
    public static final ASN1ObjectIdentifier id_aca_group;
    public static final ASN1ObjectIdentifier id_at_clearance;

    @Deprecated
    public static final ASN1ObjectIdentifier id_at_privateKeyStatement;
    public static final ASN1ObjectIdentifier id_at_role;
    public static final ASN1ObjectIdentifier id_at_statementOfPossession;
    public static final ASN1ObjectIdentifier id_ce_targetInformation;
    public static final ASN1ObjectIdentifier id_pe_aaControls;
    public static final ASN1ObjectIdentifier id_pe_ac_auditIdentity;
    public static final ASN1ObjectIdentifier id_pe_ac_proxying;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.f18745id_pe;
        id_pe_ac_auditIdentity = aSN1ObjectIdentifier.m14432branch("4");
        id_pe_aaControls = aSN1ObjectIdentifier.m14432branch("6");
        id_pe_ac_proxying = aSN1ObjectIdentifier.m14432branch("10");
        id_ce_targetInformation = X509ObjectIdentifiers.f18743id_ce.m14432branch("55");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = X509ObjectIdentifiers.f18746id_pkix.m14432branch("10");
        f18713id_aca = aSN1ObjectIdentifierM14432branch;
        id_aca_authenticationInfo = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_aca_accessIdentity = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_aca_chargingIdentity = aSN1ObjectIdentifierM14432branch.m14432branch("3");
        id_aca_group = aSN1ObjectIdentifierM14432branch.m14432branch("4");
        id_aca_encAttrs = aSN1ObjectIdentifierM14432branch.m14432branch("6");
        id_at_role = new ASN1ObjectIdentifier("2.5.4.72");
        id_at_clearance = new ASN1ObjectIdentifier("2.5.1.5.55");
        id_at_privateKeyStatement = new ASN1ObjectIdentifier("1.3.6.1.4.1.22112.2.1");
        id_at_statementOfPossession = new ASN1ObjectIdentifier("1.3.6.1.4.1.22112.2.1");
    }
}
