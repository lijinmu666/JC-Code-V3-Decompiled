package org.bouncycastle.p249jcajce;

import org.bouncycastle.p194crypto.CharToByteConverter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PBKDF2Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF2Key(char[] cArr, CharToByteConverter charToByteConverter) {
        this.password = C6238Arrays.m18233clone(cArr);
        this.converter = charToByteConverter;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
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
