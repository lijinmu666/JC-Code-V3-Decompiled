package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p117text.Typography;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u001e\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\nR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m4988d2 = {"Lkotlinx/coroutines/internal/Symbol;", BuildConfig.f24315FLAVOR, "symbol", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;)V", "toString", "unbox", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.internal.Symbol */
/* loaded from: classes.dex */
public final class C1578Symbol {

    @JvmField
    public final String symbol;

    public C1578Symbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return Typography.f5418less + this.symbol + Typography.f5416greater;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: unbox */
    public final <T> T m7449unbox(Object value) {
        if (value == this) {
            return null;
        }
        return value;
    }
}
