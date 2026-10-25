package com.flyfishxu.p028kadb.p032mdns;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p122kotlinx.coroutines.p125flow.StateFlow;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/KadbMdns;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/flyfishxu/kadb/mdns/MdnsDiscoveryState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "start", BuildConfig.f24315FLAVOR, "stop", "close", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KadbMdns extends AutoCloseable {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: close */
        public static void m2230close(KadbMdns kadbMdns) {
            KadbMdns.super.close();
        }
    }

    @Override // java.lang.AutoCloseable
    default void close() {
        mo2229stop();
    }

    StateFlow<MdnsDiscoveryState> getState();

    /* renamed from: start */
    void mo2228start();

    /* renamed from: stop */
    void mo2229stop();
}
