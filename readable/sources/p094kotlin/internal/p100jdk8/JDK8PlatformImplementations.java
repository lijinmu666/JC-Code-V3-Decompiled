package p094kotlin.internal.p100jdk8;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.p099jdk7.JDK7PlatformImplementations;
import p094kotlin.internal.p100jdk8.JDK8PlatformImplementations;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p110random.AbstractC1241Random;
import p094kotlin.p110random.p111jdk8.PlatformThreadLocalRandom;
import p094kotlin.p112ranges.IntRange;
import p094kotlin.p117text.MatchGroup;
import p094kotlin.p119time.C1324Instant;
import p094kotlin.p119time.InterfaceC1323Clock;
import p094kotlin.p119time.p120jdk8.InstantConversionsJDK8Kt;

@Metadata(m4987d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001fB\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082\u0080\u0004J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004JA\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0014\u001a\u0002H\u000fH\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015JN\u0010\u0016\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f\"\n\b\u0002\u0010\u0017*\u0004\b\u0002H\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00182\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0019\u001a\u0002H\u0017H\u0096\u0080\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004\u0082\u0002\u0004\n\u0002\b9¨\u0006 "}, m4988d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", BuildConfig.f24315FLAVOR, "version", BuildConfig.f24315FLAVOR, "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", BuildConfig.f24315FLAVOR, "getOrDefault", "V", "K", "map", BuildConfig.f24315FLAVOR, "key", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent", "NewV", "Ljava/util/concurrent/ConcurrentMap;", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0007¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, m4988d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "sdkVersion", BuildConfig.f24315FLAVOR, "Ljava/lang/Integer;", "Lkotlin/jvm/JvmField;", "kotlin-stdlib-jdk8"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
    public static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = new ReflectSdkVersion();

        @JvmField
        public static final Integer sdkVersion;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            sdkVersion = num;
        }

        private ReflectSdkVersion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object computeIfAbsent$lambda$0(Object obj, Object obj2) {
        return obj;
    }

    private final boolean sdkIsNullOrAtLeast(int version) {
        Integer num = ReflectSdkVersion.sdkVersion;
        return num == null || num.intValue() >= version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.internal.PlatformImplementations
    public <K, V, NewV extends V> V computeIfAbsent(ConcurrentMap<K, V> map, K key, final NewV newValue) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (sdkIsNullOrAtLeast(24)) {
            final Function1 function1 = new Function1() { // from class: o.e0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return JDK8PlatformImplementations.computeIfAbsent$lambda$0(newValue, obj);
                }
            };
            return map.computeIfAbsent(key, new Function() { // from class: o.f0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return function1.mo2237invoke(obj);
                }
            });
        }
        V vPutIfAbsent = map.putIfAbsent(key, newValue);
        return vPutIfAbsent == null ? newValue : vPutIfAbsent;
    }

    @Override // p094kotlin.internal.PlatformImplementations
    public AbstractC1241Random defaultPlatformRandom() {
        return sdkIsNullOrAtLeast(34) ? new PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }

    @Override // p094kotlin.internal.PlatformImplementations
    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        IntRange intRange = new IntRange(matcher.start(name), matcher.end(name) - 1);
        if (intRange.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return new MatchGroup(strGroup, intRange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.internal.PlatformImplementations
    public <K, V> V getOrDefault(Map<K, ? extends V> map, K key, V v) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (sdkIsNullOrAtLeast(24)) {
            return map.getOrDefault(key, v);
        }
        V v2 = map.get(key);
        if (v2 != null) {
            return v2;
        }
        if (map.containsKey(key)) {
            return null;
        }
        return v;
    }

    @Override // p094kotlin.internal.PlatformImplementations
    public InterfaceC1323Clock getSystemClock() {
        return sdkIsNullOrAtLeast(26) ? new InterfaceC1323Clock() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations.getSystemClock.1
            @Override // p094kotlin.p119time.InterfaceC1323Clock
            /* renamed from: now */
            public C1324Instant mo6153now() {
                Instant instantNow = Instant.now();
                Intrinsics.checkNotNullExpressionValue(instantNow, "now(...)");
                return InstantConversionsJDK8Kt.toKotlinInstant(instantNow);
            }
        } : new InterfaceC1323Clock() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations.getSystemClock.2
            @Override // p094kotlin.p119time.InterfaceC1323Clock
            /* renamed from: now */
            public C1324Instant mo6153now() {
                return C1324Instant.INSTANCE.fromEpochMilliseconds(System.currentTimeMillis());
            }
        };
    }
}
