package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.HW */
/* loaded from: classes.dex */
public final class C2105HW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2105HW> f8605CREATOR = new C2172IW();

    /* renamed from: AZxh */
    public final Rect f8606AZxh;

    /* renamed from: JHa */
    public final float f8607JHa;

    /* renamed from: KLFTb */
    public final List f8608KLFTb;

    /* renamed from: ZfxDd */
    public final String f8609ZfxDd;

    /* renamed from: mjFkc */
    public final String f8610mjFkc;

    /* renamed from: wA */
    public final List f8611wA;

    /* renamed from: xJ */
    public final float f8612xJ;

    public C2105HW(String str, Rect rect, List list, String str2, List list2, float f, float f2) {
        this.f8610mjFkc = str;
        this.f8606AZxh = rect;
        this.f8611wA = list;
        this.f8609ZfxDd = str2;
        this.f8608KLFTb = list2;
        this.f8607JHa = f;
        this.f8612xJ = f2;
    }

    /* renamed from: AZxh */
    public final float m8576AZxh() {
        return this.f8607JHa;
    }

    /* renamed from: JHa */
    public final String m8577JHa() {
        return this.f8610mjFkc;
    }

    /* renamed from: ZfxDd */
    public final String m8578ZfxDd() {
        return this.f8609ZfxDd;
    }

    /* renamed from: lgHUyS */
    public final List m8579lgHUyS() {
        return this.f8608KLFTb;
    }

    /* renamed from: mjFkc */
    public final float m8580mjFkc() {
        return this.f8612xJ;
    }

    /* renamed from: wA */
    public final Rect m8581wA() {
        return this.f8606AZxh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f8610mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f8606AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f8611wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f8609ZfxDd, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 5, this.f8608KLFTb, false);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f8607JHa);
        AbstractC3997k6.m12472KLFTb(parcel, 7, this.f8612xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    /* renamed from: xJ */
    public final List m8582xJ() {
        return this.f8611wA;
    }
}
