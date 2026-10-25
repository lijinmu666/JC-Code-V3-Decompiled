package org.bouncycastle.p191cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.CMSAlgorithmProtection;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class DefaultAuthenticatedAttributeTableGenerator implements CMSAttributeTableGenerator {

    /* renamed from: table */
    private final Hashtable f19012table;

    public DefaultAuthenticatedAttributeTableGenerator() {
        this.f19012table = new Hashtable();
    }

    public Hashtable createStandardAttributeTable(Map map) {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.f19012table.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable.put(objNextElement, this.f19012table.get(objNextElement));
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSAttributes.contentType;
        if (!hashtable.containsKey(aSN1ObjectIdentifier)) {
            Attribute attribute = new Attribute(aSN1ObjectIdentifier, new C5104DERSet(ASN1ObjectIdentifier.getInstance(map.get(CMSAttributeTableGenerator.CONTENT_TYPE))));
            hashtable.put(attribute.getAttrType(), attribute);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAttributes.messageDigest;
        if (!hashtable.containsKey(aSN1ObjectIdentifier2)) {
            Attribute attribute2 = new Attribute(aSN1ObjectIdentifier2, new C5104DERSet(new DEROctetString((byte[]) map.get(CMSAttributeTableGenerator.f18937DIGEST))));
            hashtable.put(attribute2.getAttrType(), attribute2);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAttributes.cmsAlgorithmProtect;
        if (!hashtable.contains(aSN1ObjectIdentifier3)) {
            Attribute attribute3 = new Attribute(aSN1ObjectIdentifier3, new C5104DERSet(new CMSAlgorithmProtection((AlgorithmIdentifier) map.get(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER), 2, (AlgorithmIdentifier) map.get(CMSAttributeTableGenerator.MAC_ALGORITHM_IDENTIFIER))));
            hashtable.put(attribute3.getAttrType(), attribute3);
        }
        return hashtable;
    }

    @Override // org.bouncycastle.p191cms.CMSAttributeTableGenerator
    public AttributeTable getAttributes(Map map) {
        return new AttributeTable(createStandardAttributeTable(map));
    }

    public DefaultAuthenticatedAttributeTableGenerator(AttributeTable attributeTable) {
        this.f19012table = attributeTable != null ? attributeTable.toHashtable() : new Hashtable();
    }
}
