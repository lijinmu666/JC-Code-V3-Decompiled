package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class SignerInfo extends ASN1Object {
    private AbstractC5093ASN1Set authenticatedAttributes;
    private AlgorithmIdentifier digAlgorithm;
    private AlgorithmIdentifier digEncryptionAlgorithm;
    private ASN1OctetString encryptedDigest;
    private IssuerAndSerialNumber issuerAndSerialNumber;
    private AbstractC5093ASN1Set unauthenticatedAttributes;

    /* renamed from: version */
    private ASN1Integer f18528version;

    public SignerInfo(ASN1Integer aSN1Integer, IssuerAndSerialNumber issuerAndSerialNumber, AlgorithmIdentifier algorithmIdentifier, AbstractC5093ASN1Set abstractC5093ASN1Set, AlgorithmIdentifier algorithmIdentifier2, ASN1OctetString aSN1OctetString, AbstractC5093ASN1Set abstractC5093ASN1Set2) {
        this.f18528version = aSN1Integer;
        this.issuerAndSerialNumber = issuerAndSerialNumber;
        this.digAlgorithm = algorithmIdentifier;
        this.authenticatedAttributes = abstractC5093ASN1Set;
        this.digEncryptionAlgorithm = algorithmIdentifier2;
        this.encryptedDigest = aSN1OctetString;
        this.unauthenticatedAttributes = abstractC5093ASN1Set2;
    }

    public static SignerInfo getInstance(Object obj) {
        if (obj instanceof SignerInfo) {
            return (SignerInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignerInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public AbstractC5093ASN1Set getAuthenticatedAttributes() {
        return this.authenticatedAttributes;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digAlgorithm;
    }

    public AlgorithmIdentifier getDigestEncryptionAlgorithm() {
        return this.digEncryptionAlgorithm;
    }

    public ASN1OctetString getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerAndSerialNumber;
    }

    public AbstractC5093ASN1Set getUnauthenticatedAttributes() {
        return this.unauthenticatedAttributes;
    }

    public ASN1Integer getVersion() {
        return this.f18528version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.m14420add(this.f18528version);
        aSN1EncodableVector.m14420add(this.issuerAndSerialNumber);
        aSN1EncodableVector.m14420add(this.digAlgorithm);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authenticatedAttributes;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        aSN1EncodableVector.m14420add(this.digEncryptionAlgorithm);
        aSN1EncodableVector.m14420add(this.encryptedDigest);
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.unauthenticatedAttributes;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SignerInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18528version = (ASN1Integer) objects.nextElement();
        this.issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(objects.nextElement());
        this.digAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        Object objNextElement = objects.nextElement();
        if (objNextElement instanceof ASN1TaggedObject) {
            this.authenticatedAttributes = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) objNextElement, false);
            objNextElement = objects.nextElement();
        } else {
            this.authenticatedAttributes = null;
        }
        this.digEncryptionAlgorithm = AlgorithmIdentifier.getInstance(objNextElement);
        this.encryptedDigest = ASN1OctetString.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.unauthenticatedAttributes = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
        } else {
            this.unauthenticatedAttributes = null;
        }
    }
}
