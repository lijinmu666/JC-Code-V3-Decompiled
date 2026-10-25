package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3995FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final C0864Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;

    /* renamed from: sigHash */
    private final C0864Enums.HashType f3996sigHash;

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, C0864Enums.HashType hashType, C0864Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (!f3995FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.f3996sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.f3996sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.f3996sigHash));
        byte[] bArrDigest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int length = bArr2.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (bArr2[bArr2.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i2 = (length - digestLength) - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, i2);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, bArrCopyOf.length, bArrCopyOf.length + digestLength);
        int i3 = 0;
        while (true) {
            int i4 = i2;
            MessageDigest messageDigest = engineFactory;
            byte[] bArr3 = bArrDigest;
            long j = (length * 8) - i;
            if (i3 < j) {
                if (((bArrCopyOf[i3 / 8] >> (7 - (i3 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i3++;
                i2 = i4;
                engineFactory = messageDigest;
                bArrDigest = bArr3;
            } else {
                byte[] bArrM4285mgf1 = SubtleUtil.m4285mgf1(bArrCopyOfRange, i4, this.mgf1Hash);
                int length2 = bArrM4285mgf1.length;
                byte[] bArr4 = new byte[length2];
                for (int i5 = 0; i5 < length2; i5++) {
                    bArr4[i5] = (byte) (bArrM4285mgf1[i5] ^ bArrCopyOf[i5]);
                }
                for (int i6 = 0; i6 <= j; i6++) {
                    int i7 = i6 / 8;
                    bArr4[i7] = (byte) ((~(1 << (7 - (i6 % 8)))) & bArr4[i7]);
                }
                int i8 = 0;
                while (true) {
                    int i9 = this.saltLength;
                    if (i8 >= (r6 - i9) - 2) {
                        if (bArr4[(r6 - i9) - 2] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr4, length2 - i9, length2);
                        int i10 = digestLength + 8;
                        byte[] bArr5 = new byte[this.saltLength + i10];
                        System.arraycopy(bArr3, 0, bArr5, 8, bArr3.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr5, i10, bArrCopyOfRange2.length);
                        if (!C0853Bytes.m4230equal(messageDigest.digest(bArr5), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr4[i8] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i8++;
                }
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.PublicKeyVerify
    /* renamed from: verify */
    public void mo3387verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        int iBitLength2 = (modulus.bitLength() + 6) / 8;
        if (iBitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
        if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
    }
}
