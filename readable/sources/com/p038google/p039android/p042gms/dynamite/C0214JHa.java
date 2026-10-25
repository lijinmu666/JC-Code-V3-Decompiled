package com.p038google.p039android.p042gms.dynamite;

import android.content.Context;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.JHa */
/* loaded from: classes.dex */
public final class C0214JHa implements DynamiteModule.InterfaceC0212AZxh {
    @Override // com.p038google.p039android.p042gms.dynamite.DynamiteModule.InterfaceC0212AZxh
    /* renamed from: mjFkc */
    public final DynamiteModule.InterfaceC0212AZxh.AZxh mo2392mjFkc(Context context, String str, DynamiteModule.InterfaceC0212AZxh.mjFkc mjfkc) {
        int iMo2404AZxh;
        DynamiteModule.InterfaceC0212AZxh.AZxh aZxh = new DynamiteModule.InterfaceC0212AZxh.AZxh();
        int iMo2405mjFkc = mjfkc.mo2405mjFkc(context, str);
        aZxh.f2279mjFkc = iMo2405mjFkc;
        int i = 1;
        int i2 = 0;
        if (iMo2405mjFkc != 0) {
            iMo2404AZxh = mjfkc.mo2404AZxh(context, str, false);
            aZxh.f2278AZxh = iMo2404AZxh;
        } else {
            iMo2404AZxh = mjfkc.mo2404AZxh(context, str, true);
            aZxh.f2278AZxh = iMo2404AZxh;
        }
        int i3 = aZxh.f2279mjFkc;
        if (i3 == 0) {
            if (iMo2404AZxh == 0) {
                i = 0;
            }
            aZxh.f2280wA = i;
            return aZxh;
        }
        i2 = i3;
        if (i2 >= iMo2404AZxh) {
            i = -1;
        }
        aZxh.f2280wA = i;
        return aZxh;
    }
}
