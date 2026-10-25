package org.bouncycastle.p177cert.p180crmf.p181bc;

import java.security.cert.X509Certificate;
import org.bouncycastle.operator.KeyWrapper;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;
import org.bouncycastle.p177cert.p180crmf.EncryptedValueBuilder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.PrivateKeyInfoFactory;

/* loaded from: classes2.dex */
public class BcEncryptedValueBuilder extends EncryptedValueBuilder {
    public BcEncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor) {
        super(keyWrapper, outputEncryptor);
    }

    /* renamed from: build */
    public EncryptedValue m14796build(X509Certificate x509Certificate) {
        return m14784build(new JcaX509CertificateHolder(x509Certificate));
    }

    /* renamed from: build */
    public EncryptedValue m14797build(AsymmetricKeyParameter asymmetricKeyParameter) {
        return m14783build(PrivateKeyInfoFactory.createPrivateKeyInfo(asymmetricKeyParameter));
    }
}
