package org.bouncycastle.p226est.p227jcajce;

import java.util.Set;
import org.bouncycastle.p226est.ESTClient;
import org.bouncycastle.p226est.ESTClientProvider;
import org.bouncycastle.p226est.ESTException;

/* loaded from: classes2.dex */
class DefaultESTHttpClientProvider implements ESTClientProvider {
    private final Long absoluteLimit;
    private final ChannelBindingProvider bindingProvider;
    private final Set<String> cipherSuites;
    private final boolean filterCipherSuites;
    private final JsseHostnameAuthorizer hostNameAuthorizer;
    private final SSLSocketFactoryCreator socketFactoryCreator;

    /* renamed from: timeout */
    private final int f21214timeout;

    public DefaultESTHttpClientProvider(JsseHostnameAuthorizer jsseHostnameAuthorizer, SSLSocketFactoryCreator sSLSocketFactoryCreator, int i, ChannelBindingProvider channelBindingProvider, Set<String> set, Long l, boolean z) {
        this.hostNameAuthorizer = jsseHostnameAuthorizer;
        this.socketFactoryCreator = sSLSocketFactoryCreator;
        this.f21214timeout = i;
        this.bindingProvider = channelBindingProvider;
        this.cipherSuites = set;
        this.absoluteLimit = l;
        this.filterCipherSuites = z;
    }

    @Override // org.bouncycastle.p226est.ESTClientProvider
    public boolean isTrusted() {
        return this.socketFactoryCreator.isTrusted();
    }

    @Override // org.bouncycastle.p226est.ESTClientProvider
    public ESTClient makeClient() throws ESTException {
        try {
            return new DefaultESTClient(new DefaultESTClientSourceProvider(this.socketFactoryCreator.createFactory(), this.hostNameAuthorizer, this.f21214timeout, this.bindingProvider, this.cipherSuites, this.absoluteLimit, this.filterCipherSuites));
        } catch (Exception e) {
            throw new ESTException(e.getMessage(), e.getCause());
        }
    }
}
