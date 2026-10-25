package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class Duration extends ASN1Object implements ASN1Choice {

    /* renamed from: hours */
    public static final int f22699hours = 4;
    public static final int microseconds = 0;
    public static final int milliseconds = 1;

    /* renamed from: minutes */
    public static final int f22700minutes = 3;

    /* renamed from: seconds */
    public static final int f22701seconds = 2;
    public static final int sixtyHours = 5;

    /* renamed from: years */
    public static final int f22702years = 6;

    /* renamed from: choice */
    private final int f22703choice;
    private final C5972UINT16 duration;

    public Duration(int i, C5972UINT16 c5972uint16) {
        this.f22703choice = i;
        this.duration = c5972uint16;
    }

    public static Duration getInstance(Object obj) {
        if (obj instanceof Duration) {
            return (Duration) obj;
        }
        if (obj != null) {
            return new Duration(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: hours */
    public static Duration m17258hours(C5972UINT16 c5972uint16) {
        return new Duration(4, c5972uint16);
    }

    public static Duration microseconds(C5972UINT16 c5972uint16) {
        return new Duration(0, c5972uint16);
    }

    public static Duration milliseconds(C5972UINT16 c5972uint16) {
        return new Duration(1, c5972uint16);
    }

    /* renamed from: minutes */
    public static Duration m17259minutes(C5972UINT16 c5972uint16) {
        return new Duration(3, c5972uint16);
    }

    /* renamed from: seconds */
    public static Duration m17260seconds(C5972UINT16 c5972uint16) {
        return new Duration(2, c5972uint16);
    }

    public static Duration sixtyHours(C5972UINT16 c5972uint16) {
        return new Duration(5, c5972uint16);
    }

    /* renamed from: years */
    public static Duration m17261years(C5972UINT16 c5972uint16) {
        return new Duration(6, c5972uint16);
    }

    public int getChoice() {
        return this.f22703choice;
    }

    public C5972UINT16 getDuration() {
        return this.duration;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22703choice, this.duration);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        switch (this.f22703choice) {
            case 0:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = "uS";
                break;
            case 1:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = "mS";
                break;
            case 2:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " seconds";
                break;
            case 3:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " minute";
                break;
            case 4:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " hours";
                break;
            case 5:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " sixty hours";
                break;
            case 6:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " years";
                break;
            default:
                sb = new StringBuilder();
                sb.append(this.duration.f22780value);
                str = " unknown choice";
                break;
        }
        sb.append(str);
        return sb.toString();
    }

    private Duration(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22703choice = tagNo;
        switch (tagNo) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                try {
                    this.duration = C5972UINT16.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                    return;
                } catch (Exception e) {
                    throw new IllegalStateException(e.getMessage(), e);
                }
            default:
                throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
    }
}
