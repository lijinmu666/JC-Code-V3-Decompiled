package androidx.p017core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import p131o.AbstractC2550O9;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* renamed from: read */
    public static IconCompat m567read(AbstractC2550O9 abstractC2550O9) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f952mjFkc = abstractC2550O9.m9880qGY(iconCompat.f952mjFkc, 1);
        iconCompat.f954wA = abstractC2550O9.m9853Dt(iconCompat.f954wA, 2);
        iconCompat.f950ZfxDd = abstractC2550O9.m9857IEE(iconCompat.f950ZfxDd, 3);
        iconCompat.f949KLFTb = abstractC2550O9.m9880qGY(iconCompat.f949KLFTb, 4);
        iconCompat.f948JHa = abstractC2550O9.m9880qGY(iconCompat.f948JHa, 5);
        iconCompat.f955xJ = (ColorStateList) abstractC2550O9.m9857IEE(iconCompat.f955xJ, 6);
        iconCompat.f953qdMbNW = abstractC2550O9.m9872diqgf(iconCompat.f953qdMbNW, 7);
        iconCompat.f947Dt = abstractC2550O9.m9872diqgf(iconCompat.f947Dt, 8);
        iconCompat.m553xJ();
        return iconCompat;
    }

    /* renamed from: write */
    public static void m568write(IconCompat iconCompat, AbstractC2550O9 abstractC2550O9) {
        abstractC2550O9.m9855Gd(true, true);
        iconCompat.m550lgHUyS(abstractC2550O9.m9858JHa());
        int i = iconCompat.f952mjFkc;
        if (-1 != i) {
            abstractC2550O9.m9863OjSQV(i, 1);
        }
        byte[] bArr = iconCompat.f954wA;
        if (bArr != null) {
            abstractC2550O9.m9851BAnRFn(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f950ZfxDd;
        if (parcelable != null) {
            abstractC2550O9.m9852CqaNbM(parcelable, 3);
        }
        int i2 = iconCompat.f949KLFTb;
        if (i2 != 0) {
            abstractC2550O9.m9863OjSQV(i2, 4);
        }
        int i3 = iconCompat.f948JHa;
        if (i3 != 0) {
            abstractC2550O9.m9863OjSQV(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f955xJ;
        if (colorStateList != null) {
            abstractC2550O9.m9852CqaNbM(colorStateList, 6);
        }
        String str = iconCompat.f953qdMbNW;
        if (str != null) {
            abstractC2550O9.m9860KLMXS(str, 7);
        }
        String str2 = iconCompat.f947Dt;
        if (str2 != null) {
            abstractC2550O9.m9860KLMXS(str2, 8);
        }
    }
}
