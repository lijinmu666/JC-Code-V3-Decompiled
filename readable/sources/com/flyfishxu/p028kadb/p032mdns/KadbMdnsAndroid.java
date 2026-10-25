package com.flyfishxu.p028kadb.p032mdns;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.p003net.p004nsd.NsdManager$ServiceInfoCallback;
import com.flyfishxu.p028kadb.p032mdns.KadbMdnsAndroid;
import com.flyfishxu.p028kadb.p032mdns.internal.AndroidDiscoveryListener;
import com.flyfishxu.p028kadb.p032mdns.internal.AndroidResolveListener;
import com.flyfishxu.p028kadb.p032mdns.internal.AndroidServiceInfoCallback;
import com.flyfishxu.p028kadb.p032mdns.internal.MdnsRegistry;
import com.flyfishxu.p028kadb.p032mdns.internal.MdnsServiceKey;
import com.flyfishxu.p028kadb.p032mdns.internal.NsdServiceInfoMapperKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.collections.C1155MapsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.p125flow.StateFlow;
import p131o.AbstractC1861E0;

@Metadata(m4987d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0019H\u0002J\u0018\u0010+\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0018\u0010.\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00063"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/KadbMdnsAndroid;", "Lcom/flyfishxu/kadb/mdns/KadbMdns;", "context", "Landroid/content/Context;", "config", "Lcom/flyfishxu/kadb/mdns/MdnsConfig;", "<init>", "(Landroid/content/Context;Lcom/flyfishxu/kadb/mdns/MdnsConfig;)V", "applicationContext", "kotlin.jvm.PlatformType", "nsdManager", "Landroid/net/nsd/NsdManager;", "registry", "Lcom/flyfishxu/kadb/mdns/internal/MdnsRegistry;", "callbacks", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/mdns/internal/MdnsServiceKey;", "Landroid/net/nsd/NsdManager$ServiceInfoCallback;", "lock", BuildConfig.f24315FLAVOR, "started", BuildConfig.f24315FLAVOR, "closed", "discoveryListeners", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "Lcom/flyfishxu/kadb/mdns/internal/AndroidDiscoveryListener;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/flyfishxu/kadb/mdns/MdnsDiscoveryState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "start", BuildConfig.f24315FLAVOR, "stop", "close", "onStatusChanged", "status", "Lcom/flyfishxu/kadb/mdns/MdnsStatus;", "onServiceFound", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "serviceType", "onServiceLost", "upsertService", "fallbackServiceType", "registerServiceInfoCallback", "removeServiceByKey", "key", "unregisterServiceInfoCallback", "clearServiceInfoCallbacks", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nKadbMdnsAndroid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KadbMdnsAndroid.kt\ncom/flyfishxu/kadb/mdns/KadbMdnsAndroid\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,226:1\n1453#2,2:227\n1468#2,4:229\n2068#2,2:233\n2068#2,2:235\n2068#2,2:238\n1#3:237\n*S KotlinDebug\n*F\n+ 1 KadbMdnsAndroid.kt\ncom/flyfishxu/kadb/mdns/KadbMdnsAndroid\n*L\n46#1:227,2\n46#1:229,4\n71#1:233,2\n91#1:235,2\n219#1:238,2\n*E\n"})
/* loaded from: classes.dex */
public final class KadbMdnsAndroid implements KadbMdns {
    private final Context applicationContext;
    private final Map<MdnsServiceKey, NsdManager$ServiceInfoCallback> callbacks;
    private boolean closed;
    private final MdnsConfig config;
    private final Map<MdnsServiceType, AndroidDiscoveryListener> discoveryListeners;
    private final Object lock;
    private final NsdManager nsdManager;
    private final MdnsRegistry registry;
    private boolean started;
    private final StateFlow<MdnsDiscoveryState> state;

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MdnsStatus.m2252values().length];
            try {
                iArr[MdnsStatus.STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MdnsStatus.f2082STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MdnsStatus.f2083STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MdnsStatus.f2081FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KadbMdnsAndroid(Context context, MdnsConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        this.nsdManager = (NsdManager) applicationContext.getSystemService(NsdManager.class);
        this.registry = new MdnsRegistry(config);
        this.callbacks = new LinkedHashMap();
        this.lock = new Object();
        Set<MdnsServiceType> serviceTypes = config.getServiceTypes();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(C1155MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(serviceTypes, 10)), 16));
        for (Object obj : serviceTypes) {
            linkedHashMap.put(obj, new AndroidDiscoveryListener((MdnsServiceType) obj, new KadbMdnsAndroid$discoveryListeners$1$1(this), new KadbMdnsAndroid$discoveryListeners$1$2(this), new KadbMdnsAndroid$discoveryListeners$1$3(this)));
        }
        this.discoveryListeners = linkedHashMap;
        this.state = this.registry.getState();
    }

    private final void clearServiceInfoCallbacks() {
        List list;
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        synchronized (this.lock) {
            list = CollectionsKt.m5899toList(this.callbacks.values());
            this.callbacks.clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NsdManager$ServiceInfoCallback nsdManager$ServiceInfoCallbackM8101mjFkc = AbstractC1861E0.m8101mjFkc(it.next());
            try {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                this.nsdManager.unregisterServiceInfoCallback(nsdManager$ServiceInfoCallbackM8101mjFkc);
                C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
            } catch (Throwable th) {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onServiceFound(NsdServiceInfo serviceInfo, final MdnsServiceType serviceType) {
        if (Build.VERSION.SDK_INT >= 34) {
            registerServiceInfoCallback(serviceInfo, serviceType);
        } else {
            this.nsdManager.resolveService(serviceInfo, new AndroidResolveListener(new Function1() { // from class: o.H0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return KadbMdnsAndroid.onServiceFound$lambda$0(this.f8473mjFkc, serviceType, (NsdServiceInfo) obj);
                }
            }, new Function1() { // from class: o.I0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return KadbMdnsAndroid.onServiceFound$lambda$1(this.f8665mjFkc, ((Integer) obj).intValue());
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit onServiceFound$lambda$0(KadbMdnsAndroid kadbMdnsAndroid, MdnsServiceType mdnsServiceType, NsdServiceInfo resolvedInfo) {
        Intrinsics.checkNotNullParameter(resolvedInfo, "resolvedInfo");
        kadbMdnsAndroid.upsertService(resolvedInfo, mdnsServiceType);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit onServiceFound$lambda$1(KadbMdnsAndroid kadbMdnsAndroid, int i) {
        kadbMdnsAndroid.onStatusChanged(MdnsStatus.f2081FAILED);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onServiceLost(NsdServiceInfo serviceInfo, MdnsServiceType serviceType) {
        MdnsServiceKey mdnsServiceKey = NsdServiceInfoMapperKt.toMdnsServiceKey(serviceInfo, serviceType);
        if (mdnsServiceKey == null) {
            return;
        }
        unregisterServiceInfoCallback(mdnsServiceKey);
        synchronized (this.lock) {
            try {
                if (this.started) {
                    this.registry.m2255remove(mdnsServiceKey.m2262getName(), mdnsServiceKey.getServiceType());
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStatusChanged(MdnsStatus status) {
        synchronized (this.lock) {
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            this.registry.m2254failed();
                        } else if (!this.started) {
                            this.registry.m2257stopped();
                        }
                    } else if (this.started) {
                        this.registry.m2256started();
                    }
                } else if (this.started) {
                    this.registry.starting();
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void registerServiceInfoCallback(NsdServiceInfo serviceInfo, final MdnsServiceType serviceType) {
        final MdnsServiceKey mdnsServiceKey;
        boolean z;
        Object objM18546constructorimpl;
        if (Build.VERSION.SDK_INT >= 34 && (mdnsServiceKey = NsdServiceInfoMapperKt.toMdnsServiceKey(serviceInfo, serviceType)) != null) {
            AndroidServiceInfoCallback androidServiceInfoCallback = new AndroidServiceInfoCallback(new Function1() { // from class: o.J0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return KadbMdnsAndroid.registerServiceInfoCallback$lambda$0(this.f8825mjFkc, ((Integer) obj).intValue());
                }
            }, new Function1() { // from class: o.K0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return KadbMdnsAndroid.registerServiceInfoCallback$lambda$1(this.f9105mjFkc, serviceType, (NsdServiceInfo) obj);
                }
            }, new Function0() { // from class: o.L0
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Object mo4323invoke() {
                    return KadbMdnsAndroid.registerServiceInfoCallback$lambda$2(this.f9295mjFkc, mdnsServiceKey);
                }
            }, new Function0() { // from class: o.M0
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Object mo4323invoke() {
                    return KadbMdnsAndroid.registerServiceInfoCallback$lambda$3(this.f9498mjFkc, mdnsServiceKey);
                }
            });
            synchronized (this.lock) {
                if (!this.started || this.closed || this.callbacks.containsKey(mdnsServiceKey)) {
                    z = false;
                } else {
                    this.callbacks.put(mdnsServiceKey, androidServiceInfoCallback);
                    z = true;
                }
            }
            if (z) {
                try {
                    C1124Result.Companion companion = C1124Result.INSTANCE;
                    this.nsdManager.registerServiceInfoCallback(serviceInfo, this.applicationContext.getMainExecutor(), AbstractC1861E0.m8101mjFkc(androidServiceInfoCallback));
                    objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                } catch (Throwable th) {
                    C1124Result.Companion companion2 = C1124Result.INSTANCE;
                    objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
                }
                if (C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl) != null) {
                    synchronized (this.lock) {
                        this.callbacks.remove(mdnsServiceKey, androidServiceInfoCallback);
                    }
                    onStatusChanged(MdnsStatus.f2081FAILED);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit registerServiceInfoCallback$lambda$0(KadbMdnsAndroid kadbMdnsAndroid, int i) {
        kadbMdnsAndroid.onStatusChanged(MdnsStatus.f2081FAILED);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit registerServiceInfoCallback$lambda$1(KadbMdnsAndroid kadbMdnsAndroid, MdnsServiceType mdnsServiceType, NsdServiceInfo updatedInfo) {
        Intrinsics.checkNotNullParameter(updatedInfo, "updatedInfo");
        kadbMdnsAndroid.upsertService(updatedInfo, mdnsServiceType);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit registerServiceInfoCallback$lambda$2(KadbMdnsAndroid kadbMdnsAndroid, MdnsServiceKey mdnsServiceKey) {
        kadbMdnsAndroid.removeServiceByKey(mdnsServiceKey);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit registerServiceInfoCallback$lambda$3(KadbMdnsAndroid kadbMdnsAndroid, MdnsServiceKey mdnsServiceKey) {
        synchronized (kadbMdnsAndroid.lock) {
            kadbMdnsAndroid.callbacks.remove(mdnsServiceKey);
        }
        return C1133Unit.INSTANCE;
    }

    private final void removeServiceByKey(MdnsServiceKey key) {
        synchronized (this.lock) {
            try {
                if (this.started) {
                    this.registry.m2255remove(key.m2262getName(), key.getServiceType());
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        unregisterServiceInfoCallback(key);
    }

    private final void unregisterServiceInfoCallback(MdnsServiceKey key) {
        NsdManager$ServiceInfoCallback nsdManager$ServiceInfoCallbackM8101mjFkc;
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        synchronized (this.lock) {
            nsdManager$ServiceInfoCallbackM8101mjFkc = AbstractC1861E0.m8101mjFkc(this.callbacks.remove(key));
        }
        if (nsdManager$ServiceInfoCallbackM8101mjFkc == null) {
            return;
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            this.nsdManager.unregisterServiceInfoCallback(nsdManager$ServiceInfoCallbackM8101mjFkc);
            C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void upsertService(NsdServiceInfo serviceInfo, MdnsServiceType fallbackServiceType) {
        MdnsEndpoint mdnsEndpoint = NsdServiceInfoMapperKt.toMdnsEndpoint(serviceInfo, this.config, fallbackServiceType);
        if (mdnsEndpoint == null) {
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.started) {
                    this.registry.m2258upsert(mdnsEndpoint);
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.flyfishxu.p028kadb.p032mdns.KadbMdns, java.lang.AutoCloseable
    public void close() {
        mo2229stop();
        synchronized (this.lock) {
            this.closed = true;
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
    }

    @Override // com.flyfishxu.p028kadb.p032mdns.KadbMdns
    public StateFlow<MdnsDiscoveryState> getState() {
        return this.state;
    }

    @Override // com.flyfishxu.p028kadb.p032mdns.KadbMdns
    /* renamed from: start */
    public void mo2228start() {
        Object objM18546constructorimpl;
        synchronized (this.lock) {
            if (!this.closed && !this.started) {
                this.started = true;
                this.callbacks.clear();
                this.registry.starting();
                List<C1122Pair> list = C1155MapsKt.m5985toList(this.discoveryListeners);
                if (list.isEmpty()) {
                    onStatusChanged(MdnsStatus.f2082STARTED);
                    return;
                }
                for (C1122Pair c1122Pair : list) {
                    MdnsServiceType mdnsServiceType = (MdnsServiceType) c1122Pair.component1();
                    AndroidDiscoveryListener androidDiscoveryListener = (AndroidDiscoveryListener) c1122Pair.component2();
                    try {
                        C1124Result.Companion companion = C1124Result.INSTANCE;
                        this.nsdManager.discoverServices(mdnsServiceType.getDnsType(), 1, androidDiscoveryListener);
                        objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                    } catch (Throwable th) {
                        C1124Result.Companion companion2 = C1124Result.INSTANCE;
                        objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
                    }
                    if (C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl) != null) {
                        onStatusChanged(MdnsStatus.f2081FAILED);
                    }
                }
            }
        }
    }

    @Override // com.flyfishxu.p028kadb.p032mdns.KadbMdns
    /* renamed from: stop */
    public void mo2229stop() {
        synchronized (this.lock) {
            if (this.started) {
                this.started = false;
                for (AndroidDiscoveryListener androidDiscoveryListener : CollectionsKt.m5899toList(this.discoveryListeners.values())) {
                    try {
                        C1124Result.Companion companion = C1124Result.INSTANCE;
                        this.nsdManager.stopServiceDiscovery(androidDiscoveryListener);
                        C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                    } catch (Throwable th) {
                        C1124Result.Companion companion2 = C1124Result.INSTANCE;
                        C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
                    }
                }
                clearServiceInfoCallbacks();
                synchronized (this.lock) {
                    this.callbacks.clear();
                    this.registry.m2257stopped();
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                }
            }
        }
    }

    public /* synthetic */ KadbMdnsAndroid(Context context, MdnsConfig mdnsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new MdnsConfig(null, false, 3, null) : mdnsConfig);
    }
}
