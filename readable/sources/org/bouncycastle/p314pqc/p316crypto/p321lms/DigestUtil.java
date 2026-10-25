package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;

/* loaded from: classes2.dex */
class DigestUtil {

    public static class WrapperDigest implements InterfaceC5277Digest {

        /* renamed from: digest */
        private final InterfaceC5277Digest f23214digest;

        /* renamed from: length */
        private final int f23215length;

        public WrapperDigest(InterfaceC5277Digest interfaceC5277Digest, int i) {
            this.f23214digest = interfaceC5277Digest;
            this.f23215length = i;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: doFinal */
        public int mo14967doFinal(byte[] bArr, int i) {
            byte[] bArr2 = new byte[this.f23214digest.getDigestSize()];
            this.f23214digest.mo14967doFinal(bArr2, 0);
            System.arraycopy(bArr2, 0, bArr, i, this.f23215length);
            return this.f23215length;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public String getAlgorithmName() {
            return this.f23214digest.getAlgorithmName() + "/" + (this.f23215length * 8);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public int getDigestSize() {
            return this.f23215length;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: reset */
        public void mo14968reset() {
            this.f23214digest.mo14968reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14969update(byte b) {
            this.f23214digest.mo14969update(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14970update(byte[] bArr, int i, int i2) {
            this.f23214digest.mo14970update(bArr, i, i2);
        }
    }

    private static InterfaceC5277Digest createDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256_len)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static InterfaceC5277Digest getDigest(LMOtsParameters lMOtsParameters) {
        return createDigest(lMOtsParameters.getDigestOID(), lMOtsParameters.m17622getN());
    }

    private static InterfaceC5277Digest createDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest(aSN1ObjectIdentifier);
        return (NISTObjectIdentifiers.id_shake256_len.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || interfaceC5277DigestCreateDigest.getDigestSize() != i) ? new WrapperDigest(interfaceC5277DigestCreateDigest, i) : interfaceC5277DigestCreateDigest;
    }

    public static InterfaceC5277Digest getDigest(LMSigParameters lMSigParameters) {
        return createDigest(lMSigParameters.getDigestOID(), lMSigParameters.m17654getM());
    }
}
