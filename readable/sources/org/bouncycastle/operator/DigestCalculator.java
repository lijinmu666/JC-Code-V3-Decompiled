package org.bouncycastle.operator;

import java.io.OutputStream;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface DigestCalculator {

    /* renamed from: SHA_256 */
    public static final AlgorithmIdentifier f22858SHA_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);

    /* renamed from: SHA_512 */
    public static final AlgorithmIdentifier f22859SHA_512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);

    AlgorithmIdentifier getAlgorithmIdentifier();

    byte[] getDigest();

    OutputStream getOutputStream();
}
