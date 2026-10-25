package p131o;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.k6 */
/* loaded from: classes.dex */
public abstract class AbstractC3997k6 {
    /* renamed from: AZxh */
    public static void m12467AZxh(Parcel parcel, int i) {
        m12480qGY(parcel, i);
    }

    /* renamed from: Dt */
    public static void m12468Dt(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: ETF */
    public static void m12469ETF(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcel.writeString(str);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: IEE */
    public static void m12470IEE(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    /* renamed from: JHa */
    public static void m12471JHa(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: KLFTb */
    public static void m12472KLFTb(Parcel parcel, int i, float f) {
        m12477fehf(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: MiMN */
    public static void m12473MiMN(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
                return;
            }
            return;
        }
        int iM12482rkYL = m12482rkYL(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                m12470IEE(parcel, parcelable, i2);
            }
        }
        m12480qGY(parcel, iM12482rkYL);
    }

    /* renamed from: VA */
    public static void m12474VA(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcel.writeStringList(list);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: YoKzxo */
    public static void m12475YoKzxo(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
                return;
            }
            return;
        }
        int iM12482rkYL = m12482rkYL(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                m12470IEE(parcel, parcelable, 0);
            }
        }
        m12480qGY(parcel, iM12482rkYL);
    }

    /* renamed from: ZfxDd */
    public static void m12476ZfxDd(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcel.writeBundle(bundle);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: fehf */
    public static void m12477fehf(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    /* renamed from: lgHUyS */
    public static void m12478lgHUyS(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                m12477fehf(parcel, i, 0);
            }
        } else {
            int iM12482rkYL = m12482rkYL(parcel, i);
            parcel.writeIntArray(iArr);
            m12480qGY(parcel, iM12482rkYL);
        }
    }

    /* renamed from: mjFkc */
    public static int m12479mjFkc(Parcel parcel) {
        return m12482rkYL(parcel, 20293);
    }

    /* renamed from: qGY */
    public static void m12480qGY(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    /* renamed from: qdMbNW */
    public static void m12481qdMbNW(Parcel parcel, int i, long j) {
        m12477fehf(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: rkYL */
    public static int m12482rkYL(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: wA */
    public static void m12483wA(Parcel parcel, int i, boolean z) {
        m12477fehf(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: xJ */
    public static void m12484xJ(Parcel parcel, int i, int i2) {
        m12477fehf(parcel, i, 4);
        parcel.writeInt(i2);
    }
}
