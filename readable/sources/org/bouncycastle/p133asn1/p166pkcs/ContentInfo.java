package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.DLSequence;

/* loaded from: classes2.dex */
public class ContentInfo extends ASN1Object implements PKCSObjectIdentifiers {

    /* renamed from: content */
    private ASN1Encodable f18468content;
    private ASN1ObjectIdentifier contentType;

    /* renamed from: isBer */
    private boolean f18469isBer;

    public ContentInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18469isBer = true;
        this.contentType = aSN1ObjectIdentifier;
        this.f18468content = aSN1Encodable;
    }

    public static ContentInfo getInstance(Object obj) {
        if (obj instanceof ContentInfo) {
            return (ContentInfo) obj;
        }
        if (obj != null) {
            return new ContentInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getContent() {
        return this.f18468content;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.contentType);
        ASN1Encodable aSN1Encodable = this.f18468content;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new BERTaggedObject(true, 0, aSN1Encodable));
        }
        return this.f18469isBer ? new BERSequence(aSN1EncodableVector) : new DLSequence(aSN1EncodableVector);
    }

    private ContentInfo(ASN1Sequence aSN1Sequence) {
        this.f18469isBer = true;
        Enumeration objects = aSN1Sequence.getObjects();
        this.contentType = (ASN1ObjectIdentifier) objects.nextElement();
        if (objects.hasMoreElements()) {
            this.f18468content = ((ASN1TaggedObject) objects.nextElement()).getExplicitBaseObject();
        }
        this.f18469isBer = aSN1Sequence instanceof BERSequence;
    }
}
