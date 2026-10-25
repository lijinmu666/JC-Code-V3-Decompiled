package p132okio.internal;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.C5049Base64;
import p132okio.C5052Buffer;
import p132okio.SegmentedByteString;
import p132okio._JvmPlatformKt;

@Metadata(m4987d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0080\b\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H\u0080\b\u001a\u001d\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0080\b\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0002H\u0080\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0015*\u00020\u0002H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0080\b\u001a-\u0010\u0017\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0080\b\u001a-\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0018*\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0018*\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0080\b\u001a\u001d\u0010%\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010'\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010'\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010(\u001a\u00020\u0018*\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0080\b\u001a\r\u0010*\u001a\u00020\u000e*\u00020\u0002H\u0080\b\u001a\u0015\u0010+\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0080\b\u001a\u0011\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0015H\u0080\b\u001a\u001d\u0010.\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0080\b\u001a\r\u0010/\u001a\u00020\u0002*\u00020\u0001H\u0080\b\u001a\u000f\u00100\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0080\b\u001a$\u00101\u001a\u00020\u001e*\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0000\u001a\r\u00104\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\u0018\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u000eH\u0002\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00068"}, m4988d2 = {"commonUtf8", BuildConfig.f24315FLAVOR, "Lokio/ByteString;", "commonBase64", "commonBase64Url", "HEX_DIGIT_CHARS", BuildConfig.f24315FLAVOR, "getHEX_DIGIT_CHARS", "()[C", "commonHex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonSubstring", "beginIndex", BuildConfig.f24315FLAVOR, "endIndex", "commonGetByte", BuildConfig.f24315FLAVOR, "pos", "commonGetSize", "commonToByteArray", BuildConfig.f24315FLAVOR, "commonInternalArray", "commonRangeEquals", BuildConfig.f24315FLAVOR, "offset", "other", "otherOffset", "byteCount", "commonCopyInto", BuildConfig.f24315FLAVOR, "target", "targetOffset", "commonStartsWith", "prefix", "commonEndsWith", "suffix", "commonIndexOf", "fromIndex", "commonLastIndexOf", "commonEquals", BuildConfig.f24315FLAVOR, "commonHashCode", "commonCompareTo", "commonOf", "data", "commonToByteString", "commonEncodeUtf8", "commonDecodeBase64", "commonWrite", "buffer", "Lokio/Buffer;", "commonToString", "codePointIndexToCharIndex", "s", "codePointCount", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-ByteString")
@SourceDebugExtension(m6344value = {"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,338:1\n128#1:344\n129#1,9:346\n69#2:339\n75#2:340\n75#2:342\n75#2:343\n69#2:370\n75#2:382\n1#3:341\n1#3:345\n212#4,7:355\n122#4:362\n219#4,5:363\n122#4:368\n226#4:369\n228#4:371\n397#4,2:372\n122#4:374\n400#4,6:375\n127#4:381\n406#4:383\n122#4:384\n407#4,13:385\n122#4:398\n422#4:399\n122#4:400\n425#4:401\n230#4,3:402\n440#4,3:405\n122#4:408\n443#4:409\n127#4:410\n446#4,10:411\n127#4:421\n456#4:422\n122#4:423\n457#4,4:424\n127#4:428\n461#4:429\n122#4:430\n462#4,14:431\n122#4:445\n477#4,2:446\n122#4:448\n481#4:449\n122#4:450\n484#4:451\n234#4,3:452\n500#4,3:455\n122#4:458\n503#4:459\n127#4:460\n506#4,2:461\n127#4:463\n510#4,10:464\n127#4:474\n520#4:475\n122#4:476\n521#4,4:477\n127#4:481\n525#4:482\n122#4:483\n526#4,4:484\n127#4:488\n530#4:489\n122#4:490\n531#4,15:491\n122#4:506\n547#4,2:507\n122#4:509\n550#4,2:510\n122#4:512\n554#4:513\n122#4:514\n557#4:515\n241#4:516\n122#4:517\n242#4,5:518\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n*L\n304#1:344\n304#1:346,9\n64#1:339\n65#1:340\n253#1:342\n254#1:343\n323#1:370\n323#1:382\n304#1:345\n323#1:355,7\n328#1:362\n323#1:363,5\n328#1:368\n323#1:369\n323#1:371\n323#1:372,2\n328#1:374\n323#1:375,6\n323#1:381\n323#1:383\n328#1:384\n323#1:385,13\n328#1:398\n323#1:399\n328#1:400\n323#1:401\n323#1:402,3\n323#1:405,3\n328#1:408\n323#1:409\n323#1:410\n323#1:411,10\n323#1:421\n323#1:422\n328#1:423\n323#1:424,4\n323#1:428\n323#1:429\n328#1:430\n323#1:431,14\n328#1:445\n323#1:446,2\n328#1:448\n323#1:449\n328#1:450\n323#1:451\n323#1:452,3\n323#1:455,3\n328#1:458\n323#1:459\n323#1:460\n323#1:461,2\n323#1:463\n323#1:464,10\n323#1:474\n323#1:475\n328#1:476\n323#1:477,4\n323#1:481\n323#1:482\n328#1:483\n323#1:484,4\n323#1:488\n323#1:489\n328#1:490\n323#1:491,15\n328#1:506\n323#1:507,2\n328#1:509\n323#1:510,2\n328#1:512\n323#1:513\n328#1:514\n323#1:515\n323#1:516\n328#1:517\n323#1:518,5\n*E\n"})
/* renamed from: okio.internal.-ByteString, reason: invalid class name */
/* loaded from: classes.dex */
public final class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
    
        r8 = p094kotlin.C1133Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int codePointIndexToCharIndex(byte[] bArr, int i) {
        byte b;
        int i2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (i3 < length) {
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                int i6 = i5 + 1;
                if (i5 == i) {
                    return i4;
                }
                if ((b2 != 10 && b2 != 13 && ((b2 >= 0 && b2 < 32) || (127 <= b2 && b2 < 160))) || b2 == 65533) {
                    return -1;
                }
                i4 += b2 < 65536 ? 1 : 2;
                i3++;
                while (true) {
                    i5 = i6;
                    if (i3 < length && (b = bArr[i3]) >= 0) {
                        i3++;
                        i6 = i5 + 1;
                        if (i5 != i) {
                            if ((b != 10 && b != 13 && ((b >= 0 && b < 32) || (127 <= b && b < 160))) || b == 65533) {
                                break loop0;
                            }
                            i4 += b < 65536 ? 1 : 2;
                        } else {
                            return i4;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i7 = i3 + 1;
                    if (length <= i7) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b3 = bArr[i7];
                    if ((b3 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    int i8 = (b3 ^ ByteCompanionObject.MIN_VALUE) ^ (b2 << 6);
                    if (i8 < 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    i2 = i5 + 1;
                    if (i5 == i) {
                        return i4;
                    }
                    if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                        return -1;
                    }
                    i4 += i8 < 65536 ? 1 : 2;
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    i3 += 2;
                } else if ((b2 >> 4) == -2) {
                    int i9 = i3 + 2;
                    if (length <= i9) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b4 = bArr[i3 + 1];
                    if ((b4 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b5 = bArr[i9];
                    if ((b5 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    int i10 = ((b4 << 6) ^ ((-123008) ^ b5)) ^ (b2 << 12);
                    if (i10 < 2048) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    if (55296 <= i10 && i10 < 57344) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    i2 = i5 + 1;
                    if (i5 == i) {
                        return i4;
                    }
                    if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                        return -1;
                    }
                    i4 += i10 < 65536 ? 1 : 2;
                    C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                    i3 += 3;
                } else {
                    if ((b2 >> 3) != -2) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    int i11 = i3 + 3;
                    if (length <= i11) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b6 = bArr[i3 + 1];
                    if ((b6 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b7 = bArr[i3 + 2];
                    if ((b7 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    byte b8 = bArr[i11];
                    if ((b8 & 192) != 128) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    int i12 = (((b8 ^ ByteCompanionObject.MIN_VALUE) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b2 << 18);
                    if (i12 > 1114111) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    if (55296 <= i12 && i12 < 57344) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    if (i12 < 65536) {
                        if (i5 == i) {
                            return i4;
                        }
                        return -1;
                    }
                    i2 = i5 + 1;
                    if (i5 == i) {
                        return i4;
                    }
                    if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                        return -1;
                    }
                    i4 += i12 < 65536 ? 1 : 2;
                    C1133Unit c1133Unit3 = C1133Unit.INSTANCE;
                    i3 += 4;
                }
                i5 = i2;
            }
        }
        return i4;
    }

    public static final String commonBase64(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return C5049Base64.encodeBase64$default(byteString.getData(), null, 1, null);
    }

    public static final String commonBase64Url(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return C5049Base64.encodeBase64(byteString.getData(), C5049Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(p132okio.ByteString byteString, p132okio.ByteString other) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM14252size = byteString.m14252size();
        int iM14252size2 = other.m14252size();
        int iMin = Math.min(iM14252size, iM14252size2);
        for (int i = 0; i < iMin; i++) {
            int iM14242getByte = byteString.m14242getByte(i) & C1126UByte.MAX_VALUE;
            int iM14242getByte2 = other.m14242getByte(i) & C1126UByte.MAX_VALUE;
            if (iM14242getByte != iM14242getByte2) {
                return iM14242getByte < iM14242getByte2 ? -1 : 1;
            }
        }
        if (iM14252size == iM14252size2) {
            return 0;
        }
        return iM14252size < iM14252size2 ? -1 : 1;
    }

    public static final void commonCopyInto(p132okio.ByteString byteString, int i, byte[] target, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto(byteString.getData(), target, i2, i, i3 + i);
    }

    public static final p132okio.ByteString commonDecodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrDecodeBase64ToArray = C5049Base64.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new p132okio.ByteString(bArrDecodeBase64ToArray);
        }
        return null;
    }

    public static final p132okio.ByteString commonEncodeUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        p132okio.ByteString byteString = new p132okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(p132okio.ByteString byteString, p132okio.ByteString suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.m14252size() - suffix.m14252size(), suffix, 0, suffix.m14252size());
    }

    public static final boolean commonEquals(p132okio.ByteString byteString, Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof p132okio.ByteString) {
            p132okio.ByteString byteString2 = (p132okio.ByteString) obj;
            if (byteString2.m14252size() == byteString.getData().length && byteString2.rangeEquals(0, byteString.getData(), 0, byteString.getData().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(p132okio.ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData()[i];
    }

    public static final int commonGetSize(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData().length;
    }

    public static final int commonHashCode(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode = byteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(byteString.getData());
        byteString.setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public static final String commonHex(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[byteString.getData().length * 2];
        int i = 0;
        for (byte b : byteString.getData()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final int commonIndexOf(p132okio.ByteString byteString, byte[] other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = byteString.getData().length - other.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public static final byte[] commonInternalArray(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData();
    }

    public static final int commonLastIndexOf(p132okio.ByteString byteString, p132okio.ByteString other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i);
    }

    public static final p132okio.ByteString commonOf(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return new p132okio.ByteString(bArrCopyOf);
    }

    public static final boolean commonRangeEquals(p132okio.ByteString byteString, int i, p132okio.ByteString other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i2, byteString.getData(), i, i3);
    }

    public static final boolean commonStartsWith(p132okio.ByteString byteString, p132okio.ByteString prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.m14252size());
    }

    public static final p132okio.ByteString commonSubstring(p132okio.ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 <= byteString.getData().length) {
            if (i2 - i >= 0) {
                return (i == 0 && i2 == byteString.getData().length) ? byteString : new p132okio.ByteString(ArraysKt.copyOfRange(byteString.getData(), i, i2));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
    }

    public static final p132okio.ByteString commonToAsciiLowercase(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getData().length; i++) {
            byte b = byteString.getData()[i];
            if (b >= 65 && b <= 90) {
                byte[] data = byteString.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new p132okio.ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    public static final p132okio.ByteString commonToAsciiUppercase(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getData().length; i++) {
            byte b = byteString.getData()[i];
            if (b >= 97 && b <= 122) {
                byte[] data = byteString.getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        bArrCopyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new p132okio.ByteString(bArrCopyOf);
            }
        }
        return byteString;
    }

    public static final byte[] commonToByteArray(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data = byteString.getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final p132okio.ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        SegmentedByteString.checkOffsetAndCount(bArr.length, i, i2);
        return new p132okio.ByteString(ArraysKt.copyOfRange(bArr, i, i2 + i));
    }

    public static final String commonToString(p132okio.ByteString byteString) {
        p132okio.ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        if (byteString.getData().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strM14254utf8 = byteString.m14254utf8();
            String strSubstring = strM14254utf8.substring(0, iCodePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (iCodePointIndexToCharIndex >= strM14254utf8.length()) {
                return "[text=" + strReplace$default + ']';
            }
            return "[size=" + byteString.getData().length + " text=" + strReplace$default + "…]";
        }
        if (byteString.getData().length <= 64) {
            return "[hex=" + byteString.mo14243hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(byteString.getData().length);
        sb.append(" hex=");
        if (64 <= byteString.getData().length) {
            if (64 != byteString.getData().length) {
                byteString2 = new p132okio.ByteString(ArraysKt.copyOfRange(byteString.getData(), 0, 64));
            }
            sb.append(byteString2.mo14243hex());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData().length + ')').toString());
    }

    public static final String commonUtf8(p132okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8 = byteString.getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(p132okio.ByteString byteString, C5052Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.mo14231write(byteString.getData(), i, i2);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(p132okio.ByteString byteString, byte[] suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.m14252size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(p132okio.ByteString byteString, byte[] other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (int iMin = Math.min(i, byteString.getData().length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(p132okio.ByteString byteString, int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return i >= 0 && i <= byteString.getData().length - i3 && i2 >= 0 && i2 <= other.length - i3 && SegmentedByteString.arrayRangeEquals(byteString.getData(), i, other, i2, i3);
    }

    public static final boolean commonStartsWith(p132okio.ByteString byteString, byte[] prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }
}
