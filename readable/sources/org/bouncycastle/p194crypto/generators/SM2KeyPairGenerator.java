package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class SM2KeyPairGenerator extends ECKeyPairGenerator {
    public SM2KeyPairGenerator() {
        super("SM2KeyGen");
    }

    @Override // org.bouncycastle.p194crypto.generators.ECKeyPairGenerator
    public boolean isOutOfRangeD(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(ECConstants.f22091ONE) < 0 || bigInteger.compareTo(bigInteger2.subtract(BigIntegers.f24189ONE)) >= 0;
    }
}
