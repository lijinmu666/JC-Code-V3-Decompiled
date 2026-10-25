package p132okio;

import java.io.Closeable;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m4988d2 = {"Lokio/Source;", "Ljava/io/Closeable;", "Lokio/Closeable;", "read", BuildConfig.f24315FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "close", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: okio.Source */
/* loaded from: classes.dex */
public interface InterfaceC5062Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    /* renamed from: read */
    long mo2305read(C5052Buffer sink, long byteCount);

    /* renamed from: timeout */
    C5065Timeout mo2306timeout();
}
