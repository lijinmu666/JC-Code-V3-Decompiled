package androidx.fragment.p022app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import java.util.ArrayList;
import p131o.C3793gy;

/* renamed from: androidx.fragment.app.JHa */
/* loaded from: classes.dex */
public final class C0092JHa implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C0092JHa> f1185CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public ArrayList f1186AZxh;

    /* renamed from: JHa */
    public ArrayList f1187JHa;

    /* renamed from: KLFTb */
    public String f1188KLFTb;

    /* renamed from: ZfxDd */
    public int f1189ZfxDd;

    /* renamed from: lgHUyS */
    public ArrayList f1190lgHUyS;

    /* renamed from: mjFkc */
    public ArrayList f1191mjFkc;

    /* renamed from: wA */
    public C0085AZxh[] f1192wA;

    /* renamed from: xJ */
    public ArrayList f1193xJ;

    /* renamed from: androidx.fragment.app.JHa$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C0092JHa[] newArray(int i) {
            return new C0092JHa[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C0092JHa createFromParcel(Parcel parcel) {
            return new C0092JHa(parcel);
        }
    }

    public C0092JHa(Parcel parcel) {
        this.f1188KLFTb = null;
        this.f1187JHa = new ArrayList();
        this.f1193xJ = new ArrayList();
        this.f1191mjFkc = parcel.createTypedArrayList(C3793gy.f13875CREATOR);
        this.f1186AZxh = parcel.createStringArrayList();
        this.f1192wA = (C0085AZxh[]) parcel.createTypedArray(C0085AZxh.f1061CREATOR);
        this.f1189ZfxDd = parcel.readInt();
        this.f1188KLFTb = parcel.readString();
        this.f1187JHa = parcel.createStringArrayList();
        this.f1193xJ = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f1190lgHUyS = parcel.createTypedArrayList(AbstractC0093KLFTb.xJ.f1244CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f1191mjFkc);
        parcel.writeStringList(this.f1186AZxh);
        parcel.writeTypedArray(this.f1192wA, i);
        parcel.writeInt(this.f1189ZfxDd);
        parcel.writeString(this.f1188KLFTb);
        parcel.writeStringList(this.f1187JHa);
        parcel.writeTypedList(this.f1193xJ);
        parcel.writeTypedList(this.f1190lgHUyS);
    }
}
