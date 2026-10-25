package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p131o.InterfaceC1929F;

/* renamed from: o.Mu */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2470Mu extends AbstractBinderC3645el implements InterfaceC2534Nu {
    public AbstractBinderC2470Mu() {
        super("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    public static InterfaceC2534Nu asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2534Nu ? (InterfaceC2534Nu) iInterfaceQueryLocalInterface : new C2400Lu(iBinder);
    }

    @Override // p131o.AbstractBinderC3645el
    /* renamed from: ZfxDd */
    public final boolean mo8465ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcel.readStrongBinder());
            AbstractC3906im.m12313AZxh(parcel);
            InterfaceC2337Ku interfaceC2337KuNewTextRecognizer = newTextRecognizer(interfaceC1929FM8243KLFTb);
            parcel2.writeNoException();
            AbstractC3906im.m12315wA(parcel2, interfaceC2337KuNewTextRecognizer);
        } else {
            if (i != 2) {
                return false;
            }
            InterfaceC1929F interfaceC1929FM8243KLFTb2 = InterfaceC1929F.mjFkc.m8243KLFTb(parcel.readStrongBinder());
            C3192Xu c3192Xu = (C3192Xu) AbstractC3906im.m12314mjFkc(parcel, C3192Xu.f11714CREATOR);
            AbstractC3906im.m12313AZxh(parcel);
            InterfaceC2337Ku interfaceC2337KuNewTextRecognizerWithOptions = newTextRecognizerWithOptions(interfaceC1929FM8243KLFTb2, c3192Xu);
            parcel2.writeNoException();
            AbstractC3906im.m12315wA(parcel2, interfaceC2337KuNewTextRecognizerWithOptions);
        }
        return true;
    }
}
