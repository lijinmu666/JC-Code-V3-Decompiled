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
public class SequenceOfCtlCommand extends ASN1Object {
    private final List<CtlCommand> ctlCommands;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.SequenceOfCtlCommand$Builder */
    public static class C5910Builder {

        /* renamed from: items */
        private final List<CtlCommand> f22605items = new ArrayList();

        public C5910Builder addHashId8(CtlCommand... ctlCommandArr) {
            this.f22605items.addAll(Arrays.asList(ctlCommandArr));
            return this;
        }

        /* renamed from: build */
        public SequenceOfCtlCommand m17201build() {
            return new SequenceOfCtlCommand(this.f22605items);
        }
    }

    public SequenceOfCtlCommand(List<CtlCommand> list) {
        this.ctlCommands = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5910Builder m17200builder() {
        return new C5910Builder();
    }

    public static SequenceOfCtlCommand getInstance(Object obj) {
        if (obj instanceof SequenceOfCtlCommand) {
            return (SequenceOfCtlCommand) obj;
        }
        if (obj != null) {
            return new SequenceOfCtlCommand(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<CtlCommand> getCtlCommands() {
        return this.ctlCommands;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.ctlCommands.toArray(new ASN1Encodable[0]));
    }

    private SequenceOfCtlCommand(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(CtlCommand.getInstance(it.next()));
        }
        this.ctlCommands = Collections.unmodifiableList(arrayList);
    }
}
