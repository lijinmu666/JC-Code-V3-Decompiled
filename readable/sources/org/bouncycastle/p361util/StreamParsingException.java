package org.bouncycastle.p361util;

/* loaded from: classes2.dex */
public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f24207_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f24207_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f24207_e;
    }
}
