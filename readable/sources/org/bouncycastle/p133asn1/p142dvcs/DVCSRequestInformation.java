package org.bouncycastle.p133asn1.p142dvcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;

/* loaded from: classes2.dex */
public class DVCSRequestInformation extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_DATA_LOCATIONS = 3;
    private static final int TAG_DVCS = 2;
    private static final int TAG_EXTENSIONS = 4;
    private static final int TAG_REQUESTER = 0;
    private static final int TAG_REQUEST_POLICY = 1;
    private GeneralNames dataLocations;

    /* renamed from: dvcs */
    private GeneralNames f18308dvcs;
    private Extensions extensions;

    /* renamed from: nonce */
    private BigInteger f18309nonce;
    private PolicyInformation requestPolicy;
    private DVCSTime requestTime;
    private GeneralNames requester;

    /* renamed from: service */
    private ServiceType f18310service;

    /* renamed from: version */
    private int f18311version;

    private DVCSRequestInformation(ASN1Sequence aSN1Sequence) {
        int i;
        this.f18311version = 1;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.f18311version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
            i = 1;
        } else {
            this.f18311version = 1;
            i = 0;
        }
        this.f18310service = ServiceType.getInstance(aSN1Sequence.getObjectAt(i));
        for (int i2 = i + 1; i2 < aSN1Sequence.mo14450size(); i2++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i2);
            if (objectAt instanceof ASN1Integer) {
                this.f18309nonce = ASN1Integer.getInstance(objectAt).getValue();
            } else if (!(objectAt instanceof ASN1GeneralizedTime) && (objectAt instanceof ASN1TaggedObject)) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objectAt);
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.requester = GeneralNames.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 1) {
                    this.requestPolicy = PolicyInformation.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, false));
                } else if (tagNo == 2) {
                    this.f18308dvcs = GeneralNames.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 3) {
                    this.dataLocations = GeneralNames.getInstance(aSN1TaggedObject, false);
                } else {
                    if (tagNo != 4) {
                        throw new IllegalArgumentException("unknown tag number encountered: " + tagNo);
                    }
                    this.extensions = Extensions.getInstance(aSN1TaggedObject, false);
                }
            } else {
                this.requestTime = DVCSTime.getInstance(objectAt);
            }
        }
    }

    public static DVCSRequestInformation getInstance(Object obj) {
        if (obj instanceof DVCSRequestInformation) {
            return (DVCSRequestInformation) obj;
        }
        if (obj != null) {
            return new DVCSRequestInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getDVCS */
    public GeneralNames m14584getDVCS() {
        return this.f18308dvcs;
    }

    public GeneralNames getDataLocations() {
        return this.dataLocations;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public BigInteger getNonce() {
        return this.f18309nonce;
    }

    public PolicyInformation getRequestPolicy() {
        return this.requestPolicy;
    }

    public DVCSTime getRequestTime() {
        return this.requestTime;
    }

    public GeneralNames getRequester() {
        return this.requester;
    }

    public ServiceType getService() {
        return this.f18310service;
    }

    public int getVersion() {
        return this.f18311version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        int i = this.f18311version;
        if (i != 1) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        aSN1EncodableVector.m14420add(this.f18310service);
        if (this.f18309nonce != null) {
            aSN1EncodableVector.m14420add(new ASN1Integer(this.f18309nonce));
        }
        DVCSTime dVCSTime = this.requestTime;
        if (dVCSTime != null) {
            aSN1EncodableVector.m14420add(dVCSTime);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = {this.requester, this.requestPolicy, this.f18308dvcs, this.dataLocations, this.extensions};
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, i3, aSN1Encodable));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVCSRequestInformation {\n");
        if (this.f18311version != 1) {
            sb.append("version: " + this.f18311version + "\n");
        }
        sb.append("service: " + this.f18310service + "\n");
        if (this.f18309nonce != null) {
            sb.append("nonce: " + this.f18309nonce + "\n");
        }
        if (this.requestTime != null) {
            sb.append("requestTime: " + this.requestTime + "\n");
        }
        if (this.requester != null) {
            sb.append("requester: " + this.requester + "\n");
        }
        if (this.requestPolicy != null) {
            sb.append("requestPolicy: " + this.requestPolicy + "\n");
        }
        if (this.f18308dvcs != null) {
            sb.append("dvcs: " + this.f18308dvcs + "\n");
        }
        if (this.dataLocations != null) {
            sb.append("dataLocations: " + this.dataLocations + "\n");
        }
        if (this.extensions != null) {
            sb.append("extensions: " + this.extensions + "\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static DVCSRequestInformation getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
