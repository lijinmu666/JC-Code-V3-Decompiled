package org.bouncycastle.p194crypto.p217signers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Ed25519ctxSigner implements InterfaceC5282Signer {

    /* renamed from: buffer */
    private final C5383Buffer f20955buffer = new C5383Buffer();

    /* renamed from: context */
    private final byte[] f20956context;
    private boolean forSigning;
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    /* renamed from: org.bouncycastle.crypto.signers.Ed25519ctxSigner$Buffer */
    public static final class C5383Buffer extends ByteArrayOutputStream {
        private C5383Buffer() {
        }

        public synchronized byte[] generateSignature(Ed25519PrivateKeyParameters ed25519PrivateKeyParameters, byte[] bArr) {
            byte[] bArr2;
            bArr2 = new byte[64];
            ed25519PrivateKeyParameters.m15731sign(1, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr2, 0);
            reset();
            return bArr2;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            C6238Arrays.m18250fill(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }

        public synchronized boolean verifySignature(Ed25519PublicKeyParameters ed25519PublicKeyParameters, byte[] bArr, byte[] bArr2) {
            if (64 != bArr2.length) {
                reset();
                return false;
            }
            boolean zM15734verify = ed25519PublicKeyParameters.m15734verify(1, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr2, 0);
            reset();
            return zM15734verify;
        }
    }

    public Ed25519ctxSigner(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'context' cannot be null");
        }
        this.f20956context = C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        Ed25519PrivateKeyParameters ed25519PrivateKeyParameters;
        if (!this.forSigning || (ed25519PrivateKeyParameters = this.privateKey) == null) {
            throw new IllegalStateException("Ed25519ctxSigner not initialised for signature generation.");
        }
        return this.f20955buffer.generateSignature(ed25519PrivateKeyParameters, this.f20956context);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        Ed25519PublicKeyParameters ed25519PublicKeyParameters = null;
        if (z) {
            this.privateKey = (Ed25519PrivateKeyParameters) cipherParameters;
        } else {
            this.privateKey = null;
            ed25519PublicKeyParameters = (Ed25519PublicKeyParameters) cipherParameters;
        }
        this.publicKey = ed25519PublicKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties(EdDSAParameterSpec.f21918Ed25519, 128, cipherParameters, z));
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20955buffer.reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) throws IOException {
        this.f20955buffer.write(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        if (this.forSigning || (ed25519PublicKeyParameters = this.publicKey) == null) {
            throw new IllegalStateException("Ed25519ctxSigner not initialised for verification");
        }
        return this.f20955buffer.verifySignature(ed25519PublicKeyParameters, this.f20956context, bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) throws IOException {
        this.f20955buffer.write(bArr, i, i2);
    }
}
