package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.util.Iterator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5954Psid;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5970Time64;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId3;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfHashedId3;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.ThreeDLocation;

/* loaded from: classes2.dex */
public class HeaderInfo extends ASN1Object {
    private final ContributedExtensionBlocks contributedExtensions;
    private final EncryptionKey encryptionKey;
    private final C5970Time64 expiryTime;
    private final ThreeDLocation generationLocation;
    private final C5970Time64 generationTime;
    private final SequenceOfHashedId3 inlineP2pcdRequest;
    private final MissingCrlIdentifier missingCrlIdentifier;
    private final HashedId3 p2pcdLearningRequest;
    private final PduFunctionalType pduFunctionalType;

    /* renamed from: psid */
    private final C5954Psid f22643psid;
    private final Certificate requestedCertificate;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.HeaderInfo$Builder */
    public static class C5925Builder {
        private ContributedExtensionBlocks contributedExtensions;
        private EncryptionKey encryptionKey;
        private C5970Time64 expiryTime;
        private ThreeDLocation generationLocation;
        private C5970Time64 generationTime;
        private SequenceOfHashedId3 inlineP2pcdRequest;
        private MissingCrlIdentifier missingCrlIdentifier;
        private HashedId3 p2pcdLearningRequest;
        private PduFunctionalType pduFunctionalType;

        /* renamed from: psid */
        private C5954Psid f22644psid;
        private Certificate requestedCertificate;

        public HeaderInfo createHeaderInfo() {
            return new HeaderInfo(this.f22644psid, this.generationTime, this.expiryTime, this.generationLocation, this.p2pcdLearningRequest, this.missingCrlIdentifier, this.encryptionKey, this.inlineP2pcdRequest, this.requestedCertificate, this.pduFunctionalType, this.contributedExtensions);
        }

        public C5925Builder setContributedExtensions(ContributedExtensionBlocks contributedExtensionBlocks) {
            this.contributedExtensions = contributedExtensionBlocks;
            return this;
        }

        public C5925Builder setEncryptionKey(EncryptionKey encryptionKey) {
            this.encryptionKey = encryptionKey;
            return this;
        }

        public C5925Builder setExpiryTime(C5970Time64 c5970Time64) {
            this.expiryTime = c5970Time64;
            return this;
        }

        public C5925Builder setGenerationLocation(ThreeDLocation threeDLocation) {
            this.generationLocation = threeDLocation;
            return this;
        }

        public C5925Builder setGenerationTime(C5970Time64 c5970Time64) {
            this.generationTime = c5970Time64;
            return this;
        }

        public C5925Builder setInlineP2pcdRequest(SequenceOfHashedId3 sequenceOfHashedId3) {
            this.inlineP2pcdRequest = sequenceOfHashedId3;
            return this;
        }

        public C5925Builder setMissingCrlIdentifier(MissingCrlIdentifier missingCrlIdentifier) {
            this.missingCrlIdentifier = missingCrlIdentifier;
            return this;
        }

        public C5925Builder setP2pcdLearningRequest(HashedId3 hashedId3) {
            this.p2pcdLearningRequest = hashedId3;
            return this;
        }

        public C5925Builder setPduFunctionalType(PduFunctionalType pduFunctionalType) {
            this.pduFunctionalType = pduFunctionalType;
            return this;
        }

        /* renamed from: setPsid */
        public C5925Builder m17229setPsid(C5954Psid c5954Psid) {
            this.f22644psid = c5954Psid;
            return this;
        }

        public C5925Builder setRequestedCertificate(Certificate certificate) {
            this.requestedCertificate = certificate;
            return this;
        }
    }

