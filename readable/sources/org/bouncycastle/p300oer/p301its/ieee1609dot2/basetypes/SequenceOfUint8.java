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
public class SequenceOfUint8 extends ASN1Object {

    /* renamed from: uint8s */
    private final List<C5976UINT8> f22766uint8s;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfUint8$Builder */
    public static class C5967Builder {

        /* renamed from: items */
        private final List<C5976UINT8> f22767items = new ArrayList();

        public C5967Builder addHashId3(C5976UINT8... c5976uint8Arr) {
            this.f22767items.addAll(Arrays.asList(c5976uint8Arr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfUint8 m17337build() {
            return new SequenceOfUint8(this.f22767items);
        }
    }

    public SequenceOfUint8(List<C5976UINT8> list) {
        this.f22766uint8s = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5967Builder m17336builder() {
        return new C5967Builder();
    }

    public static SequenceOfUint8 getInstance(Object obj) {
        if (obj instanceof SequenceOfUint8) {
            return (SequenceOfUint8) obj;
        }
        if (obj != null) {
            return new SequenceOfUint8(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<C5976UINT8> getUint8s() {
        return this.f22766uint8s;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator<C5976UINT8> it = this.f22766uint8s.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(it.next().toASN1Primitive());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private SequenceOfUint8(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(C5976UINT8.getInstance(it.next()));
        }
        this.f22766uint8s = Collections.unmodifiableList(arrayList);
    }
}
