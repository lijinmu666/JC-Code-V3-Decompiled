package org.bouncycastle.p300oer.p301its.etsi102941;

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
public class SequenceOfCrlEntry extends ASN1Object {
    private final List<CrlEntry> crlEntries;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.SequenceOfCrlEntry$Builder */
    public static class C5909Builder {

        /* renamed from: items */
        private final List<CrlEntry> f22604items = new ArrayList();

        public C5909Builder addCrlEntry(CrlEntry... crlEntryArr) {
            this.f22604items.addAll(Arrays.asList(crlEntryArr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfCrlEntry m17199build() {
            return new SequenceOfCrlEntry(this.f22604items);
        }
    }

    public SequenceOfCrlEntry(List<CrlEntry> list) {
        this.crlEntries = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5909Builder m17198builder() {
        return new C5909Builder();
    }

    public static SequenceOfCrlEntry getInstance(Object obj) {
        if (obj instanceof SequenceOfCrlEntry) {
            return (SequenceOfCrlEntry) obj;
        }
        if (obj != null) {
            return new SequenceOfCrlEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<CrlEntry> getCrlEntries() {
        return this.crlEntries;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.crlEntries.toArray(new ASN1Encodable[0]));
    }

    private SequenceOfCrlEntry(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(CrlEntry.getInstance(it.next()));
        }
        this.crlEntries = Collections.unmodifiableList(arrayList);
    }
}
