package org.bouncycastle.p177cert.p183dane;

import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class TruncatingDigestCalculator implements DigestCalculator {
    private final DigestCalculator baseCalculator;

    /* renamed from: length */
    private final int f18869length;

    public TruncatingDigestCalculator(DigestCalculator digestCalculator) {
        this(digestCalculator, 28);
    }

    @Override // org.bouncycastle.operator.DigestCalculator
    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.baseCalculator.getAlgorithmIdentifier();
    }

    @Override // org.bouncycastle.operator.DigestCalculator
    public byte[] getDigest() {
        int i = this.f18869length;
        byte[] bArr = new byte[i];
        System.arraycopy(this.baseCalculator.getDigest(), 0, bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.operator.DigestCalculator
    public OutputStream getOutputStream() {
        return this.baseCalculator.getOutputStream();
    }

    public TruncatingDigestCalculator(DigestCalculator digestCalculator, int i) {
        this.baseCalculator = digestCalculator;
        this.f18869length = i;
    }
}
