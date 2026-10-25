package com.p038google.p061crypto.p062tink.p075subtle;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p094kotlin.C1126UByte;

/* renamed from: com.google.crypto.tink.subtle.Base64 */
/* loaded from: classes.dex */
public final class C0852Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: CRLF */
    public static final int f3909CRLF = 4;

    /* renamed from: DEFAULT */
    public static final int f3910DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;

    /* renamed from: NO_WRAP */
    public static final int f3911NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* renamed from: UTF_8 */
    private static final Charset f3912UTF_8 = Charset.forName("UTF-8");

    /* renamed from: com.google.crypto.tink.subtle.Base64$Coder */
    public static abstract class Coder {

        /* renamed from: op */
        public int f3913op;

        /* renamed from: output */
        public byte[] f3914output;

        public abstract int maxOutputSize(int i);

        /* renamed from: process */
        public abstract boolean mo4228process(byte[] bArr, int i, int i2, boolean z);
    }

    /* renamed from: com.google.crypto.tink.subtle.Base64$Decoder */
    public static class Decoder extends Coder {

        /* renamed from: DECODE */
        private static final int[] f3915DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: EQUALS */
        private static final int f3916EQUALS = -2;

        /* renamed from: SKIP */
        private static final int f3917SKIP = -1;
        private final int[] alphabet;

        /* renamed from: state */
        private int f3918state;

        /* renamed from: value */
        private int f3919value;

        public Decoder(int i, byte[] bArr) {
            this.f3914output = bArr;
            this.alphabet = (i & 8) == 0 ? f3915DECODE : DECODE_WEBSAFE;
            this.f3918state = 0;
            this.f3919value = 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.C0852Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.C0852Base64.Coder
        /* renamed from: process */
        public boolean mo4228process(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f3918state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f3919value;
            byte[] bArr2 = this.f3914output;
            int[] iArr = this.alphabet;
            int i6 = 0;
            int i7 = i5;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i7 = (iArr[bArr[i9] & C1126UByte.MAX_VALUE] << 18) | (iArr[bArr[i9 + 1] & C1126UByte.MAX_VALUE] << 12) | (iArr[bArr[i9 + 2] & C1126UByte.MAX_VALUE] << 6) | iArr[bArr[i9 + 3] & C1126UByte.MAX_VALUE]) < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i7;
                        bArr2[i6 + 1] = (byte) (i7 >> 8);
                        bArr2[i6] = (byte) (i7 >> 16);
                        i6 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & C1126UByte.MAX_VALUE];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f3918state = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i6] = (byte) (i7 >> 4);
                                i6++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.f3918state = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.f3918state = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.f3918state = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i7 << 6);
                        bArr2[i6 + 2] = (byte) i13;
                        bArr2[i6 + 1] = (byte) (i13 >> 8);
                        bArr2[i6] = (byte) (i13 >> 16);
                        i6 += 3;
                        i7 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i6 + 1] = (byte) (i7 >> 2);
                        bArr2[i6] = (byte) (i7 >> 10);
                        i6 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        this.f3918state = 6;
                        return false;
                    }
                    i8++;
                    i7 = i12;
                } else if (i12 >= 0) {
                    i8++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.f3918state = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.f3918state = i8;
                this.f3919value = i7;
                this.f3913op = i6;
                return true;
            }
            if (i8 == 1) {
                this.f3918state = 6;
                return false;
            }
            if (i8 == 2) {
                bArr2[i6] = (byte) (i7 >> 4);
                i6++;
            } else if (i8 == 3) {
                int i14 = i6 + 1;
                bArr2[i6] = (byte) (i7 >> 10);
                i6 += 2;
                bArr2[i14] = (byte) (i7 >> 2);
            } else if (i8 == 4) {
                this.f3918state = 6;
                return false;
            }
            this.f3918state = i8;
            this.f3913op = i6;
            return true;
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.Base64$Encoder */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: ENCODE */
        private static final byte[] f3920ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;

        /* renamed from: count */
        private int f3921count;

        /* renamed from: doCr */
        public final boolean f3922doCr;
        public final boolean doNewline;
        public final boolean doPadding;

        /* renamed from: tail */
        private final byte[] f3923tail;

        /* renamed from: tailLen */
        int f3924tailLen;

        public Encoder(int i, byte[] bArr) {
            this.f3914output = bArr;
            this.doPadding = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.doNewline = z;
            this.f3922doCr = (i & 4) != 0;
            this.alphabet = (i & 8) == 0 ? f3920ENCODE : ENCODE_WEBSAFE;
            this.f3923tail = new byte[2];
            this.f3924tailLen = 0;
            this.f3921count = z ? 19 : -1;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.C0852Base64.Coder
        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x00e6 A[SYNTHETIC] */
        @Override // com.p038google.p061crypto.p062tink.p075subtle.C0852Base64.Coder
        /* renamed from: process */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean mo4228process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 481
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p038google.p061crypto.p062tink.p075subtle.C0852Base64.Encoder.mo4228process(byte[], int, int, boolean):boolean");
        }
    }

    private C0852Base64() {
    }

    /* renamed from: decode */
    public static byte[] m4221decode(String str) {
        return m4222decode(str, 2);
    }

    /* renamed from: encode */
    public static String m4225encode(byte[] bArr) {
        return encodeToString(bArr, 2);
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(m4226encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] urlSafeDecode(String str) {
        return m4222decode(str, 11);
    }

    public static String urlSafeEncode(byte[] bArr) {
        return encodeToString(bArr, 11);
    }

    /* renamed from: decode */
    public static byte[] m4222decode(String str, int i) {
        return m4223decode(str.getBytes(f3912UTF_8), i);
    }

    /* renamed from: encode */
    public static byte[] m4226encode(byte[] bArr, int i) {
        return m4227encode(bArr, 0, bArr.length, i);
    }

    /* renamed from: decode */
    public static byte[] m4223decode(byte[] bArr, int i) {
        return m4224decode(bArr, 0, bArr.length, i);
    }

    /* renamed from: encode */
    public static byte[] m4227encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (encoder.doPadding) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        }
        if (encoder.doNewline && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (encoder.f3922doCr ? 2 : 1);
        }
        encoder.f3914output = new byte[i4];
        encoder.mo4228process(bArr, i, i2, true);
        return encoder.f3914output;
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(m4227encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: decode */
    public static byte[] m4224decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[(i2 * 3) / 4]);
        if (decoder.mo4228process(bArr, i, i2, true)) {
            int i4 = decoder.f3913op;
            byte[] bArr2 = decoder.f3914output;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
