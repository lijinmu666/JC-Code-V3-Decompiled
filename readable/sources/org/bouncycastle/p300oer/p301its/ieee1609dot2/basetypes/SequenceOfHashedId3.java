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
public class SequenceOfHashedId3 extends ASN1Object {
    private final List<HashedId3> hashedId3s;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfHashedId3$Builder */
    public static class C5961Builder {

        /* renamed from: items */
        private final List<HashedId3> f22759items = new ArrayList();

        public C5961Builder addHashId3(HashedId3... hashedId3Arr) {
            this.f22759items.addAll(Arrays.asList(hashedId3Arr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfHashedId3 m17324build() {
            return new SequenceOfHashedId3(this.f22759items);
        }
    }

    public SequenceOfHashedId3(List<HashedId3> list) {
        this.hashedId3s = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5961Builder m17323builder() {
        return new C5961Builder();
    }

    public static SequenceOfHashedId3 getInstance(Object obj) {
        if (obj instanceof SequenceOfHashedId3) {
            return (SequenceOfHashedId3) obj;
        }
        if (obj != null) {
            return new SequenceOfHashedId3(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<HashedId3> getHashedId3s() {
        return this.hashedId3s;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.hashedId3s.toArray(new ASN1Encodable[0]));
    }

    private SequenceOfHashedId3(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(HashedId3.getInstance(it.next()));
        }
        this.hashedId3s = Collections.unmodifiableList(arrayList);
    }
}
