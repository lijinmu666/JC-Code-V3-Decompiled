package org.bouncycastle.p226est.p227jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p226est.ESTClient;
import org.bouncycastle.p226est.ESTClientSourceProvider;
import org.bouncycastle.p226est.ESTException;
import org.bouncycastle.p226est.ESTRequest;
import org.bouncycastle.p226est.ESTRequestBuilder;
import org.bouncycastle.p226est.ESTResponse;
import org.bouncycastle.p226est.InterfaceC5444Source;
import org.bouncycastle.p361util.Properties;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
class DefaultESTClient implements ESTClient {
    private final ESTClientSourceProvider sslSocketProvider;

    /* renamed from: utf8 */
    private static final Charset f21211utf8 = Charset.forName("UTF-8");

    /* renamed from: CRLF */
    private static byte[] f21210CRLF = {13, 10};

    public static class PrintingOutputStream extends OutputStream {

        /* renamed from: tgt */
        private final OutputStream f21212tgt;

        public PrintingOutputStream(OutputStream outputStream) {
            this.f21212tgt = outputStream;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            System.out.print(String.valueOf((char) i));
            this.f21212tgt.write(i);
        }
    }

    public DefaultESTClient(ESTClientSourceProvider eSTClientSourceProvider) {
        this.sslSocketProvider = eSTClientSourceProvider;
    }

    private static void writeLine(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes());
        outputStream.write(f21210CRLF);
    }

    @Override // org.bouncycastle.p226est.ESTClient
    public ESTResponse doRequest(ESTRequest eSTRequest) throws IOException {
        ESTResponse eSTResponsePerformRequest;
        int i = 15;
        while (true) {
            eSTResponsePerformRequest = performRequest(eSTRequest);
            ESTRequest eSTRequestRedirectURL = redirectURL(eSTResponsePerformRequest);
            if (eSTRequestRedirectURL == null || i - 1 <= 0) {
                break;
            }
            eSTRequest = eSTRequestRedirectURL;
        }
        if (i != 0) {
            return eSTResponsePerformRequest;
        }
        throw new ESTException("Too many redirects..");
    }

    public ESTResponse performRequest(ESTRequest eSTRequest) {
        InterfaceC5444Source interfaceC5444Source = null;
        try {
            InterfaceC5444Source interfaceC5444SourceMakeSource = this.sslSocketProvider.makeSource(eSTRequest.m15960getURL().getHost(), eSTRequest.m15960getURL().getPort());
            if (eSTRequest.getListener() != null) {
                eSTRequest = eSTRequest.getListener().onConnection(interfaceC5444SourceMakeSource, eSTRequest);
            }
            Set<String> setAsKeySet = Properties.asKeySet("org.bouncycastle.debug.est");
            OutputStream printingOutputStream = (setAsKeySet.contains("output") || setAsKeySet.contains("all")) ? new PrintingOutputStream(interfaceC5444SourceMakeSource.getOutputStream()) : interfaceC5444SourceMakeSource.getOutputStream();
            StringBuilder sb = new StringBuilder();
            sb.append(eSTRequest.m15960getURL().getPath());
            sb.append(eSTRequest.m15960getURL().getQuery() != null ? eSTRequest.m15960getURL().getQuery() : BuildConfig.f24315FLAVOR);
            String string = sb.toString();
            ESTRequestBuilder eSTRequestBuilder = new ESTRequestBuilder(eSTRequest);
            if (!eSTRequest.getHeaders().containsKey("Connection")) {
                eSTRequestBuilder.addHeader("Connection", "close");
            }
            URL urlM15960getURL = eSTRequest.m15960getURL();
            eSTRequestBuilder.setHeader("Host", urlM15960getURL.getPort() > -1 ? String.format("%s:%d", urlM15960getURL.getHost(), Integer.valueOf(urlM15960getURL.getPort())) : urlM15960getURL.getHost());
            ESTRequest eSTRequestM15961build = eSTRequestBuilder.m15961build();
            writeLine(printingOutputStream, eSTRequestM15961build.getMethod() + " " + string + " HTTP/1.1");
            for (Map.Entry<String, String[]> entry : eSTRequestM15961build.getHeaders().entrySet()) {
                String[] value = entry.getValue();
                for (int i = 0; i != value.length; i++) {
                    writeLine(printingOutputStream, entry.getKey() + ": " + value[i]);
                }
            }
            printingOutputStream.write(f21210CRLF);
            printingOutputStream.flush();
            eSTRequestM15961build.writeData(printingOutputStream);
            printingOutputStream.flush();
            if (eSTRequestM15961build.getHijacker() == null) {
                return new ESTResponse(eSTRequestM15961build, interfaceC5444SourceMakeSource);
            }
            ESTResponse eSTResponseMo15959hijack = eSTRequestM15961build.getHijacker().mo15959hijack(eSTRequestM15961build, interfaceC5444SourceMakeSource);
            if (interfaceC5444SourceMakeSource != null && eSTResponseMo15959hijack == null) {
                interfaceC5444SourceMakeSource.mo15977close();
            }
            return eSTResponseMo15959hijack;
        } catch (Throwable th) {
            if (0 != 0) {
                interfaceC5444Source.mo15977close();
            }
            throw th;
        }
    }

    public ESTRequest redirectURL(ESTResponse eSTResponse) throws IOException {
        ESTRequest eSTRequestM15961build;
        ESTRequestBuilder eSTRequestBuilderM15962withURL;
        if (eSTResponse.getStatusCode() < 300 || eSTResponse.getStatusCode() > 399) {
            eSTRequestM15961build = null;
        } else {
            switch (eSTResponse.getStatusCode()) {
                case 301:
                case 302:
                case 303:
                case 306:
                case 307:
                    String header = eSTResponse.getHeader("Location");
                    if (!BuildConfig.f24315FLAVOR.equals(header)) {
                        ESTRequestBuilder eSTRequestBuilder = new ESTRequestBuilder(eSTResponse.getOriginalRequest());
                        if (header.startsWith("http")) {
                            eSTRequestBuilderM15962withURL = eSTRequestBuilder.m15962withURL(new URL(header));
                        } else {
                            URL urlM15960getURL = eSTResponse.getOriginalRequest().m15960getURL();
                            eSTRequestBuilderM15962withURL = eSTRequestBuilder.m15962withURL(new URL(urlM15960getURL.getProtocol(), urlM15960getURL.getHost(), urlM15960getURL.getPort(), header));
                        }
                        eSTRequestM15961build = eSTRequestBuilderM15962withURL.m15961build();
                        break;
                    } else {
                        throw new ESTException("Redirect status type: " + eSTResponse.getStatusCode() + " but no location header");
                    }
                case 304:
                case 305:
                default:
                    throw new ESTException("Client does not handle http status code: " + eSTResponse.getStatusCode());
            }
        }
        if (eSTRequestM15961build != null) {
            eSTResponse.m15964close();
        }
        return eSTRequestM15961build;
    }
}
