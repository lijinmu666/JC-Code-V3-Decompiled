package org.bouncycastle.p194crypto.constraints;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class ConstraintUtils {
    public static int bitsOfSecurityFor(BigInteger bigInteger) {
        return bitsOfSecurityForFF(bigInteger.bitLength());
    }

    public static int bitsOfSecurityForFF(int i) {
        if (i < 2048) {
            return i >= 1024 ? 80 : 20;
        }
        if (i < 3072) {
            return 112;
        }
        if (i >= 7680) {
            return i >= 15360 ? 256 : 192;
        }
        return 128;
    }

    public static int bitsOfSecurityFor(AbstractC5817ECCurve abstractC5817ECCurve) {
        int fieldSize = (abstractC5817ECCurve.getFieldSize() + 1) / 2;
        if (fieldSize > 256) {
            return 256;
        }
        return fieldSize;
    }
}
