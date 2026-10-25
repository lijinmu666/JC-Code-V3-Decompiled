package org.bouncycastle.p191cms;

import java.util.Map;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;

/* loaded from: classes2.dex */
public class SimpleAttributeTableGenerator implements CMSAttributeTableGenerator {
    private final AttributeTable attributes;

    public SimpleAttributeTableGenerator(AttributeTable attributeTable) {
        this.attributes = attributeTable;
    }

    @Override // org.bouncycastle.p191cms.CMSAttributeTableGenerator
    public AttributeTable getAttributes(Map map) {
        return this.attributes;
    }
}
