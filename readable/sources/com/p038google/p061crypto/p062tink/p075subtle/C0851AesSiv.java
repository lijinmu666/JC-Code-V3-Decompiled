package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p071mac.internal.C0478AesUtil;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: com.google.crypto.tink.subtle.AesSiv */
/* loaded from: classes.dex */
public final class C0851AesSiv implements DeterministicAead {
    private final byte[] aesCtrKey;
    private final PrfAesCmac cmacForS2V;

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3908FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(64);
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    public C0851AesSiv(byte[] bArr) throws GeneralSecurityException {
        if (!f3908FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (KEY_SIZES.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.aesCtrKey = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.cmacForS2V = new PrfAesCmac(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    /* renamed from: s2v */
    private byte[] m4220s2v(byte[]... bArr) throws GeneralSecurityException {
        if (bArr.length == 0) {
            return this.cmacForS2V.mo3552compute(BLOCK_ONE, 16);
        }
        byte[] bArrMo3552compute = this.cmacForS2V.mo3552compute(BLOCK_ZERO, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrMo3552compute = C0853Bytes.m4233xor(C0478AesUtil.m3531dbl(bArrMo3552compute), this.cmacForS2V.mo3552compute(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        return this.cmacForS2V.mo3552compute(bArr3.length >= 16 ? C0853Bytes.m4234xorEnd(bArr3, bArrMo3552compute) : C0853Bytes.m4233xor(C0478AesUtil.m3530cmacPad(bArr3), C0478AesUtil.m3531dbl(bArrMo3552compute)), 16);
    }

    @Override // com.p038google.p061crypto.p062tink.DeterministicAead
    public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher engineFactory = EngineFactory.f3961CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & ByteCompanionObject.MAX_VALUE);
        bArr3[12] = (byte) (bArr3[12] & ByteCompanionObject.MAX_VALUE);
        engineFactory.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = engineFactory.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && SubtleUtil.isAndroid()) {
            bArrDoFinal = new byte[0];
        }
        if (C0853Bytes.m4230equal(bArrCopyOfRange, m4220s2v(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    @Override // com.p038google.p061crypto.p062tink.DeterministicAead
    public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher engineFactory = EngineFactory.f3961CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] bArrM4220s2v = m4220s2v(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrM4220s2v.clone();
        bArr3[8] = (byte) (bArr3[8] & ByteCompanionObject.MAX_VALUE);
        bArr3[12] = (byte) (bArr3[12] & ByteCompanionObject.MAX_VALUE);
        engineFactory.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr3));
        return C0853Bytes.m4229concat(bArrM4220s2v, engineFactory.doFinal(bArr));
    }
}
