package org.bouncycastle.p133asn1.p139cms;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.C5101BERSet;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DLSequence;

/* loaded from: classes.dex */
public class SignedData extends ASN1Object {
    private AbstractC5093ASN1Set certificates;
    private boolean certsBer;
    private final ContentInfo contentInfo;

    /* renamed from: crls */
    private AbstractC5093ASN1Set f18222crls;

    /* renamed from: crlsBer */
    private boolean f18223crlsBer;
    private final AbstractC5093ASN1Set digestAlgorithms;

    /* renamed from: digsBer */
    private final boolean f18224digsBer;
    private final AbstractC5093ASN1Set signerInfos;

    /* renamed from: sigsBer */
    private final boolean f18225sigsBer;

    /* renamed from: version */
    private final ASN1Integer f18226version;

    private SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18226version = ASN1Integer.getInstance(objects.nextElement());
        this.digestAlgorithms = (AbstractC5093ASN1Set) objects.nextElement();
        this.contentInfo = ContentInfo.getInstance(objects.nextElement());
        AbstractC5093ASN1Set abstractC5093ASN1Set = null;
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) objects.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.certsBer = aSN1TaggedObject instanceof BERTaggedObject;
                    this.certificates = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                } else {
                    if (tagNo != 1) {
                        throw new IllegalArgumentException("unknown tag value " + aSN1TaggedObject.getTagNo());
                    }
                    this.f18223crlsBer = aSN1TaggedObject instanceof BERTaggedObject;
                    this.f18222crls = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                }
            } else {
                if (!(aSN1Primitive instanceof AbstractC5093ASN1Set)) {
                    throw new IllegalArgumentException("SET expected, not encountered");
                }
                abstractC5093ASN1Set = (AbstractC5093ASN1Set) aSN1Primitive;
            }
        }
        if (abstractC5093ASN1Set == null) {
            throw new IllegalArgumentException("signerInfos not set");
        }
        this.signerInfos = abstractC5093ASN1Set;
        this.f18224digsBer = this.digestAlgorithms instanceof C5101BERSet;
        this.f18225sigsBer = abstractC5093ASN1Set instanceof C5101BERSet;
    }

    private ASN1Integer calculateVersion(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5093ASN1Set abstractC5093ASN1Set, AbstractC5093ASN1Set abstractC5093ASN1Set2, AbstractC5093ASN1Set abstractC5093ASN1Set3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (abstractC5093ASN1Set != null) {
            Enumeration objects = abstractC5093ASN1Set.getObjects();
            z = false;
            z2 = false;
            z3 = false;
            while (objects.hasMoreElements()) {
                Object objNextElement = objects.nextElement();
                if (objNextElement instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objNextElement);
                    if (aSN1TaggedObject.getTagNo() == 1) {
                        z2 = true;
                    } else if (aSN1TaggedObject.getTagNo() == 2) {
                        z3 = true;
                    } else if (aSN1TaggedObject.getTagNo() == 3) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z) {
            return ASN1Integer.f17916FIVE;
        }
        if (abstractC5093ASN1Set2 != null) {
            Enumeration objects2 = abstractC5093ASN1Set2.getObjects();
            while (objects2.hasMoreElements()) {
                if (objects2.nextElement() instanceof ASN1TaggedObject) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            return ASN1Integer.f17916FIVE;
        }
        if (z3) {
            return ASN1Integer.f17917FOUR;
        }
        if (!z2 && !checkForVersion3(abstractC5093ASN1Set3) && CMSObjectIdentifiers.f18179data.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return ASN1Integer.f17918ONE;
        }
        return ASN1Integer.f17919THREE;
    }

    private boolean checkForVersion3(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            if (SignerInfo.getInstance(objects.nextElement()).getVersion().hasValue(3)) {
                return true;
            }
        }
        return false;
    }

    public static SignedData getInstance(Object obj) {
        if (obj instanceof SignedData) {
            return (SignedData) obj;
        }
        if (obj != null) {
            return new SignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCRLs */
    public AbstractC5093ASN1Set m14553getCRLs() {
        return this.f18222crls;
    }

    public AbstractC5093ASN1Set getCertificates() {
        return this.certificates;
    }

    public AbstractC5093ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public ContentInfo getEncapContentInfo() {
        return this.contentInfo;
    }

    public AbstractC5093ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    public ASN1Integer getVersion() {
        return this.f18226version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(this.f18226version);
        aSN1EncodableVector.m14420add(this.digestAlgorithms);
        aSN1EncodableVector.m14420add(this.contentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.certificates;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(this.certsBer ? new BERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set) : new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.f18222crls;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(this.f18223crlsBer ? new BERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set2) : new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        aSN1EncodableVector.m14420add(this.signerInfos);
        return (!this.contentInfo.isDefiniteLength() || this.f18224digsBer || this.f18225sigsBer || this.f18223crlsBer || this.certsBer) ? new BERSequence(aSN1EncodableVector) : new DLSequence(aSN1EncodableVector);
    }

    public SignedData(AbstractC5093ASN1Set abstractC5093ASN1Set, ContentInfo contentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set2, AbstractC5093ASN1Set abstractC5093ASN1Set3, AbstractC5093ASN1Set abstractC5093ASN1Set4) {
        this.f18226version = calculateVersion(contentInfo.getContentType(), abstractC5093ASN1Set2, abstractC5093ASN1Set3, abstractC5093ASN1Set4);
        this.digestAlgorithms = abstractC5093ASN1Set;
        this.contentInfo = contentInfo;
        this.certificates = abstractC5093ASN1Set2;
        this.f18222crls = abstractC5093ASN1Set3;
        this.signerInfos = abstractC5093ASN1Set4;
        this.f18224digsBer = abstractC5093ASN1Set instanceof C5101BERSet;
        this.f18223crlsBer = abstractC5093ASN1Set3 instanceof C5101BERSet;
        this.certsBer = abstractC5093ASN1Set2 instanceof C5101BERSet;
        this.f18225sigsBer = abstractC5093ASN1Set4 instanceof C5101BERSet;
    }
}
