package org.bouncycastle.p194crypto.agreement.p197kdf;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.DigestDerivationFunction;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class ECDHKEKGenerator implements DigestDerivationFunction {
    private ASN1ObjectIdentifier algorithm;

    /* renamed from: kdf */
    private DigestDerivationFunction f19217kdf;

    /* renamed from: keySize */
    private int f19218keySize;

    /* renamed from: z */
    private byte[] f19219z;

    public ECDHKEKGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19217kdf = new KDF2BytesGenerator(interfaceC5277Digest);
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("output buffer too small");
        }
        try {
            this.f19217kdf.mo14966init(new KDFParameters(this.f19219z, new DERSequence(new AlgorithmIdentifier(this.algorithm, C5103DERNull.INSTANCE), new DERTaggedObject(2, DEROctetString.withContents(AbstractC6245Pack.intToBigEndian(this.f19218keySize)))).getEncoded(ASN1Encoding.f17902DER)));
            return this.f19217kdf.generateBytes(bArr, i, i2);
        } catch (IOException e) {
            throw new IllegalArgumentException("unable to initialise kdf: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p194crypto.DigestDerivationFunction
    public InterfaceC5277Digest getDigest() {
        return this.f19217kdf.getDigest();
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.f19218keySize = dHKDFParameters.getKeySize();
        this.f19219z = dHKDFParameters.m15028getZ();
    }
}
