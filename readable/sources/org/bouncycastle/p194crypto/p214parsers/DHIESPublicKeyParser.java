package org.bouncycastle.p194crypto.p214parsers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.p194crypto.KeyParser;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class DHIESPublicKeyParser implements KeyParser {
    private DHParameters dhParams;

    public DHIESPublicKeyParser(DHParameters dHParameters) {
        this.dhParams = dHParameters;
    }

    @Override // org.bouncycastle.p194crypto.KeyParser
    /* renamed from: readKey */
    public AsymmetricKeyParameter mo14974readKey(InputStream inputStream) throws IOException {
        int iBitLength = (this.dhParams.m15695getP().bitLength() + 7) / 8;
        byte[] bArr = new byte[iBitLength];
        C6257Streams.readFully(inputStream, bArr, 0, iBitLength);
        return new DHPublicKeyParameters(new BigInteger(1, bArr), this.dhParams);
    }
}
