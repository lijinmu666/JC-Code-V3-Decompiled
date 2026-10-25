package org.bouncycastle.p300oer.p301its.template.ieee1609dot2;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.ElementSupplier;
import org.bouncycastle.p300oer.InterfaceC5893Switch;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.SwitchIndexer;
import org.bouncycastle.p300oer.p301its.template.etsi103097.extension.EtsiTs103097ExtensionModule;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class IEEE1609dot2 {
    public static final OERDefinition.C5888Builder AesCcmCiphertext;
    public static final OERDefinition.C5888Builder Certificate;
    public static final OERDefinition.C5888Builder CertificateBase;
    public static final OERDefinition.C5888Builder CertificateId;
    public static final OERDefinition.C5888Builder CertificateType;
    public static final OERDefinition.C5888Builder ContributedExtensionBlock;
    public static final InterfaceC5893Switch ContributedExtensionBlockSwitch;
    public static final OERDefinition.C5888Builder ContributedExtensionBlocks;
    public static final OERDefinition.C5888Builder CounterSignature;
    public static final OERDefinition.C5888Builder EncryptedData;
    public static final OERDefinition.C5888Builder EncryptedDataEncryptionKey;
    public static final OERDefinition.C5888Builder EndEntityType;
    public static final OERDefinition.C5888Builder ExplicitCertificate;
    public static final OERDefinition.C5888Builder HashedData;
    public static final OERDefinition.C5888Builder HeaderInfo;
    public static final OERDefinition.C5888Builder HeaderInfoContributorId;
    public static final OERDefinition.C5888Builder Ieee1609Dot2Content;
    public static final OERDefinition.C5888Builder Ieee1609Dot2Data;
    public static final OERDefinition.C5888Builder ImplicitCertificate;
    public static final OERDefinition.C5888Builder IssuerIdentifier;
    public static final OERDefinition.C5888Builder LinkageData;
    public static final OERDefinition.C5888Builder MissingCrlIdentifier;

    /* renamed from: Opaque */
    public static final OERDefinition.C5888Builder f22806Opaque;
    public static final OERDefinition.C5888Builder PKRecipientInfo;
    public static final OERDefinition.C5888Builder PduFunctionalType;
    public static final OERDefinition.C5888Builder PreSharedKeyRecipientInfo;
    public static final OERDefinition.C5888Builder PsidGroupPermissions;
    public static final OERDefinition.C5888Builder RecipientInfo;
    public static final OERDefinition.C5888Builder SequenceOfCertificate;
    public static final OERDefinition.C5888Builder SequenceOfPsidGroupPermissions;
    public static final OERDefinition.C5888Builder SequenceOfRecipientInfo;
    public static final OERDefinition.C5888Builder SignedData;
    public static final OERDefinition.C5888Builder SignedDataPayload;
    public static final OERDefinition.C5888Builder SignerIdentifier;
    public static final OERDefinition.C5888Builder SubjectPermissions;
    public static final OERDefinition.C5888Builder SymmRecipientInfo;
    public static final OERDefinition.C5888Builder SymmetricCiphertext;
    public static final OERDefinition.C5888Builder ToBeSignedCertificate;
    public static final OERDefinition.C5888Builder ToBeSignedData;
    public static final OERDefinition.C5888Builder VerificationKeyIndicator;
    private static final ASN1Integer etsiHeaderInfoContributorId;
    private static ASN1Integer explicitOrdinal;
    private static final ASN1Encodable[] extensionBlockSwitchKeys;
    private static ASN1Integer implicitOrdinal;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.m17134octets().typeName("Opaque");
        f22806Opaque = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17131integer(0L, 255L).typeName("PduFunctionalType");
        PduFunctionalType = c5888BuilderTypeName2;
        OERDefinition.C5888Builder c5888BuilderTypeName3 = OERDefinition.m17128choice(OERDefinition.m17135octets(32).mo17150label("sha256HashedData"), OERDefinition.extension(OERDefinition.m17135octets(48).mo17150label("sha384HashedData"), OERDefinition.m17135octets(32).mo17150label("reserved"))).typeName("HashedData");
        HashedData = c5888BuilderTypeName3;
        OERDefinition.C5888Builder c5888Builder = Ieee1609Dot2BaseTypes.HashedId3;
        OERDefinition.C5888Builder c5888BuilderMo17150label = c5888Builder.mo17150label("cracaId");
        OERDefinition.C5888Builder c5888Builder2 = Ieee1609Dot2BaseTypes.CrlSeries;
        OERDefinition.C5888Builder c5888BuilderTypeName4 = OERDefinition.m17139seq(c5888BuilderMo17150label, c5888Builder2.mo17150label("crlSeries"), OERDefinition.extension(new Object[0])).typeName("MissingCrlIdentifier");
        MissingCrlIdentifier = c5888BuilderTypeName4;
        ASN1Integer aSN1Integer = new ASN1Integer(BigIntegers.f24191TWO);
        etsiHeaderInfoContributorId = aSN1Integer;
        extensionBlockSwitchKeys = new ASN1Encodable[]{aSN1Integer};
        OERDefinition.C5888Builder c5888BuilderValidSwitchValue = OERDefinition.m17131integer(0L, 255L).typeName("HeaderInfoContributorId").validSwitchValue(aSN1Integer);
        HeaderInfoContributorId = c5888BuilderValidSwitchValue;
        InterfaceC5893Switch interfaceC5893Switch = new InterfaceC5893Switch() { // from class: org.bouncycastle.oer.its.template.ieee1609dot2.IEEE1609dot2.1
            @Override // org.bouncycastle.p300oer.InterfaceC5893Switch
            /* renamed from: keys */
            public ASN1Encodable[] mo17169keys() {
                return IEEE1609dot2.extensionBlockSwitchKeys;
            }

            @Override // org.bouncycastle.p300oer.InterfaceC5893Switch
            /* renamed from: result */
            public C5887Element mo17170result(SwitchIndexer switchIndexer) {
                ASN1Integer aSN1Integer2 = ASN1Integer.getInstance(switchIndexer.mo17171get(0).toASN1Primitive());
                if (aSN1Integer2.m14446equals((ASN1Primitive) IEEE1609dot2.etsiHeaderInfoContributorId)) {
                    return OERDefinition.m17140seqof(EtsiTs103097ExtensionModule.EtsiOriginatingHeaderInfoExtension).rangeToMAXFrom(1L).mo17150label("extns").m17146build();
                }
                throw new IllegalArgumentException("No forward definition for type id " + aSN1Integer2);
            }
        };
        ContributedExtensionBlockSwitch = interfaceC5893Switch;
        OERDefinition.C5888Builder c5888BuilderTypeName5 = OERDefinition.m17139seq(c5888BuilderValidSwitchValue.mo17150label("contributorId"), OERDefinition.m17126aSwitch(interfaceC5893Switch).mo17150label("Extn")).typeName("ContributedExtensionBlock");
        ContributedExtensionBlock = c5888BuilderTypeName5;
        OERDefinition.C5888Builder c5888BuilderTypeName6 = OERDefinition.m17140seqof(c5888BuilderTypeName5).rangeToMAXFrom(1L).typeName("ContributedExtensionBlocks");
        ContributedExtensionBlocks = c5888BuilderTypeName6;
        OERDefinition.C5888Builder c5888Builder3 = Ieee1609Dot2BaseTypes.HashedId8;
        OERDefinition.C5888Builder c5888BuilderTypeName7 = c5888Builder3.typeName("PreSharedKeyRecipientInfo");
        PreSharedKeyRecipientInfo = c5888BuilderTypeName7;
        OERDefinition.C5888Builder c5888Builder4 = Ieee1609Dot2BaseTypes.EciesP256EncryptedKey;
        OERDefinition.C5888Builder c5888BuilderTypeName8 = OERDefinition.m17128choice(c5888Builder4.mo17150label("eciesNistP256"), c5888Builder4.mo17150label("eciesBrainpoolP256r1"), OERDefinition.extension(new Object[0])).typeName("EncryptedDataEncryptionKey");
        EncryptedDataEncryptionKey = c5888BuilderTypeName8;
        OERDefinition.C5888Builder c5888BuilderTypeName9 = OERDefinition.m17139seq(c5888Builder3.mo17150label("recipientId"), c5888BuilderTypeName8.mo17150label("encKey")).typeName("PKRecipientInfo");
        PKRecipientInfo = c5888BuilderTypeName9;
        OERDefinition.C5888Builder c5888BuilderTypeName10 = OERDefinition.m17139seq(OERDefinition.m17135octets(12).mo17150label("nonce"), c5888BuilderTypeName.mo17150label("ccmCiphertext")).typeName("AesCcmCiphertext");
        AesCcmCiphertext = c5888BuilderTypeName10;
        OERDefinition.C5888Builder c5888BuilderTypeName11 = OERDefinition.m17128choice(c5888BuilderTypeName10.mo17150label("aes128ccm"), OERDefinition.extension(new Object[0])).typeName("SymmetricCiphertext");
        SymmetricCiphertext = c5888BuilderTypeName11;
        OERDefinition.C5888Builder c5888BuilderTypeName12 = OERDefinition.m17139seq(c5888Builder3.mo17150label("recipientId"), c5888BuilderTypeName11.mo17150label("encKey")).typeName("SymmRecipientInfo");
        SymmRecipientInfo = c5888BuilderTypeName12;
        OERDefinition.C5888Builder c5888BuilderTypeName13 = OERDefinition.m17128choice(c5888BuilderTypeName7.mo17150label("pskRecipInfo"), c5888BuilderTypeName12.mo17150label("symmRecipInfo"), c5888BuilderTypeName9.mo17150label("certRecipInfo"), c5888BuilderTypeName9.mo17150label("signedDataRecipInfo"), c5888BuilderTypeName9.mo17150label("rekRecipInfo")).typeName("RecipientInfo");
        RecipientInfo = c5888BuilderTypeName13;
        OERDefinition.C5888Builder c5888BuilderTypeName14 = OERDefinition.m17140seqof(c5888BuilderTypeName13).typeName("SequenceOfRecipientInfo");
        SequenceOfRecipientInfo = c5888BuilderTypeName14;
        OERDefinition.C5888Builder c5888BuilderTypeName15 = OERDefinition.m17139seq(c5888BuilderTypeName14.mo17150label("recipients"), c5888BuilderTypeName11.mo17150label("ciphertext")).typeName("EncryptedData");
        EncryptedData = c5888BuilderTypeName15;
        OERDefinition.C5888Builder c5888BuilderTypeName16 = OERDefinition.bitString(8L).defaultValue(new DERBitString(128)).typeName("EndEntityType");
        EndEntityType = c5888BuilderTypeName16;
        OERDefinition.C5888Builder c5888BuilderTypeName17 = OERDefinition.m17128choice(Ieee1609Dot2BaseTypes.SequenceOfPsidSspRange.mo17150label("explicit"), OERDefinition.nullValue().mo17150label("all"), OERDefinition.extension(new Object[0])).typeName("SubjectPermissions");
        SubjectPermissions = c5888BuilderTypeName17;
        OERDefinition.C5888Builder c5888BuilderTypeName18 = OERDefinition.m17128choice(Ieee1609Dot2BaseTypes.PublicVerificationKey.mo17150label("verificationKey"), Ieee1609Dot2BaseTypes.EccP256CurvePoint.mo17150label("reconstructionValue"), OERDefinition.extension(new Object[0])).typeName("VerificationKeyIndicator");
        VerificationKeyIndicator = c5888BuilderTypeName18;
        OERDefinition.C5888Builder c5888BuilderTypeName19 = OERDefinition.m17139seq(c5888BuilderTypeName17.mo17150label("subjectPermissions"), OERDefinition.m17130integer(1L).mo17150label("minChainLength"), OERDefinition.m17130integer(0L).mo17150label("chainLengthRange"), c5888BuilderTypeName16.mo17150label("eeType")).typeName("PsidGroupPermissions");
        PsidGroupPermissions = c5888BuilderTypeName19;
        OERDefinition.C5888Builder c5888BuilderTypeName20 = OERDefinition.m17140seqof(c5888BuilderTypeName19).typeName("SequenceOfPsidGroupPermissions");
        SequenceOfPsidGroupPermissions = c5888BuilderTypeName20;
        OERDefinition.C5888Builder c5888BuilderTypeName21 = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.f22809IValue.mo17150label("iCert"), Ieee1609Dot2BaseTypes.LinkageValue.mo17150label("linkageValue"), OERDefinition.optional(Ieee1609Dot2BaseTypes.GroupLinkageValue.mo17150label("groupLinkageValue")), OERDefinition.extension(new Object[0])).typeName("LinkageData");
        LinkageData = c5888BuilderTypeName21;
        OERDefinition.C5888Builder c5888BuilderTypeName22 = OERDefinition.m17128choice(c5888BuilderTypeName21.mo17150label("linkageData"), Ieee1609Dot2BaseTypes.Hostname.mo17150label("name"), OERDefinition.m17136octets(1, 64).mo17150label("binaryId"), OERDefinition.nullValue().mo17150label("none"), OERDefinition.extension(new Object[0])).typeName("CertificateId");
        CertificateId = c5888BuilderTypeName22;
        OERDefinition.C5888Builder c5888BuilderTypeName23 = OERDefinition.m17139seq(c5888BuilderTypeName22.mo17150label("id"), c5888Builder.mo17150label("cracaId"), c5888Builder2.mo17150label("crlSeries"), Ieee1609Dot2BaseTypes.ValidityPeriod.mo17150label("validityPeriod"), OERDefinition.optional(Ieee1609Dot2BaseTypes.GeographicRegion.mo17150label("region"), Ieee1609Dot2BaseTypes.SubjectAssurance.mo17150label("assuranceLevel"), Ieee1609Dot2BaseTypes.SequenceOfPsidSsp.mo17150label("appPermissions"), c5888BuilderTypeName20.mo17150label("certIssuePermissions"), c5888BuilderTypeName20.mo17150label("certRequestPermissions"), OERDefinition.nullValue().mo17150label("canRequestRollover"), Ieee1609Dot2BaseTypes.PublicEncryptionKey.mo17150label("encryptionKey")), c5888BuilderTypeName18.mo17150label("verifyKeyIndicator"), OERDefinition.extension(new Object[0])).typeName("ToBeSignedCertificate");
        ToBeSignedCertificate = c5888BuilderTypeName23;
        OERDefinition.C5888Builder c5888BuilderMo17150label2 = c5888Builder3.mo17150label("sha256AndDigest");
        OERDefinition.C5888Builder c5888Builder5 = Ieee1609Dot2BaseTypes.HashAlgorithm;
        OERDefinition.C5888Builder c5888BuilderTypeName24 = OERDefinition.m17128choice(c5888BuilderMo17150label2, c5888Builder5.mo17150label("self"), OERDefinition.extension(c5888Builder3.mo17150label("sha384AndDigest"))).typeName("IssuerIdentifier");
        IssuerIdentifier = c5888BuilderTypeName24;
        OERDefinition.C5888Builder c5888BuilderTypeName25 = OERDefinition.enumeration(OERDefinition.enumItem("explicit"), OERDefinition.enumItem("implicit"), OERDefinition.extension(new Object[0])).typeName("CertificateType");
        CertificateType = c5888BuilderTypeName25;
        explicitOrdinal = new ASN1Integer(BigInteger.ZERO);
        implicitOrdinal = new ASN1Integer(BigInteger.ONE);
        OERDefinition.C5888Builder c5888Builder6 = Ieee1609Dot2BaseTypes.f22819UINT8;
        OERDefinition.C5888Builder c5888BuilderMo17150label3 = c5888Builder6.mo17150label("version");
        OERDefinition.C5888Builder c5888BuilderMo17150label4 = c5888BuilderTypeName25.mo17150label("type");
        OERDefinition.C5888Builder c5888BuilderMo17150label5 = c5888BuilderTypeName24.mo17150label("issuer");
        OERDefinition.C5888Builder c5888BuilderMo17150label6 = c5888BuilderTypeName23.mo17150label("toBeSigned");
        OERDefinition.C5888Builder c5888Builder7 = Ieee1609Dot2BaseTypes.Signature;
        OERDefinition.C5888Builder c5888BuilderTypeName26 = OERDefinition.m17139seq(c5888BuilderMo17150label3, c5888BuilderMo17150label4, c5888BuilderMo17150label5, c5888BuilderMo17150label6, OERDefinition.optional(c5888Builder7.mo17150label("signature"))).mo17150label("signature").typeName("CertificateBase");
        CertificateBase = c5888BuilderTypeName26;
        OERDefinition.C5888Builder c5888BuilderTypeName27 = c5888BuilderTypeName26.m17147copy().typeName("Certificate");
        Certificate = c5888BuilderTypeName27;
        ExplicitCertificate = c5888BuilderTypeName26.typeName("ExplicitCertificate").replaceChild(1, c5888BuilderTypeName25.validSwitchValue(explicitOrdinal).mo17150label("type"));
        ImplicitCertificate = c5888BuilderTypeName26.typeName("ImplicitCertificate").replaceChild(1, c5888BuilderTypeName25.validSwitchValue(implicitOrdinal).mo17150label("type"));
        OERDefinition.C5888Builder c5888BuilderTypeName28 = OERDefinition.m17140seqof(c5888BuilderTypeName27).typeName("SequenceOfCertificate");
        SequenceOfCertificate = c5888BuilderTypeName28;
        OERDefinition.C5888Builder c5888BuilderTypeName29 = OERDefinition.m17128choice(c5888Builder3.mo17150label(CMSAttributeTableGenerator.f18937DIGEST), c5888BuilderTypeName28.mo17150label("certificate"), OERDefinition.nullValue().mo17150label("self"), OERDefinition.extension(new Object[0])).typeName("SignerIdentifier");
        SignerIdentifier = c5888BuilderTypeName29;
        OERDefinition.C5888Builder c5888BuilderMo17150label7 = Ieee1609Dot2BaseTypes.f22811Psid.mo17150label("psid");
        OERDefinition.C5888Builder c5888Builder8 = Ieee1609Dot2BaseTypes.f22814Time64;
        OERDefinition.C5888Builder c5888BuilderTypeName30 = OERDefinition.m17139seq(c5888BuilderMo17150label7, OERDefinition.optional(c5888Builder8.mo17150label("generationTime"), c5888Builder8.mo17150label("expiryTime"), Ieee1609Dot2BaseTypes.ThreeDLocation.mo17150label("generationLocation"), c5888Builder.mo17150label("p2pcdLearningRequest"), c5888BuilderTypeName4.mo17150label("missingCrlIdentifier"), Ieee1609Dot2BaseTypes.EncryptionKey.mo17150label("encryptionKey")), OERDefinition.extension(OERDefinition.optional(Ieee1609Dot2BaseTypes.SequenceOfHashedId3.mo17150label("inlineP2pcdRequest"), c5888BuilderTypeName27.mo17150label("requestedCertificate"), c5888BuilderTypeName2.mo17150label("pduFunctionalType"), c5888BuilderTypeName6.mo17150label("contributedExtensions")))).typeName("HeaderInfo");
        HeaderInfo = c5888BuilderTypeName30;
        SignedData = OERDefinition.m17139seq(c5888Builder5.mo17150label("hashId"), OERDefinition.deferred(new ElementSupplier() { // from class: org.bouncycastle.oer.its.template.ieee1609dot2.IEEE1609dot2.2

            /* renamed from: built */
            private C5887Element f22807built;

            @Override // org.bouncycastle.p300oer.ElementSupplier
            /* renamed from: build */
            public C5887Element mo17122build() {
                C5887Element c5887Element;
                synchronized (this) {
                    try {
                        if (this.f22807built == null) {
                            this.f22807built = IEEE1609dot2.ToBeSignedData.mo17150label("tbsData").m17146build();
                        }
                        c5887Element = this.f22807built;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c5887Element;
            }
        }).mo17150label("tbsData"), c5888BuilderTypeName29.mo17150label("signer"), c5888Builder7.mo17150label("signature")).typeName("SignedData");
        OERDefinition.C5888Builder c5888BuilderTypeName31 = OERDefinition.m17128choice(c5888BuilderTypeName.mo17150label("unsecuredData"), OERDefinition.deferred(new ElementSupplier() { // from class: org.bouncycastle.oer.its.template.ieee1609dot2.IEEE1609dot2.3

            /* renamed from: built */
            private C5887Element f22808built;

            @Override // org.bouncycastle.p300oer.ElementSupplier
            /* renamed from: build */
            public C5887Element mo17122build() {
                C5887Element c5887Element;
                synchronized (this) {
                    try {
                        if (this.f22808built == null) {
                            this.f22808built = IEEE1609dot2.SignedData.mo17150label("signedData").mayRecurse(true).m17146build();
                        }
                        c5887Element = this.f22808built;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c5887Element;
            }
        }).mo17150label("signedData").mayRecurse(true), c5888BuilderTypeName15.mo17150label("encryptedData"), c5888BuilderTypeName.mo17150label("signedCertificateRequest"), OERDefinition.extension(new Object[0])).typeName("Ieee1609Dot2Content");
        Ieee1609Dot2Content = c5888BuilderTypeName31;
        CounterSignature = OERDefinition.m17139seq(c5888Builder6.mo17150label("protocolVersion"), c5888BuilderTypeName31.mo17150label("content")).typeName("CounterSignature");
        OERDefinition.C5888Builder c5888BuilderTypeName32 = OERDefinition.m17139seq(c5888Builder6.validSwitchValue(ASN1Integer.f17919THREE).mo17150label("protocolVersion"), c5888BuilderTypeName31.mo17150label("content")).typeName("Ieee1609Dot2Data");
        Ieee1609Dot2Data = c5888BuilderTypeName32;
        OERDefinition.C5888Builder c5888BuilderTypeName33 = OERDefinition.m17139seq(OERDefinition.optional(c5888BuilderTypeName32.mo17150label("data"), c5888BuilderTypeName3.mo17150label("extDataHash")), OERDefinition.extension(new Object[0])).typeName("SignedDataPayload");
        SignedDataPayload = c5888BuilderTypeName33;
        ToBeSignedData = OERDefinition.m17139seq(c5888BuilderTypeName33.mo17150label("payload"), c5888BuilderTypeName30.mo17150label("headerInfo")).typeName("ToBeSignedData");
    }
}
