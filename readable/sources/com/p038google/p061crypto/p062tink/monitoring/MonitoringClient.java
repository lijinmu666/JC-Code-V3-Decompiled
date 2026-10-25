package com.p038google.p061crypto.p062tink.monitoring;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public interface MonitoringClient {

    /* renamed from: com.google.crypto.tink.monitoring.MonitoringClient$Logger */
    public interface InterfaceC0485Logger {
        /* renamed from: log */
        void mo3490log(int i, long j);

        void logFailure();
    }

    InterfaceC0485Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2);
}
