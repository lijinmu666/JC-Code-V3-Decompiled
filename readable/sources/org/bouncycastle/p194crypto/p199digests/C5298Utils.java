package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* renamed from: org.bouncycastle.crypto.digests.Utils */
/* loaded from: classes2.dex */
class C5298Utils {

    /* renamed from: org.bouncycastle.crypto.digests.Utils$DefaultProperties */
    public static class DefaultProperties implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;

        /* renamed from: purpose */
        private final CryptoServicePurpose f19596purpose;

        public DefaultProperties(int i, String str, CryptoServicePurpose cryptoServicePurpose) {
            this.bitsOfSecurity = i;
            this.algorithmName = str;
            this.f19596purpose = cryptoServicePurpose;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public int bitsOfSecurity() {
            return this.bitsOfSecurity;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public Object getParams() {
            return null;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public CryptoServicePurpose getPurpose() {
            return this.f19596purpose;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    /* renamed from: org.bouncycastle.crypto.digests.Utils$DefaultPropertiesWithPRF */
    public static class DefaultPropertiesWithPRF implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;
        private final int prfBitsOfSecurity;

        /* renamed from: purpose */
        private final CryptoServicePurpose f19597purpose;

        public DefaultPropertiesWithPRF(int i, int i2, String str, CryptoServicePurpose cryptoServicePurpose) {
            this.bitsOfSecurity = i;
            this.prfBitsOfSecurity = i2;
            this.algorithmName = str;
            this.f19597purpose = cryptoServicePurpose;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public int bitsOfSecurity() {
            return this.f19597purpose == CryptoServicePurpose.PRF ? this.prfBitsOfSecurity : this.bitsOfSecurity;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public Object getParams() {
            return null;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public CryptoServicePurpose getPurpose() {
            return this.f19597purpose;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    public static CryptoServiceProperties getDefaultProperties(InterfaceC5277Digest interfaceC5277Digest, int i, CryptoServicePurpose cryptoServicePurpose) {
        return new DefaultPropertiesWithPRF(interfaceC5277Digest.getDigestSize() * 4, i, interfaceC5277Digest.getAlgorithmName(), cryptoServicePurpose);
    }

    public static CryptoServiceProperties getDefaultProperties(InterfaceC5277Digest interfaceC5277Digest, CryptoServicePurpose cryptoServicePurpose) {
        return new DefaultProperties(interfaceC5277Digest.getDigestSize() * 4, interfaceC5277Digest.getAlgorithmName(), cryptoServicePurpose);
    }
}
