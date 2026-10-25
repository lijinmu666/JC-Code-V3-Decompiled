package com.indidevs.p086android.p087adbeesh.p089pairing;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;", BuildConfig.f24315FLAVOR, "provideCode", BuildConfig.f24315FLAVOR, "sessionId", "port", BuildConfig.f24315FLAVOR, "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface AdbPairingCodeProvider {
    Object provideCode(String str, int i, Continuation<? super String> continuation);
}
