package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ScryptKeySpec implements KeySpec {
    private final int blockSize;
    private final int costParameter;

    /* renamed from: keySize */
    private final int f21944keySize;
    private final int parallelizationParameter;
    private final char[] password;

    /* renamed from: salt */
    private final byte[] f21945salt;

    public ScryptKeySpec(char[] cArr, byte[] bArr, int i, int i2, int i3, int i4) {
        this.password = cArr;
        this.f21945salt = C6238Arrays.m18231clone(bArr);
        this.costParameter = i;
        this.blockSize = i2;
        this.parallelizationParameter = i3;
        this.f21944keySize = i4;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCostParameter() {
        return this.costParameter;
    }

    public int getKeyLength() {
        return this.f21944keySize;
    }

    public int getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public char[] getPassword() {
        return this.password;
    }

    /* renamed from: getSalt */
    public byte[] m16216getSalt() {
        return C6238Arrays.m18231clone(this.f21945salt);
    }
}
