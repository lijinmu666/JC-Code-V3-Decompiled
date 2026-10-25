package org.bouncycastle.p366x509;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.p366x509.X509Util;
import org.bouncycastle.p366x509.p367util.StreamParser;

/* loaded from: classes2.dex */
public class X509StreamParser implements StreamParser {
    private Provider _provider;

    /* renamed from: _spi */
    private X509StreamParserSpi f24291_spi;

    private X509StreamParser(Provider provider, X509StreamParserSpi x509StreamParserSpi) {
        this._provider = provider;
        this.f24291_spi = x509StreamParserSpi;
    }

    private static X509StreamParser createParser(X509Util.Implementation implementation) {
        return new X509StreamParser(implementation.getProvider(), (X509StreamParserSpi) implementation.getEngine());
    }

    public static X509StreamParser getInstance(String str) throws NoSuchParserException {
        try {
            return createParser(X509Util.getImplementation("X509StreamParser", str));
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchParserException(e.getMessage());
        }
    }

    public Provider getProvider() {
        return this._provider;
    }

    /* renamed from: init */
    public void m18396init(InputStream inputStream) {
        this.f24291_spi.engineInit(inputStream);
    }

    @Override // org.bouncycastle.p366x509.p367util.StreamParser
    /* renamed from: read */
    public Object mo18398read() {
        return this.f24291_spi.engineRead();
    }

    @Override // org.bouncycastle.p366x509.p367util.StreamParser
    /* renamed from: readAll */
    public Collection mo18399readAll() {
        return this.f24291_spi.engineReadAll();
    }

    public static X509StreamParser getInstance(String str, String str2) {
        return getInstance(str, X509Util.getProvider(str2));
    }

    /* renamed from: init */
    public void m18397init(byte[] bArr) {
        this.f24291_spi.engineInit(new ByteArrayInputStream(bArr));
    }

    public static X509StreamParser getInstance(String str, Provider provider) throws NoSuchParserException {
        try {
            return createParser(X509Util.getImplementation("X509StreamParser", str, provider));
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchParserException(e.getMessage());
        }
    }
}
