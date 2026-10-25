package org.bouncycastle.p307pkcs.p308bc;

import java.io.IOException;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequest;
import org.bouncycastle.p307pkcs.PKCSException;

/* loaded from: classes2.dex */
public class BcPKCS10CertificationRequest extends PKCS10CertificationRequest {
    public BcPKCS10CertificationRequest(CertificationRequest certificationRequest) {
        super(certificationRequest);
    }

    public AsymmetricKeyParameter getPublicKey() throws PKCSException {
        try {
            return PublicKeyFactory.createKey(getSubjectPublicKeyInfo());
        } catch (IOException e) {
            throw new PKCSException("error extracting key encoding: " + e.getMessage(), e);
        }
    }

    public BcPKCS10CertificationRequest(PKCS10CertificationRequest pKCS10CertificationRequest) {
        super(pKCS10CertificationRequest.toASN1Structure());
    }

    public BcPKCS10CertificationRequest(byte[] bArr) {
        super(bArr);
    }
}
