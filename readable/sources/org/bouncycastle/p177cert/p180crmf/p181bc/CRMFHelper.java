package org.bouncycastle.p177cert.p180crmf.p181bc;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.p180crmf.CRMFException;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.AlgorithmIdentifierFactory;
import org.bouncycastle.p194crypto.p221util.CipherFactory;
import org.bouncycastle.p194crypto.p221util.CipherKeyGeneratorFactory;

/* loaded from: classes2.dex */
class CRMFHelper {
    public static Object createContentCipher(boolean z, CipherParameters cipherParameters, AlgorithmIdentifier algorithmIdentifier) throws CRMFException {
        try {
            return CipherFactory.createContentCipher(z, cipherParameters, algorithmIdentifier);
        } catch (IllegalArgumentException e) {
            throw new CRMFException(e.getMessage(), e);
        }
    }

    public CipherKeyGenerator createKeyGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecureRandom secureRandom) throws CRMFException {
        try {
            return CipherKeyGeneratorFactory.createKeyGenerator(aSN1ObjectIdentifier, secureRandom);
        } catch (IllegalArgumentException e) {
            throw new CRMFException(e.getMessage(), e);
        }
    }

    public AlgorithmIdentifier generateEncryptionAlgID(ASN1ObjectIdentifier aSN1ObjectIdentifier, KeyParameter keyParameter, SecureRandom secureRandom) throws CRMFException {
        try {
            return AlgorithmIdentifierFactory.generateEncryptionAlgID(aSN1ObjectIdentifier, keyParameter.m15773getKey().length * 8, secureRandom);
        } catch (IllegalArgumentException e) {
            throw new CRMFException(e.getMessage(), e);
        }
    }
}
