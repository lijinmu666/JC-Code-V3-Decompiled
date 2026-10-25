package org.bouncycastle.operator.p305bc;

import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.SymmetricKeyWrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

/* loaded from: classes2.dex */
public class BcSymmetricKeyWrapper extends SymmetricKeyWrapper {

    /* renamed from: random */
    private SecureRandom f22884random;

    /* renamed from: wrapper */
    private InterfaceC5283Wrapper f22885wrapper;
    private KeyParameter wrappingKey;

    public BcSymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, InterfaceC5283Wrapper interfaceC5283Wrapper, KeyParameter keyParameter) {
        super(algorithmIdentifier);
        this.f22885wrapper = interfaceC5283Wrapper;
        this.wrappingKey = keyParameter;
    }

    @Override // org.bouncycastle.operator.KeyWrapper
    public byte[] generateWrappedKey(GenericKey genericKey) {
        byte[] keyBytes = OperatorUtils.getKeyBytes(genericKey);
        SecureRandom secureRandom = this.f22884random;
        if (secureRandom == null) {
            this.f22885wrapper.mo14995init(true, this.wrappingKey);
        } else {
            this.f22885wrapper.mo14995init(true, new ParametersWithRandom(this.wrappingKey, secureRandom));
        }
        return this.f22885wrapper.mo14997wrap(keyBytes, 0, keyBytes.length);
    }

    public BcSymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.f22884random = secureRandom;
        return this;
    }
}
