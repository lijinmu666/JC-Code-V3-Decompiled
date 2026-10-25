package org.bouncycastle.p298mozilla;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.p160mozilla.PublicKeyAndChallenge;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class SignedPublicKeyAndChallenge implements Encodable {
    protected final org.bouncycastle.p133asn1.p160mozilla.SignedPublicKeyAndChallenge spkacSeq;

    public SignedPublicKeyAndChallenge(org.bouncycastle.p133asn1.p160mozilla.SignedPublicKeyAndChallenge signedPublicKeyAndChallenge) {
        this.spkacSeq = signedPublicKeyAndChallenge;
    }

    public String getChallenge() {
        return this.spkacSeq.getPublicKeyAndChallenge().getChallenge().getString();
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return toASN1Structure().getEncoded();
    }

    public PublicKey getPublicKey(String str) throws InvalidKeyException {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
        try {
            return KeyFactory.getInstance(subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14433getId(), str).generatePublic(new X509EncodedKeySpec(new DERBitString(subjectPublicKeyInfo).getOctets()));
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.spkacSeq.getPublicKeyAndChallenge();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException {
        ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(this.spkacSeq.getSignatureAlgorithm());
        OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
        this.spkacSeq.getPublicKeyAndChallenge().encodeTo(outputStream, ASN1Encoding.f17902DER);
        outputStream.close();
        return contentVerifierMo17379get.mo16015verify(this.spkacSeq.getSignature().getOctets());
    }

    public ASN1Primitive toASN1Primitive() {
        return this.spkacSeq.toASN1Primitive();
    }

    public org.bouncycastle.p133asn1.p160mozilla.SignedPublicKeyAndChallenge toASN1Structure() {
        return this.spkacSeq;
    }

    /* renamed from: verify */
    public boolean m17117verify() {
        return m17118verify(null);
    }

    public SignedPublicKeyAndChallenge(byte[] bArr) {
        this.spkacSeq = org.bouncycastle.p133asn1.p160mozilla.SignedPublicKeyAndChallenge.getInstance(bArr);
    }

    /* renamed from: verify */
    public boolean m17118verify(String str) throws SignatureException, InvalidKeyException {
        String strM14433getId = this.spkacSeq.getSignatureAlgorithm().getAlgorithm().m14433getId();
        Signature signature = str == null ? Signature.getInstance(strM14433getId) : Signature.getInstance(strM14433getId, str);
        signature.initVerify(getPublicKey(str));
        try {
            signature.update(this.spkacSeq.getPublicKeyAndChallenge().getEncoded());
            return signature.verify(this.spkacSeq.getSignature().getOctets());
        } catch (Exception unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }
}
