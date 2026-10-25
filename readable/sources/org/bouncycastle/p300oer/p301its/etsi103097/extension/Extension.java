package org.bouncycastle.p300oer.p301its.etsi103097.extension;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class Extension extends ASN1Object {
    public static final C5920ExtId etsiTs102941CrlRequestId = new C5920ExtId(1);
    public static final C5920ExtId etsiTs102941DeltaCtlRequestId = new C5920ExtId(2);

    /* renamed from: content */
    private final ASN1Encodable f22623content;

    /* renamed from: id */
    private final C5920ExtId f22624id;

    public Extension(ASN1Sequence aSN1Sequence) {
        ASN1Encodable etsiTs102941DeltaCtlRequest;
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        C5920ExtId c5920ExtId = C5920ExtId.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22624id = c5920ExtId;
        if (c5920ExtId.mo14431equals(etsiTs102941CrlRequestId)) {
            etsiTs102941DeltaCtlRequest = EtsiTs102941CrlRequest.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            if (!c5920ExtId.mo14431equals(etsiTs102941DeltaCtlRequestId)) {
                throw new IllegalArgumentException("id not 1 (EtsiTs102941CrlRequest) or 2 (EtsiTs102941DeltaCtlRequest)");
            }
            etsiTs102941DeltaCtlRequest = EtsiTs102941DeltaCtlRequest.getInstance((Object) aSN1Sequence.getObjectAt(1));
        }
        this.f22623content = etsiTs102941DeltaCtlRequest;
    }

    public static Extension etsiTs102941CrlRequest(EtsiTs102941CrlRequest etsiTs102941CrlRequest) {
        return new Extension(etsiTs102941CrlRequestId, etsiTs102941CrlRequest);
    }

    public static Extension etsiTs102941DeltaCtlRequest(EtsiTs102941DeltaCtlRequest etsiTs102941DeltaCtlRequest) {
        return new Extension(etsiTs102941DeltaCtlRequestId, etsiTs102941DeltaCtlRequest);
    }

    public static Extension getInstance(Object obj) {
        if (obj instanceof Extension) {
            return (Extension) obj;
        }
        if (obj != null) {
            return new Extension(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getContent() {
        return this.f22623content;
    }

    /* renamed from: getId */
    public C5920ExtId m17214getId() {
        return this.f22624id;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22624id, this.f22623content});
    }

    public Extension(C5920ExtId c5920ExtId, ASN1Encodable aSN1Encodable) {
        this.f22624id = c5920ExtId;
        if (c5920ExtId.getExtId().intValue() != 1 && c5920ExtId.getExtId().intValue() != 2) {
            throw new IllegalArgumentException("id not 1 (EtsiTs102941CrlRequest) or 2 (EtsiTs102941DeltaCtlRequest)");
        }
        this.f22623content = aSN1Encodable;
    }
}
