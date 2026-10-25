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
public class SequenceOfPsidGroupPermissions extends ASN1Object {
    private final List<PsidGroupPermissions> psidGroupPermissions;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SequenceOfPsidGroupPermissions$Builder */
    public static class C5933Builder {
        private final List<PsidGroupPermissions> groupPermissions = new ArrayList();

        public C5933Builder addGroupPermission(PsidGroupPermissions... psidGroupPermissionsArr) {
            this.groupPermissions.addAll(Arrays.asList(psidGroupPermissionsArr));
            return this;
        }

        public SequenceOfPsidGroupPermissions createSequenceOfPsidGroupPermissions() {
            return new SequenceOfPsidGroupPermissions(this.groupPermissions);
        }

        public C5933Builder setGroupPermissions(List<PsidGroupPermissions> list) {
            this.groupPermissions.addAll(list);
            return this;
        }
    }

    public SequenceOfPsidGroupPermissions(List<PsidGroupPermissions> list) {
        this.psidGroupPermissions = Collections.unmodifiableList(list);
    }

    /* renamed from: builder */
    public static C5933Builder m17240builder() {
        return new C5933Builder();
    }

    public static SequenceOfPsidGroupPermissions getInstance(Object obj) {
        if (obj instanceof SequenceOfPsidGroupPermissions) {
            return (SequenceOfPsidGroupPermissions) obj;
        }
        if (obj != null) {
            return new SequenceOfPsidGroupPermissions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<PsidGroupPermissions> getPsidGroupPermissions() {
        return this.psidGroupPermissions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.psidGroupPermissions.toArray(new PsidGroupPermissions[0]));
    }

    private SequenceOfPsidGroupPermissions(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(PsidGroupPermissions.getInstance(it.next()));
        }
        this.psidGroupPermissions = Collections.unmodifiableList(arrayList);
    }
}
