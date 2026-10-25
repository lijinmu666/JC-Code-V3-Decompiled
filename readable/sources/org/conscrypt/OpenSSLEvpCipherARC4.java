package org.conscrypt;

import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes2.dex */
public class OpenSSLEvpCipherARC4 extends OpenSSLEvpCipher {
    public OpenSSLEvpCipherARC4() {
        super(OpenSSLCipher.EnumC6304Mode.ECB, OpenSSLCipher.EnumC6305Padding.NOPADDING);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) {
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.EnumC6304Mode enumC6304Mode) throws NoSuchAlgorithmException {
        if (enumC6304Mode == OpenSSLCipher.EnumC6304Mode.NONE || enumC6304Mode == OpenSSLCipher.EnumC6304Mode.ECB) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + enumC6304Mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.EnumC6305Padding enumC6305Padding) throws NoSuchPaddingException {
        if (enumC6305Padding == OpenSSLCipher.EnumC6305Padding.NOPADDING) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + enumC6305Padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ARCFOUR";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i, OpenSSLCipher.EnumC6304Mode enumC6304Mode) {
        return "rc4";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public boolean supportsVariableSizeKey() {
        return true;
    }
}
