package com.p038google.p061crypto.p062tink.p078util;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import org.joda.time.Instant;

/* loaded from: classes.dex */
public class KeysDownloader {
    private final Executor backgroundExecutor;

    @GuardedBy("instanceStateLock")
    private long cacheExpirationDurationInMillis;

    @GuardedBy("instanceStateLock")
    private String cachedData;

    @GuardedBy("instanceStateLock")
    private long cachedTimeInMillis;
    private final Object fetchDataLock;
    private final HttpTransport httpTransport;
    private final Object instanceStateLock;

    @GuardedBy("instanceStateLock")
    private Runnable pendingRefreshRunnable;

    /* renamed from: url */
    private final String f4022url;

    /* renamed from: UTF_8 */
    private static final Charset f4021UTF_8 = Charset.forName("UTF-8");
    private static final NetHttpTransport DEFAULT_HTTP_TRANSPORT = new NetHttpTransport.Builder().build();
    private static final Executor DEFAULT_BACKGROUND_EXECUTOR = Executors.newCachedThreadPool();
    private static final Pattern MAX_AGE_PATTERN = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");

    /* renamed from: com.google.crypto.tink.util.KeysDownloader$Builder */
    public static class C0880Builder {

        /* renamed from: url */
        private String f4024url;
        private HttpTransport httpTransport = KeysDownloader.DEFAULT_HTTP_TRANSPORT;
        private Executor executor = KeysDownloader.DEFAULT_BACKGROUND_EXECUTOR;

        /* renamed from: build */
        public KeysDownloader m4294build() {
            if (this.f4024url != null) {
                return new KeysDownloader(this.executor, this.httpTransport, this.f4024url);
            }
            throw new IllegalArgumentException("must provide a url with {#setUrl}");
        }

        public C0880Builder setExecutor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public C0880Builder setHttpTransport(HttpTransport httpTransport) {
            this.httpTransport = httpTransport;
            return this;
        }

        /* renamed from: setUrl */
        public C0880Builder m4295setUrl(String str) {
            this.f4024url = str;
            return this;
        }
    }

    public KeysDownloader(Executor executor, HttpTransport httpTransport, String str) {
        validate(str);
        this.backgroundExecutor = executor;
        this.httpTransport = httpTransport;
        this.instanceStateLock = new Object();
        this.fetchDataLock = new Object();
        this.f4022url = str;
        this.cachedTimeInMillis = Long.MIN_VALUE;
        this.cacheExpirationDurationInMillis = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("fetchDataLock")
    public String fetchAndCacheData() throws IOException {
        long currentTimeInMillis = getCurrentTimeInMillis();
        HttpResponse httpResponseExecute = this.httpTransport.createRequestFactory().buildGetRequest(new GenericUrl(this.f4022url)).execute();
        if (httpResponseExecute.getStatusCode() != 200) {
            throw new IOException("Unexpected status code = " + httpResponseExecute.getStatusCode());
        }
        InputStream content = httpResponseExecute.getContent();
        try {
            String str = readerToString(new InputStreamReader(content, f4021UTF_8));
            content.close();
            synchronized (this.instanceStateLock) {
                this.cachedTimeInMillis = currentTimeInMillis;
                this.cacheExpirationDurationInMillis = getExpirationDurationInSeconds(httpResponseExecute.getHeaders()) * 1000;
                this.cachedData = str;
            }
            return str;
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    @GuardedBy("instanceStateLock")
    private boolean hasNonExpiredDataCached() {
        long currentTimeInMillis = getCurrentTimeInMillis();
        long j = this.cachedTimeInMillis;
        return j + this.cacheExpirationDurationInMillis > currentTimeInMillis && !((j > currentTimeInMillis ? 1 : (j == currentTimeInMillis ? 0 : -1)) > 0);
    }

    private Runnable newRefreshRunnable() {
        return new Runnable() { // from class: com.google.crypto.tink.util.KeysDownloader.1
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
            
                r5 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
            
                r5 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
            
                throw r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
            
                throw r5;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                synchronized (KeysDownloader.this.fetchDataLock) {
                    try {
                        KeysDownloader.this.fetchAndCacheData();
                        synchronized (KeysDownloader.this.instanceStateLock) {
                            if (KeysDownloader.this.pendingRefreshRunnable == this) {
                                KeysDownloader.this.pendingRefreshRunnable = null;
                            }
                        }
                    } catch (IOException unused) {
                        synchronized (KeysDownloader.this.instanceStateLock) {
                            if (KeysDownloader.this.pendingRefreshRunnable == this) {
                                KeysDownloader.this.pendingRefreshRunnable = null;
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (KeysDownloader.this.instanceStateLock) {
                            if (KeysDownloader.this.pendingRefreshRunnable == this) {
                                KeysDownloader.this.pendingRefreshRunnable = null;
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
            }
        };
    }

    private static String readerToString(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = bufferedReader.read();
            if (i == -1) {
                return sb.toString();
            }
            sb.append((char) i);
        }
    }

    @GuardedBy("instanceStateLock")
    private boolean shouldProactivelyRefreshDataInBackground() {
        return this.cachedTimeInMillis + (this.cacheExpirationDurationInMillis / 2) <= getCurrentTimeInMillis();
    }

    private static void validate(String str) {
        try {
            if (new URL(str).getProtocol().toLowerCase(Locale.US).equals("https")) {
            } else {
                throw new IllegalArgumentException("url must point to a HTTPS server");
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String download() {
        synchronized (this.instanceStateLock) {
            try {
                if (hasNonExpiredDataCached()) {
                    if (shouldProactivelyRefreshDataInBackground()) {
                        refreshInBackground();
                    }
                    return this.cachedData;
                }
                synchronized (this.fetchDataLock) {
                    synchronized (this.instanceStateLock) {
                        if (hasNonExpiredDataCached()) {
                            return this.cachedData;
                        }
                        return fetchAndCacheData();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getCurrentTimeInMillis() {
        return Instant.now().getMillis();
    }

    public long getExpirationDurationInSeconds(HttpHeaders httpHeaders) {
        long jLongValue;
        if (httpHeaders.getCacheControl() != null) {
            for (String str : httpHeaders.getCacheControl().split(",")) {
                Matcher matcher = MAX_AGE_PATTERN.matcher(str);
                if (matcher.matches()) {
                    jLongValue = Long.valueOf(matcher.group(1)).longValue();
                    break;
                }
            }
            jLongValue = 0;
        } else {
            jLongValue = 0;
        }
        if (httpHeaders.getAge() != null) {
            jLongValue -= httpHeaders.getAge().longValue();
        }
        return Math.max(0L, jLongValue);
    }

    public HttpTransport getHttpTransport() {
        return this.httpTransport;
    }

    /* renamed from: getUrl */
    public String m4293getUrl() {
        return this.f4022url;
    }

    public void refreshInBackground() {
        Runnable runnableNewRefreshRunnable = newRefreshRunnable();
        synchronized (this.instanceStateLock) {
            try {
                if (this.pendingRefreshRunnable != null) {
                    return;
                }
                this.pendingRefreshRunnable = runnableNewRefreshRunnable;
                try {
                    this.backgroundExecutor.execute(runnableNewRefreshRunnable);
                } catch (Throwable th) {
                    synchronized (this.instanceStateLock) {
                        try {
                            if (this.pendingRefreshRunnable == runnableNewRefreshRunnable) {
                                this.pendingRefreshRunnable = null;
                            }
                            throw th;
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }
}
