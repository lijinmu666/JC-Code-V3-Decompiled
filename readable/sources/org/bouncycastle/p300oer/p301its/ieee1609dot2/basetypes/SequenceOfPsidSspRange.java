package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class SequenceOfPsidSspRange extends ASN1Object {
    private final List<PsidSspRange> psidSspRanges;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfPsidSspRange$Builder */
    public static class C5965Builder {
        private final ArrayList<PsidSspRange> psidSspRanges = new ArrayList<>();

        /* renamed from: add */
        public C5965Builder m17332add(PsidSspRange... psidSspRangeArr) {
            this.psidSspRanges.addAll(Arrays.asList(psidSspRangeArr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfPsidSspRange m17333build() {
            return new SequenceOfPsidSspRange(this.psidSspRanges);
        }
    }

    public SequenceOfPsidSspRange(List<PsidSspRange> list) {
        this.psidSspRanges = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5965Builder m17331builder() {
        return new C5965Builder();
    }

    public static SequenceOfPsidSspRange getInstance(Object obj) {
        if (obj instanceof SequenceOfPsidSspRange) {
            return (SequenceOfPsidSspRange) obj;
        }
        if (obj != null) {
            return new SequenceOfPsidSspRange(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<PsidSspRange> getPsidSspRanges() {
        return this.psidSspRanges;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator<PsidSspRange> it = this.psidSspRanges.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(it.next());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private SequenceOfPsidSspRange(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(PsidSspRange.getInstance(it.next()));
        }
        this.psidSspRanges = Collections.unmodifiableList(arrayList);
    }
}
