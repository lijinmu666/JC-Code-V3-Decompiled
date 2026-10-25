package com.flyfishxu.p028kadb.p037tls;

import com.flyfishxu.p028kadb.exception.AdbPairAuthException;
import com.flyfishxu.p028kadb.p037tls.TlsErrorMapper;
import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m4988d2 = {"Lcom/flyfishxu/kadb/tls/TlsErrorMapper;", BuildConfig.f24315FLAVOR, "<init>", "()V", "map", BuildConfig.f24315FLAVOR, "throwable", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTlsErrorMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TlsErrorMapper.kt\ncom/flyfishxu/kadb/tls/TlsErrorMapper\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1505#2:55\n1506#2:57\n1439#2,2:58\n1439#2,2:60\n1#3:56\n*S KotlinDebug\n*F\n+ 1 TlsErrorMapper.kt\ncom/flyfishxu/kadb/tls/TlsErrorMapper\n*L\n29#1:55\n29#1:57\n41#1:58,2\n46#1:60,2\n*E\n"})
/* loaded from: classes.dex */
public final class TlsErrorMapper {
    public static final TlsErrorMapper INSTANCE = new TlsErrorMapper();

    private TlsErrorMapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable map$lambda$0$0(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable map$lambda$1(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable map$lambda$3(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCause();
    }

    /* renamed from: map */
    public final Throwable m2348map(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        StringBuilder sb = new StringBuilder();
        Iterator it = SequencesKt.generateSequence(throwable, (Function1<? super Throwable, ? extends Throwable>) new Function1() { // from class: o.B8
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return TlsErrorMapper.map$lambda$0$0((Throwable) obj);
            }
        }).iterator();
        while (it.hasNext()) {
            String message = ((Throwable) it.next()).getMessage();
            if (message != null) {
                String lowerCase = message.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                sb.append(lowerCase);
                sb.append('\n');
            }
        }
        String string = sb.toString();
        if (StringsKt.contains$default((CharSequence) string, (CharSequence) "certificate_required", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) string, (CharSequence) "unknown_ca", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) string, (CharSequence) "access_denied", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) string, (CharSequence) "certificate_unknown", false, 2, (Object) null)) {
            return new AdbPairAuthException();
        }
        Iterator it2 = SequencesKt.generateSequence(throwable, (Function1<? super Throwable, ? extends Throwable>) new Function1() { // from class: o.C8
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return TlsErrorMapper.map$lambda$1((Throwable) obj);
            }
        }).iterator();
        while (it2.hasNext()) {
            if (((Throwable) it2.next()) instanceof InterruptedByTimeoutException) {
                return new IOException("TLS handshake timeout", throwable);
            }
        }
        for (Throwable th : SequencesKt.generateSequence(throwable, (Function1<? super Throwable, ? extends Throwable>) new Function1() { // from class: o.D8
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return TlsErrorMapper.map$lambda$3((Throwable) obj);
            }
        })) {
            if ((th instanceof SSLHandshakeException) || (th instanceof SSLProtocolException) || (th instanceof SSLException)) {
                String message2 = throwable.getMessage();
                String str = BuildConfig.f24315FLAVOR;
                if (message2 == null) {
                    message2 = BuildConfig.f24315FLAVOR;
                }
                if (message2.length() > 0) {
                    str = ": " + message2;
                }
                return new IOException("TLS handshake failed" + str, throwable);
            }
        }
        return throwable;
    }
}
