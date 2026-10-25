package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes2.dex */
final class CryptoUpcalls {

    /* renamed from: logger */
    private static final Logger f24345logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    public static byte[] ecSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        if ("EC".equals(privateKey.getAlgorithm())) {
            return signDigestWithPrivateKey(privateKey, bArr, "NONEwithECDSA");
        }
        throw new RuntimeException("Unexpected key type: " + privateKey.toString());
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        for (Provider provider : Security.getProviders(str)) {
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
        }
        if (arrayList.isEmpty()) {
            f24345logger.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    public static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 2, bArr);
    }

    private static byte[] rsaOpWithPrivateKey(PrivateKey privateKey, int i, int i2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String str;
        Cipher cipher;
        String algorithm = privateKey.getAlgorithm();
        if (!"RSA".equals(algorithm)) {
            f24345logger.warning("Unexpected key type: " + algorithm);
            return null;
        }
        if (i == 1) {
            str = "PKCS1Padding";
        } else if (i == 3) {
            str = "NoPadding";
        } else {
            if (i != 4) {
                f24345logger.warning("Unsupported OpenSSL/BoringSSL padding: " + i);
                return null;
            }
            str = "OAEPPadding";
        }
        String str2 = "RSA/ECB/" + str;
        try {
            cipher = Cipher.getInstance(str2);
            cipher.init(i2, privateKey);
        } catch (InvalidKeyException e) {
            f24345logger.log(Level.WARNING, "Preferred provider doesn't support key:", (Throwable) e);
        } catch (NoSuchAlgorithmException unused) {
            f24345logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        } catch (NoSuchPaddingException unused2) {
            f24345logger.warning("Unsupported cipher algorithm: " + str2);
            return null;
        }
        if (Conscrypt.isConscrypt(cipher.getProvider())) {
            cipher = null;
        }
        if (cipher == null) {
            Iterator<Provider> it = getExternalProviders("Cipher." + str2).iterator();
            while (it.hasNext()) {
                try {
                    cipher = Cipher.getInstance(str2, it.next());
                    cipher.init(i2, privateKey);
                    break;
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused3) {
                    cipher = null;
                }
            }
            if (cipher == null) {
                f24345logger.warning("Could not find provider for algorithm: " + str2);
                return null;
            }
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            f24345logger.log(Level.WARNING, "Exception while decrypting message with " + privateKey.getAlgorithm() + " private key using " + str2 + ":", (Throwable) e2);
            return null;
        }
    }

    public static byte[] rsaSignDigestWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 1, bArr);
    }

    private static byte[] signDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature;
        try {
            signature = Signature.getInstance(str);
            signature.initSign(privateKey);
        } catch (InvalidKeyException e) {
            f24345logger.warning("Preferred provider doesn't support key:");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
            f24345logger.warning("Unsupported signature algorithm: " + str);
            return null;
        }
        if (Conscrypt.isConscrypt(signature.getProvider())) {
            signature = null;
        }
        if (signature == null) {
            Iterator<Provider> it = getExternalProviders("Signature." + str).iterator();
            RuntimeException runtimeException = null;
            while (it.hasNext()) {
                try {
                    signature = Signature.getInstance(str, it.next());
                    signature.initSign(privateKey);
                    break;
                } catch (RuntimeException e2) {
                    if (runtimeException == null) {
                        runtimeException = e2;
                    }
                    signature = null;
                } catch (InvalidKeyException | NoSuchAlgorithmException unused2) {
                    signature = null;
                }
            }
            if (signature == null) {
                if (runtimeException != null) {
                    throw runtimeException;
                }
                f24345logger.warning("Could not find provider for algorithm: " + str);
                return null;
            }
        }
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (Exception e3) {
            f24345logger.log(Level.WARNING, "Exception while signing message with " + privateKey.getAlgorithm() + " private key:", (Throwable) e3);
            return null;
        }
    }
}
