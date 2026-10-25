package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.C5916Version;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;

/* loaded from: classes2.dex */
public class ToBeSignedCrl extends ASN1Object {

    /* renamed from: entries */
    private final SequenceOfCrlEntry f22610entries;
    private final C5969Time32 nextUpdate;
    private final C5969Time32 thisUpdate;

    /* renamed from: version */
    private final C5916Version f22611version;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.ToBeSignedCrl$Builder */
    public static class C5913Builder {

        /* renamed from: entries */
        private SequenceOfCrlEntry f22612entries;
        private C5969Time32 nextUpdate;
        private C5969Time32 thisUpdate;

        /* renamed from: version */
        private C5916Version f22613version;

        public ToBeSignedCrl createToBeSignedCrl() {
            return new ToBeSignedCrl(this.f22613version, this.thisUpdate, this.nextUpdate, this.f22612entries);
        }

        public C5913Builder setEntries(SequenceOfCrlEntry sequenceOfCrlEntry) {
            this.f22612entries = sequenceOfCrlEntry;
            return this;
        }

        public C5913Builder setNextUpdate(C5969Time32 c5969Time32) {
            this.nextUpdate = c5969Time32;
            return this;
        }

        public C5913Builder setThisUpdate(C5969Time32 c5969Time32) {
            this.thisUpdate = c5969Time32;
            return this;
        }

        public C5913Builder setVersion(C5916Version c5916Version) {
            this.f22613version = c5916Version;
            return this;
        }
    }

    private ToBeSignedCrl(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.f22611version = C5916Version.getInstance(aSN1Sequence.getObjectAt(0));
        this.thisUpdate = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.nextUpdate = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(2));
        this.f22610entries = SequenceOfCrlEntry.getInstance(aSN1Sequence.getObjectAt(3));
    }

    /* renamed from: builder */
    public static C5913Builder m17206builder() {
        return new C5913Builder();
    }

    public static ToBeSignedCrl getInstance(Object obj) {
        if (obj instanceof ToBeSignedCrl) {
            return (ToBeSignedCrl) obj;
        }
        if (obj != null) {
            return new ToBeSignedCrl(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SequenceOfCrlEntry getEntries() {
        return this.f22610entries;
    }

    public C5969Time32 getNextUpdate() {
        return this.nextUpdate;
    }

    public C5969Time32 getThisUpdate() {
        return this.thisUpdate;
    }

    public C5916Version getVersion() {
        return this.f22611version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22611version, this.thisUpdate, this.nextUpdate, this.f22610entries});
    }

    public ToBeSignedCrl(C5916Version c5916Version, C5969Time32 c5969Time32, C5969Time32 c5969Time322, SequenceOfCrlEntry sequenceOfCrlEntry) {
        this.f22611version = c5916Version;
        this.thisUpdate = c5969Time32;
        this.nextUpdate = c5969Time322;
        this.f22610entries = sequenceOfCrlEntry;
    }
}
