package org.bouncycastle.p133asn1.p172x500;

import org.bouncycastle.p133asn1.ASN1BMPString;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.ASN1T61String;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.ASN1UniversalString;
import org.bouncycastle.p133asn1.DERUTF8String;

/* loaded from: classes2.dex */
public class DirectoryString extends ASN1Object implements ASN1Choice, ASN1String {

    /* renamed from: string */
    private ASN1String f18583string;

    public DirectoryString(String str) {
        this.f18583string = new DERUTF8String(str);
    }

    public static DirectoryString getInstance(Object obj) {
        if (obj == null || (obj instanceof DirectoryString)) {
            return (DirectoryString) obj;
        }
        if (obj instanceof ASN1T61String) {
            return new DirectoryString((ASN1T61String) obj);
        }
        if (obj instanceof ASN1PrintableString) {
            return new DirectoryString((ASN1PrintableString) obj);
        }
        if (obj instanceof ASN1UniversalString) {
            return new DirectoryString((ASN1UniversalString) obj);
        }
        if (obj instanceof ASN1UTF8String) {
            return new DirectoryString((ASN1UTF8String) obj);
        }
        if (obj instanceof ASN1BMPString) {
            return new DirectoryString((ASN1BMPString) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.p133asn1.ASN1String
    public String getString() {
        return this.f18583string.getString();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ((ASN1Encodable) this.f18583string).toASN1Primitive();
    }

    public String toString() {
        return this.f18583string.getString();
    }

    private DirectoryString(ASN1BMPString aSN1BMPString) {
        this.f18583string = aSN1BMPString;
    }

    public static DirectoryString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    private DirectoryString(ASN1PrintableString aSN1PrintableString) {
        this.f18583string = aSN1PrintableString;
    }

    private DirectoryString(ASN1T61String aSN1T61String) {
        this.f18583string = aSN1T61String;
    }

    private DirectoryString(ASN1UTF8String aSN1UTF8String) {
        this.f18583string = aSN1UTF8String;
    }

    private DirectoryString(ASN1UniversalString aSN1UniversalString) {
        this.f18583string = aSN1UniversalString;
    }
}
