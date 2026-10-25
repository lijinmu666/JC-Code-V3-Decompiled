package com.flyfishxu.p028kadb.p029cert;

import com.flyfishxu.p028kadb.p029cert.KadbCertException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0019\u001a\u00020\u000fJ\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\n\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCert;", BuildConfig.f24315FLAVOR, "<init>", "()V", "lock", "store", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "policy", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", "additionalPrivateKeysPem", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "state", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "configure", BuildConfig.f24315FLAVOR, "ensureReady", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "rotate", "importIdentity", "privateKeyPem", "certificatePem", "importPrivateKey", "exportIdentityOrNull", "exportPrivateKeyOrNull", "clear", "currentKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "currentKeyPair$com_github_IndiTheo_kadb", "currentKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "currentKeySet$com_github_IndiTheo_kadb", "ensureReadyStateLocked", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "loadOrGenerateState", "regenerateAndPersistState", "resolveImportedIdentity", "Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", "validatePrivateKeyOrThrow", "readPrivateKeyFromStoreOrThrow", "writePrivateKeyOrThrow", "resolveHostKeySet", "defaultKeyPair", "validatePolicy", "toKadbCertException", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "error", BuildConfig.f24315FLAVOR, "State", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nKadbCert.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KadbCert.kt\ncom/flyfishxu/kadb/cert/KadbCert\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,233:1\n777#2:234\n873#2,2:235\n1739#2:237\n1814#2,3:238\n1#3:241\n*S KotlinDebug\n*F\n+ 1 KadbCert.kt\ncom/flyfishxu/kadb/cert/KadbCert\n*L\n36#1:234\n36#1:235,2\n37#1:237\n37#1:238,3\n*E\n"})
/* loaded from: classes.dex */
public final class KadbCert {
    public static final KadbCert INSTANCE = new KadbCert();
    private static final Object lock = new Object();
    private static volatile KadbPrivateKeyStore store = new InMemoryPrivateKeyStore();
    private static volatile KadbCertPolicy policy = new KadbCertPolicy(0, 0, false, null, 15, null);
    private static volatile List<byte[]> additionalPrivateKeysPem = CollectionsKt.emptyList();
    private static volatile InterfaceC0190State state = InterfaceC0190State.Uninitialized.INSTANCE;

    @Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCert$State;", BuildConfig.f24315FLAVOR, "Uninitialized", "Ready", "Broken", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Broken;", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "Lcom/flyfishxu/kadb/cert/KadbCert$State$Uninitialized;", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.cert.KadbCert$State */
    public interface InterfaceC0190State {

        @Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCert$State$Broken;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "cause", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        /* renamed from: com.flyfishxu.kadb.cert.KadbCert$State$Broken, reason: from toString */
        public static final /* data */ class Broken implements InterfaceC0190State {
            private final Throwable cause;

            public Broken(Throwable cause) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.cause = cause;
            }

            public static /* synthetic */ Broken copy$default(Broken broken, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = broken.cause;
                }
                return broken.m2183copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getCause() {
                return this.cause;
            }

            /* renamed from: copy */
            public final Broken m2183copy(Throwable cause) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                return new Broken(cause);
            }

