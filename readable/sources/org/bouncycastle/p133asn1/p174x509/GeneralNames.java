package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class GeneralNames extends ASN1Object {

    /* renamed from: names */
    private final GeneralName[] f18656names;

    private GeneralNames(ASN1Sequence aSN1Sequence) {
        this.f18656names = new GeneralName[aSN1Sequence.mo14450size()];
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            this.f18656names[i] = GeneralName.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    /* renamed from: copy */
    private static GeneralName[] m14691copy(GeneralName[] generalNameArr) {
        GeneralName[] generalNameArr2 = new GeneralName[generalNameArr.length];
        System.arraycopy(generalNameArr, 0, generalNameArr2, 0, generalNameArr.length);
        return generalNameArr2;
    }

    public static GeneralNames fromExtensions(Extensions extensions, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, aSN1ObjectIdentifier));
    }

    public static GeneralNames getInstance(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        if (obj != null) {
            return new GeneralNames(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName[] getNames() {
        return m14691copy(this.f18656names);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18656names);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("GeneralNames:");
        sb.append(strLineSeparator);
        for (int i = 0; i != this.f18656names.length; i++) {
            sb.append("    ");
            sb.append(this.f18656names[i]);
            sb.append(strLineSeparator);
        }
        return sb.toString();
    }

    public GeneralNames(GeneralName generalName) {
        this.f18656names = new GeneralName[]{generalName};
    }

    public static GeneralNames getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralNames(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralNames(GeneralName[] generalNameArr) {
        this.f18656names = m14691copy(generalNameArr);
    }
}
