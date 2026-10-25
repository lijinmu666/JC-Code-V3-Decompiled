package com.p038google.p061crypto.p062tink.integration.p069android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KmsClient;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {
    private static final int MAX_WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 40;

    /* renamed from: PREFIX */
    public static final String f3101PREFIX = "android-keystore://";

    /* renamed from: TAG */
    private static final String f3102TAG = "AndroidKeystoreKmsClient";
    private static final Object keyCreationLock = new Object();

    @GuardedBy("this")
    private KeyStore keyStore;

    /* renamed from: keyUri */
    private final String f3103keyUri;

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient$Builder */
    public static final class C0414Builder {
        KeyStore keyStore;

        /* renamed from: keyUri */
        String f3104keyUri = null;

        public C0414Builder() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
            this.keyStore = null;
            if (!AndroidKeystoreKmsClient.isAtLeastM()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }

        /* renamed from: build */
        public AndroidKeystoreKmsClient m3479build() {
            return new AndroidKeystoreKmsClient(this);
        }

        public C0414Builder setKeyStore(KeyStore keyStore) {
            if (keyStore == null) {
                throw new IllegalArgumentException("val cannot be null");
            }
            this.keyStore = keyStore;
            return this;
        }

        public C0414Builder setKeyUri(String str) {
            if (str == null || !str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.f3101PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.f3104keyUri = str;
            return this;
        }
    }

    public static boolean generateKeyIfNotExist(String str) {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            try {
                if (androidKeystoreKmsClient.m3478hasKey(str)) {
                    return false;
                }
                generateNewAesGcmKeyWithoutExistenceCheck(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void generateNewAeadKey(String str) {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            try {
                if (androidKeystoreKmsClient.m3478hasKey(str)) {
                    throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
                }
                generateNewAesGcmKeyWithoutExistenceCheck(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void generateNewAesGcmKeyWithoutExistenceCheck(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        String strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(f3101PREFIX, str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strValidateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    public static InterfaceC0305Aead getOrGenerateNewAeadKey(String str) {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        synchronized (keyCreationLock) {
            try {
                if (!androidKeystoreKmsClient.m3478hasKey(str)) {
                    generateNewAesGcmKeyWithoutExistenceCheck(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return androidKeystoreKmsClient.mo3373getAead(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    private static void sleepRandomAmount() throws InterruptedException {
        try {
            Thread.sleep((int) (Math.random() * 40.0d));
        } catch (InterruptedException unused) {
        }
    }

    private static InterfaceC0305Aead validateAead(InterfaceC0305Aead interfaceC0305Aead) throws KeyStoreException {
        byte[] bArrRandBytes = C0870Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrRandBytes, interfaceC0305Aead.mo3322decrypt(interfaceC0305Aead.mo3323encrypt(bArrRandBytes, bArr), bArr))) {
            return interfaceC0305Aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    public synchronized void deleteKey(String str) {
        this.keyStore.deleteEntry(Validators.validateKmsKeyUriAndRemovePrefix(f3101PREFIX, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    @Override // com.p038google.p061crypto.p062tink.KmsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean doesSupport(String str) {
        boolean z;
        String str2 = this.f3103keyUri;
        if (str2 != null && str2.equals(str)) {
            return true;
        }
        if (this.f3103keyUri == null) {
            z = str.toLowerCase(Locale.US).startsWith(f3101PREFIX);
        }
        return z;
    }

    @Override // com.p038google.p061crypto.p062tink.KmsClient
    /* renamed from: getAead */
    public synchronized InterfaceC0305Aead mo3373getAead(String str) {
        try {
            String str2 = this.f3103keyUri;
            if (str2 != null && !str2.equals(str)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.f3103keyUri, str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(f3101PREFIX, str), this.keyStore));
    }

    /* renamed from: hasKey */
    public synchronized boolean m3478hasKey(String str) {
        String strValidateKmsKeyUriAndRemovePrefix;
        strValidateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(f3101PREFIX, str);
        try {
        } catch (NullPointerException unused) {
            Log.w(f3102TAG, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                sleepRandomAmount();
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.keyStore = keyStore;
                keyStore.load(null);
                return this.keyStore.containsAlias(strValidateKmsKeyUriAndRemovePrefix);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        }
        return this.keyStore.containsAlias(strValidateKmsKeyUriAndRemovePrefix);
    }

    @Override // com.p038google.p061crypto.p062tink.KmsClient
    public KmsClient withCredentials(String str) {
        return new AndroidKeystoreKmsClient();
    }

    @Override // com.p038google.p061crypto.p062tink.KmsClient
    public KmsClient withDefaultCredentials() {
        return new AndroidKeystoreKmsClient();
    }

    public AndroidKeystoreKmsClient() {
        this(new C0414Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String str) {
        this(new C0414Builder().setKeyUri(str));
    }

    private AndroidKeystoreKmsClient(C0414Builder c0414Builder) {
        this.f3103keyUri = c0414Builder.f3104keyUri;
        this.keyStore = c0414Builder.keyStore;
    }
}
