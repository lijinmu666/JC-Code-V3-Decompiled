package com.flyfishxu.p028kadb.p033pair;

import com.flyfishxu.p028kadb.p029cert.AdbKeyPair;
import com.flyfishxu.p028kadb.p029cert.CertUtils;
import com.flyfishxu.p028kadb.p029cert.HostKeySet;
import com.flyfishxu.p028kadb.p033pair.SslUtils;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.p172x500.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;
import org.conscrypt.BuildConfig;
import org.conscrypt.OpenSSLProvider;
import p094kotlin.C1122Pair;
import p094kotlin.C1124Result;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.TuplesKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.C1155MapsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u000212B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002JI\u0010\"\u001a\u0004\u0018\u00010\u00122\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010$2\u0010\u0010%\u001a\f\u0012\u0006\b\u0001\u0012\u00020&\u0018\u00010$2\u0006\u0010'\u001a\u00020\u00122\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0017\u0010.\u001a\u0004\u0018\u00010\u00122\u0006\u0010/\u001a\u00020&H\u0000¢\u0006\u0002\b0R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/SslUtils;", BuildConfig.f24315FLAVOR, "<init>", "()V", "customConscrypt", BuildConfig.f24315FLAVOR, "getCustomConscrypt", "()Z", "setCustomConscrypt", "(Z)V", "lock", "cachedContext", "Lcom/flyfishxu/kadb/pair/SslUtils$CachedContext;", "newClientEngine", "Ljavax/net/ssl/SSLEngine;", "sslContext", "Ljavax/net/ssl/SSLContext;", "host", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "getSslContext", "hostKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "createSslContext", "Lkotlin/Pair;", "newClientKeyManager", "Ljavax/net/ssl/X509ExtendedKeyManager;", "newClientKeyManager$com_github_IndiTheo_kadb", "getAllAcceptingTrustManager", "Ljavax/net/ssl/X509TrustManager;", "buildCacheKey", "chooseAlias", "keyTypes", BuildConfig.f24315FLAVOR, "issuers", "Ljava/security/Principal;", "defaultAlias", "identities", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/pair/SslUtils$ClientIdentity;", "([Ljava/lang/String;[Ljava/security/Principal;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "supportsKeyType", "keyType", "parseAdbKeyFingerprintHexFromIssuer", "issuer", "parseAdbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb", "CachedContext", "ClientIdentity", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSslUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SslUtils.kt\ncom/flyfishxu/kadb/pair/SslUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,237:1\n1749#2:238\n1782#2,4:239\n1373#2,2:243\n1402#2,4:245\n296#2,2:251\n296#2,2:253\n14266#3,2:249\n1#4:255\n1107#5,2:256\n*S KotlinDebug\n*F\n+ 1 SslUtils.kt\ncom/flyfishxu/kadb/pair/SslUtils\n*L\n125#1:238\n125#1:239,4\n132#1:243,2\n132#1:245,4\n208#1:251,2\n215#1:253,2\n196#1:249,2\n231#1:256,2\n*E\n"})
/* loaded from: classes.dex */
public final class SslUtils {
    private static volatile CachedContext cachedContext;
    private static volatile boolean customConscrypt;
    public static final SslUtils INSTANCE = new SslUtils();
    private static final Object lock = new Object();

