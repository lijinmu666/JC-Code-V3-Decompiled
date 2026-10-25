package com.flyfishxu.p028kadb.p036stream;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/AdbSyncDirEntry;", BuildConfig.f24315FLAVOR, "name", BuildConfig.f24315FLAVOR, "mode", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "mtimeSec", "errorCode", "<init>", "(Ljava/lang/String;IJJLjava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getMode", "()I", "getSize", "()J", "getMtimeSec", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbSyncDirEntry {
    private final Integer errorCode;
    private final int mode;
    private final long mtimeSec;
    private final String name;
    private final long size;

    public AdbSyncDirEntry(String name, int i, long j, long j2, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.mode = i;
        this.size = j;
        this.mtimeSec = j2;
        this.errorCode = num;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getMtimeSec() {
        return this.mtimeSec;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSize() {
        return this.size;
    }
}
