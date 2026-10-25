package org.bouncycastle.p249jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.p194crypto.CharToByteConverter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    private final int iterationCount;

    /* renamed from: salt */
    private final byte[] f21359salt;

    public PBKDF2KeyWithParameters(char[] cArr, CharToByteConverter charToByteConverter, byte[] bArr, int i) {
        super(cArr, charToByteConverter);
        this.f21359salt = C6238Arrays.m18231clone(bArr);
        this.iterationCount = i;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.f21359salt;
    }
}