            /* renamed from: equals */
            public boolean m2184equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Broken) && Intrinsics.areEqual(this.cause, ((Broken) other).cause);
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public int hashCode() {
                return this.cause.hashCode();
            }

            public String toString() {
                return "Broken(cause=" + this.cause + ")";
            }
        }

        @Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCert$State$Ready;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "snapshot", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "keySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "<init>", "(Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;Lcom/flyfishxu/kadb/cert/HostKeySet;)V", "getSnapshot", "()Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "getKeySet", "()Lcom/flyfishxu/kadb/cert/HostKeySet;", "component1", "component2", "copy", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        /* renamed from: com.flyfishxu.kadb.cert.KadbCert$State$Ready, reason: from toString */
        public static final /* data */ class Ready implements InterfaceC0190State {
            private final HostKeySet keySet;
            private final KadbIdentitySnapshot snapshot;

            public Ready(KadbIdentitySnapshot snapshot, HostKeySet keySet) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                Intrinsics.checkNotNullParameter(keySet, "keySet");
                this.snapshot = snapshot;
                this.keySet = keySet;
            }

            public static /* synthetic */ Ready copy$default(Ready ready, KadbIdentitySnapshot kadbIdentitySnapshot, HostKeySet hostKeySet, int i, Object obj) {
                if ((i & 1) != 0) {
                    kadbIdentitySnapshot = ready.snapshot;
                }
                if ((i & 2) != 0) {
                    hostKeySet = ready.keySet;
                }
                return ready.m2185copy(kadbIdentitySnapshot, hostKeySet);
            }

            /* renamed from: component1, reason: from getter */
            public final KadbIdentitySnapshot getSnapshot() {
                return this.snapshot;
            }

            /* renamed from: component2, reason: from getter */
            public final HostKeySet getKeySet() {
                return this.keySet;
            }

            /* renamed from: copy */
            public final Ready m2185copy(KadbIdentitySnapshot snapshot, HostKeySet keySet) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                Intrinsics.checkNotNullParameter(keySet, "keySet");
                return new Ready(snapshot, keySet);
            }

            /* renamed from: equals */
            public boolean m2186equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Ready)) {
                    return false;
                }
                Ready ready = (Ready) other;
                return Intrinsics.areEqual(this.snapshot, ready.snapshot) && Intrinsics.areEqual(this.keySet, ready.keySet);
            }

            public final HostKeySet getKeySet() {
                return this.keySet;
            }

            public final KadbIdentitySnapshot getSnapshot() {
                return this.snapshot;
            }

            public int hashCode() {
                return (this.snapshot.hashCode() * 31) + this.keySet.hashCode();
            }

            public String toString() {
                return "Ready(snapshot=" + this.snapshot + ", keySet=" + this.keySet + ")";
            }
        }

        @Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbCert$State$Uninitialized;", "Lcom/flyfishxu/kadb/cert/KadbCert$State;", "<init>", "()V", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        /* renamed from: com.flyfishxu.kadb.cert.KadbCert$State$Uninitialized */
        public static final /* data */ class Uninitialized implements InterfaceC0190State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
            }

            /* renamed from: equals */
            public boolean m2187equals(Object other) {
                return this == other || (other instanceof Uninitialized);
            }

            public int hashCode() {
                return 895384043;
            }

            public String toString() {
                return "Uninitialized";
            }
        }
    }

    private KadbCert() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(KadbCert kadbCert, KadbPrivateKeyStore kadbPrivateKeyStore, KadbCertPolicy kadbCertPolicy, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            kadbCertPolicy = new KadbCertPolicy(0, 0, false, null, 15, null);
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        kadbCert.configure(kadbPrivateKeyStore, kadbCertPolicy, list);
    }

    private final InterfaceC0190State.Ready ensureReadyStateLocked() {
        InterfaceC0190State interfaceC0190State = state;
        if (interfaceC0190State instanceof InterfaceC0190State.Ready) {
            return (InterfaceC0190State.Ready) interfaceC0190State;
        }
        try {
            InterfaceC0190State.Ready readyLoadOrGenerateState = loadOrGenerateState();
            state = readyLoadOrGenerateState;
            return readyLoadOrGenerateState;
        } catch (Throwable th) {
            state = new InterfaceC0190State.Broken(th);
            throw toKadbCertException(th);
        }
    }

    public static /* synthetic */ KadbIdentitySnapshot importIdentity$default(KadbCert kadbCert, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr2 = null;
        }
        return kadbCert.importIdentity(bArr, bArr2);
    }

    private final InterfaceC0190State.Ready loadOrGenerateState() throws InvalidKeySpecException {
        byte[] privateKeyFromStoreOrThrow = readPrivateKeyFromStoreOrThrow();
        if (privateKeyFromStoreOrThrow == null || privateKeyFromStoreOrThrow.length == 0) {
            return regenerateAndPersistState();
        }
        try {
            validatePrivateKeyOrThrow(privateKeyFromStoreOrThrow);
            ResolvedIdentity resolvedIdentityIdentityFromPrivateKey = CertUtils.INSTANCE.identityFromPrivateKey(privateKeyFromStoreOrThrow, policy);
            return new InterfaceC0190State.Ready(resolvedIdentityIdentityFromPrivateKey.getSnapshot().deepCopy$com_github_IndiTheo_kadb(), resolveHostKeySet(resolvedIdentityIdentityFromPrivateKey.getKeyPair()));
        } catch (KadbCertException.PrivateKeyParseFailed e) {
            if (policy.getAutoHealInvalidPrivateKey()) {
                return regenerateAndPersistState();
            }
            throw e;
        }
    }

    private final byte[] readPrivateKeyFromStoreOrThrow() {
        try {
            return store.readPrivateKeyPem();
        } catch (Throwable th) {
            throw new KadbCertException.StoreReadFailed(th);
        }
    }

    private final InterfaceC0190State.Ready regenerateAndPersistState() {
        ResolvedIdentity resolvedIdentityGenerateNewIdentity = CertUtils.INSTANCE.generateNewIdentity(policy);
        writePrivateKeyOrThrow(resolvedIdentityGenerateNewIdentity.getPrivateKeyPem());
        return new InterfaceC0190State.Ready(resolvedIdentityGenerateNewIdentity.getSnapshot().deepCopy$com_github_IndiTheo_kadb(), resolveHostKeySet(resolvedIdentityGenerateNewIdentity.getKeyPair()));
    }

    private final HostKeySet resolveHostKeySet(AdbKeyPair defaultKeyPair) {
        Object objM18546constructorimpl;
        List listMutableListOf = CollectionsKt.mutableListOf(defaultKeyPair);
        Set setMutableSetOf = C1159SetsKt.mutableSetOf(CertUtils.INSTANCE.fingerprintSha256(defaultKeyPair.getPublicKey()));
        for (byte[] bArr : additionalPrivateKeysPem) {
            try {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(CertUtils.INSTANCE.identityFromPrivateKey(bArr, policy).getKeyPair());
            } catch (Throwable th) {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
            }
            if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
                objM18546constructorimpl = null;
            }
            AdbKeyPair adbKeyPair = (AdbKeyPair) objM18546constructorimpl;
            if (adbKeyPair != null && setMutableSetOf.add(CertUtils.INSTANCE.fingerprintSha256(adbKeyPair.getPublicKey()))) {
                listMutableListOf.add(adbKeyPair);
            }
        }
        return new HostKeySet(defaultKeyPair, listMutableListOf);
    }

    private final ResolvedIdentity resolveImportedIdentity(byte[] privateKeyPem, byte[] certificatePem) {
        Object objM18546constructorimpl;
        Object objM18546constructorimpl2;
        validatePrivateKeyOrThrow(privateKeyPem);
        if (certificatePem == null || certificatePem.length == 0) {
            return CertUtils.INSTANCE.identityFromPrivateKey(privateKeyPem, policy);
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(CertUtils.INSTANCE.identityFromPrivateKeyAndCertificate(privateKeyPem, certificatePem));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
            objM18546constructorimpl = null;
        }
        ResolvedIdentity resolvedIdentity = (ResolvedIdentity) objM18546constructorimpl;
        if (resolvedIdentity != null) {
            Certificate certificate = resolvedIdentity.getKeyPair().getCertificate();
            X509Certificate x509Certificate = certificate instanceof X509Certificate ? (X509Certificate) certificate : null;
            if (x509Certificate != null) {
                try {
                    CertUtils.INSTANCE.validateCertificate(x509Certificate);
                    objM18546constructorimpl2 = C1124Result.m18546constructorimpl(Boolean.TRUE);
                } catch (Throwable th2) {
                    C1124Result.Companion companion3 = C1124Result.INSTANCE;
                    objM18546constructorimpl2 = C1124Result.m18546constructorimpl(ResultKt.createFailure(th2));
                }
                if (C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl2) != null) {
                    objM18546constructorimpl2 = Boolean.FALSE;
                }
                if (((Boolean) objM18546constructorimpl2).booleanValue()) {
                    return resolvedIdentity;
                }
            }
        }
        return CertUtils.INSTANCE.identityFromPrivateKey(privateKeyPem, policy);
    }

    private final KadbCertException toKadbCertException(Throwable error) {
        return error instanceof KadbCertException ? (KadbCertException) error : new KadbCertException.PolicyViolation("Unexpected KadbCert error", error);
    }

    private final void validatePolicy(KadbCertPolicy policy2) {
        if (policy2.getKeySizeBits() != 2048) {
            throw new KadbCertException.PolicyViolation("Only RSA 2048 is supported", null, 2, null);
        }
        if (policy2.getCertValidityDays() <= 0) {
            throw new KadbCertException.PolicyViolation("Certificate validity must be greater than 0", null, 2, null);
        }
    }

    private final void validatePrivateKeyOrThrow(byte[] privateKeyPem) {
        try {
            CertUtils.INSTANCE.parsePrivateKeyPem(privateKeyPem);
        } catch (Throwable th) {
            throw KadbCertException.INSTANCE.fromPrivateKeyParseError$com_github_IndiTheo_kadb(th);
        }
    }

    private final void writePrivateKeyOrThrow(byte[] privateKeyPem) {
        try {
            store.writePrivateKeyPemAtomic(privateKeyPem);
        } catch (Throwable th) {
            throw new KadbCertException.StoreWriteFailed(th);
        }
    }

    /* renamed from: clear */
    public final void m2181clear() {
        synchronized (lock) {
            try {
                store.mo2180clear();
                state = InterfaceC0190State.Uninitialized.INSTANCE;
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw new KadbCertException.StoreWriteFailed(th);
            }
        }
    }

    public final void configure(KadbPrivateKeyStore store2, KadbCertPolicy policy2, List<byte[]> additionalPrivateKeysPem2) {
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(policy2, "policy");
        Intrinsics.checkNotNullParameter(additionalPrivateKeysPem2, "additionalPrivateKeysPem");
        validatePolicy(policy2);
        synchronized (lock) {
            try {
                store = store2;
                policy = policy2;
                ArrayList<byte[]> arrayList = new ArrayList();
                for (Object obj : additionalPrivateKeysPem2) {
                    if (!(((byte[]) obj).length == 0)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                for (byte[] bArr : arrayList) {
                    byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                    arrayList2.add(bArrCopyOf);
                }
                additionalPrivateKeysPem = arrayList2;
                state = InterfaceC0190State.Uninitialized.INSTANCE;
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AdbKeyPair currentKeyPair$com_github_IndiTheo_kadb() {
        AdbKeyPair defaultKeyPair;
        synchronized (lock) {
            defaultKeyPair = INSTANCE.ensureReadyStateLocked().getKeySet().getDefaultKeyPair();
        }
        return defaultKeyPair;
    }

    public final HostKeySet currentKeySet$com_github_IndiTheo_kadb() {
        HostKeySet keySet;
        synchronized (lock) {
            keySet = INSTANCE.ensureReadyStateLocked().getKeySet();
        }
        return keySet;
    }

    public final KadbIdentitySnapshot ensureReady() {
        KadbIdentitySnapshot kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
        synchronized (lock) {
            kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb = INSTANCE.ensureReadyStateLocked().getSnapshot().deepCopy$com_github_IndiTheo_kadb();
        }
        return kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
    }

    public final KadbIdentitySnapshot exportIdentityOrNull() {
        KadbIdentitySnapshot kadbIdentitySnapshot;
        KadbIdentitySnapshot kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
        synchronized (lock) {
            try {
                InterfaceC0190State interfaceC0190State = state;
                if (interfaceC0190State instanceof InterfaceC0190State.Ready) {
                    kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb = ((InterfaceC0190State.Ready) interfaceC0190State).getSnapshot().deepCopy$com_github_IndiTheo_kadb();
                } else {
                    KadbCert kadbCert = INSTANCE;
                    byte[] privateKeyFromStoreOrThrow = kadbCert.readPrivateKeyFromStoreOrThrow();
                    kadbIdentitySnapshot = null;
                    if (privateKeyFromStoreOrThrow != null && privateKeyFromStoreOrThrow.length != 0) {
                        kadbCert.validatePrivateKeyOrThrow(privateKeyFromStoreOrThrow);
                        kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb = CertUtils.INSTANCE.identityFromPrivateKey(privateKeyFromStoreOrThrow, policy).getSnapshot().deepCopy$com_github_IndiTheo_kadb();
                    }
                }
                kadbIdentitySnapshot = kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
            } finally {
            }
        }
        return kadbIdentitySnapshot;
    }

    public final byte[] exportPrivateKeyOrNull() {
        byte[] bArrCopyOf;
        synchronized (lock) {
            try {
                InterfaceC0190State interfaceC0190State = state;
                if (interfaceC0190State instanceof InterfaceC0190State.Ready) {
                    byte[] privateKeyPem = ((InterfaceC0190State.Ready) interfaceC0190State).getSnapshot().getPrivateKeyPem();
                    bArrCopyOf = Arrays.copyOf(privateKeyPem, privateKeyPem.length);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                } else {
                    byte[] privateKeyFromStoreOrThrow = INSTANCE.readPrivateKeyFromStoreOrThrow();
                    if (privateKeyFromStoreOrThrow != null) {
                        bArrCopyOf = Arrays.copyOf(privateKeyFromStoreOrThrow, privateKeyFromStoreOrThrow.length);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                    } else {
                        bArrCopyOf = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrCopyOf;
    }

    public final KadbIdentitySnapshot importIdentity(byte[] privateKeyPem, byte[] certificatePem) {
        KadbCertException kadbCertException;
        KadbIdentitySnapshot kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        synchronized (lock) {
            InterfaceC0190State interfaceC0190State = state;
            InterfaceC0190State broken = interfaceC0190State instanceof InterfaceC0190State.Ready ? (InterfaceC0190State.Ready) interfaceC0190State : null;
            try {
                KadbCert kadbCert = INSTANCE;
                ResolvedIdentity resolvedIdentityResolveImportedIdentity = kadbCert.resolveImportedIdentity(privateKeyPem, certificatePem);
                kadbCert.writePrivateKeyOrThrow(resolvedIdentityResolveImportedIdentity.getPrivateKeyPem());
                InterfaceC0190State.Ready ready = new InterfaceC0190State.Ready(resolvedIdentityResolveImportedIdentity.getSnapshot().deepCopy$com_github_IndiTheo_kadb(), kadbCert.resolveHostKeySet(resolvedIdentityResolveImportedIdentity.getKeyPair()));
                state = ready;
                kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb = ready.getSnapshot().deepCopy$com_github_IndiTheo_kadb();
            } finally {
            }
        }
        return kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
    }

    public final KadbIdentitySnapshot importPrivateKey(byte[] privateKeyPem) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        return importIdentity(privateKeyPem, null);
    }

    /* renamed from: rotate */
    public final KadbIdentitySnapshot m2182rotate() {
        KadbCertException kadbCertException;
        KadbIdentitySnapshot kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
        synchronized (lock) {
            InterfaceC0190State interfaceC0190State = state;
            InterfaceC0190State broken = interfaceC0190State instanceof InterfaceC0190State.Ready ? (InterfaceC0190State.Ready) interfaceC0190State : null;
            try {
                ResolvedIdentity resolvedIdentityGenerateNewIdentity = CertUtils.INSTANCE.generateNewIdentity(policy);
                KadbCert kadbCert = INSTANCE;
                kadbCert.writePrivateKeyOrThrow(resolvedIdentityGenerateNewIdentity.getPrivateKeyPem());
                InterfaceC0190State.Ready ready = new InterfaceC0190State.Ready(resolvedIdentityGenerateNewIdentity.getSnapshot().deepCopy$com_github_IndiTheo_kadb(), kadbCert.resolveHostKeySet(resolvedIdentityGenerateNewIdentity.getKeyPair()));
                state = ready;
                kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb = ready.getSnapshot().deepCopy$com_github_IndiTheo_kadb();
            } finally {
            }
        }
        return kadbIdentitySnapshotDeepCopy$com_github_IndiTheo_kadb;
    }
}
