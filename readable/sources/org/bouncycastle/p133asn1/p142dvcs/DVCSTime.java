package org.bouncycastle.p133asn1.p142dvcs;

import java.util.Date;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;

/* loaded from: classes2.dex */
public class DVCSTime extends ASN1Object implements ASN1Choice {

    /* renamed from: genTime */
    private final ASN1GeneralizedTime f18316genTime;
    private final ContentInfo timeStampToken;

    public DVCSTime(Date date) {
        this(new ASN1GeneralizedTime(date));
    }

    public static DVCSTime getInstance(Object obj) {
        if (obj instanceof DVCSTime) {
            return (DVCSTime) obj;
        }
        if (obj instanceof ASN1GeneralizedTime) {
            return new DVCSTime(ASN1GeneralizedTime.getInstance(obj));
        }
        if (obj != null) {
            return new DVCSTime(ContentInfo.getInstance(obj));
        }
        return null;
    }

    public ASN1GeneralizedTime getGenTime() {
        return this.f18316genTime;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18316genTime;
        return aSN1GeneralizedTime != null ? aSN1GeneralizedTime : this.timeStampToken.toASN1Primitive();
    }

    public String toString() {
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18316genTime;
        return aSN1GeneralizedTime != null ? aSN1GeneralizedTime.toString() : this.timeStampToken.toString();
    }

    public DVCSTime(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.f18316genTime = aSN1GeneralizedTime;
        this.timeStampToken = null;
    }

    public static DVCSTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(ASN1TaggedObject.getContextInstance(aSN1TaggedObject).getExplicitBaseObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public DVCSTime(ContentInfo contentInfo) {
        this.f18316genTime = null;
        this.timeStampToken = contentInfo;
    }
}
