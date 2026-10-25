package com.flyfishxu.p028kadb;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m4988d2 = {"Lcom/flyfishxu/kadb/KadbOptions;", BuildConfig.f24315FLAVOR, "delayedAckMode", "Lcom/flyfishxu/kadb/DelayedAckMode;", "<init>", "(Lcom/flyfishxu/kadb/DelayedAckMode;)V", "getDelayedAckMode", "()Lcom/flyfishxu/kadb/DelayedAckMode;", "component1", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KadbOptions {
    private final DelayedAckMode delayedAckMode;

    /* JADX WARN: Multi-variable type inference failed */
    public KadbOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ KadbOptions copy$default(KadbOptions kadbOptions, DelayedAckMode delayedAckMode, int i, Object obj) {
        if ((i & 1) != 0) {
            delayedAckMode = kadbOptions.delayedAckMode;
        }
        return kadbOptions.m2171copy(delayedAckMode);
    }

    /* renamed from: component1, reason: from getter */
    public final DelayedAckMode getDelayedAckMode() {
        return this.delayedAckMode;
    }

    /* renamed from: copy */
    public final KadbOptions m2171copy(DelayedAckMode delayedAckMode) {
        Intrinsics.checkNotNullParameter(delayedAckMode, "delayedAckMode");
        return new KadbOptions(delayedAckMode);
    }

    /* renamed from: equals */
    public boolean m2172equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KadbOptions) && this.delayedAckMode == ((KadbOptions) other).delayedAckMode;
    }

    public final DelayedAckMode getDelayedAckMode() {
        return this.delayedAckMode;
    }

    public int hashCode() {
        return this.delayedAckMode.hashCode();
    }

    public String toString() {
        return "KadbOptions(delayedAckMode=" + this.delayedAckMode + ")";
    }

    public KadbOptions(DelayedAckMode delayedAckMode) {
        Intrinsics.checkNotNullParameter(delayedAckMode, "delayedAckMode");
        this.delayedAckMode = delayedAckMode;
    }

    public /* synthetic */ KadbOptions(DelayedAckMode delayedAckMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DelayedAckMode.AOSP_DEFAULT : delayedAckMode);
    }
}
