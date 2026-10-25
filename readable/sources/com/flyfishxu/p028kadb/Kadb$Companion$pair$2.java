package com.flyfishxu.p028kadb;

import com.flyfishxu.p028kadb.p029cert.CertUtils;
import com.flyfishxu.p028kadb.p033pair.PairingConnectionCtx;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Charsets;
import p122kotlinx.coroutines.CoroutineScope;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.flyfishxu.kadb.Kadb$Companion$pair$2", m6124f = "Kadb.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6129nl = {}, m6130s = {}, m6131v = 2)
@SourceDebugExtension(m6344value = {"SMAP\nKadb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kadb.kt\ncom/flyfishxu/kadb/Kadb$Companion$pair$2\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,532:1\n72#2:533\n58#2,22:534\n*S KotlinDebug\n*F\n+ 1 Kadb.kt\ncom/flyfishxu/kadb/Kadb$Companion$pair$2\n*L\n480#1:533\n480#1:534,22\n*E\n"})
/* loaded from: classes.dex */
public final class Kadb$Companion$pair$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $host */
    final /* synthetic */ String f2008$host;

    /* renamed from: $name */
    final /* synthetic */ String f2009$name;
    final /* synthetic */ String $pairingCode;

    /* renamed from: $port */
    final /* synthetic */ int f2010$port;

    /* renamed from: label */
    int f2011label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kadb$Companion$pair$2(String str, int i, String str2, String str3, Continuation<? super Kadb$Companion$pair$2> continuation) {
        super(2, continuation);
        this.f2008$host = str;
        this.f2010$port = i;
        this.$pairingCode = str2;
        this.f2009$name = str3;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new Kadb$Companion$pair$2(this.f2008$host, this.f2010$port, this.$pairingCode, this.f2009$name, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2011label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.f2008$host;
        int i = this.f2010$port;
        byte[] bytes = this.$pairingCode.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        PairingConnectionCtx pairingConnectionCtx = new PairingConnectionCtx(str, i, bytes, CertUtils.INSTANCE.loadKeyPair(), this.f2009$name);
        try {
            pairingConnectionCtx.m2267start();
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            try {
                pairingConnectionCtx.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                pairingConnectionCtx.close();
            } catch (Throwable th3) {
                ExceptionsKt.addSuppressed(th, th3);
            }
        }
        if (th == null) {
            return C1133Unit.INSTANCE;
        }
        throw th;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((Kadb$Companion$pair$2) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
