package p094kotlin.p121uuid;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1130ULong;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.UByteArray;
import p094kotlin.WasExperimental;
import p094kotlin.comparisons.ComparisonsKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.StringsKt;
import p094kotlin.p119time.C1324Instant;
import p094kotlin.p119time.InterfaceC1323Clock;
import p132okio.C5066Utf8;

@SinceKotlin(m5061version = "2.4")
@Metadata(m4987d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u00013B\u0019\bB\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJa\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016Ja\u0010\u0018\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u0086\u0080\u0004J\u0015\u0010 \u001a\u00020!H\u0087\u0080\u0004b\u0002\b$¢\u0006\u0004\b\"\u0010#J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0082\u0004J\u0012\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0000H\u0096\u0082\u0004J\n\u0010+\u001a\u00020*H\u0096\u0080\u0004J\n\u0010,\u001a\u00020(H\u0082\u0080\u0004J\u001b\u0010-\u001a\u00020.2\n\u0010/\u001a\u000600j\u0002`1H\u0082\u0080\u0004¢\u0006\u0002\u00102R!\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fÊ\u0001\f\b5\u0012\b\b6\u0012\u0004\b\b(7Ê\u0001\u0010\b8\u0012\f\b9\u0012\b\b\fJ\u0004\b\t0:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, m4988d2 = {"Lkotlin/uuid/Uuid;", BuildConfig.f24315FLAVOR, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", BuildConfig.f24315FLAVOR, "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "Lkotlin/PublishedApi;", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "toULongs", "Lkotlin/ULong;", "toString", BuildConfig.f24315FLAVOR, "toHexDashString", "toHexString", "toByteArray", BuildConfig.f24315FLAVOR, "toUByteArray", "Lkotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "Lkotlin/ExperimentalUnsignedTypes;", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "compareTo", BuildConfig.f24315FLAVOR, "hashCode", "writeReplace", "readObject", BuildConfig.f24315FLAVOR, "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "2.4", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/uuid/ExperimentalUuidApi;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalUuidApi.class})
/* renamed from: kotlin.uuid.Uuid */
/* loaded from: classes.dex */
public final class C1327Uuid implements Comparable<C1327Uuid>, Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NIL */
    private static final C1327Uuid f5464NIL = new C1327Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    @Metadata(m4987d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0080\u0004J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0080\u0004J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0087\u0080\u0004b\u0002\b\u001b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\n\u0010&\u001a\u00020\u0005H\u0086\u0080\u0004J\u001c\u0010'\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u001c\u0010,\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J$\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u0017\u0010,\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0080\u0080\u0004¢\u0006\u0002\b2R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000Ry\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000504j\b\u0012\u0004\u0012\u00020\u0005`58FX\u0087\u0084\br\u0002\b+r0\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\"\b<\u0012\u001e\b\u000bB\u001a\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\f\b@\u0012\b\b\fJ\u0004\b\b(Ar\u0016\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\b\bE\u0012\u0004\b\b(F¢\u0006\f\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u00108¨\u0006G"}, m4988d2 = {"Lkotlin/uuid/Uuid$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "NIL", "Lkotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", BuildConfig.f24315FLAVOR, "SIZE_BITS", "fromLongs", "mostSignificantBits", BuildConfig.f24315FLAVOR, "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", BuildConfig.f24315FLAVOR, "fromUByteArray", "ubyteArray", "Lkotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "Lkotlin/ExperimentalUnsignedTypes;", "parse", "uuidString", BuildConfig.f24315FLAVOR, "parseOrNull", "parseHexDash", "hexDashString", "parseHexDashOrNull", "parseHex", "hexString", "parseHexOrNull", "random", "generateV4", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/uuid/ExperimentalUuidApi;", "generateV7", "generateV7NonMonotonicAt", "timestamp", "Lkotlin/time/Instant;", "clock", "Lkotlin/time/Clock;", "generateV7$kotlin_stdlib", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "Lkotlin/Deprecated;", "message", "Use naturalOrder<Uuid>() instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "naturalOrder<Uuid>()", "imports", "kotlin.comparisons.naturalOrder", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.1", "errorSince", "2.4", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.uuid.Uuid$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(m4972message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", m5048imports = {"kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(errorSince = "2.4", warningSince = "2.1")
        @ExperimentalUuidApi
        public static /* synthetic */ void getLEXICAL_ORDER$annotations() {
        }

        public final C1327Uuid fromByteArray(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (byteArray.length == 16) {
                return fromLongs(UuidKt__UuidJVMKt.getLongAt(byteArray, 0), UuidKt__UuidJVMKt.getLongAt(byteArray, 8));
            }
            throw new IllegalArgumentException(("Expected exactly 16 bytes, but was " + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(byteArray, 32) + " of size " + byteArray.length).toString());
        }

        public final C1327Uuid fromLongs(long mostSignificantBits, long leastSignificantBits) {
            return (mostSignificantBits == 0 && leastSignificantBits == 0) ? m6893getNIL() : new C1327Uuid(mostSignificantBits, leastSignificantBits, null);
        }

        @ExperimentalUnsignedTypes
        /* renamed from: fromUByteArray-GBYM_sE, reason: not valid java name */
        public final C1327Uuid m19978fromUByteArrayGBYM_sE(byte[] ubyteArray) {
            Intrinsics.checkNotNullParameter(ubyteArray, "ubyteArray");
            return fromByteArray(ubyteArray);
        }

        /* renamed from: fromULongs-eb3DHEI, reason: not valid java name */
        public final C1327Uuid m19979fromULongseb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        @SinceKotlin(m5061version = "2.3")
        @ExperimentalUuidApi
        public final C1327Uuid generateV4() {
            return UuidKt__UuidKt.secureRandomUuid();
        }

        @SinceKotlin(m5061version = "2.3")
        @ExperimentalUuidApi
        public final C1327Uuid generateV7() {
            return generateV7$kotlin_stdlib(InterfaceC1323Clock.System.INSTANCE);
        }

        public final C1327Uuid generateV7$kotlin_stdlib(InterfaceC1323Clock clock) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            return UuidV7Generator.INSTANCE.generate(clock);
        }

        @SinceKotlin(m5061version = "2.3")
        @ExperimentalUuidApi
        public final C1327Uuid generateV7NonMonotonicAt(C1324Instant timestamp) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            byte[] bArr = new byte[10];
            UuidKt__UuidJVMKt.secureRandomBytes(bArr);
            long epochMilliseconds = (timestamp.toEpochMilliseconds() << 16) | (((bArr[8] & 15) | 112) << 8) | (bArr[9] & C1126UByte.MAX_VALUE);
            bArr[0] = (byte) (((byte) (bArr[0] & C5066Utf8.REPLACEMENT_BYTE)) | ByteCompanionObject.MIN_VALUE);
            return fromLongs(epochMilliseconds, UuidKt__UuidJVMKt.getLongAt(bArr, 0));
        }

        public final Comparator<C1327Uuid> getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }

        /* renamed from: getNIL */
        public final C1327Uuid m6893getNIL() {
            return C1327Uuid.f5464NIL;
        }

        /* renamed from: parse */
        public final C1327Uuid m6894parse(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return UuidKt__UuidJVMKt.uuidParseHex(uuidString);
            }
            if (length == 36) {
                return UuidKt__UuidJVMKt.uuidParseHexDash(uuidString);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(uuidString, 64) + "\" of length " + uuidString.length());
        }

        public final C1327Uuid parseHex(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() == 32) {
                return UuidKt__UuidJVMKt.uuidParseHex(hexString);
            }
            throw new IllegalArgumentException(("Expected a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexString, 64) + "\" of length " + hexString.length()).toString());
        }

        public final C1327Uuid parseHexDash(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() == 36) {
                return UuidKt__UuidJVMKt.uuidParseHexDash(hexDashString);
            }
            throw new IllegalArgumentException(("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"" + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexDashString, 64) + "\" of length " + hexDashString.length()).toString());
        }

        public final C1327Uuid parseHexDashOrNull(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() != 36) {
                return null;
            }
            return UuidKt__UuidJVMKt.uuidParseHexDashOrNull(hexDashString);
        }

        public final C1327Uuid parseHexOrNull(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() != 32) {
                return null;
            }
            return UuidKt__UuidJVMKt.uuidParseHexOrNull(hexString);
        }

        public final C1327Uuid parseOrNull(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return parseHexOrNull(uuidString);
            }
            if (length != 36) {
                return null;
            }
            return parseHexDashOrNull(uuidString);
        }

        /* renamed from: random */
        public final C1327Uuid m6895random() {
            return generateV4();
        }

        private Companion() {
        }
    }

    public /* synthetic */ C1327Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @PublishedApi
    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @InlineOnly
    /* renamed from: toLongs */
    private final <T> T m6891toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo2167invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    @InlineOnly
    private final <T> T toULongs(Function2<? super C1130ULong, ? super C1130ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo2167invoke(C1130ULong.m18714boximpl(C1130ULong.m18720constructorimpl(getMostSignificantBits())), C1130ULong.m18714boximpl(C1130ULong.m18720constructorimpl(getLeastSignificantBits())));
    }

    private final Object writeReplace() {
        return UuidKt__UuidJVMKt.serializedUuid(this);
    }

    /* renamed from: equals */
    public boolean m6892equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C1327Uuid)) {
            return false;
        }
        C1327Uuid c1327Uuid = (C1327Uuid) other;
        return this.mostSignificantBits == c1327Uuid.mostSignificantBits && this.leastSignificantBits == c1327Uuid.leastSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt__UuidJVMKt.setLongAt(bArr, 0, this.mostSignificantBits);
        UuidKt__UuidJVMKt.setLongAt(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    public final String toHexDashString() {
        byte[] bArr = new byte[36];
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 24, 2, 8);
        return StringsKt.decodeToString(bArr);
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt__UuidJVMKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 8);
        UuidKt__UuidJVMKt.formatBytesInto(this.leastSignificantBits, bArr, 16, 0, 8);
        return StringsKt.decodeToString(bArr);
    }

    public String toString() {
        return toHexDashString();
    }

    @ExperimentalUnsignedTypes
    /* renamed from: toUByteArray-TcUX1vc, reason: not valid java name */
    public final byte[] m19977toUByteArrayTcUX1vc() {
        return UByteArray.m18617constructorimpl(toByteArray());
    }

    private C1327Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    @Override // java.lang.Comparable
    public int compareTo(C1327Uuid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.mostSignificantBits;
        return j != other.mostSignificantBits ? Long.compareUnsigned(C1130ULong.m18720constructorimpl(j), C1130ULong.m18720constructorimpl(other.mostSignificantBits)) : Long.compareUnsigned(C1130ULong.m18720constructorimpl(this.leastSignificantBits), C1130ULong.m18720constructorimpl(other.leastSignificantBits));
    }
}
