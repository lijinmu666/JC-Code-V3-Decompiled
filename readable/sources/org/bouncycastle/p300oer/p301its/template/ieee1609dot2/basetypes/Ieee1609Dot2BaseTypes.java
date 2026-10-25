package org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p300oer.OERDefinition;

/* loaded from: classes2.dex */
public class Ieee1609Dot2BaseTypes {
    public static final OERDefinition.C5888Builder BasePublicEncryptionKey;
    public static final OERDefinition.C5888Builder BitmapSsp;
    public static final OERDefinition.C5888Builder BitmapSspRange;
    public static final OERDefinition.C5888Builder CircularRegion;
    public static final OERDefinition.C5888Builder CountryAndRegions;
    public static final OERDefinition.C5888Builder CountryAndSubregions;
    public static final OERDefinition.C5888Builder CountryOnly;
    public static final OERDefinition.C5888Builder CrlSeries;
    public static final OERDefinition.C5888Builder Duration;
    public static final OERDefinition.C5888Builder EccP256CurvePoint;
    public static final OERDefinition.C5888Builder EccP384CurvePoint;
    public static final OERDefinition.C5888Builder EcdsaP256Signature;
    public static final OERDefinition.C5888Builder EcdsaP384Signature;
    public static final OERDefinition.C5888Builder EciesP256EncryptedKey;
    public static final OERDefinition.C5888Builder Elevation;
    public static final OERDefinition.C5888Builder EncryptionKey;
    public static final OERDefinition.C5888Builder GeographicRegion;
    public static final OERDefinition.C5888Builder GroupLinkageValue;
    public static final OERDefinition.C5888Builder HashAlgorithm;
    public static final OERDefinition.C5888Builder HashedId10;
    public static final OERDefinition.C5888Builder HashedId3;
    public static final OERDefinition.C5888Builder HashedId32;
    public static final OERDefinition.C5888Builder HashedId8;
    public static final OERDefinition.C5888Builder Hostname;

    /* renamed from: IValue */
    public static final OERDefinition.C5888Builder f22809IValue;
    public static final OERDefinition.C5888Builder IdentifiedRegion;
    public static final OERDefinition.C5888Builder KnownLatitude;
    public static final OERDefinition.C5888Builder KnownLongitude;

    /* renamed from: LaId */
    public static final OERDefinition.C5888Builder f22810LaId;
    public static final OERDefinition.C5888Builder Latitude;
    public static final OERDefinition.C5888Builder LinkageSeed;
    public static final OERDefinition.C5888Builder LinkageValue;
    public static final OERDefinition.C5888Builder Longitude;
    public static final OERDefinition.C5888Builder NinetyDegreeInt;
    public static final OERDefinition.C5888Builder OneEightyDegreeInt;
    public static final OERDefinition.C5888Builder Point256;
    public static final OERDefinition.C5888Builder Point384;
    public static final OERDefinition.C5888Builder PolygonalRegion;

    /* renamed from: Psid */
    public static final OERDefinition.C5888Builder f22811Psid;

    /* renamed from: PsidSsp */
    public static final OERDefinition.C5888Builder f22812PsidSsp;
    public static final OERDefinition.C5888Builder PsidSspRange;
    public static final OERDefinition.C5888Builder PublicEncryptionKey;
    public static final OERDefinition.C5888Builder PublicVerificationKey;
    public static final OERDefinition.C5888Builder RectangularRegion;
    public static final OERDefinition.C5888Builder RegionAndSubregions;
    public static final OERDefinition.C5888Builder SequenceOfHashedId3;
    public static final OERDefinition.C5888Builder SequenceOfHashedId8;
    public static final OERDefinition.C5888Builder SequenceOfIdentifiedRegion;
    public static final OERDefinition.C5888Builder SequenceOfOctetString;
    public static final OERDefinition.C5888Builder SequenceOfPsid;
    public static final OERDefinition.C5888Builder SequenceOfPsidSsp;
    public static final OERDefinition.C5888Builder SequenceOfPsidSspRange;
    public static final OERDefinition.C5888Builder SequenceOfRectangularRegion;
    public static final OERDefinition.C5888Builder SequenceOfRegionAndSubregions;
    public static final OERDefinition.C5888Builder SequenceOfUint16;
    public static final OERDefinition.C5888Builder SequenceOfUint8;
    public static final OERDefinition.C5888Builder ServiceSpecificPermissions;
    public static final OERDefinition.C5888Builder Signature;
    public static final OERDefinition.C5888Builder SspRange;
    public static final OERDefinition.C5888Builder SubjectAssurance;
    public static final OERDefinition.C5888Builder SymmAlgorithm;
    public static final OERDefinition.C5888Builder SymmetricEncryptionKey;
    public static final OERDefinition.C5888Builder ThreeDLocation;

