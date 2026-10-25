package org.bouncycastle.p307pkcs;

import java.util.Enumeration;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequest;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequestInfo;

/* loaded from: classes2.dex */
public class DeltaCertAttributeUtils {
    public static boolean isDeltaRequestSignatureValid(PKCS10CertificationRequest pKCS10CertificationRequest, ContentVerifierProvider contentVerifierProvider) {
        DeltaCertificateRequestAttributeValue deltaCertificateRequestAttributeValue = new DeltaCertificateRequestAttributeValue(pKCS10CertificationRequest.getAttributes(new ASN1ObjectIdentifier("2.16.840.1.114027.80.6.2"))[0]);
        Attribute[] attributes = pKCS10CertificationRequest.getAttributes(new ASN1ObjectIdentifier("2.16.840.1.114027.80.6.3"));
        CertificationRequestInfo certificationRequestInfo = pKCS10CertificationRequest.toASN1Structure().getCertificationRequestInfo();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(certificationRequestInfo.getVersion());
        aSN1EncodableVector.m14420add(certificationRequestInfo.getSubject());
        aSN1EncodableVector.m14420add(certificationRequestInfo.getSubjectPublicKeyInfo());
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration objects = certificationRequestInfo.getAttributes().getObjects();
        while (objects.hasMoreElements()) {
            Attribute attribute = Attribute.getInstance(objects.nextElement());
            if (!attribute.getAttrType().m14446equals((ASN1Primitive) new ASN1ObjectIdentifier("2.16.840.1.114027.80.6.3"))) {
                aSN1EncodableVector2.m14420add(attribute);
            }
        }
        aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) new C5104DERSet(aSN1EncodableVector2)));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.m14420add(new DERSequence(aSN1EncodableVector));
        aSN1EncodableVector3.m14420add(deltaCertificateRequestAttributeValue.getSignatureAlgorithm());
        aSN1EncodableVector3.m14420add(attributes[0].getAttributeValues()[0]);
        return new PKCS10CertificationRequest(CertificationRequest.getInstance(new DERSequence(aSN1EncodableVector3))).isSignatureValid(contentVerifierProvider);
    }
}
