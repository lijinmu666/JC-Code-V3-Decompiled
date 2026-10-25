package com.p038google.p061crypto.p062tink.p071mac.internal;

import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.InsecureSecretKeyAccess;
import com.p038google.p061crypto.p062tink.p071mac.AesCmacKey;
import com.p038google.p061crypto.p062tink.p071mac.AesCmacParameters;
import com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

@AccessesPartialKey
/* loaded from: classes.dex */
final class ChunkedAesCmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = {0};

    /* renamed from: aes */
    private final Cipher f3169aes;
    private boolean finalized = false;

    /* renamed from: key */
    private final AesCmacKey f3170key;
    private final ByteBuffer localStash;

    /* renamed from: subKey1 */
    private final byte[] f3171subKey1;

    /* renamed from: subKey2 */
    private final byte[] f3172subKey2;

    /* renamed from: x */
    private final ByteBuffer f3173x;

    /* renamed from: y */
    private final ByteBuffer f3174y;

    public ChunkedAesCmacComputation(AesCmacKey aesCmacKey) throws InvalidKeyException {
        this.f3170key = aesCmacKey;
        Cipher engineFactory = EngineFactory.f3961CIPHER.getInstance("AES/ECB/NoPadding");
        this.f3169aes = engineFactory;
        engineFactory.init(1, new SecretKeySpec(aesCmacKey.getAesKey().toByteArray(InsecureSecretKeyAccess.m3332get()), "AES"));
        byte[] bArrM3531dbl = C0478AesUtil.m3531dbl(engineFactory.doFinal(new byte[16]));
        this.f3171subKey1 = bArrM3531dbl;
        this.f3172subKey2 = C0478AesUtil.m3531dbl(bArrM3531dbl);
        this.localStash = ByteBuffer.allocate(16);
        this.f3173x = ByteBuffer.allocate(16);
        this.f3174y = ByteBuffer.allocate(16);
    }

    /* renamed from: munch */
    private void m3532munch(ByteBuffer byteBuffer) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        this.f3174y.rewind();
        this.f3173x.rewind();
        C0853Bytes.m4231xor(this.f3174y, this.f3173x, byteBuffer, 16);
        this.f3174y.rewind();
        this.f3173x.rewind();
        this.f3169aes.doFinal(this.f3174y, this.f3173x);
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation
    public byte[] computeMac() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (this.finalized) {
            throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
        }
        if (this.f3170key.getParameters().getVariant() == AesCmacParameters.C0462Variant.f3149LEGACY) {
            mo3518update(ByteBuffer.wrap(FORMAT_VERSION));
        }
        this.finalized = true;
        return C0853Bytes.m4229concat(this.f3170key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.f3169aes.doFinal(C0853Bytes.m4233xor(this.localStash.remaining() > 0 ? C0853Bytes.m4233xor(C0478AesUtil.m3530cmacPad(Arrays.copyOf(this.localStash.array(), this.localStash.position())), this.f3172subKey2) : C0853Bytes.m4232xor(this.localStash.array(), 0, this.f3171subKey1, 0, 16), this.f3173x.array())), this.f3170key.getParameters().getCryptographicTagSizeBytes()));
    }

    @Override // com.p038google.p061crypto.p062tink.p071mac.ChunkedMacComputation
    /* renamed from: update */
    public void mo3518update(ByteBuffer byteBuffer) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (this.finalized) {
            throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
        }
        if (this.localStash.remaining() != 16) {
            int iMin = Math.min(this.localStash.remaining(), byteBuffer.remaining());
            for (int i = 0; i < iMin; i++) {
                this.localStash.put(byteBuffer.get());
            }
        }
        if (this.localStash.remaining() == 0 && byteBuffer.remaining() > 0) {
            this.localStash.rewind();
            m3532munch(this.localStash);
            this.localStash.rewind();
        }
        while (byteBuffer.remaining() > 16) {
            m3532munch(byteBuffer);
        }
        this.localStash.put(byteBuffer);
    }
}
