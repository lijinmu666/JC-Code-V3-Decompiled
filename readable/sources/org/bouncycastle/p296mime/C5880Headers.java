package org.bouncycastle.p296mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Iterable;
import org.conscrypt.BuildConfig;

/* renamed from: org.bouncycastle.mime.Headers */
/* loaded from: classes2.dex */
public class C5880Headers implements Iterable<String> {
    private String boundary;
    private final String contentTransferEncoding;
    private String contentType;
    private Map<String, String> contentTypeParameters;

    /* renamed from: headers */
    private final Map<String, List> f22502headers;
    private final List<String> headersAsPresented;
    private boolean multipart;

    /* renamed from: org.bouncycastle.mime.Headers$KV */
    public static class KV {

        /* renamed from: key */
        public final String f22503key;

        /* renamed from: value */
        public final String f22504value;

        public KV(String str, String str2) {
            this.f22503key = str;
            this.f22504value = str2;
        }

        public KV(KV kv) {
            this.f22503key = kv.f22503key;
            this.f22504value = kv.f22504value;
        }
    }

    public C5880Headers(InputStream inputStream, String str) {
        this(parseHeaders(inputStream), str);
    }

    private Map<String, String> createContentTypeParameters(String str) {
        String[] strArrSplit = str.split(";");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i != strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("malformed Content-Type header");
            }
            linkedHashMap.put(str2.substring(0, iIndexOf).trim(), str2.substring(iIndexOf + 1).trim());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static List<String> parseHeaders(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(inputStream);
        while (true) {
            String line = lineReader.readLine();
            if (line == null || line.length() == 0) {
                break;
            }
            arrayList.add(line);
        }
        return arrayList;
    }

    /* renamed from: put */
    private void m17111put(String str, String str2) {
        synchronized (this) {
            try {
                KV kv = new KV(str, str2);
                List arrayList = this.f22502headers.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f22502headers.put(str, arrayList);
                }
                arrayList.add(kv);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean containsKey(String str) {
        return this.f22502headers.containsKey(str);
    }

    public void dumpHeaders(OutputStream outputStream) throws IOException {
        Iterator<String> it = this.headersAsPresented.iterator();
        while (it.hasNext()) {
            outputStream.write(C6250Strings.toUTF8ByteArray(it.next().toString()));
            outputStream.write(13);
            outputStream.write(10);
        }
    }

    public String getBoundary() {
        return this.boundary;
    }

    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Map<String, String> getContentTypeAttributes() {
        return this.contentTypeParameters;
    }

    public Iterator<String> getNames() {
        return this.f22502headers.keySet().iterator();
    }

    public String[] getValues(String str) {
        synchronized (this) {
            try {
                List list = this.f22502headers.get(str);
                if (list == null) {
                    return null;
                }
                String[] strArr = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    strArr[i] = ((KV) list.get(i)).f22504value;
                }
                return strArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: isEmpty */
    public boolean m17112isEmpty() {
        boolean zIsEmpty;
        synchronized (this) {
            zIsEmpty = this.f22502headers.isEmpty();
        }
        return zIsEmpty;
    }

    public boolean isMultipart() {
        return this.multipart;
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f22502headers.keySet().iterator();
    }

    public C5880Headers(String str, String str2) {
        this.f22502headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        ArrayList arrayList = new ArrayList();
        this.headersAsPresented = arrayList;
        arrayList.add("Content-Type: " + str);
        m17111put("Content-Type", str);
        String str3 = getValues("Content-Type") == null ? "text/plain" : getValues("Content-Type")[0];
        int iIndexOf = str3.indexOf(59);
        if (iIndexOf < 0) {
            this.contentTypeParameters = Collections.EMPTY_MAP;
        } else {
            String strSubstring = str3.substring(0, iIndexOf);
            this.contentTypeParameters = createContentTypeParameters(str3.substring(iIndexOf + 1).trim());
            str3 = strSubstring;
        }
        this.contentTransferEncoding = getValues("Content-Transfer-Encoding") != null ? getValues("Content-Transfer-Encoding")[0] : str2;
        if (str3.indexOf("multipart") < 0) {
            this.boundary = null;
            this.multipart = false;
            return;
        }
        this.multipart = true;
        String strSubstring2 = this.contentTypeParameters.get("boundary");
        if (strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
        }
        this.boundary = strSubstring2;
    }

    public C5880Headers(List<String> list, String str) {
        Map<String, String> mapCreateContentTypeParameters;
        this.f22502headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.headersAsPresented = list;
        String str2 = BuildConfig.f24315FLAVOR;
        for (String str3 : list) {
            if (str3.startsWith(" ") || str3.startsWith("\t")) {
                str2 = str2 + str3.trim();
            } else {
                if (str2.length() != 0) {
                    m17111put(str2.substring(0, str2.indexOf(58)).trim(), str2.substring(str2.indexOf(58) + 1).trim());
                }
                str2 = str3;
            }
        }
        if (str2.trim().length() != 0) {
            m17111put(str2.substring(0, str2.indexOf(58)).trim(), str2.substring(str2.indexOf(58) + 1).trim());
        }
        String str4 = getValues("Content-Type") == null ? "text/plain" : getValues("Content-Type")[0];
        int iIndexOf = str4.indexOf(59);
        if (iIndexOf < 0) {
            this.contentType = str4;
            mapCreateContentTypeParameters = Collections.EMPTY_MAP;
        } else {
            this.contentType = str4.substring(0, iIndexOf);
            mapCreateContentTypeParameters = createContentTypeParameters(str4.substring(iIndexOf + 1).trim());
        }
        this.contentTypeParameters = mapCreateContentTypeParameters;
        this.contentTransferEncoding = getValues("Content-Transfer-Encoding") != null ? getValues("Content-Transfer-Encoding")[0] : str;
        if (this.contentType.indexOf("multipart") < 0) {
            this.boundary = null;
            this.multipart = false;
        } else {
            this.multipart = true;
            String str5 = this.contentTypeParameters.get("boundary");
            this.boundary = str5.substring(1, str5.length() - 1);
        }
    }
}
