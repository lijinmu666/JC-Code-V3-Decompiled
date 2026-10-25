package cafe.cryptography.p026ed25519;

import cafe.cryptography.curve25519.C0186Scalar;
import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes.dex */
public class Ed25519ExpandedPrivateKey {

    /* renamed from: prefix */
    private final byte[] f1996prefix;

    /* renamed from: s */
    private final C0186Scalar f1997s;

    public Ed25519ExpandedPrivateKey(C0186Scalar c0186Scalar, byte[] bArr) {
        this.f1997s = c0186Scalar;
        this.f1996prefix = bArr;
    }

    public Ed25519PublicKey derivePublic() {
        return new Ed25519PublicKey(Constants.ED25519_BASEPOINT_TABLE.multiply(this.f1997s));
    }

    /* renamed from: sign */
    public Ed25519Signature m2138sign(byte[] bArr, Ed25519PublicKey ed25519PublicKey) {
        return m2137sign(bArr, 0, bArr.length, ed25519PublicKey);
    }

    /* renamed from: sign */
    public Ed25519Signature m2137sign(byte[] bArr, int i, int i2, Ed25519PublicKey ed25519PublicKey) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(XMSSKeyParameters.f23622SHA_512);
            messageDigest.update(this.f1996prefix);
            messageDigest.update(bArr, i, i2);
            C0186Scalar c0186ScalarFromBytesModOrderWide = C0186Scalar.fromBytesModOrderWide(messageDigest.digest());
            CompressedEdwardsY compressedEdwardsYCompress = Constants.ED25519_BASEPOINT_TABLE.multiply(c0186ScalarFromBytesModOrderWide).compress();
            messageDigest.reset();
            messageDigest.update(compressedEdwardsYCompress.toByteArray());
            messageDigest.update(ed25519PublicKey.toByteArray());
            messageDigest.update(bArr, i, i2);
            return new Ed25519Signature(compressedEdwardsYCompress, c0186ScalarFromBytesModOrderWide.m2132add(C0186Scalar.fromBytesModOrderWide(messageDigest.digest()).multiply(this.f1997s)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
