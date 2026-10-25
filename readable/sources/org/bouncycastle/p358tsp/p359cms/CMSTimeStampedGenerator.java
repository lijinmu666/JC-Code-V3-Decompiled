package org.bouncycastle.p358tsp.p359cms;

import java.io.IOException;
import java.net.URI;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p139cms.Attributes;
import org.bouncycastle.p133asn1.p139cms.MetaData;
import org.bouncycastle.p191cms.CMSException;

/* loaded from: classes2.dex */
public class CMSTimeStampedGenerator {

    /* renamed from: dataUri */
    protected URI f24173dataUri;
    protected MetaData metaData;

    public void initialiseMessageImprintDigestCalculator(DigestCalculator digestCalculator) throws CMSException, IOException {
        new MetaDataUtil(this.metaData).initialiseMessageImprintDigestCalculator(digestCalculator);
    }

    public void setDataUri(URI uri) {
        this.f24173dataUri = uri;
    }

    public void setMetaData(boolean z, String str, String str2) {
        setMetaData(z, str, str2, (Attributes) null);
    }

    public void setMetaData(boolean z, String str, String str2, Attributes attributes) {
        setMetaData(z, str != null ? new DERUTF8String(str) : null, str2 != null ? new DERIA5String(str2) : null, attributes);
    }

    private void setMetaData(boolean z, ASN1UTF8String aSN1UTF8String, ASN1IA5String aSN1IA5String, Attributes attributes) {
        this.metaData = new MetaData(ASN1Boolean.getInstance(z), aSN1UTF8String, aSN1IA5String, attributes);
    }
}
