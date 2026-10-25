package com.p038google.p039android.p042gms.dynamite;

import android.content.Context;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.KLFTb */
/* loaded from: classes.dex */
public final class C0215KLFTb implements DynamiteModule.InterfaceC0212AZxh {
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r3
      0x001b: PHI (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.p038google.p039android.p042gms.dynamite.DynamiteModule.InterfaceC0212AZxh
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DynamiteModule.InterfaceC0212AZxh.AZxh mo2392mjFkc(Context context, String str, DynamiteModule.InterfaceC0212AZxh.mjFkc mjfkc) {
        DynamiteModule.InterfaceC0212AZxh.AZxh aZxh = new DynamiteModule.InterfaceC0212AZxh.AZxh();
        aZxh.f2279mjFkc = mjfkc.mo2405mjFkc(context, str);
        int i = 1;
        int iMo2404AZxh = mjfkc.mo2404AZxh(context, str, true);
        aZxh.f2278AZxh = iMo2404AZxh;
        int i2 = aZxh.f2279mjFkc;
        if (i2 == 0) {
            i2 = 0;
            if (iMo2404AZxh == 0) {
                i = 0;
            } else if (i2 >= iMo2404AZxh) {
                i = -1;
            }
        }
        aZxh.f2280wA = i;
        return aZxh;
    }
}
