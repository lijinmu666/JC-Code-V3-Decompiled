package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class DVCSRequest extends ASN1Object {

    /* renamed from: data */
    private C5124Data f18307data;
    private DVCSRequestInformation requestInformation;
    private GeneralName transactionIdentifier;

    private DVCSRequest(ASN1Sequence aSN1Sequence) {
        this.requestInformation = DVCSRequestInformation.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18307data = C5124Data.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() > 2) {
            this.transactionIdentifier = GeneralName.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static DVCSRequest getInstance(Object obj) {
        if (obj instanceof DVCSRequest) {
            return (DVCSRequest) obj;
        }
        if (obj != null) {
            return new DVCSRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getData */
    public C5124Data m14583getData() {
        return this.f18307data;
    }

    public DVCSRequestInformation getRequestInformation() {
        return this.requestInformation;
    }

    public GeneralName getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.requestInformation);
        aSN1EncodableVector.m14420add(this.f18307data);
        GeneralName generalName = this.transactionIdentifier;
        if (generalName != null) {
            aSN1EncodableVector.m14420add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("DVCSRequest {\nrequestInformation: ");
        sb.append(this.requestInformation);
        sb.append("\ndata: ");
        sb.append(this.f18307data);
        sb.append("\n");
        if (this.transactionIdentifier != null) {
            str = "transactionIdentifier: " + this.transactionIdentifier + "\n";
        } else {
            str = BuildConfig.f24315FLAVOR;
        }
        sb.append(str);
        sb.append("}\n");
        return sb.toString();
    }

    public DVCSRequest(DVCSRequestInformation dVCSRequestInformation, C5124Data c5124Data) {
        this(dVCSRequestInformation, c5124Data, null);
    }

    public static DVCSRequest getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DVCSRequest(DVCSRequestInformation dVCSRequestInformation, C5124Data c5124Data, GeneralName generalName) {
        this.requestInformation = dVCSRequestInformation;
        this.f18307data = c5124Data;
        this.transactionIdentifier = generalName;
    }
}
