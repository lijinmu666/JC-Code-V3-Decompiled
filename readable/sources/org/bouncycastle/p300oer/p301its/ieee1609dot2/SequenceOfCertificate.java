package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class SequenceOfCertificate extends ASN1Object {
    private final List<Certificate> certificates;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SequenceOfCertificate$Builder */
    public static class C5932Builder {
        List<Certificate> certificates = new ArrayList();

        /* renamed from: add */
        public C5932Builder m17238add(Certificate... certificateArr) {
            this.certificates.addAll(Arrays.asList(certificateArr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfCertificate m17239build() {
            return new SequenceOfCertificate(this.certificates);
        }
    }

    public SequenceOfCertificate(List<Certificate> list) {
        this.certificates = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5932Builder m17237builder() {
        return new C5932Builder();
    }

    public static SequenceOfCertificate getInstance(Object obj) {
        if (obj instanceof SequenceOfCertificate) {
            return (SequenceOfCertificate) obj;
        }
        if (obj != null) {
            return new SequenceOfCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<Certificate> getCertificates() {
        return this.certificates;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.certificates);
    }

    private SequenceOfCertificate(ASN1Sequence aSN1Sequence) {
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(Certificate.getInstance((Object) it.next()));
        }
        this.certificates = Collections.unmodifiableList(arrayList);
    }
}
