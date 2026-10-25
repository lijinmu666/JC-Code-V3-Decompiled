package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {

    /* renamed from: WRAPPER */
    private static final HybridEncryptWrapper f3077WRAPPER = new HybridEncryptWrapper();

    public static class WrappedHybridEncrypt implements HybridEncrypt {
        private final MonitoringClient.InterfaceC0485Logger encLogger;
        final PrimitiveSet<HybridEncrypt> primitives;

        public WrappedHybridEncrypt(PrimitiveSet<HybridEncrypt> primitiveSet) {
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                this.encLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "hybrid_encrypt", "encrypt");
            } else {
                this.encLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.HybridEncrypt
        /* renamed from: encrypt */
        public byte[] mo3331encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (this.primitives.getPrimary() == null) {
                this.encLogger.logFailure();
                throw new GeneralSecurityException("keyset without primary key");
            }
            try {
                byte[] bArrM4229concat = C0853Bytes.m4229concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().mo3331encrypt(bArr, bArr2));
                this.encLogger.mo3490log(this.primitives.getPrimary().getKeyId(), bArr.length);
                return bArrM4229concat;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3077WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<HybridEncrypt> getInputPrimitiveClass() {
        return HybridEncrypt.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<HybridEncrypt> getPrimitiveClass() {
        return HybridEncrypt.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public HybridEncrypt mo3385wrap(PrimitiveSet<HybridEncrypt> primitiveSet) {
        return new WrappedHybridEncrypt(primitiveSet);
    }
}
