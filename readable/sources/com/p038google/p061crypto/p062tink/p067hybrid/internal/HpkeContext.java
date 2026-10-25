package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.internal.BigIntegerEncoding;
import com.p038google.p061crypto.p062tink.p073proto.HpkePublicKey;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];

    /* renamed from: aead */
    private final HpkeAead f3078aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;

    /* renamed from: key */
    private final byte[] f3079key;
    private final BigInteger maxSequenceNumber;

    @GuardedBy("this")
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, HpkeAead hpkeAead) {
        this.encapsulatedKey = bArr;
        this.f3079key = bArr2;
        this.baseNonce = bArr3;
        this.maxSequenceNumber = bigInteger;
        this.f3078aead = hpkeAead;
    }

    @GuardedBy("this")
    private byte[] computeNonce() {
        return C0853Bytes.m4233xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.f3078aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() {
        byte[] bArrComputeNonce;
        bArrComputeNonce = computeNonce();
        incrementSequenceNumber();
        return bArrComputeNonce;
    }

    public static HpkeContext createContext(byte[] bArr, byte[] bArr2, InterfaceC0402HpkeKem interfaceC0402HpkeKem, InterfaceC0401HpkeKdf interfaceC0401HpkeKdf, HpkeAead hpkeAead, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrHpkeSuiteId = HpkeUtil.hpkeSuiteId(interfaceC0402HpkeKem.getKemId(), interfaceC0401HpkeKdf.getKdfId(), hpkeAead.getAeadId());
        byte[] bArr4 = HpkeUtil.EMPTY_SALT;
        byte[] bArr5 = EMPTY_IKM;
        byte[] bArrM4229concat = C0853Bytes.m4229concat(HpkeUtil.BASE_MODE, interfaceC0401HpkeKdf.labeledExtract(bArr4, bArr5, "psk_id_hash", bArrHpkeSuiteId), interfaceC0401HpkeKdf.labeledExtract(bArr4, bArr3, "info_hash", bArrHpkeSuiteId));
        byte[] bArrLabeledExtract = interfaceC0401HpkeKdf.labeledExtract(bArr2, bArr5, "secret", bArrHpkeSuiteId);
        return new HpkeContext(bArr, interfaceC0401HpkeKdf.labeledExpand(bArrLabeledExtract, bArrM4229concat, "key", bArrHpkeSuiteId, hpkeAead.getKeyLength()), interfaceC0401HpkeKdf.labeledExpand(bArrLabeledExtract, bArrM4229concat, "base_nonce", bArrHpkeSuiteId, hpkeAead.getNonceLength()), maxSequenceNumber(hpkeAead.getNonceLength()), hpkeAead);
    }

    public static HpkeContext createRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, InterfaceC0402HpkeKem interfaceC0402HpkeKem, InterfaceC0401HpkeKdf interfaceC0401HpkeKdf, HpkeAead hpkeAead, byte[] bArr2) {
        return createContext(bArr, interfaceC0402HpkeKem.decapsulate(bArr, hpkeKemPrivateKey), interfaceC0402HpkeKem, interfaceC0401HpkeKdf, hpkeAead, bArr2);
    }

    public static HpkeContext createSenderContext(HpkePublicKey hpkePublicKey, InterfaceC0402HpkeKem interfaceC0402HpkeKem, InterfaceC0401HpkeKdf interfaceC0401HpkeKdf, HpkeAead hpkeAead, byte[] bArr) {
        HpkeKemEncapOutput hpkeKemEncapOutputEncapsulate = interfaceC0402HpkeKem.encapsulate(hpkePublicKey.getPublicKey().toByteArray());
        return createContext(hpkeKemEncapOutputEncapsulate.getEncapsulatedKey(), hpkeKemEncapOutputEncapsulate.getSharedSecret(), interfaceC0402HpkeKem, interfaceC0401HpkeKdf, hpkeAead, bArr);
    }

    @GuardedBy("this")
    private void incrementSequenceNumber() throws GeneralSecurityException {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
    }

    private static BigInteger maxSequenceNumber(int i) {
        BigInteger bigInteger = BigInteger.ONE;
        return bigInteger.shiftLeft(i * 8).subtract(bigInteger);
    }

    public byte[] getBaseNonce() {
        return this.baseNonce;
    }

    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    /* renamed from: getKey */
    public byte[] m3463getKey() {
        return this.f3079key;
    }

    /* renamed from: open */
    public byte[] m3464open(byte[] bArr, byte[] bArr2) {
        return this.f3078aead.mo3459open(this.f3079key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }

    /* renamed from: seal */
    public byte[] m3465seal(byte[] bArr, byte[] bArr2) {
        return this.f3078aead.mo3460seal(this.f3079key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }
}
