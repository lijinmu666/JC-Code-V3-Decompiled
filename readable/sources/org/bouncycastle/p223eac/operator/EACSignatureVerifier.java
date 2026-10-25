package org.bouncycastle.p223eac.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface EACSignatureVerifier {
    OutputStream getOutputStream();

    ASN1ObjectIdentifier getUsageIdentifier();

    /* renamed from: verify */
    boolean mo15949verify(byte[] bArr);
}
