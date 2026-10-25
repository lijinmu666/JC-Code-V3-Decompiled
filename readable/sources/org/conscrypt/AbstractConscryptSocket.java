package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes2.dex */
abstract class AbstractConscryptSocket extends SSLSocket {
    private final boolean autoClose;
    private final List<HandshakeCompletedListener> listeners;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final int peerPort;
    private int readTimeoutMilliseconds;

    /* renamed from: socket */
    final Socket f24304socket;

    public AbstractConscryptSocket() {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    private boolean isDelegating() {
        Socket socket = this.f24304socket;
        return (socket == null || socket == this) ? false : true;
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        this.listeners.add(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        if (isDelegating()) {
            this.f24304socket.bind(socketAddress);
        } else {
            super.bind(socketAddress);
        }
    }

    public final void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!isDelegating()) {
            if (super.isClosed()) {
                return;
            }
            super.close();
        } else {
            if (!this.autoClose || this.f24304socket.isClosed()) {
                return;
            }
            this.f24304socket.close();
        }
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i);

    public abstract SSLSession getActiveSession();

    @Deprecated
    public abstract byte[] getAlpnSelectedProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract String getApplicationProtocol();

    public abstract String[] getApplicationProtocols();

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return null;
    }

    public abstract byte[] getChannelId();

    public FileDescriptor getFileDescriptor$() {
        return isDelegating() ? Platform.getFileDescriptor(this.f24304socket) : Platform.getFileDescriptorFromSSLSocket(this);
    }

    @Override // javax.net.ssl.SSLSocket
    public abstract String getHandshakeApplicationProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract SSLSession getHandshakeSession();

    public String getHostname() {
        return this.peerHostname;
    }

    public String getHostnameOrIP() {
        String str = this.peerHostname;
        if (str != null) {
            return str;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return Platform.getOriginalHostNameFromInetAddress(inetAddress);
        }
        return null;
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return isDelegating() ? this.f24304socket.getInetAddress() : super.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() {
        return isDelegating() ? this.f24304socket.getInputStream() : super.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() {
        return isDelegating() ? this.f24304socket.getKeepAlive() : super.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return isDelegating() ? this.f24304socket.getLocalAddress() : super.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return isDelegating() ? this.f24304socket.getLocalPort() : super.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return isDelegating() ? this.f24304socket.getLocalSocketAddress() : super.getLocalSocketAddress();
    }

    @Deprecated
    public byte[] getNpnSelectedProtocol() {
        return null;
    }

    @Override // java.net.Socket
    public boolean getOOBInline() {
        return false;
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() {
        return isDelegating() ? this.f24304socket.getOutputStream() : super.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        if (isDelegating()) {
            return this.f24304socket.getPort();
        }
        int i = this.peerPort;
        return i != -1 ? i : super.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() {
        return isDelegating() ? this.f24304socket.getReceiveBufferSize() : super.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return isDelegating() ? this.f24304socket.getRemoteSocketAddress() : super.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() {
        return isDelegating() ? this.f24304socket.getReuseAddress() : super.getReuseAddress();
    }

    @Override // java.net.Socket
    public int getSendBufferSize() {
        return isDelegating() ? this.f24304socket.getSendBufferSize() : super.getSendBufferSize();
    }

    @Override // java.net.Socket
    public int getSoLinger() {
        return isDelegating() ? this.f24304socket.getSoLinger() : super.getSoLinger();
    }

    @Override // java.net.Socket
    public final int getSoTimeout() {
        return isDelegating() ? this.f24304socket.getSoTimeout() : this.readTimeoutMilliseconds;
    }

    public int getSoWriteTimeout() {
        return 0;
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() {
        return isDelegating() ? this.f24304socket.getTcpNoDelay() : super.getTcpNoDelay();
    }

    public abstract byte[] getTlsUnique();

    @Override // java.net.Socket
    public int getTrafficClass() {
        return isDelegating() ? this.f24304socket.getTrafficClass() : super.getTrafficClass();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return isDelegating() ? this.f24304socket.isBound() : super.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return isDelegating() ? this.f24304socket.isClosed() : super.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return isDelegating() ? this.f24304socket.isConnected() : super.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return isDelegating() ? this.f24304socket.isInputShutdown() : super.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return isDelegating() ? this.f24304socket.isOutputShutdown() : super.isOutputShutdown();
    }

    public final void notifyHandshakeCompletedListeners() {
        ArrayList arrayList = new ArrayList(this.listeners);
        if (arrayList.isEmpty()) {
            return;
        }
        HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, getActiveSession());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((HandshakeCompletedListener) it.next()).handshakeCompleted(handshakeCompletedEvent);
            } catch (RuntimeException e) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e);
            }
        }
    }

    public final PeerInfoProvider peerInfoProvider() {
        return this.peerInfoProvider;
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i) throws SocketException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @Deprecated
    public abstract void setAlpnProtocols(byte[] bArr);

    @Deprecated
    public abstract void setAlpnProtocols(String[] strArr);

    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter);

    public abstract void setApplicationProtocols(String[] strArr);

    public abstract void setChannelIdEnabled(boolean z);

    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    public void setHandshakeTimeout(int i) throws SocketException {
        throw new SocketException("Method setHandshakeTimeout() is not supported.");
    }

    public void setHostname(String str) {
        this.peerHostname = str;
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setKeepAlive(z);
        } else {
            super.setKeepAlive(z);
        }
    }

    @Deprecated
    public void setNpnProtocols(byte[] bArr) {
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        throw new SocketException("Method setOOBInline() is not supported.");
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i, int i2, int i3) {
        if (isDelegating()) {
            this.f24304socket.setPerformancePreferences(i, i2, i3);
        } else {
            super.setPerformancePreferences(i, i2, i3);
        }
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setReceiveBufferSize(i);
        } else {
            super.setReceiveBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setReuseAddress(z);
        } else {
            super.setReuseAddress(z);
        }
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setSendBufferSize(i);
        } else {
            super.setSendBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setSoLinger(z, i);
        } else {
            super.setSoLinger(z, i);
        }
    }

    @Override // java.net.Socket
    public final void setSoTimeout(int i) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setSoTimeout(i);
        } else {
            super.setSoTimeout(i);
            this.readTimeoutMilliseconds = i;
        }
    }

    public void setSoWriteTimeout(int i) throws SocketException {
        throw new SocketException("Method setSoWriteTimeout() is not supported.");
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setTcpNoDelay(z);
        } else {
            super.setTcpNoDelay(z);
        }
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) throws SocketException {
        if (isDelegating()) {
            this.f24304socket.setTrafficClass(i);
        } else {
            super.setTrafficClass(i);
        }
    }

    public abstract void setUseSessionTickets(boolean z);

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        if (isDelegating()) {
            this.f24304socket.shutdownInput();
        } else {
            super.shutdownInput();
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        if (isDelegating()) {
            this.f24304socket.shutdownOutput();
        } else {
            super.shutdownOutput();
        }
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        StringBuilder sb = new StringBuilder("SSL socket over ");
        if (isDelegating()) {
            sb.append(this.f24304socket.toString());
        } else {
            sb.append(super.toString());
        }
        return sb.toString();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        if (this.peerHostname == null && (socketAddress instanceof InetSocketAddress)) {
            this.peerHostname = Platform.getHostStringFromInetSocketAddress((InetSocketAddress) socketAddress);
        }
        if (isDelegating()) {
            this.f24304socket.connect(socketAddress, i);
        } else {
            super.connect(socketAddress, i);
        }
    }

    public AbstractConscryptSocket(String str, int i) {
        super(str, i);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(InetAddress inetAddress, int i) {
        super(inetAddress, i);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(String str, int i, InetAddress inetAddress, int i2) {
        super(str, i, inetAddress, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        super(inetAddress, i, inetAddress2, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(Socket socket, String str, int i, boolean z) {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            /* renamed from: getPort */
            public int mo18409getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.f24304socket = (Socket) Preconditions.checkNotNull(socket, "socket");
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = z;
    }
}
