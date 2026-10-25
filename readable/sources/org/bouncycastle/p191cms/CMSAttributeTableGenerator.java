package org.bouncycastle.p191cms;

import java.util.Map;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;

/* loaded from: classes2.dex */
public interface CMSAttributeTableGenerator {
    public static final String CONTENT_TYPE = "contentType";

    /* renamed from: DIGEST */
    public static final String f18937DIGEST = "digest";
    public static final String DIGEST_ALGORITHM_IDENTIFIER = "digestAlgID";
    public static final String MAC_ALGORITHM_IDENTIFIER = "macAlgID";
    public static final String SIGNATURE = "encryptedDigest";
    public static final String SIGNATURE_ALGORITHM_IDENTIFIER = "signatureAlgID";

    AttributeTable getAttributes(Map map);
}
