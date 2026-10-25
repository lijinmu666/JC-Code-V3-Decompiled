package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes2.dex */
public abstract class OpenSSLEvpCipherDESEDE extends OpenSSLEvpCipher {
    private static final int DES_BLOCK_SIZE = 8;

    /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$1 */
    public static /* synthetic */ class C63171 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        static {
            int[] iArr = new int[OpenSSLCipher.EnumC6305Padding.m18476values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Padding = iArr;
            try {
                iArr[OpenSSLCipher.EnumC6305Padding.NOPADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[OpenSSLCipher.EnumC6305Padding.PKCS5PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$CBC */
    public static class C6318CBC extends OpenSSLEvpCipherDESEDE {

        /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$CBC$NoPadding */
        public static class NoPadding extends C6318CBC {
            public NoPadding() {
                super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$CBC$PKCS5Padding */
        public static class PKCS5Padding extends C6318CBC {
            public PKCS5Padding() {
                super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
            }
        }

        public C6318CBC(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
            super(OpenSSLCipher.EnumC6304Mode.CBC, enumC6305Padding);
        }
    }

    public OpenSSLEvpCipherDESEDE(OpenSSLCipher.EnumC6304Mode enumC6304Mode, OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
        super(enumC6304Mode, enumC6305Padding);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 16 && i != 24) {
            throw new InvalidKeyException("key size must be 128 or 192 bits");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.EnumC6304Mode enumC6304Mode) throws NoSuchAlgorithmException {
        if (enumC6304Mode == OpenSSLCipher.EnumC6304Mode.CBC) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + enumC6304Mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.EnumC6305Padding enumC6305Padding) throws NoSuchPaddingException {
        int i = C63171.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[enumC6305Padding.ordinal()];
        if (i == 1 || i == 2) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + enumC6305Padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "DESede";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 8;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i, OpenSSLCipher.EnumC6304Mode enumC6304Mode) {
        return (i == 16 ? "des-ede" : "des-ede3") + "-" + enumC6304Mode.toString().toLowerCase(Locale.US);
    }
}
