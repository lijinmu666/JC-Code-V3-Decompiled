package com.flyfishxu.p028kadb.p029cert.platform;

import android.os.Build;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u0003"}, m4988d2 = {"defaultDeviceName", BuildConfig.f24315FLAVOR, "software", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDefaultDeviceName.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDeviceName.android.kt\ncom/flyfishxu/kadb/cert/platform/DefaultDeviceName_androidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
/* loaded from: classes.dex */
public final class DefaultDeviceName_androidKt {
    public static final String defaultDeviceName(String str) {
        String string;
        if (str != null && (string = StringsKt.m6778trim((CharSequence) str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        String property = System.getProperty("user.name");
        if (property == null) {
            property = System.getenv("USER");
        }
        String str2 = System.getenv("HOSTNAME");
        if (str2 == null && (str2 = Build.HOST) == null) {
            str2 = Build.DEVICE;
        }
        return DefaultDeviceNameKt.formatDefaultDeviceName(property, str2);
    }

    public static /* synthetic */ String defaultDeviceName$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return defaultDeviceName(str);
    }
}
