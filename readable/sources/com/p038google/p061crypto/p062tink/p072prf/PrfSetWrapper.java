package com.p038google.p061crypto.p062tink.p072prf;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PrfSetWrapper implements PrimitiveWrapper<InterfaceC0504Prf, AbstractC0506PrfSet> {

    /* renamed from: WRAPPER */
    private static final PrfSetWrapper f3201WRAPPER = new PrfSetWrapper();

    public static class WrappedPrfSet extends AbstractC0506PrfSet {
        private final Map<Integer, InterfaceC0504Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        public static class PrfWithMonitoring implements InterfaceC0504Prf {

            /* renamed from: keyId */
            private final int f3202keyId;

            /* renamed from: logger */
            private final MonitoringClient.InterfaceC0485Logger f3203logger;

            /* renamed from: prf */
            private final InterfaceC0504Prf f3204prf;

            public PrfWithMonitoring(InterfaceC0504Prf interfaceC0504Prf, int i, MonitoringClient.InterfaceC0485Logger interfaceC0485Logger) {
                this.f3204prf = interfaceC0504Prf;
                this.f3202keyId = i;
                this.f3203logger = interfaceC0485Logger;
            }

            @Override // com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf
            /* renamed from: compute */
            public byte[] mo3552compute(byte[] bArr, int i) throws GeneralSecurityException {
                try {
                    byte[] bArrMo3552compute = this.f3204prf.mo3552compute(bArr, i);
                    this.f3203logger.mo3490log(this.f3202keyId, bArr.length);
                    return bArrMo3552compute;
                } catch (GeneralSecurityException e) {
                    this.f3203logger.logFailure();
                    throw e;
                }
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p072prf.AbstractC0506PrfSet
        /* renamed from: getPrfs */
        public Map<Integer, InterfaceC0504Prf> mo3553getPrfs() {
            return this.keyIdToPrfMap;
        }

        @Override // com.p038google.p061crypto.p062tink.p072prf.AbstractC0506PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        private WrappedPrfSet(PrimitiveSet<InterfaceC0504Prf> primitiveSet) throws GeneralSecurityException {
            if (primitiveSet.getRawPrimitives().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            }
            if (primitiveSet.getPrimary() == null) {
                throw new GeneralSecurityException("Primary key not set.");
            }
            MonitoringClient.InterfaceC0485Logger interfaceC0485LoggerCreateLogger = primitiveSet.hasAnnotations() ? MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "prf", "compute") : MonitoringUtil.DO_NOTHING_LOGGER;
            this.primaryKeyId = primitiveSet.getPrimary().getKeyId();
            List<PrimitiveSet.C0320Entry<InterfaceC0504Prf>> rawPrimitives = primitiveSet.getRawPrimitives();
            HashMap map = new HashMap();
            for (PrimitiveSet.C0320Entry<InterfaceC0504Prf> c0320Entry : rawPrimitives) {
                if (!c0320Entry.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                    throw new GeneralSecurityException("Key " + c0320Entry.getKeyId() + " has non raw prefix type");
                }
                map.put(Integer.valueOf(c0320Entry.getKeyId()), new PrfWithMonitoring(c0320Entry.getPrimitive(), c0320Entry.getKeyId(), interfaceC0485LoggerCreateLogger));
            }
            this.keyIdToPrfMap = Collections.unmodifiableMap(map);
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3201WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0504Prf> getInputPrimitiveClass() {
        return InterfaceC0504Prf.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<AbstractC0506PrfSet> getPrimitiveClass() {
        return AbstractC0506PrfSet.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public AbstractC0506PrfSet mo3385wrap(PrimitiveSet<InterfaceC0504Prf> primitiveSet) {
        return new WrappedPrfSet(primitiveSet);
    }
}
