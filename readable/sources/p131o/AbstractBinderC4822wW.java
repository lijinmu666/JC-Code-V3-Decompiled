package p131o;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: o.wW */
/* loaded from: classes.dex */
public abstract class AbstractBinderC4822wW extends AbstractBinderC4135mD implements InterfaceC4890xW {
    /* renamed from: ZfxDd */
    public static InterfaceC4890xW m13859ZfxDd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof InterfaceC4890xW ? (InterfaceC4890xW) iInterfaceQueryLocalInterface : new C4754vW(iBinder);
    }
}
