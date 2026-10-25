package org.bouncycastle.p249jcajce.provider.asymmetric.p258gost;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;

/* loaded from: classes2.dex */
class GOSTUtil {
    private static String generateKeyFingerprint(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        return new Fingerprint(C6238Arrays.concatenate(bigInteger.toByteArray(), gOST3410Parameters.m15751getP().toByteArray(), gOST3410Parameters.m15750getA().toByteArray())).toString();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        BigInteger bigIntegerModPow = gOST3410Parameters.m15750getA().modPow(bigInteger, gOST3410Parameters.m15751getP());
        sb.append(str);
        sb.append(" Private Key [");
        sb.append(generateKeyFingerprint(bigIntegerModPow, gOST3410Parameters));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("                  Y: ");
        sb.append(bigIntegerModPow.toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public static String publicKeyToString(String str, BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append(str);
        sb.append(" Public Key [");
        sb.append(generateKeyFingerprint(bigInteger, gOST3410Parameters));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("                 Y: ");
        sb.append(bigInteger.toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }
}
