package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.DistributionPointName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;

/* loaded from: classes.dex */
public class CRLSource extends ASN1Object implements ASN1Choice {

    /* renamed from: dpn */
    private final DistributionPointName f18097dpn;

    /* renamed from: issuer */
    private final GeneralNames f18098issuer;

    private CRLSource(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.hasContextTag(0)) {
            this.f18097dpn = DistributionPointName.getInstance(aSN1TaggedObject, true);
            this.f18098issuer = null;
        } else if (aSN1TaggedObject.hasContextTag(1)) {
            this.f18097dpn = null;
            this.f18098issuer = GeneralNames.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(aSN1TaggedObject));
        }
    }

    public static CRLSource getInstance(Object obj) {
        if (obj instanceof CRLSource) {
            return (CRLSource) obj;
        }
        if (obj != null) {
            return new CRLSource(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getDpn */
    public DistributionPointName m14500getDpn() {
        return this.f18097dpn;
    }

    public GeneralNames getIssuer() {
        return this.f18098issuer;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        DistributionPointName distributionPointName = this.f18097dpn;
        return distributionPointName != null ? new DERTaggedObject(true, 0, (ASN1Encodable) distributionPointName) : new DERTaggedObject(true, 1, (ASN1Encodable) this.f18098issuer);
    }

    public CRLSource(DistributionPointName distributionPointName, GeneralNames generalNames) {
        if ((distributionPointName == null) == (generalNames == null)) {
            throw new IllegalArgumentException("either dpn or issuer must be set");
        }
        this.f18097dpn = distributionPointName;
        this.f18098issuer = generalNames;
    }
}
