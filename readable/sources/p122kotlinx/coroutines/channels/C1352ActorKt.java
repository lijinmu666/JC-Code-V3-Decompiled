package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.AbstractCoroutine;
import p122kotlinx.coroutines.CoroutineContextKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.JobSupport;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(m4987d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2-\b\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112-\u0010\u0012\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, m4988d2 = {"actor", "Lkotlinx/coroutines/channels/SendChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", BuildConfig.f24315FLAVOR, "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.channels.ActorKt */
/* loaded from: classes.dex */
public final class C1352ActorKt {
    @ObsoleteCoroutinesApi
    /* renamed from: actor */
    public static final <E> SendChannel<E> m7045actor(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1<? super Throwable, C1133Unit> function1, Function2<? super ActorScope<E>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        InterfaceC1361Channel interfaceC1361ChannelChannel$default = ChannelKt.Channel$default(i, null, null, 6, null);
        ActorCoroutine lazyActorCoroutine = coroutineStart.m6962isLazy() ? new LazyActorCoroutine(coroutineContextNewCoroutineContext, interfaceC1361ChannelChannel$default, function2) : new ActorCoroutine(coroutineContextNewCoroutineContext, interfaceC1361ChannelChannel$default, true);
        if (function1 != null) {
            ((JobSupport) lazyActorCoroutine).invokeOnCompletion(function1);
        }
        ((AbstractCoroutine) lazyActorCoroutine).m6900start(coroutineStart, lazyActorCoroutine, function2);
        return (SendChannel<E>) lazyActorCoroutine;
    }

    public static /* synthetic */ SendChannel actor$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.f5506DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        return m7045actor(coroutineScope, coroutineContext2, i3, coroutineStart2, function1, function2);
    }
}
