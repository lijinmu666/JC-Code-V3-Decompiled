package org.bouncycastle.p194crypto.p199digests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NullDigest implements InterfaceC5277Digest {

    /* renamed from: bOut */
    private OpenByteArrayOutputStream f19473bOut = new OpenByteArrayOutputStream();

    public static class OpenByteArrayOutputStream extends ByteArrayOutputStream {
        private OpenByteArrayOutputStream() {
        }

        /* renamed from: copy */
        public void m15110copy(byte[] bArr, int i) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i, size());
        }

        @Override // java.io.ByteArrayOutputStream
        public void reset() {
            super.reset();
            C6238Arrays.m18227clear(((ByteArrayOutputStream) this).buf);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        int size = this.f19473bOut.size();
        this.f19473bOut.m15110copy(bArr, i);
        mo14968reset();
        return size;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "NULL";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.f19473bOut.size();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19473bOut.reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) throws IOException {
        this.f19473bOut.write(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) throws IOException {
        this.f19473bOut.write(bArr, i, i2);
    }
}
