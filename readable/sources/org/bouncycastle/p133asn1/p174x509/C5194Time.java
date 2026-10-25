package org.bouncycastle.p133asn1.p174x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.DERGeneralizedTime;
import org.bouncycastle.p133asn1.DERUTCTime;
import org.bouncycastle.p133asn1.LocaleUtil;

/* renamed from: org.bouncycastle.asn1.x509.Time */
/* loaded from: classes2.dex */
public class C5194Time extends ASN1Object implements ASN1Choice {

    /* renamed from: time */
    ASN1Primitive f18697time;

    public C5194Time(Date date) throws NumberFormatException {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", LocaleUtil.EN_Locale);
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i = Integer.parseInt(str.substring(0, 4));
        this.f18697time = (i < 1950 || i > 2049) ? new DERGeneralizedTime(str) : new DERUTCTime(str.substring(2));
    }

    public static C5194Time getInstance(Object obj) {
        if (obj == null || (obj instanceof C5194Time)) {
            return (C5194Time) obj;
        }
        if (obj instanceof ASN1UTCTime) {
            return new C5194Time((ASN1UTCTime) obj);
        }
        if (obj instanceof ASN1GeneralizedTime) {
            return new C5194Time((ASN1GeneralizedTime) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    /* renamed from: getDate */
    public Date m14707getDate() {
        try {
            ASN1Primitive aSN1Primitive = this.f18697time;
            return aSN1Primitive instanceof ASN1UTCTime ? ((ASN1UTCTime) aSN1Primitive).getAdjustedDate() : ((ASN1GeneralizedTime) aSN1Primitive).m14427getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    /* renamed from: getTime */
    public String m14708getTime() {
        ASN1Primitive aSN1Primitive = this.f18697time;
        return aSN1Primitive instanceof ASN1UTCTime ? ((ASN1UTCTime) aSN1Primitive).getAdjustedTime() : ((ASN1GeneralizedTime) aSN1Primitive).m14428getTime();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18697time;
    }

    public String toString() {
        return m14708getTime();
    }

    public C5194Time(Date date, Locale locale) throws NumberFormatException {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", locale);
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i = Integer.parseInt(str.substring(0, 4));
        this.f18697time = (i < 1950 || i > 2049) ? new DERGeneralizedTime(str) : new DERUTCTime(str.substring(2));
    }

    public static C5194Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public C5194Time(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTCTime) && !(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.f18697time = aSN1Primitive;
    }
}
