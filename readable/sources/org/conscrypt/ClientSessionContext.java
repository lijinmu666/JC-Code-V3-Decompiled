package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort;

    public static final class HostAndPort {

        /* renamed from: host */
        final String f24317host;

        /* renamed from: port */
        final int f24318port;

        public HostAndPort(String str, int i) {
            this.f24317host = str;
            this.f24318port = i;
        }

        /* renamed from: equals */
        public boolean m18419equals(Object obj) {
            if (!(obj instanceof HostAndPort)) {
                return false;
            }
            HostAndPort hostAndPort = (HostAndPort) obj;
            return this.f24317host.equals(hostAndPort.f24317host) && this.f24318port == hostAndPort.f24318port;
        }

        public int hashCode() {
            return (this.f24317host.hashCode() * 31) + this.f24318port;
        }
    }

    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    private NativeSslSession getSession(String str, int i) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession nativeSslSessionNewInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i);
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
                nativeSslSession = (list == null || list.size() <= 0) ? null : list.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (nativeSslSession != null && nativeSslSession.mo18461isValid()) {
            return nativeSslSession;
        }
        SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
        if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i)) == null || (nativeSslSessionNewInstance = NativeSslSession.newInstance(this, sessionData, str, i)) == null || !nativeSslSessionNewInstance.mo18461isValid()) {
            return null;
        }
        putSession(hostAndPort, nativeSslSessionNewInstance);
        return nativeSslSessionNewInstance;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> arrayList = this.sessionsByHostAndPort.get(hostAndPort);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.sessionsByHostAndPort.put(hostAndPort, arrayList);
                }
                if (arrayList.size() > 0 && arrayList.get(0).isSingleUse() != nativeSslSession.isSingleUse()) {
                    while (!arrayList.isEmpty()) {
                        removeSession(arrayList.get(0));
                    }
                    this.sessionsByHostAndPort.put(hostAndPort, arrayList);
                }
                arrayList.add(nativeSslSession);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
                if (list != null) {
                    list.remove(nativeSslSession);
                    if (list.isEmpty()) {
                        this.sessionsByHostAndPort.remove(hostAndPort);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized NativeSslSession getCachedSession(String str, int i, SSLParametersImpl sSLParametersImpl) {
        if (str == null) {
            return null;
        }
        NativeSslSession session = getSession(str, i);
        if (session == null) {
            return null;
        }
        String protocol = session.getProtocol();
        for (String str2 : sSLParametersImpl.enabledProtocols) {
            if (protocol.equals(str2)) {
                String cipherSuite = session.getCipherSuite();
                for (String str3 : sSLParametersImpl.getEnabledCipherSuites()) {
                    if (cipherSuite.equals(str3)) {
                        if (session.isSingleUse()) {
                            removeSession(session);
                        }
                        return session;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bArrMo18462toBytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
        if (this.persistentCache == null || nativeSslSession.isSingleUse() || (bArrMo18462toBytes = nativeSslSession.mo18462toBytes()) == null) {
            return;
        }
        this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bArrMo18462toBytes);
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost == null) {
            return;
        }
        removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    /* renamed from: size */
    public int m18418size() {
        int size;
        synchronized (this.sessionsByHostAndPort) {
            try {
                Iterator<List<NativeSslSession>> it = this.sessionsByHostAndPort.values().iterator();
                size = 0;
                while (it.hasNext()) {
                    size += it.next().size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }
}
