package org.conscrypt.p368ct;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.conscrypt.p368ct.VerifiedSCT;

/* loaded from: classes2.dex */
public class CTLogInfo {
    private final String description;

    /* renamed from: logId */
    private final byte[] f24467logId;
    private final PublicKey publicKey;

    /* renamed from: url */
    private final String f24468url;

    public CTLogInfo(PublicKey publicKey, String str, String str2) {
        try {
            this.f24467logId = MessageDigest.getInstance(XMSSKeyParameters.f23621SHA_256).digest(publicKey.getEncoded());
            this.publicKey = publicKey;
            this.description = str;
            this.f24468url = str2;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: equals */
    public boolean m18512equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CTLogInfo)) {
            return false;
        }
        CTLogInfo cTLogInfo = (CTLogInfo) obj;
        return this.publicKey.equals(cTLogInfo.publicKey) && this.description.equals(cTLogInfo.description) && this.f24468url.equals(cTLogInfo.f24468url);
    }

    public String getDescription() {
        return this.description;
    }

    /* renamed from: getID */
    public byte[] m18513getID() {
        return this.f24467logId;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    /* renamed from: getUrl */
    public String m18514getUrl() {
        return this.f24468url;
    }

    public int hashCode() {
        return ((((this.publicKey.hashCode() + 31) * 31) + this.description.hashCode()) * 31) + this.f24468url.hashCode();
    }

    public VerifiedSCT.EnumC6342Status verifySingleSCT(SignedCertificateTimestamp signedCertificateTimestamp, CertificateEntry certificateEntry) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException {
        if (!Arrays.equals(signedCertificateTimestamp.getLogID(), m18513getID())) {
            return VerifiedSCT.EnumC6342Status.UNKNOWN_LOG;
        }
        try {
            byte[] bArrEncodeTBS = signedCertificateTimestamp.encodeTBS(certificateEntry);
            try {
                Signature signature = Signature.getInstance(signedCertificateTimestamp.getSignature().getAlgorithm());
                try {
                    signature.initVerify(this.publicKey);
                    try {
                        signature.update(bArrEncodeTBS);
                        return !signature.verify(signedCertificateTimestamp.getSignature().getSignature()) ? VerifiedSCT.EnumC6342Status.INVALID_SIGNATURE : VerifiedSCT.EnumC6342Status.VALID;
                    } catch (SignatureException e) {
                        throw new RuntimeException(e);
                    }
                } catch (InvalidKeyException unused) {
                    return VerifiedSCT.EnumC6342Status.INVALID_SCT;
                }
            } catch (NoSuchAlgorithmException unused2) {
                return VerifiedSCT.EnumC6342Status.INVALID_SCT;
            }
        } catch (SerializationException unused3) {
            return VerifiedSCT.EnumC6342Status.INVALID_SCT;
        }
    }
}
