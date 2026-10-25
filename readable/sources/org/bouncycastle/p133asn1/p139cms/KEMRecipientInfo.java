package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class KEMRecipientInfo extends ASN1Object {
    private final ASN1Integer cmsVersion;
    private final ASN1OctetString encryptedKey;

    /* renamed from: kdf */
    private final AlgorithmIdentifier f18200kdf;
    private final ASN1Integer kekLength;

    /* renamed from: kem */
    private final AlgorithmIdentifier f18201kem;

    /* renamed from: kemct */
    private final ASN1OctetString f18202kemct;

    /* renamed from: rid */
    private final RecipientIdentifier f18203rid;

    /* renamed from: ukm */
    private final ASN1OctetString f18204ukm;

    /* renamed from: wrap */
    private final AlgorithmIdentifier f18205wrap;

    private KEMRecipientInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 8 || aSN1Sequence.mo14450size() > 9) {
            throw new IllegalArgumentException("bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.cmsVersion = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18203rid = RecipientIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18201kem = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.f18202kemct = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3));
        this.f18200kdf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(4));
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(5));
        this.kekLength = aSN1Integer;
        if (aSN1Integer.intValueExact() > 65535) {
            throw new IllegalArgumentException("kekLength must be <= 65535");
        }
        int i = 6;
        if (aSN1Sequence.getObjectAt(6) instanceof ASN1TaggedObject) {
            this.f18204ukm = ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(6)), true);
            i = 7;
        } else {
            this.f18204ukm = null;
        }
        this.f18205wrap = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        this.encryptedKey = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i + 1));
    }

    public static KEMRecipientInfo getInstance(Object obj) {
        if (obj instanceof KEMRecipientInfo) {
            return (KEMRecipientInfo) obj;
        }
        if (obj != null) {
            return new KEMRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    /* renamed from: getKdf */
    public AlgorithmIdentifier m14542getKdf() {
        return this.f18200kdf;
    }

    /* renamed from: getKem */
    public AlgorithmIdentifier m14543getKem() {
        return this.f18201kem;
    }

    public ASN1OctetString getKemct() {
        return this.f18202kemct;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.f18203rid;
    }

    /* renamed from: getUkm */
    public byte[] m14544getUkm() {
        ASN1OctetString aSN1OctetString = this.f18204ukm;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.getOctets();
    }

    /* renamed from: getWrap */
    public AlgorithmIdentifier m14545getWrap() {
        return this.f18205wrap;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(this.cmsVersion);
        aSN1EncodableVector.m14420add(this.f18203rid);
        aSN1EncodableVector.m14420add(this.f18201kem);
        aSN1EncodableVector.m14420add(this.f18202kemct);
        aSN1EncodableVector.m14420add(this.f18200kdf);
        aSN1EncodableVector.m14420add(this.kekLength);
        ASN1OctetString aSN1OctetString = this.f18204ukm;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) aSN1OctetString));
        }
        aSN1EncodableVector.m14420add(this.f18205wrap);
        aSN1EncodableVector.m14420add(this.encryptedKey);
        return new DERSequence(aSN1EncodableVector);
    }

    public KEMRecipientInfo(RecipientIdentifier recipientIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier2, ASN1Integer aSN1Integer, ASN1OctetString aSN1OctetString2, AlgorithmIdentifier algorithmIdentifier3, ASN1OctetString aSN1OctetString3) {
        if (algorithmIdentifier == null) {
            throw new NullPointerException("kem cannot be null");
        }
        if (algorithmIdentifier3 == null) {
            throw new NullPointerException("wrap cannot be null");
        }
        if (aSN1Integer.intValueExact() > 65535) {
            throw new IllegalArgumentException("kekLength must be <= 65535");
        }
        this.cmsVersion = ASN1Integer.f17922ZERO;
        this.f18203rid = recipientIdentifier;
        this.f18201kem = algorithmIdentifier;
        this.f18202kemct = aSN1OctetString;
        this.f18200kdf = algorithmIdentifier2;
        this.kekLength = aSN1Integer;
        this.f18204ukm = aSN1OctetString2;
        this.f18205wrap = algorithmIdentifier3;
        this.encryptedKey = aSN1OctetString3;
    }
}
