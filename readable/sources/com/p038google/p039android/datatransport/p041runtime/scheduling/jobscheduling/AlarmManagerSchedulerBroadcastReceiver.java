package com.p038google.p039android.datatransport.p041runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import p131o.AbstractC2480N3;
import p131o.AbstractC3140X8;
import p131o.C3543d9;
import p131o.RunnableC4488rWxwaT;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: mjFkc */
    public static /* synthetic */ void m2356mjFkc() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        C3543d9.m11710JHa(context);
        AbstractC3140X8.mjFkc mjfkcMo10892ZfxDd = AbstractC3140X8.m10886mjFkc().mo10891AZxh(queryParameter).mo10892ZfxDd(AbstractC2480N3.m9583AZxh(iIntValue));
        if (queryParameter2 != null) {
            mjfkcMo10892ZfxDd.mo10894wA(Base64.decode(queryParameter2, 0));
        }
        C3543d9.m11712wA().m11714KLFTb().m7678xJ(mjfkcMo10892ZfxDd.mo10893mjFkc(), i, RunnableC4488rWxwaT.m13377mjFkc());
    }
}
