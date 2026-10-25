package org.bouncycastle.operator.p305bc;

import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public class BcSymmetricKeyUnwrapper extends SymmetricKeyUnwrapper {

    /* renamed from: random */
    private SecureRandom f22882random;

    /* renamed from: wrapper */
    private InterfaceC5283Wrapper f22883wrapper;
    private KeyParameter wrappingKey;

    public BcSymmetricKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, InterfaceC5283Wrapper interfaceC5283Wrapper, KeyParameter keyParameter) {
        super(algorithmIdentifier);
        this.f22883wrapper = interfaceC5283Wrapper;
        this.wrappingKey = keyParameter;
    }

    @Override // org.bouncycastle.operator.KeyUnwrapper
    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws OperatorException {
        this.f22883wrapper.mo14995init(false, this.wrappingKey);
        try {
            return new GenericKey(algorithmIdentifier, this.f22883wrapper.mo14996unwrap(bArr, 0, bArr.length));
        } catch (InvalidCipherTextException e) {
            throw new OperatorException("unable to unwrap key: " + e.getMessage(), e);
        }
    }

    public BcSymmetricKeyUnwrapper setSecureRandom(SecureRandom secureRandom) {
        this.f22882random = secureRandom;
        return this;
    }
}
