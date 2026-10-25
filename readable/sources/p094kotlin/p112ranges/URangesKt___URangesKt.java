package p094kotlin.p112ranges;

import java.util.NoSuchElementException;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.C1128UInt;
import p094kotlin.C1130ULong;
import p094kotlin.C1132UShort;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p110random.AbstractC1241Random;
import p094kotlin.p110random.URandomKt;
import p094kotlin.p112ranges.UIntProgression;
import p094kotlin.p112ranges.ULongProgression;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u000f\u001a%\u0010\r\u001a\u00020\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u0013\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0015\u001a)\u0010\r\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001b\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001c\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b!\u0010\"\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b#\u0010$\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0007H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b%\u0010&\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b(\u0010)\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b*\u0010+\u001a+\u0010,\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b.\u0010/\u001a+\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b0\u00101\u001a+\u0010,\u001a\u00020\b*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b2\u00103\u001a+\u0010,\u001a\u00020\u0002*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b4\u00105\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a\u001c\u00106\u001a\u00020\b*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u000208H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\b*\u00020\b2\u0006\u00107\u001a\u000209H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a+\u0010:\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b;\u0010<\u001a+\u0010:\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b=\u0010>\u001a+\u0010:\u001a\u00020\u0012*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b?\u0010@\u001a+\u0010:\u001a\u00020\u000e*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bA\u0010B\u001a+\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bE\u0010F\u001a+\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bG\u0010H\u001a+\u0010C\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bI\u0010J\u001a+\u0010C\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bK\u0010L\u001a+\u0010M\u001a\u00020\u0001*\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bO\u0010F\u001a+\u0010M\u001a\u00020\u0007*\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bP\u0010H\u001a+\u0010M\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bQ\u0010J\u001a+\u0010M\u001a\u00020'*\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bR\u0010L\u001a3\u0010S\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bT\u0010U\u001a3\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bV\u0010W\u001a3\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bX\u0010Y\u001a3\u0010S\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bZ\u0010[\u001a1\u0010S\u001a\u00020\u0001*\u00020\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b^\u0010_\u001a1\u0010S\u001a\u00020\u0007*\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b`\u0010a¨\u0006b"}, m4988d2 = {"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/SinceKotlin;", "version", "1.7", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "1.5", "Lkotlin/internal/InlineOnly;", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", BuildConfig.f24315FLAVOR, "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/ranges/URangesKt")
/* loaded from: classes.dex */
public class URangesKt___URangesKt {
    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m19762coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.m6319compare(s & 65535, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m19763coerceAtLeastJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) < 0 ? i2 : i;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m19764coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.m6319compare(b & C1126UByte.MAX_VALUE, b2 & C1126UByte.MAX_VALUE) < 0 ? b2 : b;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m19765coerceAtLeasteb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) < 0 ? j2 : j;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m19766coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.m6319compare(s & 65535, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m19767coerceAtMostJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) > 0 ? i2 : i;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m19768coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.m6319compare(b & C1126UByte.MAX_VALUE, b2 & C1126UByte.MAX_VALUE) > 0 ? b2 : b;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m19769coerceAtMosteb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) > 0 ? j2 : j;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m19770coerceInJPwROB0(long j, ClosedRange<C1130ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((C1130ULong) RangesKt___RangesKt.coerceIn(C1130ULong.m18714boximpl(j), (ClosedFloatingPointRange<C1130ULong>) range)).getData();
        }
        if (!range.mo6445isEmpty()) {
            return Long.compareUnsigned(j, ((C1130ULong) range.getStart()).getData()) < 0 ? ((C1130ULong) range.getStart()).getData() : Long.compareUnsigned(j, ((C1130ULong) range.getEndInclusive()).getData()) > 0 ? ((C1130ULong) range.getEndInclusive()).getData() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m19771coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & 65535;
        int i2 = s3 & 65535;
        if (Intrinsics.m6319compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.m6319compare(i3, i) < 0 ? s2 : Intrinsics.m6319compare(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) C1132UShort.m18871toStringimpl(s3)) + " is less than minimum " + ((Object) C1132UShort.m18871toStringimpl(s2)) + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m19772coerceInWZ9TVnA(int i, int i2, int i3) {
        if (Integer.compareUnsigned(i2, i3) <= 0) {
            return Integer.compareUnsigned(i, i2) < 0 ? i2 : Integer.compareUnsigned(i, i3) > 0 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) C1128UInt.m18687toStringimpl(i3)) + " is less than minimum " + ((Object) C1128UInt.m18687toStringimpl(i2)) + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m19773coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & C1126UByte.MAX_VALUE;
        int i2 = b3 & C1126UByte.MAX_VALUE;
        if (Intrinsics.m6319compare(i, i2) <= 0) {
            int i3 = b & C1126UByte.MAX_VALUE;
            return Intrinsics.m6319compare(i3, i) < 0 ? b2 : Intrinsics.m6319compare(i3, i2) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) C1126UByte.m18608toStringimpl(b3)) + " is less than minimum " + ((Object) C1126UByte.m18608toStringimpl(b2)) + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m19774coerceInsambcqE(long j, long j2, long j3) {
        if (Long.compareUnsigned(j2, j3) <= 0) {
            return Long.compareUnsigned(j, j2) < 0 ? j2 : Long.compareUnsigned(j, j3) > 0 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) C1130ULong.m18766toStringimpl(j3)) + " is less than minimum " + ((Object) C1130ULong.m18766toStringimpl(j2)) + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m19775coerceInwuiCnnA(int i, ClosedRange<C1128UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((C1128UInt) RangesKt___RangesKt.coerceIn(C1128UInt.m18635boximpl(i), (ClosedFloatingPointRange<C1128UInt>) range)).getData();
        }
        if (!range.mo6445isEmpty()) {
            return Integer.compareUnsigned(i, ((C1128UInt) range.getStart()).getData()) < 0 ? ((C1128UInt) range.getStart()).getData() : Integer.compareUnsigned(i, ((C1128UInt) range.getEndInclusive()).getData()) > 0 ? ((C1128UInt) range.getEndInclusive()).getData() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m19776contains68kG9v0(UIntRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m19749containsWZ4Q5Ns(C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m19777containsGYNo2lE(ULongRange contains, C1130ULong c1130ULong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return c1130ULong != null && contains.m19758containsVKZWuLQ(c1130ULong.getData());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m19778containsGab390E(ULongRange contains, int i) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m19758containsVKZWuLQ(C1130ULong.m18720constructorimpl(i & BodyPartID.bodyIdMax));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m19779containsULbyJY(ULongRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m19758containsVKZWuLQ(C1130ULong.m18720constructorimpl(b & 255));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m19780containsZsK3CEQ(UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m19749containsWZ4Q5Ns(C1128UInt.m18641constructorimpl(s & 65535));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m19781containsbiwQdVI(UIntRange contains, C1128UInt c1128UInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return c1128UInt != null && contains.m19749containsWZ4Q5Ns(c1128UInt.getData());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m19782containsfz5IDCE(UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return C1130ULong.m18720constructorimpl(j >>> 32) == 0 && contains.m19749containsWZ4Q5Ns(C1128UInt.m18641constructorimpl((int) j));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m19783containsuhHAxoY(ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m19758containsVKZWuLQ(C1130ULong.m18720constructorimpl(s & 65535));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m19784downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m19746fromClosedRangeNkh28Cs(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(s2 & 65535), -1);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m19785downToJ1ME1BU(int i, int i2) {
        return UIntProgression.INSTANCE.m19746fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m19786downToKr8caGY(byte b, byte b2) {
        return UIntProgression.INSTANCE.m19746fromClosedRangeNkh28Cs(C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE), C1128UInt.m18641constructorimpl(b2 & C1126UByte.MAX_VALUE), -1);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m19787downToeb3DHEI(long j, long j2) {
        return ULongProgression.INSTANCE.m19755fromClosedRange7ftBX0g(j, j2, -1L);
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: first */
    public static final int m6520first(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.mo6445isEmpty()) {
            return uIntProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.7")
    public static final C1128UInt firstOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.mo6445isEmpty()) {
            return null;
        }
        return C1128UInt.m18635boximpl(uIntProgression.getFirst());
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: last */
    public static final int m6522last(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.mo6445isEmpty()) {
            return uIntProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.7")
    public static final C1128UInt lastOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.mo6445isEmpty()) {
            return null;
        }
        return C1128UInt.m18635boximpl(uIntProgression.getLast());
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: random */
    private static final int m6524random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return m6525random(uIntRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final C1128UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return randomOrNull(uIntRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.INSTANCE.m19746fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: step */
    public static final UIntProgression m6528step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m19746fromClosedRangeNkh28Cs(first, last, i);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m19788until5PvTz6A(short s, short s2) {
        return Intrinsics.m6319compare(s2 & 65535, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(C1128UInt.m18641constructorimpl(s & 65535), C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static UIntRange m19789untilJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i2, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(i, C1128UInt.m18641constructorimpl(i2 - 1), null);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m19790untilKr8caGY(byte b, byte b2) {
        return Intrinsics.m6319compare(b2 & C1126UByte.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE), C1128UInt.m18641constructorimpl(C1128UInt.m18641constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static ULongRange m19791untileb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j2, 0L) <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange(j, C1130ULong.m18720constructorimpl(j2 - C1130ULong.m18720constructorimpl(1 & BodyPartID.bodyIdMax)), null);
    }

    @SinceKotlin(m5061version = "1.7")
    public static final C1130ULong firstOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.mo6445isEmpty()) {
            return null;
        }
        return C1130ULong.m18714boximpl(uLongProgression.getFirst());
    }

    @SinceKotlin(m5061version = "1.7")
    public static final C1130ULong lastOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.mo6445isEmpty()) {
            return null;
        }
        return C1130ULong.m18714boximpl(uLongProgression.getLast());
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: random */
    private static final long m6526random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return m6527random(uLongRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    private static final C1130ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return randomOrNull(uLongRange, AbstractC1241Random.INSTANCE);
    }

    @SinceKotlin(m5061version = "1.5")
    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.INSTANCE.m19755fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: random */
    public static final int m6525random(UIntRange uIntRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1128UInt randomOrNull(UIntRange uIntRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.mo6445isEmpty()) {
            return null;
        }
        return C1128UInt.m18635boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: step */
    public static final ULongProgression m6529step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m19755fromClosedRange7ftBX0g(first, last, j);
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: first */
    public static final long m6521first(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.mo6445isEmpty()) {
            return uLongProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: last */
    public static final long m6523last(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.mo6445isEmpty()) {
            return uLongProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: random */
    public static final long m6527random(ULongRange uLongRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(m5061version = "1.5")
    public static final C1130ULong randomOrNull(ULongRange uLongRange, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.mo6445isEmpty()) {
            return null;
        }
        return C1130ULong.m18714boximpl(URandomKt.nextULong(random, uLongRange));
    }
}
