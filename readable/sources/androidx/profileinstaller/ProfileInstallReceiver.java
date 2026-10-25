package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.AbstractC0121wA;
import java.io.IOException;
import p131o.ExecutorC2671Q3;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* renamed from: androidx.profileinstaller.ProfileInstallReceiver$mjFkc */
    public class C0115mjFkc implements AbstractC0121wA.wA {
        public C0115mjFkc() {
        }

        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: AZxh */
        public void mo1127AZxh(int i, Object obj) {
            AbstractC0121wA.f1440AZxh.mo1127AZxh(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }

        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: mjFkc */
        public void mo1128mjFkc(int i, Object obj) {
            AbstractC0121wA.f1440AZxh.mo1128mjFkc(i, obj);
        }
    }

    /* renamed from: mjFkc */
    public static void m1126mjFkc(AbstractC0121wA.wA wAVar) {
        Process.sendSignal(Process.myPid(), 10);
        wAVar.mo1127AZxh(12, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException, IOException {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            AbstractC0121wA.m1155ETF(context, new ExecutorC2671Q3(), new C0115mjFkc(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    AbstractC0121wA.m1158VA(context, new ExecutorC2671Q3(), new C0115mjFkc());
                    return;
                } else {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        AbstractC0121wA.m1163wA(context, new ExecutorC2671Q3(), new C0115mjFkc());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            m1126mjFkc(new C0115mjFkc());
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        C0115mjFkc c0115mjFkc = new C0115mjFkc();
        if ("DROP_SHADER_CACHE".equals(string2)) {
            AbstractC0120mjFkc.m1150AZxh(context, c0115mjFkc);
        } else {
            c0115mjFkc.mo1127AZxh(16, null);
        }
    }
}
