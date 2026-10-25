package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p141crmf.CertTemplate;

/* loaded from: classes.dex */
public class ModCertTemplate extends ASN1Object {
    private final BodyPartList certReferences;
    private final CertTemplate certTemplate;
    private final BodyPartPath pkiDataReference;

    /* renamed from: replace */
    private final boolean f18084replace;

    private ModCertTemplate(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        if (aSN1Sequence.mo14450size() != 4 && aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.pkiDataReference = BodyPartPath.getInstance(aSN1Sequence.getObjectAt(0));
        this.certReferences = BodyPartList.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() == 4) {
            this.f18084replace = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(2)).m14419isTrue();
            objectAt = aSN1Sequence.getObjectAt(3);
        } else {
            this.f18084replace = true;
            objectAt = aSN1Sequence.getObjectAt(2);
        }
        this.certTemplate = CertTemplate.getInstance(objectAt);
    }

    public static ModCertTemplate getInstance(Object obj) {
        if (obj instanceof ModCertTemplate) {
            return (ModCertTemplate) obj;
        }
        if (obj != null) {
            return new ModCertTemplate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartList getCertReferences() {
        return this.certReferences;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public BodyPartPath getPkiDataReference() {
        return this.pkiDataReference;
    }

    public boolean isReplacingFields() {
        return this.f18084replace;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.pkiDataReference);
        aSN1EncodableVector.m14420add(this.certReferences);
        boolean z = this.f18084replace;
        if (!z) {
            aSN1EncodableVector.m14420add(ASN1Boolean.getInstance(z));
        }
        aSN1EncodableVector.m14420add(this.certTemplate);
        return new DERSequence(aSN1EncodableVector);
    }

    public ModCertTemplate(BodyPartPath bodyPartPath, BodyPartList bodyPartList, boolean z, CertTemplate certTemplate) {
        this.pkiDataReference = bodyPartPath;
        this.certReferences = bodyPartList;
        this.f18084replace = z;
        this.certTemplate = certTemplate;
    }
}
