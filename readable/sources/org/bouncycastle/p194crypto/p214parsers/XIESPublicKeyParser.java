package org.bouncycastle.p194crypto.p214parsers;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.KeyParser;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class XIESPublicKeyParser implements KeyParser {
    private final boolean isX25519;

    public XIESPublicKeyParser(boolean z) {
        this.isX25519 = z;
    }

    @Override // org.bouncycastle.p194crypto.KeyParser
    /* renamed from: readKey */
    public AsymmetricKeyParameter mo14974readKey(InputStream inputStream) throws IOException {
        int i = this.isX25519 ? 32 : 56;
        byte[] bArr = new byte[i];
        C6257Streams.readFully(inputStream, bArr, 0, i);
        return this.isX25519 ? new X25519PublicKeyParameters(bArr, 0) : new X448PublicKeyParameters(bArr, 0);
    }
}
