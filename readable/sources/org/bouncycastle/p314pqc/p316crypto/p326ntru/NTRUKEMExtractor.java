package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUKEMExtractor implements EncapsulatedSecretExtractor {
    private final NTRUPrivateKeyParameters ntruPrivateKey;

    public NTRUKEMExtractor(NTRUPrivateKeyParameters nTRUPrivateKeyParameters) {
        if (nTRUPrivateKeyParameters == null) {
            throw new NullPointerException("'ntruPrivateKey' cannot be null");
        }
        this.ntruPrivateKey = nTRUPrivateKeyParameters;
    }

    /* renamed from: cmov */
    private void m17756cmov(byte[] bArr, byte[] bArr2, byte b) {
        byte b2 = (byte) ((~b) + 1);
        for (int i = 0; i < bArr.length; i++) {
            byte b3 = bArr[i];
            bArr[i] = (byte) (b3 ^ ((bArr2[i] ^ b3) & b2));
        }
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        NTRUParameterSet parameterSet = this.ntruPrivateKey.getParameters().getParameterSet();
        if (bArr == null) {
            throw new NullPointerException("'encapsulation' cannot be null");
        }
        if (bArr.length != parameterSet.ntruCiphertextBytes()) {
            throw new IllegalArgumentException("encapsulation");
        }
        byte[] bArr2 = this.ntruPrivateKey.privateKey;
        OWCPADecryptResult oWCPADecryptResultM17759decrypt = new NTRUOWCPA(parameterSet).m17759decrypt(bArr, bArr2);
        byte[] bArr3 = oWCPADecryptResultM17759decrypt.f23385rm;
        int i = oWCPADecryptResultM17759decrypt.f23384fail;
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        byte[] bArr4 = new byte[sHA3Digest.getDigestSize()];
        sHA3Digest.mo14970update(bArr3, 0, bArr3.length);
        sHA3Digest.mo14967doFinal(bArr4, 0);
        sHA3Digest.mo14970update(bArr2, parameterSet.owcpaSecretKeyBytes(), parameterSet.prfKeyBytes());
        sHA3Digest.mo14970update(bArr, 0, bArr.length);
        sHA3Digest.mo14967doFinal(bArr3, 0);
        m17756cmov(bArr4, bArr3, (byte) i);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr4, 0, parameterSet.sharedKeyBytes());
        C6238Arrays.m18227clear(bArr4);
        return bArrCopyOfRange;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.ntruPrivateKey.getParameters().getEncapsulationLength();
    }
}
