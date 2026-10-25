package org.bouncycastle.p226est.p227jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p226est.HttpAuth;

/* loaded from: classes2.dex */
public class JcaHttpAuthBuilder {
    private final char[] password;
    private JcaDigestCalculatorProviderBuilder providerBuilder;

    /* renamed from: random */
    private SecureRandom f21215random;

    /* renamed from: realm */
    private final String f21216realm;
    private final String username;

    public JcaHttpAuthBuilder(String str, String str2, char[] cArr) {
        this.providerBuilder = new JcaDigestCalculatorProviderBuilder();
        this.f21215random = new SecureRandom();
        this.f21216realm = str;
        this.username = str2;
        this.password = cArr;
    }

    /* renamed from: build */
    public HttpAuth m15978build() {
        return new HttpAuth(this.f21216realm, this.username, this.password, this.f21215random, this.providerBuilder.m17397build());
    }

    public JcaHttpAuthBuilder setNonceGenerator(SecureRandom secureRandom) {
        this.f21215random = secureRandom;
        return this;
    }

    public JcaHttpAuthBuilder setProvider(String str) {
        this.providerBuilder.setProvider(str);
        return this;
    }

    public JcaHttpAuthBuilder(String str, char[] cArr) {
        this(null, str, cArr);
    }

    public JcaHttpAuthBuilder setProvider(Provider provider) {
        this.providerBuilder.setProvider(provider);
        return this;
    }
}
