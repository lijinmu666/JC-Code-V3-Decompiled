package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.p030core.AdbReader;
import com.flyfishxu.p028kadb.p031debug.LoggingKt;
import java.io.IOException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.RangesKt;
import p132okio.BufferedSource;
import p132okio.C5053Okio;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbReader;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "source", "Lokio/Source;", "maxPayloadSize", BuildConfig.f24315FLAVOR, "<init>", "(Lokio/Source;I)V", "bufferedSource", "Lokio/BufferedSource;", "localHardCap", "inboundMaxPayloadSize", "setInboundMaxPayloadSize", BuildConfig.f24315FLAVOR, "readMessage", "Lcom/flyfishxu/kadb/core/AdbMessage;", "close", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbReader implements AutoCloseable {
    private final BufferedSource bufferedSource;
    private volatile int inboundMaxPayloadSize;
    private final int localHardCap;

    public AdbReader(InterfaceC5062Source source, int i) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.bufferedSource = C5053Okio.m14316buffer(source);
        int iCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 0), 1048576);
        this.localHardCap = iCoerceAtMost;
        this.inboundMaxPayloadSize = iCoerceAtMost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String readMessage$lambda$0$0$0$0(AdbMessage adbMessage) {
        return "(" + Thread.currentThread().getName() + ") < " + adbMessage;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.bufferedSource.close();
    }

    public final AdbMessage readMessage() {
        final AdbMessage adbMessage;
        synchronized (this.bufferedSource) {
            BufferedSource bufferedSource = this.bufferedSource;
            int intLe = bufferedSource.readIntLe();
            int intLe2 = bufferedSource.readIntLe();
            int intLe3 = bufferedSource.readIntLe();
            int intLe4 = bufferedSource.readIntLe();
            if (intLe4 < 0 || intLe4 > this.inboundMaxPayloadSize) {
                throw new IOException("Invalid ADB payload length: " + intLe4 + " (max=" + this.inboundMaxPayloadSize + ")");
            }
            int intLe5 = bufferedSource.readIntLe();
            int intLe6 = bufferedSource.readIntLe();
            int i = ~intLe;
            if (intLe6 != i) {
                throw new IOException("Invalid ADB magic: expected=" + i + " actual=" + intLe6 + " command=" + intLe);
            }
            adbMessage = new AdbMessage(intLe, intLe2, intLe3, intLe4, intLe5, intLe6, bufferedSource.readByteArray(intLe4));
            LoggingKt.m2214log(new Function0() { // from class: o.Ne
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Object mo4323invoke() {
                    return AdbReader.readMessage$lambda$0$0$0$0(adbMessage);
                }
            });
        }
        return adbMessage;
    }

    public final void setInboundMaxPayloadSize(int maxPayloadSize) {
        this.inboundMaxPayloadSize = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(maxPayloadSize, 0), 1048576);
    }

    public /* synthetic */ AdbReader(InterfaceC5062Source interfaceC5062Source, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC5062Source, (i2 & 2) != 0 ? 1048576 : i);
    }
}
