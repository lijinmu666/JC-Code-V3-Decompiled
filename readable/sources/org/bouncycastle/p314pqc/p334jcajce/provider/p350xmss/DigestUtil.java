package org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes2.dex */
class DigestUtil {

    public static class DoubleDigest implements InterfaceC5277Digest {

        /* renamed from: digest */
        private SHAKEDigest f23880digest;

        public DoubleDigest(SHAKEDigest sHAKEDigest) {
            this.f23880digest = sHAKEDigest;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: doFinal */
        public int mo14967doFinal(byte[] bArr, int i) {
            return this.f23880digest.mo14998doFinal(bArr, i, getDigestSize());
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public String getAlgorithmName() {
            return this.f23880digest.getAlgorithmName() + "/" + (this.f23880digest.getDigestSize() * 16);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public int getDigestSize() {
            return this.f23880digest.getDigestSize() * 2;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: reset */
        public void mo14968reset() {
            this.f23880digest.mo14968reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14969update(byte b) {
            this.f23880digest.mo14969update(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14970update(byte[] bArr, int i, int i2) {
            this.f23880digest.mo14970update(bArr, i, i2);
        }
    }

    public static InterfaceC5277Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier getDigestOID(String str) {
        if (str.equals(XMSSKeyParameters.f23621SHA_256)) {
            return NISTObjectIdentifiers.id_sha256;
        }
        if (str.equals(XMSSKeyParameters.f23622SHA_512)) {
            return NISTObjectIdentifiers.id_sha512;
        }
        if (str.equals("SHAKE128")) {
            return NISTObjectIdentifiers.id_shake128;
        }
        if (str.equals("SHAKE256")) {
            return NISTObjectIdentifiers.id_shake256;
        }
        throw new IllegalArgumentException("unrecognized digest: " + str);
    }

    public static byte[] getDigestResult(InterfaceC5277Digest interfaceC5277Digest) {
        byte[] bArr = new byte[interfaceC5277Digest.getDigestSize()];
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    public static String getXMSSDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return "SHA256";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return "SHA512";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return "SHAKE128";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return "SHAKE256";
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }
}
