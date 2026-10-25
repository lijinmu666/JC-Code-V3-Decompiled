package p094kotlin.p105jvm.functions;

import org.conscrypt.BuildConfig;
import p094kotlin.Function;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.FunctionBase;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J'\u0010\u0004\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H¦\u0082\u0004¢\u0006\u0002\u0010\bR\u0013\u0010\t\u001a\u00020\nX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¨\u0006\r"}, m4988d2 = {"Lkotlin/jvm/functions/FunctionN;", "R", "Lkotlin/Function;", "Lkotlin/jvm/internal/FunctionBase;", "invoke", "args", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Ljava/lang/Object;", "arity", BuildConfig.f24315FLAVOR, "getArity", "()I", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface FunctionN<R> extends Function<R>, FunctionBase<R> {
    @Override // p094kotlin.p105jvm.internal.FunctionBase
    int getArity();

    /* renamed from: invoke */
    R m6282invoke(Object... args);
}
