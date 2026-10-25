package org.bouncycastle.p194crypto.constraints;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.p194crypto.CryptoServiceProperties;

/* loaded from: classes2.dex */
public class LoggingConstraint extends ServicesConstraint {
    public LoggingConstraint(Set<String> set) {
        super(set);
    }

    @Override // org.bouncycastle.p194crypto.CryptoServicesConstraints
    /* renamed from: check */
    public void mo14961check(CryptoServiceProperties cryptoServiceProperties) {
        if (isException(cryptoServiceProperties.getServiceName())) {
            return;
        }
        Logger logger = ServicesConstraint.f19264LOG;
        if (logger.isLoggable(Level.INFO)) {
            logger.info("service " + cryptoServiceProperties.getServiceName() + " referenced [" + cryptoServiceProperties.getServiceName() + ", " + cryptoServiceProperties.bitsOfSecurity() + ", " + cryptoServiceProperties.getPurpose());
        }
    }
}
