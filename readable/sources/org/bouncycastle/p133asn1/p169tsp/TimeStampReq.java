package org.bouncycastle.p133asn1.p169tsp;

import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* loaded from: classes2.dex */
public class TimeStampReq extends ASN1Object {

    /* renamed from: certReq */
    ASN1Boolean f18556certReq;
    Extensions extensions;
    MessageImprint messageImprint;

    /* renamed from: nonce */
    ASN1Integer f18557nonce;
    ASN1ObjectIdentifier tsaPolicy;

    /* renamed from: version */
    ASN1Integer f18558version;

    private TimeStampReq(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        this.f18558version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.messageImprint = MessageImprint.getInstance(aSN1Sequence.getObjectAt(1));
        for (int i = 2; i < iMo14450size; i++) {
            if (aSN1Sequence.getObjectAt(i) instanceof ASN1ObjectIdentifier) {
                checkOption(this.tsaPolicy, i, 2);
                this.tsaPolicy = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Integer) {
                checkOption(this.f18557nonce, i, 3);
                this.f18557nonce = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Boolean) {
                checkOption(this.f18556certReq, i, 4);
                this.f18556certReq = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(i));
            } else {
                if (!(aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject)) {
                    throw new IllegalArgumentException("unidentified structure in sequence");
                }
                checkOption(this.extensions, i, 5);
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.extensions = Extensions.getInstance(aSN1TaggedObject, false);
                }
            }
        }
    }

    private void checkOption(Object obj, int i, int i2) {
        if (obj != null || i > i2) {
            throw new IllegalArgumentException("badly placed optional in sequence");
        }
    }

    public static TimeStampReq getInstance(Object obj) {
        if (obj instanceof TimeStampReq) {
            return (TimeStampReq) obj;
        }
        if (obj != null) {
            return new TimeStampReq(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Boolean getCertReq() {
        ASN1Boolean aSN1Boolean = this.f18556certReq;
        return aSN1Boolean == null ? ASN1Boolean.f17897FALSE : aSN1Boolean;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public ASN1Integer getNonce() {
        return this.f18557nonce;
    }

    public ASN1ObjectIdentifier getReqPolicy() {
        return this.tsaPolicy;
    }

    public ASN1Integer getVersion() {
        return this.f18558version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(this.f18558version);
        aSN1EncodableVector.m14420add(this.messageImprint);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.tsaPolicy;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.m14420add(aSN1ObjectIdentifier);
        }
        ASN1Integer aSN1Integer = this.f18557nonce;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        ASN1Boolean aSN1Boolean = this.f18556certReq;
        if (aSN1Boolean != null && aSN1Boolean.m14419isTrue()) {
            aSN1EncodableVector.m14420add(this.f18556certReq);
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampReq(MessageImprint messageImprint, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Boolean aSN1Boolean, Extensions extensions) {
        this.f18558version = ASN1Integer.f17918ONE;
        this.messageImprint = messageImprint;
        this.tsaPolicy = aSN1ObjectIdentifier;
        this.f18557nonce = aSN1Integer;
        this.f18556certReq = aSN1Boolean;
        this.extensions = extensions;
    }
}
