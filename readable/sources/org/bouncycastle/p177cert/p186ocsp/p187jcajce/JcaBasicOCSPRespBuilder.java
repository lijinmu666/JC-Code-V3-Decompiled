package org.bouncycastle.p177cert.p186ocsp.p187jcajce;

import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.p186ocsp.BasicOCSPRespBuilder;

/* loaded from: classes2.dex */
public class JcaBasicOCSPRespBuilder extends BasicOCSPRespBuilder {
    public JcaBasicOCSPRespBuilder(PublicKey publicKey, DigestCalculator digestCalculator) {
        super(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), digestCalculator);
    }

    public JcaBasicOCSPRespBuilder(X500Principal x500Principal) {
        super(new JcaRespID(x500Principal));
    }
}
