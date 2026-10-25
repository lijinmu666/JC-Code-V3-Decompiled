package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.KadbOptions;
import com.flyfishxu.p028kadb.p029cert.AdbKeyPair;
import com.flyfishxu.p028kadb.p029cert.HostKeySet;
import com.flyfishxu.p028kadb.p034queue.AdbMessageQueue;
import com.flyfishxu.p028kadb.p036stream.AdbStream;
import com.flyfishxu.p028kadb.p037tls.TlsErrorMapper;
import com.flyfishxu.p028kadb.transport.OkioAdaptersKt;
import com.flyfishxu.p028kadb.transport.TlsNioChannel;
import com.flyfishxu.p028kadb.transport.TransportChannel;
import com.flyfishxu.p028kadb.transport.TransportFactory;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.net.ssl.SSLProtocolException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.C1302CharsKt;
import p094kotlin.p117text.StringsKt;
import p132okio.C5052Buffer;

@Metadata(m4987d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00060\u0001j\u0002`\u0002:\u0001$BA\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\rH\u0002J\u0011\u0010\u001f\u001a\u00020 H\u0001b\u0002\b\"¢\u0006\u0002\b!J\b\u0010#\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbConnection;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "adbReader", "Lcom/flyfishxu/kadb/core/AdbReader;", "adbWriter", "Lcom/flyfishxu/kadb/core/AdbWriter;", "closeable", "Ljava/io/Closeable;", "supportedFeatures", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "version", BuildConfig.f24315FLAVOR, "outboundMaxPayloadSize", "<init>", "(Lcom/flyfishxu/kadb/core/AdbReader;Lcom/flyfishxu/kadb/core/AdbWriter;Ljava/io/Closeable;Ljava/util/Set;II)V", "random", "Ljava/util/Random;", "messageQueue", "Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "delayedAckEnabled", BuildConfig.f24315FLAVOR, "open", "Lcom/flyfishxu/kadb/stream/AdbStream;", "destination", "supportsFeature", "feature", "featureSnapshot", "featureSnapshot$com_github_IndiTheo_kadb", "newId", "ensureEmpty", BuildConfig.f24315FLAVOR, "ensureEmpty$com_github_IndiTheo_kadb", "Lorg/jetbrains/annotations/TestOnly;", "close", "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbConnection implements AutoCloseable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdbWriter adbWriter;
    private final Closeable closeable;
    private final boolean delayedAckEnabled;
    private final AdbMessageQueue messageQueue;
    private final int outboundMaxPayloadSize;
    private final Random random;
    private final Set<String> supportedFeatures;
    private final int version;

    @Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0012JP\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¨\u0006\u001f"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbConnection$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "connect", "Lkotlin/Pair;", "Lcom/flyfishxu/kadb/core/AdbConnection;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "host", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "hostKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "connectTimeoutMs", "ioTimeoutMs", "(Ljava/lang/String;ILcom/flyfishxu/kadb/cert/HostKeySet;Lcom/flyfishxu/kadb/KadbOptions;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "(Ljava/lang/String;ILcom/flyfishxu/kadb/cert/AdbKeyPair;Lcom/flyfishxu/kadb/KadbOptions;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseConnectionString", "Lcom/flyfishxu/kadb/core/AdbConnection$Companion$ConnectionString;", "connectionString", "decodeOkayAckBytes", "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "delayedAckEnabled", BuildConfig.f24315FLAVOR, "ConnectionString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nAdbConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbConnection.kt\ncom/flyfishxu/kadb/core/AdbConnection$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,306:1\n1#2:307\n1739#3:308\n1814#3,3:309\n777#3:312\n873#3,2:313\n*S KotlinDebug\n*F\n+ 1 AdbConnection.kt\ncom/flyfishxu/kadb/core/AdbConnection$Companion\n*L\n267#1:308\n267#1:309,3\n268#1:312\n268#1:313,2\n*E\n"})
    public static final class Companion {

        @Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbConnection$Companion$ConnectionString;", BuildConfig.f24315FLAVOR, "features", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "<init>", "(Ljava/util/Set;)V", "getFeatures", "()Ljava/util/Set;", "component1", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        public static final /* data */ class ConnectionString {
            private final Set<String> features;

            public ConnectionString(Set<String> features) {
                Intrinsics.checkNotNullParameter(features, "features");
                this.features = features;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ConnectionString copy$default(ConnectionString connectionString, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = connectionString.features;
                }
                return connectionString.m2206copy(set);
            }

            public final Set<String> component1() {
                return this.features;
            }

            /* renamed from: copy */
            public final ConnectionString m2206copy(Set<String> features) {
                Intrinsics.checkNotNullParameter(features, "features");
                return new ConnectionString(features);
            }

            /* renamed from: equals */
            public boolean m2207equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConnectionString) && Intrinsics.areEqual(this.features, ((ConnectionString) other).features);
            }

            public final Set<String> getFeatures() {
                return this.features;
            }

            public int hashCode() {
                return this.features.hashCode();
            }

            public String toString() {
                return "ConnectionString(features=" + this.features + ")";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int decodeOkayAckBytes(AdbMessage message, boolean delayedAckEnabled) throws IOException {
            if (message.getCommand() != 1497451343) {
                throw new IllegalArgumentException(("Expected OKAY message, got " + message.getCommand()).toString());
            }
            int payloadLength = message.getPayloadLength();
            if (payloadLength == 0) {
                if (!delayedAckEnabled) {
                    return 0;
                }
                String string = Integer.toString(message.getArg1(), C1302CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new IOException("Delayed ACK stream missing OKAY payload for localId: " + string);
            }
            if (payloadLength != 4) {
                throw new IOException("Invalid OKAY payload size: " + message.getPayloadLength());
            }
            if (delayedAckEnabled) {
                return new C5052Buffer().mo14230write(message.getPayload()).readIntLe();
            }
            throw new IOException("Unexpected OKAY payload for non-delayed-ack stream: " + message.getPayloadLength());
        }

        private final ConnectionString parseConnectionString(String connectionString) {
            int iIndexOf$default;
            List listSplit$default = StringsKt.split$default((CharSequence) connectionString, new String[]{":"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() <= 2) {
                return new ConnectionString(C1159SetsKt.emptySet());
            }
            Set setEmptySet = C1159SetsKt.emptySet();
            for (String str : StringsKt.split$default((CharSequence) listSplit$default.get(2), new String[]{";"}, false, 0, 6, (Object) null)) {
                if (str.length() != 0 && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '=', 0, false, 6, (Object) null)) > 0 && iIndexOf$default != StringsKt.getLastIndex(str)) {
                    String strSubstring = str.substring(0, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    String strSubstring2 = str.substring(iIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    if (Intrinsics.areEqual(strSubstring, "features")) {
                        List listSplit$default2 = StringsKt.split$default((CharSequence) strSubstring2, new String[]{","}, false, 0, 6, (Object) null);
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
                        Iterator it = listSplit$default2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(StringsKt.m6778trim((CharSequence) it.next()).toString());
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : arrayList) {
                            if (((String) obj).length() > 0) {
                                arrayList2.add(obj);
                            }
                        }
                        setEmptySet = CollectionsKt.m5900toSet(arrayList2);
                    }
                }
            }
            return new ConnectionString(setEmptySet);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x016a, code lost:
        
            if (r6 == 1314410051) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x016f, code lost:
        
            if (r6 != 1397511251) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0171, code lost:
        
            r1.writeStls(16777216);
            r6 = com.flyfishxu.p028kadb.p033pair.SslUtils.INSTANCE;
            r7 = r6.getSslContext(r13);
            r6 = r6.newClientEngine(r7, r14, r0);
            r22 = r8;
            r8 = new com.flyfishxu.p028kadb.transport.TlsNioChannel(r3, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0187, code lost:
        
            r9 = java.util.concurrent.TimeUnit.MILLISECONDS;
            r5.f2039L$0 = r14;
            r5.f2040L$1 = r13;
            r24 = r14;
            r5.f2043L$2 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
            r5.f2044L$3 = r3;
            r5.f2045L$4 = r15;
            r5.f2046L$5 = r1;
            r5.f2047L$6 = r11;
            r5.f2048L$7 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r19);
            r5.f2049L$8 = r2;
            r5.f2050L$9 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r7);
            r5.f2041L$10 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r6);
            r5.f2042L$11 = r8;
            r5.f2033I$0 = r0;
            r5.f2034I$1 = r10;
            r5.f2035I$2 = r4;
            r5.f2037J$0 = r22;
            r22 = r22;
            r6 = r20;
            r5.f2038J$1 = r6;
            r14 = r18;
            r5.f2036I$3 = r14;
            r18 = r0;
            r5.f2051label = 2;
            r0 = r8.handshake(r6, r9, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x01d0, code lost:
        
            r9 = r17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x01d2, code lost:
        
            if (r0 != r9) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x01d4, code lost:
        
            return r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x01d5, code lost:
        
            r0 = r18;
            r18 = r14;
            r14 = r2;
            r2 = r1;
            r1 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x022a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x022b, code lost:
        
            r2 = r1;
            r1 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0252, code lost:
        
            throw new java.io.IOException("Connection failed: " + r2.f5202element);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0253, code lost:
        
            r22 = p094kotlin.collections.CollectionsKt.intersect(parseConnectionString(new java.lang.String(((com.flyfishxu.p028kadb.p030core.AdbMessage) r2.f5202element).getPayload(), p094kotlin.p117text.Charsets.UTF_8)).getFeatures(), r11);
            r0 = java.lang.Math.min(((com.flyfishxu.p028kadb.p030core.AdbMessage) r2.f5202element).getArg0(), 16777217);
            r1.updateProtocolVersion(r0);
            r2 = ((com.flyfishxu.p028kadb.p030core.AdbMessage) r2.f5202element).getArg1();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x028a, code lost:
        
            if (r2 <= 0) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x028c, code lost:
        
            r2 = p094kotlin.p112ranges.RangesKt.coerceAtMost(p094kotlin.p112ranges.RangesKt.coerceAtLeast(java.lang.Math.min(r2, 1048576), 1), 1048576);
            r15.setInboundMaxPayloadSize(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x02b3, code lost:
        
            return p094kotlin.TuplesKt.m5076to(new com.flyfishxu.p028kadb.p030core.AdbConnection(r15, r1, r3, r22, r0, r2), r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x02ca, code lost:
        
            throw new java.io.IOException("Peer maxdata must be > 0: " + r2);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0167 A[EDGE_INSN: B:119:0x0167->B:30:0x0167 BREAK  A[LOOP:0: B:28:0x015a->B:80:0x030f], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x02cb A[Catch: all -> 0x0237, TryCatch #7 {all -> 0x0237, blocks: (B:28:0x015a, B:34:0x0171, B:66:0x023a, B:67:0x0252, B:68:0x0253, B:70:0x028c, B:72:0x02b4, B:73:0x02ca, B:74:0x02cb, B:76:0x02e7, B:78:0x02f3, B:80:0x030f, B:79:0x0302, B:81:0x0325, B:82:0x0341, B:25:0x0124, B:26:0x0142, B:27:0x0146, B:84:0x0343, B:85:0x034a), top: B:107:0x0124, inners: #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
        /* JADX WARN: Type inference failed for: r0v38, types: [T, com.flyfishxu.kadb.core.AdbMessage] */
        /* JADX WARN: Type inference failed for: r2v25, types: [T, com.flyfishxu.kadb.core.AdbMessage] */
        /* JADX WARN: Type inference failed for: r8v2, types: [T, com.flyfishxu.kadb.core.AdbMessage] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01d5 -> B:93:0x01dc). Please report as a decompilation issue!!! */
        /* renamed from: connect */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object m2205connect(String str, int i, HostKeySet hostKeySet, KadbOptions kadbOptions, int i2, int i3, Continuation<? super C1122Pair<AdbConnection, ? extends TransportChannel>> continuation) {
            AdbConnection$Companion$connect$1 adbConnection$Companion$connect$1;
            int i4;
            int i5;
            long j;
            int i6;
            HostKeySet hostKeySet2;
            KadbOptions kadbOptions2;
            String str2;
            long j2;
            TransportChannel transportChannel;
            AdbReader adbReader;
            int i7;
            int i8;
            AdbConnection$Companion$connect$1 adbConnection$Companion$connect$12;
            long j3;
            AdbWriter adbWriter;
            Set set;
            byte[] bArrConnectPayload;
            C1235Ref.ObjectRef objectRef;
            int i9;
            byte[] bArr;
            long j4;
            C1235Ref.ObjectRef objectRef2;
            int i10;
            AdbConnection$Companion$connect$1 adbConnection$Companion$connect$13;
            int i11;
            Object obj;
            long j5;
            Set set2;
            int i12;
            AdbWriter adbWriter2;
            int command;
            int i13;
            long j6;
            String str3;
            Object obj2;
            int i14;
            long j7;
            int i15;
            AdbReader adbReader2;
            int i16;
            int i17;
            int i18 = i3;
            if (continuation instanceof AdbConnection$Companion$connect$1) {
                adbConnection$Companion$connect$1 = (AdbConnection$Companion$connect$1) continuation;
                int i19 = adbConnection$Companion$connect$1.f2051label;
                if ((i19 & Integer.MIN_VALUE) != 0) {
                    adbConnection$Companion$connect$1.f2051label = i19 - Integer.MIN_VALUE;
                } else {
                    adbConnection$Companion$connect$1 = new AdbConnection$Companion$connect$1(this, continuation);
                }
            }
            Object obj3 = adbConnection$Companion$connect$1.f2052result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i20 = adbConnection$Companion$connect$1.f2051label;
            try {
                try {
                    if (i20 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        long j8 = i2;
                        long j9 = i18;
                        TransportFactory transportFactory = TransportFactory.INSTANCE;
                        adbConnection$Companion$connect$1.f2039L$0 = str;
                        adbConnection$Companion$connect$1.f2040L$1 = hostKeySet;
                        adbConnection$Companion$connect$1.f2043L$2 = kadbOptions;
                        adbConnection$Companion$connect$1.f2033I$0 = i;
                        adbConnection$Companion$connect$1.f2034I$1 = i2;
                        adbConnection$Companion$connect$1.f2035I$2 = i18;
                        adbConnection$Companion$connect$1.f2037J$0 = j8;
                        adbConnection$Companion$connect$1.f2038J$1 = j9;
                        adbConnection$Companion$connect$1.f2036I$3 = 0;
                        adbConnection$Companion$connect$1.f2051label = 1;
                        Object objM2354connect = transportFactory.m2354connect(str, i, j8, adbConnection$Companion$connect$1);
                        if (objM2354connect == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i4 = i;
                        i5 = i2;
                        j = j8;
                        i6 = 0;
                        hostKeySet2 = hostKeySet;
                        kadbOptions2 = kadbOptions;
                        str2 = str;
                        obj3 = objM2354connect;
                        j2 = j9;
                    } else if (i20 == 1) {
                        i6 = adbConnection$Companion$connect$1.f2036I$3;
                        j2 = adbConnection$Companion$connect$1.f2038J$1;
                        j = adbConnection$Companion$connect$1.f2037J$0;
                        i18 = adbConnection$Companion$connect$1.f2035I$2;
                        i5 = adbConnection$Companion$connect$1.f2034I$1;
                        i4 = adbConnection$Companion$connect$1.f2033I$0;
                        kadbOptions2 = (KadbOptions) adbConnection$Companion$connect$1.f2043L$2;
                        hostKeySet2 = (HostKeySet) adbConnection$Companion$connect$1.f2040L$1;
                        str2 = (String) adbConnection$Companion$connect$1.f2039L$0;
                        ResultKt.throwOnFailure(obj3);
                    } else {
                        if (i20 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i21 = adbConnection$Companion$connect$1.f2036I$3;
                        long j10 = adbConnection$Companion$connect$1.f2038J$1;
                        long j11 = adbConnection$Companion$connect$1.f2037J$0;
                        int i22 = adbConnection$Companion$connect$1.f2035I$2;
                        int i23 = adbConnection$Companion$connect$1.f2034I$1;
                        int i24 = adbConnection$Companion$connect$1.f2033I$0;
                        TlsNioChannel tlsNioChannel = (TlsNioChannel) adbConnection$Companion$connect$1.f2042L$11;
                        C1235Ref.ObjectRef objectRef3 = (C1235Ref.ObjectRef) adbConnection$Companion$connect$1.f2049L$8;
                        byte[] bArr2 = (byte[]) adbConnection$Companion$connect$1.f2048L$7;
                        Set set3 = (Set) adbConnection$Companion$connect$1.f2047L$6;
                        AdbWriter adbWriter3 = (AdbWriter) adbConnection$Companion$connect$1.f2046L$5;
                        AdbReader adbReader3 = (AdbReader) adbConnection$Companion$connect$1.f2045L$4;
                        TransportChannel transportChannel2 = (TransportChannel) adbConnection$Companion$connect$1.f2044L$3;
                        KadbOptions kadbOptions3 = (KadbOptions) adbConnection$Companion$connect$1.f2043L$2;
                        HostKeySet hostKeySet3 = (HostKeySet) adbConnection$Companion$connect$1.f2040L$1;
                        String str4 = (String) adbConnection$Companion$connect$1.f2039L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            i9 = i21;
                            transportChannel = transportChannel2;
                            String str5 = str4;
                            long j12 = j11;
                            int i25 = i24;
                            TlsNioChannel tlsNioChannel2 = tlsNioChannel;
                            bArr = bArr2;
                            AdbReader adbReader4 = adbReader3;
                            kadbOptions2 = kadbOptions3;
                            long j13 = j10;
                            i11 = i23;
                            Object obj4 = coroutine_suspended;
                            set2 = set3;
                            hostKeySet2 = hostKeySet3;
                            adbConnection$Companion$connect$13 = adbConnection$Companion$connect$1;
                            i12 = i22;
                            adbWriter2 = adbWriter3;
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                objectRef3.f5202element = adbReader.readMessage();
                                                i10 = i16;
                                                i12 = i17;
                                                j4 = j13;
                                                transportChannel = tlsNioChannel2;
                                                obj = obj4;
                                                objectRef2 = objectRef3;
                                                j5 = j12;
                                                str2 = str5;
                                                while (true) {
                                                    command = ((AdbMessage) objectRef2.f5202element).getCommand();
                                                    if (command != 1213486401) {
                                                        break;
                                                    }
                                                    i13 = i10;
                                                    j6 = j5;
                                                    str3 = str2;
                                                    obj2 = obj;
                                                    i14 = i9;
                                                    j7 = j4;
                                                    i15 = i12;
                                                    if (((AdbMessage) objectRef2.f5202element).getArg0() != 1) {
                                                        throw new IllegalStateException(("Unsupported auth type: " + objectRef2.f5202element).toString());
                                                    }
                                                    AdbKeyPair adbKeyPair = (AdbKeyPair) CollectionsKt.getOrNull(hostKeySet2.getKeyPairs(), i14);
                                                    if (adbKeyPair != null) {
                                                        i14++;
                                                        adbWriter.writeAuth(2, adbKeyPair.signPayload$com_github_IndiTheo_kadb((AdbMessage) objectRef2.f5202element));
                                                    } else {
                                                        adbWriter.writeAuth(3, AdbConnectionKt.adbPublicKey(hostKeySet2.getDefaultKeyPair()));
                                                    }
                                                    objectRef2.f5202element = adbReader.readMessage();
                                                    j4 = j7;
                                                    i9 = i14;
                                                    i10 = i13;
                                                    i12 = i15;
                                                    str2 = str3;
                                                    obj = obj2;
                                                    j5 = j6;
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                adbReader = adbReader4;
                                                adbWriter = adbWriter2;
                                                try {
                                                    adbReader.close();
                                                } catch (Throwable unused) {
                                                }
                                                try {
                                                    adbWriter.close();
                                                } catch (Throwable unused2) {
                                                }
                                                try {
                                                    transportChannel.close();
                                                    throw th;
                                                } catch (Throwable unused3) {
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            transportChannel = tlsNioChannel2;
                                            adbReader.close();
                                            adbWriter.close();
                                            transportChannel.close();
                                            throw th;
                                        }
                                        adbWriter = new AdbWriter(OkioAdaptersKt.asOkioSink(tlsNioChannel2, j13));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        adbWriter = adbWriter2;
                                        transportChannel = tlsNioChannel2;
                                        adbReader.close();
                                        adbWriter.close();
                                        transportChannel.close();
                                        throw th;
                                    }
                                    adbReader = new AdbReader(OkioAdaptersKt.asOkioSource(tlsNioChannel2, j13), 0, 2, null);
                                } catch (Throwable th4) {
                                    th = th4;
                                    adbReader = adbReader2;
                                    adbWriter = adbWriter2;
                                    transportChannel = tlsNioChannel2;
                                    adbReader.close();
                                    adbWriter.close();
                                    transportChannel.close();
                                    throw th;
                                }
                                i16 = i25;
                                adbReader2 = adbReader4;
                                i17 = i12;
                            } catch (Throwable th5) {
                                th = th5;
                                adbReader2 = adbReader4;
                            }
                            adbReader4.close();
                            adbWriter2.close();
                        } catch (Throwable th6) {
                            Throwable th7 = th6;
                            adbWriter2 = adbWriter3;
                            adbReader = adbReader3;
                            TransportChannel transportChannel3 = transportChannel2;
                            try {
                                throw TlsErrorMapper.INSTANCE.m2348map(th7);
                            } catch (Throwable th8) {
                                th = th8;
                                transportChannel = transportChannel3;
                                adbWriter = adbWriter2;
                                adbReader.close();
                                adbWriter.close();
                                transportChannel.close();
                                throw th;
                            }
                        }
                    }
                    objectRef.f5202element = adbReader.readMessage();
                    i9 = i7;
                    bArr = bArrConnectPayload;
                    j4 = j2;
                    objectRef2 = objectRef;
                    i10 = i4;
                    adbConnection$Companion$connect$13 = adbConnection$Companion$connect$12;
                    i11 = i5;
                    obj = coroutine_suspended;
                    j5 = j3;
                    set2 = set;
                    i12 = i8;
                    while (true) {
                        command = ((AdbMessage) objectRef2.f5202element).getCommand();
                        if (command != 1213486401) {
                        }
                        objectRef2.f5202element = adbReader.readMessage();
                        j4 = j7;
                        i9 = i14;
                        i10 = i13;
                        i12 = i15;
                        str2 = str3;
                        obj = obj2;
                        j5 = j6;
                    }
                } catch (SSLProtocolException e) {
                    throw TlsErrorMapper.INSTANCE.m2348map(e);
                }
                AdbProtocol adbProtocol = AdbProtocol.INSTANCE;
                set = CollectionsKt.m5900toSet(adbProtocol.connectFeatures(kadbOptions2.getDelayedAckMode()));
                bArrConnectPayload = adbProtocol.connectPayload(CollectionsKt.m5899toList(set));
                adbWriter.writeConnect(bArrConnectPayload);
                objectRef = new C1235Ref.ObjectRef();
            } catch (Throwable th9) {
                th = th9;
                adbReader.close();
                adbWriter.close();
                transportChannel.close();
                throw th;
            }
            transportChannel = (TransportChannel) obj3;
            i7 = i6;
            i8 = i18;
            adbConnection$Companion$connect$12 = adbConnection$Companion$connect$1;
            j3 = j;
            adbReader = new AdbReader(OkioAdaptersKt.asOkioSource(transportChannel, j2), 0, 2, null);
            adbWriter = new AdbWriter(OkioAdaptersKt.asOkioSink(transportChannel, j2));
        }

        private Companion() {
        }

        /* renamed from: connect */
        public final Object m2204connect(String str, int i, AdbKeyPair adbKeyPair, KadbOptions kadbOptions, int i2, int i3, Continuation<? super C1122Pair<AdbConnection, ? extends TransportChannel>> continuation) {
            return m2205connect(str, i, HostKeySet.INSTANCE.m2179single(adbKeyPair), kadbOptions, i2, i3, continuation);
        }
    }

    public AdbConnection(AdbReader adbReader, AdbWriter adbWriter, Closeable closeable, Set<String> supportedFeatures, int i, int i2) {
        Intrinsics.checkNotNullParameter(adbReader, "adbReader");
        Intrinsics.checkNotNullParameter(adbWriter, "adbWriter");
        Intrinsics.checkNotNullParameter(supportedFeatures, "supportedFeatures");
        this.adbWriter = adbWriter;
        this.closeable = closeable;
        this.supportedFeatures = supportedFeatures;
        this.version = i;
        this.outboundMaxPayloadSize = i2;
        this.random = new Random();
        this.messageQueue = new AdbMessageQueue(adbReader);
        this.delayedAckEnabled = supportedFeatures.contains(AdbProtocol.FEATURE_DELAYED_ACK);
    }

    /* renamed from: newId */
    private final int m2202newId() {
        int iNextInt;
        do {
            iNextInt = this.random.nextInt();
        } while (iNextInt == 0);
        return iNextInt;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            this.messageQueue.close();
            this.adbWriter.close();
            Closeable closeable = this.closeable;
            if (closeable != null) {
                closeable.close();
            }
        } catch (Throwable unused) {
        }
    }

    public final void ensureEmpty$com_github_IndiTheo_kadb() {
        this.messageQueue.ensureEmpty();
    }

    public final Set<String> featureSnapshot$com_github_IndiTheo_kadb() {
        return CollectionsKt.m5900toSet(this.supportedFeatures);
    }

    /* renamed from: open */
    public final AdbStream m2203open(String destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        int iM2202newId = m2202newId();
        this.messageQueue.startListening(iM2202newId);
        try {
            this.adbWriter.writeOpen(iM2202newId, destination, this.delayedAckEnabled ? AdbProtocol.INITIAL_DELAYED_ACK_BYTES : 0);
            return new AdbStream(this.messageQueue, this.adbWriter, this.outboundMaxPayloadSize, iM2202newId, this.messageQueue.m2284take(iM2202newId, AdbProtocol.CMD_OKAY).getArg0(), this.delayedAckEnabled, INSTANCE.decodeOkayAckBytes(r11, this.delayedAckEnabled));
        } catch (Throwable th) {
            this.messageQueue.stopListening(iM2202newId);
            throw th;
        }
    }

    public final boolean supportsFeature(String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return this.supportedFeatures.contains(feature);
    }
}
