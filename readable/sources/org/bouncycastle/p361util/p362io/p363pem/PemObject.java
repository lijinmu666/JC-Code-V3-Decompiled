package org.bouncycastle.p361util.p362io.p363pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class PemObject implements PemObjectGenerator {
    private static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());

    /* renamed from: content */
    private byte[] f24252content;

    /* renamed from: headers */
    private List f24253headers;

    /* renamed from: type */
    private String f24254type;

    public PemObject(String str, List list, byte[] bArr) {
        this.f24254type = str;
        this.f24253headers = Collections.unmodifiableList(list);
        this.f24252content = bArr;
    }

    @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator
    public PemObject generate() {
        return this;
    }

    public byte[] getContent() {
        return this.f24252content;
    }

    public List getHeaders() {
        return this.f24253headers;
    }

    /* renamed from: getType */
    public String m18367getType() {
        return this.f24254type;
    }

    public PemObject(String str, byte[] bArr) {
        this(str, EMPTY_LIST, bArr);
    }
}
