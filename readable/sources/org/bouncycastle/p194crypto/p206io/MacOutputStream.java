package org.bouncycastle.p194crypto.p206io;

import java.io.OutputStream;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;

/* loaded from: classes2.dex */
public class MacOutputStream extends OutputStream {

    /* renamed from: mac */
    protected InterfaceC5278Mac f20362mac;

    public MacOutputStream(InterfaceC5278Mac interfaceC5278Mac) {
        this.f20362mac = interfaceC5278Mac;
    }

    /* renamed from: getMac */
    public byte[] m15555getMac() {
        byte[] bArr = new byte[this.f20362mac.getMacSize()];
        this.f20362mac.mo14975doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f20362mac.mo14978update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f20362mac.mo14979update(bArr, i, i2);
    }
}
