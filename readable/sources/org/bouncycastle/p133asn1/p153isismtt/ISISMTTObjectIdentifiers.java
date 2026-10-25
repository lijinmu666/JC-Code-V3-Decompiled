package org.bouncycastle.p133asn1.p153isismtt;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface ISISMTTObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_isismtt;
    public static final ASN1ObjectIdentifier id_isismtt_at;
    public static final ASN1ObjectIdentifier id_isismtt_at_PKReference;
    public static final ASN1ObjectIdentifier id_isismtt_at_additionalInformation;
    public static final ASN1ObjectIdentifier id_isismtt_at_admission;
    public static final ASN1ObjectIdentifier id_isismtt_at_certHash;
    public static final ASN1ObjectIdentifier id_isismtt_at_certInDirSince;
    public static final ASN1ObjectIdentifier id_isismtt_at_dateOfCertGen;
    public static final ASN1ObjectIdentifier id_isismtt_at_declarationOfMajority;
    public static final ASN1ObjectIdentifier id_isismtt_at_iCCSN;
    public static final ASN1ObjectIdentifier id_isismtt_at_liabilityLimitationFlag;
    public static final ASN1ObjectIdentifier id_isismtt_at_monetaryLimit;
    public static final ASN1ObjectIdentifier id_isismtt_at_nameAtBirth;
    public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities;
    public static final ASN1ObjectIdentifier id_isismtt_at_procuration;
    public static final ASN1ObjectIdentifier id_isismtt_at_requestedCertificate;
    public static final ASN1ObjectIdentifier id_isismtt_at_restriction;
    public static final ASN1ObjectIdentifier id_isismtt_at_retrieveIfAllowed;
    public static final ASN1ObjectIdentifier id_isismtt_cp;
    public static final ASN1ObjectIdentifier id_isismtt_cp_accredited;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.8");
        id_isismtt = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1");
        id_isismtt_cp = aSN1ObjectIdentifierM14432branch;
        id_isismtt_cp_accredited = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifier.m14432branch("3");
        id_isismtt_at = aSN1ObjectIdentifierM14432branch2;
        id_isismtt_at_dateOfCertGen = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        id_isismtt_at_procuration = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        id_isismtt_at_admission = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_isismtt_at_monetaryLimit = aSN1ObjectIdentifierM14432branch2.m14432branch("4");
        id_isismtt_at_declarationOfMajority = aSN1ObjectIdentifierM14432branch2.m14432branch("5");
        id_isismtt_at_iCCSN = aSN1ObjectIdentifierM14432branch2.m14432branch("6");
        id_isismtt_at_PKReference = aSN1ObjectIdentifierM14432branch2.m14432branch("7");
        id_isismtt_at_restriction = aSN1ObjectIdentifierM14432branch2.m14432branch("8");
        id_isismtt_at_retrieveIfAllowed = aSN1ObjectIdentifierM14432branch2.m14432branch("9");
        id_isismtt_at_requestedCertificate = aSN1ObjectIdentifierM14432branch2.m14432branch("10");
        id_isismtt_at_namingAuthorities = aSN1ObjectIdentifierM14432branch2.m14432branch("11");
        id_isismtt_at_certInDirSince = aSN1ObjectIdentifierM14432branch2.m14432branch("12");
        id_isismtt_at_certHash = aSN1ObjectIdentifierM14432branch2.m14432branch("13");
        id_isismtt_at_nameAtBirth = aSN1ObjectIdentifierM14432branch2.m14432branch("14");
        id_isismtt_at_additionalInformation = aSN1ObjectIdentifierM14432branch2.m14432branch("15");
        id_isismtt_at_liabilityLimitationFlag = new ASN1ObjectIdentifier("0.2.262.1.10.12.0");
    }
}
