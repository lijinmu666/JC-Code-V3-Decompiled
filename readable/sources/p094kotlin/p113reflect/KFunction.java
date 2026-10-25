package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.Function;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R)\u0010\u0004\u001a\u00020\u00058&X§\u0084\br\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\bR)\u0010\f\u001a\u00020\u00058&X§\u0084\br\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\bR)\u0010\u000e\u001a\u00020\u00058&X§\u0084\br\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\bR)\u0010\u0010\u001a\u00020\u00058&X§\u0084\br\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0010\u0010\bR)\u0010\u0012\u001a\u00020\u00058&X§\u0084\br\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, m4988d2 = {"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "isInline", BuildConfig.f24315FLAVOR, "isInline$annotations", "()V", "()Z", "Lkotlin/SinceKotlin;", "version", "1.1", "isExternal", "isExternal$annotations", "isOperator", "isOperator$annotations", "isInfix", "isInfix$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isExternal$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isInfix$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isInline$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isOperator$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isSuspend$annotations() {
        }
    }

    boolean isExternal();

    /* renamed from: isInfix */
    boolean mo6314isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // p094kotlin.p113reflect.KCallable
    boolean isSuspend();
}
