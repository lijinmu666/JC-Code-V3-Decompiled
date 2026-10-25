package com.flyfishxu.p028kadb.p036stream;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/AdbSyncStat;", BuildConfig.f24315FLAVOR, "mode", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "mtimeSec", "<init>", "(IJJ)V", "getMode", "()I", "getSize", "()J", "getMtimeSec", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbSyncStat {
    private final int mode;
    private final long mtimeSec;
    private final long size;

    public AdbSyncStat(int i, long j, long j2) {
        this.mode = i;
        this.size = j;
        this.mtimeSec = j2;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getMtimeSec() {
        return this.mtimeSec;
    }

    public final long getSize() {
        return this.size;
    }
}
