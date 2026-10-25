package org.conscrypt;

import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: classes2.dex */
public abstract class OpenSSLContextImpl extends SSLContextSpi {
    private static DefaultSSLContextImpl defaultSslContextImpl;
    private final ClientSessionContext clientSessionContext;
    private final String[] protocols;
    private final ServerSessionContext serverSessionContext;
    SSLParametersImpl sslParameters;

    /* renamed from: org.conscrypt.OpenSSLContextImpl$TLSv1 */
    public static final class C6309TLSv1 extends OpenSSLContextImpl {
        public C6309TLSv1() {
            super(NativeCrypto.TLSV1_PROTOCOLS);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLContextImpl$TLSv11 */
    public static final class C6310TLSv11 extends OpenSSLContextImpl {
        public C6310TLSv11() {
            super(NativeCrypto.TLSV11_PROTOCOLS);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLContextImpl$TLSv12 */
    public static final class C6311TLSv12 extends OpenSSLContextImpl {
        public C6311TLSv12() {
            super(NativeCrypto.TLSV12_PROTOCOLS);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLContextImpl$TLSv13 */
    public static final class C6312TLSv13 extends OpenSSLContextImpl {
        public C6312TLSv13() {
            super(NativeCrypto.TLSV13_PROTOCOLS);
        }
    }

    public OpenSSLContextImpl(String[] strArr) {
        this.protocols = strArr;
        this.clientSessionContext = new ClientSessionContext();
        this.serverSessionContext = new ServerSessionContext();
    }

    public static OpenSSLContextImpl getPreferred() {
        return new C6312TLSv13();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i) {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.m18501clone();
        sSLParametersImpl2.setUseClientMode(false);
        return Platform.wrapEngine(new ConscryptEngine(str, i, sSLParametersImpl2));
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetClientSessionContext() {
        return this.clientSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetServerSessionContext() {
        return this.serverSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (this.sslParameters != null) {
            return new OpenSSLServerSocketFactoryImpl(this.sslParameters);
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        if (this.sslParameters != null) {
            return Platform.wrapSocketFactoryIfNeeded(new OpenSSLSocketFactoryImpl(this.sslParameters));
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        this.sslParameters = new SSLParametersImpl(keyManagerArr, trustManagerArr, secureRandom, this.clientSessionContext, this.serverSessionContext, this.protocols);
    }

    public OpenSSLContextImpl(String[] strArr, boolean z) {
        synchronized (DefaultSSLContextImpl.class) {
            try {
                this.protocols = null;
                DefaultSSLContextImpl defaultSSLContextImpl = defaultSslContextImpl;
                if (defaultSSLContextImpl == null) {
                    this.clientSessionContext = new ClientSessionContext();
                    this.serverSessionContext = new ServerSessionContext();
                    defaultSslContextImpl = (DefaultSSLContextImpl) this;
                } else {
                    this.clientSessionContext = (ClientSessionContext) defaultSSLContextImpl.engineGetClientSessionContext();
                    this.serverSessionContext = (ServerSessionContext) defaultSslContextImpl.engineGetServerSessionContext();
                }
                this.sslParameters = new SSLParametersImpl(defaultSslContextImpl.getKeyManagers(), defaultSslContextImpl.getTrustManagers(), (SecureRandom) null, this.clientSessionContext, this.serverSessionContext, strArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl != null) {
            SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.m18501clone();
            sSLParametersImpl2.setUseClientMode(false);
            return Platform.wrapEngine(new ConscryptEngine(sSLParametersImpl2));
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }
}
