package org.bouncycastle.p133asn1.p174x509.qualified;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes2.dex */
public interface RFC3739QCObjectIdentifiers {

    /* renamed from: id_qcs */
    public static final ASN1ObjectIdentifier f18750id_qcs;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v1;
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v2;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = X509ObjectIdentifiers.f18746id_pkix.m14432branch("11");
        f18750id_qcs = aSN1ObjectIdentifierM14432branch;
        id_qcs_pkixQCSyntax_v1 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_qcs_pkixQCSyntax_v2 = aSN1ObjectIdentifierM14432branch.m14432branch("2");
    }
}
