package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* loaded from: classes.dex */
public class Challenge extends ASN1Object {
    private final ASN1OctetString challenge;
    private final EnvelopedData encryptedRand;

    /* renamed from: owf */
    private final AlgorithmIdentifier f18106owf;

    /* renamed from: witness */
    private final ASN1OctetString f18107witness;

    /* renamed from: org.bouncycastle.asn1.cmp.Challenge$Rand */
    public static class C5112Rand extends ASN1Object {

        /* renamed from: integer */
        private final ASN1Integer f18108integer;

        /* renamed from: sender */
        private final GeneralName f18109sender;

        public C5112Rand(ASN1Integer aSN1Integer, GeneralName generalName) {
            this.f18108integer = aSN1Integer;
            this.f18109sender = generalName;
        }

        public static C5112Rand getInstance(Object obj) {
            if (obj instanceof C5112Rand) {
                return (C5112Rand) obj;
            }
            if (obj != null) {
                return new C5112Rand(ASN1Sequence.getInstance(obj));
            }
            return null;
        }

        /* renamed from: getInt */
        public ASN1Integer m14503getInt() {
            return this.f18108integer;
        }

        public GeneralName getSender() {
            return this.f18109sender;
        }

        @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return new DERSequence(new ASN1Encodable[]{this.f18108integer, this.f18109sender});
        }

        private C5112Rand(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.mo14450size() != 2) {
                throw new IllegalArgumentException("expected sequence size of 2");
            }
            this.f18108integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            this.f18109sender = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        }

        public C5112Rand(byte[] bArr, GeneralName generalName) {
            this(new ASN1Integer(bArr), generalName);
        }
    }

    private Challenge(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence) {
            this.f18106owf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.f18106owf = null;
        }
        int i2 = i + 1;
        this.f18107witness = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
        int i3 = i + 2;
        ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i2));
        this.challenge = aSN1OctetString;
        if (aSN1Sequence.mo14450size() <= i3) {
            this.encryptedRand = null;
        } else {
            if (aSN1OctetString.getOctets().length != 0) {
                throw new IllegalArgumentException("ambigous challenge");
            }
            this.encryptedRand = EnvelopedData.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i3)), true);
        }
    }

    public static Challenge getInstance(Object obj) {
        if (obj instanceof Challenge) {
            return (Challenge) obj;
        }
        if (obj != null) {
            return new Challenge(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getChallenge() {
        return this.challenge.getOctets();
    }

    public EnvelopedData getEncryptedRand() {
        return this.encryptedRand;
    }

    /* renamed from: getOwf */
    public AlgorithmIdentifier m14502getOwf() {
        return this.f18106owf;
    }

    public byte[] getWitness() {
        return this.f18107witness.getOctets();
    }

    public boolean isEncryptedRand() {
        return this.encryptedRand != null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.addOptional(this.f18106owf);
        aSN1EncodableVector.m14420add(this.f18107witness);
        aSN1EncodableVector.m14420add(this.challenge);
        EnvelopedData envelopedData = this.encryptedRand;
        if (envelopedData != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(0, envelopedData));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public Challenge(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, EnvelopedData envelopedData) {
        this.f18106owf = algorithmIdentifier;
        this.f18107witness = new DEROctetString(bArr);
        this.challenge = new DEROctetString(new byte[0]);
        this.encryptedRand = envelopedData;
    }

    public Challenge(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this.f18106owf = algorithmIdentifier;
        this.f18107witness = new DEROctetString(bArr);
        this.challenge = new DEROctetString(bArr2);
        this.encryptedRand = null;
    }

    public Challenge(byte[] bArr, EnvelopedData envelopedData) {
        this((AlgorithmIdentifier) null, bArr, envelopedData);
    }

    public Challenge(byte[] bArr, byte[] bArr2) {
        this((AlgorithmIdentifier) null, bArr, bArr2);
    }
}
