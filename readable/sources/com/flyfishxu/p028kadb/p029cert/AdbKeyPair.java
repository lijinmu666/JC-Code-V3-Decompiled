package com.flyfishxu.p028kadb.p029cert;

import com.flyfishxu.p028kadb.p030core.AdbMessage;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/AdbKeyPair;", BuildConfig.f24315FLAVOR, "privateKey", "Ljava/security/PrivateKey;", "publicKey", "Ljava/security/PublicKey;", "certificate", "Ljava/security/cert/Certificate;", "<init>", "(Ljava/security/PrivateKey;Ljava/security/PublicKey;Ljava/security/cert/Certificate;)V", "getPrivateKey", "()Ljava/security/PrivateKey;", "getPublicKey", "()Ljava/security/PublicKey;", "getCertificate", "()Ljava/security/cert/Certificate;", "signPayload", BuildConfig.f24315FLAVOR, "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "signPayload$com_github_IndiTheo_kadb", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbKeyPair {
    private final Certificate certificate;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public AdbKeyPair(PrivateKey privateKey, PublicKey publicKey, Certificate certificate) {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.certificate = certificate;
    }

    public final Certificate getCertificate() {
        return this.certificate;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final PublicKey getPublicKey() {
        return this.publicKey;
    }

    public final byte[] signPayload$com_github_IndiTheo_kadb(AdbMessage message) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(message, "message");
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, this.privateKey);
        cipher.update(AndroidPubkey.INSTANCE.getSIGNATURE_PADDING());
        byte[] bArrDoFinal = cipher.doFinal(message.getPayload(), 0, message.getPayloadLength());
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }
}
