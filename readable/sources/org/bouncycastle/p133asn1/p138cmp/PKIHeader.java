package org.bouncycastle.p133asn1.p138cmp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* loaded from: classes.dex */
public class PKIHeader extends ASN1Object {
    public static final int CMP_1999 = 1;
    public static final int CMP_2000 = 2;
    public static final int CMP_2021 = 3;
    public static final GeneralName NULL_NAME = new GeneralName(X500Name.getInstance(new DERSequence()));
    private PKIFreeText freeText;
    private ASN1Sequence generalInfo;
    private ASN1GeneralizedTime messageTime;
    private AlgorithmIdentifier protectionAlg;

    /* renamed from: pvno */
    private final ASN1Integer f18139pvno;
    private ASN1OctetString recipKID;
    private ASN1OctetString recipNonce;
    private final GeneralName recipient;

    /* renamed from: sender */
    private final GeneralName f18140sender;
    private ASN1OctetString senderKID;
    private ASN1OctetString senderNonce;
    private ASN1OctetString transactionID;

    public PKIHeader(int i, GeneralName generalName, GeneralName generalName2) {
        this(ASN1Integer.m14429valueOf(i), generalName, generalName2);
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static PKIHeader getInstance(Object obj) {
        if (obj instanceof PKIHeader) {
            return (PKIHeader) obj;
        }
        if (obj != null) {
            return new PKIHeader(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIFreeText getFreeText() {
        return this.freeText;
    }

    public InfoTypeAndValue[] getGeneralInfo() {
        ASN1Sequence aSN1Sequence = this.generalInfo;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        InfoTypeAndValue[] infoTypeAndValueArr = new InfoTypeAndValue[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            infoTypeAndValueArr[i] = InfoTypeAndValue.getInstance(this.generalInfo.getObjectAt(i));
        }
        return infoTypeAndValueArr;
    }

    public ASN1GeneralizedTime getMessageTime() {
        return this.messageTime;
    }

    public AlgorithmIdentifier getProtectionAlg() {
        return this.protectionAlg;
    }

    /* renamed from: getPvno */
    public ASN1Integer m14519getPvno() {
        return this.f18139pvno;
    }

    public ASN1OctetString getRecipKID() {
        return this.recipKID;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public GeneralName getRecipient() {
        return this.recipient;
    }

    public GeneralName getSender() {
        return this.f18140sender;
    }

    public ASN1OctetString getSenderKID() {
        return this.senderKID;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(12);
        aSN1EncodableVector.m14420add(this.f18139pvno);
        aSN1EncodableVector.m14420add(this.f18140sender);
        aSN1EncodableVector.m14420add(this.recipient);
        addOptional(aSN1EncodableVector, 0, this.messageTime);
        addOptional(aSN1EncodableVector, 1, this.protectionAlg);
        addOptional(aSN1EncodableVector, 2, this.senderKID);
        addOptional(aSN1EncodableVector, 3, this.recipKID);
        addOptional(aSN1EncodableVector, 4, this.transactionID);
        addOptional(aSN1EncodableVector, 5, this.senderNonce);
        addOptional(aSN1EncodableVector, 6, this.recipNonce);
        addOptional(aSN1EncodableVector, 7, this.freeText);
        addOptional(aSN1EncodableVector, 8, this.generalInfo);
        return new DERSequence(aSN1EncodableVector);
    }

    private PKIHeader(ASN1Integer aSN1Integer, GeneralName generalName, GeneralName generalName2) {
        this.f18139pvno = aSN1Integer;
        this.f18140sender = generalName;
        this.recipient = generalName2;
    }

    private PKIHeader(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18139pvno = ASN1Integer.getInstance(objects.nextElement());
        this.f18140sender = GeneralName.getInstance(objects.nextElement());
        this.recipient = GeneralName.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (!aSN1TaggedObject.hasContextTag()) {
                throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(aSN1TaggedObject));
            }
            switch (aSN1TaggedObject.getTagNo()) {
                case 0:
                    this.messageTime = ASN1GeneralizedTime.getInstance(aSN1TaggedObject, true);
                    break;
                case 1:
                    this.protectionAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
                    break;
                case 2:
                    this.senderKID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 3:
                    this.recipKID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 4:
                    this.transactionID = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 5:
                    this.senderNonce = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 6:
                    this.recipNonce = ASN1OctetString.getInstance(aSN1TaggedObject, true);
                    break;
                case 7:
                    this.freeText = PKIFreeText.getInstance(aSN1TaggedObject, true);
                    break;
                case 8:
                    this.generalInfo = ASN1Sequence.getInstance(aSN1TaggedObject, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
            }
        }
    }
}
