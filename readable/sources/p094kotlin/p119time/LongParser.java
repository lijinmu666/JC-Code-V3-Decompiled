package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007Jw\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m4988d2 = {"Lkotlin/time/LongParser;", BuildConfig.f24315FLAVOR, "overflowLimit", BuildConfig.f24315FLAVOR, "allowSign", BuildConfig.f24315FLAVOR, "<init>", "(JZ)V", "overflowThreshold", "lastDigitMax", "parse", "value", BuildConfig.f24315FLAVOR, "startIndex", BuildConfig.f24315FLAVOR, "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "endIndex", "sign", "hasOverflow", BuildConfig.f24315FLAVOR, "Companion", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/LongParser\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,1629:1\n1665#2,3:1630\n1665#2,3:1633\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/LongParser\n*L\n1311#1:1630,3\n1318#1:1633,3\n*E\n"})
/* loaded from: classes.dex */
public final class LongParser {
    private final boolean allowSign;
    private final long lastDigitMax;
    private final long overflowLimit;
    private final long overflowThreshold;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: iso */
    private static final LongParser f5453iso = new LongParser(DurationKt.MAX_MILLIS, true);

    /* renamed from: default */
    private static final LongParser f5452default = new LongParser(LongCompanionObject.MAX_VALUE, false);

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m4988d2 = {"Lkotlin/time/LongParser$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "iso", "Lkotlin/time/LongParser;", "getIso", "()Lkotlin/time/LongParser;", "default", "getDefault", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LongParser getDefault() {
            return LongParser.f5452default;
        }

        /* renamed from: getIso */
        public final LongParser m6885getIso() {
            return LongParser.f5453iso;
        }

        private Companion() {
        }
    }

    private LongParser(long j, boolean z) {
        this.overflowLimit = j;
        this.allowSign = z;
        long j2 = 10;
        this.overflowThreshold = j / j2;
        this.lastDigitMax = j % j2;
    }

    /* renamed from: parse */
    public final long m6884parse(String value, int startIndex, Function3<? super Integer, ? super Integer, ? super Boolean, C1133Unit> callback) {
        int i;
        char cCharAt;
        char cCharAt2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.allowSign) {
            char cCharAt3 = value.charAt(startIndex);
            if (cCharAt3 == '+') {
                startIndex++;
            } else if (cCharAt3 == '-') {
                startIndex++;
                i = -1;
            }
            i = 1;
        } else {
            i = 1;
        }
        while (startIndex < value.length() && value.charAt(startIndex) == '0') {
            startIndex++;
        }
        long j = 0;
        while (startIndex < value.length() && '0' <= (cCharAt = value.charAt(startIndex)) && cCharAt < ':') {
            int i2 = cCharAt - '0';
            if (j > this.overflowThreshold || (j == this.overflowThreshold && i2 > this.lastDigitMax)) {
                while (startIndex < value.length() && '0' <= (cCharAt2 = value.charAt(startIndex)) && cCharAt2 < ':') {
                    startIndex++;
                }
                callback.mo6219invoke(Integer.valueOf(startIndex), Integer.valueOf(i), Boolean.TRUE);
                return this.overflowLimit;
            }
            j = i2 + (j << 3) + (j << 1);
            startIndex++;
        }
        callback.mo6219invoke(Integer.valueOf(startIndex), Integer.valueOf(i), Boolean.FALSE);
        return j;
    }
}
