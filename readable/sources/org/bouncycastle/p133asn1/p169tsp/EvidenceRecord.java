package org.bouncycastle.p133asn1.p169tsp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class EvidenceRecord extends ASN1Object {

    /* renamed from: OID */
    private static final ASN1ObjectIdentifier f18549OID = new ASN1ObjectIdentifier("1.3.6.1.5.5.11.0.2.1");
    private ArchiveTimeStampSequence archiveTimeStampSequence;
    private CryptoInfos cryptoInfos;
    private ASN1Sequence digestAlgorithms;
    private EncryptionInfo encryptionInfo;

    /* renamed from: version */
    private ASN1Integer f18550version;

    private EvidenceRecord(ASN1Sequence aSN1Sequence) {
        this.f18550version = ASN1Integer.f17918ONE;
        if (aSN1Sequence.mo14450size() < 3 && aSN1Sequence.mo14450size() > 5) {
            throw new IllegalArgumentException("wrong sequence size in constructor: " + aSN1Sequence.mo14450size());
        }
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (!aSN1Integer.hasValue(1)) {
            throw new IllegalArgumentException("incompatible version");
        }
        this.f18550version = aSN1Integer;
        this.digestAlgorithms = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        for (int i = 2; i != aSN1Sequence.mo14450size() - 1; i++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i);
            if (!(objectAt instanceof ASN1TaggedObject)) {
                throw new IllegalArgumentException("unknown object in getInstance: " + objectAt.getClass().getName());
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt;
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.cryptoInfos = CryptoInfos.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 1) {
                    throw new IllegalArgumentException("unknown tag in getInstance: " + aSN1TaggedObject.getTagNo());
                }
                this.encryptionInfo = EncryptionInfo.getInstance(aSN1TaggedObject, false);
            }
        }
        this.archiveTimeStampSequence = ArchiveTimeStampSequence.getInstance(aSN1Sequence.getObjectAt(aSN1Sequence.mo14450size() - 1));
    }

    public static EvidenceRecord getInstance(Object obj) {
        if (obj instanceof EvidenceRecord) {
            return (EvidenceRecord) obj;
        }
        if (obj != null) {
            return new EvidenceRecord(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EvidenceRecord addArchiveTimeStamp(ArchiveTimeStamp archiveTimeStamp, boolean z) {
        if (z) {
            return new EvidenceRecord(this, this.archiveTimeStampSequence.m14649append(new ArchiveTimeStampChain(archiveTimeStamp)), archiveTimeStamp);
        }
        ArchiveTimeStampChain[] archiveTimeStampChains = this.archiveTimeStampSequence.getArchiveTimeStampChains();
        if (!archiveTimeStampChains[archiveTimeStampChains.length - 1].getArchiveTimestamps()[0].getDigestAlgorithmIdentifier().mo14431equals(archiveTimeStamp.getDigestAlgorithmIdentifier())) {
            throw new IllegalArgumentException("mismatch of digest algorithm in addArchiveTimeStamp");
        }
        archiveTimeStampChains[archiveTimeStampChains.length - 1] = archiveTimeStampChains[archiveTimeStampChains.length - 1].m14648append(archiveTimeStamp);
        return new EvidenceRecord(this, new ArchiveTimeStampSequence(archiveTimeStampChains), (ArchiveTimeStamp) null);
    }

    public ArchiveTimeStampSequence getArchiveTimeStampSequence() {
        return this.archiveTimeStampSequence;
    }

    public AlgorithmIdentifier[] getDigestAlgorithms() {
        int iMo14450size = this.digestAlgorithms.mo14450size();
        AlgorithmIdentifier[] algorithmIdentifierArr = new AlgorithmIdentifier[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            algorithmIdentifierArr[i] = AlgorithmIdentifier.getInstance(this.digestAlgorithms.getObjectAt(i));
        }
        return algorithmIdentifierArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18550version);
        aSN1EncodableVector.m14420add(this.digestAlgorithms);
        CryptoInfos cryptoInfos = this.cryptoInfos;
        if (cryptoInfos != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) cryptoInfos));
        }
        EncryptionInfo encryptionInfo = this.encryptionInfo;
        if (encryptionInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) encryptionInfo));
        }
        aSN1EncodableVector.m14420add(this.archiveTimeStampSequence);
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        return "EvidenceRecord: Oid(" + f18549OID + ")";
    }

    public EvidenceRecord(CryptoInfos cryptoInfos, EncryptionInfo encryptionInfo, ArchiveTimeStamp archiveTimeStamp) {
        this.f18550version = ASN1Integer.f17918ONE;
        this.digestAlgorithms = new DERSequence(archiveTimeStamp.getDigestAlgorithmIdentifier());
        this.cryptoInfos = cryptoInfos;
        this.encryptionInfo = encryptionInfo;
        this.archiveTimeStampSequence = new ArchiveTimeStampSequence(new ArchiveTimeStampChain(archiveTimeStamp));
    }

    public static EvidenceRecord getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private EvidenceRecord(EvidenceRecord evidenceRecord, ArchiveTimeStampSequence archiveTimeStampSequence, ArchiveTimeStamp archiveTimeStamp) {
        ASN1Sequence dERSequence;
        this.f18550version = ASN1Integer.f17918ONE;
        this.f18550version = evidenceRecord.f18550version;
        if (archiveTimeStamp == null) {
            dERSequence = evidenceRecord.digestAlgorithms;
            break;
        }
        AlgorithmIdentifier digestAlgorithmIdentifier = archiveTimeStamp.getDigestAlgorithmIdentifier();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration objects = evidenceRecord.digestAlgorithms.getObjects();
        while (objects.hasMoreElements()) {
            AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance(objects.nextElement());
            aSN1EncodableVector.m14420add(algorithmIdentifier);
            if (algorithmIdentifier.mo14431equals(digestAlgorithmIdentifier)) {
                dERSequence = evidenceRecord.digestAlgorithms;
                break;
            }
        }
        aSN1EncodableVector.m14420add(digestAlgorithmIdentifier);
        dERSequence = new DERSequence(aSN1EncodableVector);
        this.digestAlgorithms = dERSequence;
        this.cryptoInfos = evidenceRecord.cryptoInfos;
        this.encryptionInfo = evidenceRecord.encryptionInfo;
        this.archiveTimeStampSequence = archiveTimeStampSequence;
    }

    public EvidenceRecord(AlgorithmIdentifier[] algorithmIdentifierArr, CryptoInfos cryptoInfos, EncryptionInfo encryptionInfo, ArchiveTimeStampSequence archiveTimeStampSequence) {
        this.f18550version = ASN1Integer.f17918ONE;
        this.digestAlgorithms = new DERSequence(algorithmIdentifierArr);
        this.cryptoInfos = cryptoInfos;
        this.encryptionInfo = encryptionInfo;
        this.archiveTimeStampSequence = archiveTimeStampSequence;
    }
}
