package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class DistributionPointName extends ASN1Object implements ASN1Choice {
    public static final int FULL_NAME = 0;
    public static final int NAME_RELATIVE_TO_CRL_ISSUER = 1;

    /* renamed from: name */
    private final ASN1Encodable f18648name;

    /* renamed from: type */
    private final int f18649type;

    public DistributionPointName(int i, ASN1Encodable aSN1Encodable) {
        this.f18649type = i;
        this.f18648name = aSN1Encodable;
    }

    private void appendObject(StringBuilder sb, String str, String str2, String str3) {
        sb.append("    ");
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        sb.append("    ");
        sb.append("    ");
        sb.append(str3);
        sb.append(str);
    }

    public static DistributionPointName getInstance(Object obj) {
        if (obj == null || (obj instanceof DistributionPointName)) {
            return (DistributionPointName) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new DistributionPointName((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static DistributionPointName getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Util.getTaggedChoiceBaseObject(aSN1TaggedObject, z, "DistributionPointName"));
    }

    /* renamed from: getName */
    public ASN1Encodable m14683getName() {
        return this.f18648name;
    }

    /* renamed from: getType */
    public int m14684getType() {
        return this.f18649type;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18649type, this.f18648name);
    }

    public String toString() {
        String string;
        String str;
        String strLineSeparator = C6250Strings.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("DistributionPointName: [");
        sb.append(strLineSeparator);
        if (this.f18649type == 0) {
            string = this.f18648name.toString();
            str = "fullName";
        } else {
            string = this.f18648name.toString();
            str = "nameRelativeToCRLIssuer";
        }
        appendObject(sb, strLineSeparator, str, string);
        sb.append("]");
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public DistributionPointName(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable abstractC5093ASN1Set;
        this.f18649type = aSN1TaggedObject.getTagNo();
        if (aSN1TaggedObject.hasContextTag(0)) {
            abstractC5093ASN1Set = GeneralNames.getInstance(aSN1TaggedObject, false);
        } else {
            if (!aSN1TaggedObject.hasContextTag(1)) {
                throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(aSN1TaggedObject));
            }
            abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
        }
        this.f18648name = abstractC5093ASN1Set;
    }

    public static DistributionPointName getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Util.getInstanceChoiceBaseObject(aSN1TaggedObject, z, "DistributionPointName"));
    }

    public DistributionPointName(GeneralNames generalNames) {
        this(0, generalNames);
    }
}
