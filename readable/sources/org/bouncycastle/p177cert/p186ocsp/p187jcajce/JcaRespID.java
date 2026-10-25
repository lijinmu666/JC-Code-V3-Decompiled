package org.bouncycastle.p177cert.p186ocsp.p187jcajce;

import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.p186ocsp.C5230RespID;

/* loaded from: classes2.dex */
public class JcaRespID extends C5230RespID {
    public JcaRespID(PublicKey publicKey, DigestCalculator digestCalculator) {
        super(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), digestCalculator);
    }

    public JcaRespID(X500Principal x500Principal) {
        super(X500Name.getInstance(x500Principal.getEncoded()));
    }
}
