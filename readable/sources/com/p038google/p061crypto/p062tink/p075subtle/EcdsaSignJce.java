package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class EcdsaSignJce implements PublicKeySign {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3927FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final EllipticCurves.EcdsaEncoding encoding;
    private final ECPrivateKey privateKey;
    private final String signatureAlgorithm;

    public EcdsaSignJce(ECPrivateKey eCPrivateKey, C0864Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding) throws GeneralSecurityException {
        if (!f3927FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        this.privateKey = eCPrivateKey;
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hashType);
        this.encoding = ecdsaEncoding;
    }

    @Override // com.p038google.p061crypto.p062tink.PublicKeySign
    /* renamed from: sign */
    public byte[] mo3386sign(byte[] bArr) throws SignatureException, InvalidKeyException {
        Signature engineFactory = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm, EngineFactory.toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"));
        engineFactory.initSign(this.privateKey);
        engineFactory.update(bArr);
        byte[] bArrSign = engineFactory.sign();
        return this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363 ? EllipticCurves.ecdsaDer2Ieee(bArrSign, EllipticCurves.fieldSizeInBytes(this.privateKey.getParams().getCurve()) * 2) : bArrSign;
    }
}
