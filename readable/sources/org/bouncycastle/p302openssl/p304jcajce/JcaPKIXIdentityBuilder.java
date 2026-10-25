package org.bouncycastle.p302openssl.p304jcajce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateConverter;
import org.bouncycastle.p302openssl.PEMKeyPair;
import org.bouncycastle.p302openssl.PEMParser;
import org.bouncycastle.p310pkix.p311jcajce.JcaPKIXIdentity;

/* loaded from: classes2.dex */
public class JcaPKIXIdentityBuilder {
    private JcaPEMKeyConverter keyConverter = new JcaPEMKeyConverter();
    private JcaX509CertificateConverter certConverter = new JcaX509CertificateConverter();

    private void checkFile(File file) throws IOException {
        if (file.canRead()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("Unable to open file " + file.getPath() + " for reading.");
        }
        throw new FileNotFoundException("Unable to open " + file.getPath() + ": it does not exist.");
    }

    /* renamed from: build */
    public JcaPKIXIdentity m17368build(File file, File file2) throws IOException {
        checkFile(file);
        checkFile(file2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        JcaPKIXIdentity jcaPKIXIdentityM17369build = m17369build(fileInputStream, fileInputStream2);
        fileInputStream.close();
        fileInputStream2.close();
        return jcaPKIXIdentityM17369build;
    }

    public JcaPKIXIdentityBuilder setProvider(String str) {
        this.keyConverter = this.keyConverter.setProvider(str);
        this.certConverter = this.certConverter.setProvider(str);
        return this;
    }

    /* renamed from: build */
    public JcaPKIXIdentity m17369build(InputStream inputStream, InputStream inputStream2) throws IOException {
        JcaPEMKeyConverter jcaPEMKeyConverter;
        PrivateKeyInfo privateKeyInfo;
        Object object = new PEMParser(new InputStreamReader(inputStream)).readObject();
        if (object instanceof PEMKeyPair) {
            jcaPEMKeyConverter = this.keyConverter;
            privateKeyInfo = ((PEMKeyPair) object).getPrivateKeyInfo();
        } else {
            if (!(object instanceof PrivateKeyInfo)) {
                throw new IOException("unrecognised private key file");
            }
            jcaPEMKeyConverter = this.keyConverter;
            privateKeyInfo = (PrivateKeyInfo) object;
        }
        PrivateKey privateKey = jcaPEMKeyConverter.getPrivateKey(privateKeyInfo);
        PEMParser pEMParser = new PEMParser(new InputStreamReader(inputStream2));
        ArrayList arrayList = new ArrayList();
        while (true) {
            Object object2 = pEMParser.readObject();
            if (object2 == null) {
                return new JcaPKIXIdentity(privateKey, (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]));
            }
            arrayList.add(this.certConverter.getCertificate((X509CertificateHolder) object2));
        }
    }

    public JcaPKIXIdentityBuilder setProvider(Provider provider) {
        this.keyConverter = this.keyConverter.setProvider(provider);
        this.certConverter = this.certConverter.setProvider(provider);
        return this;
    }
}
