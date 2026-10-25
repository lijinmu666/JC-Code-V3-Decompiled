package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class PBMAC1Params extends ASN1Object implements PKCSObjectIdentifiers {

    /* renamed from: func */
    private AlgorithmIdentifier f18487func;

    /* renamed from: scheme */
    private AlgorithmIdentifier f18488scheme;

    private PBMAC1Params(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(((ASN1Encodable) objects.nextElement()).toASN1Primitive());
        ASN1Encodable objectAt = aSN1Sequence2.getObjectAt(0);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_PBKDF2;
        if (objectAt.equals(aSN1ObjectIdentifier)) {
            this.f18487func = new AlgorithmIdentifier(aSN1ObjectIdentifier, PBKDF2Params.getInstance(aSN1Sequence2.getObjectAt(1)));
        } else {
            this.f18487func = AlgorithmIdentifier.getInstance(aSN1Sequence2);
        }
        this.f18488scheme = AlgorithmIdentifier.getInstance(objects.nextElement());
    }

    public static PBMAC1Params getInstance(Object obj) {
        if (obj instanceof PBMAC1Params) {
            return (PBMAC1Params) obj;
        }
        if (obj != null) {
            return new PBMAC1Params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getKeyDerivationFunc() {
        return this.f18487func;
    }

    public AlgorithmIdentifier getMessageAuthScheme() {
        return this.f18488scheme;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18487func, this.f18488scheme);
    }

    public PBMAC1Params(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18487func = algorithmIdentifier;
        this.f18488scheme = algorithmIdentifier2;
    }
}
