package com.flyfishxu.p028kadb.p035shell;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\nJ*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbPtyShellSession;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "shell", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "<init>", "(Lcom/flyfishxu/kadb/shell/AdbShellStream;)V", "read", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "write", BuildConfig.f24315FLAVOR, "input", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "closeStdin", "resize", "rows", BuildConfig.f24315FLAVOR, "cols", "xPixels", "yPixels", "close", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbPtyShellSession implements AutoCloseable {
    private final AdbShellStream shell;

    public AdbPtyShellSession(AdbShellStream shell) {
        Intrinsics.checkNotNullParameter(shell, "shell");
        this.shell = shell;
    }

    public static /* synthetic */ void resize$default(AdbPtyShellSession adbPtyShellSession, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        adbPtyShellSession.m2288resize(i, i2, i3, i4);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.shell.close();
    }

    public final void closeStdin() {
        this.shell.closeStdin();
    }

    /* renamed from: read */
    public final AdbShellPacket m2287read() {
        return this.shell.m2294read();
    }

    /* renamed from: resize */
    public final void m2288resize(int rows, int cols, int xPixels, int yPixels) {
        this.shell.m2296resize(rows, cols, xPixels, yPixels);
    }

    /* renamed from: write */
    public final void m2289write(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.shell.m2298write(input);
    }

    /* renamed from: write */
    public final void m2290write(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.shell.m2299write(input);
    }
}
