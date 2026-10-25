package org.bouncycastle.p307pkcs.p308bc;

import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequestBuilder;

/* loaded from: classes2.dex */
public class BcPKCS10CertificationRequestBuilder extends PKCS10CertificationRequestBuilder {
    public BcPKCS10CertificationRequestBuilder(X500Name x500Name, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(x500Name, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }
}
