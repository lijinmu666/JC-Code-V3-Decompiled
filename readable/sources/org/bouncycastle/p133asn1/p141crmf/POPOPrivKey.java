package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;

/* loaded from: classes2.dex */
public class POPOPrivKey extends ASN1Object implements ASN1Choice {
    public static final int agreeMAC = 3;

    /* renamed from: dhMAC */
    public static final int f18265dhMAC = 2;
    public static final int encryptedKey = 4;
    public static final int subsequentMessage = 1;
    public static final int thisMessage = 0;

    /* renamed from: obj */
    private ASN1Encodable f18266obj;

    /* renamed from: tagNo */
    private int f18267tagNo;

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private POPOPrivKey(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1BitString;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f18267tagNo = tagNo;
        if (tagNo == 0) {
            aSN1BitString = ASN1BitString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 1) {
            aSN1BitString = SubsequentMessage.m14568valueOf(ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact());
        } else if (tagNo != 2) {
            if (tagNo == 3) {
                aSN1BitString = PKMACValue.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 4) {
                    throw new IllegalArgumentException("unknown tag in POPOPrivKey");
                }
                aSN1BitString = EnvelopedData.getInstance(aSN1TaggedObject, false);
            }
        }
        this.f18266obj = aSN1BitString;
    }

    public static POPOPrivKey getInstance(Object obj) {
        if (obj instanceof POPOPrivKey) {
            return (POPOPrivKey) obj;
        }
        if (obj != null) {
            return new POPOPrivKey(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getType */
    public int m14566getType() {
        return this.f18267tagNo;
    }

    public ASN1Encodable getValue() {
        return this.f18266obj;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18267tagNo, this.f18266obj);
    }

    public POPOPrivKey(PKMACValue pKMACValue) {
        this.f18267tagNo = 3;
        this.f18266obj = pKMACValue;
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, true));
    }

    public POPOPrivKey(SubsequentMessage subsequentMessage2) {
        this.f18267tagNo = 1;
        this.f18266obj = subsequentMessage2;
    }
}
