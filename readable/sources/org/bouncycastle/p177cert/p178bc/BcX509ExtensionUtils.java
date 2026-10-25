package org.bouncycastle.p177cert.p178bc;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AuthorityKeyIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectKeyIdentifier;
import org.bouncycastle.p177cert.X509ExtensionUtils;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;

/* loaded from: classes2.dex */
public class BcX509ExtensionUtils extends X509ExtensionUtils {

    public static class SHA1DigestCalculator implements DigestCalculator {

        /* renamed from: bOut */
        private ByteArrayOutputStream f18806bOut;

        private SHA1DigestCalculator() {
            this.f18806bOut = new ByteArrayOutputStream();
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1);
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public byte[] getDigest() {
            byte[] byteArray = this.f18806bOut.toByteArray();
            this.f18806bOut.reset();
            SHA1Digest sHA1Digest = new SHA1Digest();
            sHA1Digest.mo14970update(byteArray, 0, byteArray.length);
            byte[] bArr = new byte[sHA1Digest.getDigestSize()];
            sHA1Digest.mo14967doFinal(bArr, 0);
            return bArr;
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public OutputStream getOutputStream() {
            return this.f18806bOut;
        }
    }

    public BcX509ExtensionUtils() {
        super(new SHA1DigestCalculator());
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(AsymmetricKeyParameter asymmetricKeyParameter) {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }

    public SubjectKeyIdentifier createSubjectKeyIdentifier(AsymmetricKeyParameter asymmetricKeyParameter) {
        return super.createSubjectKeyIdentifier(SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }

    public BcX509ExtensionUtils(DigestCalculator digestCalculator) {
        super(digestCalculator);
    }
}
