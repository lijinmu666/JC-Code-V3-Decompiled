package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import java.lang.reflect.Field;
import p131o.InterfaceC3068W0;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements InterfaceC0104KLFTb {

    /* renamed from: AZxh */
    public static int f196AZxh;

    /* renamed from: KLFTb */
    public static Field f197KLFTb;

    /* renamed from: ZfxDd */
    public static Field f198ZfxDd;

    /* renamed from: wA */
    public static Field f199wA;

    /* renamed from: mjFkc */
    public Activity f200mjFkc;

    /* renamed from: mjFkc */
    public static void m5mjFkc() throws NoSuchFieldException, SecurityException {
        try {
            f196AZxh = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f198ZfxDd = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f197KLFTb = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f199wA = declaredField3;
            declaredField3.setAccessible(true);
            f196AZxh = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (mjfkc != AbstractC0112wA.mjFkc.ON_DESTROY) {
            return;
        }
        if (f196AZxh == 0) {
            m5mjFkc();
        }
        if (f196AZxh == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f200mjFkc.getSystemService("input_method");
            try {
                Object obj = f199wA.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f198ZfxDd.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f197KLFTb.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
