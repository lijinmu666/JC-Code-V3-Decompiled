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
public class SequenceOfHashedId8 extends ASN1Object {
    private final List<HashedId8> hashedId8s;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfHashedId8$Builder */
    public static class C5962Builder {

        /* renamed from: items */
        private final List<HashedId8> f22760items = new ArrayList();

        public C5962Builder addHashId8(HashedId8... hashedId8Arr) {
            this.f22760items.addAll(Arrays.asList(hashedId8Arr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfHashedId8 m17326build() {
            return new SequenceOfHashedId8(this.f22760items);
        }
    }

    public SequenceOfHashedId8(List<HashedId8> list) {
        this.hashedId8s = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5962Builder m17325builder() {
        return new C5962Builder();
    }

    public static SequenceOfHashedId8 getInstance(Object obj) {
        if (obj instanceof SequenceOfHashedId8) {
            return (SequenceOfHashedId8) obj;
        }
        if (obj != null) {
            return new SequenceOfHashedId8(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<HashedId8> getHashedId8s() {
        return this.hashedId8s;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.hashedId8s.toArray(new ASN1Encodable[0]));
    }

    private SequenceOfHashedId8(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(HashedId8.getInstance(it.next()));
        }
        this.hashedId8s = Collections.unmodifiableList(arrayList);
    }
}
