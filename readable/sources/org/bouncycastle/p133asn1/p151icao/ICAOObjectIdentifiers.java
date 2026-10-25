package org.bouncycastle.p133asn1.p151icao;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface ICAOObjectIdentifiers {

    /* renamed from: id_icao */
    public static final ASN1ObjectIdentifier f18405id_icao;
    public static final ASN1ObjectIdentifier id_icao_aaProtocolObject;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterList;
    public static final ASN1ObjectIdentifier id_icao_cscaMasterListSigningKey;
    public static final ASN1ObjectIdentifier id_icao_documentTypeList;
    public static final ASN1ObjectIdentifier id_icao_extensions;
    public static final ASN1ObjectIdentifier id_icao_extensions_namechangekeyrollover;
    public static final ASN1ObjectIdentifier id_icao_ldsSecurityObject;
    public static final ASN1ObjectIdentifier id_icao_mrtd;
    public static final ASN1ObjectIdentifier id_icao_mrtd_security;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.23.136");
        f18405id_icao = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1");
        id_icao_mrtd = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_icao_mrtd_security = aSN1ObjectIdentifierM14432branch2;
        id_icao_ldsSecurityObject = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        id_icao_cscaMasterList = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        id_icao_cscaMasterListSigningKey = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_icao_documentTypeList = aSN1ObjectIdentifierM14432branch2.m14432branch("4");
        id_icao_aaProtocolObject = aSN1ObjectIdentifierM14432branch2.m14432branch("5");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14432branch2.m14432branch("6");
        id_icao_extensions = aSN1ObjectIdentifierM14432branch3;
        id_icao_extensions_namechangekeyrollover = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
    }
}
