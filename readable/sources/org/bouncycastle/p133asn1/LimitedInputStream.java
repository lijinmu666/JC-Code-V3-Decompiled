package org.bouncycastle.p133asn1;

import java.io.InputStream;

/* loaded from: classes.dex */
abstract class LimitedInputStream extends InputStream {

    /* renamed from: _in */
    protected final InputStream f18006_in;

    /* renamed from: _limit */
    private int f18007_limit;

    public LimitedInputStream(InputStream inputStream, int i) {
        this.f18006_in = inputStream;
        this.f18007_limit = i;
    }

    public int getLimit() {
        return this.f18007_limit;
    }

    public void setParentEofDetect(boolean z) {
        InputStream inputStream = this.f18006_in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }
}
