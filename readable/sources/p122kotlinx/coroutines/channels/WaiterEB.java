package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.JvmField;
import p122kotlinx.coroutines.InterfaceC1348Waiter;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m4988d2 = {"Lkotlinx/coroutines/channels/WaiterEB;", BuildConfig.f24315FLAVOR, "waiter", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/Waiter;)V", "toString", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class WaiterEB {

    @JvmField
    public final InterfaceC1348Waiter waiter;

    public WaiterEB(InterfaceC1348Waiter interfaceC1348Waiter) {
        this.waiter = interfaceC1348Waiter;
    }

    public String toString() {
        return "WaiterEB(" + this.waiter + ')';
    }
}
