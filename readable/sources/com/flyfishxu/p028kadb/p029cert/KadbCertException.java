package com.flyfishxu.p028kadb.p029cert;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0005\t\n\u000b\f\rB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "PrivateKeyParseFailed", "StoreReadFailed", "StoreWriteFailed", "PolicyViolation", "Companion", "Lcom/flyfishxu/kadb/cert/KadbCertException$PolicyViolation;", "Lcom/flyfishxu/kadb/cert/KadbCertException$PrivateKeyParseFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException$StoreReadFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException$StoreWriteFailed;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class KadbCertException extends RuntimeException {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "fromPrivateKeyParseError", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "error", BuildConfig.f24315FLAVOR, "fromPrivateKeyParseError$com_github_IndiTheo_kadb", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KadbCertException fromPrivateKeyParseError$com_github_IndiTheo_kadb(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return error instanceof KadbCertException ? (KadbCertException) error : new PrivateKeyParseFailed(error);
        }

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException$PolicyViolation;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "message", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class PolicyViolation extends KadbCertException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PolicyViolation(String message, Throwable th) {
            super(message, th, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }

        public /* synthetic */ PolicyViolation(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException$PrivateKeyParseFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class PrivateKeyParseFailed extends KadbCertException {
        /* JADX WARN: Multi-variable type inference failed */
        public PrivateKeyParseFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public PrivateKeyParseFailed(Throwable th) {
            super("Failed to parse private key", th, null);
        }

        public /* synthetic */ PrivateKeyParseFailed(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException$StoreReadFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class StoreReadFailed extends KadbCertException {
        /* JADX WARN: Multi-variable type inference failed */
        public StoreReadFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public StoreReadFailed(Throwable th) {
            super("Failed to read identity from store", th, null);
        }

        public /* synthetic */ StoreReadFailed(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCertException$StoreWriteFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class StoreWriteFailed extends KadbCertException {
        /* JADX WARN: Multi-variable type inference failed */
        public StoreWriteFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public StoreWriteFailed(Throwable th) {
            super("Failed to write identity to store", th, null);
        }

        public /* synthetic */ StoreWriteFailed(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }
    }

    public /* synthetic */ KadbCertException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    private KadbCertException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ KadbCertException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th, null);
    }
}
