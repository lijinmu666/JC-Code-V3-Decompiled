package com.flyfishxu.p028kadb.p033pair;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.security.auth.Destroyable;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMModeCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C3409b7;

@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "Ljavax/security/auth/Destroyable;", "mSpake2Ctx", "Lcom/flyfish233/crypto/spake2/Spake2Context;", "password", BuildConfig.f24315FLAVOR, "<init>", "(Lcom/flyfish233/crypto/spake2/Spake2Context;[B)V", "msg", "getMsg", "()[B", "mSecretKey", "mDecIv", BuildConfig.f24315FLAVOR, "mEncIv", "mIsDestroyed", BuildConfig.f24315FLAVOR, "initCipher", "theirMsg", "encrypt", "input", "decrypt", "isDestroyed", "destroy", BuildConfig.f24315FLAVOR, "encryptDecrypt", "forEncryption", "in", "iv", "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingAuthCtx implements Destroyable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long mDecIv;
    private long mEncIv;
    private boolean mIsDestroyed;
    private final byte[] mSecretKey;
    private final C3409b7 mSpake2Ctx;
    private final byte[] msg;

    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/PairingAuthCtx$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PairingAuthCtx(C3409b7 mSpake2Ctx, byte[] password) {
        Intrinsics.checkNotNullParameter(mSpake2Ctx, "mSpake2Ctx");
        Intrinsics.checkNotNullParameter(password, "password");
        this.mSpake2Ctx = mSpake2Ctx;
        byte[] bArrM11459ZfxDd = mSpake2Ctx.m11459ZfxDd(password);
        Intrinsics.checkNotNullExpressionValue(bArrM11459ZfxDd, "generateMessage(...)");
        this.msg = bArrM11459ZfxDd;
        this.mSecretKey = new byte[PairingAuthCtx_androidKt.getHKDF_KEY_LENGTH()];
    }

    private final byte[] encryptDecrypt(boolean forEncryption, byte[] in, byte[] iv) {
        if (this.mIsDestroyed) {
            return null;
        }
        AEADParameters aEADParameters = new AEADParameters(new KeyParameter(this.mSecretKey), this.mSecretKey.length * 8, iv);
        GCMModeCipher gCMModeCipherNewInstance = GCMBlockCipher.newInstance(AESEngine.newInstance());
        gCMModeCipherNewInstance.mo15226init(forEncryption, aEADParameters);
        byte[] bArr = new byte[gCMModeCipherNewInstance.getOutputSize(in.length)];
        try {
            gCMModeCipherNewInstance.mo15224doFinal(bArr, gCMModeCipherNewInstance.processBytes(in, 0, in.length, bArr, 0));
            return bArr;
        } catch (InvalidCipherTextException unused) {
            return null;
        }
    }

    /* renamed from: decrypt */
    public final byte[] m2263decrypt(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(PairingAuthCtx_androidKt.getGCM_IV_LENGTH()).order(ByteOrder.LITTLE_ENDIAN);
        long j = this.mDecIv;
        this.mDecIv = 1 + j;
        byte[] bArrArray = byteBufferOrder.putLong(j).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return encryptDecrypt(false, input, bArrArray);
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        this.mIsDestroyed = true;
        Arrays.fill(this.mSecretKey, (byte) 0);
        this.mSpake2Ctx.destroy();
    }

    /* renamed from: encrypt */
    public final byte[] m2264encrypt(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(PairingAuthCtx_androidKt.getGCM_IV_LENGTH()).order(ByteOrder.LITTLE_ENDIAN);
        long j = this.mEncIv;
        this.mEncIv = 1 + j;
        byte[] bArrArray = byteBufferOrder.putLong(j).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return encryptDecrypt(true, input, bArrArray);
    }

    public final byte[] getMsg() {
        return this.msg;
    }

    public final boolean initCipher(byte[] theirMsg) {
        byte[] bArrM11457Pq;
        if (this.mIsDestroyed || (bArrM11457Pq = this.mSpake2Ctx.m11457Pq(theirMsg)) == null) {
            return false;
        }
        HKDFBytesGenerator hKDFBytesGenerator = new HKDFBytesGenerator(new SHA256Digest());
        hKDFBytesGenerator.mo14966init(new HKDFParameters(bArrM11457Pq, null, PairingAuthCtx_androidKt.m2266getINFO()));
        byte[] bArr = this.mSecretKey;
        hKDFBytesGenerator.generateBytes(bArr, 0, bArr.length);
        return true;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }
}
