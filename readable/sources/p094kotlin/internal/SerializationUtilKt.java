package p094kotlin.internal;

import java.io.InvalidObjectException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0081\u0088\u0004b\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0081\u0088\u0004b\u0002\b\u0002ø\u0001\u0000*\f\b\u0000\u0010\u0007\"\u00020\b2\u00020\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, m4988d2 = {"throwReadObjectNotSupported", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "wrapAsDeserializationException", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function0;", "ReadObjectParameterType", "Ljava/io/ObjectInputStream;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SerializationUtilKt {
    @InlineOnly
    private static final Void throwReadObjectNotSupported() throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @InlineOnly
    private static final void wrapAsDeserializationException(Function0<C1133Unit> action) throws Throwable {
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            action.mo4323invoke();
        } catch (Throwable th) {
            Throwable thInitCause = new InvalidObjectException(th.getMessage()).initCause(th);
            Intrinsics.checkNotNullExpressionValue(thInitCause, "initCause(...)");
            throw thInitCause;
        }
    }
}