    /* renamed from: Time32 */
    public static final OERDefinition.C5888Builder f22813Time32;

    /* renamed from: Time64 */
    public static final OERDefinition.C5888Builder f22814Time64;
    public static final OERDefinition.C5888Builder TwoDLocation;

    /* renamed from: UINT16 */
    public static final OERDefinition.C5888Builder f22815UINT16;

    /* renamed from: UINT3 */
    public static final OERDefinition.C5888Builder f22816UINT3 = OERDefinition.m17131integer(0, 7).typeName("UINT3");

    /* renamed from: UINT32 */
    public static final OERDefinition.C5888Builder f22817UINT32;

    /* renamed from: UINT64 */
    public static final OERDefinition.C5888Builder f22818UINT64;

    /* renamed from: UINT8 */
    public static final OERDefinition.C5888Builder f22819UINT8;
    public static final OERDefinition.C5888Builder UnknownLatitude;
    public static final OERDefinition.C5888Builder UnknownLongitude;
    public static final OERDefinition.C5888Builder ValidityPeriod;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.m17131integer(0L, 255L).typeName("UINT8");
        f22819UINT8 = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17131integer(0L, 65535L).typeName("UINT16");
        f22815UINT16 = c5888BuilderTypeName2;
        OERDefinition.C5888Builder c5888BuilderTypeName3 = OERDefinition.m17131integer(0L, BodyPartID.bodyIdMax).typeName("UINT32");
        f22817UINT32 = c5888BuilderTypeName3;
        OERDefinition.C5888Builder c5888BuilderTypeName4 = OERDefinition.m17133integer(BigInteger.ZERO, new BigInteger("18446744073709551615")).typeName("UINT64");
        f22818UINT64 = c5888BuilderTypeName4;
        OERDefinition.C5888Builder c5888BuilderTypeName5 = OERDefinition.m17140seqof(c5888BuilderTypeName2).typeName("SequenceOfUint16");
        SequenceOfUint16 = c5888BuilderTypeName5;
        OERDefinition.C5888Builder c5888BuilderTypeName6 = OERDefinition.m17140seqof(c5888BuilderTypeName).typeName("SequenceOfUint8");
        SequenceOfUint8 = c5888BuilderTypeName6;
        OERDefinition.C5888Builder c5888BuilderTypeName7 = OERDefinition.m17135octets(3).typeName("HashedId3");
        HashedId3 = c5888BuilderTypeName7;
        OERDefinition.C5888Builder c5888BuilderTypeName8 = OERDefinition.m17135octets(8).typeName("HashedId8");
        HashedId8 = c5888BuilderTypeName8;
        HashedId10 = OERDefinition.m17135octets(10).typeName("HashedId10");
        HashedId32 = OERDefinition.m17135octets(32).typeName("HashedId32");
        SequenceOfHashedId3 = OERDefinition.m17140seqof(c5888BuilderTypeName7).typeName("SequenceOfHashedId3");
        SequenceOfHashedId8 = OERDefinition.m17140seqof(c5888BuilderTypeName8).typeName("SequenceOfHashedId8");
        OERDefinition.C5888Builder c5888BuilderTypeName9 = c5888BuilderTypeName3.typeName("Time32");
        f22813Time32 = c5888BuilderTypeName9;
        f22814Time64 = c5888BuilderTypeName4.typeName("Time64");
        OERDefinition.C5888Builder c5888BuilderTypeName10 = OERDefinition.m17128choice(c5888BuilderTypeName2.mo17150label("microseconds"), c5888BuilderTypeName2.mo17150label("milliseconds"), c5888BuilderTypeName2.mo17150label("seconds"), c5888BuilderTypeName2.mo17150label("minutes"), c5888BuilderTypeName2.mo17150label("hours"), c5888BuilderTypeName2.mo17150label("sixtyHours"), c5888BuilderTypeName2.mo17150label("years")).typeName("Duration");
        Duration = c5888BuilderTypeName10;
        ValidityPeriod = OERDefinition.m17139seq(c5888BuilderTypeName9.mo17150label("start"), c5888BuilderTypeName10.mo17150label("duration")).typeName("ValidityPeriod");
        f22809IValue = c5888BuilderTypeName2.m17147copy().typeName("IValue");
        Hostname = OERDefinition.utf8String(0, 255).typeName("Hostname");
        LinkageValue = OERDefinition.m17135octets(9).typeName("LinkageValue");
        GroupLinkageValue = OERDefinition.m17139seq(OERDefinition.m17135octets(4).mo17150label("jValue"), OERDefinition.m17135octets(9).mo17150label("value")).typeName("GroupLinkageValue");
        f22810LaId = OERDefinition.m17135octets(2).typeName("LaId");
        LinkageSeed = OERDefinition.m17135octets(16).typeName("LinkageSeed");
        OERDefinition.C5888Builder c5888BuilderTypeName11 = OERDefinition.m17139seq(OERDefinition.m17135octets(32).mo17150label("x"), OERDefinition.m17135octets(32).mo17150label("y")).typeName("Point256");
        Point256 = c5888BuilderTypeName11;
        OERDefinition.C5888Builder c5888BuilderTypeName12 = OERDefinition.m17128choice(OERDefinition.m17135octets(32).mo17150label("x-only"), OERDefinition.nullValue().mo17150label("fill"), OERDefinition.m17135octets(32).mo17150label("compressed-y-0"), OERDefinition.m17135octets(32).mo17150label("compressed-y-1"), c5888BuilderTypeName11.mo17150label("uncompressedP256")).typeName("EccP256CurvePoint");
        EccP256CurvePoint = c5888BuilderTypeName12;
        OERDefinition.C5888Builder c5888BuilderTypeName13 = OERDefinition.m17139seq(c5888BuilderTypeName12.mo17150label("rSig"), OERDefinition.m17135octets(32).mo17150label("sSig")).typeName("EcdsaP256Signature");
        EcdsaP256Signature = c5888BuilderTypeName13;
        OERDefinition.C5888Builder c5888BuilderTypeName14 = OERDefinition.m17139seq(OERDefinition.m17135octets(48).mo17150label("x"), OERDefinition.m17135octets(48).mo17150label("y")).typeName("Point384");
        Point384 = c5888BuilderTypeName14;
        OERDefinition.C5888Builder c5888BuilderTypeName15 = OERDefinition.m17128choice(OERDefinition.m17135octets(48).mo17150label("x-only"), OERDefinition.nullValue().mo17150label("fill"), OERDefinition.m17135octets(48).mo17150label("compressed-y-0"), OERDefinition.m17135octets(48).mo17150label("compressed-y-1"), c5888BuilderTypeName14.mo17150label("uncompressedP384")).typeName("EccP384CurvePoint");
        EccP384CurvePoint = c5888BuilderTypeName15;
        OERDefinition.C5888Builder c5888BuilderTypeName16 = OERDefinition.m17139seq(c5888BuilderTypeName15.mo17150label("rSig"), OERDefinition.m17135octets(48).mo17150label("sSig")).typeName("EcdsaP384Signature");
        EcdsaP384Signature = c5888BuilderTypeName16;
        Signature = OERDefinition.m17128choice(c5888BuilderTypeName13.mo17150label("ecdsaNistP256Signature"), c5888BuilderTypeName13.mo17150label("ecdsaBrainpoolP256r1Signature"), OERDefinition.extension(c5888BuilderTypeName16.mo17150label("ecdsaBrainpoolP384r1Signature"))).typeName("Signature");
        OERDefinition.C5888Builder c5888BuilderTypeName17 = OERDefinition.enumeration(OERDefinition.enumItem("aes128Ccm"), OERDefinition.extension(new Object[0])).typeName("SymmAlgorithm");
        SymmAlgorithm = c5888BuilderTypeName17;
        HashAlgorithm = OERDefinition.enumeration(OERDefinition.enumItem("sha256"), OERDefinition.extension(OERDefinition.enumItem("sha384"))).typeName("HashAlgorithm");
        EciesP256EncryptedKey = OERDefinition.m17139seq(c5888BuilderTypeName12.m17147copy().mo17150label("v"), OERDefinition.m17135octets(16).mo17150label("c"), OERDefinition.m17135octets(16).mo17150label("t")).typeName("EciesP256EncryptedKey");
        OERDefinition.C5888Builder c5888BuilderTypeName18 = OERDefinition.m17128choice(c5888BuilderTypeName12.mo17150label("eciesNistP256"), c5888BuilderTypeName12.mo17150label("eciesBrainpoolP256r1"), OERDefinition.extension(new Object[0])).typeName("BasePublicEncryptionKey");
        BasePublicEncryptionKey = c5888BuilderTypeName18;
        OERDefinition.C5888Builder c5888BuilderTypeName19 = OERDefinition.m17128choice(OERDefinition.m17135octets(16).mo17150label("aes128Ccm"), OERDefinition.extension(new Object[0])).typeName("SymmetricEncryptionKey");
        SymmetricEncryptionKey = c5888BuilderTypeName19;
        OERDefinition.C5888Builder c5888BuilderTypeName20 = OERDefinition.m17139seq(c5888BuilderTypeName17.mo17150label("supportedSymmAlg"), c5888BuilderTypeName18.mo17150label("publicKey")).typeName("PublicEncryptionKey");
        PublicEncryptionKey = c5888BuilderTypeName20;
        EncryptionKey = OERDefinition.m17128choice(c5888BuilderTypeName20.mo17150label("publicOption"), c5888BuilderTypeName19.mo17150label("symmetric")).typeName("EncryptionKey");
        PublicVerificationKey = OERDefinition.m17128choice(c5888BuilderTypeName12.mo17150label("ecdsaNistP256"), c5888BuilderTypeName12.mo17150label("ecdsaBrainpoolP256r1"), OERDefinition.extension(c5888BuilderTypeName15.mo17150label("ecdsaBrainpoolP384r1"))).typeName("PublicVerificationKey");
        OERDefinition.C5888Builder c5888BuilderTypeName21 = OERDefinition.m17129integer().rangeToMAXFrom(0L).typeName("Psid");
        f22811Psid = c5888BuilderTypeName21;
        OERDefinition.C5888Builder c5888BuilderTypeName22 = OERDefinition.m17136octets(0, 31).typeName("BitmapSsp");
        BitmapSsp = c5888BuilderTypeName22;
        OERDefinition.C5888Builder c5888BuilderTypeName23 = OERDefinition.m17128choice(OERDefinition.m17134octets().unbounded().mo17150label("opaque"), OERDefinition.extension(c5888BuilderTypeName22)).typeName("ServiceSpecificPermissions");
        ServiceSpecificPermissions = c5888BuilderTypeName23;
        OERDefinition.C5888Builder c5888BuilderTypeName24 = OERDefinition.m17139seq(c5888BuilderTypeName21.mo17150label("psid"), OERDefinition.optional(c5888BuilderTypeName23.mo17150label("ssp"))).typeName("PsidSsp");
        f22812PsidSsp = c5888BuilderTypeName24;
        SequenceOfPsidSsp = OERDefinition.m17140seqof(c5888BuilderTypeName24).typeName("SequenceOfPsidSsp");
        SequenceOfPsid = OERDefinition.m17140seqof(c5888BuilderTypeName21).typeName("SequenceOfPsid");
        OERDefinition.C5888Builder c5888BuilderTypeName25 = OERDefinition.m17140seqof(OERDefinition.m17134octets().rangeToMAXFrom(0L)).typeName("SequenceOfOctetString");
        SequenceOfOctetString = c5888BuilderTypeName25;
        OERDefinition.C5888Builder c5888BuilderTypeName26 = OERDefinition.m17139seq(OERDefinition.m17136octets(1, 32).mo17150label("sspValue"), OERDefinition.m17136octets(1, 32).mo17150label("sspBitMask")).typeName("BitmapSspRange");
        BitmapSspRange = c5888BuilderTypeName26;
        OERDefinition.C5888Builder c5888BuilderTypeName27 = OERDefinition.m17128choice(c5888BuilderTypeName25.mo17150label("opaque"), OERDefinition.nullValue().mo17150label("all"), OERDefinition.extension(c5888BuilderTypeName26.mo17150label("bitmapSspRange"))).typeName("SspRange");
        SspRange = c5888BuilderTypeName27;
        OERDefinition.C5888Builder c5888BuilderTypeName28 = OERDefinition.m17139seq(c5888BuilderTypeName21.mo17150label("psid"), OERDefinition.optional(c5888BuilderTypeName27.mo17150label("sspRange"))).typeName("PsidSspRange");
        PsidSspRange = c5888BuilderTypeName28;
        SequenceOfPsidSspRange = OERDefinition.m17140seqof(c5888BuilderTypeName28).typeName("SequenceOfPsidSspRange");
        SubjectAssurance = OERDefinition.m17135octets(1).typeName("SubjectAssurance");
        CrlSeries = c5888BuilderTypeName2.typeName("CrlSeries");
        OERDefinition.C5888Builder c5888BuilderTypeName29 = c5888BuilderTypeName2.typeName("CountryOnly");
        CountryOnly = c5888BuilderTypeName29;
        OERDefinition.C5888Builder c5888BuilderTypeName30 = OERDefinition.m17139seq(c5888BuilderTypeName29.mo17150label("countryOnly"), c5888BuilderTypeName6.mo17150label("regions")).typeName("CountryAndRegions");
        CountryAndRegions = c5888BuilderTypeName30;
        OERDefinition.C5888Builder c5888BuilderTypeName31 = OERDefinition.m17139seq(c5888BuilderTypeName.mo17150label("region"), c5888BuilderTypeName5.mo17150label("subregions")).typeName("RegionAndSubregions");
        RegionAndSubregions = c5888BuilderTypeName31;
        OERDefinition.C5888Builder c5888BuilderTypeName32 = OERDefinition.m17140seqof(c5888BuilderTypeName31).typeName("SequenceOfRegionAndSubregions");
        SequenceOfRegionAndSubregions = c5888BuilderTypeName32;
        OERDefinition.C5888Builder c5888BuilderTypeName33 = OERDefinition.m17139seq(c5888BuilderTypeName29.mo17150label("country"), c5888BuilderTypeName32.mo17150label("regionAndSubregions")).typeName("CountryAndSubregions");
        CountryAndSubregions = c5888BuilderTypeName33;
        OERDefinition.C5888Builder c5888BuilderTypeName34 = OERDefinition.m17128choice(c5888BuilderTypeName29.mo17150label("countryOnly"), c5888BuilderTypeName30.mo17150label("countryAndRegions"), c5888BuilderTypeName33.mo17150label("countryAndSubregions"), OERDefinition.extension(new Object[0])).typeName("IdentifiedRegion");
        IdentifiedRegion = c5888BuilderTypeName34;
        OERDefinition.C5888Builder c5888BuilderTypeName35 = OERDefinition.m17140seqof(c5888BuilderTypeName34).typeName("SequenceOfIdentifiedRegion");
        SequenceOfIdentifiedRegion = c5888BuilderTypeName35;
        OERDefinition.C5888Builder c5888BuilderTypeName36 = OERDefinition.m17131integer(-1799999999L, 1800000001L).typeName("OneEightyDegreeInt");
        OneEightyDegreeInt = c5888BuilderTypeName36;
        KnownLongitude = c5888BuilderTypeName36.m17147copy().typeName("KnownLongitude");
        UnknownLongitude = OERDefinition.m17129integer().validSwitchValue(ASN1Integer.m14429valueOf(1800000001)).typeName("UnknownLongitude");
        OERDefinition.C5888Builder c5888BuilderTypeName37 = OERDefinition.m17131integer(-900000000L, 900000001L).typeName("NinetyDegreeInt");
        NinetyDegreeInt = c5888BuilderTypeName37;
        KnownLatitude = c5888BuilderTypeName37.m17147copy().typeName("KnownLatitude");
        UnknownLatitude = OERDefinition.m17129integer().validSwitchValue(ASN1Integer.m14429valueOf(900000001)).typeName("UnknownLatitude");
        OERDefinition.C5888Builder c5888BuilderTypeName38 = c5888BuilderTypeName2.typeName("Elevation");
        Elevation = c5888BuilderTypeName38;
        OERDefinition.C5888Builder c5888BuilderTypeName39 = c5888BuilderTypeName36.m17147copy().typeName("Longitude");
        Longitude = c5888BuilderTypeName39;
        OERDefinition.C5888Builder c5888BuilderTypeName40 = c5888BuilderTypeName37.m17147copy().typeName("Latitude");
        Latitude = c5888BuilderTypeName40;
        ThreeDLocation = OERDefinition.m17139seq(c5888BuilderTypeName40.mo17150label("latitude"), c5888BuilderTypeName39.mo17150label("longitude"), c5888BuilderTypeName38.mo17150label("elevation")).typeName("ThreeDLocation");
        OERDefinition.C5888Builder c5888BuilderTypeName41 = OERDefinition.m17139seq(c5888BuilderTypeName40.mo17150label("latitude"), c5888BuilderTypeName39.mo17150label("longitude")).typeName("TwoDLocation");
        TwoDLocation = c5888BuilderTypeName41;
        OERDefinition.C5888Builder c5888BuilderTypeName42 = OERDefinition.m17139seq(c5888BuilderTypeName41.mo17150label("northWest"), c5888BuilderTypeName41.mo17150label("southEast")).typeName("RectangularRegion");
        RectangularRegion = c5888BuilderTypeName42;
        OERDefinition.C5888Builder c5888BuilderTypeName43 = OERDefinition.m17140seqof(c5888BuilderTypeName42).typeName("SequenceOfRectangularRegion");
        SequenceOfRectangularRegion = c5888BuilderTypeName43;
        OERDefinition.C5888Builder c5888BuilderTypeName44 = OERDefinition.m17139seq(c5888BuilderTypeName41.mo17150label("center"), c5888BuilderTypeName2.mo17150label("radius")).typeName("CircularRegion");
        CircularRegion = c5888BuilderTypeName44;
        OERDefinition.C5888Builder c5888BuilderTypeName45 = OERDefinition.m17140seqof(c5888BuilderTypeName41).rangeToMAXFrom(3L).typeName("PolygonalRegion");
        PolygonalRegion = c5888BuilderTypeName45;
        GeographicRegion = OERDefinition.m17128choice(c5888BuilderTypeName44.mo17150label("circularRegion"), c5888BuilderTypeName43.mo17150label("rectangularRegion"), c5888BuilderTypeName45.mo17150label("polygonalRegion"), c5888BuilderTypeName35.mo17150label("identifiedRegion"), OERDefinition.extension(new Object[0])).typeName("GeographicRegion");
    }
}
