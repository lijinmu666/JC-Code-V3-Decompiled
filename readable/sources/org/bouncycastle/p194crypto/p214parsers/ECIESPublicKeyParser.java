package org.bouncycastle.p194crypto.p214parsers;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.KeyParser;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class ECIESPublicKeyParser implements KeyParser {
    private ECDomainParameters ecParams;

    public ECIESPublicKeyParser(ECDomainParameters eCDomainParameters) {
        this.ecParams = eCDomainParameters;
    }

    @Override // org.bouncycastle.p194crypto.KeyParser
    /* renamed from: readKey */
    public AsymmetricKeyParameter mo14974readKey(InputStream inputStream) throws IOException {
        boolean z;
        int i = inputStream.read();
        if (i < 0) {
            throw new EOFException();
        }
        if (i == 0) {
            throw new IOException("Sender's public key invalid.");
        }
        if (i == 2 || i == 3) {
            z = true;
        } else {
            if (i != 4 && i != 6 && i != 7) {
                throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(i, 16));
            }
            z = false;
        }
        AbstractC5817ECCurve curve = this.ecParams.getCurve();
        int affinePointEncodingLength = curve.getAffinePointEncodingLength(z);
        byte[] bArr = new byte[affinePointEncodingLength];
        bArr[0] = (byte) i;
        int i2 = affinePointEncodingLength - 1;
        if (C6257Streams.readFully(inputStream, bArr, 1, i2) == i2) {
            return new ECPublicKeyParameters(curve.decodePoint(bArr), this.ecParams);
        }
        throw new EOFException();
    }
}
