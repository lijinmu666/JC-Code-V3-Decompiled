package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import org.conscrypt.BuildConfig;

/* renamed from: o.P9 */
/* loaded from: classes.dex */
public class C2615P9 extends AbstractC2550O9 {

    /* renamed from: Dt */
    public int f10043Dt;

    /* renamed from: ETF */
    public int f10044ETF;

    /* renamed from: JHa */
    public final int f10045JHa;

    /* renamed from: KLFTb */
    public final Parcel f10046KLFTb;

    /* renamed from: ZfxDd */
    public final SparseIntArray f10047ZfxDd;

    /* renamed from: lgHUyS */
    public final String f10048lgHUyS;

    /* renamed from: qdMbNW */
    public int f10049qdMbNW;

    /* renamed from: xJ */
    public final int f10050xJ;

    public C2615P9(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.f24315FLAVOR, new C4633tjSezt(), new C4633tjSezt(), new C4633tjSezt());
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: AZxh */
    public AbstractC2550O9 mo9850AZxh() {
        Parcel parcel = this.f10046KLFTb;
        int iDataPosition = parcel.dataPosition();
        int i = this.f10043Dt;
        if (i == this.f10045JHa) {
            i = this.f10050xJ;
        }
        return new C2615P9(parcel, iDataPosition, i, this.f10048lgHUyS + "  ", this.f9919mjFkc, this.f9918AZxh, this.f9920wA);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: ETF */
    public CharSequence mo9854ETF() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f10046KLFTb);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: HGpJ */
    public void mo9856HGpJ(boolean z) {
        this.f10046KLFTb.writeInt(z ? 1 : 0);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: MiMN */
    public boolean mo9861MiMN(int i) {
        while (this.f10043Dt < this.f10050xJ) {
            int i2 = this.f10044ETF;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f10046KLFTb.setDataPosition(this.f10043Dt);
            int i3 = this.f10046KLFTb.readInt();
            this.f10044ETF = this.f10046KLFTb.readInt();
            this.f10043Dt += i3;
        }
        return this.f10044ETF == i;
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: Ne */
    public void mo9862Ne(Parcelable parcelable) {
        this.f10046KLFTb.writeParcelable(parcelable, 0);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: Pq */
    public String mo9864Pq() {
        return this.f10046KLFTb.readString();
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: VocHEe */
    public void mo9868VocHEe(byte[] bArr) {
        if (bArr == null) {
            this.f10046KLFTb.writeInt(-1);
        } else {
            this.f10046KLFTb.writeInt(bArr.length);
            this.f10046KLFTb.writeByteArray(bArr);
        }
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: fehf */
    public Parcelable mo9874fehf() {
        return this.f10046KLFTb.readParcelable(getClass().getClassLoader());
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: huTpC */
    public void mo9875huTpC(int i) {
        mo9879mjFkc();
        this.f10049qdMbNW = i;
        this.f10047ZfxDd.put(i, this.f10046KLFTb.dataPosition());
        mo9878mByQ(0);
        mo9878mByQ(i);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: lB */
    public void mo9876lB(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f10046KLFTb, 0);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: mByQ */
    public void mo9878mByQ(int i) {
        this.f10046KLFTb.writeInt(i);
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: mjFkc */
    public void mo9879mjFkc() {
        int i = this.f10049qdMbNW;
        if (i >= 0) {
            int i2 = this.f10047ZfxDd.get(i);
            int iDataPosition = this.f10046KLFTb.dataPosition();
            this.f10046KLFTb.setDataPosition(i2);
            this.f10046KLFTb.writeInt(iDataPosition - i2);
            this.f10046KLFTb.setDataPosition(iDataPosition);
        }
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: qdMbNW */
    public byte[] mo9881qdMbNW() {
        int i = this.f10046KLFTb.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f10046KLFTb.readByteArray(bArr);
        return bArr;
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: rkYL */
    public int mo9883rkYL() {
        return this.f10046KLFTb.readInt();
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: xJ */
    public boolean mo9887xJ() {
        return this.f10046KLFTb.readInt() != 0;
    }

    @Override // p131o.AbstractC2550O9
    /* renamed from: xrEuO */
    public void mo9888xrEuO(String str) {
        this.f10046KLFTb.writeString(str);
    }

    public C2615P9(Parcel parcel, int i, int i2, String str, C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2, C4633tjSezt c4633tjSezt3) {
        super(c4633tjSezt, c4633tjSezt2, c4633tjSezt3);
        this.f10047ZfxDd = new SparseIntArray();
        this.f10049qdMbNW = -1;
        this.f10044ETF = -1;
        this.f10046KLFTb = parcel;
        this.f10045JHa = i;
        this.f10050xJ = i2;
        this.f10043Dt = i;
        this.f10048lgHUyS = str;
    }
}
