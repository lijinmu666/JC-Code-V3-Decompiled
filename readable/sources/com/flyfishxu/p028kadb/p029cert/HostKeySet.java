package com.flyfishxu.p028kadb.p029cert;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/HostKeySet;", BuildConfig.f24315FLAVOR, "defaultKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "keyPairs", BuildConfig.f24315FLAVOR, "<init>", "(Lcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/util/List;)V", "getDefaultKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getKeyPairs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nHostKeySet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HostKeySet.kt\ncom/flyfishxu/kadb/cert/HostKeySet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
/* loaded from: classes.dex */
public final /* data */ class HostKeySet {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdbKeyPair defaultKeyPair;
    private final List<AdbKeyPair> keyPairs;

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/HostKeySet$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "single", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: single */
        public final HostKeySet m2179single(AdbKeyPair keyPair) {
            Intrinsics.checkNotNullParameter(keyPair, "keyPair");
            return new HostKeySet(keyPair, CollectionsKt.m5801listOf(keyPair));
        }

        private Companion() {
        }
    }

    public HostKeySet(AdbKeyPair defaultKeyPair, List<AdbKeyPair> keyPairs) {
        Intrinsics.checkNotNullParameter(defaultKeyPair, "defaultKeyPair");
        Intrinsics.checkNotNullParameter(keyPairs, "keyPairs");
        this.defaultKeyPair = defaultKeyPair;
        this.keyPairs = keyPairs;
        if (keyPairs.isEmpty()) {
            throw new IllegalArgumentException("HostKeySet must contain at least one key pair");
        }
        if (CollectionsKt.m5848first((List) keyPairs) != defaultKeyPair) {
            throw new IllegalArgumentException("Default key pair must be the first entry in key set");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostKeySet copy$default(HostKeySet hostKeySet, AdbKeyPair adbKeyPair, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            adbKeyPair = hostKeySet.defaultKeyPair;
        }
        if ((i & 2) != 0) {
            list = hostKeySet.keyPairs;
        }
        return hostKeySet.m2177copy(adbKeyPair, list);
    }

    /* renamed from: component1, reason: from getter */
    public final AdbKeyPair getDefaultKeyPair() {
        return this.defaultKeyPair;
    }

    public final List<AdbKeyPair> component2() {
        return this.keyPairs;
    }

    /* renamed from: copy */
    public final HostKeySet m2177copy(AdbKeyPair defaultKeyPair, List<AdbKeyPair> keyPairs) {
        Intrinsics.checkNotNullParameter(defaultKeyPair, "defaultKeyPair");
        Intrinsics.checkNotNullParameter(keyPairs, "keyPairs");
        return new HostKeySet(defaultKeyPair, keyPairs);
    }

    /* renamed from: equals */
    public boolean m2178equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostKeySet)) {
            return false;
        }
        HostKeySet hostKeySet = (HostKeySet) other;
        return Intrinsics.areEqual(this.defaultKeyPair, hostKeySet.defaultKeyPair) && Intrinsics.areEqual(this.keyPairs, hostKeySet.keyPairs);
    }

    public final AdbKeyPair getDefaultKeyPair() {
        return this.defaultKeyPair;
    }

    public final List<AdbKeyPair> getKeyPairs() {
        return this.keyPairs;
    }

    public int hashCode() {
        return (this.defaultKeyPair.hashCode() * 31) + this.keyPairs.hashCode();
    }

    public String toString() {
        return "HostKeySet(defaultKeyPair=" + this.defaultKeyPair + ", keyPairs=" + this.keyPairs + ")";
    }
}
