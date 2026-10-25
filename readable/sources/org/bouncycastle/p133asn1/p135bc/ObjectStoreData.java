package org.bouncycastle.p133asn1.p135bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERGeneralizedTime;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class ObjectStoreData extends ASN1Object {

    /* renamed from: comment */
    private final String f18048comment;
    private final ASN1GeneralizedTime creationDate;
    private final AlgorithmIdentifier integrityAlgorithm;
    private final ASN1GeneralizedTime lastModifiedDate;
    private final ObjectDataSequence objectDataSequence;

    /* renamed from: version */
    private final BigInteger f18049version;

    private ObjectStoreData(ASN1Sequence aSN1Sequence) {
        this.f18049version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue();
        this.integrityAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.creationDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        this.objectDataSequence = ObjectDataSequence.getInstance(aSN1Sequence.getObjectAt(4));
        this.f18048comment = aSN1Sequence.mo14450size() == 6 ? ASN1UTF8String.getInstance(aSN1Sequence.getObjectAt(5)).getString() : null;
    }

    public static ObjectStoreData getInstance(Object obj) {
        if (obj instanceof ObjectStoreData) {
            return (ObjectStoreData) obj;
        }
        if (obj != null) {
            return new ObjectStoreData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public String getComment() {
        return this.f18048comment;
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    public AlgorithmIdentifier getIntegrityAlgorithm() {
        return this.integrityAlgorithm;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public ObjectDataSequence getObjectDataSequence() {
        return this.objectDataSequence;
    }

    public BigInteger getVersion() {
        return this.f18049version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(new ASN1Integer(this.f18049version));
        aSN1EncodableVector.m14420add(this.integrityAlgorithm);
        aSN1EncodableVector.m14420add(this.creationDate);
        aSN1EncodableVector.m14420add(this.lastModifiedDate);
        aSN1EncodableVector.m14420add(this.objectDataSequence);
        if (this.f18048comment != null) {
            aSN1EncodableVector.m14420add(new DERUTF8String(this.f18048comment));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ObjectStoreData(AlgorithmIdentifier algorithmIdentifier, Date date, Date date2, ObjectDataSequence objectDataSequence, String str) {
        this.f18049version = BigInteger.valueOf(1L);
        this.integrityAlgorithm = algorithmIdentifier;
        this.creationDate = new DERGeneralizedTime(date);
        this.lastModifiedDate = new DERGeneralizedTime(date2);
        this.objectDataSequence = objectDataSequence;
        this.f18048comment = str;
    }
}
