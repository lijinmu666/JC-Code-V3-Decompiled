package org.bouncycastle.p249jcajce.p250io;

import java.io.OutputStream;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
class DigestUpdatingOutputStream extends OutputStream {

    /* renamed from: digest */
    private MessageDigest f21377digest;

    public DigestUpdatingOutputStream(MessageDigest messageDigest) {
        this.f21377digest = messageDigest;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f21377digest.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f21377digest.update(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f21377digest.update(bArr, i, i2);
    }
}
