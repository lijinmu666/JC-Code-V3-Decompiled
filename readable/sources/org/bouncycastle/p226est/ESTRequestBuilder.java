package org.bouncycastle.p226est;

import java.net.URL;
import org.bouncycastle.p226est.HttpUtil;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ESTRequestBuilder {

    /* renamed from: client */
    ESTClient f21183client;

    /* renamed from: data */
    private byte[] f21184data;

    /* renamed from: headers */
    private HttpUtil.C5443Headers f21185headers;
    ESTHijacker hijacker;
    ESTSourceConnectionListener listener;

    /* renamed from: method */
    private final String f21186method;

    /* renamed from: url */
    private URL f21187url;

    public ESTRequestBuilder(String str, URL url) {
        this.f21186method = str;
        this.f21187url = url;
        this.f21185headers = new HttpUtil.C5443Headers();
    }

    public ESTRequestBuilder addHeader(String str, String str2) {
        this.f21185headers.m15972add(str, str2);
        return this;
    }

    /* renamed from: build */
    public ESTRequest m15961build() {
        return new ESTRequest(this.f21186method, this.f21187url, this.f21184data, this.hijacker, this.listener, this.f21185headers, this.f21183client);
    }

    public ESTRequestBuilder setHeader(String str, String str2) {
        this.f21185headers.m15973set(str, str2);
        return this;
    }

    public ESTRequestBuilder withClient(ESTClient eSTClient) {
        this.f21183client = eSTClient;
        return this;
    }

    public ESTRequestBuilder withConnectionListener(ESTSourceConnectionListener eSTSourceConnectionListener) {
        this.listener = eSTSourceConnectionListener;
        return this;
    }

    public ESTRequestBuilder withData(byte[] bArr) {
        this.f21184data = C6238Arrays.m18231clone(bArr);
        return this;
    }

    public ESTRequestBuilder withHijacker(ESTHijacker eSTHijacker) {
        this.hijacker = eSTHijacker;
        return this;
    }

    /* renamed from: withURL */
    public ESTRequestBuilder m15962withURL(URL url) {
        this.f21187url = url;
        return this;
    }

    public ESTRequestBuilder(ESTRequest eSTRequest) {
        this.f21186method = eSTRequest.f21181method;
        this.f21187url = eSTRequest.f21182url;
        this.listener = eSTRequest.listener;
        this.f21184data = eSTRequest.f21179data;
        this.hijacker = eSTRequest.hijacker;
        this.f21185headers = (HttpUtil.C5443Headers) eSTRequest.f21180headers.clone();
        this.f21183client = eSTRequest.getClient();
    }
}
