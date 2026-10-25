package org.bouncycastle.p133asn1.p168smime;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;

/* loaded from: classes2.dex */
public class SMIMECapabilities extends ASN1Object {
    private ASN1Sequence capabilities;
    public static final ASN1ObjectIdentifier preferSignedData = PKCSObjectIdentifiers.preferSignedData;
    public static final ASN1ObjectIdentifier canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
    public static final ASN1ObjectIdentifier sMIMECapabilitesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
    public static final ASN1ObjectIdentifier aes256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
    public static final ASN1ObjectIdentifier aes192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
    public static final ASN1ObjectIdentifier aes128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
    public static final ASN1ObjectIdentifier idea_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
    public static final ASN1ObjectIdentifier cast5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10");

    /* renamed from: dES_CBC */
    public static final ASN1ObjectIdentifier f18538dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
    public static final ASN1ObjectIdentifier dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;

    /* renamed from: rC2_CBC */
    public static final ASN1ObjectIdentifier f18539rC2_CBC = PKCSObjectIdentifiers.f18490RC2_CBC;

    public SMIMECapabilities(ASN1Sequence aSN1Sequence) {
        this.capabilities = aSN1Sequence;
    }

    public static SMIMECapabilities getInstance(Object obj) {
        if (obj == null || (obj instanceof SMIMECapabilities)) {
            return (SMIMECapabilities) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SMIMECapabilities((ASN1Sequence) obj);
        }
        if (obj instanceof Attribute) {
            return new SMIMECapabilities((ASN1Sequence) ((Attribute) obj).getAttrValues().getObjectAt(0));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public Vector getCapabilities(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Enumeration objects = this.capabilities.getObjects();
        Vector vector = new Vector();
        if (aSN1ObjectIdentifier == null) {
            while (objects.hasMoreElements()) {
                vector.addElement(SMIMECapability.getInstance(objects.nextElement()));
            }
        } else {
            while (objects.hasMoreElements()) {
                SMIMECapability sMIMECapability = SMIMECapability.getInstance(objects.nextElement());
                if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) sMIMECapability.getCapabilityID())) {
                    vector.addElement(sMIMECapability);
                }
            }
        }
        return vector;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.capabilities;
    }
}
