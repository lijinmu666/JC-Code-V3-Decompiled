package org.bouncycastle.p361util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class Base64Encoder implements InterfaceC6254Encoder {
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: padding */
    protected byte f24211padding = C1217Base64.padSymbol;
    protected final byte[] decodingTable = new byte[128];

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c, char c2, char c3, char c4) throws IOException {
        char c5 = this.f24211padding;
        if (c3 == c5) {
            if (c4 != c5) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.decodingTable;
            byte b = bArr[c];
            byte b2 = bArr[c2];
            if ((b | b2) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b2 >> 4) | (b << 2));
            return 1;
        }
        byte[] bArr2 = this.decodingTable;
        if (c4 == c5) {
            byte b3 = bArr2[c];
            byte b4 = bArr2[c2];
            byte b5 = bArr2[c3];
            if ((b3 | b4 | b5) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b3 << 2) | (b4 >> 4));
            outputStream.write((b5 >> 2) | (b4 << 4));
            return 2;
        }
        byte b6 = bArr2[c];
        byte b7 = bArr2[c2];
        byte b8 = bArr2[c3];
        byte b9 = bArr2[c4];
        if ((b6 | b7 | b8 | b9) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b6 << 2) | (b7 >> 4));
        outputStream.write((b7 << 4) | (b8 >> 2));
        outputStream.write(b9 | (b8 << 6));
        return 3;
    }

    /* renamed from: ignore */
    private boolean m18333ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    /* renamed from: nextI */
    private int m18334nextI(String str, int i, int i2) {
        while (i < i2 && m18333ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }

    @Override // org.bouncycastle.p361util.encoders.InterfaceC6254Encoder
    /* renamed from: decode */
    public int mo18320decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && m18333ignore(str.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i = length;
        int i2 = 0;
        while (i > 0 && i2 != 4) {
            if (!m18333ignore(str.charAt(i - 1))) {
                i2++;
            }
            i--;
        }
        int iM18334nextI = m18334nextI(str, 0, i);
        int i3 = 0;
        int i4 = 0;
        while (iM18334nextI < i) {
            int i5 = iM18334nextI + 1;
            byte b = this.decodingTable[str.charAt(iM18334nextI)];
            int iM18334nextI2 = m18334nextI(str, i5, i);
            int i6 = iM18334nextI2 + 1;
            byte b2 = this.decodingTable[str.charAt(iM18334nextI2)];
            int iM18334nextI3 = m18334nextI(str, i6, i);
            int i7 = iM18334nextI3 + 1;
            byte b3 = this.decodingTable[str.charAt(iM18334nextI3)];
            int iM18334nextI4 = m18334nextI(str, i7, i);
            int i8 = iM18334nextI4 + 1;
            byte b4 = this.decodingTable[str.charAt(iM18334nextI4)];
            if ((b | b2 | b3 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
            int i9 = i3 + 2;
            bArr[i3 + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            i3 += 3;
            bArr[i9] = (byte) ((b3 << 6) | b4);
            i4 += 3;
            if (i3 == 54) {
                outputStream.write(bArr);
                i3 = 0;
            }
            iM18334nextI = m18334nextI(str, i8, i);
        }
        if (i3 > 0) {
            outputStream.write(bArr, 0, i3);
        }
        int iM18334nextI5 = m18334nextI(str, iM18334nextI, length);
        int iM18334nextI6 = m18334nextI(str, iM18334nextI5 + 1, length);
        int iM18334nextI7 = m18334nextI(str, iM18334nextI6 + 1, length);
        return i4 + decodeLastBlock(outputStream, str.charAt(iM18334nextI5), str.charAt(iM18334nextI6), str.charAt(iM18334nextI7), str.charAt(m18334nextI(str, iM18334nextI7 + 1, length)));
    }

    @Override // org.bouncycastle.p361util.encoders.InterfaceC6254Encoder
    /* renamed from: encode */
    public int mo18322encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        if (i2 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(54, i3);
            outputStream.write(bArr2, 0, m18336encode(bArr, i, iMin, bArr2, 0));
            i += iMin;
            i3 -= iMin;
        }
        return ((i2 + 2) / 3) * 4;
    }

    @Override // org.bouncycastle.p361util.encoders.InterfaceC6254Encoder
    public int getEncodedLength(int i) {
        return ((i + 2) / 3) * 4;
    }

    @Override // org.bouncycastle.p361util.encoders.InterfaceC6254Encoder
    public int getMaxDecodedLength(int i) {
        return (i / 4) * 3;
    }

    public void initialiseDecodingTable() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i >= bArr2.length) {
                return;
            }
            this.decodingTable[bArr2[i]] = (byte) i;
            i++;
        }
    }

    /* renamed from: nextI */
    private int m18335nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && m18333ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    @Override // org.bouncycastle.p361util.encoders.InterfaceC6254Encoder
    /* renamed from: decode */
    public int mo18321decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[54];
        int i3 = i + i2;
        while (i3 > i && m18333ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        if (i3 == 0) {
            return 0;
        }
        int i4 = i3;
        int i5 = 0;
        while (i4 > i && i5 != 4) {
            if (!m18333ignore((char) bArr[i4 - 1])) {
                i5++;
            }
            i4--;
        }
        int iM18335nextI = m18335nextI(bArr, i, i4);
        int i6 = 0;
        int i7 = 0;
        while (iM18335nextI < i4) {
            int i8 = iM18335nextI + 1;
            byte b = this.decodingTable[bArr[iM18335nextI]];
            int iM18335nextI2 = m18335nextI(bArr, i8, i4);
            int i9 = iM18335nextI2 + 1;
            byte b2 = this.decodingTable[bArr[iM18335nextI2]];
            int iM18335nextI3 = m18335nextI(bArr, i9, i4);
            int i10 = iM18335nextI3 + 1;
            byte b3 = this.decodingTable[bArr[iM18335nextI3]];
            int iM18335nextI4 = m18335nextI(bArr, i10, i4);
            int i11 = iM18335nextI4 + 1;
            byte b4 = this.decodingTable[bArr[iM18335nextI4]];
            if ((b | b2 | b3 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            bArr2[i6] = (byte) ((b << 2) | (b2 >> 4));
            int i12 = i6 + 2;
            bArr2[i6 + 1] = (byte) ((b2 << 4) | (b3 >> 2));
            i6 += 3;
            bArr2[i12] = (byte) ((b3 << 6) | b4);
            if (i6 == 54) {
                outputStream.write(bArr2);
                i6 = 0;
            }
            i7 += 3;
            iM18335nextI = m18335nextI(bArr, i11, i4);
        }
        if (i6 > 0) {
            outputStream.write(bArr2, 0, i6);
        }
        int iM18335nextI5 = m18335nextI(bArr, iM18335nextI, i3);
        int iM18335nextI6 = m18335nextI(bArr, iM18335nextI5 + 1, i3);
        int iM18335nextI7 = m18335nextI(bArr, iM18335nextI6 + 1, i3);
        return i7 + decodeLastBlock(outputStream, (char) bArr[iM18335nextI5], (char) bArr[iM18335nextI6], (char) bArr[iM18335nextI7], (char) bArr[m18335nextI(bArr, iM18335nextI7 + 1, i3)]);
    }

    /* renamed from: encode */
    public int m18336encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i + i2) - 2;
        int i5 = i;
        int i6 = i3;
        while (i5 < i4) {
            byte b = bArr[i5];
            int i7 = i5 + 2;
            int i8 = bArr[i5 + 1] & C1126UByte.MAX_VALUE;
            i5 += 3;
            byte b2 = bArr[i7];
            int i9 = b2 & C1126UByte.MAX_VALUE;
            byte[] bArr3 = this.encodingTable;
            bArr2[i6] = bArr3[(b >>> 2) & 63];
            bArr2[i6 + 1] = bArr3[((b << 4) | (i8 >>> 4)) & 63];
            int i10 = i6 + 3;
            bArr2[i6 + 2] = bArr3[((i8 << 2) | (i9 >>> 6)) & 63];
            i6 += 4;
            bArr2[i10] = bArr3[b2 & C5066Utf8.REPLACEMENT_BYTE];
        }
        int i11 = i2 - (i5 - i);
        if (i11 == 1) {
            int i12 = bArr[i5] & C1126UByte.MAX_VALUE;
            byte[] bArr4 = this.encodingTable;
            bArr2[i6] = bArr4[(i12 >>> 2) & 63];
            bArr2[i6 + 1] = bArr4[(i12 << 4) & 63];
            int i13 = i6 + 3;
            byte b3 = this.f24211padding;
            bArr2[i6 + 2] = b3;
            i6 += 4;
            bArr2[i13] = b3;
        } else if (i11 == 2) {
            int i14 = i5 + 1;
            int i15 = bArr[i5] & C1126UByte.MAX_VALUE;
            int i16 = bArr[i14] & C1126UByte.MAX_VALUE;
            byte[] bArr5 = this.encodingTable;
            bArr2[i6] = bArr5[(i15 >>> 2) & 63];
            bArr2[i6 + 1] = bArr5[((i15 << 4) | (i16 >>> 4)) & 63];
            int i17 = i6 + 3;
            bArr2[i6 + 2] = bArr5[(i16 << 2) & 63];
            i6 += 4;
            bArr2[i17] = this.f24211padding;
        }
        return i6 - i3;
    }
}
