package org.bouncycastle.p194crypto.p200ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p361util.BigIntegers;

/* renamed from: org.bouncycastle.crypto.ec.ECUtil */
/* loaded from: classes2.dex */
class C5333ECUtil {
    public static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, secureRandom);
            if (!bigIntegerCreateRandomBigInteger.equals(ECConstants.f22094ZERO) && bigIntegerCreateRandomBigInteger.compareTo(bigInteger) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }
}
