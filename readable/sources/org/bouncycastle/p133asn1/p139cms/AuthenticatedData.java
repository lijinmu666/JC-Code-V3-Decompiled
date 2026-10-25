package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class AuthenticatedData extends ASN1Object {
    private AbstractC5093ASN1Set authAttrs;
    private AlgorithmIdentifier digestAlgorithm;
    private ContentInfo encapsulatedContentInfo;

    /* renamed from: mac */
    private ASN1OctetString f18170mac;
    private AlgorithmIdentifier macAlgorithm;
    private OriginatorInfo originatorInfo;
    private AbstractC5093ASN1Set recipientInfos;
    private AbstractC5093ASN1Set unauthAttrs;

    /* renamed from: version */
    private ASN1Integer f18171version;

    private AuthenticatedData(ASN1Sequence aSN1Sequence) {
        int i;
        this.f18171version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
        if (objectAt instanceof ASN1TaggedObject) {
            this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) objectAt, false);
            objectAt = aSN1Sequence.getObjectAt(2);
            i = 3;
        } else {
            i = 2;
        }
        this.recipientInfos = AbstractC5093ASN1Set.getInstance(objectAt);
        this.macAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        int i2 = i + 2;
        ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i + 1);
        if (objectAt2 instanceof ASN1TaggedObject) {
            this.digestAlgorithm = AlgorithmIdentifier.getInstance((ASN1TaggedObject) objectAt2, false);
            objectAt2 = aSN1Sequence.getObjectAt(i2);
            i2 = i + 3;
        }
        this.encapsulatedContentInfo = ContentInfo.getInstance(objectAt2);
        int i3 = i2 + 1;
        ASN1Encodable objectAt3 = aSN1Sequence.getObjectAt(i2);
        if (objectAt3 instanceof ASN1TaggedObject) {
            this.authAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) objectAt3, false);
            objectAt3 = aSN1Sequence.getObjectAt(i3);
            i3 = i2 + 2;
        }
        this.f18170mac = ASN1OctetString.getInstance(objectAt3);
        if (aSN1Sequence.mo14450size() > i3) {
            this.unauthAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i3), false);
        }
    }

    public static int calculateVersion(OriginatorInfo originatorInfo) {
        if (originatorInfo != null) {
            AbstractC5093ASN1Set abstractC5093ASN1SetM14547getCRLs = originatorInfo.m14547getCRLs();
            if (abstractC5093ASN1SetM14547getCRLs != null) {
                int iM14454size = abstractC5093ASN1SetM14547getCRLs.m14454size();
                for (int i = 0; i < iM14454size; i++) {
                    ASN1Encodable objectAt = abstractC5093ASN1SetM14547getCRLs.getObjectAt(i);
                    if ((objectAt instanceof ASN1TaggedObject) && ((ASN1TaggedObject) objectAt).hasContextTag(1)) {
                        return 3;
                    }
                }
            }
            AbstractC5093ASN1Set certificates = originatorInfo.getCertificates();
            if (certificates != null) {
                int iM14454size2 = certificates.m14454size();
                boolean z = false;
                for (int i2 = 0; i2 < iM14454size2; i2++) {
                    ASN1Encodable objectAt2 = certificates.getObjectAt(i2);
                    if (objectAt2 instanceof ASN1TaggedObject) {
                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt2;
                        if (aSN1TaggedObject.hasContextTag(3)) {
                            return 3;
                        }
                        z = z || aSN1TaggedObject.hasContextTag(2);
                    }
                }
                if (z) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static AuthenticatedData getInstance(Object obj) {
        if (obj instanceof AuthenticatedData) {
            return (AuthenticatedData) obj;
        }
        if (obj != null) {
            return new AuthenticatedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AbstractC5093ASN1Set getAuthAttrs() {
        return this.authAttrs;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ContentInfo getEncapsulatedContentInfo() {
        return this.encapsulatedContentInfo;
    }

    /* renamed from: getMac */
    public ASN1OctetString m14536getMac() {
        return this.f18170mac;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public AbstractC5093ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public AbstractC5093ASN1Set getUnauthAttrs() {
        return this.unauthAttrs;
    }

    public ASN1Integer getVersion() {
        return this.f18171version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        aSN1EncodableVector.m14420add(this.f18171version);
        OriginatorInfo originatorInfo = this.originatorInfo;
        if (originatorInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) originatorInfo));
        }
        aSN1EncodableVector.m14420add(this.recipientInfos);
        aSN1EncodableVector.m14420add(this.macAlgorithm);
        AlgorithmIdentifier algorithmIdentifier = this.digestAlgorithm;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) algorithmIdentifier));
        }
        aSN1EncodableVector.m14420add(this.encapsulatedContentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authAttrs;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) abstractC5093ASN1Set));
        }
        aSN1EncodableVector.m14420add(this.f18170mac);
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.unauthAttrs;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 3, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public AuthenticatedData(OriginatorInfo originatorInfo, AbstractC5093ASN1Set abstractC5093ASN1Set, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ContentInfo contentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set2, ASN1OctetString aSN1OctetString, AbstractC5093ASN1Set abstractC5093ASN1Set3) {
        if (!(algorithmIdentifier2 == null && abstractC5093ASN1Set2 == null) && (algorithmIdentifier2 == null || abstractC5093ASN1Set2 == null)) {
            throw new IllegalArgumentException("digestAlgorithm and authAttrs must be set together");
        }
        this.f18171version = ASN1Integer.m14429valueOf(calculateVersion(originatorInfo));
        this.originatorInfo = originatorInfo;
        this.macAlgorithm = algorithmIdentifier;
        this.digestAlgorithm = algorithmIdentifier2;
        this.recipientInfos = abstractC5093ASN1Set;
        this.encapsulatedContentInfo = contentInfo;
        this.authAttrs = abstractC5093ASN1Set2;
        this.f18170mac = aSN1OctetString;
        this.unauthAttrs = abstractC5093ASN1Set3;
    }

    public static AuthenticatedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
