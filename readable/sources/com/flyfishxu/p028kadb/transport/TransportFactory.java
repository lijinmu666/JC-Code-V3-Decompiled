package com.flyfishxu.p028kadb.transport;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\f¨\u0006\r"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/TransportFactory;", BuildConfig.f24315FLAVOR, "<init>", "()V", "connect", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "host", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "connectTimeoutMs", BuildConfig.f24315FLAVOR, "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TransportFactory {
    public static final TransportFactory INSTANCE = new TransportFactory();

    private TransportFactory() {
    }

    /* renamed from: connect */
    public final Object m2354connect(String str, int i, long j, Continuation<? super TransportChannel> continuation) {
        return PlainBlockingChannel.INSTANCE.m2352connect(str, i, j);
    }
}
