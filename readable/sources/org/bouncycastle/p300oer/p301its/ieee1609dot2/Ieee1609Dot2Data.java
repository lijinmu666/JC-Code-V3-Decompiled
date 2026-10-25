package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.util.Iterator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.etsi102941.InnerEcRequestSignedForPop;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Data;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataEncrypted;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataEncryptedUnicast;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSigned;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSignedAndEncrypted;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSignedAndEncryptedUnicast;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSignedExternalPayload;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataUnsecured;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class Ieee1609Dot2Data extends ASN1Object {

    /* renamed from: content */
    private final Ieee1609Dot2Content f22647content;
    private final C5976UINT8 protocolVersion;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.Ieee1609Dot2Data$Builder */
    public static class C5926Builder {

        /* renamed from: content */
        private Ieee1609Dot2Content f22648content;
        private C5976UINT8 protocolVersion;

        public CounterSignature createCounterSignature() {
            return new CounterSignature(this.protocolVersion, this.f22648content);
        }

        public EtsiTs103097Data createEtsiTs103097Data() {
            return new EtsiTs103097Data(this.protocolVersion, this.f22648content);
        }

        public EtsiTs103097DataEncrypted createEtsiTs103097DataEncrypted() {
            return new EtsiTs103097DataEncrypted(this.f22648content);
        }

        public EtsiTs103097DataEncryptedUnicast createEtsiTs103097DataEncryptedUnicast() {
            return new EtsiTs103097DataEncryptedUnicast(this.f22648content);
        }

        public EtsiTs103097DataSigned createEtsiTs103097DataSigned() {
            return new EtsiTs103097DataSigned(this.f22648content);
        }

        public EtsiTs103097DataSignedAndEncrypted createEtsiTs103097DataSignedAndEncrypted() {
            return new EtsiTs103097DataSignedAndEncrypted(this.f22648content);
        }

        public EtsiTs103097DataSignedAndEncryptedUnicast createEtsiTs103097DataSignedAndEncryptedUnicast() {
            return new EtsiTs103097DataSignedAndEncryptedUnicast(this.f22648content);
        }

        public EtsiTs103097DataSignedExternalPayload createEtsiTs103097DataSignedExternalPayload() {
            return new EtsiTs103097DataSignedExternalPayload(this.f22648content);
        }

        public EtsiTs103097DataUnsecured createEtsiTs103097DataUnsecured() {
            return new EtsiTs103097DataUnsecured(this.f22648content);
        }

        public Ieee1609Dot2Data createIeee1609Dot2Data() {
            return new Ieee1609Dot2Data(this.protocolVersion, this.f22648content);
        }

        public InnerEcRequestSignedForPop createInnerEcRequestSignedForPop() {
            return new InnerEcRequestSignedForPop(this.f22648content);
        }

        public C5926Builder setContent(Ieee1609Dot2Content ieee1609Dot2Content) {
            this.f22648content = ieee1609Dot2Content;
            return this;
        }

        public C5926Builder setProtocolVersion(C5976UINT8 c5976uint8) {
            this.protocolVersion = c5976uint8;
            return this;
        }
    }

    public Ieee1609Dot2Data(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        Iterator<ASN1Encodable> it = ASN1Sequence.getInstance(aSN1Sequence).iterator();
        this.protocolVersion = C5976UINT8.getInstance(it.next());
        this.f22647content = Ieee1609Dot2Content.getInstance(it.next());
    }

    /* renamed from: builder */
    public static C5926Builder m17230builder() {
        return new C5926Builder();
    }

    public static Ieee1609Dot2Data getInstance(Object obj) {
        if (obj instanceof Ieee1609Dot2Data) {
            return (Ieee1609Dot2Data) obj;
        }
        if (obj != null) {
            return new Ieee1609Dot2Data(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Ieee1609Dot2Content getContent() {
        return this.f22647content;
    }

    public C5976UINT8 getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.protocolVersion, this.f22647content);
    }

    public Ieee1609Dot2Data(C5976UINT8 c5976uint8, Ieee1609Dot2Content ieee1609Dot2Content) {
        this.protocolVersion = c5976uint8;
        this.f22647content = ieee1609Dot2Content;
    }
}
