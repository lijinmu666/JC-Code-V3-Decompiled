package org.bouncycastle.p194crypto.constraints;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.p194crypto.CryptoServiceConstraintsException;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;

/* loaded from: classes2.dex */
public class LegacyBitsOfSecurityConstraint extends ServicesConstraint {
    private final int legacyRequiredBitsOfSecurity;
    private final int requiredBitsOfSecurity;

    /* renamed from: org.bouncycastle.crypto.constraints.LegacyBitsOfSecurityConstraint$1 */
    public static /* synthetic */ class C52861 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose;

        static {
            int[] iArr = new int[CryptoServicePurpose.m14960values().length];
            $SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose = iArr;
            try {
                iArr[CryptoServicePurpose.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose[CryptoServicePurpose.VERIFYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose[CryptoServicePurpose.DECRYPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose[CryptoServicePurpose.VERIFICATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LegacyBitsOfSecurityConstraint(int i) {
        this(i, 0);
    }

    @Override // org.bouncycastle.p194crypto.CryptoServicesConstraints
    /* renamed from: check */
    public void mo14961check(CryptoServiceProperties cryptoServiceProperties) {
        if (isException(cryptoServiceProperties.getServiceName())) {
            return;
        }
        CryptoServicePurpose purpose = cryptoServiceProperties.getPurpose();
        int i = C52861.$SwitchMap$org$bouncycastle$crypto$CryptoServicePurpose[purpose.ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            if (cryptoServiceProperties.bitsOfSecurity() >= this.requiredBitsOfSecurity) {
                return;
            }
            throw new CryptoServiceConstraintsException("service does not provide " + this.requiredBitsOfSecurity + " bits of security only " + cryptoServiceProperties.bitsOfSecurity());
        }
        if (cryptoServiceProperties.bitsOfSecurity() < this.legacyRequiredBitsOfSecurity) {
            throw new CryptoServiceConstraintsException("service does not provide " + this.legacyRequiredBitsOfSecurity + " bits of security only " + cryptoServiceProperties.bitsOfSecurity());
        }
        if (purpose != CryptoServicePurpose.ANY) {
            Logger logger = ServicesConstraint.f19264LOG;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("usage of legacy cryptography service for algorithm " + cryptoServiceProperties.getServiceName());
            }
        }
    }

    public LegacyBitsOfSecurityConstraint(int i, int i2) {
        super(Collections.EMPTY_SET);
        this.requiredBitsOfSecurity = i;
        this.legacyRequiredBitsOfSecurity = i2;
    }

    public LegacyBitsOfSecurityConstraint(int i, int i2, Set<String> set) {
        super(set);
        this.requiredBitsOfSecurity = i;
        this.legacyRequiredBitsOfSecurity = i2;
    }

    public LegacyBitsOfSecurityConstraint(int i, Set<String> set) {
        this(i, 0, set);
    }
}
