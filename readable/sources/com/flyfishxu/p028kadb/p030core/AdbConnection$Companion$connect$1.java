package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.KadbOptions;
import com.flyfishxu.p028kadb.p029cert.HostKeySet;
import com.flyfishxu.p028kadb.p030core.AdbConnection;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;

@Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.flyfishxu.kadb.core.AdbConnection$Companion", m6124f = "AdbConnection.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {111, 138}, m6127m = "connect", m6128n = {"host", "hostKeySet", "options", "port", "connectTimeoutMs", "ioTimeoutMs", "connectTimeout", "ioTimeout", "authKeyIndex", "host", "hostKeySet", "options", "channel", "reader", "writer", "advertisedFeatures", "connectPayload", "message", "sslContext", "engine", "tlsChannel", "port", "connectTimeoutMs", "ioTimeoutMs", "connectTimeout", "ioTimeout", "authKeyIndex"}, m6129nl = {112, 139}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "J$0", "J$1", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "J$0", "J$1", "I$3"}, m6131v = 2)
/* loaded from: classes.dex */
public final class AdbConnection$Companion$connect$1 extends ContinuationImpl {

    /* renamed from: I$0 */
    int f2033I$0;

    /* renamed from: I$1 */
    int f2034I$1;

    /* renamed from: I$2 */
    int f2035I$2;

    /* renamed from: I$3 */
    int f2036I$3;

    /* renamed from: J$0 */
    long f2037J$0;

    /* renamed from: J$1 */
    long f2038J$1;

    /* renamed from: L$0 */
    Object f2039L$0;

    /* renamed from: L$1 */
    Object f2040L$1;

    /* renamed from: L$10 */
    Object f2041L$10;

    /* renamed from: L$11 */
    Object f2042L$11;

    /* renamed from: L$2 */
    Object f2043L$2;

    /* renamed from: L$3 */
    Object f2044L$3;

    /* renamed from: L$4 */
    Object f2045L$4;

    /* renamed from: L$5 */
    Object f2046L$5;

    /* renamed from: L$6 */
    Object f2047L$6;

    /* renamed from: L$7 */
    Object f2048L$7;

    /* renamed from: L$8 */
    Object f2049L$8;

    /* renamed from: L$9 */
    Object f2050L$9;

    /* renamed from: label */
    int f2051label;

    /* renamed from: result */
    /* synthetic */ Object f2052result;

    /* renamed from: this$0 */
    final /* synthetic */ AdbConnection.Companion f2053this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbConnection$Companion$connect$1(AdbConnection.Companion companion, Continuation<? super AdbConnection$Companion$connect$1> continuation) {
        super(continuation);
        this.f2053this$0 = companion;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2052result = obj;
        this.f2051label |= Integer.MIN_VALUE;
        return this.f2053this$0.m2205connect((String) null, 0, (HostKeySet) null, (KadbOptions) null, 0, 0, this);
    }
}
