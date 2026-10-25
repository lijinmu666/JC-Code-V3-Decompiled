package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes2.dex */
public class NoSignatureContentSigner implements ContentSigner {
    @Override // org.bouncycastle.operator.ContentSigner
    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return new AlgorithmIdentifier(X509ObjectIdentifiers.id_alg_unsigned);
    }

    @Override // org.bouncycastle.operator.ContentSigner
    public OutputStream getOutputStream() {
        return new OutputStream() { // from class: org.bouncycastle.operator.NoSignatureContentSigner.1
            @Override // java.io.OutputStream
            public void write(int i) {
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
            }
        };
    }

    @Override // org.bouncycastle.operator.ContentSigner
    public byte[] getSignature() {
        return new byte[0];
    }
}
