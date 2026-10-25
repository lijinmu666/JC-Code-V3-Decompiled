package com.indidevs.p086android.p087adbeesh.p090runtime;

import com.flyfishxu.p028kadb.C0187Kadb;
import java.io.Closeable;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/runtime/AdbSession;", "Ljava/io/Closeable;", "shell", "Lcom/indidevs/android/adbeesh/runtime/AdbShellResult;", "command", BuildConfig.f24315FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kadb", "Lcom/flyfishxu/kadb/Kadb;", "getKadb", "()Lcom/flyfishxu/kadb/Kadb;", "isAlive", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", BuildConfig.f24315FLAVOR, "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface AdbSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    C0187Kadb getKadb();

    /* renamed from: isAlive */
    Object mo4315isAlive(Continuation<? super Boolean> continuation);

    /* renamed from: shell */
    Object mo4316shell(String str, Continuation<? super AdbShellResult> continuation);
}
