package org.bouncycastle.p226est;

import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class EnrollmentResponse {
    private final long notBefore;
    private final PrivateKeyInfo privateKeyInfo;
    private final ESTRequest requestToRetry;

    /* renamed from: source */
    private final InterfaceC5444Source f21203source;

    /* renamed from: store */
    private final InterfaceC6249Store<X509CertificateHolder> f21204store;

    public EnrollmentResponse(InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store, long j, ESTRequest eSTRequest, InterfaceC5444Source interfaceC5444Source) {
        this.f21204store = interfaceC6249Store;
        this.notBefore = j;
        this.requestToRetry = eSTRequest;
        this.f21203source = interfaceC5444Source;
        this.privateKeyInfo = null;
    }

    public boolean canRetry() {
        return this.notBefore < System.currentTimeMillis();
    }

    public long getNotBefore() {
        return this.notBefore;
    }

    public PrivateKeyInfo getPrivateKeyInfo() {
        return this.privateKeyInfo;
    }

    public ESTRequest getRequestToRetry() {
        return this.requestToRetry;
    }

    public Object getSession() {
        return this.f21203source.getSession();
    }

    public InterfaceC5444Source getSource() {
        return this.f21203source;
    }

    public InterfaceC6249Store<X509CertificateHolder> getStore() {
        return this.f21204store;
    }

    public boolean isCompleted() {
        return this.requestToRetry == null;
    }

    public EnrollmentResponse(InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store, long j, ESTRequest eSTRequest, InterfaceC5444Source interfaceC5444Source, PrivateKeyInfo privateKeyInfo) {
        this.f21204store = interfaceC6249Store;
        this.notBefore = j;
        this.requestToRetry = eSTRequest;
        this.f21203source = interfaceC5444Source;
        this.privateKeyInfo = privateKeyInfo;
    }
}
