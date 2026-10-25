package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
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
public class AeadWrapper implements PrimitiveWrapper<InterfaceC0305Aead, InterfaceC0305Aead> {

    /* renamed from: logger */
    private static final Logger f3025logger = Logger.getLogger(AeadWrapper.class.getName());

    /* renamed from: WRAPPER */
    private static final AeadWrapper f3024WRAPPER = new AeadWrapper();

    public static class WrappedAead implements InterfaceC0305Aead {
        private final MonitoringClient.InterfaceC0485Logger decLogger;
        private final MonitoringClient.InterfaceC0485Logger encLogger;

        /* renamed from: pSet */
        private final PrimitiveSet<InterfaceC0305Aead> f3026pSet;

        @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
        /* renamed from: decrypt */
        public byte[] mo3322decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.C0320Entry<InterfaceC0305Aead> c0320Entry : this.f3026pSet.getPrimitive(bArrCopyOf)) {
                    try {
                        byte[] bArrMo3322decrypt = c0320Entry.getPrimitive().mo3322decrypt(bArrCopyOfRange, bArr2);
                        this.decLogger.mo3490log(c0320Entry.getKeyId(), bArrCopyOfRange.length);
                        return bArrMo3322decrypt;
                    } catch (GeneralSecurityException e) {
                        AeadWrapper.f3025logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e);
                    }
                }
            }
            for (PrimitiveSet.C0320Entry<InterfaceC0305Aead> c0320Entry2 : this.f3026pSet.getRawPrimitives()) {
                try {
                    byte[] bArrMo3322decrypt2 = c0320Entry2.getPrimitive().mo3322decrypt(bArr, bArr2);
                    this.decLogger.mo3490log(c0320Entry2.getKeyId(), bArr.length);
                    return bArrMo3322decrypt2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }

        @Override // com.p038google.p061crypto.p062tink.InterfaceC0305Aead
        /* renamed from: encrypt */
        public byte[] mo3323encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrM4229concat = C0853Bytes.m4229concat(this.f3026pSet.getPrimary().getIdentifier(), this.f3026pSet.getPrimary().getPrimitive().mo3323encrypt(bArr, bArr2));
                this.encLogger.mo3490log(this.f3026pSet.getPrimary().getKeyId(), bArr.length);
                return bArrM4229concat;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }

        private WrappedAead(PrimitiveSet<InterfaceC0305Aead> primitiveSet) {
            this.f3026pSet = primitiveSet;
            if (!primitiveSet.hasAnnotations()) {
                MonitoringClient.InterfaceC0485Logger interfaceC0485Logger = MonitoringUtil.DO_NOTHING_LOGGER;
                this.encLogger = interfaceC0485Logger;
                this.decLogger = interfaceC0485Logger;
            } else {
                MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                MonitoringKeysetInfo monitoringKeysetInfo = MonitoringUtil.getMonitoringKeysetInfo(primitiveSet);
                this.encLogger = monitoringClient.createLogger(monitoringKeysetInfo, "aead", "encrypt");
                this.decLogger = monitoringClient.createLogger(monitoringKeysetInfo, "aead", "decrypt");
            }
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3024WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0305Aead> getInputPrimitiveClass() {
        return InterfaceC0305Aead.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0305Aead> getPrimitiveClass() {
        return InterfaceC0305Aead.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public InterfaceC0305Aead mo3385wrap(PrimitiveSet<InterfaceC0305Aead> primitiveSet) {
        return new WrappedAead(primitiveSet);
    }
}
