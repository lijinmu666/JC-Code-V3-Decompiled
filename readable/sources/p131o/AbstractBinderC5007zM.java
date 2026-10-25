package p131o;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: o.zM */
/* loaded from: classes.dex */
public abstract class AbstractBinderC5007zM extends AbstractBinderC4135mD implements InterfaceC2028GN {
    /* renamed from: ZfxDd */
    public static InterfaceC2028GN m14096ZfxDd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2028GN ? (InterfaceC2028GN) iInterfaceQueryLocalInterface : new C4408qL(iBinder);
    }
}
