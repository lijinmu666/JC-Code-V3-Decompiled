package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class CtlDelete extends ASN1Object implements ASN1Choice {

    /* renamed from: cert */
    public static final int f22580cert = 0;

    /* renamed from: dc */
    public static final int f22581dc = 1;

    /* renamed from: choice */
    private final int f22582choice;
    private final ASN1Encodable ctlDelete;

    public CtlDelete(int i, ASN1Encodable aSN1Encodable) {
        ASN1Encodable hashedId8;
        this.f22582choice = i;
        if (i == 0) {
            hashedId8 = HashedId8.getInstance(aSN1Encodable);
        } else {
            if (i != 1) {
                throw new IllegalArgumentException("invalid choice value " + i);
            }
            hashedId8 = DcDelete.getInstance(aSN1Encodable);
        }
        this.ctlDelete = hashedId8;
    }

    /* renamed from: cert */
    public static CtlDelete m17178cert(HashedId8 hashedId8) {
        return new CtlDelete(0, hashedId8);
    }

    /* renamed from: dc */
    public static CtlDelete m17179dc(DcDelete dcDelete) {
        return new CtlDelete(1, dcDelete);
    }

    public static CtlDelete getInstance(Object obj) {
        if (obj instanceof CtlDelete) {
            return (CtlDelete) obj;
        }
        if (obj != null) {
            return new CtlDelete(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22582choice;
    }

    public ASN1Encodable getCtlDelete() {
        return this.ctlDelete;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22582choice, this.ctlDelete);
    }

    private CtlDelete(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getExplicitBaseObject());
    }
}
