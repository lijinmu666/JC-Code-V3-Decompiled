package org.bouncycastle.p249jcajce;

import org.bouncycastle.p194crypto.CharToByteConverter;

/* loaded from: classes2.dex */
public class PBKDF1Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF1Key(char[] cArr, CharToByteConverter charToByteConverter) {
        char[] cArr2 = new char[cArr.length];
        this.password = cArr2;
        this.converter = charToByteConverter;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF1";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.converter.mo14954convert(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.converter.mo14955getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
