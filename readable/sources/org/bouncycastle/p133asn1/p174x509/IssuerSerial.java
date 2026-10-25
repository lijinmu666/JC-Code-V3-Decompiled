package org.bouncycastle.p133asn1.p174x509;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class IssuerSerial extends ASN1Object {

    /* renamed from: issuer */
    GeneralNames f18664issuer;
    ASN1BitString issuerUID;

    /* renamed from: serial */
    ASN1Integer f18665serial;

    private IssuerSerial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2 && aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.f18664issuer = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18665serial = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() == 3) {
            this.issuerUID = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static IssuerSerial getInstance(Object obj) {
        if (obj instanceof IssuerSerial) {
            return (IssuerSerial) obj;
        }
        if (obj != null) {
            return new IssuerSerial(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getIssuer() {
        return this.f18664issuer;
    }

    public ASN1BitString getIssuerUID() {
        return this.issuerUID;
    }

    public ASN1Integer getSerial() {
        return this.f18665serial;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18664issuer);
        aSN1EncodableVector.m14420add(this.f18665serial);
        ASN1BitString aSN1BitString = this.issuerUID;
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(aSN1BitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public IssuerSerial(X500Name x500Name, BigInteger bigInteger) {
        this(new GeneralNames(new GeneralName(x500Name)), new ASN1Integer(bigInteger));
    }

    public static IssuerSerial getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public IssuerSerial(GeneralNames generalNames, BigInteger bigInteger) {
        this(generalNames, new ASN1Integer(bigInteger));
    }

    public IssuerSerial(GeneralNames generalNames, ASN1Integer aSN1Integer) {
        this.f18664issuer = generalNames;
        this.f18665serial = aSN1Integer;
    }
}
