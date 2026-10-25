package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

/* renamed from: o.o8 */
/* loaded from: classes.dex */
public abstract class AbstractC4260o8 {

    /* renamed from: mjFkc */
    public static final int[] f15508mjFkc = {AbstractC3800h4.f13928JHa};

    /* renamed from: AZxh */
    public static final int[] f15507AZxh = {AbstractC3800h4.f13954xJ};

    /* renamed from: AZxh */
    public static void m12936AZxh(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12535bVfe, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12413KbpP, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(AbstractC3800h4.f13931MiMN, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                m12943wA(context);
            }
        }
        m12941mjFkc(context);
    }

    /* renamed from: JHa */
    public static boolean m12937JHa(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    /* renamed from: KLFTb */
    public static void m12938KLFTb(Context context, int[] iArr, String str) {
        if (m12944xJ(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    /* renamed from: ZfxDd */
    public static void m12939ZfxDd(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        boolean zM12937JHa;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12535bVfe, i, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12513YRhJjQ, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zM12937JHa = typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12705zo, -1) != -1;
        } else {
            zM12937JHa = m12937JHa(context, attributeSet, iArr, i, i2, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zM12937JHa) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* renamed from: lgHUyS */
    public static TypedArray m12940lgHUyS(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m12936AZxh(context, attributeSet, i, i2);
        m12939ZfxDd(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    /* renamed from: mjFkc */
    public static void m12941mjFkc(Context context) {
        m12938KLFTb(context, f15508mjFkc, "Theme.AppCompat");
    }

    /* renamed from: qdMbNW */
    public static C1606A8 m12942qdMbNW(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m12936AZxh(context, attributeSet, i, i2);
        m12939ZfxDd(context, attributeSet, iArr, i, i2, iArr2);
        return C1606A8.m7575diqgf(context, attributeSet, iArr, i, i2);
    }

    /* renamed from: wA */
    public static void m12943wA(Context context) {
        m12938KLFTb(context, f15507AZxh, "Theme.MaterialComponents");
    }

    /* renamed from: xJ */
    public static boolean m12944xJ(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }
}
