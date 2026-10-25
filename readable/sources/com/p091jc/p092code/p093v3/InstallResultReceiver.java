package com.p091jc.p092code.p093v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class InstallResultReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", -999);
            String stringExtra = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
            String str = "[安装结果] status=" + intExtra + " legacy=" + intent.getIntExtra("android.content.pm.extra.LEGACY_STATUS", 0) + " msg=" + stringExtra;
            Log.d("JCCodeV3", str);
            MainActivity.m4615wMV(str);
        } catch (Throwable unused) {
        }
    }
}
