package com.p038google.p061crypto.p062tink.p066daead;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringKeysetInfo;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {

    /* renamed from: logger */
    private static final Logger f3072logger = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    /* renamed from: WRAPPER */
    private static final DeterministicAeadWrapper f3071WRAPPER = new DeterministicAeadWrapper();

    public static class WrappedDeterministicAead implements DeterministicAead {
        private final MonitoringClient.InterfaceC0485Logger decLogger;
        private final MonitoringClient.InterfaceC0485Logger encLogger;
        private final PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitiveSet) {
            this.primitives = primitiveSet;
            if (!primitiveSet.hasAnnotations()) {
                MonitoringClient.InterfaceC0485Logger interfaceC0485Logger = MonitoringUtil.DO_NOTHING_LOGGER;
                this.encLogger = interfaceC0485Logger;
                this.decLogger = interfaceC0485Logger;
            } else {
                MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                MonitoringKeysetInfo monitoringKeysetInfo = MonitoringUtil.getMonitoringKeysetInfo(primitiveSet);
                this.encLogger = monitoringClient.createLogger(monitoringKeysetInfo, "daead", "encrypt");
                this.decLogger = monitoringClient.createLogger(monitoringKeysetInfo, "daead", "decrypt");
            }
        }

        @Override // com.p038google.p061crypto.p062tink.DeterministicAead
        public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.C0320Entry<DeterministicAead> c0320Entry : this.primitives.getPrimitive(bArrCopyOf)) {
                    try {
                        byte[] bArrDecryptDeterministically = c0320Entry.getPrimitive().decryptDeterministically(bArrCopyOfRange, bArr2);
                        this.decLogger.mo3490log(c0320Entry.getKeyId(), bArrCopyOfRange.length);
                        return bArrDecryptDeterministically;
                    } catch (GeneralSecurityException e) {
                        DeterministicAeadWrapper.f3072logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e);
                    }
                }
            }
            for (PrimitiveSet.C0320Entry<DeterministicAead> c0320Entry2 : this.primitives.getRawPrimitives()) {
                try {
                    byte[] bArrDecryptDeterministically2 = c0320Entry2.getPrimitive().decryptDeterministically(bArr, bArr2);
                    this.decLogger.mo3490log(c0320Entry2.getKeyId(), bArr.length);
                    return bArrDecryptDeterministically2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }

        @Override // com.p038google.p061crypto.p062tink.DeterministicAead
        public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrM4229concat = C0853Bytes.m4229concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().encryptDeterministically(bArr, bArr2));
                this.encLogger.mo3490log(this.primitives.getPrimary().getKeyId(), bArr.length);
                return bArrM4229concat;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3071WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<DeterministicAead> getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public DeterministicAead mo3385wrap(PrimitiveSet<DeterministicAead> primitiveSet) {
        return new WrappedDeterministicAead(primitiveSet);
    }
}
