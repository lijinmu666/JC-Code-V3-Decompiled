package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface ContentVerifier {
    AlgorithmIdentifier getAlgorithmIdentifier();

    OutputStream getOutputStream();

    /* renamed from: verify */
    boolean mo16015verify(byte[] bArr);
}
