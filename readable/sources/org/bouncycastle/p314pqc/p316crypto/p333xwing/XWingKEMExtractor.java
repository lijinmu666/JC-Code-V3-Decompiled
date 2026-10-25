package org.bouncycastle.p314pqc.p316crypto.p333xwing;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.p207kems.MLKEMExtractor;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XWingKEMExtractor implements EncapsulatedSecretExtractor {
    private static final int MLKEM_CIPHERTEXT_SIZE = 1088;

    /* renamed from: key */
    private final XWingPrivateKeyParameters f23675key;
    private final MLKEMExtractor mlkemExtractor;

    public XWingKEMExtractor(XWingPrivateKeyParameters xWingPrivateKeyParameters) {
        this.f23675key = xWingPrivateKeyParameters;
        this.mlkemExtractor = new MLKEMExtractor(xWingPrivateKeyParameters.getKyberPrivateKey());
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, MLKEM_CIPHERTEXT_SIZE);
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, MLKEM_CIPHERTEXT_SIZE, bArr.length);
        byte[] bArrComputeSSX = XWingKEMGenerator.computeSSX(new X25519PublicKeyParameters(bArrCopyOfRange2, 0), this.f23675key.getXDHPrivateKey());
        byte[] bArrComputeSharedSecret = XWingKEMGenerator.computeSharedSecret(this.f23675key.getXDHPublicKey().getEncoded(), this.mlkemExtractor.extractSecret(bArrCopyOfRange), bArrCopyOfRange2, bArrComputeSSX);
        C6238Arrays.m18227clear(bArrComputeSSX);
        return bArrComputeSharedSecret;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.mlkemExtractor.getEncapsulationLength() + 32;
    }
}
