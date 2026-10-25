package org.bouncycastle.p300oer.p301its.ieee1609dot2;

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
public class SequenceOfRecipientInfo extends ASN1Object {
    private final List<RecipientInfo> recipientInfos;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SequenceOfRecipientInfo$Builder */
    public static class C5934Builder {
        private List<RecipientInfo> recipientInfos;

        public C5934Builder addRecipients(RecipientInfo... recipientInfoArr) {
            if (this.recipientInfos == null) {
                this.recipientInfos = new ArrayList();
            }
            this.recipientInfos.addAll(Arrays.asList(recipientInfoArr));
            return this;
        }

        public SequenceOfRecipientInfo createSequenceOfRecipientInfo() {
            return new SequenceOfRecipientInfo(this.recipientInfos);
        }

        public C5934Builder setRecipientInfos(List<RecipientInfo> list) {
            this.recipientInfos = list;
            return this;
        }
    }

    public SequenceOfRecipientInfo(List<RecipientInfo> list) {
        this.recipientInfos = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5934Builder m17241builder() {
        return new C5934Builder();
    }

    public static SequenceOfRecipientInfo getInstance(Object obj) {
        if (obj instanceof SequenceOfRecipientInfo) {
            return (SequenceOfRecipientInfo) obj;
        }
        if (obj != null) {
            return new SequenceOfRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<RecipientInfo> getRecipientInfos() {
        return this.recipientInfos;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator<RecipientInfo> it = this.recipientInfos.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(it.next());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private SequenceOfRecipientInfo(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(RecipientInfo.getInstance(it.next()));
        }
        this.recipientInfos = Collections.unmodifiableList(arrayList);
    }
}
