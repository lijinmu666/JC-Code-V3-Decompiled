package org.bouncycastle.p307pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;
import org.bouncycastle.p133asn1.p166pkcs.C5134CRLBag;
import org.bouncycastle.p133asn1.p166pkcs.C5135CertBag;
import org.bouncycastle.p133asn1.p166pkcs.C5138SafeBag;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class PKCS12SafeBag {
    public static final ASN1ObjectIdentifier friendlyNameAttribute = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
    public static final ASN1ObjectIdentifier localKeyIdAttribute = PKCSObjectIdentifiers.pkcs_9_at_localKeyId;

    /* renamed from: safeBag */
    private C5138SafeBag f22930safeBag;

    public PKCS12SafeBag(C5138SafeBag c5138SafeBag) {
        this.f22930safeBag = c5138SafeBag;
    }

    public Attribute[] getAttributes() {
        AbstractC5093ASN1Set bagAttributes = this.f22930safeBag.getBagAttributes();
        if (bagAttributes == null) {
            return null;
        }
        Attribute[] attributeArr = new Attribute[bagAttributes.m14454size()];
        for (int i = 0; i != bagAttributes.m14454size(); i++) {
            attributeArr[i] = Attribute.getInstance(bagAttributes.getObjectAt(i));
        }
        return attributeArr;
    }

    public Object getBagValue() {
        if (m17412getType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs8ShroudedKeyBag)) {
            return new PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo.getInstance(this.f22930safeBag.getBagValue()));
        }
        if (m17412getType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18491certBag)) {
            return new X509CertificateHolder(Certificate.getInstance(ASN1OctetString.getInstance(C5135CertBag.getInstance(this.f22930safeBag.getBagValue()).getCertValue()).getOctets()));
        }
        if (m17412getType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18500keyBag)) {
            return PrivateKeyInfo.getInstance(this.f22930safeBag.getBagValue());
        }
        boolean zM14446equals = m17412getType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18492crlBag);
        ASN1Encodable bagValue = this.f22930safeBag.getBagValue();
        return zM14446equals ? new X509CRLHolder(CertificateList.getInstance(ASN1OctetString.getInstance(C5134CRLBag.getInstance(bagValue).getCrlValue()).getOctets())) : bagValue;
    }

    /* renamed from: getType */
    public ASN1ObjectIdentifier m17412getType() {
        return this.f22930safeBag.getBagId();
    }

    public C5138SafeBag toASN1Structure() {
        return this.f22930safeBag;
    }
}
