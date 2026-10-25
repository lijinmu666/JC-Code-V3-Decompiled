package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class SequenceOfPsid extends ASN1Object {

    /* renamed from: psids */
    private final List<C5954Psid> f22761psids;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfPsid$Builder */
    public static class C5963Builder {

        /* renamed from: items */
        private List<C5954Psid> f22762items = new ArrayList();

        public SequenceOfPsid createSequenceOfPsidSsp() {
            return new SequenceOfPsid(this.f22762items);
        }

        /* renamed from: setItem */
        public C5963Builder m17328setItem(C5954Psid... c5954PsidArr) {
            for (int i = 0; i != c5954PsidArr.length; i++) {
                this.f22762items.add(c5954PsidArr[i]);
            }
            return this;
        }

        public C5963Builder setItems(List<C5954Psid> list) {
            this.f22762items = list;
            return this;
        }
    }

    public SequenceOfPsid(List<C5954Psid> list) {
        this.f22761psids = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5963Builder m17327builder() {
        return new C5963Builder();
    }

    public static SequenceOfPsid getInstance(Object obj) {
        if (obj instanceof SequenceOfPsid) {
            return (SequenceOfPsid) obj;
        }
        if (obj != null) {
            return new SequenceOfPsid(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<C5954Psid> getPsids() {
        return this.f22761psids;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22761psids);
    }

    private SequenceOfPsid(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(C5954Psid.getInstance(it.next()));
        }
        this.f22761psids = Collections.unmodifiableList(arrayList);
    }
}
