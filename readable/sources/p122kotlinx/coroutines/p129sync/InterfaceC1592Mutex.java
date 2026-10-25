package p122kotlinx.coroutines.p129sync;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p122kotlinx.coroutines.p127selects.SelectClause2;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001H&J\u0014\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R(\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/sync/Mutex;", BuildConfig.f24315FLAVOR, "isLocked", BuildConfig.f24315FLAVOR, "()Z", "tryLock", "owner", "lock", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "unlock", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.sync.Mutex */
/* loaded from: classes.dex */
public interface InterfaceC1592Mutex {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.sync.Mutex$DefaultImpls */
    public static final class DefaultImpls {
        @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void getOnLock$annotations() {
        }
    }

    static /* synthetic */ Object lock$default(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return interfaceC1592Mutex.mo7492lock(obj, continuation);
    }

    static /* synthetic */ boolean tryLock$default(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return interfaceC1592Mutex.mo7493tryLock(obj);
    }

    static /* synthetic */ void unlock$default(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        interfaceC1592Mutex.mo7494unlock(obj);
    }

    SelectClause2<Object, InterfaceC1592Mutex> getOnLock();

    boolean holdsLock(Object owner);

    boolean isLocked();

    /* renamed from: lock */
    Object mo7492lock(Object obj, Continuation<? super C1133Unit> continuation);

    /* renamed from: tryLock */
    boolean mo7493tryLock(Object owner);

    /* renamed from: unlock */
    void mo7494unlock(Object owner);
}
