package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class KemOtherInfo extends ASN1Object {
    private static final PKIFreeText DEFAULT_staticString = new PKIFreeText("CMP-KEM");

    /* renamed from: ct */
    private final ASN1OctetString f18119ct;

    /* renamed from: len */
    private final ASN1Integer f18120len;

    /* renamed from: mac */
    private final AlgorithmIdentifier f18121mac;
    private final ASN1OctetString recipNonce;
    private final ASN1OctetString senderNonce;
    private final PKIFreeText staticString;
    private final ASN1OctetString transactionID;

    public KemOtherInfo(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString aSN1OctetString3, long j, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString4) {
        this(aSN1OctetString, aSN1OctetString2, aSN1OctetString3, ASN1Integer.m14430valueOf(j), algorithmIdentifier, aSN1OctetString4);
    }

    private static void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static KemOtherInfo getInstance(Object obj) {
        if (obj instanceof KemOtherInfo) {
            return (KemOtherInfo) obj;
        }
        if (obj != null) {
            return new KemOtherInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static ASN1TaggedObject tryGetTagged(ASN1Sequence aSN1Sequence, int i) {
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i);
        if (objectAt instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) objectAt;
        }
        return null;
    }

    /* renamed from: getCt */
    public ASN1OctetString m14511getCt() {
        return this.f18119ct;
    }

    /* renamed from: getLen */
    public ASN1Integer m14512getLen() {
        return this.f18120len;
    }

    /* renamed from: getMac */
    public AlgorithmIdentifier m14513getMac() {
        return this.f18121mac;
    }

    public ASN1OctetString getRecipNonce() {
        return this.recipNonce;
    }

    public ASN1OctetString getSenderNonce() {
        return this.senderNonce;
    }

    public ASN1OctetString getTransactionID() {
        return this.transactionID;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.m14420add(this.staticString);
        addOptional(aSN1EncodableVector, 0, this.transactionID);
        addOptional(aSN1EncodableVector, 1, this.senderNonce);
        addOptional(aSN1EncodableVector, 2, this.recipNonce);
        aSN1EncodableVector.m14420add(this.f18120len);
        aSN1EncodableVector.m14420add(this.f18121mac);
        aSN1EncodableVector.m14420add(this.f18119ct);
        return new DERSequence(aSN1EncodableVector);
    }

    public KemOtherInfo(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString aSN1OctetString3, ASN1Integer aSN1Integer, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString4) {
        this.staticString = DEFAULT_staticString;
        this.transactionID = aSN1OctetString;
        this.senderNonce = aSN1OctetString2;
        this.recipNonce = aSN1OctetString3;
        this.f18120len = aSN1Integer;
        this.f18121mac = algorithmIdentifier;
        this.f18119ct = aSN1OctetString4;
    }

    private KemOtherInfo(ASN1Sequence aSN1Sequence) {
        int i;
        ASN1OctetString aSN1OctetString;
        ASN1OctetString aSN1OctetString2;
        ASN1Primitive aSN1PrimitiveTryGetContextBaseUniversal;
        ASN1Primitive aSN1PrimitiveTryGetContextBaseUniversal2;
        ASN1Primitive aSN1PrimitiveTryGetContextBaseUniversal3;
        if (aSN1Sequence.mo14450size() < 4 || aSN1Sequence.mo14450size() > 7) {
            throw new IllegalArgumentException("sequence size should be between 4 and 7 inclusive");
        }
        PKIFreeText pKIFreeText = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(0));
        this.staticString = pKIFreeText;
        PKIFreeText pKIFreeText2 = DEFAULT_staticString;
        if (!pKIFreeText2.mo14431equals(pKIFreeText)) {
            throw new IllegalArgumentException("staticString field should be " + pKIFreeText2);
        }
        ASN1TaggedObject aSN1TaggedObjectTryGetTagged = tryGetTagged(aSN1Sequence, 1);
        ASN1OctetString aSN1OctetString3 = null;
        if (aSN1TaggedObjectTryGetTagged == null || (aSN1PrimitiveTryGetContextBaseUniversal3 = ASN1Util.tryGetContextBaseUniversal(aSN1TaggedObjectTryGetTagged, 0, true, 4)) == null) {
            i = 1;
            aSN1OctetString = null;
        } else {
            aSN1OctetString = (ASN1OctetString) aSN1PrimitiveTryGetContextBaseUniversal3;
            aSN1TaggedObjectTryGetTagged = tryGetTagged(aSN1Sequence, 2);
            i = 2;
        }
        if (aSN1TaggedObjectTryGetTagged == null || (aSN1PrimitiveTryGetContextBaseUniversal2 = ASN1Util.tryGetContextBaseUniversal(aSN1TaggedObjectTryGetTagged, 1, true, 4)) == null) {
            aSN1OctetString2 = null;
        } else {
            aSN1OctetString2 = (ASN1OctetString) aSN1PrimitiveTryGetContextBaseUniversal2;
            i++;
            aSN1TaggedObjectTryGetTagged = tryGetTagged(aSN1Sequence, i);
        }
        if (aSN1TaggedObjectTryGetTagged != null && (aSN1PrimitiveTryGetContextBaseUniversal = ASN1Util.tryGetContextBaseUniversal(aSN1TaggedObjectTryGetTagged, 2, true, 4)) != null) {
            aSN1OctetString3 = (ASN1OctetString) aSN1PrimitiveTryGetContextBaseUniversal;
            i++;
            aSN1TaggedObjectTryGetTagged = tryGetTagged(aSN1Sequence, i);
        }
        if (aSN1TaggedObjectTryGetTagged != null) {
            throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(aSN1TaggedObjectTryGetTagged));
        }
        this.transactionID = aSN1OctetString;
        this.senderNonce = aSN1OctetString2;
        this.recipNonce = aSN1OctetString3;
        this.f18120len = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i));
        this.f18121mac = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.f18119ct = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i + 2));
        if (i + 3 != aSN1Sequence.mo14450size()) {
            throw new IllegalArgumentException("unexpected data at end of sequence");
        }
    }
}
