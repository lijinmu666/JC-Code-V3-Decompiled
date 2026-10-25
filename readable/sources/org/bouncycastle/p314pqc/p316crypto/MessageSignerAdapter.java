package org.bouncycastle.p314pqc.p316crypto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class MessageSignerAdapter implements InterfaceC5282Signer {

    /* renamed from: buffer */
    private final C6050Buffer f23057buffer = new C6050Buffer();
    private final MessageSigner messageSigner;

    /* renamed from: org.bouncycastle.pqc.crypto.MessageSignerAdapter$Buffer */
    public static final class C6050Buffer extends ByteArrayOutputStream {
        private C6050Buffer() {
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            C6238Arrays.m18250fill(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }
    }

    public MessageSignerAdapter(MessageSigner messageSigner) {
        if (messageSigner == null) {
            throw new NullPointerException("'messageSigner' cannot be null");
        }
        this.messageSigner = messageSigner;
    }

    private byte[] getMessage() {
        try {
            return this.f23057buffer.toByteArray();
        } finally {
            mo14988reset();
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        return this.messageSigner.generateSignature(getMessage());
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.messageSigner.mo15864init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f23057buffer.reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) throws IOException {
        this.f23057buffer.write(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        return this.messageSigner.verifySignature(getMessage(), bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) throws IOException {
        this.f23057buffer.write(bArr, i, i2);
    }
}
