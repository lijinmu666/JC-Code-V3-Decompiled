package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dh.DHUtil */
/* loaded from: classes2.dex */
class C5506DHUtil {
    private static String generateKeyFingerprint(BigInteger bigInteger, DHParameters dHParameters) {
        return new Fingerprint(C6238Arrays.concatenate(bigInteger.toByteArray(), dHParameters.m15695getP().toByteArray(), dHParameters.m15691getG().toByteArray())).toString();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        BigInteger bigIntegerModPow = dHParameters.m15691getG().modPow(bigInteger, dHParameters.m15695getP());
        sb.append(str);
        sb.append(" Private Key [");
        sb.append(generateKeyFingerprint(bigIntegerModPow, dHParameters));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("              Y: ");
        sb.append(bigIntegerModPow.toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public static String publicKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append(str);
        sb.append(" Public Key [");
        sb.append(generateKeyFingerprint(bigInteger, dHParameters));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("             Y: ");
        sb.append(bigInteger.toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }
}
