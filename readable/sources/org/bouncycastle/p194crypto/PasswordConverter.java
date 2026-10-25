package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public enum PasswordConverter implements CharToByteConverter {
    ASCII { // from class: org.bouncycastle.crypto.PasswordConverter.1
        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: convert */
        public byte[] mo14954convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(cArr);
        }

        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: getType */
        public String mo14955getType() {
            return "ASCII";
        }
    },
    UTF8 { // from class: org.bouncycastle.crypto.PasswordConverter.2
        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: convert */
        public byte[] mo14954convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        }

        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: getType */
        public String mo14955getType() {
            return "UTF8";
        }
    },
    PKCS12 { // from class: org.bouncycastle.crypto.PasswordConverter.3
        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: convert */
        public byte[] mo14954convert(char[] cArr) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        }

        @Override // org.bouncycastle.p194crypto.CharToByteConverter
        /* renamed from: getType */
        public String mo14955getType() {
            return "PKCS12";
        }
    }
}
