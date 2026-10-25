package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.KeyStatus;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringKeysetInfo;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MonitoringUtil {
    public static final MonitoringClient.InterfaceC0485Logger DO_NOTHING_LOGGER = new DoNothingLogger(null);
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/google.crypto.";

    /* renamed from: com.google.crypto.tink.internal.MonitoringUtil$1 */
    public static /* synthetic */ class C04221 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.m3793values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class DoNothingLogger implements MonitoringClient.InterfaceC0485Logger {
        private DoNothingLogger() {
        }

        @Override // com.p038google.p061crypto.p062tink.monitoring.MonitoringClient.InterfaceC0485Logger
        /* renamed from: log */
        public void mo3490log(int i, long j) {
        }

        @Override // com.p038google.p061crypto.p062tink.monitoring.MonitoringClient.InterfaceC0485Logger
        public void logFailure() {
        }

        public /* synthetic */ DoNothingLogger(C04221 c04221) {
            this();
        }
    }

    private MonitoringUtil() {
    }

    public static <P> MonitoringKeysetInfo getMonitoringKeysetInfo(PrimitiveSet<P> primitiveSet) {
        MonitoringKeysetInfo.C0487Builder c0487BuilderNewBuilder = MonitoringKeysetInfo.newBuilder();
        c0487BuilderNewBuilder.setAnnotations(primitiveSet.getAnnotations());
        Iterator<List<PrimitiveSet.C0320Entry<P>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.C0320Entry<P> c0320Entry : it.next()) {
                c0487BuilderNewBuilder.addEntry(parseStatus(c0320Entry.getStatus()), c0320Entry.getKeyId(), parseKeyTypeUrl(c0320Entry.getKeyType()), c0320Entry.getOutputPrefixType().name());
            }
        }
        if (primitiveSet.getPrimary() != null) {
            c0487BuilderNewBuilder.setPrimaryKeyId(primitiveSet.getPrimary().getKeyId());
        }
        try {
            return c0487BuilderNewBuilder.m3539build();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String parseKeyTypeUrl(String str) {
        return !str.startsWith(TYPE_URL_PREFIX) ? str : str.substring(34);
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) {
        int i = C04221.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatus.f2991ENABLED;
        }
        if (i == 2) {
            return KeyStatus.DISABLED;
        }
        if (i == 3) {
            return KeyStatus.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }
}
