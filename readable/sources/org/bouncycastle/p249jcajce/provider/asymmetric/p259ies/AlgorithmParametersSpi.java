package org.bouncycastle.p249jcajce.provider.asymmetric.p259ies;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p281jce.p282spec.IESParameterSpec;

/* loaded from: classes2.dex */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    IESParameterSpec currentSpec;

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (this.currentSpec.getDerivationV() != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(this.currentSpec.getDerivationV())));
            }
            if (this.currentSpec.getEncodingV() != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) new DEROctetString(this.currentSpec.getEncodingV())));
            }
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.currentSpec.getMacKeySize()));
            byte[] nonce = this.currentSpec.getNonce();
            if (nonce != null) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.currentSpec.getCipherKeySize()));
                aSN1EncodableVector2.m14420add(new DEROctetString(nonce));
                aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
            }
            aSN1EncodableVector.m14420add(this.currentSpec.getPointCompression() ? ASN1Boolean.f17898TRUE : ASN1Boolean.f17897FALSE);
            return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding IESParameters");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return localEngineGetParameterSpec(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
            throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
        }
        this.currentSpec = (IESParameterSpec) algorithmParameterSpec;
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "IES Parameters";
    }

    public boolean isASN1FormatString(String str) {
        return str == null || str.equals("ASN.1");
    }

    public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == IESParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.currentSpec;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) {
        if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.fromByteArray(bArr);
            if (aSN1Sequence.mo14450size() > 5) {
                throw new IOException("sequence too big");
            }
            Enumeration objects = aSN1Sequence.getObjects();
            BigInteger bigInteger = null;
            boolean zM14419isTrue = false;
            BigInteger value = null;
            byte[] octets = null;
            byte[] octets2 = null;
            byte[] octets3 = null;
            while (objects.hasMoreElements()) {
                Object objNextElement = objects.nextElement();
                if (objNextElement instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objNextElement);
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        octets = ASN1OctetString.getInstance(aSN1TaggedObject, false).getOctets();
                    } else if (aSN1TaggedObject.getTagNo() == 1) {
                        octets2 = ASN1OctetString.getInstance(aSN1TaggedObject, false).getOctets();
                    }
                } else if (objNextElement instanceof ASN1Integer) {
                    value = ASN1Integer.getInstance(objNextElement).getValue();
                } else if (objNextElement instanceof ASN1Sequence) {
                    ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(objNextElement);
                    BigInteger value2 = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).getValue();
                    octets3 = ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets();
                    bigInteger = value2;
                } else if (objNextElement instanceof ASN1Boolean) {
                    zM14419isTrue = ASN1Boolean.getInstance(objNextElement).m14419isTrue();
                }
            }
            this.currentSpec = bigInteger != null ? new IESParameterSpec(octets, octets2, value.intValue(), bigInteger.intValue(), octets3, zM14419isTrue) : new IESParameterSpec(octets, octets2, value.intValue(), -1, null, zM14419isTrue);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Not a valid IES Parameter encoding.");
        } catch (ClassCastException unused2) {
            throw new IOException("Not a valid IES Parameter encoding.");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format " + str);
    }
}
