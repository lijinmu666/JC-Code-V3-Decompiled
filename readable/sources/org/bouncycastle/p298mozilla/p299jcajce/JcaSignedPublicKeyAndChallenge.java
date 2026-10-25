package org.bouncycastle.p298mozilla.p299jcajce;

import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p298mozilla.SignedPublicKeyAndChallenge;

/* loaded from: classes2.dex */
public class JcaSignedPublicKeyAndChallenge extends SignedPublicKeyAndChallenge {

    /* renamed from: helper */
    JcaJceHelper f22535helper;

    private JcaSignedPublicKeyAndChallenge(org.bouncycastle.p133asn1.p160mozilla.SignedPublicKeyAndChallenge signedPublicKeyAndChallenge, JcaJceHelper jcaJceHelper) {
        super(signedPublicKeyAndChallenge);
        new DefaultJcaJceHelper();
        this.f22535helper = jcaJceHelper;
    }

    public PublicKey getPublicKey() throws InvalidKeyException {
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfo = this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
            return this.f22535helper.createKeyFactory(subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14433getId()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public JcaSignedPublicKeyAndChallenge setProvider(String str) {
        return new JcaSignedPublicKeyAndChallenge(this.spkacSeq, new NamedJcaJceHelper(str));
    }

    public JcaSignedPublicKeyAndChallenge(byte[] bArr) {
        super(bArr);
        this.f22535helper = new DefaultJcaJceHelper();
    }

    public JcaSignedPublicKeyAndChallenge setProvider(Provider provider) {
        return new JcaSignedPublicKeyAndChallenge(this.spkacSeq, new ProviderJcaJceHelper(provider));
    }
}
