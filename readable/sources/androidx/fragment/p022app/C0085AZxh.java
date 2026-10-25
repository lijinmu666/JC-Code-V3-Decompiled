package androidx.fragment.p022app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.p022app.AbstractC0095lgHUyS;
import androidx.lifecycle.AbstractC0112wA;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.AZxh */
/* loaded from: classes.dex */
public final class C0085AZxh implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C0085AZxh> f1061CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public final ArrayList f1062AZxh;

    /* renamed from: Dt */
    public final int f1063Dt;

    /* renamed from: ETF */
    public final CharSequence f1064ETF;

    /* renamed from: JHa */
    public final String f1065JHa;

    /* renamed from: KLFTb */
    public final int f1066KLFTb;

    /* renamed from: MiMN */
    public final ArrayList f1067MiMN;

    /* renamed from: VA */
    public final ArrayList f1068VA;

    /* renamed from: YoKzxo */
    public final boolean f1069YoKzxo;

    /* renamed from: ZfxDd */
    public final int[] f1070ZfxDd;

    /* renamed from: lgHUyS */
    public final int f1071lgHUyS;

    /* renamed from: mjFkc */
    public final int[] f1072mjFkc;

    /* renamed from: qdMbNW */
    public final CharSequence f1073qdMbNW;

    /* renamed from: wA */
    public final int[] f1074wA;

    /* renamed from: xJ */
    public final int f1075xJ;

    /* renamed from: androidx.fragment.app.AZxh$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C0085AZxh[] newArray(int i) {
            return new C0085AZxh[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C0085AZxh createFromParcel(Parcel parcel) {
            return new C0085AZxh(parcel);
        }
    }

    public C0085AZxh(Parcel parcel) {
        this.f1072mjFkc = parcel.createIntArray();
        this.f1062AZxh = parcel.createStringArrayList();
        this.f1074wA = parcel.createIntArray();
        this.f1070ZfxDd = parcel.createIntArray();
        this.f1066KLFTb = parcel.readInt();
        this.f1065JHa = parcel.readString();
        this.f1075xJ = parcel.readInt();
        this.f1071lgHUyS = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f1073qdMbNW = (CharSequence) creator.createFromParcel(parcel);
        this.f1063Dt = parcel.readInt();
        this.f1064ETF = (CharSequence) creator.createFromParcel(parcel);
        this.f1068VA = parcel.createStringArrayList();
        this.f1067MiMN = parcel.createStringArrayList();
        this.f1069YoKzxo = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: mjFkc */
    public C0096mjFkc m718mjFkc(AbstractC0093KLFTb abstractC0093KLFTb) {
        C0096mjFkc c0096mjFkc = new C0096mjFkc(abstractC0093KLFTb);
        int i = 0;
        int i2 = 0;
        while (i < this.f1072mjFkc.length) {
            AbstractC0095lgHUyS.mjFkc mjfkc = new AbstractC0095lgHUyS.mjFkc();
            int i3 = i + 1;
            mjfkc.f1278mjFkc = this.f1072mjFkc[i];
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Instantiate " + c0096mjFkc + " op #" + i2 + " base fragment #" + this.f1072mjFkc[i3]);
            }
            String str = (String) this.f1062AZxh.get(i2);
            if (str != null) {
                mjfkc.f1273AZxh = abstractC0093KLFTb.m936vadzgd(str);
            } else {
                mjfkc.f1273AZxh = null;
            }
            mjfkc.f1280xJ = AbstractC0112wA.AZxh.m1097values()[this.f1074wA[i2]];
            mjfkc.f1277lgHUyS = AbstractC0112wA.AZxh.m1097values()[this.f1070ZfxDd[i2]];
            int[] iArr = this.f1072mjFkc;
            int i4 = iArr[i3];
            mjfkc.f1279wA = i4;
            int i5 = iArr[i + 2];
            mjfkc.f1276ZfxDd = i5;
            int i6 = i + 4;
            int i7 = iArr[i + 3];
            mjfkc.f1275KLFTb = i7;
            i += 5;
            int i8 = iArr[i6];
            mjfkc.f1274JHa = i8;
            c0096mjFkc.f1264ZfxDd = i4;
            c0096mjFkc.f1259KLFTb = i5;
            c0096mjFkc.f1258JHa = i7;
            c0096mjFkc.f1272xJ = i8;
            c0096mjFkc.m965ZfxDd(mjfkc);
            i2++;
        }
        c0096mjFkc.f1266lgHUyS = this.f1066KLFTb;
        c0096mjFkc.f1256ETF = this.f1065JHa;
        c0096mjFkc.f1281Ucbh = this.f1075xJ;
        c0096mjFkc.f1269qdMbNW = true;
        c0096mjFkc.f1262VA = this.f1071lgHUyS;
        c0096mjFkc.f1260MiMN = this.f1073qdMbNW;
        c0096mjFkc.f1263YoKzxo = this.f1063Dt;
        c0096mjFkc.f1270rkYL = this.f1064ETF;
        c0096mjFkc.f1268qGY = this.f1068VA;
        c0096mjFkc.f1265fehf = this.f1067MiMN;
        c0096mjFkc.f1257IEE = this.f1069YoKzxo;
        c0096mjFkc.m983rkYL(1);
        return c0096mjFkc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1072mjFkc);
        parcel.writeStringList(this.f1062AZxh);
        parcel.writeIntArray(this.f1074wA);
        parcel.writeIntArray(this.f1070ZfxDd);
        parcel.writeInt(this.f1066KLFTb);
        parcel.writeString(this.f1065JHa);
        parcel.writeInt(this.f1075xJ);
        parcel.writeInt(this.f1071lgHUyS);
        TextUtils.writeToParcel(this.f1073qdMbNW, parcel, 0);
        parcel.writeInt(this.f1063Dt);
        TextUtils.writeToParcel(this.f1064ETF, parcel, 0);
        parcel.writeStringList(this.f1068VA);
        parcel.writeStringList(this.f1067MiMN);
        parcel.writeInt(this.f1069YoKzxo ? 1 : 0);
    }
}
