package com.flyfishxu.p028kadb.transport;

import java.io.Closeable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u000e\u0010\u0010\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001cÀ\u0006\u0003"}, m4988d2 = {"Lcom/flyfishxu/kadb/transport/TransportChannel;", "Ljava/io/Closeable;", "read", BuildConfig.f24315FLAVOR, "dst", "Ljava/nio/ByteBuffer;", "timeout", BuildConfig.f24315FLAVOR, "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", BuildConfig.f24315FLAVOR, "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "isOpen", BuildConfig.f24315FLAVOR, "()Z", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface TransportChannel extends Closeable {
    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();

    /* renamed from: isOpen */
    boolean mo2349isOpen();

    /* renamed from: read */
    Object mo2350read(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation);

    Object readExactly(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation);

    Object shutdownInput(Continuation<? super C1133Unit> continuation);

    Object shutdownOutput(Continuation<? super C1133Unit> continuation);

    /* renamed from: write */
    Object mo2351write(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super Integer> continuation);

    Object writeExactly(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, Continuation<? super C1133Unit> continuation);
}
