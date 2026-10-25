package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.NativeCrypto;
import org.conscrypt.SSLParametersImpl;

/* loaded from: classes2.dex */
final class NativeSsl {
    private final SSLParametersImpl.AliasChooser aliasChooser;
    private final NativeCrypto.SSLHandshakeCallbacks handshakeCallbacks;
    private X509Certificate[] localCertificates;

    /* renamed from: lock */
    private final ReadWriteLock f24380lock = new ReentrantReadWriteLock();
    private final SSLParametersImpl parameters;
    private final SSLParametersImpl.PSKCallbacks pskCallbacks;

    /* renamed from: ssl */
    private volatile long f24381ssl;

    public final class BioWrapper {

        /* renamed from: bio */
        private volatile long f24382bio;

        /* renamed from: close */
        public void m18458close() {
            NativeSsl.this.f24380lock.writeLock().lock();
            try {
                long j = this.f24382bio;
                this.f24382bio = 0L;
                if (j != 0) {
                    NativeCrypto.BIO_free_all(j);
                }
            } finally {
                NativeSsl.this.f24380lock.writeLock().unlock();
            }
        }

        public int getPendingWrittenBytes() {
            NativeSsl.this.f24380lock.readLock().lock();
            try {
                return this.f24382bio == 0 ? 0 : NativeCrypto.SSL_pending_written_bytes_in_BIO(this.f24382bio);
            } finally {
                NativeSsl.this.f24380lock.readLock().unlock();
            }
        }

        public int readDirectByteBuffer(long j, int i) {
            NativeSsl.this.f24380lock.readLock().lock();
            try {
                if (NativeSsl.this.isClosed()) {
                    throw new SSLException("Connection closed");
                }
                return NativeCrypto.ENGINE_SSL_read_BIO_direct(NativeSsl.this.f24381ssl, NativeSsl.this, this.f24382bio, j, i, NativeSsl.this.handshakeCallbacks);
            } finally {
                NativeSsl.this.f24380lock.readLock().unlock();
            }
        }

        public int writeDirectByteBuffer(long j, int i) {
            NativeSsl.this.f24380lock.readLock().lock();
            try {
                if (NativeSsl.this.isClosed()) {
                    throw new SSLException("Connection closed");
                }
                return NativeCrypto.ENGINE_SSL_write_BIO_direct(NativeSsl.this.f24381ssl, NativeSsl.this, this.f24382bio, j, i, NativeSsl.this.handshakeCallbacks);
            } finally {
                NativeSsl.this.f24380lock.readLock().unlock();
            }
        }

        private BioWrapper() {
            this.f24382bio = NativeCrypto.SSL_BIO_new(NativeSsl.this.f24381ssl, NativeSsl.this);
        }
    }

    private NativeSsl(long j, SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        this.f24381ssl = j;
        this.parameters = sSLParametersImpl;
        this.handshakeCallbacks = sSLHandshakeCallbacks;
        this.aliasChooser = aliasChooser;
        this.pskCallbacks = pSKCallbacks;
    }

