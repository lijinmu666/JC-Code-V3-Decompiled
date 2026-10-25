package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class CtlCommand extends ASN1Object implements ASN1Choice {

    /* renamed from: add */
    public static final int f22577add = 0;

    /* renamed from: delete */
    public static final int f22578delete = 1;

    /* renamed from: choice */
    private final int f22579choice;
    private final ASN1Encodable ctlCommand;

    public CtlCommand(int i, ASN1Encodable aSN1Encodable) {
        this.f22579choice = i;
        this.ctlCommand = aSN1Encodable;
    }

    /* renamed from: add */
    public static CtlCommand m17176add(CtlEntry ctlEntry) {
        return new CtlCommand(0, ctlEntry);
    }

    /* renamed from: delete */
    public static CtlCommand m17177delete(CtlDelete ctlDelete) {
        return new CtlCommand(1, ctlDelete);
    }

    public static CtlCommand getInstance(Object obj) {
        if (obj instanceof CtlCommand) {
            return (CtlCommand) obj;
        }
        if (obj != null) {
            return new CtlCommand(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22579choice;
    }

    public ASN1Encodable getCtlCommand() {
        return this.ctlCommand;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22579choice, this.ctlCommand);
    }

    private CtlCommand(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable ctlEntry;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22579choice = tagNo;
        if (tagNo == 0) {
            ctlEntry = CtlEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            ctlEntry = CtlDelete.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.ctlCommand = ctlEntry;
    }
}
