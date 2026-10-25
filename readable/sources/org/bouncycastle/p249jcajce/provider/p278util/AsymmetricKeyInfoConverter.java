package org.bouncycastle.p249jcajce.provider.p278util;

import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public interface AsymmetricKeyInfoConverter {
    PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo);

    PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo);
}
