package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.OERInputStream;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.Opaque */
/* loaded from: classes2.dex */
public class C5929Opaque extends ASN1Object {

    /* renamed from: content */
    private final byte[] f22655content;

    private C5929Opaque(ASN1OctetString aSN1OctetString) {
        this(aSN1OctetString.getOctets());
    }

    public static C5929Opaque getInstance(Object obj) {
        if (obj instanceof C5929Opaque) {
            return (C5929Opaque) obj;
        }
        if (obj != null) {
            return new C5929Opaque(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public static <T> T getValue(final Class<T> cls, final C5887Element c5887Element, C5929Opaque c5929Opaque) {
        return (T) AccessController.doPrivileged(new PrivilegedAction<T>() { // from class: org.bouncycastle.oer.its.ieee1609dot2.Opaque.1
            @Override // java.security.PrivilegedAction
            public T run() throws NoSuchMethodException, SecurityException {
                try {
                    return (T) cls.cast(cls.getMethod("getInstance", Object.class).invoke(null, OERInputStream.m17155parse(C5929Opaque.this.f22655content, c5887Element)));
                } catch (Exception e) {
                    throw new IllegalStateException("could not invoke getInstance on type " + e.getMessage(), e);
                }
            }
        });
    }

    public byte[] getContent() {
        return this.f22655content;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f22655content);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.f22655content);
    }

    public C5929Opaque(byte[] bArr) {
        this.f22655content = C6238Arrays.m18231clone(bArr);
    }
}
