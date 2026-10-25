package org.bouncycastle.p307pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequest;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequestInfo;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class PKCS10CertificationRequestBuilder {
    private List attributes;
    private boolean leaveOffEmpty;
    private SubjectPublicKeyInfo publicKeyInfo;

    /* renamed from: subject */
    private X500Name f22928subject;

    public PKCS10CertificationRequestBuilder(X500Name x500Name, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.attributes = new ArrayList();
        this.leaveOffEmpty = false;
        this.f22928subject = x500Name;
        this.publicKeyInfo = subjectPublicKeyInfo;
    }

    public PKCS10CertificationRequestBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attributes.add(new Attribute(aSN1ObjectIdentifier, new C5104DERSet(aSN1Encodable)));
        return this;
    }

    /* renamed from: build */
    public PKCS10CertificationRequest m17405build(ContentSigner contentSigner) throws IOException {
        CertificationRequestInfo certificationRequestInfo;
        if (this.attributes.isEmpty()) {
            certificationRequestInfo = this.leaveOffEmpty ? new CertificationRequestInfo(this.f22928subject, this.publicKeyInfo, (AbstractC5093ASN1Set) null) : new CertificationRequestInfo(this.f22928subject, this.publicKeyInfo, new C5104DERSet());
        } else {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            Iterator it = this.attributes.iterator();
            while (it.hasNext()) {
                aSN1EncodableVector.m14420add(Attribute.getInstance(it.next()));
            }
            certificationRequestInfo = new CertificationRequestInfo(this.f22928subject, this.publicKeyInfo, new C5104DERSet(aSN1EncodableVector));
        }
        try {
            OutputStream outputStream = contentSigner.getOutputStream();
            outputStream.write(certificationRequestInfo.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return new PKCS10CertificationRequest(new CertificationRequest(certificationRequestInfo, contentSigner.getAlgorithmIdentifier(), new DERBitString(contentSigner.getSignature())));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certification request signature");
        }
    }

    public PKCS10CertificationRequestBuilder setAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        Iterator it = this.attributes.iterator();
        while (it.hasNext()) {
            if (((Attribute) it.next()).getAttrType().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                throw new IllegalStateException("Attribute " + aSN1ObjectIdentifier.toString() + " is already set");
            }
        }
        addAttribute(aSN1ObjectIdentifier, aSN1Encodable);
        return this;
    }

    public PKCS10CertificationRequestBuilder setLeaveOffEmptyAttributes(boolean z) {
        this.leaveOffEmpty = z;
        return this;
    }

    public PKCS10CertificationRequestBuilder(PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder) {
        this.attributes = new ArrayList();
        this.leaveOffEmpty = false;
        this.publicKeyInfo = pKCS10CertificationRequestBuilder.publicKeyInfo;
        this.f22928subject = pKCS10CertificationRequestBuilder.f22928subject;
        this.leaveOffEmpty = pKCS10CertificationRequestBuilder.leaveOffEmpty;
        this.attributes = new ArrayList(pKCS10CertificationRequestBuilder.attributes);
    }

    public PKCS10CertificationRequestBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable[] aSN1EncodableArr) {
        this.attributes.add(new Attribute(aSN1ObjectIdentifier, new C5104DERSet(aSN1EncodableArr)));
        return this;
    }

    /* renamed from: build */
    public PKCS10CertificationRequest m17406build(ContentSigner contentSigner, SubjectPublicKeyInfo subjectPublicKeyInfo, ContentSigner contentSigner2) throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = this.attributes.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(Attribute.getInstance(it.next()));
        }
        aSN1EncodableVector.m14420add(new Attribute(Extension.subjectAltPublicKeyInfo, new C5104DERSet(subjectPublicKeyInfo)));
        aSN1EncodableVector.m14420add(new Attribute(Extension.altSignatureAlgorithm, new C5104DERSet(contentSigner2.getAlgorithmIdentifier())));
        CertificationRequestInfo certificationRequestInfo = new CertificationRequestInfo(this.f22928subject, this.publicKeyInfo, new C5104DERSet(aSN1EncodableVector));
        try {
            OutputStream outputStream = contentSigner2.getOutputStream();
            outputStream.write(certificationRequestInfo.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            aSN1EncodableVector.m14420add(new Attribute(Extension.altSignatureValue, new C5104DERSet(new DERBitString(contentSigner2.getSignature()))));
            CertificationRequestInfo certificationRequestInfo2 = new CertificationRequestInfo(this.f22928subject, this.publicKeyInfo, new C5104DERSet(aSN1EncodableVector));
            try {
                OutputStream outputStream2 = contentSigner.getOutputStream();
                outputStream2.write(certificationRequestInfo2.getEncoded(ASN1Encoding.f17902DER));
                outputStream2.close();
                return new PKCS10CertificationRequest(new CertificationRequest(certificationRequestInfo2, contentSigner.getAlgorithmIdentifier(), new DERBitString(contentSigner.getSignature())));
            } catch (IOException unused) {
                throw new IllegalStateException("cannot produce certification request signature");
            }
        } catch (IOException unused2) {
            throw new IllegalStateException("cannot produce certification request signature");
        }
    }

    public PKCS10CertificationRequestBuilder setAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable[] aSN1EncodableArr) {
        Iterator it = this.attributes.iterator();
        while (it.hasNext()) {
            if (((Attribute) it.next()).getAttrType().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                throw new IllegalStateException("Attribute " + aSN1ObjectIdentifier.toString() + " is already set");
            }
        }
        addAttribute(aSN1ObjectIdentifier, aSN1EncodableArr);
        return this;
    }
}
