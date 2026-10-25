package org.bouncycastle.p133asn1;

/* renamed from: org.bouncycastle.asn1.ASN1Tag */
/* loaded from: classes.dex */
final class C5095ASN1Tag {
    private final int tagClass;
    private final int tagNumber;

    private C5095ASN1Tag(int i, int i2) {
        this.tagClass = i;
        this.tagNumber = i2;
    }

    /* renamed from: create */
    public static C5095ASN1Tag m14456create(int i, int i2) {
        return new C5095ASN1Tag(i, i2);
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNumber() {
        return this.tagNumber;
    }
}
