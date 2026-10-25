package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    private AbstractC5093ASN1Set certificates;
    private ContentInfo contentInfo;

    /* renamed from: crls */
    private AbstractC5093ASN1Set f18526crls;
    private AbstractC5093ASN1Set digestAlgorithms;
    private AbstractC5093ASN1Set signerInfos;

    /* renamed from: version */
    private ASN1Integer f18527version;

    public SignedData(ASN1Integer aSN1Integer, AbstractC5093ASN1Set abstractC5093ASN1Set, ContentInfo contentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set2, AbstractC5093ASN1Set abstractC5093ASN1Set3, AbstractC5093ASN1Set abstractC5093ASN1Set4) {
        this.f18527version = aSN1Integer;
        this.digestAlgorithms = abstractC5093ASN1Set;
        this.contentInfo = contentInfo;
        this.certificates = abstractC5093ASN1Set2;
        this.f18526crls = abstractC5093ASN1Set3;
        this.signerInfos = abstractC5093ASN1Set4;
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
    public AbstractC5093ASN1Set m14638getCRLs() {
        return this.f18526crls;
    }

    public AbstractC5093ASN1Set getCertificates() {
        return this.certificates;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public AbstractC5093ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public AbstractC5093ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    public ASN1Integer getVersion() {
        return this.f18527version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(this.f18527version);
        aSN1EncodableVector.m14420add(this.digestAlgorithms);
        aSN1EncodableVector.m14420add(this.contentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.certificates;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.f18526crls;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        aSN1EncodableVector.m14420add(this.signerInfos);
        return new BERSequence(aSN1EncodableVector);
    }

    public SignedData(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18527version = (ASN1Integer) objects.nextElement();
        this.digestAlgorithms = (AbstractC5093ASN1Set) objects.nextElement();
        this.contentInfo = ContentInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) objects.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.certificates = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                } else {
                    if (tagNo != 1) {
                        throw new IllegalArgumentException("unknown tag value " + aSN1TaggedObject.getTagNo());
                    }
                    this.f18526crls = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                }
            } else {
                this.signerInfos = (AbstractC5093ASN1Set) aSN1Primitive;
            }
        }
    }
}
