package com.indidevs.p086android.p087adbeesh.internal.connection;

import com.flyfishxu.p028kadb.C0187Kadb;
import com.flyfishxu.p028kadb.p035shell.AdbShellResponse;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbShellResult;
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
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.Dispatchers;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/connection/AdbSessionImpl;", "Lcom/indidevs/android/adbeesh/runtime/AdbSession;", "kadb", "Lcom/flyfishxu/kadb/Kadb;", "<init>", "(Lcom/flyfishxu/kadb/Kadb;)V", "getKadb", "()Lcom/flyfishxu/kadb/Kadb;", "shell", "Lcom/indidevs/android/adbeesh/runtime/AdbShellResult;", "command", BuildConfig.f24315FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAlive", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", BuildConfig.f24315FLAVOR, "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbSessionImpl implements AdbSession {
    private final C0187Kadb kadb;

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.connection.AdbSessionImpl$isAlive$2", m6124f = "AdbSessionImpl.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: com.indidevs.android.adbeesh.internal.connection.AdbSessionImpl$isAlive$2 */
    public static final class C08942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: label */
        int f4115label;

        public C08942(Continuation<? super C08942> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbSessionImpl.this.new C08942(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f4115label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(AdbSessionImpl.this.getKadb().connectionCheck());
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C08942) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "Lcom/indidevs/android/adbeesh/runtime/AdbShellResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.connection.AdbSessionImpl$shell$2", m6124f = "AdbSessionImpl.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nAdbSessionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbSessionImpl.kt\ncom/indidevs/android/adbeesh/internal/connection/AdbSessionImpl$shell$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.internal.connection.AdbSessionImpl$shell$2 */
    public static final class C08952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdbShellResult>, Object> {
        final /* synthetic */ String $command;

        /* renamed from: label */
        int f4117label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08952(String str, Continuation<? super C08952> continuation) {
            super(2, continuation);
            this.$command = str;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbSessionImpl.this.new C08952(this.$command, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f4117label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AdbShellResponse adbShellResponseM2162shell = AdbSessionImpl.this.getKadb().m2162shell(this.$command);
            int exitCode = adbShellResponseM2162shell.getExitCode();
            String output = adbShellResponseM2162shell.getOutput();
            String errorOutput = adbShellResponseM2162shell.getErrorOutput();
            if (errorOutput.length() <= 0) {
                errorOutput = null;
            }
            return new AdbShellResult(exitCode, output, errorOutput);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super AdbShellResult> continuation) {
            return ((C08952) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public AdbSessionImpl(C0187Kadb kadb) {
        Intrinsics.checkNotNullParameter(kadb, "kadb");
        this.kadb = kadb;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            getKadb().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession
    public C0187Kadb getKadb() {
        return this.kadb;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession
    /* renamed from: isAlive */
    public Object mo4315isAlive(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.m6975getIO(), new C08942(null), continuation);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession
    /* renamed from: shell */
    public Object mo4316shell(String str, Continuation<? super AdbShellResult> continuation) {
        return BuildersKt.withContext(Dispatchers.m6975getIO(), new C08952(str, null), continuation);
    }
}
