package cafe.cryptography.p026ed25519;

import cafe.cryptography.curve25519.C0186Scalar;
import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.EdwardsPoint;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes.dex */
public class Ed25519PublicKey {

    /* renamed from: A */
    private final EdwardsPoint f1999A;

    /* renamed from: Aenc */
    private final CompressedEdwardsY f2000Aenc;

    public Ed25519PublicKey(EdwardsPoint edwardsPoint) {
        this.f1999A = edwardsPoint;
        this.f2000Aenc = edwardsPoint.compress();
    }

    public static Ed25519PublicKey fromByteArray(byte[] bArr) {
        return new Ed25519PublicKey(new CompressedEdwardsY(bArr));
    }

    /* renamed from: equals */
    public boolean m2140equals(Object obj) {
        if (obj instanceof Ed25519PublicKey) {
            return this.f2000Aenc.m2104equals(((Ed25519PublicKey) obj).f2000Aenc);
        }
        return false;
    }

    public int hashCode() {
        return this.f2000Aenc.hashCode();
    }

    public byte[] toByteArray() {
        return this.f2000Aenc.toByteArray();
    }

    /* renamed from: verify */
    public boolean m2142verify(byte[] bArr, Ed25519Signature ed25519Signature) {
        return m2141verify(bArr, 0, bArr.length, ed25519Signature);
    }

    /* renamed from: verify */
    public boolean m2141verify(byte[] bArr, int i, int i2, Ed25519Signature ed25519Signature) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(XMSSKeyParameters.f23622SHA_512);
            messageDigest.update(ed25519Signature.f2001R.toByteArray());
            messageDigest.update(this.f2000Aenc.toByteArray());
            messageDigest.update(bArr, i, i2);
            return EdwardsPoint.vartimeDoubleScalarMultiplyBasepoint(C0186Scalar.fromBytesModOrderWide(messageDigest.digest()), this.f1999A.m2111negate(), ed25519Signature.f2002S).compress().m2104equals(ed25519Signature.f2001R);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private Ed25519PublicKey(CompressedEdwardsY compressedEdwardsY) {
        this.f2000Aenc = compressedEdwardsY;
        this.f1999A = compressedEdwardsY.decompress();
    }
}
