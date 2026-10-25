package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.conscrypt.NativeRef;
import org.conscrypt.SSLUtils;

/* loaded from: classes2.dex */
abstract class NativeSslSession {

    /* renamed from: logger */
    private static final Logger f24384logger = Logger.getLogger(NativeSslSession.class.getName());

    /* renamed from: org.conscrypt.NativeSslSession$Impl */
    public static final class C6300Impl extends NativeSslSession {
        private final String cipherSuite;

        /* renamed from: context */
        private final AbstractSessionContext f24385context;

        /* renamed from: host */
        private final String f24386host;
        private final X509Certificate[] peerCertificates;
        private final byte[] peerOcspStapledResponse;
        private final byte[] peerSignedCertificateTimestamp;

        /* renamed from: port */
        private final int f24387port;
        private final String protocol;

        /* renamed from: ref */
        private final NativeRef.SSL_SESSION f24388ref;

        /* JADX INFO: Access modifiers changed from: private */
        public long getCreationTime() {
            return NativeCrypto.SSL_SESSION_get_time(this.f24388ref.f24379address);
        }

        @Override // org.conscrypt.NativeSslSession
        public String getCipherSuite() {
            return this.cipherSuite;
        }

        @Override // org.conscrypt.NativeSslSession
        /* renamed from: getId */
        public byte[] mo18460getId() {
            return NativeCrypto.SSL_SESSION_session_id(this.f24388ref.f24379address);
        }

        @Override // org.conscrypt.NativeSslSession
        public String getPeerHost() {
            return this.f24386host;
        }

        @Override // org.conscrypt.NativeSslSession
        public byte[] getPeerOcspStapledResponse() {
            return this.peerOcspStapledResponse;
        }

        @Override // org.conscrypt.NativeSslSession
        public int getPeerPort() {
            return this.f24387port;
        }

        @Override // org.conscrypt.NativeSslSession
        public byte[] getPeerSignedCertificateTimestamp() {
            return this.peerSignedCertificateTimestamp;
        }

        @Override // org.conscrypt.NativeSslSession
        public String getProtocol() {
            return this.protocol;
        }

        @Override // org.conscrypt.NativeSslSession
        public boolean isSingleUse() {
            return NativeCrypto.SSL_SESSION_should_be_single_use(this.f24388ref.f24379address);
        }

        @Override // org.conscrypt.NativeSslSession
        /* renamed from: isValid */
        public boolean mo18461isValid() {
            return System.currentTimeMillis() - (Math.max(0L, Math.min((long) this.f24385context.getSessionTimeout(), NativeCrypto.SSL_SESSION_get_timeout(this.f24388ref.f24379address))) * 1000) < getCreationTime();
        }

        @Override // org.conscrypt.NativeSslSession
        public void offerToResume(NativeSsl nativeSsl) {
            nativeSsl.offerToResumeSession(this.f24388ref.f24379address);
        }

        @Override // org.conscrypt.NativeSslSession
        /* renamed from: toBytes */
        public byte[] mo18462toBytes() throws IOException, CertificateEncodingException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(SSLUtils.SessionType.OPEN_SSL_WITH_TLS_SCT.f24459value);
                byte[] bArrI2d_SSL_SESSION = NativeCrypto.i2d_SSL_SESSION(this.f24388ref.f24379address);
                dataOutputStream.writeInt(bArrI2d_SSL_SESSION.length);
                dataOutputStream.write(bArrI2d_SSL_SESSION);
                dataOutputStream.writeInt(this.peerCertificates.length);
                for (X509Certificate x509Certificate : this.peerCertificates) {
                    byte[] encoded = x509Certificate.getEncoded();
                    dataOutputStream.writeInt(encoded.length);
                    dataOutputStream.write(encoded);
                }
                if (this.peerOcspStapledResponse != null) {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.writeInt(this.peerOcspStapledResponse.length);
                    dataOutputStream.write(this.peerOcspStapledResponse);
                } else {
                    dataOutputStream.writeInt(0);
                }
                byte[] bArr = this.peerSignedCertificateTimestamp;
                if (bArr != null) {
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(this.peerSignedCertificateTimestamp);
                } else {
                    dataOutputStream.writeInt(0);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                NativeSslSession.f24384logger.log(Level.WARNING, "Failed to convert saved SSL Session: ", (Throwable) e);
                return null;
            } catch (CertificateEncodingException e2) {
                NativeSslSession.m18459log(e2);
                return null;
            }
        }

