package org.bouncycastle.p133asn1.p145esf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p172x500.DirectoryString;

/* loaded from: classes2.dex */
public class SignerLocation extends ASN1Object {
    private DirectoryString countryName;
    private DirectoryString localityName;
    private ASN1Sequence postalAddress;

    private SignerLocation(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(objects.nextElement());
            int tagNo = contextInstance.getTagNo();
            if (tagNo == 0) {
                this.countryName = DirectoryString.getInstance(contextInstance, true);
            } else if (tagNo == 1) {
                this.localityName = DirectoryString.getInstance(contextInstance, true);
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("illegal tag");
                }
                this.postalAddress = contextInstance.isExplicit() ? ASN1Sequence.getInstance(contextInstance, true) : ASN1Sequence.getInstance(contextInstance, false);
                ASN1Sequence aSN1Sequence2 = this.postalAddress;
                if (aSN1Sequence2 != null && aSN1Sequence2.mo14450size() > 6) {
                    throw new IllegalArgumentException("postal address must contain less than 6 strings");
                }
            }
        }
    }

    public static SignerLocation getInstance(Object obj) {
        return (obj == null || (obj instanceof SignerLocation)) ? (SignerLocation) obj : new SignerLocation(ASN1Sequence.getInstance(obj));
    }

    public DirectoryString getCountry() {
        return this.countryName;
    }

    public DERUTF8String getCountryName() {
        if (this.countryName == null) {
            return null;
        }
        return new DERUTF8String(getCountry().getString());
    }

    public DirectoryString getLocality() {
        return this.localityName;
    }

    public DERUTF8String getLocalityName() {
        if (this.localityName == null) {
            return null;
        }
        return new DERUTF8String(getLocality().getString());
    }

    public DirectoryString[] getPostal() {
        ASN1Sequence aSN1Sequence = this.postalAddress;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        DirectoryString[] directoryStringArr = new DirectoryString[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            directoryStringArr[i] = DirectoryString.getInstance(this.postalAddress.getObjectAt(i));
        }
        return directoryStringArr;
    }

    public ASN1Sequence getPostalAddress() {
        return this.postalAddress;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        DirectoryString directoryString = this.countryName;
        if (directoryString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) directoryString));
        }
        DirectoryString directoryString2 = this.localityName;
        if (directoryString2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) directoryString2));
        }
        ASN1Sequence aSN1Sequence = this.postalAddress;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) aSN1Sequence));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SignerLocation(ASN1UTF8String aSN1UTF8String, ASN1UTF8String aSN1UTF8String2, ASN1Sequence aSN1Sequence) {
        this(DirectoryString.getInstance(aSN1UTF8String), DirectoryString.getInstance(aSN1UTF8String2), aSN1Sequence);
    }

    private SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence != null && aSN1Sequence.mo14450size() > 6) {
            throw new IllegalArgumentException("postal address must contain less than 6 strings");
        }
        this.countryName = directoryString;
        this.localityName = directoryString2;
        this.postalAddress = aSN1Sequence;
    }

    public SignerLocation(DirectoryString directoryString, DirectoryString directoryString2, DirectoryString[] directoryStringArr) {
        this(directoryString, directoryString2, new DERSequence(directoryStringArr));
    }
}
