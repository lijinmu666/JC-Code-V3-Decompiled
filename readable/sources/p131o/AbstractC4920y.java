package p131o;

/* renamed from: o.y */
/* loaded from: classes.dex */
public abstract class AbstractC4920y {
    /* renamed from: mjFkc */
    public static byte[] m13977mjFkc(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex string must not be null");
        }
        if ((str.length() & 1) != 0) {
            throw new IllegalArgumentException("hex string must have even length");
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            int iDigit = Character.digit(str.charAt(i), 16);
            int iDigit2 = Character.digit(str.charAt(i + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("invalid hexadecimal character");
            }
            bArr[i / 2] = (byte) ((iDigit << 4) | iDigit2);
        }
        return bArr;
    }
}
