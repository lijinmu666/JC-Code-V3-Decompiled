package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt> {

    /* renamed from: logger */
    private static final Logger f3076logger = Logger.getLogger(HybridDecryptWrapper.class.getName());

    /* renamed from: WRAPPER */
    private static final HybridDecryptWrapper f3075WRAPPER = new HybridDecryptWrapper();

    public static class WrappedHybridDecrypt implements HybridDecrypt {
        private final MonitoringClient.InterfaceC0485Logger decLogger;
        private final PrimitiveSet<HybridDecrypt> primitives;

        public WrappedHybridDecrypt(PrimitiveSet<HybridDecrypt> primitiveSet) {
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                this.decLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "hybrid_decrypt", "decrypt");
            } else {
                this.decLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.HybridDecrypt
        /* renamed from: decrypt */
        public byte[] mo3330decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.C0320Entry<HybridDecrypt> c0320Entry : this.primitives.getPrimitive(bArrCopyOfRange)) {
                    try {
                        byte[] bArrMo3330decrypt = c0320Entry.getPrimitive().mo3330decrypt(bArrCopyOfRange2, bArr2);
                        this.decLogger.mo3490log(c0320Entry.getKeyId(), bArrCopyOfRange2.length);
                        return bArrMo3330decrypt;
                    } catch (GeneralSecurityException e) {
                        HybridDecryptWrapper.f3076logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            for (PrimitiveSet.C0320Entry<HybridDecrypt> c0320Entry2 : this.primitives.getRawPrimitives()) {
                try {
                    byte[] bArrMo3330decrypt2 = c0320Entry2.getPrimitive().mo3330decrypt(bArr, bArr2);
                    this.decLogger.mo3490log(c0320Entry2.getKeyId(), bArr.length);
                    return bArrMo3330decrypt2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3075WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<HybridDecrypt> getInputPrimitiveClass() {
        return HybridDecrypt.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<HybridDecrypt> getPrimitiveClass() {
        return HybridDecrypt.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public HybridDecrypt mo3385wrap(PrimitiveSet<HybridDecrypt> primitiveSet) {
        return new WrappedHybridDecrypt(primitiveSet);
    }
}
