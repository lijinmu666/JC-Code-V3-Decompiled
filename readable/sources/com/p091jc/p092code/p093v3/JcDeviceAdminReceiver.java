package com.p091jc.p092code.p093v3;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class JcDeviceAdminReceiver extends DeviceAdminReceiver {
    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
        Log.d("JCCodeV3", "[设备所有者] 已解除");
        MainActivity.m4615wMV("[设备所有者] 已解除");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
        Log.d("JCCodeV3", "[设备所有者] 已激活");
        MainActivity.m4615wMV("[设备所有者] 已激活");
    }
}
