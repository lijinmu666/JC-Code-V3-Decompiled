package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
class LazyConstructionEnumeration implements Enumeration {

    /* renamed from: aIn */
    private ASN1InputStream f18003aIn;

    /* renamed from: nextObj */
    private Object f18004nextObj = readObject();

    public LazyConstructionEnumeration(byte[] bArr) {
        this.f18003aIn = new ASN1InputStream(bArr, true);
    }

    private Object readObject() {
        try {
            return this.f18003aIn.readObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("malformed ASN.1: " + e, e);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f18004nextObj != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f18004nextObj;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f18004nextObj = readObject();
        return obj;
    }
}
