package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class SequenceOfUint16 extends ASN1Object {

    /* renamed from: uint16s */
    private final List<C5972UINT16> f22764uint16s;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfUint16$Builder */
    public static class C5966Builder {

        /* renamed from: items */
        private final List<C5972UINT16> f22765items = new ArrayList();

        public C5966Builder addHashId3(C5972UINT16... c5972uint16Arr) {
            this.f22765items.addAll(Arrays.asList(c5972uint16Arr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfUint16 m17335build() {
            return new SequenceOfUint16(this.f22765items);
        }
    }

    public SequenceOfUint16(List<C5972UINT16> list) {
        this.f22764uint16s = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5966Builder m17334builder() {
        return new C5966Builder();
    }

    public static SequenceOfUint16 getInstance(Object obj) {
        if (obj instanceof SequenceOfUint16) {
            return (SequenceOfUint16) obj;
        }
        if (obj != null) {
            return new SequenceOfUint16(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<C5972UINT16> getUint16s() {
        return this.f22764uint16s;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.f22764uint16s.toArray(new ASN1Encodable[0]));
    }

    private SequenceOfUint16(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(C5972UINT16.getInstance(it.next()));
        }
        this.f22764uint16s = Collections.unmodifiableList(arrayList);
    }
}
