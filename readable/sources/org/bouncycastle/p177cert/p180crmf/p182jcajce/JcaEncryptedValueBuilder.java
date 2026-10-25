package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.operator.KeyWrapper;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p177cert.p180crmf.EncryptedValueBuilder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;

/* loaded from: classes2.dex */
public class JcaEncryptedValueBuilder extends EncryptedValueBuilder {
    public JcaEncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor) {
        super(keyWrapper, outputEncryptor);
    }

    /* renamed from: build */
    public EncryptedValue m14801build(PrivateKey privateKey) {
        return m14783build(PrivateKeyInfo.getInstance(privateKey.getEncoded()));
    }

    /* renamed from: build */
    public EncryptedValue m14802build(X509Certificate x509Certificate) {
        return m14784build(new JcaX509CertificateHolder(x509Certificate));
    }
}
