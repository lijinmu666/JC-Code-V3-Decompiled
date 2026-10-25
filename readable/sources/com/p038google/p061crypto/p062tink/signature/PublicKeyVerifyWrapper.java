package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class PublicKeyVerifyWrapper implements PrimitiveWrapper<PublicKeyVerify, PublicKeyVerify> {

    /* renamed from: logger */
    private static final Logger f3866logger = Logger.getLogger(PublicKeyVerifyWrapper.class.getName());
    private static final byte[] FORMAT_VERSION = {0};

    /* renamed from: WRAPPER */
    private static final PublicKeyVerifyWrapper f3865WRAPPER = new PublicKeyVerifyWrapper();

    public static class WrappedPublicKeyVerify implements PublicKeyVerify {
        private final MonitoringClient.InterfaceC0485Logger monitoringLogger;
        private final PrimitiveSet<PublicKeyVerify> primitives;

        public WrappedPublicKeyVerify(PrimitiveSet<PublicKeyVerify> primitiveSet) {
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                this.monitoringLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "public_key_verify", "verify");
            } else {
                this.monitoringLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.PublicKeyVerify
        /* renamed from: verify */
        public void mo3387verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length <= 5) {
                this.monitoringLogger.logFailure();
                throw new GeneralSecurityException("signature too short");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (PrimitiveSet.C0320Entry<PublicKeyVerify> c0320Entry : this.primitives.getPrimitive(bArrCopyOf)) {
                try {
                    c0320Entry.getPrimitive().mo3387verify(bArrCopyOfRange, c0320Entry.getOutputPrefixType().equals(OutputPrefixType.LEGACY) ? C0853Bytes.m4229concat(bArr2, PublicKeyVerifyWrapper.FORMAT_VERSION) : bArr2);
                    this.monitoringLogger.mo3490log(c0320Entry.getKeyId(), r3.length);
                    return;
                } catch (GeneralSecurityException e) {
                    PublicKeyVerifyWrapper.f3866logger.info("signature prefix matches a key, but cannot verify: " + e);
                }
            }
            for (PrimitiveSet.C0320Entry<PublicKeyVerify> c0320Entry2 : this.primitives.getRawPrimitives()) {
                try {
                    c0320Entry2.getPrimitive().mo3387verify(bArr, bArr2);
                    this.monitoringLogger.mo3490log(c0320Entry2.getKeyId(), bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.monitoringLogger.logFailure();
            throw new GeneralSecurityException("invalid signature");
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3865WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<PublicKeyVerify> getInputPrimitiveClass() {
        return PublicKeyVerify.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<PublicKeyVerify> getPrimitiveClass() {
        return PublicKeyVerify.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public PublicKeyVerify mo3385wrap(PrimitiveSet<PublicKeyVerify> primitiveSet) {
        return new WrappedPublicKeyVerify(primitiveSet);
    }
}
