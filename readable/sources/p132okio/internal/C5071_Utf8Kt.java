package p132okio.internal;

import java.util.Arrays;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.C5066Utf8;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, m4988d2 = {"commonToUtf8String", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "beginIndex", BuildConfig.f24315FLAVOR, "endIndex", "commonAsUtf8ToByteArray", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n69#3:77\n75#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n"})
/* renamed from: okio.internal._Utf8Kt */
/* loaded from: classes.dex */
public final class C5071_Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (Intrinsics.m6319compare((int) cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i3 = i2;
                while (i2 < length2) {
                    char cCharAt3 = str.charAt(i2);
                    if (Intrinsics.m6319compare((int) cCharAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) cCharAt3;
                        i2++;
                        while (true) {
                            i3 = i4;
                            if (i2 >= length2 || Intrinsics.m6319compare((int) str.charAt(i2), 128) >= 0) {
                                break;
                            }
                            i4 = i3 + 1;
                            bArr[i3] = (byte) str.charAt(i2);
                            i2++;
                        }
                    } else {
                        if (Intrinsics.m6319compare((int) cCharAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((cCharAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i3] = (byte) ((cCharAt3 >> '\f') | InterfaceC5102BERTags.f17976FLAGS);
                            bArr[i3 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.m6319compare((int) cCharAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (cCharAt = str.charAt(i)) || cCharAt >= 57344) {
                            bArr[i3] = C5066Utf8.REPLACEMENT_BYTE;
                            i2++;
                            i3++;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i3 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((iCharAt & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                return bArrCopyOf;
            }
            bArr[i2] = (byte) cCharAt2;
            i2++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
        return bArrCopyOf2;
    }

    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = 3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i10 < 0 || i2 > bArr.length || i10 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i10 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i10];
        int i12 = 0;
        while (i10 < i2) {
            byte b = bArr[i10];
            if (b >= 0) {
                i8 = i12 + 1;
                cArr[i12] = (char) b;
                i10++;
                while (i10 < i2) {
                    byte b2 = bArr[i10];
                    if (b2 < 0) {
                        break;
                    }
                    i10++;
                    cArr[i8] = (char) b2;
                    i8++;
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } else if ((b >> 5) == -2) {
                int i13 = i10 + 1;
                if (i2 <= i13) {
                    i8 = i12 + 1;
                    cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b3 = bArr[i13];
                    if ((b3 & 192) == 128) {
                        int i14 = (b << 6) ^ (b3 ^ ByteCompanionObject.MIN_VALUE);
                        if (i14 < 128) {
                            i8 = i12 + 1;
                            cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i8 = i12 + 1;
                            cArr[i12] = (char) i14;
                        }
                        C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                        i9 = 2;
                        i10 += i9;
                    } else {
                        i8 = i12 + 1;
                        cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                C1133Unit c1133Unit3 = C1133Unit.INSTANCE;
                i9 = 1;
                i10 += i9;
            } else {
                if ((b >> 4) == -2) {
                    int i15 = i10 + 2;
                    if (i2 <= i15) {
                        i5 = i12 + 1;
                        cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                        C1133Unit c1133Unit4 = C1133Unit.INSTANCE;
                        int i16 = i10 + 1;
                        i7 = (i2 <= i16 || (bArr[i16] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b4 = bArr[i10 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i15];
                            if ((b5 & 192) == 128) {
                                int i17 = ((b5 ^ ByteCompanionObject.MIN_VALUE) ^ (b4 << 6)) ^ (b << 12);
                                if (i17 < 2048) {
                                    i6 = i12 + 1;
                                    cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                                } else if (55296 > i17 || i17 >= 57344) {
                                    char c = (char) i17;
                                    i6 = i12 + 1;
                                    cArr[i12] = c;
                                } else {
                                    i6 = i12 + 1;
                                    cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                                }
                                C1133Unit c1133Unit5 = C1133Unit.INSTANCE;
                                i5 = i6;
                                i7 = i11;
                            } else {
                                i5 = i12 + 1;
                                cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                                C1133Unit c1133Unit6 = C1133Unit.INSTANCE;
                            }
                        } else {
                            i5 = i12 + 1;
                            cArr[i12] = (char) C5066Utf8.REPLACEMENT_CODE_POINT;
                            C1133Unit c1133Unit7 = C1133Unit.INSTANCE;
                        }
                    }
                    i10 += i7;
                    i12 = i5;
                } else {
                    if ((b >> 3) == -2) {
                        int i18 = i10 + 3;
                        if (i2 <= i18) {
                            i3 = i12 + 1;
                            cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                            C1133Unit c1133Unit8 = C1133Unit.INSTANCE;
                            int i19 = i10 + 1;
                            if (i2 <= i19 || (bArr[i19] & 192) != 128) {
                                i11 = 1;
                            } else {
                                int i20 = i10 + 2;
                                if (i2 <= i20 || (bArr[i20] & 192) != 128) {
                                    i11 = 2;
                                }
                            }
                            i10 += i11;
                        } else {
                            byte b6 = bArr[i10 + 1];
                            if ((b6 & 192) == 128) {
                                byte b7 = bArr[i10 + 2];
                                if ((b7 & 192) == 128) {
                                    byte b8 = bArr[i18];
                                    if ((b8 & 192) == 128) {
                                        int i21 = (((b8 ^ ByteCompanionObject.MIN_VALUE) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b << 18);
                                        if (i21 > 1114111) {
                                            i3 = i12 + 1;
                                            cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                        } else if ((55296 > i21 || i21 >= 57344) && i21 >= 65536) {
                                            if (i21 != 65533) {
                                                cArr[i12] = (char) ((i21 >>> 10) + C5066Utf8.HIGH_SURROGATE_HEADER);
                                                i4 = i12 + 2;
                                                cArr[i12 + 1] = (char) ((i21 & 1023) + C5066Utf8.LOG_SURROGATE_HEADER);
                                            } else {
                                                cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                                i4 = i12 + 1;
                                            }
                                            C1133Unit c1133Unit9 = C1133Unit.INSTANCE;
                                            i3 = i4;
                                            i11 = 4;
                                        } else {
                                            i3 = i12 + 1;
                                            cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                        }
                                        C1133Unit c1133Unit10 = C1133Unit.INSTANCE;
                                        i11 = 4;
                                    } else {
                                        i3 = i12 + 1;
                                        cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                        C1133Unit c1133Unit11 = C1133Unit.INSTANCE;
                                        i11 = 3;
                                    }
                                    i10 += i11;
                                } else {
                                    i3 = i12 + 1;
                                    cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                    C1133Unit c1133Unit12 = C1133Unit.INSTANCE;
                                    i11 = 2;
                                    i10 += i11;
                                }
                            } else {
                                i3 = i12 + 1;
                                cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                                C1133Unit c1133Unit13 = C1133Unit.INSTANCE;
                                i11 = 1;
                                i10 += i11;
                            }
                        }
                    } else {
                        i3 = i12 + 1;
                        cArr[i12] = C5066Utf8.REPLACEMENT_CHARACTER;
                        i10++;
                    }
                    i12 = i3;
                }
                i11 = 3;
            }
            i12 = i8;
            i11 = 3;
        }
        return StringsKt.concatToString(cArr, 0, i12);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
