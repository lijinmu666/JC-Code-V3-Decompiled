package com.flyfishxu.p028kadb.p036stream;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/Packet;", BuildConfig.f24315FLAVOR, "id", BuildConfig.f24315FLAVOR, "arg", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getArg", "()I", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: com.flyfishxu.kadb.stream.Packet */
/* loaded from: classes.dex */
final class C0199Packet {
    private final int arg;
    private final String id;

    public C0199Packet(String id, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.arg = i;
    }

    public final int getArg() {
        return this.arg;
    }

    public final String getId() {
        return this.id;
    }
}
