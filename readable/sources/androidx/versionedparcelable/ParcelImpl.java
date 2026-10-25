package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import p131o.C2615P9;
import p131o.InterfaceC2677Q9;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<ParcelImpl> f1951CREATOR = new C0185mjFkc();

    /* renamed from: mjFkc */
    public final InterfaceC2677Q9 f1952mjFkc;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$mjFkc */
    public static class C0185mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }
    }

    public ParcelImpl(Parcel parcel) {
        this.f1952mjFkc = new C2615P9(parcel).m9873eyqo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new C2615P9(parcel).m9871cMLeY(this.f1952mjFkc);
    }
}
