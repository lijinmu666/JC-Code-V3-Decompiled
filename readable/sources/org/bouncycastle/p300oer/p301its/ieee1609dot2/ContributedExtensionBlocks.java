package org.bouncycastle.p300oer.p301its.ieee1609dot2;

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
public class ContributedExtensionBlocks extends ASN1Object {
    private final List<ContributedExtensionBlock> contributedExtensionBlocks;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.ContributedExtensionBlocks$Builder */
    public static class C5923Builder {
        private final List<ContributedExtensionBlock> extensionBlocks = new ArrayList();

        /* renamed from: add */
        public C5923Builder m17223add(ContributedExtensionBlock... contributedExtensionBlockArr) {
            this.extensionBlocks.addAll(Arrays.asList(contributedExtensionBlockArr));
            return this;
        }

        /* renamed from: build */
        public ContributedExtensionBlocks m17224build() {
            return new ContributedExtensionBlocks(this.extensionBlocks);
        }
    }

    public ContributedExtensionBlocks(List<ContributedExtensionBlock> list) {
        this.contributedExtensionBlocks = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5923Builder m17221builder() {
        return new C5923Builder();
    }

    public static ContributedExtensionBlocks getInstance(Object obj) {
        if (obj instanceof ContributedExtensionBlocks) {
            return (ContributedExtensionBlocks) obj;
        }
        if (obj != null) {
            return new ContributedExtensionBlocks(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<ContributedExtensionBlock> getContributedExtensionBlocks() {
        return this.contributedExtensionBlocks;
    }

    /* renamed from: size */
    public int m17222size() {
        return this.contributedExtensionBlocks.size();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.contributedExtensionBlocks.toArray(new ContributedExtensionBlock[0]));
    }

    private ContributedExtensionBlocks(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(ContributedExtensionBlock.getInstance(it.next()));
        }
        this.contributedExtensionBlocks = Collections.unmodifiableList(arrayList);
    }
}
