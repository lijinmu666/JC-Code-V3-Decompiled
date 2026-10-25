package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class CtlEntry extends ASN1Object implements ASN1Choice {

    /* renamed from: aa */
    public static final int f22583aa = 2;

    /* renamed from: dc */
    public static final int f22584dc = 3;

    /* renamed from: ea */
    public static final int f22585ea = 1;

    /* renamed from: rca */
    public static final int f22586rca = 0;

    /* renamed from: tlm */
    public static final int f22587tlm = 4;

    /* renamed from: choice */
    private final int f22588choice;
    private final ASN1Encodable ctlEntry;

    public CtlEntry(int i, ASN1Encodable aSN1Encodable) {
        this.f22588choice = i;
        this.ctlEntry = aSN1Encodable;
    }

    /* renamed from: aa */
    public static CtlEntry m17180aa(C5895AaEntry c5895AaEntry) {
        return new CtlEntry(2, c5895AaEntry);
    }

    /* renamed from: dc */
    public static CtlEntry m17181dc(C5900DcEntry c5900DcEntry) {
        return new CtlEntry(3, c5900DcEntry);
    }

    /* renamed from: ea */
    public static CtlEntry m17182ea(C5901EaEntry c5901EaEntry) {
        return new CtlEntry(1, c5901EaEntry);
    }

    public static CtlEntry getInstance(Object obj) {
        if (obj instanceof CtlEntry) {
            return (CtlEntry) obj;
        }
        if (obj != null) {
            return new CtlEntry(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: rca */
    public static CtlEntry m17183rca(RootCaEntry rootCaEntry) {
        return new CtlEntry(0, rootCaEntry);
    }

    /* renamed from: tlm */
    public static CtlEntry m17184tlm(TlmEntry tlmEntry) {
        return new CtlEntry(4, tlmEntry);
    }

    public int getChoice() {
        return this.f22588choice;
    }

    public ASN1Encodable getCtlEntry() {
        return this.ctlEntry;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22588choice, this.ctlEntry);
    }

    private CtlEntry(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable rootCaEntry;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22588choice = tagNo;
        if (tagNo == 0) {
            rootCaEntry = RootCaEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            rootCaEntry = C5901EaEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 2) {
            rootCaEntry = C5895AaEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 3) {
            rootCaEntry = C5900DcEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 4) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            rootCaEntry = TlmEntry.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.ctlEntry = rootCaEntry;
    }
}
