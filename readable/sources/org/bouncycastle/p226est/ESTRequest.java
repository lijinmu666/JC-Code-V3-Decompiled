package org.bouncycastle.p226est;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import org.bouncycastle.p226est.HttpUtil;

/* loaded from: classes2.dex */
public class ESTRequest {

    /* renamed from: data */
    final byte[] f21179data;
    final ESTClient estClient;

    /* renamed from: headers */
    HttpUtil.C5443Headers f21180headers;
    final ESTHijacker hijacker;
    final ESTSourceConnectionListener listener;

    /* renamed from: method */
    final String f21181method;

    /* renamed from: url */
    final URL f21182url;

    public ESTRequest(String str, URL url, byte[] bArr, ESTHijacker eSTHijacker, ESTSourceConnectionListener eSTSourceConnectionListener, HttpUtil.C5443Headers c5443Headers, ESTClient eSTClient) {
        new HttpUtil.C5443Headers();
        this.f21181method = str;
        this.f21182url = url;
        this.f21179data = bArr;
        this.hijacker = eSTHijacker;
        this.listener = eSTSourceConnectionListener;
        this.f21180headers = c5443Headers;
        this.estClient = eSTClient;
    }

    public ESTClient getClient() {
        return this.estClient;
    }

    public Map<String, String[]> getHeaders() {
        return (Map) this.f21180headers.clone();
    }

    public ESTHijacker getHijacker() {
        return this.hijacker;
    }

    public ESTSourceConnectionListener getListener() {
        return this.listener;
    }

    public String getMethod() {
        return this.f21181method;
    }

    /* renamed from: getURL */
    public URL m15960getURL() {
        return this.f21182url;
    }

    public void writeData(OutputStream outputStream) throws IOException {
        byte[] bArr = this.f21179data;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }
}