    @Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/SslUtils$CachedContext;", BuildConfig.f24315FLAVOR, "hostKeyCacheKey", BuildConfig.f24315FLAVOR, "context", "Ljavax/net/ssl/SSLContext;", "customConscrypt", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljavax/net/ssl/SSLContext;Z)V", "getHostKeyCacheKey", "()Ljava/lang/String;", "getContext", "()Ljavax/net/ssl/SSLContext;", "getCustomConscrypt", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* data */ class CachedContext {
        private final SSLContext context;
        private final boolean customConscrypt;
        private final String hostKeyCacheKey;

        public CachedContext(String hostKeyCacheKey, SSLContext context, boolean z) {
            Intrinsics.checkNotNullParameter(hostKeyCacheKey, "hostKeyCacheKey");
            Intrinsics.checkNotNullParameter(context, "context");
            this.hostKeyCacheKey = hostKeyCacheKey;
            this.context = context;
            this.customConscrypt = z;
        }

        public static /* synthetic */ CachedContext copy$default(CachedContext cachedContext, String str, SSLContext sSLContext, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cachedContext.hostKeyCacheKey;
            }
            if ((i & 2) != 0) {
                sSLContext = cachedContext.context;
            }
            if ((i & 4) != 0) {
                z = cachedContext.customConscrypt;
            }
            return cachedContext.m2278copy(str, sSLContext, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getHostKeyCacheKey() {
            return this.hostKeyCacheKey;
        }

        /* renamed from: component2, reason: from getter */
        public final SSLContext getContext() {
            return this.context;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCustomConscrypt() {
            return this.customConscrypt;
        }

        /* renamed from: copy */
        public final CachedContext m2278copy(String hostKeyCacheKey, SSLContext context, boolean customConscrypt) {
            Intrinsics.checkNotNullParameter(hostKeyCacheKey, "hostKeyCacheKey");
            Intrinsics.checkNotNullParameter(context, "context");
            return new CachedContext(hostKeyCacheKey, context, customConscrypt);
        }

        /* renamed from: equals */
        public boolean m2279equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedContext)) {
                return false;
            }
            CachedContext cachedContext = (CachedContext) other;
            return Intrinsics.areEqual(this.hostKeyCacheKey, cachedContext.hostKeyCacheKey) && Intrinsics.areEqual(this.context, cachedContext.context) && this.customConscrypt == cachedContext.customConscrypt;
        }

        public final SSLContext getContext() {
            return this.context;
        }

        public final boolean getCustomConscrypt() {
            return this.customConscrypt;
        }

        public final String getHostKeyCacheKey() {
            return this.hostKeyCacheKey;
        }

        public int hashCode() {
            return (((this.hostKeyCacheKey.hashCode() * 31) + this.context.hashCode()) * 31) + Boolean.hashCode(this.customConscrypt);
        }

