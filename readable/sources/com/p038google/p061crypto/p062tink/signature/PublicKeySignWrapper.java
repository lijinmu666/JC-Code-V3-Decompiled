package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.MonitoringUtil;
import com.p038google.p061crypto.p062tink.internal.MutableMonitoringRegistry;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringClient;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class PublicKeySignWrapper implements PrimitiveWrapper<PublicKeySign, PublicKeySign> {
    private static final byte[] FORMAT_VERSION = {0};

    /* renamed from: WRAPPER */
    private static final PublicKeySignWrapper f3863WRAPPER = new PublicKeySignWrapper();

    public static class WrappedPublicKeySign implements PublicKeySign {

        /* renamed from: logger */
        private final MonitoringClient.InterfaceC0485Logger f3864logger;
        private final PrimitiveSet<PublicKeySign> primitives;

        public WrappedPublicKeySign(PrimitiveSet<PublicKeySign> primitiveSet) {
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                this.f3864logger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitiveSet), "public_key_sign", "sign");
            } else {
                this.f3864logger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.PublicKeySign
        /* renamed from: sign */
        public byte[] mo3386sign(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                bArr = C0853Bytes.m4229concat(bArr, PublicKeySignWrapper.FORMAT_VERSION);
            }
            try {
                byte[] bArrM4229concat = C0853Bytes.m4229concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().mo3386sign(bArr));
                this.f3864logger.mo3490log(this.primitives.getPrimary().getKeyId(), bArr.length);
                return bArrM4229concat;
            } catch (GeneralSecurityException e) {
                this.f3864logger.logFailure();
                throw e;
            }
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3863WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<PublicKeySign> getInputPrimitiveClass() {
        return PublicKeySign.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<PublicKeySign> getPrimitiveClass() {
        return PublicKeySign.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public PublicKeySign mo3385wrap(PrimitiveSet<PublicKeySign> primitiveSet) {
        return new WrappedPublicKeySign(primitiveSet);
    }
}
