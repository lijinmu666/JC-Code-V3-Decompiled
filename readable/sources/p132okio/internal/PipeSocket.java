package p132okio.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p132okio.C5056Pipe;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5061Socket;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m4988d2 = {"Lokio/internal/PipeSocket;", "Lokio/Socket;", "sinkPipe", "Lokio/Pipe;", "sourcePipe", "<init>", "(Lokio/Pipe;Lokio/Pipe;)V", "getSinkPipe", "()Lokio/Pipe;", "getSourcePipe", "source", "Lokio/Source;", "getSource", "()Lokio/Source;", "sink", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "cancel", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PipeSocket implements InterfaceC5061Socket {
    private final C5056Pipe sinkPipe;
    private final C5056Pipe sourcePipe;

    public PipeSocket(C5056Pipe sinkPipe, C5056Pipe sourcePipe) {
        Intrinsics.checkNotNullParameter(sinkPipe, "sinkPipe");
        Intrinsics.checkNotNullParameter(sourcePipe, "sourcePipe");
        this.sinkPipe = sinkPipe;
        this.sourcePipe = sourcePipe;
    }

    @Override // p132okio.InterfaceC5061Socket
    /* renamed from: cancel */
    public void mo14386cancel() {
        this.sourcePipe.m14371cancel();
        this.sinkPipe.m14371cancel();
    }

    @Override // p132okio.InterfaceC5061Socket
    /* renamed from: getSink */
    public InterfaceC5060Sink mo14387getSink() {
        return this.sinkPipe.m14374sink();
    }

    public final C5056Pipe getSinkPipe() {
        return this.sinkPipe;
    }

    @Override // p132okio.InterfaceC5061Socket
    public InterfaceC5062Source getSource() {
        return this.sourcePipe.m14375source();
    }

    public final C5056Pipe getSourcePipe() {
        return this.sourcePipe;
    }
}