        public String toString() {
            return "CachedContext(hostKeyCacheKey=" + this.hostKeyCacheKey + ", context=" + this.context + ", customConscrypt=" + this.customConscrypt + ")";
        }
    }

    @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, m4988d2 = {"Lcom/flyfishxu/kadb/pair/SslUtils$ClientIdentity;", BuildConfig.f24315FLAVOR, "alias", BuildConfig.f24315FLAVOR, "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "adbTlsFingerprintHex", "<init>", "(Ljava/lang/String;Lcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getAdbTlsFingerprintHex", "component1", "component2", "component3", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* data */ class ClientIdentity {
        private final String adbTlsFingerprintHex;
        private final String alias;
        private final AdbKeyPair keyPair;

        public ClientIdentity(String alias, AdbKeyPair keyPair, String adbTlsFingerprintHex) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(keyPair, "keyPair");
            Intrinsics.checkNotNullParameter(adbTlsFingerprintHex, "adbTlsFingerprintHex");
            this.alias = alias;
            this.keyPair = keyPair;
            this.adbTlsFingerprintHex = adbTlsFingerprintHex;
        }

        public static /* synthetic */ ClientIdentity copy$default(ClientIdentity clientIdentity, String str, AdbKeyPair adbKeyPair, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientIdentity.alias;
            }
            if ((i & 2) != 0) {
                adbKeyPair = clientIdentity.keyPair;
            }
            if ((i & 4) != 0) {
                str2 = clientIdentity.adbTlsFingerprintHex;
            }
            return clientIdentity.m2280copy(str, adbKeyPair, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAlias() {
            return this.alias;
        }

        /* renamed from: component2, reason: from getter */
        public final AdbKeyPair getKeyPair() {
            return this.keyPair;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAdbTlsFingerprintHex() {
            return this.adbTlsFingerprintHex;
        }

        /* renamed from: copy */
        public final ClientIdentity m2280copy(String alias, AdbKeyPair keyPair, String adbTlsFingerprintHex) {
            Intrinsics.checkNotNullParameter(alias, "alias");
            Intrinsics.checkNotNullParameter(keyPair, "keyPair");
            Intrinsics.checkNotNullParameter(adbTlsFingerprintHex, "adbTlsFingerprintHex");
            return new ClientIdentity(alias, keyPair, adbTlsFingerprintHex);
        }

        /* renamed from: equals */
        public boolean m2281equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientIdentity)) {
                return false;
            }
            ClientIdentity clientIdentity = (ClientIdentity) other;
            return Intrinsics.areEqual(this.alias, clientIdentity.alias) && Intrinsics.areEqual(this.keyPair, clientIdentity.keyPair) && Intrinsics.areEqual(this.adbTlsFingerprintHex, clientIdentity.adbTlsFingerprintHex);
        }

        public final String getAdbTlsFingerprintHex() {
            return this.adbTlsFingerprintHex;
        }

        public final String getAlias() {
            return this.alias;
        }

        public final AdbKeyPair getKeyPair() {
            return this.keyPair;
        }

        public int hashCode() {
            return (((this.alias.hashCode() * 31) + this.keyPair.hashCode()) * 31) + this.adbTlsFingerprintHex.hashCode();
        }

        public String toString() {
            return "ClientIdentity(alias=" + this.alias + ", keyPair=" + this.keyPair + ", adbTlsFingerprintHex=" + this.adbTlsFingerprintHex + ")";
        }
    }

    private SslUtils() {
    }

    private final String buildCacheKey(HostKeySet hostKeySet) {
        return CollectionsKt.joinToString$default(hostKeySet.getKeyPairs(), "|", null, null, 0, null, new Function1() { // from class: o.g7
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return SslUtils.buildCacheKey$lambda$0((AdbKeyPair) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCacheKey$lambda$0(AdbKeyPair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CertUtils.INSTANCE.fingerprintSha256(it.getCertificate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String chooseAlias(String[] keyTypes, Principal[] issuers, String defaultAlias, List<ClientIdentity> identities) {
        String alias;
        Object next;
        if (keyTypes != null && keyTypes.length != 0) {
            int length = keyTypes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    identities = CollectionsKt.emptyList();
                    break;
                }
                if (supportsKeyType(keyTypes[i])) {
                    break;
                }
                i++;
            }
        }
        Object obj = null;
        if (identities.isEmpty()) {
            return null;
        }
        if (issuers != null && issuers.length != 0) {
            for (Principal principal : issuers) {
                String adbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb = parseAdbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb(principal);
                if (adbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb != null) {
                    Iterator<T> it = identities.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics.areEqual(((ClientIdentity) next).getAdbTlsFingerprintHex(), adbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb)) {
                            break;
                        }
                    }
                    ClientIdentity clientIdentity = (ClientIdentity) next;
                    if (clientIdentity != null) {
                        return clientIdentity.getAlias();
                    }
                }
            }
        }
        Iterator<T> it2 = identities.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((ClientIdentity) next2).getAlias(), defaultAlias)) {
                obj = next2;
                break;
            }
        }
        ClientIdentity clientIdentity2 = (ClientIdentity) obj;
        return (clientIdentity2 == null || (alias = clientIdentity2.getAlias()) == null) ? ((ClientIdentity) CollectionsKt.m5848first((List) identities)).getAlias() : alias;
    }

    private final C1122Pair<SSLContext, Boolean> createSslContext(HostKeySet hostKeySet) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext;
        boolean z;
        try {
            int i = OpenSSLProvider.f24434mjFkc;
            Object objNewInstance = OpenSSLProvider.class.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type java.security.Provider");
            sSLContext = SSLContext.getInstance("TLSv1.3", (Provider) objNewInstance);
            Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(...)");
            z = true;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (Throwable unused) {
            sSLContext = SSLContext.getInstance("TLSv1.3");
            Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(...)");
            z = false;
        }
        sSLContext.init(new KeyManager[]{newClientKeyManager$com_github_IndiTheo_kadb(hostKeySet)}, new X509TrustManager[]{getAllAcceptingTrustManager()}, new SecureRandom());
        return TuplesKt.m5076to(sSLContext, Boolean.valueOf(z));
    }

    private final X509TrustManager getAllAcceptingTrustManager() {
        return new X509TrustManager() { // from class: com.flyfishxu.kadb.pair.SslUtils.getAllAcceptingTrustManager.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean supportsKeyType(String keyType) {
        if (keyType == null) {
            return true;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = keyType.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "RSA", false, 2, (Object) null);
    }

    public final boolean getCustomConscrypt() {
        return customConscrypt;
    }

    public final SSLContext getSslContext(HostKeySet hostKeySet) {
        Intrinsics.checkNotNullParameter(hostKeySet, "hostKeySet");
        String strBuildCacheKey = buildCacheKey(hostKeySet);
        CachedContext cachedContext2 = cachedContext;
        if (cachedContext2 != null && Intrinsics.areEqual(cachedContext2.getHostKeyCacheKey(), strBuildCacheKey)) {
            customConscrypt = cachedContext2.getCustomConscrypt();
            return cachedContext2.getContext();
        }
        synchronized (lock) {
            CachedContext cachedContext3 = cachedContext;
            if (cachedContext3 != null && Intrinsics.areEqual(cachedContext3.getHostKeyCacheKey(), strBuildCacheKey)) {
                customConscrypt = cachedContext3.getCustomConscrypt();
                return cachedContext3.getContext();
            }
            C1122Pair<SSLContext, Boolean> c1122PairCreateSslContext = INSTANCE.createSslContext(hostKeySet);
            CachedContext cachedContext4 = new CachedContext(strBuildCacheKey, c1122PairCreateSslContext.getFirst(), c1122PairCreateSslContext.getSecond().booleanValue());
            cachedContext = cachedContext4;
            customConscrypt = cachedContext4.getCustomConscrypt();
            return cachedContext4.getContext();
        }
    }

    public final SSLEngine newClientEngine(SSLContext sslContext, String host, int port) {
        Intrinsics.checkNotNullParameter(sslContext, "sslContext");
        SSLEngine sSLEngineCreateSSLEngine = host != null ? sslContext.createSSLEngine(host, port) : sslContext.createSSLEngine();
        sSLEngineCreateSSLEngine.setUseClientMode(true);
        sSLEngineCreateSSLEngine.setEnabledProtocols(new String[]{"TLSv1.3"});
        Intrinsics.checkNotNull(sSLEngineCreateSSLEngine);
        return sSLEngineCreateSSLEngine;
    }

    public final X509ExtendedKeyManager newClientKeyManager$com_github_IndiTheo_kadb(HostKeySet hostKeySet) {
        Intrinsics.checkNotNullParameter(hostKeySet, "hostKeySet");
        List<AdbKeyPair> keyPairs = hostKeySet.getKeyPairs();
        final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keyPairs, 10));
        int i = 0;
        for (Object obj : keyPairs) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AdbKeyPair adbKeyPair = (AdbKeyPair) obj;
            arrayList.add(new ClientIdentity("key-" + i, adbKeyPair, CertUtils.INSTANCE.adbTlsFingerprintHex(adbKeyPair.getPublicKey())));
            i = i2;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(C1155MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((ClientIdentity) obj2).getAlias(), obj2);
        }
        final String alias = ((ClientIdentity) CollectionsKt.m5848first((List) arrayList)).getAlias();
        return new X509ExtendedKeyManager() { // from class: com.flyfishxu.kadb.pair.SslUtils$newClientKeyManager$1
            @Override // javax.net.ssl.X509KeyManager
            public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket) {
                return SslUtils.INSTANCE.chooseAlias(keyTypes, issuers, alias, arrayList);
            }

            @Override // javax.net.ssl.X509ExtendedKeyManager
            public String chooseEngineClientAlias(String[] keyTypes, Principal[] issuers, SSLEngine engine) {
                return SslUtils.INSTANCE.chooseAlias(keyTypes, issuers, alias, arrayList);
            }

            @Override // javax.net.ssl.X509KeyManager
            public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
                return null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // javax.net.ssl.X509KeyManager
            public X509Certificate[] getCertificateChain(String alias2) {
                SslUtils.ClientIdentity clientIdentity = linkedHashMap.get(alias2);
                if (clientIdentity == null) {
                    return null;
                }
                Certificate certificate = clientIdentity.getKeyPair().getCertificate();
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                return new X509Certificate[]{certificate};
            }

            @Override // javax.net.ssl.X509KeyManager
            public String[] getClientAliases(String keyType, Principal[] issuers) {
                if (!SslUtils.INSTANCE.supportsKeyType(keyType)) {
                    return new String[0];
                }
                List<SslUtils.ClientIdentity> list = arrayList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((SslUtils.ClientIdentity) it.next()).getAlias());
                }
                return (String[]) arrayList2.toArray(new String[0]);
            }

            @Override // javax.net.ssl.X509KeyManager
            public PrivateKey getPrivateKey(String alias2) {
                AdbKeyPair keyPair;
                SslUtils.ClientIdentity clientIdentity = linkedHashMap.get(alias2);
                if (clientIdentity == null || (keyPair = clientIdentity.getKeyPair()) == null) {
                    return null;
                }
                return keyPair.getPrivateKey();
            }

            @Override // javax.net.ssl.X509KeyManager
            public String[] getServerAliases(String keyType, Principal[] issuers) {
                return null;
            }
        };
    }

    public final String parseAdbKeyFingerprintHexFromIssuer$com_github_IndiTheo_kadb(Principal issuer) {
        Object objM18546constructorimpl;
        AttributeTypeAndValue first;
        ASN1Encodable value;
        String string;
        AttributeTypeAndValue first2;
        ASN1Encodable value2;
        String string2;
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(new X500Name(issuer.getName()));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
            objM18546constructorimpl = null;
        }
        X500Name x500Name = (X500Name) objM18546constructorimpl;
        if (x500Name == null) {
            return null;
        }
        C5188RDN[] c5188rdnArrM14666getRDNs = x500Name.m14666getRDNs(C5189BCStyle.f18597O);
        Intrinsics.checkNotNullExpressionValue(c5188rdnArrM14666getRDNs, "getRDNs(...)");
        C5188RDN c5188rdn = (C5188RDN) ArraysKt.firstOrNull(c5188rdnArrM14666getRDNs);
        if (c5188rdn == null || (first = c5188rdn.getFirst()) == null || (value = first.getValue()) == null || (string = value.toString()) == null || !Intrinsics.areEqual(string, "AdbKey-0")) {
            return null;
        }
        C5188RDN[] c5188rdnArrM14666getRDNs2 = x500Name.m14666getRDNs(C5189BCStyle.f18591CN);
        Intrinsics.checkNotNullExpressionValue(c5188rdnArrM14666getRDNs2, "getRDNs(...)");
        C5188RDN c5188rdn2 = (C5188RDN) ArraysKt.firstOrNull(c5188rdnArrM14666getRDNs2);
        if (c5188rdn2 != null && (first2 = c5188rdn2.getFirst()) != null && (value2 = first2.getValue()) != null && (string2 = value2.toString()) != null && string2.length() == 64) {
            for (int i = 0; i < string2.length(); i++) {
                char cCharAt = string2.charAt(i);
                if (Character.isDigit(cCharAt) || (('a' <= cCharAt && cCharAt < 'g') || ('A' <= cCharAt && cCharAt < 'G'))) {
                }
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = string2.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        return null;
    }

    public final void setCustomConscrypt(boolean z) {
        customConscrypt = z;
    }

    public final SSLContext getSslContext(AdbKeyPair keyPair) {
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        return getSslContext(HostKeySet.INSTANCE.m2179single(keyPair));
    }
}
