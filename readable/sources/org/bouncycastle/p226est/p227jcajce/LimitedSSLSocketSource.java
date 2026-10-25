package org.bouncycastle.p226est.p227jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.p226est.InterfaceC5444Source;
import org.bouncycastle.p226est.LimitedSource;
import org.bouncycastle.p226est.TLSUniqueProvider;

/* loaded from: classes2.dex */
class LimitedSSLSocketSource implements InterfaceC5444Source<SSLSession>, TLSUniqueProvider, LimitedSource {
    private final Long absoluteReadLimit;
    private final ChannelBindingProvider bindingProvider;

    /* renamed from: socket */
    protected final SSLSocket f21219socket;

    public LimitedSSLSocketSource(SSLSocket sSLSocket, ChannelBindingProvider channelBindingProvider, Long l) {
        this.f21219socket = sSLSocket;
        this.bindingProvider = channelBindingProvider;
        this.absoluteReadLimit = l;
    }

    @Override // org.bouncycastle.p226est.InterfaceC5444Source
    /* renamed from: close */
    public void mo15977close() throws IOException {
        this.f21219socket.close();
    }

    @Override // org.bouncycastle.p226est.LimitedSource
    public Long getAbsoluteReadLimit() {
        return this.absoluteReadLimit;
    }

    @Override // org.bouncycastle.p226est.InterfaceC5444Source
    public InputStream getInputStream() {
        return this.f21219socket.getInputStream();
    }

    @Override // org.bouncycastle.p226est.InterfaceC5444Source
    public OutputStream getOutputStream() {
        return this.f21219socket.getOutputStream();
    }

    @Override // org.bouncycastle.p226est.TLSUniqueProvider
    public byte[] getTLSUnique() {
        if (isTLSUniqueAvailable()) {
            return this.bindingProvider.getChannelBinding(this.f21219socket, "tls-unique");
        }
        throw new IllegalStateException("No binding provider.");
    }

    @Override // org.bouncycastle.p226est.TLSUniqueProvider
    public boolean isTLSUniqueAvailable() {
        return this.bindingProvider.canAccessChannelBinding(this.f21219socket);
    }

    @Override // org.bouncycastle.p226est.InterfaceC5444Source
    public SSLSession getSession() {
        return this.f21219socket.getSession();
    }
}
