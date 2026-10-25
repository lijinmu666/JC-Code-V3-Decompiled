package org.bouncycastle.p307pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequest;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequestInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class PKCS10CertificationRequest {
    private static Attribute[] EMPTY_ARRAY = new Attribute[0];
    private final SubjectPublicKeyInfo altPublicKey;
    private final AlgorithmIdentifier altSignature;
    private final ASN1BitString altSignatureValue;
    private final CertificationRequest certificationRequest;
    private final boolean isAltRequest;

    public PKCS10CertificationRequest(CertificationRequest certificationRequest) {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        ASN1BitString aSN1BitString;
        if (certificationRequest == null) {
            throw new NullPointerException("certificationRequest cannot be null");
        }
        this.certificationRequest = certificationRequest;
        AbstractC5093ASN1Set attributes = certificationRequest.getCertificationRequestInfo().getAttributes();
        AlgorithmIdentifier algorithmIdentifier = null;
        if (attributes != null) {
            Enumeration objects = attributes.getObjects();
            subjectPublicKeyInfo = null;
            aSN1BitString = null;
            while (objects.hasMoreElements()) {
                Attribute attribute = Attribute.getInstance(objects.nextElement());
                algorithmIdentifier = Extension.altSignatureAlgorithm.m14446equals((ASN1Primitive) attribute.getAttrType()) ? AlgorithmIdentifier.getInstance(getSingleValue(attribute)) : algorithmIdentifier;
                subjectPublicKeyInfo = Extension.subjectAltPublicKeyInfo.m14446equals((ASN1Primitive) attribute.getAttrType()) ? SubjectPublicKeyInfo.getInstance(getSingleValue(attribute)) : subjectPublicKeyInfo;
                if (Extension.altSignatureValue.m14446equals((ASN1Primitive) attribute.getAttrType())) {
                    aSN1BitString = ASN1BitString.getInstance(getSingleValue(attribute));
                }
            }
        } else {
            subjectPublicKeyInfo = null;
            aSN1BitString = null;
        }
        boolean z = (algorithmIdentifier != null) | (subjectPublicKeyInfo != null) | (aSN1BitString != null);
        this.isAltRequest = z;
        if (z) {
            if (!((aSN1BitString != null) & (algorithmIdentifier != null) & (subjectPublicKeyInfo != null))) {
                throw new IllegalArgumentException("invalid alternate public key details found");
            }
        }
        this.altSignature = algorithmIdentifier;
        this.altPublicKey = subjectPublicKeyInfo;
        this.altSignatureValue = aSN1BitString;
    }

    private static ASN1Encodable getSingleValue(Attribute attribute) {
        ASN1Encodable[] attributeValues = attribute.getAttributeValues();
        if (attributeValues.length == 1) {
            return attributeValues[0];
        }
        throw new IllegalArgumentException("single value attribute value not size of 1");
    }

    private static CertificationRequest parseBytes(byte[] bArr) throws PKCSIOException {
        try {
            CertificationRequest certificationRequest = CertificationRequest.getInstance(ASN1Primitive.fromByteArray(bArr));
            if (certificationRequest != null) {
                return certificationRequest;
            }
            throw new PKCSIOException("empty data passed to constructor");
        } catch (ClassCastException e) {
            throw new PKCSIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new PKCSIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: equals */
    public boolean m17404equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PKCS10CertificationRequest) {
            return toASN1Structure().mo14431equals(((PKCS10CertificationRequest) obj).toASN1Structure());
        }
        return false;
    }

    public Attribute[] getAttributes() {
        AbstractC5093ASN1Set attributes = this.certificationRequest.getCertificationRequestInfo().getAttributes();
        if (attributes == null) {
            return EMPTY_ARRAY;
        }
        Attribute[] attributeArr = new Attribute[attributes.m14454size()];
        for (int i = 0; i != attributes.m14454size(); i++) {
            attributeArr[i] = Attribute.getInstance(attributes.getObjectAt(i));
        }
        return attributeArr;
    }

    public byte[] getEncoded() {
        return this.certificationRequest.getEncoded();
    }

    public Extensions getRequestedExtensions() {
        Attribute[] attributes = getAttributes();
        for (int i = 0; i != attributes.length; i++) {
            Attribute attribute = attributes[i];
            if (PKCSObjectIdentifiers.pkcs_9_at_extensionRequest.m14446equals((ASN1Primitive) attribute.getAttrType())) {
                ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
                AbstractC5093ASN1Set attrValues = attribute.getAttrValues();
                if (attrValues == null || attrValues.m14454size() == 0) {
                    throw new IllegalStateException("pkcs_9_at_extensionRequest present but has no value");
                }
                try {
                    Enumeration objects = ASN1Sequence.getInstance(attrValues.getObjectAt(0)).getObjects();
                    while (objects.hasMoreElements()) {
                        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(objects.nextElement());
                        boolean z = aSN1Sequence.mo14450size() == 3 && ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(1)).m14419isTrue();
                        if (aSN1Sequence.mo14450size() == 2) {
                            extensionsGenerator.addExtension(ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0)), false, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
                        } else {
                            if (aSN1Sequence.mo14450size() != 3) {
                                throw new IllegalStateException("incorrect sequence size of Extension get " + aSN1Sequence.mo14450size() + " expected 2 or three");
                            }
                            extensionsGenerator.addExtension(ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0)), z, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
                        }
                    }
                    return extensionsGenerator.generate();
                } catch (IllegalArgumentException e) {
                    throw Exceptions.illegalStateException("asn1 processing issue: " + e.getMessage(), e);
                }
            }
        }
        return null;
    }

    public byte[] getSignature() {
        return this.certificationRequest.getSignature().getOctets();
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.certificationRequest.getSignatureAlgorithm();
    }

    public X500Name getSubject() {
        return X500Name.getInstance(this.certificationRequest.getCertificationRequestInfo().getSubject());
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.certificationRequest.getCertificationRequestInfo().getSubjectPublicKeyInfo();
    }

    public boolean hasAltPublicKey() {
        return this.isAltRequest;
    }

    public int hashCode() {
        return toASN1Structure().hashCode();
    }

    public boolean isAltSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, PKCSException {
        if (!this.isAltRequest) {
            throw new IllegalStateException("no alternate public key present");
        }
        CertificationRequestInfo certificationRequestInfo = this.certificationRequest.getCertificationRequestInfo();
        AbstractC5093ASN1Set attributes = certificationRequestInfo.getAttributes();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration objects = attributes.getObjects();
        while (objects.hasMoreElements()) {
            Attribute attribute = Attribute.getInstance(objects.nextElement());
            if (!Extension.altSignatureValue.m14446equals((ASN1Primitive) attribute.getAttrType())) {
                aSN1EncodableVector.m14420add(attribute);
            }
        }
        CertificationRequestInfo certificationRequestInfo2 = new CertificationRequestInfo(certificationRequestInfo.getSubject(), certificationRequestInfo.getSubjectPublicKeyInfo(), new C5104DERSet(aSN1EncodableVector));
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(this.altSignature);
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            outputStream.write(certificationRequestInfo2.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(this.altSignatureValue.getOctets());
        } catch (Exception e) {
            throw new PKCSException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, PKCSException {
        CertificationRequestInfo certificationRequestInfo = this.certificationRequest.getCertificationRequestInfo();
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(this.certificationRequest.getSignatureAlgorithm());
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            outputStream.write(certificationRequestInfo.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(getSignature());
        } catch (Exception e) {
            throw new PKCSException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public CertificationRequest toASN1Structure() {
        return this.certificationRequest;
    }

    public PKCS10CertificationRequest(byte[] bArr) {
        this(parseBytes(bArr));
    }

    public Attribute[] getAttributes(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AbstractC5093ASN1Set attributes = this.certificationRequest.getCertificationRequestInfo().getAttributes();
        if (attributes == null) {
            return EMPTY_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != attributes.m14454size(); i++) {
            Attribute attribute = Attribute.getInstance(attributes.getObjectAt(i));
            if (attribute.getAttrType().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                arrayList.add(attribute);
            }
        }
        return arrayList.size() == 0 ? EMPTY_ARRAY : (Attribute[]) arrayList.toArray(new Attribute[arrayList.size()]);
    }
}
