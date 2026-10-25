package p132okio;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0011R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0012"}, m4988d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "()Lokio/Source;", "read", BuildConfig.f24315FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "close", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "-deprecated_delegate", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class ForwardingSource implements InterfaceC5062Source {
    private final InterfaceC5062Source delegate;

    public ForwardingSource(InterfaceC5062Source delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", m5048imports = {}))
    @InterfaceC1231JvmName(m6260name = "-deprecated_delegate")
    /* renamed from: -deprecated_delegate, reason: not valid java name and from getter */
    public final InterfaceC5062Source getDelegate() {
        return this.delegate;
    }

    @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @InterfaceC1231JvmName(m6260name = "delegate")
    public final InterfaceC5062Source delegate() {
        return this.delegate;
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: read */
    public long mo2305read(C5052Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.mo2305read(sink, byteCount);
    }

    @Override // p132okio.InterfaceC5062Source
    /* renamed from: timeout */
    public C5065Timeout getTimeout() {
        return this.delegate.getTimeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
