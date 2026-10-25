package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p071mac.internal.C0478AesUtil;
import com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class PrfAesCmac implements InterfaceC0504Prf {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3981FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    /* renamed from: keySpec */
    private final SecretKey f3982keySpec;

    /* renamed from: subKey1 */
    private byte[] f3983subKey1;

    /* renamed from: subKey2 */
    private byte[] f3984subKey2;

    public PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.f3982keySpec = new SecretKeySpec(bArr, "AES");
        generateSubKeys();
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher cipherInstance = instance();
        cipherInstance.init(1, this.f3982keySpec);
        byte[] bArrM3531dbl = C0478AesUtil.m3531dbl(cipherInstance.doFinal(new byte[16]));
        this.f3983subKey1 = bArrM3531dbl;
        this.f3984subKey2 = C0478AesUtil.m3531dbl(bArrM3531dbl);
    }

    private static Cipher instance() throws GeneralSecurityException {
        if (f3981FIPS.isCompatible()) {
            return EngineFactory.f3961CIPHER.getInstance("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf
    /* renamed from: compute */
    public byte[] mo3552compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherInstance = instance();
        cipherInstance.init(1, this.f3982keySpec);
        int iMax = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        byte[] bArrM4232xor = iMax * 16 == bArr.length ? C0853Bytes.m4232xor(bArr, (iMax - 1) * 16, this.f3983subKey1, 0, 16) : C0853Bytes.m4233xor(C0478AesUtil.m3530cmacPad(Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length)), this.f3984subKey2);
        byte[] bArrDoFinal = new byte[16];
        for (int i2 = 0; i2 < iMax - 1; i2++) {
            bArrDoFinal = cipherInstance.doFinal(C0853Bytes.m4232xor(bArrDoFinal, 0, bArr, i2 * 16, 16));
        }
        return Arrays.copyOf(cipherInstance.doFinal(C0853Bytes.m4233xor(bArrM4232xor, bArrDoFinal)), i);
    }
}
