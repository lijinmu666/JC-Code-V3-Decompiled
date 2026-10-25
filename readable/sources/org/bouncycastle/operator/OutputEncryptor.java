package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface OutputEncryptor {
    AlgorithmIdentifier getAlgorithmIdentifier();

    /* renamed from: getKey */
    GenericKey mo14795getKey();

    OutputStream getOutputStream(OutputStream outputStream);
}
