package org.bouncycastle.p281jce.netscape;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;

/* loaded from: classes2.dex */
public class NetscapeCertRequest extends ASN1Object {
    String challenge;

    /* renamed from: content */
    DERBitString f21969content;

    /* renamed from: keyAlg */
    AlgorithmIdentifier f21970keyAlg;

    /* renamed from: pubkey */
    PublicKey f21971pubkey;

    /* renamed from: sigAlg */
    AlgorithmIdentifier f21972sigAlg;

    /* renamed from: sigBits */
    byte[] f21973sigBits;

    public NetscapeCertRequest(String str, AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) throws InvalidKeySpecException {
        this.challenge = str;
        this.f21972sigAlg = algorithmIdentifier;
        this.f21971pubkey = publicKey;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(getKeySpec());
        aSN1EncodableVector.m14420add(new DERIA5String(str));
        try {
            this.f21969content = new DERBitString(new DERSequence(aSN1EncodableVector));
        } catch (IOException e) {
            throw new InvalidKeySpecException("exception encoding key: " + e.toString());
        }
    }

    private ASN1Primitive getKeySpec() throws InvalidKeySpecException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f21971pubkey.getEncoded());
            byteArrayOutputStream.close();
            return new ASN1InputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (IOException e) {
            throw new InvalidKeySpecException(e.getMessage());
        }
    }

    /* renamed from: getReq */
    private static ASN1Sequence m16232getReq(byte[] bArr) {
        return ASN1Sequence.getInstance(new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject());
    }

    public String getChallenge() {
        return this.challenge;
    }

    public AlgorithmIdentifier getKeyAlgorithm() {
        return this.f21970keyAlg;
    }

    public PublicKey getPublicKey() {
        return this.f21971pubkey;
    }

    public AlgorithmIdentifier getSigningAlgorithm() {
        return this.f21972sigAlg;
    }

    public void setChallenge(String str) {
        this.challenge = str;
    }

    public void setKeyAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.f21970keyAlg = algorithmIdentifier;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.f21971pubkey = publicKey;
    }

    public void setSigningAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.f21972sigAlg = algorithmIdentifier;
    }

    /* renamed from: sign */
    public void m16233sign(PrivateKey privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        m16234sign(privateKey, null);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        try {
            aSN1EncodableVector2.m14420add(getKeySpec());
        } catch (Exception unused) {
        }
        aSN1EncodableVector2.m14420add(new DERIA5String(this.challenge));
        aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.m14420add(this.f21972sigAlg);
        aSN1EncodableVector.m14420add(new DERBitString(this.f21973sigBits));
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: verify */
    public boolean m16235verify(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        if (!str.equals(this.challenge)) {
            return false;
        }
        Signature signature = Signature.getInstance(this.f21972sigAlg.getAlgorithm().m14433getId(), BouncyCastleProvider.PROVIDER_NAME);
        signature.initVerify(this.f21971pubkey);
        signature.update(this.f21969content.getOctets());
        return signature.verify(this.f21973sigBits);
    }

    public NetscapeCertRequest(ASN1Sequence aSN1Sequence) {
        try {
            if (aSN1Sequence.mo14450size() != 3) {
                throw new IllegalArgumentException("invalid SPKAC (size):" + aSN1Sequence.mo14450size());
            }
            this.f21972sigAlg = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.f21973sigBits = ((DERBitString) aSN1Sequence.getObjectAt(2)).getOctets();
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
            if (aSN1Sequence2.mo14450size() != 2) {
                throw new IllegalArgumentException("invalid PKAC (len): " + aSN1Sequence2.mo14450size());
            }
            this.challenge = ((ASN1IA5String) aSN1Sequence2.getObjectAt(1)).getString();
            this.f21969content = new DERBitString(aSN1Sequence2);
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence2.getObjectAt(0));
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded(ASN1Encoding.f17902DER));
            AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
            this.f21970keyAlg = algorithm;
            this.f21971pubkey = KeyFactory.getInstance(algorithm.getAlgorithm().m14433getId(), BouncyCastleProvider.PROVIDER_NAME).generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    /* renamed from: sign */
    public void m16234sign(PrivateKey privateKey, SecureRandom secureRandom) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        Signature signature = Signature.getInstance(this.f21972sigAlg.getAlgorithm().m14433getId(), BouncyCastleProvider.PROVIDER_NAME);
        if (secureRandom != null) {
            signature.initSign(privateKey, secureRandom);
        } else {
            signature.initSign(privateKey);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(getKeySpec());
        aSN1EncodableVector.m14420add(new DERIA5String(this.challenge));
        try {
            signature.update(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER));
            this.f21973sigBits = signature.sign();
        } catch (IOException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    public NetscapeCertRequest(byte[] bArr) {
        this(m16232getReq(bArr));
    }
}
