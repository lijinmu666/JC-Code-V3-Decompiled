package org.bouncycastle.p226est;

/* loaded from: classes2.dex */
public class ESTServiceBuilder {
    protected ESTClientProvider clientProvider;

    /* renamed from: label */
    protected String f21201label;

    /* renamed from: server */
    protected final String f21202server;

    public ESTServiceBuilder(String str) {
        this.f21202server = str;
    }

    /* renamed from: build */
    public ESTService mo15967build() {
        return new ESTService(this.f21202server, this.f21201label, this.clientProvider);
    }

    public ESTServiceBuilder withClientProvider(ESTClientProvider eSTClientProvider) {
        this.clientProvider = eSTClientProvider;
        return this;
    }

    public ESTServiceBuilder withLabel(String str) {
        this.f21201label = str;
        return this;
    }
}
