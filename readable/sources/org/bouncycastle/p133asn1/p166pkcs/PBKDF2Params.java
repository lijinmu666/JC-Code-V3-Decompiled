package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PBKDF2Params extends ASN1Object {
    private static final AlgorithmIdentifier algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, C5103DERNull.INSTANCE);
    private final ASN1Integer iterationCount;
    private final ASN1Integer keyLength;

    /* renamed from: octStr */
    private final ASN1OctetString f18485octStr;

    /* renamed from: prf */
    private final AlgorithmIdentifier f18486prf;

    private PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18485octStr = (ASN1OctetString) objects.nextElement();
        this.iterationCount = (ASN1Integer) objects.nextElement();
        if (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            if (objNextElement instanceof ASN1Integer) {
                this.keyLength = ASN1Integer.getInstance(objNextElement);
                objNextElement = objects.hasMoreElements() ? objects.nextElement() : null;
            } else {
                this.keyLength = null;
            }
            if (objNextElement != null) {
                this.f18486prf = AlgorithmIdentifier.getInstance(objNextElement);
                return;
            }
        } else {
            this.keyLength = null;
        }
        this.f18486prf = null;
    }

    public static PBKDF2Params getInstance(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        if (obj != null) {
            return new PBKDF2Params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    /* renamed from: getPrf */
    public AlgorithmIdentifier m14634getPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.f18486prf;
        return algorithmIdentifier != null ? algorithmIdentifier : algid_hmacWithSHA1;
    }

    /* renamed from: getSalt */
    public byte[] m14635getSalt() {
        return C6238Arrays.m18231clone(this.f18485octStr.getOctets());
    }

    public boolean isDefaultPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.f18486prf;
        return algorithmIdentifier == null || algorithmIdentifier.mo14431equals(algid_hmacWithSHA1);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18485octStr);
        aSN1EncodableVector.m14420add(this.iterationCount);
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        AlgorithmIdentifier algorithmIdentifier = this.f18486prf;
        if (algorithmIdentifier != null && !algorithmIdentifier.mo14431equals(algid_hmacWithSHA1)) {
            aSN1EncodableVector.m14420add(this.f18486prf);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PBKDF2Params(byte[] bArr, int i) {
        this(bArr, i, 0);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.f18485octStr = new DEROctetString(C6238Arrays.m18231clone(bArr));
        this.iterationCount = ASN1Integer.m14429valueOf(i);
        this.keyLength = i2 > 0 ? ASN1Integer.m14429valueOf(i2) : null;
        this.f18486prf = algorithmIdentifier;
    }

    public PBKDF2Params(byte[] bArr, int i, AlgorithmIdentifier algorithmIdentifier) {
        this(bArr, i, 0, algorithmIdentifier);
    }
}
