package p131o;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* renamed from: o.s8 */
/* loaded from: classes.dex */
public class C4528s8 implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4528s8> f16462CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public final C2930U1 f16463AZxh;

    /* renamed from: JHa */
    public int f16464JHa;

    /* renamed from: KLFTb */
    public int f16465KLFTb;

    /* renamed from: ZfxDd */
    public int f16466ZfxDd;

    /* renamed from: mjFkc */
    public final C2930U1 f16467mjFkc;

    /* renamed from: wA */
    public final int f16468wA;

    /* renamed from: xJ */
    public int f16469xJ;

    /* renamed from: o.s8$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C4528s8[] newArray(int i) {
            return new C4528s8[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C4528s8 createFromParcel(Parcel parcel) {
            return new C4528s8(parcel);
        }
    }

    public C4528s8(int i, int i2, int i3, int i4) {
        this.f16466ZfxDd = i;
        this.f16465KLFTb = i2;
        this.f16464JHa = i3;
        this.f16468wA = i4;
        this.f16469xJ = m13487wA(i);
        this.f16467mjFkc = new C2930U1(59);
        this.f16463AZxh = new C2930U1(i4 == 1 ? 23 : 12);
    }

    /* renamed from: AZxh */
    public static String m13485AZxh(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: mjFkc */
    public static String m13486mjFkc(Resources resources, CharSequence charSequence) {
        return m13485AZxh(resources, charSequence, "%02d");
    }

    /* renamed from: wA */
    public static int m13487wA(int i) {
        return i >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: equals */
    public boolean m13488equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4528s8)) {
            return false;
        }
        C4528s8 c4528s8 = (C4528s8) obj;
        return this.f16466ZfxDd == c4528s8.f16466ZfxDd && this.f16465KLFTb == c4528s8.f16465KLFTb && this.f16468wA == c4528s8.f16468wA && this.f16464JHa == c4528s8.f16464JHa;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f16468wA), Integer.valueOf(this.f16466ZfxDd), Integer.valueOf(this.f16465KLFTb), Integer.valueOf(this.f16464JHa)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16466ZfxDd);
        parcel.writeInt(this.f16465KLFTb);
        parcel.writeInt(this.f16464JHa);
        parcel.writeInt(this.f16468wA);
    }

    public C4528s8(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
