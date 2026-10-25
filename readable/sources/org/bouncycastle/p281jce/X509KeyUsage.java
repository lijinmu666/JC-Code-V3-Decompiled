package org.bouncycastle.p281jce;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p174x509.KeyUsage;

/* loaded from: classes2.dex */
public class X509KeyUsage extends ASN1Object {

    /* renamed from: cRLSign */
    public static final int f21959cRLSign = 2;
    public static final int dataEncipherment = 16;
    public static final int decipherOnly = 32768;
    public static final int digitalSignature = 128;
    public static final int encipherOnly = 1;
    public static final int keyAgreement = 8;
    public static final int keyCertSign = 4;
    public static final int keyEncipherment = 32;
    public static final int nonRepudiation = 64;

    /* renamed from: usage */
    private int f21960usage;

    public X509KeyUsage(int i) {
        this.f21960usage = i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new KeyUsage(this.f21960usage).toASN1Primitive();
    }
}
