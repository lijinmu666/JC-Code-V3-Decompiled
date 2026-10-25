package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

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
public class BitmapSspRange extends ASN1Object {
    private final ASN1OctetString sspBitMask;
    private final ASN1OctetString sspValue;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.BitmapSspRange$Builder */
    public static class C5941Builder {
        private ASN1OctetString sspBitMask;
        private ASN1OctetString sspValue;

        public BitmapSspRange createBitmapSspRange() {
            return new BitmapSspRange(this.sspValue, this.sspBitMask);
        }

        public C5941Builder setSspBitMask(ASN1OctetString aSN1OctetString) {
            this.sspBitMask = aSN1OctetString;
            return this;
        }

        public C5941Builder setSspValue(ASN1OctetString aSN1OctetString) {
            this.sspValue = aSN1OctetString;
            return this;
        }

        public C5941Builder setSspBitMask(byte[] bArr) {
            this.sspBitMask = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }

        public C5941Builder setSspValue(byte[] bArr) {
            this.sspValue = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    public BitmapSspRange(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        this.sspValue = aSN1OctetString;
        this.sspBitMask = aSN1OctetString2;
    }

    /* renamed from: builder */
    public static C5941Builder m17254builder() {
        return new C5941Builder();
    }

    public static BitmapSspRange getInstance(Object obj) {
        if (obj instanceof BitmapSspRange) {
            return (BitmapSspRange) obj;
        }
        if (obj != null) {
            return new BitmapSspRange(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getSspBitMask() {
        return this.sspBitMask;
    }

    public ASN1OctetString getSspValue() {
        return this.sspValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.sspValue, this.sspBitMask);
    }

    private BitmapSspRange(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        this.sspValue = ASN1OctetString.getInstance(it.next());
        this.sspBitMask = ASN1OctetString.getInstance(it.next());
    }
}
