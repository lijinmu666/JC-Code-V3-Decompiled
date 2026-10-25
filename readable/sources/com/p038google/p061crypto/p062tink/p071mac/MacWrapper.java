package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.InterfaceC0317Mac;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringKeysetInfo;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class MacWrapper implements PrimitiveWrapper<InterfaceC0317Mac, InterfaceC0317Mac> {

    /* renamed from: logger */
    private static final Logger f3168logger = Logger.getLogger(MacWrapper.class.getName());
    private static final byte[] FORMAT_VERSION = {0};

    /* renamed from: WRAPPER */
    private static final MacWrapper f3167WRAPPER = new MacWrapper();

    public static class WrappedMac implements InterfaceC0317Mac {
        private final MonitoringClient.InterfaceC0485Logger computeLogger;
        private final PrimitiveSet<InterfaceC0317Mac> primitives;
        private final MonitoringClient.InterfaceC0485Logger verifyLogger;

        @Override // com.p038google.p061crypto.p062tink.InterfaceC0317Mac
        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                bArr = C0853Bytes.m4229concat(bArr, MacWrapper.FORMAT_VERSION);
            }
            try {
                byte[] bArrM4229concat = C0853Bytes.m4229concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(bArr));
                this.computeLogger.mo3490log(this.primitives.getPrimary().getKeyId(), bArr.length);
                return bArrM4229concat;
            } catch (GeneralSecurityException e) {
                this.computeLogger.logFailure();
                throw e;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.InterfaceC0317Mac
        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length <= 5) {
                this.verifyLogger.logFailure();
                throw new GeneralSecurityException("tag too short");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (PrimitiveSet.C0320Entry<InterfaceC0317Mac> c0320Entry : this.primitives.getPrimitive(bArrCopyOf)) {
                try {
                    c0320Entry.getPrimitive().verifyMac(bArrCopyOfRange, c0320Entry.getOutputPrefixType().equals(OutputPrefixType.LEGACY) ? C0853Bytes.m4229concat(bArr2, MacWrapper.FORMAT_VERSION) : bArr2);
                    this.verifyLogger.mo3490log(c0320Entry.getKeyId(), r3.length);
                    return;
                } catch (GeneralSecurityException e) {
                    MacWrapper.f3168logger.info("tag prefix matches a key, but cannot verify: " + e);
                }
            }
            for (PrimitiveSet.C0320Entry<InterfaceC0317Mac> c0320Entry2 : this.primitives.getRawPrimitives()) {
                try {
                    c0320Entry2.getPrimitive().verifyMac(bArr, bArr2);
                    this.verifyLogger.mo3490log(c0320Entry2.getKeyId(), bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.verifyLogger.logFailure();
            throw new GeneralSecurityException("invalid MAC");
        }

        private WrappedMac(PrimitiveSet<InterfaceC0317Mac> primitiveSet) {
            this.primitives = primitiveSet;
            if (!primitiveSet.hasAnnotations()) {
                MonitoringClient.InterfaceC0485Logger interfaceC0485Logger = MonitoringUtil.DO_NOTHING_LOGGER;
                this.computeLogger = interfaceC0485Logger;
                this.verifyLogger = interfaceC0485Logger;
            } else {
                MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                MonitoringKeysetInfo monitoringKeysetInfo = MonitoringUtil.getMonitoringKeysetInfo(primitiveSet);
                this.computeLogger = monitoringClient.createLogger(monitoringKeysetInfo, "mac", "compute");
                this.verifyLogger = monitoringClient.createLogger(monitoringKeysetInfo, "mac", "verify");
            }
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3167WRAPPER);
    }

    private void validateMacKeyPrefixes(PrimitiveSet<InterfaceC0317Mac> primitiveSet) throws GeneralSecurityException {
        Iterator<List<PrimitiveSet.C0320Entry<InterfaceC0317Mac>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.C0320Entry<InterfaceC0317Mac> c0320Entry : it.next()) {
                if (c0320Entry.m3383getKey() instanceof AbstractC0475MacKey) {
                    AbstractC0475MacKey abstractC0475MacKey = (AbstractC0475MacKey) c0320Entry.m3383getKey();
                    C0878Bytes c0878BytesCopyFrom = C0878Bytes.copyFrom(c0320Entry.getIdentifier());
                    if (!c0878BytesCopyFrom.m4291equals(abstractC0475MacKey.getOutputPrefix())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + abstractC0475MacKey.getParameters() + " has wrong output prefix (" + abstractC0475MacKey.getOutputPrefix() + ") instead of (" + c0878BytesCopyFrom + ")");
                    }
                }
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0317Mac> getInputPrimitiveClass() {
        return InterfaceC0317Mac.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0317Mac> getPrimitiveClass() {
        return InterfaceC0317Mac.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public InterfaceC0317Mac mo3385wrap(PrimitiveSet<InterfaceC0317Mac> primitiveSet) throws GeneralSecurityException {
        validateMacKeyPrefixes(primitiveSet);
        return new WrappedMac(primitiveSet);
    }
}
