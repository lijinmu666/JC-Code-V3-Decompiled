package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class TargetEtcChain extends ASN1Object {

    /* renamed from: chain */
    private ASN1Sequence f18324chain;
    private PathProcInput pathProcInput;

    /* renamed from: target */
    private CertEtcToken f18325target;

    private TargetEtcChain(ASN1Sequence aSN1Sequence) {
        this.f18325target = CertEtcToken.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
            if (objectAt instanceof ASN1TaggedObject) {
                extractPathProcInput(objectAt);
                return;
            }
            this.f18324chain = ASN1Sequence.getInstance(objectAt);
            if (aSN1Sequence.mo14450size() > 2) {
                extractPathProcInput(aSN1Sequence.getObjectAt(2));
            }
        }
    }

    public static TargetEtcChain[] arrayFromSequence(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        TargetEtcChain[] targetEtcChainArr = new TargetEtcChain[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            targetEtcChainArr[i] = getInstance(aSN1Sequence.getObjectAt(i));
        }
        return targetEtcChainArr;
    }

    private void extractPathProcInput(ASN1Encodable aSN1Encodable) {
        ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Encodable);
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.pathProcInput = PathProcInput.getInstance(aSN1TaggedObject, false);
            return;
        }
        throw new IllegalArgumentException("Unknown tag encountered: " + aSN1TaggedObject.getTagNo());
    }

    public static TargetEtcChain getInstance(Object obj) {
        if (obj instanceof TargetEtcChain) {
            return (TargetEtcChain) obj;
        }
        if (obj != null) {
            return new TargetEtcChain(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertEtcToken[] getChain() {
        ASN1Sequence aSN1Sequence = this.f18324chain;
        if (aSN1Sequence != null) {
            return CertEtcToken.arrayFromSequence(aSN1Sequence);
        }
        return null;
    }

    public PathProcInput getPathProcInput() {
        return this.pathProcInput;
    }

    public CertEtcToken getTarget() {
        return this.f18325target;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18325target);
        ASN1Sequence aSN1Sequence = this.f18324chain;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        PathProcInput pathProcInput = this.pathProcInput;
        if (pathProcInput != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) pathProcInput));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TargetEtcChain {\n");
        sb.append("target: " + this.f18325target + "\n");
        if (this.f18324chain != null) {
            sb.append("chain: " + this.f18324chain + "\n");
        }
        if (this.pathProcInput != null) {
            sb.append("pathProcInput: " + this.pathProcInput + "\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    public TargetEtcChain(CertEtcToken certEtcToken) {
        this(certEtcToken, null, null);
    }

    public static TargetEtcChain getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public TargetEtcChain(CertEtcToken certEtcToken, PathProcInput pathProcInput) {
        this(certEtcToken, null, pathProcInput);
    }

    public TargetEtcChain(CertEtcToken certEtcToken, CertEtcToken[] certEtcTokenArr) {
        this(certEtcToken, certEtcTokenArr, null);
    }

    public TargetEtcChain(CertEtcToken certEtcToken, CertEtcToken[] certEtcTokenArr, PathProcInput pathProcInput) {
        this.f18325target = certEtcToken;
        if (certEtcTokenArr != null) {
            this.f18324chain = new DERSequence(certEtcTokenArr);
        }
        this.pathProcInput = pathProcInput;
    }
}
