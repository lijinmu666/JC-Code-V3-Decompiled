package org.bouncycastle.p300oer.p301its.etsi103097.extension;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Sequence;

/* loaded from: classes2.dex */
public class EtsiOriginatingHeaderInfoExtension extends Extension {

    /* renamed from: org.bouncycastle.oer.its.etsi103097.extension.EtsiOriginatingHeaderInfoExtension$Builder */
    public static class C5917Builder {
        private ASN1Encodable encodable;

        /* renamed from: id */
        private C5920ExtId f22620id;

        public EtsiOriginatingHeaderInfoExtension createEtsiOriginatingHeaderInfoExtension() {
            return new EtsiOriginatingHeaderInfoExtension(this.f22620id, this.encodable);
        }

        public C5917Builder setEncodable(ASN1Encodable aSN1Encodable) {
            this.encodable = aSN1Encodable;
            return this;
        }

        public C5917Builder setEtsiTs102941CrlRequest(EtsiTs102941CrlRequest etsiTs102941CrlRequest) {
            this.f22620id = Extension.etsiTs102941CrlRequestId;
            this.encodable = etsiTs102941CrlRequest;
            return this;
        }

        public C5917Builder setEtsiTs102941DeltaCtlRequest(EtsiTs102941DeltaCtlRequest etsiTs102941DeltaCtlRequest) {
            this.f22620id = Extension.etsiTs102941DeltaCtlRequestId;
            this.encodable = etsiTs102941DeltaCtlRequest;
            return this;
        }

        /* renamed from: setId */
        public C5917Builder m17211setId(C5920ExtId c5920ExtId) {
            this.f22620id = c5920ExtId;
            return this;
        }
    }

    private EtsiOriginatingHeaderInfoExtension(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    /* renamed from: builder */
    public static C5917Builder m17210builder() {
        return new C5917Builder();
    }

    public static EtsiOriginatingHeaderInfoExtension getInstance(Object obj) {
        if (obj instanceof EtsiOriginatingHeaderInfoExtension) {
            return (EtsiOriginatingHeaderInfoExtension) obj;
        }
        if (obj != null) {
            return new EtsiOriginatingHeaderInfoExtension(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs102941CrlRequest getEtsiTs102941CrlRequest() {
        return EtsiTs102941CrlRequest.getInstance(getContent());
    }

    public EtsiTs102941DeltaCtlRequest getEtsiTs102941DeltaCtlRequest() {
        return EtsiTs102941DeltaCtlRequest.getInstance((Object) getContent());
    }

    public EtsiOriginatingHeaderInfoExtension(C5920ExtId c5920ExtId, ASN1Encodable aSN1Encodable) {
        super(c5920ExtId, aSN1Encodable);
    }
}
