package p122kotlinx.coroutines;

import java.lang.Throwable;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p122kotlinx.coroutines.CopyableThrowable;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/CopyableThrowable;", "T", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "createCopy", "()Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    T createCopy();
}
