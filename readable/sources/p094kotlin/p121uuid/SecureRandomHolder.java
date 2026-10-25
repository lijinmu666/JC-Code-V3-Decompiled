package p094kotlin.p121uuid;

import java.security.SecureRandom;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lkotlin/uuid/SecureRandomHolder;", BuildConfig.f24315FLAVOR, "<init>", "()V", "instance", "Ljava/security/SecureRandom;", "getInstance", "()Ljava/security/SecureRandom;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class SecureRandomHolder {
    public static final SecureRandomHolder INSTANCE = new SecureRandomHolder();
    private static final SecureRandom instance = new SecureRandom();

    private SecureRandomHolder() {
    }

    public final SecureRandom getInstance() {
        return instance;
    }
}
