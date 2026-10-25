package org.bouncycastle.p302openssl.p304jcajce;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CRLHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p302openssl.MiscPEMGenerator;
import org.bouncycastle.p302openssl.PEMEncryptor;

/* loaded from: classes2.dex */
public class JcaMiscPEMGenerator extends MiscPEMGenerator {
    private String algorithm;

    /* renamed from: obj */
    private Object f22830obj;
    private char[] password;
    private Provider provider;

    /* renamed from: random */
    private SecureRandom f22831random;

    public JcaMiscPEMGenerator(Object obj) {
        super(convertObject(obj));
    }

    private static Object convertObject(Object obj) {
        if (obj instanceof X509Certificate) {
            try {
                return new JcaX509CertificateHolder((X509Certificate) obj);
            } catch (CertificateEncodingException e) {
                throw new IllegalArgumentException("Cannot encode object: " + e.toString());
            }
        }
        if (!(obj instanceof X509CRL)) {
            return obj instanceof KeyPair ? convertObject(((KeyPair) obj).getPrivate()) : obj instanceof PrivateKey ? PrivateKeyInfo.getInstance(((Key) obj).getEncoded()) : obj instanceof PublicKey ? SubjectPublicKeyInfo.getInstance(((PublicKey) obj).getEncoded()) : obj;
        }
        try {
            return new JcaX509CRLHolder((X509CRL) obj);
        } catch (CRLException e2) {
            throw new IllegalArgumentException("Cannot encode object: " + e2.toString());
        }
    }

    public JcaMiscPEMGenerator(Object obj, PEMEncryptor pEMEncryptor) {
        super(convertObject(obj), pEMEncryptor);
    }
}
