package p094kotlin;

import java.io.Serializable;
import org.conscrypt.BuildConfig;
import p094kotlin.p104js.JsImplicitExport;
import p094kotlin.p105jvm.internal.Intrinsics;

@JsImplicitExport(couldBeConvertedToExplicitExport = true)
@Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\u000f\u0010\u000f\u001a\u00028\u0000HÆ\u0083\u0004¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\u00028\u0001HÆ\u0083\u0004¢\u0006\u0002\u0010\nJ/\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0081\u0004¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0017\u0010\u0005\u001a\u00028\u0000X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00028\u0001X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0019"}, m4988d2 = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "toString", BuildConfig.f24315FLAVOR, "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/js/JsImplicitExport;", "couldBeConvertedToExplicitExport"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: kotlin.Pair */
/* loaded from: classes.dex */
public final /* data */ class C1122Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public C1122Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C1122Pair copy$default(C1122Pair c1122Pair, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c1122Pair.first;
        }
        if ((i & 2) != 0) {
            obj2 = c1122Pair.second;
        }
        return c1122Pair.m5038copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    /* renamed from: copy */
    public final C1122Pair<A, B> m5038copy(A first, B second) {
        return new C1122Pair<>(first, second);
    }

    /* renamed from: equals */
    public boolean m5039equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C1122Pair)) {
            return false;
        }
        C1122Pair c1122Pair = (C1122Pair) other;
        return Intrinsics.areEqual(this.first, c1122Pair.first) && Intrinsics.areEqual(this.second, c1122Pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b = this.second;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
