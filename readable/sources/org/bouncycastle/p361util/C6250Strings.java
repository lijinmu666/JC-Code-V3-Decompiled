package org.bouncycastle.p361util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p361util.encoders.C6256UTF8;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.util.Strings */
/* loaded from: classes2.dex */
public final class C6250Strings {
    private static String LINE_SEPARATOR;

    /* renamed from: org.bouncycastle.util.Strings$StringListImpl */
    public static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List, org.bouncycastle.p361util.StringList
        public /* bridge */ /* synthetic */ String get(int i) {
            return (String) super.get(i);
        }

        @Override // org.bouncycastle.p361util.StringList
        public String[] toStringArray() {
            int size = size();
            String[] strArr = new String[size];
            for (int i = 0; i != size; i++) {
                strArr[i] = get(i);
            }
            return strArr;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public void add(int i, String str) {
            super.add(i, (int) str);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public String set(int i, String str) {
            return (String) super.set(i, (int) str);
        }

        @Override // org.bouncycastle.p361util.StringList
        public String[] toStringArray(int i, int i2) {
            String[] strArr = new String[i2 - i];
            for (int i3 = i; i3 != size() && i3 != i2; i3++) {
                strArr[i3 - i] = get(i3);
            }
            return strArr;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(String str) {
            return super.add((StringListImpl) str);
        }
    }

    static {
        try {
            try {
                LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.bouncycastle.util.Strings.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty("line.separator");
                    }
                });
            } catch (Exception unused) {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            LINE_SEPARATOR = "\n";
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & C1126UByte.MAX_VALUE);
        }
        return cArr;
    }

    public static boolean constantTimeAreEqual(String str, String str2) {
        boolean z = str.length() == str2.length();
        int length = str.length();
        if (z) {
            for (int i = 0; i != length; i++) {
                z &= str.charAt(i) == str2.charAt(i);
            }
        } else {
            for (int i2 = 0; i2 != length; i2++) {
                z &= str.charAt(i2) == ' ';
            }
        }
        return z;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        return fromUTF8ByteArray(bArr, 0, bArr.length);
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    /* renamed from: newList */
    public static StringList m18306newList() {
        return new StringListImpl();
    }

    /* renamed from: split */
    public static String[] m18307split(String str, char c) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int iIndexOf = str.indexOf(c);
            if (iIndexOf >= 0) {
                vector.addElement(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public static int toByteArray(String str, byte[] bArr, int i) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i + i2] = (byte) str.charAt(i2);
        }
        return length;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) (c + ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
    
        throw new java.lang.IllegalStateException("invalid UTF-16 low surrogate");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void toUTF8ByteArray(char[] cArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3;
        int i4;
        if (i2 < 1) {
            return;
        }
        byte[] bArr = new byte[64];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 1;
            char c = cArr[i + i5];
            if (c < 128) {
                i3 = i6 + 1;
                bArr[i6] = (byte) c;
            } else {
                if (c < 2048) {
                    int i8 = i6 + 1;
                    bArr[i6] = (byte) ((c >> 6) | 192);
                    i4 = i6 + 2;
                    bArr[i8] = (byte) ((c & '?') | 128);
                } else if (c < 55296 || c > 57343) {
                    bArr[i6] = (byte) ((c >> '\f') | InterfaceC5102BERTags.f17976FLAGS);
                    bArr[i6 + 1] = (byte) (((c >> 6) & 63) | 128);
                    i3 = i6 + 3;
                    bArr[i6 + 2] = (byte) ((c & '?') | 128);
                } else {
                    if (c > 56319) {
                        throw new IllegalStateException("invalid UTF-16 high surrogate");
                    }
                    if (i7 >= i2) {
                        throw new IllegalStateException("invalid UTF-16 codepoint (truncated surrogate pair)");
                    }
                    int i9 = i5 + 2;
                    char c2 = cArr[i7 + i];
                    if (c2 < 56320 || c2 > 57343) {
                        break;
                    }
                    int i10 = ((c2 & 1023) | ((c & 1023) << 10)) + PKIFailureInfo.notAuthorized;
                    bArr[i6] = (byte) ((i10 >> 18) | 240);
                    bArr[i6 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                    int i11 = i6 + 3;
                    bArr[i6 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                    i4 = i6 + 4;
                    bArr[i11] = (byte) ((i10 & 63) | 128);
                    i7 = i9;
                }
                i3 = i4;
            }
            if (i3 + 4 > 64) {
                outputStream.write(bArr, 0, i3);
                i6 = 0;
            } else {
                i6 = i3;
            }
            if (i7 >= i2) {
                if (i6 > 0) {
                    outputStream.write(bArr, 0, i6);
                    return;
                }
                return;
            }
            i5 = i7;
        }
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) (c - ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String fromUTF8ByteArray(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2];
        int iTranscodeToUTF16 = C6256UTF8.transcodeToUTF16(bArr, i, i2, cArr);
        if (iTranscodeToUTF16 >= 0) {
            return new String(cArr, 0, iTranscodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        toUTF8ByteArray(cArr, 0, cArr.length, outputStream);
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        return toUTF8ByteArray(cArr, 0, cArr.length);
    }

    public static byte[] toUTF8ByteArray(char[] cArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }
}
