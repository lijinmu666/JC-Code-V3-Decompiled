package org.bouncycastle.operator.p305bc;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSSigner;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSSigner;

/* loaded from: classes2.dex */
public class BcHssLmsContentSignerBuilder extends BcContentSignerBuilder {
    private static final AlgorithmIdentifier sigAlgId = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig);

    public static class HssSigner implements InterfaceC5282Signer {

        /* renamed from: signer */
        private MessageSigner f22879signer;

        /* renamed from: stream */
        private final ByteArrayOutputStream f22880stream = new ByteArrayOutputStream();

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        public byte[] generateSignature() {
            byte[] byteArray = this.f22880stream.toByteArray();
            this.f22880stream.reset();
            return this.f22879signer.generateSignature(byteArray);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        /* renamed from: init */
        public void mo14987init(boolean z, CipherParameters cipherParameters) {
            MessageSigner hSSSigner;
            if ((cipherParameters instanceof HSSPublicKeyParameters) || (cipherParameters instanceof HSSPrivateKeyParameters)) {
                hSSSigner = new HSSSigner();
            } else {
                if (!(cipherParameters instanceof LMSPublicKeyParameters) && !(cipherParameters instanceof LMSPrivateKeyParameters)) {
                    throw new IllegalArgumentException("Incorrect Key Parameters");
                }
                hSSSigner = new LMSSigner();
            }
            this.f22879signer = hSSSigner;
            this.f22879signer.mo15864init(z, cipherParameters);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        /* renamed from: reset */
        public void mo14988reset() {
            this.f22880stream.reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        /* renamed from: update */
        public void mo14989update(byte b) {
            this.f22880stream.write(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        public boolean verifySignature(byte[] bArr) {
            byte[] byteArray = this.f22880stream.toByteArray();
            this.f22880stream.reset();
            return this.f22879signer.verifySignature(byteArray, bArr);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
        /* renamed from: update */
        public void mo14990update(byte[] bArr, int i, int i2) {
            this.f22880stream.write(bArr, i, i2);
        }
    }

    public BcHssLmsContentSignerBuilder() {
        super(sigAlgId, null);
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentSignerBuilder
    public InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        return new HssSigner();
    }
}
