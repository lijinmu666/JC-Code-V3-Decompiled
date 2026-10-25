package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class PrivateKeyInfo extends ASN1Object {
    private AbstractC5093ASN1Set attributes;
    private ASN1OctetString privateKey;
    private AlgorithmIdentifier privateKeyAlgorithm;
    private ASN1BitString publicKey;

    /* renamed from: version */
    private ASN1Integer f18513version;

    private PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(objects.nextElement());
        this.f18513version = aSN1Integer;
        int versionValue = getVersionValue(aSN1Integer);
        this.privateKeyAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.privateKey = ASN1OctetString.getInstance(objects.nextElement());
        int i = -1;
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo <= i) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (tagNo == 0) {
                this.attributes = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (versionValue < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.publicKey = ASN1BitString.getInstance(aSN1TaggedObject, false);
            }
            i = tagNo;
        }
    }

    public static PrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static int getVersionValue(ASN1Integer aSN1Integer) {
        int iIntValueExact = aSN1Integer.intValueExact();
        if (iIntValueExact < 0 || iIntValueExact > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return iIntValueExact;
    }

    public AbstractC5093ASN1Set getAttributes() {
        return this.attributes;
    }

    public ASN1OctetString getPrivateKey() {
        return new DEROctetString(this.privateKey.getOctets());
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithm() {
        return this.privateKeyAlgorithm;
    }

    public int getPrivateKeyLength() {
        return this.privateKey.getOctetsLength();
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    public ASN1Integer getVersion() {
        return this.f18513version;
    }

    public boolean hasPublicKey() {
        return this.publicKey != null;
    }

    public ASN1Encodable parsePrivateKey() {
        return ASN1Primitive.fromByteArray(this.privateKey.getOctets());
    }

    public ASN1Encodable parsePublicKey() {
        ASN1BitString aSN1BitString = this.publicKey;
        if (aSN1BitString == null) {
            return null;
        }
        return ASN1Primitive.fromByteArray(aSN1BitString.getOctets());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18513version);
        aSN1EncodableVector.m14420add(this.privateKeyAlgorithm);
        aSN1EncodableVector.m14420add(this.privateKey);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.attributes;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        ASN1BitString aSN1BitString = this.publicKey;
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1BitString));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this(algorithmIdentifier, aSN1Encodable, (AbstractC5093ASN1Set) null, (byte[]) null);
    }

    public static PrivateKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this(algorithmIdentifier, aSN1Encodable, abstractC5093ASN1Set, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, AbstractC5093ASN1Set abstractC5093ASN1Set, byte[] bArr) {
        this(algorithmIdentifier, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER), abstractC5093ASN1Set, bArr);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this(algorithmIdentifier, bArr, (AbstractC5093ASN1Set) null, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this(algorithmIdentifier, bArr, abstractC5093ASN1Set, (byte[]) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, AbstractC5093ASN1Set abstractC5093ASN1Set, byte[] bArr2) {
        this.f18513version = new ASN1Integer(bArr2 != null ? BigIntegers.f24189ONE : BigIntegers.f24192ZERO);
        this.privateKeyAlgorithm = algorithmIdentifier;
        this.privateKey = new DEROctetString(bArr);
        this.attributes = abstractC5093ASN1Set;
        this.publicKey = bArr2 == null ? null : new DERBitString(bArr2);
    }
}
