package p132okio;

import java.io.EOFException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, m4988d2 = {"Lokio/BlackholeSink;", "Lokio/Sink;", "<init>", "()V", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "flush", "timeout", "Lokio/Timeout;", "close", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class BlackholeSink implements InterfaceC5060Sink {
    @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
    public void flush() {
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return C5065Timeout.f17852NONE;
    }

    @Override // p132okio.InterfaceC5060Sink
    /* renamed from: write */
    public void mo2303write(C5052Buffer source, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "source");
        source.mo14226skip(byteCount);
    }
}
