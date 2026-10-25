package org.bouncycastle.p226est;

import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class CACertsResponse {
    private InterfaceC6249Store<X509CRLHolder> crlHolderStore;
    private final ESTRequest requestToRetry;

    /* renamed from: session */
    private final InterfaceC5444Source f21161session;

    /* renamed from: store */
    private final InterfaceC6249Store<X509CertificateHolder> f21162store;

    /* renamed from: trusted */
    private final boolean f21163trusted;

    public CACertsResponse(InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store, InterfaceC6249Store<X509CRLHolder> interfaceC6249Store2, ESTRequest eSTRequest, InterfaceC5444Source interfaceC5444Source, boolean z) {
        this.f21162store = interfaceC6249Store;
        this.requestToRetry = eSTRequest;
        this.f21161session = interfaceC5444Source;
        this.f21163trusted = z;
        this.crlHolderStore = interfaceC6249Store2;
    }

    public InterfaceC6249Store<X509CertificateHolder> getCertificateStore() {
        InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store = this.f21162store;
        if (interfaceC6249Store != null) {
            return interfaceC6249Store;
        }
        throw new IllegalStateException("Response has no certificates.");
    }

    public InterfaceC6249Store<X509CRLHolder> getCrlStore() {
        InterfaceC6249Store<X509CRLHolder> interfaceC6249Store = this.crlHolderStore;
        if (interfaceC6249Store != null) {
            return interfaceC6249Store;
        }
        throw new IllegalStateException("Response has no CRLs.");
    }

    public ESTRequest getRequestToRetry() {
        return this.requestToRetry;
    }

    public Object getSession() {
        return this.f21161session.getSession();
    }

    /* renamed from: hasCRLs */
    public boolean m15955hasCRLs() {
        return this.crlHolderStore != null;
    }

    public boolean hasCertificates() {
        return this.f21162store != null;
    }

    public boolean isTrusted() {
        return this.f21163trusted;
    }
}
