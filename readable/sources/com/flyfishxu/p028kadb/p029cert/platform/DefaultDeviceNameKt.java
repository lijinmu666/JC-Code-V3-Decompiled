package com.flyfishxu.p028kadb.p029cert.platform;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, m4988d2 = {"formatDefaultDeviceName", BuildConfig.f24315FLAVOR, "loginName", "hostName", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDefaultDeviceName.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDeviceName.kt\ncom/flyfishxu/kadb/cert/platform/DefaultDeviceNameKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
/* loaded from: classes.dex */
public final class DefaultDeviceNameKt {
    public static final String formatDefaultDeviceName(String str, String str2) {
        return formatDefaultDeviceName$normalize(str) + "@" + formatDefaultDeviceName$normalize(str2);
    }

    private static final String formatDefaultDeviceName$normalize(String str) {
        String string;
        if (str != null && (string = StringsKt.m6778trim((CharSequence) str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return "unknown";
    }
}
