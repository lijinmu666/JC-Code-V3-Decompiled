package p094kotlin.p098enums;

import org.conscrypt.BuildConfig;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.NotImplementedError;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.internal.UsedFromCompilerGeneratedCode;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004b\u0010\b\u0004\u0012\f\b\u0005\u0012\b\b\fJ\u0004\b\t0\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r0\fH\u0081\u0080\u0004b\u0002\b\u000eb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0081\u0080\u0004b\u0002\b\u000eb\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000fb\u0002\b\u0012¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, m4988d2 = {"enumEntries", "Lkotlin/enums/EnumEntries;", "T", BuildConfig.f24315FLAVOR, "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/SinceKotlin;", "version", "2.0", "E", "entriesProvider", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "Lkotlin/PublishedApi;", "1.8", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "Lkotlin/internal/UsedFromCompilerGeneratedCode;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class EnumEntriesKt {
    @SinceKotlin(m5061version = "2.0")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Enum<T>> EnumEntries<T> enumEntries() {
        throw new NotImplementedError(null, 1, null);
    }

    @SinceKotlin(m5061version = "1.8")
    @PublishedApi
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(Function0<E[]> entriesProvider) {
        Intrinsics.checkNotNullParameter(entriesProvider, "entriesProvider");
        return new EnumEntriesList(entriesProvider.mo4323invoke());
    }

    @SinceKotlin(m5061version = "1.8")
    @PublishedApi
    @UsedFromCompilerGeneratedCode
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