    private HeaderInfo(ASN1Sequence aSN1Sequence) {
        ContributedExtensionBlocks contributedExtensionBlocks;
        if (aSN1Sequence.mo14450size() != 11 && aSN1Sequence.mo14450size() != 7) {
            throw new IllegalArgumentException("expected sequence size of 11 or 7");
        }
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        this.f22643psid = C5954Psid.getInstance(it.next());
        this.generationTime = (C5970Time64) OEROptional.getValue(C5970Time64.class, it.next());
        this.expiryTime = (C5970Time64) OEROptional.getValue(C5970Time64.class, it.next());
        this.generationLocation = (ThreeDLocation) OEROptional.getValue(ThreeDLocation.class, it.next());
        this.p2pcdLearningRequest = (HashedId3) OEROptional.getValue(HashedId3.class, it.next());
        this.missingCrlIdentifier = (MissingCrlIdentifier) OEROptional.getValue(MissingCrlIdentifier.class, it.next());
        this.encryptionKey = (EncryptionKey) OEROptional.getValue(EncryptionKey.class, it.next());
        if (aSN1Sequence.mo14450size() > 7) {
            this.inlineP2pcdRequest = (SequenceOfHashedId3) OEROptional.getValue(SequenceOfHashedId3.class, it.next());
            this.requestedCertificate = (Certificate) OEROptional.getValue(Certificate.class, it.next());
            this.pduFunctionalType = (PduFunctionalType) OEROptional.getValue(PduFunctionalType.class, it.next());
            contributedExtensionBlocks = (ContributedExtensionBlocks) OEROptional.getValue(ContributedExtensionBlocks.class, it.next());
        } else {
            contributedExtensionBlocks = null;
            this.inlineP2pcdRequest = null;
            this.requestedCertificate = null;
            this.pduFunctionalType = null;
        }
        this.contributedExtensions = contributedExtensionBlocks;
    }

    /* renamed from: builder */
    public static C5925Builder m17227builder() {
        return new C5925Builder();
    }

    public static HeaderInfo getInstance(Object obj) {
        if (obj instanceof HeaderInfo) {
            return (HeaderInfo) obj;
        }
        if (obj != null) {
            return new HeaderInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContributedExtensionBlocks getContributedExtensions() {
        return this.contributedExtensions;
    }

    public EncryptionKey getEncryptionKey() {
        return this.encryptionKey;
    }

    public C5970Time64 getExpiryTime() {
        return this.expiryTime;
    }

    public ThreeDLocation getGenerationLocation() {
        return this.generationLocation;
    }

    public C5970Time64 getGenerationTime() {
        return this.generationTime;
    }

    public SequenceOfHashedId3 getInlineP2pcdRequest() {
        return this.inlineP2pcdRequest;
    }

    public MissingCrlIdentifier getMissingCrlIdentifier() {
        return this.missingCrlIdentifier;
    }

    public HashedId3 getP2pcdLearningRequest() {
        return this.p2pcdLearningRequest;
    }

    public PduFunctionalType getPduFunctionalType() {
        return this.pduFunctionalType;
    }

    /* renamed from: getPsid */
    public C5954Psid m17228getPsid() {
        return this.f22643psid;
    }

    public Certificate getRequestedCertificate() {
        return this.requestedCertificate;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22643psid, OEROptional.getInstance(this.generationTime), OEROptional.getInstance(this.expiryTime), OEROptional.getInstance(this.generationLocation), OEROptional.getInstance(this.p2pcdLearningRequest), OEROptional.getInstance(this.missingCrlIdentifier), OEROptional.getInstance(this.encryptionKey), OEROptional.getInstance(this.inlineP2pcdRequest), OEROptional.getInstance(this.requestedCertificate), OEROptional.getInstance(this.pduFunctionalType), OEROptional.getInstance(this.contributedExtensions)});
    }

    public HeaderInfo(C5954Psid c5954Psid, C5970Time64 c5970Time64, C5970Time64 c5970Time642, ThreeDLocation threeDLocation, HashedId3 hashedId3, MissingCrlIdentifier missingCrlIdentifier, EncryptionKey encryptionKey, SequenceOfHashedId3 sequenceOfHashedId3, Certificate certificate, PduFunctionalType pduFunctionalType, ContributedExtensionBlocks contributedExtensionBlocks) {
        this.f22643psid = c5954Psid;
        this.generationTime = c5970Time64;
        this.expiryTime = c5970Time642;
        this.generationLocation = threeDLocation;
        this.p2pcdLearningRequest = hashedId3;
        this.missingCrlIdentifier = missingCrlIdentifier;
        this.encryptionKey = encryptionKey;
        this.inlineP2pcdRequest = sequenceOfHashedId3;
        this.requestedCertificate = certificate;
        this.pduFunctionalType = pduFunctionalType;
        this.contributedExtensions = contributedExtensionBlocks;
    }
}
