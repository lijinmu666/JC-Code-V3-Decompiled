package org.bouncycastle.p133asn1.p169tsp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* renamed from: org.bouncycastle.asn1.tsp.TSTInfo */
/* loaded from: classes2.dex */
public class C5186TSTInfo extends ASN1Object {
    private Accuracy accuracy;
    private Extensions extensions;

    /* renamed from: genTime */
    private ASN1GeneralizedTime f18552genTime;
    private MessageImprint messageImprint;

    /* renamed from: nonce */
    private ASN1Integer f18553nonce;
    private ASN1Boolean ordering;
    private ASN1Integer serialNumber;

    /* renamed from: tsa */
    private GeneralName f18554tsa;
    private ASN1ObjectIdentifier tsaPolicyId;

    /* renamed from: version */
    private ASN1Integer f18555version;

    public C5186TSTInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, MessageImprint messageImprint, ASN1Integer aSN1Integer, ASN1GeneralizedTime aSN1GeneralizedTime, Accuracy accuracy, ASN1Boolean aSN1Boolean, ASN1Integer aSN1Integer2, GeneralName generalName, Extensions extensions) {
        this.f18555version = ASN1Integer.f17918ONE;
        this.tsaPolicyId = aSN1ObjectIdentifier;
        this.messageImprint = messageImprint;
        this.serialNumber = aSN1Integer;
        this.f18552genTime = aSN1GeneralizedTime;
        this.accuracy = accuracy;
        this.ordering = aSN1Boolean;
        this.f18553nonce = aSN1Integer2;
        this.f18554tsa = generalName;
        this.extensions = extensions;
    }

    public static C5186TSTInfo getInstance(Object obj) {
        if (obj instanceof C5186TSTInfo) {
            return (C5186TSTInfo) obj;
        }
        if (obj != null) {
            return new C5186TSTInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Accuracy getAccuracy() {
        return this.accuracy;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public ASN1GeneralizedTime getGenTime() {
        return this.f18552genTime;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public ASN1Integer getNonce() {
        return this.f18553nonce;
    }

    public ASN1Boolean getOrdering() {
        return this.ordering;
    }

    public ASN1ObjectIdentifier getPolicy() {
        return this.tsaPolicyId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    /* renamed from: getTsa */
    public GeneralName m14651getTsa() {
        return this.f18554tsa;
    }

    public ASN1Integer getVersion() {
        return this.f18555version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.m14420add(this.f18555version);
        aSN1EncodableVector.m14420add(this.tsaPolicyId);
        aSN1EncodableVector.m14420add(this.messageImprint);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(this.f18552genTime);
        Accuracy accuracy = this.accuracy;
        if (accuracy != null) {
            aSN1EncodableVector.m14420add(accuracy);
        }
        ASN1Boolean aSN1Boolean = this.ordering;
        if (aSN1Boolean != null && aSN1Boolean.m14419isTrue()) {
            aSN1EncodableVector.m14420add(this.ordering);
        }
        ASN1Integer aSN1Integer = this.f18553nonce;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        GeneralName generalName = this.f18554tsa;
        if (generalName != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) generalName));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private C5186TSTInfo(ASN1Sequence aSN1Sequence) {
        ASN1Object aSN1Object;
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18555version = ASN1Integer.getInstance(objects.nextElement());
        this.tsaPolicyId = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        this.messageImprint = MessageImprint.getInstance(objects.nextElement());
        this.serialNumber = ASN1Integer.getInstance(objects.nextElement());
        this.f18552genTime = ASN1GeneralizedTime.getInstance(objects.nextElement());
        ASN1Boolean aSN1Boolean = ASN1Boolean.getInstance(false);
        while (true) {
            this.ordering = aSN1Boolean;
            while (objects.hasMoreElements()) {
                aSN1Object = (ASN1Object) objects.nextElement();
                if (aSN1Object instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Object;
                    int tagNo = aSN1TaggedObject.getTagNo();
                    if (tagNo == 0) {
                        this.f18554tsa = GeneralName.getInstance(aSN1TaggedObject, true);
                    } else {
                        if (tagNo != 1) {
                            throw new IllegalArgumentException("Unknown tag value " + aSN1TaggedObject.getTagNo());
                        }
                        this.extensions = Extensions.getInstance(aSN1TaggedObject, false);
                    }
                } else if ((aSN1Object instanceof ASN1Sequence) || (aSN1Object instanceof Accuracy)) {
                    this.accuracy = Accuracy.getInstance(aSN1Object);
                } else if (aSN1Object instanceof ASN1Boolean) {
                    break;
                } else if (aSN1Object instanceof ASN1Integer) {
                    this.f18553nonce = ASN1Integer.getInstance(aSN1Object);
                }
            }
            return;
            aSN1Boolean = ASN1Boolean.getInstance(aSN1Object);
        }
    }
}
