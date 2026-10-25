package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.p362io.BufferingOutputStream;

/* loaded from: classes2.dex */
public class BufferingContentSigner implements ExtendedContentSigner {
    private final ContentSigner contentSigner;

    /* renamed from: output */
    private final OutputStream f22854output;

    public BufferingContentSigner(ContentSigner contentSigner) {
        this.contentSigner = contentSigner;
        this.f22854output = new BufferingOutputStream(contentSigner.getOutputStream());
    }

    @Override // org.bouncycastle.operator.ContentSigner
    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.contentSigner.getAlgorithmIdentifier();
    }

    @Override // org.bouncycastle.operator.ExtendedContentSigner
    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        ContentSigner contentSigner = this.contentSigner;
        if (contentSigner instanceof ExtendedContentSigner) {
            return ((ExtendedContentSigner) contentSigner).getDigestAlgorithmIdentifier();
        }
        return null;
    }

    @Override // org.bouncycastle.operator.ContentSigner
    public OutputStream getOutputStream() {
        return this.f22854output;
    }

    @Override // org.bouncycastle.operator.ContentSigner
    public byte[] getSignature() {
        return this.contentSigner.getSignature();
    }

    public BufferingContentSigner(ContentSigner contentSigner, int i) {
        this.contentSigner = contentSigner;
        this.f22854output = new BufferingOutputStream(contentSigner.getOutputStream(), i);
    }
}
