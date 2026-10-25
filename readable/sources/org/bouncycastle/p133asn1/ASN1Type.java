package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
abstract class ASN1Type {
    final Class javaClass;

    public ASN1Type(Class cls) {
        this.javaClass = cls;
    }

    /* renamed from: equals */
    public final boolean m14458equals(Object obj) {
        return this == obj;
    }

    public final Class getJavaClass() {
        return this.javaClass;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
