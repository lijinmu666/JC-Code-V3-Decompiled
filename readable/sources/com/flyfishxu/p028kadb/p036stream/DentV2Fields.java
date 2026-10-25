package com.flyfishxu.p028kadb.p036stream;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/DentV2Fields;", BuildConfig.f24315FLAVOR, "errorCode", BuildConfig.f24315FLAVOR, "dev", BuildConfig.f24315FLAVOR, "ino", "mode", "nlink", "uid", "gid", "size", "atimeSec", "mtimeSec", "ctimeSec", "name", BuildConfig.f24315FLAVOR, "<init>", "(IJJIIIIJJJJLjava/lang/String;)V", "getErrorCode", "()I", "getDev", "()J", "getIno", "getMode", "getNlink", "getUid", "getGid", "getSize", "getAtimeSec", "getMtimeSec", "getCtimeSec", "getName", "()Ljava/lang/String;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class DentV2Fields {
    private final long atimeSec;
    private final long ctimeSec;
    private final long dev;
    private final int errorCode;
    private final int gid;
    private final long ino;
    private final int mode;
    private final long mtimeSec;
    private final String name;
    private final int nlink;
    private final long size;
    private final int uid;

    public DentV2Fields(int i, long j, long j2, int i2, int i3, int i4, int i5, long j3, long j4, long j5, long j6, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.errorCode = i;
        this.dev = j;
        this.ino = j2;
        this.mode = i2;
        this.nlink = i3;
        this.uid = i4;
        this.gid = i5;
        this.size = j3;
        this.atimeSec = j4;
        this.mtimeSec = j5;
        this.ctimeSec = j6;
        this.name = name;
    }

    public final long getAtimeSec() {
        return this.atimeSec;
    }

    public final long getCtimeSec() {
        return this.ctimeSec;
    }

    public final long getDev() {
        return this.dev;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getGid() {
        return this.gid;
    }

    public final long getIno() {
        return this.ino;
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

    public final int getNlink() {
        return this.nlink;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getUid() {
        return this.uid;
    }
}
