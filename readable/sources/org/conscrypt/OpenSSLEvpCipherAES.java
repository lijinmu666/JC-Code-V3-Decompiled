package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes2.dex */
public abstract class OpenSSLEvpCipherAES extends OpenSSLEvpCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$1 */
    public static /* synthetic */ class C63131 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Mode;
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
            int[] iArr2 = new int[OpenSSLCipher.EnumC6304Mode.m18474values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Mode = iArr2;
            try {
                iArr2[OpenSSLCipher.EnumC6304Mode.CBC.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.EnumC6304Mode.CTR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.EnumC6304Mode.ECB.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES */
    public static class C6314AES extends OpenSSLEvpCipherAES {

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$CBC */
        public static class CBC extends C6314AES {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$CBC$NoPadding */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$CBC$PKCS5Padding */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public CBC(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.CBC, enumC6305Padding);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$CTR */
        public static class CTR extends C6314AES {
            public CTR() {
                super(OpenSSLCipher.EnumC6304Mode.CTR, OpenSSLCipher.EnumC6305Padding.NOPADDING);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$ECB */
        public static class ECB extends C6314AES {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$ECB$NoPadding */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES$ECB$PKCS5Padding */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public ECB(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.ECB, enumC6305Padding);
            }
        }

        public C6314AES(OpenSSLCipher.EnumC6304Mode enumC6304Mode, OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
            super(enumC6304Mode, enumC6305Padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 16 || i == 24 || i == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128 */
    public static class C6315AES_128 extends OpenSSLEvpCipherAES {

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$CBC */
        public static class CBC extends C6315AES_128 {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$CBC$NoPadding */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$CBC$PKCS5Padding */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public CBC(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.CBC, enumC6305Padding);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$CTR */
        public static class CTR extends C6315AES_128 {
            public CTR() {
                super(OpenSSLCipher.EnumC6304Mode.CTR, OpenSSLCipher.EnumC6305Padding.NOPADDING);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$ECB */
        public static class ECB extends C6315AES_128 {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$ECB$NoPadding */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_128$ECB$PKCS5Padding */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public ECB(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.ECB, enumC6305Padding);
            }
        }

        public C6315AES_128(OpenSSLCipher.EnumC6304Mode enumC6304Mode, OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
            super(enumC6304Mode, enumC6305Padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 16) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256 */
    public static class C6316AES_256 extends OpenSSLEvpCipherAES {

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$CBC */
        public static class CBC extends C6316AES_256 {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$CBC$NoPadding */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$CBC$PKCS5Padding */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public CBC(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.CBC, enumC6305Padding);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$CTR */
        public static class CTR extends C6316AES_256 {
            public CTR() {
                super(OpenSSLCipher.EnumC6304Mode.CTR, OpenSSLCipher.EnumC6305Padding.NOPADDING);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$ECB */
        public static class ECB extends C6316AES_256 {

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$ECB$NoPadding */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.EnumC6305Padding.NOPADDING);
                }
            }

            /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$AES_256$ECB$PKCS5Padding */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.EnumC6305Padding.PKCS5PADDING);
                }
            }

            public ECB(OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
                super(OpenSSLCipher.EnumC6304Mode.ECB, enumC6305Padding);
            }
        }

        public C6316AES_256(OpenSSLCipher.EnumC6304Mode enumC6304Mode, OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
            super(enumC6304Mode, enumC6305Padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    public OpenSSLEvpCipherAES(OpenSSLCipher.EnumC6304Mode enumC6304Mode, OpenSSLCipher.EnumC6305Padding enumC6305Padding) {
        super(enumC6304Mode, enumC6305Padding);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.EnumC6304Mode enumC6304Mode) throws NoSuchAlgorithmException {
        int i = C63131.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[enumC6304Mode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + enumC6304Mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.EnumC6305Padding enumC6305Padding) throws NoSuchPaddingException {
        int i = C63131.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[enumC6305Padding.ordinal()];
        if (i == 1 || i == 2) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + enumC6305Padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i, OpenSSLCipher.EnumC6304Mode enumC6304Mode) {
        return "aes-" + (i * 8) + "-" + enumC6304Mode.toString().toLowerCase(Locale.US);
    }
}
