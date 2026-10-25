package p094kotlin.p101io.encoding;

import java.io.IOException;
import java.nio.charset.Charset;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.collections.AbstractList;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.C1302CharsKt;
import p094kotlin.p117text.Charsets;
import p132okio.C5066Utf8;

@SinceKotlin(m5061version = "2.2")
@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000 F2\u00020\u0001:\u0002EFB)\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bH\u0087\u0080\u0004b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J&\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004JE\u0010\"\u001a\u0002H#\"\f\b\u0000\u0010#*\u00060$j\u0002`%2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u0002H#2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0087\u0080\bb\u0002\b'¢\u0006\u0002\u0010&J&\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J&\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020*2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J8\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0086\u0080\u0004J'\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b,J7\u0010-\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b.J\u0017\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b1J\n\u00102\u001a\u00020\u0003H\u0082\u0080\u0004J2\u00103\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0082\u0080\u0004J'\u00104\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b5J'\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b7J\u0017\u00108\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0002\b9J*\u0010:\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0082\u0080\u0004J\u0012\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020\u0006H\u0082\u0080\u0004J\"\u0010?\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0082\u0080\u0004J'\u0010@\u001a\u00020>2\u0006\u00100\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\bAJ\"\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u00020\bX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000f\u0010\u0012\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(HÊ\u0001\u0010\bI\u0012\f\bJ\u0012\b\b\fJ\u0004\b\t0K¨\u0006G"}, m4988d2 = {"Lkotlin/io/encoding/Base64;", BuildConfig.f24315FLAVOR, "isUrlSafe", BuildConfig.f24315FLAVOR, "isMimeScheme", "mimeLineLength", BuildConfig.f24315FLAVOR, "paddingOption", "Lkotlin/io/encoding/Base64$PaddingOption;", "<init>", "(ZZILkotlin/io/encoding/Base64$PaddingOption;)V", "isUrlSafe$kotlin_stdlib", "()Z", "isMimeScheme$kotlin_stdlib", "getMimeLineLength$kotlin_stdlib", "()I", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "mimeGroupsPerLine", "withPadding", "option", "Lkotlin/SinceKotlin;", "version", "2.0", "encodeToByteArray", BuildConfig.f24315FLAVOR, "source", "startIndex", "endIndex", "encodeIntoByteArray", "destination", "destinationOffset", "encode", BuildConfig.f24315FLAVOR, "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "Lkotlin/IgnorableReturnValue;", "decode", "decodeIntoByteArray", BuildConfig.f24315FLAVOR, "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "sourceSize", "encodeSize$kotlin_stdlib", "shouldPadOnEncode", "decodeImpl", "decodeSize", "decodeSize$kotlin_stdlib", "charsToBytesImpl", "charsToBytesImpl$kotlin_stdlib", "bytesToStringImpl", "bytesToStringImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "checkPaddingIsAllowed", BuildConfig.f24315FLAVOR, "skipIllegalSymbolsIfMime", "checkSourceBounds", "checkSourceBounds$kotlin_stdlib", "checkDestinationBounds", "destinationSize", "capacityNeeded", "PaddingOption", "Default", "kotlin-stdlib", "2.2", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/io/encoding/ExperimentalEncodingApi;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalEncodingApi.class})
/* renamed from: kotlin.io.encoding.Base64 */
/* loaded from: classes.dex */
public class C1217Base64 {

    /* renamed from: Mime */
    private static final C1217Base64 f5084Mime;

    /* renamed from: Pem */
    private static final C1217Base64 f5085Pem;

    /* renamed from: UrlSafe */
    private static final C1217Base64 f5086UrlSafe;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int lineLengthMime = 76;
    private static final int lineLengthPem = 64;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final int mimeGroupsPerLine;
    private final int mimeLineLength;
    private final PaddingOption paddingOption;

    /* renamed from: Default, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] mimeLineSeparatorSymbols = {13, 10};

    @Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\nX\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u00020\u000eX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0016\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, m4988d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "<init>", "()V", "bitsPerByte", BuildConfig.f24315FLAVOR, "bitsPerSymbol", "bytesPerGroup", "symbolsPerGroup", "padSymbol", BuildConfig.f24315FLAVOR, "lineLengthMime", "lineLengthPem", "mimeLineSeparatorSymbols", BuildConfig.f24315FLAVOR, "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "UrlSafe", "getUrlSafe", "()Lkotlin/io/encoding/Base64;", "Mime", "getMime", "Pem", "getPem", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.io.encoding.Base64$Default, reason: from kotlin metadata */
    public static final class Companion extends C1217Base64 {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getMime */
        public final C1217Base64 m6214getMime() {
            return C1217Base64.f5084Mime;
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return C1217Base64.mimeLineSeparatorSymbols;
        }

        /* renamed from: getPem */
        public final C1217Base64 m6215getPem() {
            return C1217Base64.f5085Pem;
        }

        public final C1217Base64 getUrlSafe() {
            return C1217Base64.f5086UrlSafe;
        }

        private Companion() {
            super(false, false, -1, PaddingOption.f5089PRESENT, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @SinceKotlin(m5061version = "2.0")
    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\b"}, m4988d2 = {"Lkotlin/io/encoding/Base64$PaddingOption;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "2.0"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.io.encoding.Base64$PaddingOption */
    public static final class PaddingOption {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ PaddingOption[] f5087$VALUES;

        /* renamed from: PRESENT */
        public static final PaddingOption f5089PRESENT = new PaddingOption("PRESENT", 0);

        /* renamed from: ABSENT */
        public static final PaddingOption f5088ABSENT = new PaddingOption("ABSENT", 1);
        public static final PaddingOption PRESENT_OPTIONAL = new PaddingOption("PRESENT_OPTIONAL", 2);
        public static final PaddingOption ABSENT_OPTIONAL = new PaddingOption("ABSENT_OPTIONAL", 3);

        /* renamed from: $values */
        private static final /* synthetic */ PaddingOption[] m6216$values() {
            return new PaddingOption[]{f5089PRESENT, f5088ABSENT, PRESENT_OPTIONAL, ABSENT_OPTIONAL};
        }

        static {
            PaddingOption[] paddingOptionArrM6216$values = m6216$values();
            f5087$VALUES = paddingOptionArrM6216$values;
            $ENTRIES = EnumEntriesKt.enumEntries(paddingOptionArrM6216$values);
        }

        private PaddingOption(String str, int i) {
        }

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static PaddingOption m6217valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        /* renamed from: values */
        public static PaddingOption[] m6218values() {
            return (PaddingOption[]) f5087$VALUES.clone();
        }
    }

    static {
        PaddingOption paddingOption = PaddingOption.f5089PRESENT;
        f5086UrlSafe = new C1217Base64(true, false, -1, paddingOption);
        f5084Mime = new C1217Base64(false, true, 76, paddingOption);
        f5085Pem = new C1217Base64(false, true, 64, paddingOption);
    }

    public /* synthetic */ C1217Base64(boolean z, boolean z2, int i, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, i, paddingOption);
    }

    private final void checkDestinationBounds(int destinationSize, int destinationOffset, int capacityNeeded) {
        if (destinationOffset < 0 || destinationOffset > destinationSize) {
            throw new IndexOutOfBoundsException("destination offset: " + destinationOffset + ", destination size: " + destinationSize);
        }
        int i = destinationOffset + capacityNeeded;
        if (i < 0 || i > destinationSize) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + destinationOffset + ", destination size: " + destinationSize + ", capacity needed: " + capacityNeeded);
        }
    }

    private final void checkPaddingIsAllowed(int padIndex) {
        if (this.paddingOption != PaddingOption.f5088ABSENT) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + padIndex);
    }

    public static /* synthetic */ byte[] decode$default(C1217Base64 c1217Base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return c1217Base64.m6212decode(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d0, code lost:
    
        if (r7 == (-2)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d3, code lost:
    
        if (r7 == (-8)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d5, code lost:
    
        if (r4 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00db, code lost:
    
        if (r18.paddingOption == p094kotlin.p101io.encoding.C1217Base64.PaddingOption.f5089PRESENT) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e5, code lost:
    
        throw new java.lang.IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        if (r8 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        r0 = skipIllegalSymbolsIfMime(r19, r6, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
    
        if (r0 < r23) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f0, code lost:
    
        return r9 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
    
        r1 = r19[r0] & p094kotlin.C1126UByte.MAX_VALUE;
        r3 = new java.lang.StringBuilder();
        r3.append("Symbol '");
        r3.append((char) r1);
        r3.append("'(");
        r1 = java.lang.Integer.toString(r1, p094kotlin.p117text.C1302CharsKt.checkRadix(8));
        p094kotlin.p105jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        r3.append(r1);
        r3.append(") at index ");
        r3.append(r0 - 1);
        r3.append(" is prohibited after the pad character");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
    
        throw new java.lang.IllegalArgumentException(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0134, code lost:
    
        throw new java.lang.IllegalArgumentException("The pad bits must be zeros");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013c, code lost:
    
        throw new java.lang.IllegalArgumentException("The last unit of input does not have enough bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int decodeImpl(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        boolean z;
        int[] iArr = this.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int i = -8;
        int i2 = destinationOffset;
        int iHandlePaddingSymbol = startIndex;
        int i3 = -8;
        int i4 = 0;
        while (true) {
            if (iHandlePaddingSymbol >= endIndex) {
                z = false;
                break;
            }
            if (i3 == i && iHandlePaddingSymbol + 3 < endIndex) {
                int i5 = iHandlePaddingSymbol + 4;
                int i6 = (iArr[source[iHandlePaddingSymbol + 1] & C1126UByte.MAX_VALUE] << 12) | (iArr[source[iHandlePaddingSymbol] & C1126UByte.MAX_VALUE] << 18) | (iArr[source[iHandlePaddingSymbol + 2] & C1126UByte.MAX_VALUE] << 6) | iArr[source[iHandlePaddingSymbol + 3] & C1126UByte.MAX_VALUE];
                if (i6 >= 0) {
                    destination[i2] = (byte) (i6 >> 16);
                    int i7 = i2 + 2;
                    destination[i2 + 1] = (byte) (i6 >> 8);
                    i2 += 3;
                    destination[i7] = (byte) i6;
                    iHandlePaddingSymbol = i5;
                }
                i = -8;
            }
            int i8 = source[iHandlePaddingSymbol] & C1126UByte.MAX_VALUE;
            int i9 = iArr[i8];
            if (i9 >= 0) {
                iHandlePaddingSymbol++;
                i4 = (i4 << 6) | i9;
                int i10 = i3 + 6;
                if (i10 >= 0) {
                    destination[i2] = (byte) (i4 >>> i10);
                    i4 &= (1 << i10) - 1;
                    i3 -= 2;
                    i2++;
                } else {
                    i3 = i10;
                }
            } else {
                if (i9 == -2) {
                    iHandlePaddingSymbol = handlePaddingSymbol(source, iHandlePaddingSymbol, endIndex, i3);
                    z = true;
                    break;
                }
                if (!this.isMimeScheme) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid symbol '");
                    sb.append((char) i8);
                    sb.append("'(");
                    String string = Integer.toString(i8, C1302CharsKt.checkRadix(8));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    sb.append(string);
                    sb.append(") at index ");
                    sb.append(iHandlePaddingSymbol);
                    throw new IllegalArgumentException(sb.toString());
                }
                iHandlePaddingSymbol++;
            }
            i = -8;
        }
    }

    public static /* synthetic */ int decodeIntoByteArray$default(C1217Base64 c1217Base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return c1217Base64.decodeIntoByteArray(bArr, bArr2, i5, i6, i3);
    }

    public static /* synthetic */ String encode$default(C1217Base64 c1217Base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return c1217Base64.m6213encode(bArr, i, i2);
    }

    public static /* synthetic */ int encodeIntoByteArray$default(C1217Base64 c1217Base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return c1217Base64.encodeIntoByteArray(bArr, bArr2, i5, i6, i3);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(C1217Base64 c1217Base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return c1217Base64.encodeToAppendable(bArr, appendable, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(C1217Base64 c1217Base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return c1217Base64.encodeToByteArray(bArr, i, i2);
    }

    private final int handlePaddingSymbol(byte[] source, int padIndex, int endIndex, int byteStart) {
        if (byteStart == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + padIndex);
        }
        if (byteStart == -6) {
            checkPaddingIsAllowed(padIndex);
        } else {
            if (byteStart == -4) {
                checkPaddingIsAllowed(padIndex);
                int iSkipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(source, padIndex + 1, endIndex);
                if (iSkipIllegalSymbolsIfMime != endIndex && source[iSkipIllegalSymbolsIfMime] == 61) {
                    return iSkipIllegalSymbolsIfMime + 1;
                }
                throw new IllegalArgumentException("Missing one pad character at index " + iSkipIllegalSymbolsIfMime);
            }
            if (byteStart != -2) {
                throw new IllegalStateException("Unreachable");
            }
        }
        return padIndex + 1;
    }

    private final boolean shouldPadOnEncode() {
        PaddingOption paddingOption = this.paddingOption;
        return paddingOption == PaddingOption.f5089PRESENT || paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    private final int skipIllegalSymbolsIfMime(byte[] source, int startIndex, int endIndex) {
        if (!this.isMimeScheme) {
            return startIndex;
        }
        while (startIndex < endIndex) {
            if (Base64Kt.base64DecodeMap[source[startIndex] & C1126UByte.MAX_VALUE] != -1) {
                return startIndex;
            }
            startIndex++;
        }
        return startIndex;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b : source) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
        byte[] bArr = new byte[endIndex - startIndex];
        int i = 0;
        while (startIndex < endIndex) {
            char cCharAt = source.charAt(startIndex);
            if (cCharAt <= 255) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else {
                bArr[i] = C5066Utf8.REPLACEMENT_BYTE;
                i++;
            }
            startIndex++;
        }
        return bArr;
    }

    public final void checkSourceBounds$kotlin_stdlib(int sourceSize, int startIndex, int endIndex) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, sourceSize);
    }

    /* renamed from: decode */
    public final byte[] m6212decode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        int iDecodeSize$kotlin_stdlib = decodeSize$kotlin_stdlib(source, startIndex, endIndex);
        byte[] bArr = new byte[iDecodeSize$kotlin_stdlib];
        if (decodeImpl(source, bArr, 0, startIndex, endIndex) == iDecodeSize$kotlin_stdlib) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int decodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, decodeSize$kotlin_stdlib(source, startIndex, endIndex));
        return decodeImpl(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int decodeSize$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        int i = endIndex - startIndex;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + startIndex + ", endIndex: " + endIndex);
        }
        if (this.isMimeScheme) {
            while (true) {
                if (startIndex >= endIndex) {
                    break;
                }
                int i2 = Base64Kt.base64DecodeMap[source[startIndex] & C1126UByte.MAX_VALUE];
                if (i2 < 0) {
                    if (i2 == -2) {
                        i -= endIndex - startIndex;
                        break;
                    }
                    i--;
                }
                startIndex++;
            }
        } else if (source[endIndex - 1] == 61) {
            i = source[endIndex + (-2)] == 61 ? i - 2 : i - 1;
        }
        return (int) ((i * 6) / 8);
    }

    /* renamed from: encode */
    public final String m6213encode(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
    }

    public final int encodeIntoByteArray(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        int i = startIndex;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, i, endIndex);
        checkDestinationBounds(destination.length, destinationOffset, encodeSize$kotlin_stdlib(endIndex - i));
        byte[] bArr = this.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int i2 = this.isMimeScheme ? this.mimeGroupsPerLine : Integer.MAX_VALUE;
        int i3 = destinationOffset;
        while (i + 2 < endIndex) {
            int iMin = Math.min((endIndex - i) / 3, i2);
            for (int i4 = 0; i4 < iMin; i4++) {
                int i5 = source[i] & C1126UByte.MAX_VALUE;
                int i6 = i + 2;
                int i7 = source[i + 1] & C1126UByte.MAX_VALUE;
                i += 3;
                int i8 = (i7 << 8) | (i5 << 16) | (source[i6] & C1126UByte.MAX_VALUE);
                destination[i3] = bArr[i8 >>> 18];
                destination[i3 + 1] = bArr[(i8 >>> 12) & 63];
                int i9 = i3 + 3;
                destination[i3 + 2] = bArr[(i8 >>> 6) & 63];
                i3 += 4;
                destination[i9] = bArr[i8 & 63];
            }
            if (iMin == i2 && i != endIndex) {
                int i10 = i3 + 1;
                byte[] bArr2 = mimeLineSeparatorSymbols;
                destination[i3] = bArr2[0];
                i3 += 2;
                destination[i10] = bArr2[1];
            }
        }
        int i11 = endIndex - i;
        if (i11 == 1) {
            int i12 = i + 1;
            int i13 = (source[i] & C1126UByte.MAX_VALUE) << 4;
            destination[i3] = bArr[i13 >>> 6];
            int i14 = i3 + 2;
            destination[i3 + 1] = bArr[i13 & 63];
            if (shouldPadOnEncode()) {
                int i15 = i3 + 3;
                destination[i14] = padSymbol;
                i3 += 4;
                destination[i15] = padSymbol;
                i = i12;
            } else {
                i = i12;
                i3 = i14;
            }
        } else if (i11 == 2) {
            int i16 = i + 1;
            int i17 = source[i] & C1126UByte.MAX_VALUE;
            i += 2;
            int i18 = ((source[i16] & C1126UByte.MAX_VALUE) << 2) | (i17 << 10);
            destination[i3] = bArr[i18 >>> 12];
            destination[i3 + 1] = bArr[(i18 >>> 6) & 63];
            int i19 = i3 + 3;
            destination[i3 + 2] = bArr[i18 & 63];
            if (shouldPadOnEncode()) {
                i3 += 4;
                destination[i19] = padSymbol;
            } else {
                i3 = i19;
            }
        }
        if (i == endIndex) {
            return i3 - destinationOffset;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int encodeSize$kotlin_stdlib(int sourceSize) {
        int i = sourceSize / 3;
        int i2 = sourceSize % 3;
        int i3 = i * 4;
        if (i2 != 0) {
            i3 += shouldPadOnEncode() ? 4 : i2 + 1;
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Input is too big");
        }
        if (this.isMimeScheme) {
            i3 += ((i3 - 1) / this.mimeLineLength) * 2;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @IgnorableReturnValue
    public final <A extends Appendable> A encodeToAppendable(byte[] source, A destination, int startIndex, int endIndex) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        destination.append(new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1));
        return destination;
    }

    public final byte[] encodeToByteArray(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        byte[] bArr = new byte[encodeSize$kotlin_stdlib(endIndex - startIndex)];
        encodeIntoByteArrayImpl$kotlin_stdlib(source, bArr, 0, startIndex, endIndex);
        return bArr;
    }

    /* renamed from: getMimeLineLength$kotlin_stdlib, reason: from getter */
    public final int getMimeLineLength() {
        return this.mimeLineLength;
    }

    /* renamed from: getPaddingOption$kotlin_stdlib, reason: from getter */
    public final PaddingOption getPaddingOption() {
        return this.paddingOption;
    }

    /* renamed from: isMimeScheme$kotlin_stdlib, reason: from getter */
    public final boolean getIsMimeScheme() {
        return this.isMimeScheme;
    }

    /* renamed from: isUrlSafe$kotlin_stdlib, reason: from getter */
    public final boolean getIsUrlSafe() {
        return this.isUrlSafe;
    }

    @SinceKotlin(m5061version = "2.0")
    public final C1217Base64 withPadding(PaddingOption option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return this.paddingOption == option ? this : new C1217Base64(this.isUrlSafe, this.isMimeScheme, this.mimeLineLength, option);
    }

    private C1217Base64(boolean z, boolean z2, int i, PaddingOption paddingOption) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        this.mimeLineLength = i;
        this.paddingOption = paddingOption;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.mimeGroupsPerLine = i / 4;
    }

    public static /* synthetic */ byte[] decode$default(C1217Base64 c1217Base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return c1217Base64.m6211decode(charSequence, i, i2);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(C1217Base64 c1217Base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = charSequence.length();
        }
        return c1217Base64.decodeIntoByteArray(charSequence, bArr, i5, i6, i3);
    }

    public final int decodeIntoByteArray(CharSequence source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), startIndex, endIndex);
            String strSubstring = str.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decodeIntoByteArray$default(this, bArrCharsToBytesImpl$kotlin_stdlib, destination, destinationOffset, 0, 0, 24, (Object) null);
    }

    /* renamed from: decode */
    public final byte[] m6211decode(CharSequence source, int startIndex, int endIndex) {
        byte[] bArrCharsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String) {
            String str = (String) source;
            checkSourceBounds$kotlin_stdlib(str.length(), startIndex, endIndex);
            String strSubstring = str.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrCharsToBytesImpl$kotlin_stdlib = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArrCharsToBytesImpl$kotlin_stdlib, "getBytes(...)");
        } else {
            bArrCharsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decode$default(this, bArrCharsToBytesImpl$kotlin_stdlib, 0, 0, 6, (Object) null);
    }
}
