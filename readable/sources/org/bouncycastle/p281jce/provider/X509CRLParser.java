package org.bouncycastle.p281jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.SignedData;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p366x509.X509StreamParserSpi;
import org.bouncycastle.p366x509.p367util.StreamParsingException;

/* loaded from: classes2.dex */
public class X509CRLParser extends X509StreamParserSpi {
    private static final C5815PEMUtil PEM_PARSER = new C5815PEMUtil("CRL");

    /* renamed from: sData */
    private AbstractC5093ASN1Set f22042sData = null;
    private int sDataObjectCount = 0;
    private InputStream currentStream = null;

    /* renamed from: getCRL */
    private CRL m16263getCRL() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.f22042sData;
        if (abstractC5093ASN1Set == null || this.sDataObjectCount >= abstractC5093ASN1Set.m14454size()) {
            return null;
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.f22042sData;
        int i = this.sDataObjectCount;
        this.sDataObjectCount = i + 1;
        return new X509CRLObject(CertificateList.getInstance(abstractC5093ASN1Set2.getObjectAt(i)));
    }

    private CRL readDERCRL(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).readObject();
        if (aSN1Sequence.mo14450size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509CRLObject(CertificateList.getInstance(aSN1Sequence));
        }
        this.f22042sData = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).m14638getCRLs();
        return m16263getCRL();
    }

    private CRL readPEMCRL(InputStream inputStream) {
        ASN1Sequence pEMObject = PEM_PARSER.readPEMObject(inputStream);
        if (pEMObject != null) {
            return new X509CRLObject(CertificateList.getInstance(pEMObject));
        }
        return null;
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public void engineInit(InputStream inputStream) {
        this.currentStream = inputStream;
        this.f22042sData = null;
        this.sDataObjectCount = 0;
        if (inputStream.markSupported()) {
            return;
        }
        this.currentStream = new BufferedInputStream(this.currentStream);
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public Object engineRead() throws StreamParsingException, IOException {
        try {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.f22042sData;
            if (abstractC5093ASN1Set != null) {
                if (this.sDataObjectCount != abstractC5093ASN1Set.m14454size()) {
                    return m16263getCRL();
                }
                this.f22042sData = null;
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
                return readPEMCRL(this.currentStream);
            }
            this.currentStream.reset();
            return readDERCRL(this.currentStream);
        } catch (Exception e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }

    @Override // org.bouncycastle.p366x509.X509StreamParserSpi
    public Collection engineReadAll() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CRL crl = (CRL) engineRead();
            if (crl == null) {
                return arrayList;
            }
            arrayList.add(crl);
        }
    }
}
