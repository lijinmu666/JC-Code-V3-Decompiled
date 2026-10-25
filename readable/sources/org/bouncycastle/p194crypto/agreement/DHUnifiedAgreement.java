package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.DHUPrivateParameters;
import org.bouncycastle.p194crypto.p213params.DHUPublicParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class DHUnifiedAgreement {
    private DHUPrivateParameters privParams;

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        DHUPublicParameters dHUPublicParameters = (DHUPublicParameters) cipherParameters;
        DHBasicAgreement dHBasicAgreement = new DHBasicAgreement();
        DHBasicAgreement dHBasicAgreement2 = new DHBasicAgreement();
        dHBasicAgreement.mo14945init(this.privParams.getStaticPrivateKey());
        BigInteger bigIntegerCalculateAgreement = dHBasicAgreement.calculateAgreement(dHUPublicParameters.getStaticPublicKey());
        dHBasicAgreement2.mo14945init(this.privParams.getEphemeralPrivateKey());
        BigInteger bigIntegerCalculateAgreement2 = dHBasicAgreement2.calculateAgreement(dHUPublicParameters.getEphemeralPublicKey());
        int fieldSize = getFieldSize();
        byte[] bArr = new byte[fieldSize * 2];
        BigIntegers.asUnsignedByteArray(bigIntegerCalculateAgreement2, bArr, 0, fieldSize);
        BigIntegers.asUnsignedByteArray(bigIntegerCalculateAgreement, bArr, fieldSize, fieldSize);
        return bArr;
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().m15695getP().bitLength() + 7) / 8;
    }

    /* renamed from: init */
    public void m15001init(CipherParameters cipherParameters) {
        DHUPrivateParameters dHUPrivateParameters = (DHUPrivateParameters) cipherParameters;
        this.privParams = dHUPrivateParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("DHU", dHUPrivateParameters.getStaticPrivateKey()));
    }
}
