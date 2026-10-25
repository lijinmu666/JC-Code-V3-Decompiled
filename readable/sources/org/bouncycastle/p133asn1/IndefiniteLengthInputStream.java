package org.bouncycastle.p133asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class IndefiniteLengthInputStream extends LimitedInputStream {

    /* renamed from: _b1 */
    private int f18001_b1;

    /* renamed from: _b2 */
    private int f18002_b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    public IndefiniteLengthInputStream(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this._eofReached = false;
        this._eofOn00 = true;
        this.f18001_b1 = inputStream.read();
        int i2 = inputStream.read();
        this.f18002_b2 = i2;
        if (i2 < 0) {
            throw new EOFException();
        }
        checkForEof();
    }

    private boolean checkForEof() {
        if (!this._eofReached && this._eofOn00 && this.f18001_b1 == 0 && this.f18002_b2 == 0) {
            this._eofReached = true;
            setParentEofDetect(true);
        }
        return this._eofReached;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (checkForEof()) {
            return -1;
        }
        int i = this.f18006_in.read();
        if (i < 0) {
            throw new EOFException();
        }
        int i2 = this.f18001_b1;
        this.f18001_b1 = this.f18002_b2;
        this.f18002_b2 = i;
        return i2;
    }

    public void setEofOn00(boolean z) {
        this._eofOn00 = z;
        checkForEof();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this._eofOn00 || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this._eofReached) {
            return -1;
        }
        int i3 = this.f18006_in.read(bArr, i + 2, i2 - 2);
        if (i3 < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.f18001_b1;
        bArr[i + 1] = (byte) this.f18002_b2;
        this.f18001_b1 = this.f18006_in.read();
        int i4 = this.f18006_in.read();
        this.f18002_b2 = i4;
        if (i4 >= 0) {
            return i3 + 2;
        }
        throw new EOFException();
    }
}
