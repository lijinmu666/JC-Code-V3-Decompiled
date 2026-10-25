package org.bouncycastle.p191cms;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.C5115Time;
import org.bouncycastle.p133asn1.p139cms.CMSAlgorithmProtection;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class DefaultSignedAttributeTableGenerator implements CMSAttributeTableGenerator {

    /* renamed from: table */
    private final Hashtable f19013table;

    public DefaultSignedAttributeTableGenerator() {
        this.f19013table = new Hashtable();
    }

    private static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    public Hashtable createStandardAttributeTable(Map map) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        Hashtable hashtableCopyHashTable = copyHashTable(this.f19013table);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAttributes.contentType;
        if (!hashtableCopyHashTable.containsKey(aSN1ObjectIdentifier2) && (aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(map.get(CMSAttributeTableGenerator.CONTENT_TYPE))) != null) {
            Attribute attribute = new Attribute(aSN1ObjectIdentifier2, new C5104DERSet(aSN1ObjectIdentifier));
            hashtableCopyHashTable.put(attribute.getAttrType(), attribute);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAttributes.signingTime;
        if (!hashtableCopyHashTable.containsKey(aSN1ObjectIdentifier3)) {
            Attribute attribute2 = new Attribute(aSN1ObjectIdentifier3, new C5104DERSet(new C5115Time(new Date())));
            hashtableCopyHashTable.put(attribute2.getAttrType(), attribute2);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CMSAttributes.messageDigest;
        if (!hashtableCopyHashTable.containsKey(aSN1ObjectIdentifier4)) {
            Attribute attribute3 = new Attribute(aSN1ObjectIdentifier4, new C5104DERSet(new DEROctetString((byte[]) map.get(CMSAttributeTableGenerator.f18937DIGEST))));
            hashtableCopyHashTable.put(attribute3.getAttrType(), attribute3);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CMSAttributes.cmsAlgorithmProtect;
        if (!hashtableCopyHashTable.contains(aSN1ObjectIdentifier5)) {
            Attribute attribute4 = new Attribute(aSN1ObjectIdentifier5, new C5104DERSet(new CMSAlgorithmProtection((AlgorithmIdentifier) map.get(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER), 1, (AlgorithmIdentifier) map.get(CMSAttributeTableGenerator.SIGNATURE_ALGORITHM_IDENTIFIER))));
            hashtableCopyHashTable.put(attribute4.getAttrType(), attribute4);
        }
        return hashtableCopyHashTable;
    }

    @Override // org.bouncycastle.p191cms.CMSAttributeTableGenerator
    public AttributeTable getAttributes(Map map) {
        return new AttributeTable(createStandardAttributeTable(map));
    }

    public DefaultSignedAttributeTableGenerator(AttributeTable attributeTable) {
        this.f19013table = attributeTable != null ? attributeTable.toHashtable() : new Hashtable();
    }
}
