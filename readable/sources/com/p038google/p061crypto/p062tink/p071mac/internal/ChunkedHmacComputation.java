package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.InsecureSecretKeyAccess;
import com.p038google.p061crypto.p062tink.p071mac.C0465HmacKey;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation;
import com.p038google.p061crypto.p062tink.p071mac.HmacParameters;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@AccessesPartialKey
/* loaded from: classes.dex */
final class ChunkedHmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};
    private boolean finalized = false;

    /* renamed from: key */
    private final C0465HmacKey f3178key;

    /* renamed from: mac */
    private final Mac f3179mac;

    public ChunkedHmacComputation(C0465HmacKey c0465HmacKey) throws InvalidKeyException {
        Mac engineFactory = EngineFactory.f3962MAC.getInstance(composeAlgorithmName(c0465HmacKey));
        this.f3179mac = engineFactory;
        engineFactory.init(new SecretKeySpec(c0465HmacKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.m3332get()), "HMAC"));
        this.f3178key = c0465HmacKey;
    }

    private static String composeAlgorithmName(C0465HmacKey c0465HmacKey) {
        return "HMAC" + c0465HmacKey.getParameters().getHashType();
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation
    public byte[] computeMac() {
        if (this.finalized) {
            throw new IllegalStateException("Cannot compute after already computing the MAC tag. Please create a new object.");
        }
        if (this.f3178key.getParameters().getVariant() == HmacParameters.C0471Variant.f3163LEGACY) {
            mo3518update(ByteBuffer.wrap(FORMAT_VERSION));
        }
        this.finalized = true;
        return C0853Bytes.m4229concat(this.f3178key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.f3179mac.doFinal(), this.f3178key.getParameters().getCryptographicTagSizeBytes()));
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation
    /* renamed from: update */
    public void mo3518update(ByteBuffer byteBuffer) {
        if (this.finalized) {
            throw new IllegalStateException("Cannot update after computing the MAC tag. Please create a new object.");
        }
        this.f3179mac.update(byteBuffer);
    }
}
