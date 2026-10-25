package p131o;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.gy */
/* loaded from: classes.dex */
public final class C3793gy implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3793gy> f13875CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public final String f13876AZxh;

    /* renamed from: Dt */
    public final Bundle f13877Dt;

    /* renamed from: ETF */
    public final boolean f13878ETF;

    /* renamed from: JHa */
    public final String f13879JHa;

    /* renamed from: KLFTb */
    public final int f13880KLFTb;

    /* renamed from: MiMN */
    public Bundle f13881MiMN;

    /* renamed from: VA */
    public final int f13882VA;

    /* renamed from: ZfxDd */
    public final int f13883ZfxDd;

    /* renamed from: lgHUyS */
    public final boolean f13884lgHUyS;

    /* renamed from: mjFkc */
    public final String f13885mjFkc;

    /* renamed from: qdMbNW */
    public final boolean f13886qdMbNW;

    /* renamed from: wA */
    public final boolean f13887wA;

    /* renamed from: xJ */
    public final boolean f13888xJ;

    /* renamed from: o.gy$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C3793gy[] newArray(int i) {
            return new C3793gy[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C3793gy createFromParcel(Parcel parcel) {
            return new C3793gy(parcel);
        }
    }

    public C3793gy(Parcel parcel) {
        this.f13885mjFkc = parcel.readString();
        this.f13876AZxh = parcel.readString();
        this.f13887wA = parcel.readInt() != 0;
        this.f13883ZfxDd = parcel.readInt();
        this.f13880KLFTb = parcel.readInt();
        this.f13879JHa = parcel.readString();
        this.f13888xJ = parcel.readInt() != 0;
        this.f13884lgHUyS = parcel.readInt() != 0;
        this.f13886qdMbNW = parcel.readInt() != 0;
        this.f13877Dt = parcel.readBundle();
        this.f13878ETF = parcel.readInt() != 0;
        this.f13881MiMN = parcel.readBundle();
        this.f13882VA = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f13885mjFkc);
        sb.append(" (");
        sb.append(this.f13876AZxh);
        sb.append(")}:");
        if (this.f13887wA) {
            sb.append(" fromLayout");
        }
        if (this.f13880KLFTb != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f13880KLFTb));
        }
        String str = this.f13879JHa;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f13879JHa);
        }
        if (this.f13888xJ) {
            sb.append(" retainInstance");
        }
        if (this.f13884lgHUyS) {
            sb.append(" removing");
        }
        if (this.f13886qdMbNW) {
            sb.append(" detached");
        }
        if (this.f13878ETF) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13885mjFkc);
        parcel.writeString(this.f13876AZxh);
        parcel.writeInt(this.f13887wA ? 1 : 0);
        parcel.writeInt(this.f13883ZfxDd);
        parcel.writeInt(this.f13880KLFTb);
        parcel.writeString(this.f13879JHa);
        parcel.writeInt(this.f13888xJ ? 1 : 0);
        parcel.writeInt(this.f13884lgHUyS ? 1 : 0);
        parcel.writeInt(this.f13886qdMbNW ? 1 : 0);
        parcel.writeBundle(this.f13877Dt);
        parcel.writeInt(this.f13878ETF ? 1 : 0);
        parcel.writeBundle(this.f13881MiMN);
        parcel.writeInt(this.f13882VA);
    }
}
