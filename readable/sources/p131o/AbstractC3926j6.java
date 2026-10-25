package p131o;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: o.j6 */
/* loaded from: classes.dex */
public abstract class AbstractC3926j6 {

    /* renamed from: o.j6$mjFkc */
    public static class mjFkc extends RuntimeException {
        public mjFkc(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    /* renamed from: AZxh */
    public static int[] m12364AZxh(Parcel parcel, int i) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return iArrCreateIntArray;
    }

    /* renamed from: Dt */
    public static boolean m12365Dt(Parcel parcel, int i) {
        m12371Pq(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: ETF */
    public static float m12366ETF(Parcel parcel, int i) {
        m12371Pq(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: IEE */
    public static int m12367IEE(Parcel parcel) {
        int iM12372VA = m12372VA(parcel);
        int iM12378qGY = m12378qGY(parcel, iM12372VA);
        int iM12379qdMbNW = m12379qdMbNW(iM12372VA);
        int iDataPosition = parcel.dataPosition();
        if (iM12379qdMbNW != 20293) {
            throw new mjFkc("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iM12372VA))), parcel);
        }
        int i = iM12378qGY + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new mjFkc("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
    }

    /* renamed from: JHa */
    public static Object[] m12368JHa(Parcel parcel, int i, Parcelable.Creator creator) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return objArrCreateTypedArray;
    }

    /* renamed from: KLFTb */
    public static ArrayList m12369KLFTb(Parcel parcel, int i) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return arrayListCreateStringArrayList;
    }

    /* renamed from: MiMN */
    public static IBinder m12370MiMN(Parcel parcel, int i) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return strongBinder;
    }

    /* renamed from: Pq */
    public static void m12371Pq(Parcel parcel, int i, int i2) {
        int iM12378qGY = m12378qGY(parcel, i);
        if (iM12378qGY == i2) {
            return;
        }
        throw new mjFkc("Expected size " + i2 + " got " + iM12378qGY + " (0x" + Integer.toHexString(iM12378qGY) + ")", parcel);
    }

    /* renamed from: VA */
    public static int m12372VA(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: YoKzxo */
    public static int m12373YoKzxo(Parcel parcel, int i) {
        m12371Pq(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: ZfxDd */
    public static String m12374ZfxDd(Parcel parcel, int i) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return string;
    }

    /* renamed from: fehf */
    public static void m12375fehf(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m12378qGY(parcel, i));
    }

    /* renamed from: lgHUyS */
    public static void m12376lgHUyS(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new mjFkc("Overread allowed size end=" + i, parcel);
    }

    /* renamed from: mjFkc */
    public static Bundle m12377mjFkc(Parcel parcel, int i) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return bundle;
    }

    /* renamed from: qGY */
    public static int m12378qGY(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    /* renamed from: qdMbNW */
    public static int m12379qdMbNW(int i) {
        return (char) i;
    }

    /* renamed from: rkYL */
    public static long m12380rkYL(Parcel parcel, int i) {
        m12371Pq(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: wA */
    public static Parcelable m12381wA(Parcel parcel, int i, Parcelable.Creator creator) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return parcelable;
    }

    /* renamed from: xJ */
    public static ArrayList m12382xJ(Parcel parcel, int i, Parcelable.Creator creator) {
        int iM12378qGY = m12378qGY(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM12378qGY == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM12378qGY);
        return arrayListCreateTypedArrayList;
    }
}
