package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.Utils */
/* loaded from: classes2.dex */
class C5571Utils {
    private static String generateKeyFingerprint(byte[] bArr) {
        return new Fingerprint(bArr).toString();
    }

    public static boolean isValidPrefix(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return !isValidPrefix(bArr, bArr);
        }
        int i = 0;
        for (int i2 = 0; i2 != bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    public static String keyToString(String str, String str2, AsymmetricKeyParameter asymmetricKeyParameter) {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] encoded = asymmetricKeyParameter instanceof X448PublicKeyParameters ? ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded() : asymmetricKeyParameter instanceof Ed448PublicKeyParameters ? ((Ed448PublicKeyParameters) asymmetricKeyParameter).getEncoded() : asymmetricKeyParameter instanceof X25519PublicKeyParameters ? ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded() : ((Ed25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        sb.append(str2);
        sb.append(" ");
        sb.append(str);
        sb.append(" [");
        sb.append(generateKeyFingerprint(encoded));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("    public data: ");
        sb.append(C6255Hex.toHexString(encoded));
        sb.append(strLineSeparator);
        return sb.toString();
    }
}
