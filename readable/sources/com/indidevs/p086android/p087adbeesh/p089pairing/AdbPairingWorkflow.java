package com.indidevs.p086android.p087adbeesh.p089pairing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ \u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;", BuildConfig.f24315FLAVOR, "provider", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;", "callbacks", BuildConfig.f24315FLAVOR, "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCallback;", "<init>", "(Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;Ljava/util/List;)V", "getProvider$adbeesh", "()Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;", "onPairingStarted", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "onPortFound", "port", BuildConfig.f24315FLAVOR, "onPairingHandshakeStarted", "onPairingSuccess", "onPairingError", "error", "provideCode", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Builder", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingWorkflow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingWorkflow.kt\ncom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n2068#2,2:70\n2068#2,2:72\n2068#2,2:74\n2068#2,2:76\n2068#2,2:78\n*S KotlinDebug\n*F\n+ 1 AdbPairingWorkflow.kt\ncom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow\n*L\n13#1:70,2\n17#1:72,2\n21#1:74,2\n25#1:76,2\n29#1:78,2\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingWorkflow {
    private final List<AdbPairingCallback> callbacks;
    private final AdbPairingCodeProvider provider;

    @Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow$Builder;", BuildConfig.f24315FLAVOR, "<init>", "()V", "provider", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;", "callbacks", BuildConfig.f24315FLAVOR, "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCallback;", "withCodeProvider", "addCallback", "callback", "build", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    /* renamed from: com.indidevs.android.adbeesh.pairing.AdbPairingWorkflow$Builder */
    public static final class C0902Builder {
        private final List<AdbPairingCallback> callbacks = new ArrayList();
        private AdbPairingCodeProvider provider;

        public final C0902Builder addCallback(AdbPairingCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        /* renamed from: build */
        public final AdbPairingWorkflow m4365build() {
            AdbPairingCodeProvider adbPairingCodeProvider = this.provider;
            if (adbPairingCodeProvider != null) {
                return new AdbPairingWorkflow(adbPairingCodeProvider, CollectionsKt.m5899toList(this.callbacks), null);
            }
            throw new IllegalStateException("AdbPairingCodeProvider must be set");
        }

        public final C0902Builder withCodeProvider(AdbPairingCodeProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.provider = provider;
            return this;
        }
    }

    public /* synthetic */ AdbPairingWorkflow(AdbPairingCodeProvider adbPairingCodeProvider, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(adbPairingCodeProvider, list);
    }

    /* renamed from: getProvider$adbeesh, reason: from getter */
    public final AdbPairingCodeProvider getProvider() {
        return this.provider;
    }

    public final void onPairingError(String sessionId, String error) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(error, "error");
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((AdbPairingCallback) it.next()).onPairingError(sessionId, error);
        }
    }

    public final void onPairingHandshakeStarted(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((AdbPairingCallback) it.next()).onPairingHandshakeStarted(sessionId);
        }
    }

    public final void onPairingStarted(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((AdbPairingCallback) it.next()).onPairingStarted(sessionId);
        }
    }

    public final void onPairingSuccess(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((AdbPairingCallback) it.next()).onPairingSuccess(sessionId);
        }
    }

    public final void onPortFound(String sessionId, int port) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((AdbPairingCallback) it.next()).onPortFound(sessionId, port);
        }
    }

    public final Object provideCode(String str, int i, Continuation<? super String> continuation) {
        return this.provider.provideCode(str, i, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AdbPairingWorkflow(AdbPairingCodeProvider adbPairingCodeProvider, List<? extends AdbPairingCallback> list) {
        this.provider = adbPairingCodeProvider;
        this.callbacks = list;
    }
}
