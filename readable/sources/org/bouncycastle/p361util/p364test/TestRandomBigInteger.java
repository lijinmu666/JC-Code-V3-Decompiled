package org.bouncycastle.p361util.p364test;

import java.math.BigInteger;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.p364test.FixedSecureRandom;

/* loaded from: classes2.dex */
public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(int i, byte[] bArr) {
        super(new FixedSecureRandom.C6259Source[]{new FixedSecureRandom.BigInteger(i, bArr)});
    }

    public TestRandomBigInteger(String str) {
        this(str, 10);
    }

    public TestRandomBigInteger(String str, int i) {
        super(new FixedSecureRandom.C6259Source[]{new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(str, i)))});
    }

    public TestRandomBigInteger(byte[] bArr) {
        super(new FixedSecureRandom.C6259Source[]{new FixedSecureRandom.BigInteger(bArr)});
    }
}
