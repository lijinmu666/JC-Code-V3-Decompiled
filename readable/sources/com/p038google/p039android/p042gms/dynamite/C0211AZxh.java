package com.p038google.p039android.p042gms.dynamite;

import android.content.Context;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.AZxh */
/* loaded from: classes.dex */
public final class C0211AZxh implements DynamiteModule.InterfaceC0212AZxh {
    @Override // com.p038google.p039android.p042gms.dynamite.DynamiteModule.InterfaceC0212AZxh
    /* renamed from: mjFkc */
    public final DynamiteModule.InterfaceC0212AZxh.AZxh mo2392mjFkc(Context context, String str, DynamiteModule.InterfaceC0212AZxh.mjFkc mjfkc) {
        DynamiteModule.InterfaceC0212AZxh.AZxh aZxh = new DynamiteModule.InterfaceC0212AZxh.AZxh();
        int iMo2404AZxh = mjfkc.mo2404AZxh(context, str, true);
        aZxh.f2278AZxh = iMo2404AZxh;
        if (iMo2404AZxh != 0) {
            aZxh.f2280wA = 1;
        } else {
            int iMo2405mjFkc = mjfkc.mo2405mjFkc(context, str);
            aZxh.f2279mjFkc = iMo2405mjFkc;
            if (iMo2405mjFkc != 0) {
                aZxh.f2280wA = -1;
            }
        }
        return aZxh;
    }
}
