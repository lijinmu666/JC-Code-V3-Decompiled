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
public class SequenceOfPsidSsp extends ASN1Object {
    private final List<C5955PsidSsp> psidSsps;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfPsidSsp$Builder */
    public static class C5964Builder {

        /* renamed from: items */
        private List<C5955PsidSsp> f22763items = new ArrayList();

        public SequenceOfPsidSsp createSequenceOfPsidSsp() {
            return new SequenceOfPsidSsp(this.f22763items);
        }

        /* renamed from: setItem */
        public C5964Builder m17330setItem(C5955PsidSsp... c5955PsidSspArr) {
            for (int i = 0; i != c5955PsidSspArr.length; i++) {
                this.f22763items.add(c5955PsidSspArr[i]);
            }
            return this;
        }

        public C5964Builder setItems(List<C5955PsidSsp> list) {
            this.f22763items = list;
            return this;
        }
    }

    public SequenceOfPsidSsp(List<C5955PsidSsp> list) {
        this.psidSsps = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5964Builder m17329builder() {
        return new C5964Builder();
    }

    public static SequenceOfPsidSsp getInstance(Object obj) {
        if (obj instanceof SequenceOfPsidSsp) {
            return (SequenceOfPsidSsp) obj;
        }
        if (obj != null) {
            return new SequenceOfPsidSsp(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<C5955PsidSsp> getPsidSsps() {
        return this.psidSsps;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.psidSsps);
    }

    private SequenceOfPsidSsp(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(C5955PsidSsp.getInstance(it.next()));
        }
        this.psidSsps = Collections.unmodifiableList(arrayList);
    }
}
