package p131o;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import com.p091jc.p092code.p093v3.JcDeviceAdminReceiver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: o.vEiZJ */
/* loaded from: classes.dex */
public abstract class AbstractC4735vEiZJ {
    /* renamed from: AZxh */
    public static void m13766AZxh(String[] strArr, int i, String str) {
        if (strArr.length >= i) {
            return;
        }
        throw new IllegalArgumentException("用法: " + str);
    }

    /* renamed from: mjFkc */
    public static String m13767mjFkc(Context context, String str) throws SecurityException, IOException {
        String str2;
        String[] strArrSplit = str.trim().split("\\s+");
        if (strArrSplit.length == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        int i = 0;
        if (strArrSplit[0].length() == 0) {
            return BuildConfig.f24315FLAVOR;
        }
        String str3 = strArrSplit[0];
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        if (devicePolicyManager == null) {
            throw new IllegalStateException("DevicePolicyManager 不可用");
        }
        ComponentName componentName = new ComponentName(context, (Class<?>) JcDeviceAdminReceiver.class);
        if (!devicePolicyManager.isDeviceOwnerApp(context.getPackageName())) {
            throw new IllegalStateException("本应用不是设备所有者，OW 命令不可用（先「申请设备所有者」）");
        }
        if ("help".equals(str3)) {
            return "OW 命令列表（dpm 风格，空格分隔参数）:\n  help\n  get-device-owner\n  is-uninstall-blocked <包名>\n  set-uninstall-blocked <包名> <true|false>\n  set-permission-grant-state <包名> <权限> <granted|denied|default>\n  set-lock-task-packages <包名> [包名...]\n  set-keyguard-disabled <true|false>\n  install-ca-cert <证书crt路径>";
        }
        if ("get-device-owner".equals(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("设备所有者: ");
            if (devicePolicyManager.isDeviceOwnerApp(context.getPackageName())) {
                str2 = "本应用 (" + context.getPackageName() + ")";
            } else {
                str2 = "无";
            }
            sb.append(str2);
            sb.append("\n");
            List<ComponentName> activeAdmins = devicePolicyManager.getActiveAdmins();
            sb.append("活跃管理员: ");
            sb.append(activeAdmins != null ? Arrays.toString(activeAdmins.toArray()) : "无");
            return sb.toString();
        }
        if ("is-uninstall-blocked".equals(str3)) {
            m13766AZxh(strArrSplit, 2, "is-uninstall-blocked <包名>");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArrSplit[1]);
            sb2.append(": ");
            sb2.append(devicePolicyManager.isUninstallBlocked(componentName, strArrSplit[1]) ? "已防卸载" : "未防护");
            return sb2.toString();
        }
        if ("set-uninstall-blocked".equals(str3)) {
            m13766AZxh(strArrSplit, 3, "set-uninstall-blocked <包名> <true|false>");
            boolean z = Boolean.parseBoolean(strArrSplit[2]);
            devicePolicyManager.setUninstallBlocked(componentName, strArrSplit[1], z);
            boolean zIsUninstallBlocked = devicePolicyManager.isUninstallBlocked(componentName, strArrSplit[1]);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(zIsUninstallBlocked != z ? "✗ 未生效 " : "✓ ");
            sb3.append(strArrSplit[1]);
            sb3.append(" → 防卸载 ");
            sb3.append(zIsUninstallBlocked);
            return sb3.toString();
        }
        if ("set-permission-grant-state".equals(str3)) {
            m13766AZxh(strArrSplit, 4, "set-permission-grant-state <包名> <权限> <granted|denied|default>");
            String lowerCase = strArrSplit[3].toLowerCase();
            if ("granted".equals(lowerCase)) {
                i = 1;
            } else if ("denied".equals(lowerCase)) {
                i = 2;
            } else if (!"default".equals(lowerCase)) {
                throw new IllegalArgumentException("状态必须是 granted / denied / default");
            }
            boolean permissionGrantState = devicePolicyManager.setPermissionGrantState(componentName, strArrSplit[1], strArrSplit[2], i);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(permissionGrantState ? "✓ " : "✗ ");
            sb4.append(strArrSplit[1]);
            sb4.append(" ");
            sb4.append(strArrSplit[2]);
            sb4.append(" → ");
            sb4.append(lowerCase);
            return sb4.toString();
        }
        if ("set-lock-task-packages".equals(str3)) {
            m13766AZxh(strArrSplit, 2, "set-lock-task-packages <包名> [包名...]");
            int length = strArrSplit.length - 1;
            String[] strArr = new String[length];
            System.arraycopy(strArrSplit, 1, strArr, 0, length);
            devicePolicyManager.setLockTaskPackages(componentName, strArr);
            return "✓ 锁定任务白名单已设置: " + Arrays.toString(strArr);
        }
        if ("set-keyguard-disabled".equals(str3)) {
            m13766AZxh(strArrSplit, 2, "set-keyguard-disabled <true|false>");
            boolean z2 = Boolean.parseBoolean(strArrSplit[2]);
            boolean keyguardDisabled = devicePolicyManager.setKeyguardDisabled(componentName, z2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(keyguardDisabled ? "✓ " : "✗ ");
            sb5.append("锁屏已");
            sb5.append(z2 ? "禁用" : "启用");
            return sb5.toString();
        }
        if (!"install-ca-cert".equals(str3)) {
            throw new IllegalArgumentException("未知命令: " + str3 + "（输入 help 查看命令列表）");
        }
        m13766AZxh(strArrSplit, 2, "install-ca-cert <证书crt路径>");
        File file = new File(strArrSplit[1]);
        if (!file.exists()) {
            throw new IllegalStateException("文件不存在: " + strArrSplit[1]);
        }
        int length2 = (int) file.length();
        byte[] bArr = new byte[length2];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (i < length2) {
            try {
                int i2 = fileInputStream.read(bArr, i, length2 - i);
                if (i2 >= 0) {
                    i += i2;
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
            }
        }
        if (!devicePolicyManager.installCaCert(componentName, bArr)) {
            return "✗ 安装失败（请确认是 PEM/DER 格式的 .crt）";
        }
        return "✓ CA 证书已安装: " + strArrSplit[1];
    }
}
