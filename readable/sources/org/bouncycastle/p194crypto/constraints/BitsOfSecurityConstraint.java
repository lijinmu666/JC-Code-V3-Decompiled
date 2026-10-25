package org.bouncycastle.p194crypto.constraints;

import java.util.Collections;
import java.util.Set;
import org.bouncycastle.p194crypto.CryptoServiceConstraintsException;
import org.bouncycastle.p194crypto.CryptoServiceProperties;

/* loaded from: classes2.dex */
public class BitsOfSecurityConstraint extends ServicesConstraint {
    private final int requiredBitsOfSecurity;

    public BitsOfSecurityConstraint(int i) {
        super(Collections.EMPTY_SET);
        this.requiredBitsOfSecurity = i;
    }

    @Override // org.bouncycastle.p194crypto.CryptoServicesConstraints
    /* renamed from: check */
    public void mo14961check(CryptoServiceProperties cryptoServiceProperties) {
        if (!isException(cryptoServiceProperties.getServiceName()) && cryptoServiceProperties.bitsOfSecurity() < this.requiredBitsOfSecurity) {
            throw new CryptoServiceConstraintsException("service does not provide " + this.requiredBitsOfSecurity + " bits of security only " + cryptoServiceProperties.bitsOfSecurity());
        }
    }

    public BitsOfSecurityConstraint(int i, Set<String> set) {
        super(set);
        this.requiredBitsOfSecurity = i;
    }
}
