package org.bouncycastle.p133asn1.p169tsp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ArchiveTimeStampChain extends ASN1Object {
    private ASN1Sequence archiveTimeStamps;

    private ArchiveTimeStampChain(ASN1Sequence aSN1Sequence) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(aSN1Sequence.mo14450size());
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            aSN1EncodableVector.m14420add(ArchiveTimeStamp.getInstance(objects.nextElement()));
        }
        this.archiveTimeStamps = new DERSequence(aSN1EncodableVector);
    }

    public static ArchiveTimeStampChain getInstance(Object obj) {
        if (obj instanceof ArchiveTimeStampChain) {
            return (ArchiveTimeStampChain) obj;
        }
        if (obj != null) {
            return new ArchiveTimeStampChain(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: append */
    public ArchiveTimeStampChain m14648append(ArchiveTimeStamp archiveTimeStamp) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.archiveTimeStamps.mo14450size() + 1);
        for (int i = 0; i != this.archiveTimeStamps.mo14450size(); i++) {
            aSN1EncodableVector.m14420add(this.archiveTimeStamps.getObjectAt(i));
        }
        aSN1EncodableVector.m14420add(archiveTimeStamp);
        return new ArchiveTimeStampChain(new DERSequence(aSN1EncodableVector));
    }

    public ArchiveTimeStamp[] getArchiveTimestamps() {
        int iMo14450size = this.archiveTimeStamps.mo14450size();
        ArchiveTimeStamp[] archiveTimeStampArr = new ArchiveTimeStamp[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            archiveTimeStampArr[i] = ArchiveTimeStamp.getInstance(this.archiveTimeStamps.getObjectAt(i));
        }
        return archiveTimeStampArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.archiveTimeStamps;
    }

    public ArchiveTimeStampChain(ArchiveTimeStamp archiveTimeStamp) {
        this.archiveTimeStamps = new DERSequence(archiveTimeStamp);
    }

    public ArchiveTimeStampChain(ArchiveTimeStamp[] archiveTimeStampArr) {
        this.archiveTimeStamps = new DERSequence(archiveTimeStampArr);
    }
}
