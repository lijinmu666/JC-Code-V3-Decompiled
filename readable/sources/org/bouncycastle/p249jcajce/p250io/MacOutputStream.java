package org.bouncycastle.p249jcajce.p250io;

import java.io.OutputStream;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class MacOutputStream extends OutputStream {

    /* renamed from: mac */
    private Mac f21378mac;

    public MacOutputStream(Mac mac) {
        this.f21378mac = mac;
    }

    /* renamed from: getMac */
    public byte[] m16084getMac() {
        return this.f21378mac.doFinal();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IllegalStateException {
        this.f21378mac.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IllegalStateException {
        this.f21378mac.update(bArr, i, i2);
    }
}
