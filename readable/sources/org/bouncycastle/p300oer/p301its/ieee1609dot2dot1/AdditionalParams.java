package org.bouncycastle.p300oer.p301its.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;

/* loaded from: classes2.dex */
public class AdditionalParams extends ASN1Object implements ASN1Choice {
    public static final int compactUnified = 2;
    public static final int encryptionKey = 3;
    public static final int original = 0;

    /* renamed from: unified */
    public static final int f22783unified = 1;
    protected final ASN1Encodable additionalParams;

    /* renamed from: choice */
    protected final int f22784choice;

    private AdditionalParams(int i, ASN1Encodable aSN1Encodable) {
        ASN1Encodable butterflyParamsOriginal;
        if (i == 0) {
            butterflyParamsOriginal = ButterflyParamsOriginal.getInstance(aSN1Encodable);
        } else if (i == 1 || i == 2) {
            butterflyParamsOriginal = ButterflyExpansion.getInstance(aSN1Encodable);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException("invalid choice value " + i);
            }
            butterflyParamsOriginal = PublicEncryptionKey.getInstance(aSN1Encodable);
        }
        this.additionalParams = butterflyParamsOriginal;
        this.f22784choice = i;
    }

    public static AdditionalParams compactUnified(ButterflyExpansion butterflyExpansion) {
        return new AdditionalParams(2, butterflyExpansion);
    }

    public static AdditionalParams encryptionKey(PublicEncryptionKey publicEncryptionKey) {
        return new AdditionalParams(3, publicEncryptionKey);
    }

    public static AdditionalParams getInstance(Object obj) {
        if (obj instanceof AdditionalParams) {
            return (AdditionalParams) obj;
        }
        if (obj != null) {
            return new AdditionalParams(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static AdditionalParams original(ButterflyParamsOriginal butterflyParamsOriginal) {
        return new AdditionalParams(0, butterflyParamsOriginal);
    }

    /* renamed from: unified */
    public static AdditionalParams m17348unified(ButterflyExpansion butterflyExpansion) {
        return new AdditionalParams(1, butterflyExpansion);
    }

    public ASN1Encodable getAdditionalParams() {
        return this.additionalParams;
    }

    public int getChoice() {
        return this.f22784choice;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22784choice, this.additionalParams);
    }

    private AdditionalParams(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getExplicitBaseObject());
    }
}
