package org.bouncycastle.p194crypto.constraints;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;

/* loaded from: classes2.dex */
public class DefaultServiceProperties implements CryptoServiceProperties {
    private final String algorithm;
    private final int bitsOfSecurity;

    /* renamed from: params */
    private final Object f19262params;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19263purpose;

    public DefaultServiceProperties(String str, int i) {
        this(str, i, null, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
    public int bitsOfSecurity() {
        return this.bitsOfSecurity;
    }

    @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
    public Object getParams() {
        return this.f19262params;
    }

    @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
    public CryptoServicePurpose getPurpose() {
        return this.f19263purpose;
    }

    @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
    public String getServiceName() {
        return this.algorithm;
    }

    public DefaultServiceProperties(String str, int i, Object obj) {
        this(str, i, obj, CryptoServicePurpose.ANY);
    }

    public DefaultServiceProperties(String str, int i, Object obj, CryptoServicePurpose cryptoServicePurpose) {
        this.algorithm = str;
        this.bitsOfSecurity = i;
        this.f19262params = obj;
        if (obj instanceof CryptoServicePurpose) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.f19263purpose = cryptoServicePurpose;
    }
}
