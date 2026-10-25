package org.bouncycastle.p281jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.SignedData;
import org.bouncycastle.p302openssl.PEMParser;
import org.bouncycastle.p366x509.X509AttributeCertificate;
import org.bouncycastle.p366x509.X509StreamParserSpi;
import org.bouncycastle.p366x509.X509V2AttributeCertificate;
import org.bouncycastle.p366x509.p367util.StreamParsingException;

/* loaded from: classes2.dex */
public class X509AttrCertParser extends X509StreamParserSpi {
    private static final C5815PEMUtil PEM_PARSER = new C5815PEMUtil(PEMParser.TYPE_ATTRIBUTE_CERTIFICATE);

    /* renamed from: sData */
    private AbstractC5093ASN1Set f22039sData = null;
    private int sDataObjectCount = 0;
    private InputStream currentStream = null;

    private X509AttributeCertificate getCertificate() {
        if (this.f22039sData == null) {
            return null;
        }
        while (this.sDataObjectCount < this.f22039sData.m14454size()) {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.f22039sData;
            int i = this.sDataObjectCount;
            this.sDataObjectCount = i + 1;
            ASN1Encodable objectAt = abstractC5093ASN1Set.getObjectAt(i);
            if (objectAt instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt;
                if (aSN1TaggedObject.getTagNo() == 2) {
                    return new X509V2AttributeCertificate(ASN1Sequence.getInstance(aSN1TaggedObject, false).getEncoded());
                }
            }
        }
        return null;
    }

    private X509AttributeCertificate readDERCertificate(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(new ASN1InputStream(inputStream).readObject());
        if (aSN1Sequence.mo14450size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509V2AttributeCertificate(aSN1Sequence.getEncoded());
        }
        this.f22039sData = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return getCertificate();
    }

    private X509AttributeCertificate readPEMCertificate(InputStream inputStream) {
        ASN1Sequence pEMObject = PEM_PARSER.readPEMObject(inputStream);
        if (pEMObject != null) {
            return new X509V2AttributeCertificate(pEMObject.getEncoded());
        }
        return null;
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public void engineInit(InputStream inputStream) {
        this.currentStream = inputStream;
        this.f22039sData = null;
        this.sDataObjectCount = 0;
        if (inputStream.markSupported()) {
            return;
        }
        this.currentStream = new BufferedInputStream(this.currentStream);
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public Object engineRead() throws StreamParsingException, IOException {
        try {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.f22039sData;
            if (abstractC5093ASN1Set != null) {
                if (this.sDataObjectCount != abstractC5093ASN1Set.m14454size()) {
                    return getCertificate();
                }
                this.f22039sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
            this.currentStream.mark(10);
            int i = this.currentStream.read();
            if (i == -1) {
                return null;
            }
            if (i != 48) {
                this.currentStream.reset();
                return readPEMCertificate(this.currentStream);
            }
            this.currentStream.reset();
            return readDERCertificate(this.currentStream);
        } catch (Exception e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public Collection engineReadAll() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) engineRead();
            if (x509AttributeCertificate == null) {
                return arrayList;
            }
            arrayList.add(x509AttributeCertificate);
        }
    }
}
