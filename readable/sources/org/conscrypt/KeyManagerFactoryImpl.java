package org.conscrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import org.conscrypt.p369io.C6343IoUtils;

/* loaded from: classes2.dex */
public class KeyManagerFactoryImpl extends KeyManagerFactorySpi {
    private KeyStore keyStore;

    /* renamed from: pwd */
    private char[] f24375pwd;

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public KeyManager[] engineGetKeyManagers() {
        if (this.keyStore != null) {
            return new KeyManager[]{new KeyManagerImpl(this.keyStore, this.f24375pwd)};
        }
        throw new IllegalStateException("KeyManagerFactory is not initialized");
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public void engineInit(KeyStore keyStore, char[] cArr) throws Throwable {
        FileInputStream fileInputStream;
        if (keyStore != null) {
            this.keyStore = keyStore;
            if (cArr != null) {
                this.f24375pwd = (char[]) cArr.clone();
                return;
            } else {
                this.f24375pwd = EmptyArray.f24349CHAR;
                return;
            }
        }
        this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        String property = System.getProperty("javax.net.ssl.keyStore");
        FileInputStream fileInputStream2 = null;
        if (property == null || property.equalsIgnoreCase("NONE") || property.isEmpty()) {
            try {
                this.keyStore.load(null, null);
                return;
            } catch (IOException e) {
                throw new KeyStoreException(e);
            } catch (CertificateException e2) {
                throw new KeyStoreException(e2);
            }
        }
        String property2 = System.getProperty("javax.net.ssl.keyStorePassword");
        if (property2 == null) {
            this.f24375pwd = EmptyArray.f24349CHAR;
        } else {
            this.f24375pwd = property2.toCharArray();
        }
        try {
            try {
                fileInputStream = new FileInputStream(new File(property));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        } catch (CertificateException e5) {
            e = e5;
        }
        try {
            this.keyStore.load(fileInputStream, this.f24375pwd);
            C6343IoUtils.closeQuietly(fileInputStream);
        } catch (FileNotFoundException e6) {
            e = e6;
            throw new KeyStoreException(e);
        } catch (IOException e7) {
            e = e7;
            throw new KeyStoreException(e);
        } catch (CertificateException e8) {
            e = e8;
            throw new KeyStoreException(e);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            C6343IoUtils.closeQuietly(fileInputStream2);
            throw th;
        }
    }

    @Override // javax.net.ssl.KeyManagerFactorySpi
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("ManagerFactoryParameters not supported");
    }
}