    private void enablePSKKeyManagerIfRequested() {
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager != null) {
            for (String str : this.parameters.enabledCipherSuites) {
                if (str != null && str.contains("PSK")) {
                    if (isClient()) {
                        NativeCrypto.set_SSL_psk_client_callback_enabled(this.f24381ssl, this, true);
                        return;
                    }
                    NativeCrypto.set_SSL_psk_server_callback_enabled(this.f24381ssl, this, true);
                    NativeCrypto.SSL_use_psk_identity_hint(this.f24381ssl, this, this.pskCallbacks.chooseServerPSKIdentityHint(pSKKeyManager));
                    return;
                }
            }
        }
    }

    private Set<String> getCipherKeyTypes() {
        HashSet hashSet = new HashSet();
        for (long j : NativeCrypto.SSL_get_ciphers(this.f24381ssl, this)) {
            String serverX509KeyType = SSLUtils.getServerX509KeyType(j);
            if (serverX509KeyType != null) {
                hashSet.add(serverX509KeyType);
            }
        }
        return hashSet;
    }

    private boolean isClient() {
        return this.parameters.getUseClientMode();
    }

    public static NativeSsl newInstance(SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        AbstractSessionContext sessionContext = sSLParametersImpl.getSessionContext();
        return new NativeSsl(NativeCrypto.m18448SSL_new(sessionContext.sslCtxNativePointer, sessionContext), sSLParametersImpl, sSLHandshakeCallbacks, aliasChooser, pSKCallbacks);
    }

    private void setCertificate(String str) throws SSLException {
        X509KeyManager x509KeyManager;
        PrivateKey privateKey;
        if (str == null || (x509KeyManager = this.parameters.getX509KeyManager()) == null || (privateKey = x509KeyManager.getPrivateKey(str)) == null) {
            return;
        }
        X509Certificate[] certificateChain = x509KeyManager.getCertificateChain(str);
        this.localCertificates = certificateChain;
        if (certificateChain == null) {
            return;
        }
        int length = certificateChain.length;
        PublicKey publicKey = length > 0 ? certificateChain[0].getPublicKey() : null;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < length; i++) {
            bArr[i] = this.localCertificates[i].getEncoded();
        }
        try {
            NativeCrypto.setLocalCertsAndPrivateKey(this.f24381ssl, this, bArr, OpenSSLKey.fromPrivateKeyForTLSStackOnly(privateKey, publicKey).getNativeRef());
        } catch (InvalidKeyException e) {
            throw new SSLException(e);
        }
    }

    private void setCertificateValidation() throws SSLException {
        if (isClient()) {
            return;
        }
        if (this.parameters.getNeedClientAuth()) {
            NativeCrypto.SSL_set_verify(this.f24381ssl, this, 3);
        } else {
            if (!this.parameters.getWantClientAuth()) {
                NativeCrypto.SSL_set_verify(this.f24381ssl, this, 0);
                return;
            }
            NativeCrypto.SSL_set_verify(this.f24381ssl, this, 1);
        }
        X509Certificate[] acceptedIssuers = this.parameters.getX509TrustManager().getAcceptedIssuers();
        if (acceptedIssuers == null || acceptedIssuers.length == 0) {
            return;
        }
        try {
            NativeCrypto.SSL_set_client_CA_list(this.f24381ssl, this, SSLUtils.encodeSubjectX509Principals(acceptedIssuers));
        } catch (CertificateEncodingException e) {
            throw new SSLException("Problem encoding principals", e);
        }
    }

    private void setTlsChannelId(OpenSSLKey openSSLKey) throws SSLHandshakeException {
        SSLParametersImpl sSLParametersImpl = this.parameters;
        if (sSLParametersImpl.channelIdEnabled) {
            if (!sSLParametersImpl.getUseClientMode()) {
                NativeCrypto.SSL_enable_tls_channel_id(this.f24381ssl, this);
            } else {
                if (openSSLKey == null) {
                    throw new SSLHandshakeException("Invalid TLS channel ID key specified");
                }
                NativeCrypto.SSL_set1_tls_channel_id(this.f24381ssl, this, openSSLKey.getNativeRef());
            }
        }
    }

    private void verifyWithSniMatchers(String str) throws SSLHandshakeException {
        if (AddressUtils.isValidSniHostname(str) && !Platform.serverNamePermitted(this.parameters, str)) {
            throw new SSLHandshakeException("SNI match failed: " + str);
        }
    }

    public void chooseClientCertificate(byte[] bArr, int[] iArr, byte[][] bArr2) throws SSLException {
        X500Principal[] x500PrincipalArr;
        Set<String> supportedClientKeyTypes = SSLUtils.getSupportedClientKeyTypes(bArr, iArr);
        String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[supportedClientKeyTypes.size()]);
        if (bArr2 == null) {
            x500PrincipalArr = null;
        } else {
            x500PrincipalArr = new X500Principal[bArr2.length];
            for (int i = 0; i < bArr2.length; i++) {
                x500PrincipalArr[i] = new X500Principal(bArr2[i]);
            }
        }
        X509KeyManager x509KeyManager = this.parameters.getX509KeyManager();
        setCertificate(x509KeyManager != null ? this.aliasChooser.chooseClientAlias(x509KeyManager, x500PrincipalArr, strArr) : null);
    }

    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) throws UnsupportedEncodingException {
        byte[] bytes;
        String str2;
        byte[] bArr3;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null) {
            return 0;
        }
        String strChooseClientPSKIdentity = this.pskCallbacks.chooseClientPSKIdentity(pSKKeyManager, str);
        if (strChooseClientPSKIdentity == null) {
            bArr3 = EmptyArray.f24348BYTE;
            str2 = BuildConfig.f24315FLAVOR;
        } else {
            if (strChooseClientPSKIdentity.isEmpty()) {
                bytes = EmptyArray.f24348BYTE;
            } else {
                try {
                    bytes = strChooseClientPSKIdentity.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("UTF-8 encoding not supported", e);
                }
            }
            byte[] bArr4 = bytes;
            str2 = strChooseClientPSKIdentity;
            bArr3 = bArr4;
        }
        if (bArr3.length + 1 > bArr.length) {
            return 0;
        }
        if (bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        }
        bArr[bArr3.length] = 0;
        byte[] encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded();
        if (encoded == null || encoded.length > bArr2.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr2, 0, encoded.length);
        return encoded.length;
    }

    /* renamed from: close */
    public void m18453close() {
        this.f24380lock.writeLock().lock();
        try {
            if (!isClosed()) {
                long j = this.f24381ssl;
                this.f24381ssl = 0L;
                NativeCrypto.SSL_free(j, this);
            }
        } finally {
            this.f24380lock.writeLock().unlock();
        }
    }

    public void configureServerCertificate() throws IOException {
        X509KeyManager x509KeyManager;
        verifyWithSniMatchers(getRequestedServerName());
        if (isClient() || (x509KeyManager = this.parameters.getX509KeyManager()) == null) {
            return;
        }
        Iterator<String> it = getCipherKeyTypes().iterator();
        while (it.hasNext()) {
            try {
                setCertificate(this.aliasChooser.chooseServerAlias(x509KeyManager, it.next()));
            } catch (CertificateEncodingException e) {
                throw new IOException(e);
            }
        }
    }

    public void doHandshake(FileDescriptor fileDescriptor, int i) {
        this.f24380lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            NativeCrypto.SSL_do_handshake(this.f24381ssl, this, fileDescriptor, this.handshakeCallbacks, i);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) {
        if (str == null) {
            throw new NullPointerException("Label is null");
        }
        return NativeCrypto.SSL_export_keying_material(this.f24381ssl, this, str.getBytes(Charset.forName("US-ASCII")), bArr, i);
    }

    public final void finalize() throws Throwable {
        try {
            m18453close();
        } finally {
            super.finalize();
        }
    }

    public void forceRead() {
        this.f24380lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_force_read(this.f24381ssl, this, this.handshakeCallbacks);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public byte[] getApplicationProtocol() {
        return NativeCrypto.getApplicationProtocol(this.f24381ssl, this);
    }

    public String getCipherSuite() {
        return NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_get_current_cipher(this.f24381ssl, this));
    }

    public int getError(int i) {
        return NativeCrypto.SSL_get_error(this.f24381ssl, this, i);
    }

    public X509Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    public int getMaxSealOverhead() {
        return NativeCrypto.SSL_max_seal_overhead(this.f24381ssl, this);
    }

    public byte[] getPeerCertificateOcspData() {
        return NativeCrypto.SSL_get_ocsp_response(this.f24381ssl, this);
    }

    public X509Certificate[] getPeerCertificates() {
        byte[][] bArrSSL_get0_peer_certificates = NativeCrypto.SSL_get0_peer_certificates(this.f24381ssl, this);
        if (bArrSSL_get0_peer_certificates == null) {
            return null;
        }
        return SSLUtils.decodeX509CertificateChain(bArrSSL_get0_peer_certificates);
    }

    public byte[] getPeerTlsSctData() {
        return NativeCrypto.SSL_get_signed_cert_timestamp_list(this.f24381ssl, this);
    }

    public int getPendingReadableBytes() {
        this.f24380lock.readLock().lock();
        try {
            if (!isClosed()) {
                return NativeCrypto.SSL_pending_readable_bytes(this.f24381ssl, this);
            }
            this.f24380lock.readLock().unlock();
            return 0;
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public String getRequestedServerName() {
        return NativeCrypto.SSL_get_servername(this.f24381ssl, this);
    }

    public byte[] getSessionId() {
        return NativeCrypto.SSL_session_id(this.f24381ssl, this);
    }

    /* renamed from: getTime */
    public long m18454getTime() {
        return NativeCrypto.SSL_get_time(this.f24381ssl, this);
    }

    public long getTimeout() {
        return NativeCrypto.SSL_get_timeout(this.f24381ssl, this);
    }

    public byte[] getTlsChannelId() {
        return NativeCrypto.SSL_get_tls_channel_id(this.f24381ssl, this);
    }

    public byte[] getTlsUnique() {
        return NativeCrypto.SSL_get_tls_unique(this.f24381ssl, this);
    }

    public String getVersion() {
        return NativeCrypto.SSL_get_version(this.f24381ssl, this);
    }

    public void initialize(String str, OpenSSLKey openSSLKey) throws SSLException {
        if (!this.parameters.getEnableSessionCreation()) {
            NativeCrypto.SSL_set_session_creation_enabled(this.f24381ssl, this, false);
        }
        NativeCrypto.SSL_accept_renegotiations(this.f24381ssl, this);
        if (isClient()) {
            NativeCrypto.SSL_set_connect_state(this.f24381ssl, this);
            NativeCrypto.SSL_enable_ocsp_stapling(this.f24381ssl, this);
            if (this.parameters.isCTVerificationEnabled(str)) {
                NativeCrypto.SSL_enable_signed_cert_timestamps(this.f24381ssl, this);
            }
        } else {
            NativeCrypto.SSL_set_accept_state(this.f24381ssl, this);
            if (this.parameters.getOCSPResponse() != null) {
                NativeCrypto.SSL_enable_ocsp_stapling(this.f24381ssl, this);
            }
        }
        if (this.parameters.getEnabledProtocols().length == 0 && this.parameters.isEnabledProtocolsFiltered) {
            throw new SSLHandshakeException("No enabled protocols; SSLv3 is no longer supported and was filtered from the list");
        }
        NativeCrypto.setEnabledProtocols(this.f24381ssl, this, this.parameters.enabledProtocols);
        long j = this.f24381ssl;
        SSLParametersImpl sSLParametersImpl = this.parameters;
        NativeCrypto.setEnabledCipherSuites(j, this, sSLParametersImpl.enabledCipherSuites, sSLParametersImpl.enabledProtocols);
        if (this.parameters.applicationProtocols.length > 0) {
            NativeCrypto.setApplicationProtocols(this.f24381ssl, this, isClient(), this.parameters.applicationProtocols);
        }
        if (!isClient() && this.parameters.applicationProtocolSelector != null) {
            NativeCrypto.setHasApplicationProtocolSelector(this.f24381ssl, this, true);
        }
        if (!isClient()) {
            NativeCrypto.SSL_set_options(this.f24381ssl, this, 4194304L);
            if (this.parameters.sctExtension != null) {
                NativeCrypto.SSL_set_signed_cert_timestamp_list(this.f24381ssl, this, this.parameters.sctExtension);
            }
            if (this.parameters.ocspResponse != null) {
                NativeCrypto.SSL_set_ocsp_response(this.f24381ssl, this, this.parameters.ocspResponse);
            }
        }
        enablePSKKeyManagerIfRequested();
        if (this.parameters.useSessionTickets) {
            NativeCrypto.SSL_clear_options(this.f24381ssl, this, 16384L);
        } else {
            NativeCrypto.SSL_set_options(this.f24381ssl, this, NativeCrypto.SSL_get_options(this.f24381ssl, this) | 16384);
        }
        if (this.parameters.getUseSni() && AddressUtils.isValidSniHostname(str)) {
            NativeCrypto.SSL_set_tlsext_host_name(this.f24381ssl, this, str);
        }
        NativeCrypto.SSL_set_mode(this.f24381ssl, this, 256L);
        setCertificateValidation();
        setTlsChannelId(openSSLKey);
    }

    public void interrupt() {
        NativeCrypto.SSL_interrupt(this.f24381ssl, this);
    }

    public boolean isClosed() {
        return this.f24381ssl == 0;
    }

    /* renamed from: newBio */
    public BioWrapper m18455newBio() {
        try {
            return new BioWrapper();
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    public void offerToResumeSession(long j) {
        NativeCrypto.SSL_set_session(this.f24381ssl, this, j);
    }

    /* renamed from: read */
    public int m18456read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3) {
        this.f24380lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            return NativeCrypto.SSL_read(this.f24381ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i, i2, i3);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public int readDirectByteBuffer(long j, int i) {
        this.f24380lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_read_direct(this.f24381ssl, this, j, i, this.handshakeCallbacks);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        byte[] encoded;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null || (encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded()) == null || encoded.length > bArr.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr, 0, encoded.length);
        return encoded.length;
    }

    public void setTimeout(long j) {
        NativeCrypto.SSL_set_timeout(this.f24381ssl, this, j);
    }

    public void shutdown(FileDescriptor fileDescriptor) {
        NativeCrypto.SSL_shutdown(this.f24381ssl, this, fileDescriptor, this.handshakeCallbacks);
    }

    public boolean wasShutdownReceived() {
        this.f24380lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.f24381ssl, this) & 2) != 0;
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public boolean wasShutdownSent() {
        this.f24380lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.f24381ssl, this) & 1) != 0;
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    /* renamed from: write */
    public void m18457write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3) {
        this.f24380lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            NativeCrypto.SSL_write(this.f24381ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i, i2, i3);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public int writeDirectByteBuffer(long j, int i) {
        this.f24380lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_write_direct(this.f24381ssl, this, j, i, this.handshakeCallbacks);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public void shutdown() {
        this.f24380lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_shutdown(this.f24381ssl, this, this.handshakeCallbacks);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }

    public int doHandshake() {
        this.f24380lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_do_handshake(this.f24381ssl, this, this.handshakeCallbacks);
        } finally {
            this.f24380lock.readLock().unlock();
        }
    }
}
