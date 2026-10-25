package org.bouncycastle.p133asn1.p171util;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.conscrypt.BuildConfig;

/* renamed from: org.bouncycastle.asn1.util.DERDump */
/* loaded from: classes2.dex */
public class C5187DERDump extends ASN1Dump {
    public static String dumpAsString(ASN1Encodable aSN1Encodable) {
        return dumpAsString(aSN1Encodable.toASN1Primitive());
    }

    public static String dumpAsString(ASN1Primitive aSN1Primitive) {
        StringBuilder sb = new StringBuilder();
        ASN1Dump._dumpAsString(BuildConfig.f24315FLAVOR, false, aSN1Primitive, sb);
        return sb.toString();
    }
}
