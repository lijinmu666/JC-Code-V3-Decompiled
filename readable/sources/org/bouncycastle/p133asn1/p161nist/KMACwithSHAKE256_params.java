package org.bouncycastle.p133asn1.p161nist;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KMACwithSHAKE256_params extends ASN1Object {
    private static final int DEF_LENGTH = 512;
    private static final byte[] EMPTY_STRING = new byte[0];
    private final byte[] customizationString;
    private final int outputLength;

    public KMACwithSHAKE256_params(int i) {
        this.outputLength = i;
        this.customizationString = EMPTY_STRING;
    }

    public static KMACwithSHAKE256_params getInstance(Object obj) {
        if (obj instanceof KMACwithSHAKE256_params) {
            return (KMACwithSHAKE256_params) obj;
        }
        if (obj != null) {
            return new KMACwithSHAKE256_params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCustomizationString() {
        return C6238Arrays.m18231clone(this.customizationString);
    }

    public int getOutputLength() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = this.outputLength;
        if (i != 512) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        if (this.customizationString.length != 0) {
            aSN1EncodableVector.m14420add(new DEROctetString(getCustomizationString()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public KMACwithSHAKE256_params(int i, byte[] bArr) {
        this.outputLength = i;
        this.customizationString = C6238Arrays.m18231clone(bArr);
    }

    private KMACwithSHAKE256_params(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("sequence size greater than 2");
        }
        if (aSN1Sequence.mo14450size() == 2) {
            this.outputLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
            this.customizationString = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        } else if (aSN1Sequence.mo14450size() != 1) {
            this.outputLength = 512;
            this.customizationString = EMPTY_STRING;
        } else if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.outputLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
            this.customizationString = EMPTY_STRING;
        } else {
            this.outputLength = 512;
            this.customizationString = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
        }
    }
}
