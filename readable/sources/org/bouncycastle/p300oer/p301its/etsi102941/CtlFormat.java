package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.C5916Version;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class CtlFormat extends ASN1Object {
    private final SequenceOfCtlCommand ctlCommands;
    private final C5976UINT8 ctlSequence;
    private final ASN1Boolean isFullCtl;
    private final C5969Time32 nextUpdate;

    /* renamed from: version */
    private final C5916Version f22589version;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.CtlFormat$Builder */
    public static class C5899Builder {
        private SequenceOfCtlCommand ctlCommands;
        private C5976UINT8 ctlSequence;
        private ASN1Boolean isFullCtl;
        private C5969Time32 nextUpdate;

        /* renamed from: version */
        private C5916Version f22590version;

        public CtlFormat createCtlFormat() {
            return new CtlFormat(this.f22590version, this.nextUpdate, this.isFullCtl, this.ctlSequence, this.ctlCommands);
        }

        public DeltaCtl createDeltaCtl() {
            ASN1Boolean aSN1Boolean = this.isFullCtl;
            if (aSN1Boolean == null || !ASN1Boolean.f17898TRUE.m14446equals((ASN1Primitive) aSN1Boolean)) {
                return new DeltaCtl(this.f22590version, this.nextUpdate, this.ctlSequence, this.ctlCommands);
            }
            throw new IllegalArgumentException("isFullCtl must be false for DeltaCtl");
        }

        public C5903FullCtl createFullCtl() {
            return new C5903FullCtl(this.f22590version, this.nextUpdate, this.isFullCtl, this.ctlSequence, this.ctlCommands);
        }

        public ToBeSignedRcaCtl createToBeSignedRcaCtl() {
            return new ToBeSignedRcaCtl(this.f22590version, this.nextUpdate, this.isFullCtl, this.ctlSequence, this.ctlCommands);
        }

        public C5899Builder setCtlCommands(SequenceOfCtlCommand sequenceOfCtlCommand) {
            this.ctlCommands = sequenceOfCtlCommand;
            return this;
        }

        public C5899Builder setCtlSequence(ASN1Integer aSN1Integer) {
            this.ctlSequence = new C5976UINT8(aSN1Integer.getValue());
            return this;
        }

        public C5899Builder setIsFullCtl(ASN1Boolean aSN1Boolean) {
            this.isFullCtl = aSN1Boolean;
            return this;
        }

        public C5899Builder setNextUpdate(C5969Time32 c5969Time32) {
            this.nextUpdate = c5969Time32;
            return this;
        }

        public C5899Builder setVersion(C5916Version c5916Version) {
            this.f22590version = c5916Version;
            return this;
        }

        public C5899Builder setCtlSequence(C5976UINT8 c5976uint8) {
            this.ctlSequence = c5976uint8;
            return this;
        }
    }

    public CtlFormat(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("expected sequence size of 5");
        }
        this.f22589version = C5916Version.getInstance(aSN1Sequence.getObjectAt(0));
        this.nextUpdate = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.isFullCtl = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(2));
        this.ctlSequence = C5976UINT8.getInstance(aSN1Sequence.getObjectAt(3));
        this.ctlCommands = SequenceOfCtlCommand.getInstance(aSN1Sequence.getObjectAt(4));
    }

    /* renamed from: builder */
    public static C5899Builder m17185builder() {
        return new C5899Builder();
    }

    public static CtlFormat getInstance(Object obj) {
        if (obj instanceof CtlFormat) {
            return (CtlFormat) obj;
        }
        if (obj != null) {
            return new CtlFormat(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SequenceOfCtlCommand getCtlCommands() {
        return this.ctlCommands;
    }

    public C5976UINT8 getCtlSequence() {
        return this.ctlSequence;
    }

    public ASN1Boolean getIsFullCtl() {
        return this.isFullCtl;
    }

    public C5969Time32 getNextUpdate() {
        return this.nextUpdate;
    }

    public C5916Version getVersion() {
        return this.f22589version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22589version, this.nextUpdate, this.isFullCtl, this.ctlSequence, this.ctlCommands});
    }

    public CtlFormat(C5916Version c5916Version, C5969Time32 c5969Time32, ASN1Boolean aSN1Boolean, C5976UINT8 c5976uint8, SequenceOfCtlCommand sequenceOfCtlCommand) {
        this.f22589version = c5916Version;
        this.nextUpdate = c5969Time32;
        this.isFullCtl = aSN1Boolean;
        this.ctlSequence = c5976uint8;
        this.ctlCommands = sequenceOfCtlCommand;
    }
}
