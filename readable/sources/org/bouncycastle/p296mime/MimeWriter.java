package org.bouncycastle.p296mime;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class MimeWriter {

    /* renamed from: headers */
    protected final C5880Headers f22508headers;

    public MimeWriter(C5880Headers c5880Headers) {
        this.f22508headers = c5880Headers;
    }

    public static List<String> mapToLines(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            arrayList.add(str + ": " + map.get(str));
        }
        return arrayList;
    }

    public abstract OutputStream getContentStream();

    public C5880Headers getHeaders() {
        return this.f22508headers;
    }
}
