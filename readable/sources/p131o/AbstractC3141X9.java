package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.util.Objects;

/* renamed from: o.X9 */
/* loaded from: classes.dex */
public abstract class AbstractC3141X9 {

    /* renamed from: o.X9$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static boolean m10905AZxh(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }

        /* renamed from: mjFkc */
        public static int m10906mjFkc(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }
    }

    /* renamed from: o.X9$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static float m10907AZxh(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }

        /* renamed from: mjFkc */
        public static float m10908mjFkc(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
    }

    /* renamed from: o.X9$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static int m10909AZxh(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i, i2, i3);
        }

        /* renamed from: mjFkc */
        public static int m10910mjFkc(ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i, i2, i3);
        }
    }

    /* renamed from: AZxh */
    public static int m10895AZxh(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    /* renamed from: Dt */
    public static boolean m10896Dt(ViewConfiguration viewConfiguration, Context context) {
        return AZxh.m10905AZxh(viewConfiguration);
    }

    /* renamed from: JHa */
    public static int m10897JHa(Context context, final ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return wA.m10910mjFkc(viewConfiguration, i, i2, i3);
        }
        if (!m10902qdMbNW(i, i2, i3)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iM10903wA = m10903wA(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return m10901mjFkc(resources, iM10903wA, new InterfaceC4594t7() { // from class: o.V9
            @Override // p131o.InterfaceC4594t7
            /* renamed from: get */
            public final Object mo10680get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    /* renamed from: KLFTb */
    public static float m10898KLFTb(ViewConfiguration viewConfiguration, Context context) {
        return mjFkc.m10908mjFkc(viewConfiguration);
    }

    /* renamed from: ZfxDd */
    public static int m10899ZfxDd(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return m10895AZxh(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    /* renamed from: lgHUyS */
    public static float m10900lgHUyS(ViewConfiguration viewConfiguration, Context context) {
        return mjFkc.m10907AZxh(viewConfiguration);
    }

    /* renamed from: mjFkc */
    public static int m10901mjFkc(Resources resources, int i, InterfaceC4594t7 interfaceC4594t7, int i2) {
        int dimensionPixelSize;
        return i != -1 ? (i == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i)) < 0) ? i2 : dimensionPixelSize : ((Integer) interfaceC4594t7.mo10680get()).intValue();
    }

    /* renamed from: qdMbNW */
    public static boolean m10902qdMbNW(int i, int i2, int i3) {
        InputDevice device = InputDevice.getDevice(i);
        return (device == null || device.getMotionRange(i2, i3) == null) ? false : true;
    }

    /* renamed from: wA */
    public static int m10903wA(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return m10895AZxh(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    /* renamed from: xJ */
    public static int m10904xJ(Context context, final ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return wA.m10909AZxh(viewConfiguration, i, i2, i3);
        }
        if (!m10902qdMbNW(i, i2, i3)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iM10899ZfxDd = m10899ZfxDd(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return m10901mjFkc(resources, iM10899ZfxDd, new InterfaceC4594t7() { // from class: o.W9
            @Override // p131o.InterfaceC4594t7
            /* renamed from: get */
            public final Object mo10680get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }
}
