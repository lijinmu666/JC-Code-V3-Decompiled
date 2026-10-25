package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringKeysetInfo;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class MutableMonitoringRegistry {
    private final AtomicReference<MonitoringClient> monitoringClient = new AtomicReference<>();
    private static final MutableMonitoringRegistry GLOBAL_INSTANCE = new MutableMonitoringRegistry();
    private static final DoNothingClient DO_NOTHING_CLIENT = new DoNothingClient();

    public static class DoNothingClient implements MonitoringClient {
        private DoNothingClient() {
        }

        @Override // com.p038google.p061crypto.p062tink.monitoring.MonitoringClient
        public MonitoringClient.InterfaceC0485Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2) {
            return MonitoringUtil.DO_NOTHING_LOGGER;
        }
    }

    public static MutableMonitoringRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    /* renamed from: clear */
    public synchronized void m3491clear() {
        this.monitoringClient.set(null);
    }

    public MonitoringClient getMonitoringClient() {
        MonitoringClient monitoringClient = this.monitoringClient.get();
        return monitoringClient == null ? DO_NOTHING_CLIENT : monitoringClient;
    }

    public synchronized void registerMonitoringClient(MonitoringClient monitoringClient) {
        if (this.monitoringClient.get() != null) {
            throw new IllegalStateException("a monitoring client has already been registered");
        }
        this.monitoringClient.set(monitoringClient);
    }
}
