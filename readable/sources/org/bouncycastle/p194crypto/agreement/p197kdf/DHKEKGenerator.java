package org.bouncycastle.p194crypto.agreement.p197kdf;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p133asn1.p176x9.KeySpecificInfo;
import org.bouncycastle.p133asn1.p176x9.OtherInfo;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p206io.DigestOutputStream;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;

    /* renamed from: digest */
    private final InterfaceC5277Digest f19214digest;
    private byte[] extraInfo;

    /* renamed from: keySize */
    private int f19215keySize;

    /* renamed from: z */
    private byte[] f19216z;

    public DHKEKGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19214digest = interfaceC5277Digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 < i) {
            throw new OutputLengthException("output buffer too small");
        }
        this.f19214digest.mo14968reset();
        int digestSize = this.f19214digest.getDigestSize();
        if (i2 > digestSize * BodyPartID.bodyIdMax) {
            throw new IllegalArgumentException("Output length too large");
        }
        byte[] bArr2 = new byte[4];
        OtherInfo otherInfo = new OtherInfo(new KeySpecificInfo(this.algorithm, DEROctetString.withContents(bArr2)), DEROctetString.withContentsOptional(this.extraInfo), DEROctetString.withContents(AbstractC6245Pack.intToBigEndian(this.f19215keySize)));
        DigestOutputStream digestOutputStream = new DigestOutputStream(this.f19214digest);
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            InterfaceC5277Digest interfaceC5277Digest = this.f19214digest;
            byte[] bArr3 = this.f19216z;
            interfaceC5277Digest.mo14970update(bArr3, 0, bArr3.length);
            i4++;
            try {
                AbstractC6245Pack.intToBigEndian(i4, bArr2);
                otherInfo.encodeTo(digestOutputStream, ASN1Encoding.f17902DER);
                if (i3 < digestSize) {
                    byte[] bArr4 = new byte[digestSize];
                    this.f19214digest.mo14967doFinal(bArr4, 0);
                    System.arraycopy(bArr4, 0, bArr, i, i3);
                    break;
                }
                this.f19214digest.mo14967doFinal(bArr, i);
                i += digestSize;
                i3 -= digestSize;
            } catch (IOException e) {
                throw new IllegalArgumentException("unable to encode parameter info: " + e.getMessage());
            }
        }
        return i2;
    }

    public InterfaceC5277Digest getDigest() {
        return this.f19214digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.f19215keySize = dHKDFParameters.getKeySize();
        this.f19216z = dHKDFParameters.m15028getZ();
        this.extraInfo = dHKDFParameters.getExtraInfo();
    }
}
