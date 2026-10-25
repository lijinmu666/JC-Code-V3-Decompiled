package p131o;

import android.os.Parcel;
import p131o.InterfaceC1929F;

/* renamed from: o.Gu */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2060Gu extends AbstractBinderC3645el implements InterfaceC2337Ku {
    public AbstractBinderC2060Gu() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    @Override // p131o.AbstractBinderC3645el
    /* renamed from: ZfxDd */
    public final boolean mo8465ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            mo9285AZxh();
            parcel2.writeNoException();
        } else if (i == 2) {
            mo9287JHa();
            parcel2.writeNoException();
        } else if (i == 3) {
            InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcel.readStrongBinder());
            C1923Eu c1923Eu = (C1923Eu) AbstractC3906im.m12314mjFkc(parcel, C1923Eu.f8093CREATOR);
            AbstractC3906im.m12313AZxh(parcel);
            C2994Uu c2994UuMo9288rkYL = mo9288rkYL(interfaceC1929FM8243KLFTb, c1923Eu);
            parcel2.writeNoException();
            parcel2.writeInt(1);
            c2994UuMo9288rkYL.writeToParcel(parcel2, 1);
        } else {
            if (i != 4) {
                return false;
            }
            InterfaceC1929F interfaceC1929FM8243KLFTb2 = InterfaceC1929F.mjFkc.m8243KLFTb(parcel.readStrongBinder());
            C1923Eu c1923Eu2 = (C1923Eu) AbstractC3906im.m12314mjFkc(parcel, C1923Eu.f8093CREATOR);
            AbstractC3906im.m12313AZxh(parcel);
            C4908xp[] c4908xpArrMo9286Dt = mo9286Dt(interfaceC1929FM8243KLFTb2, c1923Eu2);
            parcel2.writeNoException();
            parcel2.writeTypedArray(c4908xpArrMo9286Dt, 1);
        }
        return true;
    }
}
