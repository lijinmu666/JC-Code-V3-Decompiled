package org.bouncycastle.p307pkcs.p309jcajce;

import java.security.PrivateKey;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p307pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;

/* loaded from: classes2.dex */
public class JcaPKCS8EncryptedPrivateKeyInfoBuilder extends PKCS8EncryptedPrivateKeyInfoBuilder {
    public JcaPKCS8EncryptedPrivateKeyInfoBuilder(PrivateKey privateKey) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()));
    }
}
