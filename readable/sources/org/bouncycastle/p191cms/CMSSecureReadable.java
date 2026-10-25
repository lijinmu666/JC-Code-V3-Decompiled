package org.bouncycastle.p191cms;

import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;

/* loaded from: classes2.dex */
interface CMSSecureReadable {
    AbstractC5093ASN1Set getAuthAttrSet();

    ASN1ObjectIdentifier getContentType();

    InputStream getInputStream();

    boolean hasAdditionalData();

    void setAuthAttrSet(AbstractC5093ASN1Set abstractC5093ASN1Set);
}
