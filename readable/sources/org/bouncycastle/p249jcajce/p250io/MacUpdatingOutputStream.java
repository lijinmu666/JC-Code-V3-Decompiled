package org.bouncycastle.p249jcajce.p250io;

import java.io.OutputStream;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
class MacUpdatingOutputStream extends OutputStream {

    /* renamed from: mac */
    private Mac f21379mac;

    public MacUpdatingOutputStream(Mac mac) {
        this.f21379mac = mac;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IllegalStateException {
        this.f21379mac.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IllegalStateException {
        this.f21379mac.update(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IllegalStateException {
        this.f21379mac.update(bArr, i, i2);
    }
}
