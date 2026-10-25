package cafe.cryptography.p026ed25519;

import cafe.cryptography.curve25519.C0186Scalar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import p132okio.C5066Utf8;

/* loaded from: classes.dex */
public class Ed25519PrivateKey {

    /* renamed from: secret */
    private final byte[] f1998secret;

    private Ed25519PrivateKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Invalid private key");
        }
        this.f1998secret = Arrays.copyOf(bArr, bArr.length);
    }

    public static Ed25519PrivateKey fromByteArray(byte[] bArr) {
        return new Ed25519PrivateKey(bArr);
    }

    public static Ed25519PrivateKey generate(SecureRandom secureRandom) {
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        return new Ed25519PrivateKey(bArr);
    }

    public Ed25519PublicKey derivePublic() {
        return m2139expand().derivePublic();
    }

    /* renamed from: expand */
    public Ed25519ExpandedPrivateKey m2139expand() throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(XMSSKeyParameters.f23622SHA_512);
            messageDigest.update(this.f1998secret);
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 32);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrDigest, 32, 64);
            bArrCopyOfRange[0] = (byte) (bArrCopyOfRange[0] & 248);
            byte b = (byte) (bArrCopyOfRange[31] & C5066Utf8.REPLACEMENT_BYTE);
            bArrCopyOfRange[31] = b;
            bArrCopyOfRange[31] = (byte) (b | 64);
            return new Ed25519ExpandedPrivateKey(C0186Scalar.fromBits(bArrCopyOfRange), bArrCopyOfRange2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] toByteArray() {
        byte[] bArr = this.f1998secret;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
