package org.bouncycastle.p194crypto;

import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;

    /* renamed from: salt */
    protected byte[] f19139salt;

    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i = 0; i != cArr.length; i++) {
            int i2 = i * 2;
            char c = cArr[i];
            bArr[i2] = (byte) (c >>> '\b');
            bArr[i2 + 1] = (byte) c;
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] cArr) {
        return cArr != null ? C6250Strings.toUTF8ByteArray(cArr) : new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int i);

    public abstract CipherParameters generateDerivedParameters(int i);

    public abstract CipherParameters generateDerivedParameters(int i, int i2);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    /* renamed from: getSalt */
    public byte[] m14981getSalt() {
        return this.f19139salt;
    }

    /* renamed from: init */
    public void m14982init(byte[] bArr, byte[] bArr2, int i) {
        this.password = bArr;
        this.f19139salt = bArr2;
        this.iterationCount = i;
    }
}
