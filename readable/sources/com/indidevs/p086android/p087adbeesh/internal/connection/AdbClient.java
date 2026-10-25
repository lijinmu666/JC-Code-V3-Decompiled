package com.indidevs.p086android.p087adbeesh.internal.connection;

import android.util.Base64;
import android.util.Log;
import com.flyfishxu.p028kadb.C0187Kadb;
import com.flyfishxu.p028kadb.exception.AdbPairAuthException;
import com.flyfishxu.p028kadb.p029cert.KadbCert;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbAuthenticationException;
import com.indidevs.p086android.p087adbeesh.internal.security.KeyPair;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Charsets;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.Dispatchers;

@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/connection/AdbClient;", BuildConfig.f24315FLAVOR, "keyPair", "Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "deviceName", BuildConfig.f24315FLAVOR, "<init>", "(Lcom/indidevs/android/adbeesh/internal/security/KeyPair;Ljava/lang/String;)V", "ensureIdentity", BuildConfig.f24315FLAVOR, "pair", BuildConfig.f24315FLAVOR, "host", "port", BuildConfig.f24315FLAVOR, "code", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "Lcom/flyfishxu/kadb/Kadb;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPem", "type", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PEM_CERTIFICATE_TYPE = "CERTIFICATE";
    private static final String PEM_PRIVATE_KEY_TYPE = "PRIVATE KEY";

    /* renamed from: TAG */
    private static final String f4103TAG = "ADBeesh:Connection";
    private final String deviceName;
    private final KeyPair keyPair;

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/connection/AdbClient$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "TAG", BuildConfig.f24315FLAVOR, "PEM_PRIVATE_KEY_TYPE", "PEM_CERTIFICATE_TYPE", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "Lcom/flyfishxu/kadb/Kadb;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.connection.AdbClient$connect$2", m6124f = "AdbClient.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: com.indidevs.android.adbeesh.internal.connection.AdbClient$connect$2 */
    public static final class C08922 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C0187Kadb>, Object> {

        /* renamed from: $host */
        final /* synthetic */ String f4105$host;

        /* renamed from: $port */
        final /* synthetic */ int f4106$port;

        /* renamed from: label */
        int f4107label;

        /* renamed from: this$0 */
        final /* synthetic */ AdbClient f4108this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08922(String str, int i, AdbClient adbClient, Continuation<? super C08922> continuation) {
            super(2, continuation);
            this.f4105$host = str;
            this.f4106$port = i;
            this.f4108this$0 = adbClient;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C08922(this.f4105$host, this.f4106$port, this.f4108this$0, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f4107label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C0187Kadb c0187KadbCreate$default = C0187Kadb.Companion.create$default(C0187Kadb.INSTANCE, this.f4105$host, this.f4106$port, 0, 0, null, 28, null);
            try {
                this.f4108this$0.ensureIdentity();
                c0187KadbCreate$default.supportsFeature("shell_v2");
                return c0187KadbCreate$default;
            } catch (Exception e) {
                c0187KadbCreate$default.close();
                if ((e instanceof AdbPairAuthException) || (e instanceof SSLException)) {
                    throw new AdbAuthenticationException("ADB authentication failed during connection handshake. The identity may be stale or pairing might be revoked", e);
                }
                if (e instanceof IOException) {
                    return null;
                }
                throw e;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C0187Kadb> continuation) {
            return ((C08922) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.connection.AdbClient$pair$2", m6124f = "AdbClient.kt", m6125i = {}, m6126l = {C5125EACTags.LANGUAGE_PREFERENCES}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: com.indidevs.android.adbeesh.internal.connection.AdbClient$pair$2 */
    public static final class C08932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: $code */
        final /* synthetic */ String f4109$code;

        /* renamed from: $host */
        final /* synthetic */ String f4110$host;

        /* renamed from: $port */
        final /* synthetic */ int f4111$port;

        /* renamed from: label */
        int f4112label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08932(String str, int i, String str2, Continuation<? super C08932> continuation) {
            super(2, continuation);
            this.f4110$host = str;
            this.f4111$port = i;
            this.f4109$code = str2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbClient.this.new C08932(this.f4110$host, this.f4111$port, this.f4109$code, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v21 */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f4112label;
            boolean z = false;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AdbClient.this.ensureIdentity();
                    C0187Kadb.Companion companion = C0187Kadb.INSTANCE;
                    String str = this.f4110$host;
                    int i2 = this.f4111$port;
                    String str2 = this.f4109$code;
                    String str3 = AdbClient.this.deviceName;
                    this.f4112label = 1;
                    Object objM2165pair = companion.m2165pair(str, i2, str2, str3, this);
                    this = objM2165pair;
                    if (objM2165pair == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
                z = true;
            } catch (AdbPairAuthException unused) {
                Log.e(AdbClient.f4103TAG, '[' + AdbClient.this.deviceName + "] Pairing rejected by device (auth failure)");
            } catch (SSLException e) {
                Log.e(AdbClient.f4103TAG, '[' + AdbClient.this.deviceName + "] Pairing failed (TLS error)", e);
            } catch (IOException e2) {
                Log.e(AdbClient.f4103TAG, '[' + AdbClient.this.deviceName + "] Pairing failed (Network error)", e2);
            }
            return C1207Boxing.boxBoolean(z);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C08932) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public AdbClient(KeyPair keyPair, String deviceName) {
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.keyPair = keyPair;
        this.deviceName = deviceName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureIdentity() {
        try {
            String strM4311toPem = m4311toPem(this.keyPair.getPrivateKey(), "PRIVATE KEY");
            String strM4311toPem2 = m4311toPem(this.keyPair.getCertificate(), "CERTIFICATE");
            KadbCert kadbCert = KadbCert.INSTANCE;
            kadbCert.m2181clear();
            Charset charset = Charsets.UTF_8;
            byte[] bytes = strM4311toPem.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = strM4311toPem2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            kadbCert.importIdentity(bytes, bytes2);
        } catch (Exception e) {
            Log.e(f4103TAG, "Failed to import certificate/key PEM", e);
        }
    }

    /* renamed from: toPem */
    private final String m4311toPem(Object obj, String str) {
        byte[] encoded = obj instanceof Key ? ((Key) obj).getEncoded() : obj instanceof X509Certificate ? ((X509Certificate) obj).getEncoded() : null;
        if (encoded == null) {
            throw new IllegalArgumentException("Encoded data is null for " + str);
        }
        return "-----BEGIN " + str + "-----\n" + Base64.encodeToString(encoded, 0) + "-----END " + str + "-----\n";
    }

    /* renamed from: connect */
    public final Object m4312connect(String str, int i, Continuation<? super C0187Kadb> continuation) {
        return BuildersKt.withContext(Dispatchers.m6975getIO(), new C08922(str, i, this, null), continuation);
    }

    /* renamed from: pair */
    public final Object m4313pair(String str, int i, String str2, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.m6975getIO(), new C08932(str, i, str2, null), continuation);
    }
}
