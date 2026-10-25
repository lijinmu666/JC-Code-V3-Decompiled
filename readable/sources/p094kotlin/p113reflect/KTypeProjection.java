package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\bF\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0083\u0004J\f\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0083\u0004J\"\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0081\u0004J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u0017"}, m4988d2 = {"Lkotlin/reflect/KTypeProjection;", BuildConfig.f24315FLAVOR, "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getVariance", "()Lkotlin/reflect/KVariance;", "getType", "()Lkotlin/reflect/KType;", "toString", BuildConfig.f24315FLAVOR, "component1", "component2", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KTypeProjection {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: star */
    @JvmField
    public static final KTypeProjection f5269star = new KTypeProjection(null, null);
    private final InterfaceC1252KType type;
    private final KVariance variance;

    @Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\u0002\b\u000fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\u0002\b\u000fJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0080\u0004b\u0002\b\u000fR \u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\u0007\u0092\u0002\u0002\b\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0015\u0010\t\u001a\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m4988d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "star", "Lkotlin/reflect/KTypeProjection;", "getStar$annotations", "Lkotlin/PublishedApi;", "Lkotlin/jvm/JvmField;", "STAR", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "invariant", "type", "Lkotlin/reflect/KType;", "Lkotlin/jvm/JvmStatic;", "contravariant", "covariant", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @PublishedApi
        public static /* synthetic */ void getStar$annotations() {
        }

        @JvmStatic
        public final KTypeProjection contravariant(InterfaceC1252KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.f5272IN, type);
        }

        @JvmStatic
        public final KTypeProjection covariant(InterfaceC1252KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.f5273OUT, type);
        }

        /* renamed from: getSTAR */
        public final KTypeProjection m6541getSTAR() {
            return KTypeProjection.f5269star;
        }

        @JvmStatic
        public final KTypeProjection invariant(InterfaceC1252KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }

        private Companion() {
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.m6544values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f5272IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f5273OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeProjection(KVariance kVariance, InterfaceC1252KType interfaceC1252KType) {
        String str;
        this.variance = kVariance;
        this.type = interfaceC1252KType;
        if ((kVariance == null) == (interfaceC1252KType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @JvmStatic
    public static final KTypeProjection contravariant(InterfaceC1252KType interfaceC1252KType) {
        return INSTANCE.contravariant(interfaceC1252KType);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, InterfaceC1252KType interfaceC1252KType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            interfaceC1252KType = kTypeProjection.type;
        }
        return kTypeProjection.m6538copy(kVariance, interfaceC1252KType);
    }

    @JvmStatic
    public static final KTypeProjection covariant(InterfaceC1252KType interfaceC1252KType) {
        return INSTANCE.covariant(interfaceC1252KType);
    }

    @JvmStatic
    public static final KTypeProjection invariant(InterfaceC1252KType interfaceC1252KType) {
        return INSTANCE.invariant(interfaceC1252KType);
    }

    /* renamed from: component1, reason: from getter */
    public final KVariance getVariance() {
        return this.variance;
    }

    /* renamed from: component2, reason: from getter */
    public final InterfaceC1252KType getType() {
        return this.type;
    }

    /* renamed from: copy */
    public final KTypeProjection m6538copy(KVariance variance, InterfaceC1252KType type) {
        return new KTypeProjection(variance, type);
    }

    /* renamed from: equals */
    public boolean m6539equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) other;
        return this.variance == kTypeProjection.variance && Intrinsics.areEqual(this.type, kTypeProjection.type);
    }

    /* renamed from: getType */
    public final InterfaceC1252KType m6540getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        InterfaceC1252KType interfaceC1252KType = this.type;
        return iHashCode + (interfaceC1252KType != null ? interfaceC1252KType.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.variance;
        int i = kVariance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i == -1) {
            return "*";
        }
        if (i == 1) {
            return String.valueOf(this.type);
        }
        if (i == 2) {
            return "in " + this.type;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.type;
    }
}
