package org.bouncycastle.p302openssl.p304jcajce;

import java.security.PrivateKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p302openssl.PKCS8Generator;

/* loaded from: classes2.dex */
public class JcaPKCS8Generator extends PKCS8Generator {
    public JcaPKCS8Generator(PrivateKey privateKey, OutputEncryptor outputEncryptor) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()), outputEncryptor);
    }
}
