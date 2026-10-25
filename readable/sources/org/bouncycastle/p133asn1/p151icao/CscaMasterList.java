package org.bouncycastle.p133asn1.p151icao;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.Certificate;

/* loaded from: classes2.dex */
public class CscaMasterList extends ASN1Object {
    private Certificate[] certList;

    /* renamed from: version */
    private ASN1Integer f18404version;

    private CscaMasterList(ASN1Sequence aSN1Sequence) {
        this.f18404version = ASN1Integer.f17922ZERO;
        if (aSN1Sequence == null || aSN1Sequence.mo14450size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("Incorrect sequence size: " + aSN1Sequence.mo14450size());
        }
        int i = 0;
        this.f18404version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
        this.certList = new Certificate[abstractC5093ASN1Set.m14454size()];
        while (true) {
            Certificate[] certificateArr = this.certList;
            if (i >= certificateArr.length) {
                return;
            }
            certificateArr[i] = Certificate.getInstance(abstractC5093ASN1Set.getObjectAt(i));
            i++;
        }
    }

    private Certificate[] copyCertList(Certificate[] certificateArr) {
        int length = certificateArr.length;
        Certificate[] certificateArr2 = new Certificate[length];
        for (int i = 0; i != length; i++) {
            certificateArr2[i] = certificateArr[i];
        }
        return certificateArr2;
    }

    public static CscaMasterList getInstance(Object obj) {
        if (obj instanceof CscaMasterList) {
            return (CscaMasterList) obj;
        }
        if (obj != null) {
            return new CscaMasterList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Certificate[] getCertStructs() {
        return copyCertList(this.certList);
    }

    public int getVersion() {
        return this.f18404version.intValueExact();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18404version, new C5104DERSet(this.certList));
    }

    public CscaMasterList(Certificate[] certificateArr) {
        this.f18404version = ASN1Integer.f17922ZERO;
        this.certList = copyCertList(certificateArr);
    }
}
