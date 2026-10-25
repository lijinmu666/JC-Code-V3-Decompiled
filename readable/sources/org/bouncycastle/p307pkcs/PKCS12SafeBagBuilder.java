package org.bouncycastle.p307pkcs;

import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p166pkcs.C5135CertBag;
import org.bouncycastle.p133asn1.p166pkcs.C5138SafeBag;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class PKCS12SafeBagBuilder {
    private ASN1EncodableVector bagAttrs;

    /* renamed from: bagType */
    private ASN1ObjectIdentifier f22931bagType;
    private ASN1Encodable bagValue;

    public PKCS12SafeBagBuilder(PrivateKeyInfo privateKeyInfo) {
        this.bagAttrs = new ASN1EncodableVector();
        this.f22931bagType = PKCSObjectIdentifiers.f18500keyBag;
        this.bagValue = privateKeyInfo;
    }

    public PKCS12SafeBagBuilder addBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.bagAttrs.m14420add(new Attribute(aSN1ObjectIdentifier, new C5104DERSet(aSN1Encodable)));
        return this;
    }

    /* renamed from: build */
    public PKCS12SafeBag m17413build() {
        return new PKCS12SafeBag(new C5138SafeBag(this.f22931bagType, this.bagValue, new C5104DERSet(this.bagAttrs)));
    }

    public PKCS12SafeBagBuilder(PrivateKeyInfo privateKeyInfo, OutputEncryptor outputEncryptor) {
        this.bagAttrs = new ASN1EncodableVector();
        this.f22931bagType = PKCSObjectIdentifiers.pkcs8ShroudedKeyBag;
        this.bagValue = new PKCS8EncryptedPrivateKeyInfoBuilder(privateKeyInfo).m17414build(outputEncryptor).toASN1Structure();
    }

    public PKCS12SafeBagBuilder(Certificate certificate) {
        this.bagAttrs = new ASN1EncodableVector();
        this.f22931bagType = PKCSObjectIdentifiers.f18491certBag;
        this.bagValue = new C5135CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(certificate.getEncoded()));
    }

    public PKCS12SafeBagBuilder(CertificateList certificateList) {
        this.bagAttrs = new ASN1EncodableVector();
        this.f22931bagType = PKCSObjectIdentifiers.f18492crlBag;
        this.bagValue = new C5135CertBag(PKCSObjectIdentifiers.f18511x509Crl, new DEROctetString(certificateList.getEncoded()));
    }

    public PKCS12SafeBagBuilder(X509CRLHolder x509CRLHolder) {
        this(x509CRLHolder.toASN1Structure());
    }

    public PKCS12SafeBagBuilder(X509CertificateHolder x509CertificateHolder) {
        this(x509CertificateHolder.toASN1Structure());
    }
}
