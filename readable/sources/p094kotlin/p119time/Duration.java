package p094kotlin.p119time;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.comparisons.ComparisonsKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p109math.C1237MathKt;
import p094kotlin.p112ranges.LongRange;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p117text.StringsKt;

@SinceKotlin(m5061version = "1.6")
@Metadata(m4987d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0090\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0090\u0001B+\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\b\t\u0012\u0006\b\n0\n8\u000b¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015J\u0011\u0010\u001c\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b(\u0010!J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b+\u0010,J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b+\u0010.J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b0\u0010,J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b0\u0010.J\u0019\u0010/\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b8\u0010\u0015J\u0011\u00109\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b:\u0010\u0015J\u0011\u0010;\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010\u0015J\u0011\u0010=\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b>\u0010\u0015J\u0019\u0010A\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\bB\u0010CJ\u009e\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010PJ\u0089\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010RJt\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010TJ_\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010VJ\u0019\u0010e\u001a\u00020-2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bi\u00106J\u0019\u0010j\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bk\u0010lJ\u0011\u0010{\u001a\u00020|H\u0096\u0080\u0004¢\u0006\u0004\b}\u0010~JJ\u0010\u007f\u001a\u00030\u0080\u0001*\b0\u0081\u0001j\u0003`\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u00104\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J%\u0010{\u001a\u00020|2\u0006\u00104\u001a\u00020\u00192\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000fH\u0086\u0080\u0004¢\u0006\u0005\b}\u0010\u008a\u0001J\u0013\u0010\u008b\u0001\u001a\u00020|H\u0086\u0080\u0004¢\u0006\u0005\b\u008c\u0001\u0010~J\u0016\u0010\u008d\u0001\u001a\u00020\u00132\t\u0010\u001f\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0083\u0004J\u000b\u0010\u008f\u0001\u001a\u00020\u000fHÖ\u0081\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u00020\u00038BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000f8Â\u0002X\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010?\u001a\u00020\u00008FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u001f\u0010W\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0011R\u001f\u0010\\\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b]\u0010Y\u001a\u0004\b^\u0010\u0011R\u001f\u0010_\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b`\u0010Y\u001a\u0004\ba\u0010\u0011R\u001f\u0010b\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bc\u0010Y\u001a\u0004\bd\u0010\u0011R\u0015\u0010m\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0015\u0010o\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0015\u0010q\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u0015\u0010s\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bt\u0010\u0005R\u0015\u0010u\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bv\u0010\u0005R\u0015\u0010w\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bx\u0010\u0005R\u0015\u0010y\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bz\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\u000f\b\u0092\u0001\u0012\n\b\u0093\u0001\u0012\u0005\b\b(\u0094\u0001Ê\u0001\u0003\b\u0095\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0091\u0001"}, m4988d2 = {"Lkotlin/time/Duration;", BuildConfig.f24315FLAVOR, "rawValue", BuildConfig.f24315FLAVOR, "constructor-impl", "(J)J", "Lkotlin/Deprecated;", "message", "Don't call this constructor directly.", "level", "Lkotlin/DeprecationLevel;", "ERROR", "value", "getValue-impl", "unitDiscriminator", BuildConfig.f24315FLAVOR, "getUnitDiscriminator-impl", "(J)I", "isInNanos", BuildConfig.f24315FLAVOR, "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", BuildConfig.f24315FLAVOR, "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "Lkotlin/PublishedApi;", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "appendFractional", BuildConfig.f24315FLAVOR, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", BuildConfig.f24315FLAVOR, "hashCode", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.6", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
@SourceDebugExtension(m6344value = {"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1629:1\n41#1:1630\n41#1:1631\n41#1:1632\n41#1:1633\n41#1:1634\n572#1:1635\n589#1:1643\n173#2,6:1636\n1#3:1642\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n42#1:1630\n43#1:1631\n353#1:1632\n362#1:1633\n546#1:1634\n847#1:1635\n938#1:1643\n889#1:1636,6\n*E\n"})
/* loaded from: classes.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ZERO */
    private static final long f5442ZERO = m19836constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    public static final long INVALID_RAW_VALUE = 9223372036854759646L;

    /* renamed from: INVALID */
    private static final long f5441INVALID = m19836constructorimpl(INVALID_RAW_VALUE);

    @Metadata(m4987d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0087\u0080\u0004b\u0002\b\u001dJ\u0019\u0010:\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b?\u0010=J\u0019\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bAJ\u0019\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bCR\u001d\u0010\n\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u000f\u0010\u0013\u001a\u00020\u0007X\u0080Ô\b¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\rR$\u0010\u001e\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010\u001e\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010%\u001a\u0004\b\"\u0010\tR$\u0010\u001e\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010&\u001a\u0004\b\"\u0010'R$\u0010(\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#R$\u0010(\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b*\u0010\tR$\u0010(\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010'R$\u0010+\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R$\u0010+\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010\tR$\u0010+\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010'R$\u0010.\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010#R$\u0010.\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010%\u001a\u0004\b0\u0010\tR$\u0010.\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b0\u0010'R$\u00101\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010!\u001a\u0004\b3\u0010#R$\u00101\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010%\u001a\u0004\b3\u0010\tR$\u00101\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b3\u0010'R$\u00104\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#R$\u00104\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b6\u0010\tR$\u00104\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010'R$\u00107\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010#R$\u00107\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010%\u001a\u0004\b9\u0010\tR$\u00107\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010&\u001a\u0004\b9\u0010'¨\u0006D"}, m4988d2 = {"Lkotlin/time/Duration$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "fromRawValue", "Lkotlin/time/Duration;", "rawValue", BuildConfig.f24315FLAVOR, "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "ZERO", "getZERO-UwyO8pc$annotations", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID_RAW_VALUE", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "getINVALID-UwyO8pc$kotlin_stdlib", "convert", BuildConfig.f24315FLAVOR, "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "Lkotlin/time/ExperimentalTime;", "nanoseconds", BuildConfig.f24315FLAVOR, "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "Lkotlin/internal/InlineOnly;", "(J)V", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", BuildConfig.f24315FLAVOR, "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Duration.kt\nkotlin/time/DurationKt\n*L\n1#1,1629:1\n1#2:1630\n1465#3:1631\n1465#3:1632\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration$Companion\n*L\n337#1:1631\n347#1:1632\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m19884getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.f5444DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19886getDaysUwyO8pc$annotations(double d) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m19890getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.f5445HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19892getHoursUwyO8pc$annotations(double d) {
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib$annotations, reason: not valid java name */
        public static /* synthetic */ void m19895getINVALIDUwyO8pc$kotlin_stdlib$annotations() {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m19897getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19899getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m19903getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19905getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m19909getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.f5446MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19911getMinutesUwyO8pc$annotations(double d) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m19915getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19917getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m19921getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.f5447SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19923getSecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getZERO-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19926getZEROUwyO8pc$annotations() {
        }

        @ExperimentalTime
        /* renamed from: convert */
        public final double m6869convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* renamed from: fromRawValue-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m19927fromRawValueUwyO8pc$kotlin_stdlib(long rawValue) {
            long jM19836constructorimpl = Duration.m19836constructorimpl(rawValue);
            if (DurationJvmKt.getDurationAssertionsEnabled()) {
                if (Duration.m19860isInNanosimpl(jM19836constructorimpl)) {
                    long jM19856getValueimpl = Duration.m19856getValueimpl(jM19836constructorimpl);
                    if (-4611686018426999999L > jM19856getValueimpl || jM19856getValueimpl >= 4611686018427000000L) {
                        throw new AssertionError(Duration.m19856getValueimpl(jM19836constructorimpl) + " ns is out of nanoseconds range");
                    }
                } else {
                    long jM19856getValueimpl2 = Duration.m19856getValueimpl(jM19836constructorimpl);
                    if (-4611686018427387903L >= jM19856getValueimpl2 || jM19856getValueimpl2 >= DurationKt.MAX_MILLIS) {
                        long jM19856getValueimpl3 = Duration.m19856getValueimpl(jM19836constructorimpl);
                        if (jM19856getValueimpl3 != DurationKt.MAX_MILLIS && jM19856getValueimpl3 != -4611686018427387903L) {
                            throw new AssertionError(Duration.m19856getValueimpl(jM19836constructorimpl) + " ms is out of milliseconds range");
                        }
                    }
                    long jM19856getValueimpl4 = Duration.m19856getValueimpl(jM19836constructorimpl);
                    if (-4611686018426L <= jM19856getValueimpl4 && jM19856getValueimpl4 < 4611686018427L) {
                        throw new AssertionError(Duration.m19856getValueimpl(jM19836constructorimpl) + " ms is denormalized");
                    }
                }
            }
            return jM19836constructorimpl;
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m19928getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getINVALID-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m19929getINVALIDUwyO8pc$kotlin_stdlib() {
            return Duration.f5441INVALID;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m19930getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m19931getZEROUwyO8pc() {
            return Duration.f5442ZERO;
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m19932parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long duration$default = DurationKt.parseDuration$default(value, false, false, 4, null);
                if (Duration.m19841equalsimpl0(duration$default, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed");
                }
                return duration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m19933parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long duration$default = DurationKt.parseDuration$default(value, true, false, 4, null);
                if (Duration.m19841equalsimpl0(duration$default, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed");
                }
                return duration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m19934parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long duration = DurationKt.parseDuration(value, true, false);
            if (Duration.m19841equalsimpl0(duration, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m19834boximpl(duration);
        }

        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m19935parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long duration = DurationKt.parseDuration(value, false, false);
            if (Duration.m19841equalsimpl0(duration, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m19834boximpl(duration);
        }

        private Companion() {
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m19885getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.f5444DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19887getDaysUwyO8pc$annotations(int i) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m19891getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.f5445HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19893getHoursUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m19898getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19900getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m19904getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19906getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m19910getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.f5446MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19912getMinutesUwyO8pc$annotations(int i) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m19916getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19918getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m19922getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.f5447SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19924getSecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m19883getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.f5444DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19888getDaysUwyO8pc$annotations(long j) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m19889getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.f5445HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19894getHoursUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m19896getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19901getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m19902getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19907getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m19908getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.f5446MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19913getMinutesUwyO8pc$annotations(long j) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m19914getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19919getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m19920getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.f5447SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m19925getSecondsUwyO8pc$annotations(long j) {
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Don't call this constructor directly.")
    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m19832addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long jAddMillisWithoutOverflow = DurationKt.addMillisWithoutOverflow(j2, jNanosToMillis);
        if (-4611686018426L > jAddMillisWithoutOverflow || jAddMillisWithoutOverflow >= 4611686018427L) {
            return DurationKt.durationOfMillis(jAddMillisWithoutOverflow);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jAddMillisWithoutOverflow) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m19833appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strPadStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m19834boximpl(long j) {
        return new Duration(j);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Don't call this constructor directly.")
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m19836constructorimpl(long j) {
        return j;
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m19837divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.m6047maxOf(m19854getStorageUnitimpl(j), m19854getStorageUnitimpl(j2));
        return m19872toDoubleimpl(j, durationUnit) / m19872toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m19839divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m19863isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m19862isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m19860isInNanosimpl(j)) {
            return DurationKt.durationOfNanos(m19856getValueimpl(j) / i);
        }
        if (m19861isInfiniteimpl(j)) {
            return m19867timesUwyO8pc(j, C1237MathKt.m6389getSign(i));
        }
        long j2 = i;
        long jM19856getValueimpl = m19856getValueimpl(j) / j2;
        if (-4611686018426L > jM19856getValueimpl || jM19856getValueimpl >= 4611686018427L) {
            return DurationKt.durationOfMillis(jM19856getValueimpl);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jM19856getValueimpl) + (DurationKt.millisToNanos(m19856getValueimpl(j) - (jM19856getValueimpl * j2)) / j2));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m19840equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m19841equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m19842getAbsoluteValueUwyO8pc(long j) {
        return m19862isNegativeimpl(j) ? m19880unaryMinusUwyO8pc(j) : j;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m19843getHoursComponentimpl(long j) {
        if (m19861isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m19845getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m19844getInWholeDaysimpl(long j) {
        return m19875toLongimpl(j, DurationUnit.f5444DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m19845getInWholeHoursimpl(long j) {
        return m19875toLongimpl(j, DurationUnit.f5445HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m19846getInWholeMicrosecondsimpl(long j) {
        return m19875toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m19847getInWholeMillisecondsimpl(long j) {
        return (m19859isInMillisimpl(j) && m19858isFiniteimpl(j)) ? m19856getValueimpl(j) : m19875toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m19848getInWholeMinutesimpl(long j) {
        return m19875toLongimpl(j, DurationUnit.f5446MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m19849getInWholeNanosecondsimpl(long j) {
        long jM19856getValueimpl = m19856getValueimpl(j);
        if (m19860isInNanosimpl(j)) {
            return jM19856getValueimpl;
        }
        if (jM19856getValueimpl > 9223372036854L) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (jM19856getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(jM19856getValueimpl);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m19850getInWholeSecondsimpl(long j) {
        return m19875toLongimpl(j, DurationUnit.f5447SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m19851getMinutesComponentimpl(long j) {
        if (m19861isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m19848getInWholeMinutesimpl(j) % 60);
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m19852getNanosecondsComponentimpl(long j) {
        if (m19861isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m19859isInMillisimpl(j) ? DurationKt.millisToNanos(m19856getValueimpl(j) % NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE) : m19856getValueimpl(j) % InstantKt.NANOS_PER_SECOND);
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m19853getSecondsComponentimpl(long j) {
        if (m19861isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m19850getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m19854getStorageUnitimpl(long j) {
        return m19860isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m19855getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getValue-impl, reason: not valid java name */
    public static final long m19856getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m19857hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m19858isFiniteimpl(long j) {
        return !m19861isInfiniteimpl(j);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m19859isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isInNanos-impl, reason: not valid java name */
    public static final boolean m19860isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m19861isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m19862isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m19863isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m19864minusLRDsOJo(long j, long j2) {
        return m19865plusLRDsOJo(j, m19880unaryMinusUwyO8pc(j2));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m19865plusLRDsOJo(long j, long j2) {
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return m19859isInMillisimpl(j) ? m19832addValuesMixedRangesUwyO8pc(j, m19856getValueimpl(j), m19856getValueimpl(j2)) : m19832addValuesMixedRangesUwyO8pc(j, m19856getValueimpl(j2), m19856getValueimpl(j));
        }
        if (m19860isInNanosimpl(j)) {
            return DurationKt.durationOfNanosNormalized(m19856getValueimpl(j) + m19856getValueimpl(j2));
        }
        long jAddMillisWithoutOverflow = DurationKt.addMillisWithoutOverflow(m19856getValueimpl(j), m19856getValueimpl(j2));
        if (jAddMillisWithoutOverflow != INVALID_RAW_VALUE) {
            return (jAddMillisWithoutOverflow == DurationKt.MAX_MILLIS || jAddMillisWithoutOverflow == -4611686018427387903L) ? DurationKt.durationOfMillis(jAddMillisWithoutOverflow) : DurationKt.durationOfMillisNormalized(jAddMillisWithoutOverflow);
        }
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m19867timesUwyO8pc(long j, int i) {
        if (m19861isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m19880unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return f5442ZERO;
        }
        long jM19856getValueimpl = m19856getValueimpl(j);
        long j2 = i;
        long j3 = jM19856getValueimpl * j2;
        if (!m19860isInNanosimpl(j)) {
            return j3 / j2 == jM19856getValueimpl ? DurationKt.durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS))) : C1237MathKt.m6390getSign(jM19856getValueimpl) * C1237MathKt.m6389getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM19856getValueimpl && jM19856getValueimpl < 2147483648L) {
            return DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM19856getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM19856getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM19856getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        return (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) ? C1237MathKt.m6390getSign(jM19856getValueimpl) * C1237MathKt.m6389getSign(i) > 0 ? INFINITE : NEG_INFINITE : DurationKt.durationOfMillis(RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m19871toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo6277invoke(Long.valueOf(m19844getInWholeDaysimpl(j)), Integer.valueOf(m19843getHoursComponentimpl(j)), Integer.valueOf(m19851getMinutesComponentimpl(j)), Integer.valueOf(m19853getSecondsComponentimpl(j)), Integer.valueOf(m19852getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m19872toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m19856getValueimpl(j), m19854getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m19873toIntimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m19875toLongimpl(j, unit), -2147483648L, 2147483647L);
    }

    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m19874toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m19862isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM19842getAbsoluteValueUwyO8pc = m19842getAbsoluteValueUwyO8pc(j);
        long jM19845getInWholeHoursimpl = m19845getInWholeHoursimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19851getMinutesComponentimpl = m19851getMinutesComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19853getSecondsComponentimpl = m19853getSecondsComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19852getNanosecondsComponentimpl = m19852getNanosecondsComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        if (m19861isInfiniteimpl(j)) {
            jM19845getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = jM19845getInWholeHoursimpl != 0;
        boolean z3 = (iM19853getSecondsComponentimpl == 0 && iM19852getNanosecondsComponentimpl == 0) ? false : true;
        if (iM19851getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM19845getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM19851getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m19833appendFractionalimpl(j, sb, iM19853getSecondsComponentimpl, iM19852getNanosecondsComponentimpl, 9, "S", true);
        }
        return sb.toString();
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m19875toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m19856getValueimpl(j), m19854getStorageUnitimpl(j), unit);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m19876toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM19862isNegativeimpl = m19862isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM19862isNegativeimpl) {
            sb.append('-');
        }
        long jM19842getAbsoluteValueUwyO8pc = m19842getAbsoluteValueUwyO8pc(j);
        long jM19844getInWholeDaysimpl = m19844getInWholeDaysimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19843getHoursComponentimpl = m19843getHoursComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19851getMinutesComponentimpl = m19851getMinutesComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19853getSecondsComponentimpl = m19853getSecondsComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int iM19852getNanosecondsComponentimpl = m19852getNanosecondsComponentimpl(jM19842getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM19844getInWholeDaysimpl != 0;
        boolean z2 = iM19843getHoursComponentimpl != 0;
        boolean z3 = iM19851getMinutesComponentimpl != 0;
        boolean z4 = (iM19853getSecondsComponentimpl == 0 && iM19852getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM19844getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM19843getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM19851getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM19853getSecondsComponentimpl != 0 || z || z2 || z3) {
                m19833appendFractionalimpl(j, sb, iM19853getSecondsComponentimpl, iM19852getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM19852getNanosecondsComponentimpl >= 1000000) {
                m19833appendFractionalimpl(j, sb, iM19852getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, iM19852getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (iM19852getNanosecondsComponentimpl >= 1000) {
                m19833appendFractionalimpl(j, sb, iM19852getNanosecondsComponentimpl / NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, iM19852getNanosecondsComponentimpl % NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, 3, "us", false);
            } else {
                sb.append(iM19852getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM19862isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m19878toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m19877toStringimpl(j, durationUnit, i);
    }

    /* renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m19879truncateToUwyO8pc$kotlin_stdlib(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnitM19854getStorageUnitimpl = m19854getStorageUnitimpl(j);
        if (unit.compareTo(durationUnitM19854getStorageUnitimpl) <= 0 || m19861isInfiniteimpl(j)) {
            return j;
        }
        return DurationKt.toDuration(m19856getValueimpl(j) - (m19856getValueimpl(j) % DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, unit, durationUnitM19854getStorageUnitimpl)), durationUnitM19854getStorageUnitimpl);
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m19880unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m19856getValueimpl(j), ((int) j) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m19881compareToLRDsOJo(duration.getRawValue());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m19881compareToLRDsOJo(long j) {
        return m19835compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: equals */
    public boolean m6868equals(Object other) {
        return m19840equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m19857hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m19876toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m19835compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.m6320compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m19862isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m19870toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo6276invoke(Long.valueOf(m19845getInWholeHoursimpl(j)), Integer.valueOf(m19851getMinutesComponentimpl(j)), Integer.valueOf(m19853getSecondsComponentimpl(j)), Integer.valueOf(m19852getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m19869toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo6219invoke(Long.valueOf(m19848getInWholeMinutesimpl(j)), Integer.valueOf(m19853getSecondsComponentimpl(j)), Integer.valueOf(m19852getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m19868toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.mo2167invoke(Long.valueOf(m19850getInWholeSecondsimpl(j)), Integer.valueOf(m19852getNanosecondsComponentimpl(j)));
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m19838divUwyO8pc(long j, double d) {
        int iRoundToInt = C1237MathKt.roundToInt(d);
        if (iRoundToInt == d && iRoundToInt != 0) {
            return m19839divUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM19854getStorageUnitimpl = m19854getStorageUnitimpl(j);
        return DurationKt.toDuration(m19872toDoubleimpl(j, durationUnitM19854getStorageUnitimpl) / d, durationUnitM19854getStorageUnitimpl);
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m19866timesUwyO8pc(long j, double d) {
        int iRoundToInt = C1237MathKt.roundToInt(d);
        if (iRoundToInt == d) {
            return m19867timesUwyO8pc(j, iRoundToInt);
        }
        DurationUnit durationUnitM19854getStorageUnitimpl = m19854getStorageUnitimpl(j);
        return DurationKt.toDuration(m19872toDoubleimpl(j, durationUnitM19854getStorageUnitimpl) * d, durationUnitM19854getStorageUnitimpl);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m19877toStringimpl(long j, DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i >= 0) {
            double dM19872toDoubleimpl = m19872toDoubleimpl(j, unit);
            if (Double.isInfinite(dM19872toDoubleimpl)) {
                return String.valueOf(dM19872toDoubleimpl);
            }
            return DurationJvmKt.formatToExactDecimals(dM19872toDoubleimpl, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }
}
