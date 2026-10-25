package cafe.cryptography.p026ed25519;

import cafe.cryptography.curve25519.C0186Scalar;
import cafe.cryptography.curve25519.CompressedEdwardsY;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Ed25519Signature {

    /* renamed from: R */
    final CompressedEdwardsY f2001R;

    /* renamed from: S */
    final C0186Scalar f2002S;

    public Ed25519Signature(CompressedEdwardsY compressedEdwardsY, C0186Scalar c0186Scalar) {
        this.f2001R = compressedEdwardsY;
        this.f2002S = c0186Scalar;
    }

    public static Ed25519Signature fromByteArray(byte[] bArr) {
        if (bArr.length == 64) {
            return new Ed25519Signature(new CompressedEdwardsY(Arrays.copyOfRange(bArr, 0, 32)), (bArr[63] & 240) == 0 ? C0186Scalar.fromBits(Arrays.copyOfRange(bArr, 32, 64)) : C0186Scalar.fromCanonicalBytes(Arrays.copyOfRange(bArr, 32, 64)));
        }
        throw new IllegalArgumentException("signature length is wrong");
    }

    /* renamed from: equals */
    public boolean m2143equals(Object obj) {
        if (!(obj instanceof Ed25519Signature)) {
            return false;
        }
        Ed25519Signature ed25519Signature = (Ed25519Signature) obj;
        return this.f2001R.m2104equals(ed25519Signature.f2001R) && this.f2002S.m2133equals(ed25519Signature.f2002S);
    }

    public int hashCode() {
        return this.f2002S.hashCode() ^ this.f2001R.hashCode();
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f2001R.toByteArray();
        byte[] byteArray2 = this.f2002S.toByteArray();
        byte[] bArr = new byte[byteArray.length + byteArray2.length];
        System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
        System.arraycopy(byteArray2, 0, bArr, byteArray.length, byteArray2.length);
        return bArr;
    }
}
