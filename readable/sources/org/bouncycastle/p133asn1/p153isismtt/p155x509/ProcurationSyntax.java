package org.bouncycastle.p133asn1.p153isismtt.p155x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.DirectoryString;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;

/* loaded from: classes2.dex */
public class ProcurationSyntax extends ASN1Object {

    /* renamed from: certRef */
    private IssuerSerial f18409certRef;

    /* renamed from: country */
    private String f18410country;
    private GeneralName thirdPerson;
    private DirectoryString typeOfSubstitution;

    public ProcurationSyntax(String str, DirectoryString directoryString, GeneralName generalName) {
        this.f18410country = str;
        this.typeOfSubstitution = directoryString;
        this.thirdPerson = generalName;
        this.f18409certRef = null;
    }

    public static ProcurationSyntax getInstance(Object obj) {
        if (obj == null || (obj instanceof ProcurationSyntax)) {
            return (ProcurationSyntax) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProcurationSyntax((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public IssuerSerial getCertRef() {
        return this.f18409certRef;
    }

    public String getCountry() {
        return this.f18410country;
    }

    public GeneralName getThirdPerson() {
        return this.thirdPerson;
    }

    public DirectoryString getTypeOfSubstitution() {
        return this.typeOfSubstitution;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        if (this.f18410country != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) new DERPrintableString(this.f18410country, true)));
        }
        DirectoryString directoryString = this.typeOfSubstitution;
        if (directoryString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) directoryString));
        }
        GeneralName generalName = this.thirdPerson;
        if (generalName != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 3, (ASN1Encodable) generalName));
        } else {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 3, (ASN1Encodable) this.f18409certRef));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ProcurationSyntax(String str, DirectoryString directoryString, IssuerSerial issuerSerial) {
        this.f18410country = str;
        this.typeOfSubstitution = directoryString;
        this.thirdPerson = null;
        this.f18409certRef = issuerSerial;
    }

    private ProcurationSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(objects.nextElement());
            int tagNo = contextInstance.getTagNo();
            if (tagNo == 1) {
                this.f18410country = ASN1PrintableString.getInstance(contextInstance, true).getString();
            } else if (tagNo == 2) {
                this.typeOfSubstitution = DirectoryString.getInstance(contextInstance, true);
            } else {
                if (tagNo != 3) {
                    throw new IllegalArgumentException("Bad tag number: " + contextInstance.getTagNo());
                }
                ASN1Object explicitBaseObject = contextInstance.getExplicitBaseObject();
                if (explicitBaseObject instanceof ASN1TaggedObject) {
                    this.thirdPerson = GeneralName.getInstance(explicitBaseObject);
                } else {
                    this.f18409certRef = IssuerSerial.getInstance(explicitBaseObject);
                }
            }
        }
    }
}
