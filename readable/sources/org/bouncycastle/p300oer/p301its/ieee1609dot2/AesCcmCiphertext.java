package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.util.Iterator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class AesCcmCiphertext extends ASN1Object {
    private final C5929Opaque ccmCiphertext;

    /* renamed from: nonce */
    private final ASN1OctetString f22625nonce;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.AesCcmCiphertext$Builder */
    public static class C5921Builder {

        /* renamed from: nonce */
        private ASN1OctetString f22626nonce;

        /* renamed from: opaque */
        private C5929Opaque f22627opaque;

        public AesCcmCiphertext createAesCcmCiphertext() {
            return new AesCcmCiphertext(this.f22626nonce, this.f22627opaque);
        }

        public C5921Builder setCcmCiphertext(C5929Opaque c5929Opaque) {
            this.f22627opaque = c5929Opaque;
            return this;
        }

        public C5921Builder setNonce(ASN1OctetString aSN1OctetString) {
            this.f22626nonce = aSN1OctetString;
            return this;
        }

        public C5921Builder setCcmCiphertext(byte[] bArr) {
            return setCcmCiphertext(new C5929Opaque(bArr));
        }

        public C5921Builder setNonce(byte[] bArr) {
            return setNonce(new DEROctetString(C6238Arrays.m18231clone(bArr)));
        }
    }

    public AesCcmCiphertext(ASN1OctetString aSN1OctetString, C5929Opaque c5929Opaque) {
        this.f22625nonce = aSN1OctetString;
        this.ccmCiphertext = c5929Opaque;
    }

    /* renamed from: builder */
    public static C5921Builder m17215builder() {
        return new C5921Builder();
    }

    public static AesCcmCiphertext getInstance(Object obj) {
        if (obj instanceof AesCcmCiphertext) {
            return (AesCcmCiphertext) obj;
        }
        if (obj != null) {
            return new AesCcmCiphertext(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5929Opaque getCcmCiphertext() {
        return this.ccmCiphertext;
    }

    public ASN1OctetString getNonce() {
        return this.f22625nonce;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22625nonce, this.ccmCiphertext);
    }

    private AesCcmCiphertext(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        this.f22625nonce = ASN1OctetString.getInstance(it.next());
        this.ccmCiphertext = C5929Opaque.getInstance(it.next());
    }
}