        @Override // org.conscrypt.NativeSslSession
        public SSLSession toSSLSession() {
            return new SSLSession() { // from class: org.conscrypt.NativeSslSession.Impl.1
                @Override // javax.net.ssl.SSLSession
                public int getApplicationBufferSize() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public String getCipherSuite() {
                    return C6300Impl.this.getCipherSuite();
                }

                @Override // javax.net.ssl.SSLSession
                public long getCreationTime() {
                    return C6300Impl.this.getCreationTime();
                }

                @Override // javax.net.ssl.SSLSession
                public byte[] getId() {
                    return C6300Impl.this.mo18460getId();
                }

                @Override // javax.net.ssl.SSLSession
                public long getLastAccessedTime() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Certificate[] getLocalCertificates() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Principal getLocalPrincipal() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public int getPacketBufferSize() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public javax.security.cert.X509Certificate[] getPeerCertificateChain() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Certificate[] getPeerCertificates() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public String getPeerHost() {
                    return C6300Impl.this.getPeerHost();
                }

                @Override // javax.net.ssl.SSLSession
                public int getPeerPort() {
                    return C6300Impl.this.getPeerPort();
                }

                @Override // javax.net.ssl.SSLSession
                public Principal getPeerPrincipal() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public String getProtocol() {
                    return C6300Impl.this.getProtocol();
                }

                @Override // javax.net.ssl.SSLSession
                public SSLSessionContext getSessionContext() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public Object getValue(String str) {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public String[] getValueNames() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public void invalidate() {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public boolean isValid() {
                    return C6300Impl.this.mo18461isValid();
                }

                @Override // javax.net.ssl.SSLSession
                public void putValue(String str, Object obj) {
                    throw new UnsupportedOperationException();
                }

                @Override // javax.net.ssl.SSLSession
                public void removeValue(String str) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        private C6300Impl(AbstractSessionContext abstractSessionContext, NativeRef.SSL_SESSION ssl_session, String str, int i, X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2) {
            this.f24385context = abstractSessionContext;
            this.f24386host = str;
            this.f24387port = i;
            this.peerCertificates = x509CertificateArr;
            this.peerOcspStapledResponse = bArr;
            this.peerSignedCertificateTimestamp = bArr2;
            this.protocol = NativeCrypto.SSL_SESSION_get_version(ssl_session.f24379address);
            this.cipherSuite = NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_SESSION_cipher(ssl_session.f24379address));
            this.f24388ref = ssl_session;
        }
    }

    private static void checkRemaining(ByteBuffer byteBuffer, int i) throws IOException {
        if (i < 0) {
            throw new IOException("Length is negative: " + i);
        }
        if (i <= byteBuffer.remaining()) {
            return;
        }
        throw new IOException("Length of blob is longer than available: " + i + " > " + byteBuffer.remaining());
    }

    private static byte[] getOcspResponse(ConscryptSession conscryptSession) {
        List<byte[]> statusResponses = conscryptSession.getStatusResponses();
        if (statusResponses.size() >= 1) {
            return statusResponses.get(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: log */
    public static void m18459log(Throwable th) {
        f24384logger.log(Level.INFO, "Error inflating SSL session: {0}", th.getMessage() != null ? th.getMessage() : th.getClass().getName());
    }

    public static NativeSslSession newInstance(NativeRef.SSL_SESSION ssl_session, ConscryptSession conscryptSession) {
        AbstractSessionContext abstractSessionContext = (AbstractSessionContext) conscryptSession.getSessionContext();
        if (abstractSessionContext instanceof ClientSessionContext) {
            return new C6300Impl(abstractSessionContext, ssl_session, conscryptSession.getPeerHost(), conscryptSession.getPeerPort(), conscryptSession.getPeerCertificates(), getOcspResponse(conscryptSession), conscryptSession.getPeerSignedCertificateTimestamp());
        }
        return new C6300Impl(abstractSessionContext, ssl_session, null, -1, null, null, null);
    }

    public abstract String getCipherSuite();

    /* renamed from: getId */
    public abstract byte[] mo18460getId();

    public abstract String getPeerHost();

    public abstract byte[] getPeerOcspStapledResponse();

    public abstract int getPeerPort();

    public abstract byte[] getPeerSignedCertificateTimestamp();

    public abstract String getProtocol();

    public abstract boolean isSingleUse();

    /* renamed from: isValid */
    public abstract boolean mo18461isValid();

    public abstract void offerToResume(NativeSsl nativeSsl);

    /* renamed from: toBytes */
    public abstract byte[] mo18462toBytes();

    public abstract SSLSession toSSLSession();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static NativeSslSession newInstance(AbstractSessionContext abstractSessionContext, byte[] bArr, String str, int i) throws IOException {
        byte[] bArr2;
        byte[] bArr3;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        try {
            int i2 = byteBufferWrap.getInt();
            if (SSLUtils.SessionType.isSupportedType(i2)) {
                int i3 = byteBufferWrap.getInt();
                checkRemaining(byteBufferWrap, i3);
                byte[] bArr4 = new byte[i3];
                byteBufferWrap.get(bArr4);
                int i4 = byteBufferWrap.getInt();
                checkRemaining(byteBufferWrap, i4);
                X509Certificate[] x509CertificateArr = new X509Certificate[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = byteBufferWrap.getInt();
                    checkRemaining(byteBufferWrap, i6);
                    byte[] bArr5 = new byte[i6];
                    byteBufferWrap.get(bArr5);
                    try {
                        x509CertificateArr[i5] = OpenSSLX509Certificate.fromX509Der(bArr5);
                    } catch (Exception unused) {
                        throw new IOException("Can not read certificate " + i5 + "/" + i4);
                    }
                }
                if (i2 >= SSLUtils.SessionType.OPEN_SSL_WITH_OCSP.f24459value) {
                    int i7 = byteBufferWrap.getInt();
                    checkRemaining(byteBufferWrap, i7);
                    if (i7 >= 1) {
                        int i8 = byteBufferWrap.getInt();
                        checkRemaining(byteBufferWrap, i8);
                        byte[] bArr6 = new byte[i8];
                        byteBufferWrap.get(bArr6);
                        for (int i9 = 1; i9 < i7; i9++) {
                            int i10 = byteBufferWrap.getInt();
                            checkRemaining(byteBufferWrap, i10);
                            byteBufferWrap.position(byteBufferWrap.position() + i10);
                        }
                        bArr2 = bArr6;
                    } else {
                        bArr2 = null;
                    }
                }
                if (i2 == SSLUtils.SessionType.OPEN_SSL_WITH_TLS_SCT.f24459value) {
                    int i11 = byteBufferWrap.getInt();
                    checkRemaining(byteBufferWrap, i11);
                    if (i11 > 0) {
                        byte[] bArr7 = new byte[i11];
                        byteBufferWrap.get(bArr7);
                        bArr3 = bArr7;
                    } else {
                        bArr3 = null;
                    }
                }
                if (byteBufferWrap.remaining() != 0) {
                    m18459log(new AssertionError("Read entire session, but data still remains; rejecting"));
                    return null;
                }
                return new C6300Impl(abstractSessionContext, new NativeRef.SSL_SESSION(NativeCrypto.d2i_SSL_SESSION(bArr4)), str, i, x509CertificateArr, bArr2, bArr3);
            }
            throw new IOException("Unexpected type ID: " + i2);
        } catch (IOException e) {
            m18459log(e);
            return null;
        } catch (BufferUnderflowException e2) {
            m18459log(e2);
            return null;
        }
    }
}
