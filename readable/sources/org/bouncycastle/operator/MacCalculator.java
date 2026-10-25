package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface MacCalculator {
    AlgorithmIdentifier getAlgorithmIdentifier();

    /* renamed from: getKey */
    GenericKey mo14789getKey();

    /* renamed from: getMac */
    byte[] mo14790getMac();

    OutputStream getOutputStream();
}
