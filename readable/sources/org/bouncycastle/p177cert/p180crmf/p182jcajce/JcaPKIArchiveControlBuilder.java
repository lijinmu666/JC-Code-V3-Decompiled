package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.security.PrivateKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p177cert.p180crmf.PKIArchiveControlBuilder;

/* loaded from: classes2.dex */
public class JcaPKIArchiveControlBuilder extends PKIArchiveControlBuilder {
    public JcaPKIArchiveControlBuilder(PrivateKey privateKey, X500Principal x500Principal) {
        this(privateKey, X500Name.getInstance(x500Principal.getEncoded()));
    }

    public JcaPKIArchiveControlBuilder(PrivateKey privateKey, X500Name x500Name) {
        this(privateKey, new GeneralName(x500Name));
    }

    public JcaPKIArchiveControlBuilder(PrivateKey privateKey, GeneralName generalName) {
        super(PrivateKeyInfo.getInstance(privateKey.getEncoded()), generalName);
    }
}
