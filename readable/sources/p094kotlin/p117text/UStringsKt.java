package p094kotlin.p117text;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.C1132UShort;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.UnsignedKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0013\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0015\u001a!\u0010\u0016\u001a\u00020\n*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0017\u001a)\u0010\u0016\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0018\u001a!\u0010\u0019\u001a\u00020\r*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u001a\u001a)\u0010\u0019\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u0010*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u001d\u001a)\u0010\u001c\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010\u001f\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a\u001e\u0010 \u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010 \u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a\u001e\u0010!\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010!\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010\u0010*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001a&\u0010\"\u001a\u0004\u0018\u00010\u0010*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¨\u0006#"}, m4988d2 = {"toString", BuildConfig.f24315FLAVOR, "Lkotlin/UByte;", "radix", BuildConfig.f24315FLAVOR, "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/SinceKotlin;", "version", "1.5", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toUByteOrNull", "toUShortOrNull", "toUIntOrNull", "toULongOrNull", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "UStringsKt")
/* loaded from: classes.dex */
public final class UStringsKt {
    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m19820toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m19821toStringLxnNnR4(byte b, int i) {
        String string = Integer.toString(b & C1126UByte.MAX_VALUE, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m19822toStringV7xB4Y4(int i, int i2) {
        return UnsignedKt.ulongToString(i & BodyPartID.bodyIdMax, C1302CharsKt.checkRadix(i2));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m19823toStringolVBNx4(short s, int i) {
        String string = Integer.toString(s & 65535, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toUByte */
    public static final byte m6852toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1126UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1126UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toUInt */
    public static final int m6854toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1128UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1128UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toULong */
    public static final long m6856toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1130ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1130ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1132UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1132UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toUByte */
    public static final byte m6853toUByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1126UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1126UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1128UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, C1128UInt.m18641constructorimpl(255)) > 0) {
            return null;
        }
        return C1126UByte.m18558boximpl(C1126UByte.m18564constructorimpl((byte) data));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toUInt */
    public static final int m6855toUInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1128UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1128UInt toUIntOrNull(String str, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1302CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt < '0') {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iM18641constructorimpl = C1128UInt.m18641constructorimpl(i);
        int iDivideUnsigned = 119304647;
        while (i2 < length) {
            int iM6675digitOf = CharsKt__CharJVMKt.m6675digitOf(str.charAt(i2), i);
            if (iM6675digitOf < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iM18641constructorimpl);
                    if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int iM18641constructorimpl2 = C1128UInt.m18641constructorimpl(i3 * iM18641constructorimpl);
            int iM18641constructorimpl3 = C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(iM6675digitOf) + iM18641constructorimpl2);
            if (Integer.compareUnsigned(iM18641constructorimpl3, iM18641constructorimpl2) < 0) {
                return null;
            }
            i2++;
            i3 = iM18641constructorimpl3;
        }
        return C1128UInt.m18635boximpl(i3);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: toULong */
    public static final long m6857toULong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1130ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1130ULong toULongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1302CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt < '0') {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM18720constructorimpl = C1130ULong.m18720constructorimpl(i);
        long j = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i2 < length) {
            if (CharsKt__CharJVMKt.m6675digitOf(str.charAt(i2), i) < 0) {
                return null;
            }
            if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jM18720constructorimpl);
                    if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long jM18720constructorimpl2 = C1130ULong.m18720constructorimpl(j * jM18720constructorimpl);
            long jM18720constructorimpl3 = C1130ULong.m18720constructorimpl(C1130ULong.m18720constructorimpl(C1128UInt.m18641constructorimpl(r13) & BodyPartID.bodyIdMax) + jM18720constructorimpl2);
            if (Long.compareUnsigned(jM18720constructorimpl3, jM18720constructorimpl2) < 0) {
                return null;
            }
            i2++;
            j = jM18720constructorimpl3;
        }
        return C1130ULong.m18714boximpl(j);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final short toUShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1132UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1132UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1128UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, C1128UInt.m18641constructorimpl(Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)) > 0) {
            return null;
        }
        return C1132UShort.m18821boximpl(C1132UShort.m18827constructorimpl((short) data));
    }
}
