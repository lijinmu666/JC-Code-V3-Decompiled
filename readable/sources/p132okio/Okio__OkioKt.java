package p132okio;

import java.io.Closeable;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\r\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0006\u001aN\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, m4988d2 = {"buffer", "Lokio/BufferedSource;", "Lokio/Source;", "Lokio/BufferedSink;", "Lokio/Sink;", "blackholeSink", "blackhole", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, m4989k = 5, m4990mv = {2, 1, 0}, m4992xi = 48, m4993xs = "okio/Okio")
/* loaded from: classes.dex */
final /* synthetic */ class Okio__OkioKt {
    @InterfaceC1231JvmName(m6260name = "blackhole")
    public static final InterfaceC5060Sink blackhole() {
        return new BlackholeSink();
    }

    /* renamed from: buffer */
    public static final BufferedSource m14340buffer(InterfaceC5062Source interfaceC5062Source) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        return new buffer(interfaceC5062Source);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* renamed from: use */
    public static final <T extends Closeable, R> R m14341use(T t, Function1<? super T, ? extends R> block) {
        ?? r4;
        Intrinsics.checkNotNullParameter(block, "block");
        R th = null;
        try {
            R rMo2237invoke = block.mo2237invoke(t);
            InlineMarker.finallyStart(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            InlineMarker.finallyEnd(1);
            R r = th;
            th = rMo2237invoke;
            r4 = r;
        } catch (Throwable th3) {
            InlineMarker.finallyStart(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            InlineMarker.finallyEnd(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    /* renamed from: buffer */
    public static final BufferedSink m14339buffer(InterfaceC5060Sink interfaceC5060Sink) {
        Intrinsics.checkNotNullParameter(interfaceC5060Sink, "<this>");
        return new buffer(interfaceC5060Sink);
    }
}
