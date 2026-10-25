package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class OriginatorInfoGenerator {
    private final List origCRLs;
    private final List origCerts;

    public OriginatorInfoGenerator(X509CertificateHolder x509CertificateHolder) {
        ArrayList arrayList = new ArrayList(1);
        this.origCerts = arrayList;
        this.origCRLs = null;
        arrayList.add(x509CertificateHolder.toASN1Structure());
    }

    public OriginatorInformation generate() {
        List list = this.origCerts;
        AbstractC5093ASN1Set abstractC5093ASN1SetCreateDerSetFromList = list == null ? null : CMSUtils.createDerSetFromList(list);
        List list2 = this.origCRLs;
        return new OriginatorInformation(new OriginatorInfo(abstractC5093ASN1SetCreateDerSetFromList, list2 != null ? CMSUtils.createDerSetFromList(list2) : null));
    }

    public OriginatorInfoGenerator(InterfaceC6249Store interfaceC6249Store) {
        this(interfaceC6249Store, null);
    }

    public OriginatorInfoGenerator(InterfaceC6249Store interfaceC6249Store, InterfaceC6249Store interfaceC6249Store2) {
        if (interfaceC6249Store != null) {
            this.origCerts = CMSUtils.getCertificatesFromStore(interfaceC6249Store);
        } else {
            this.origCerts = null;
        }
        if (interfaceC6249Store2 != null) {
            this.origCRLs = CMSUtils.getCRLsFromStore(interfaceC6249Store2);
        } else {
            this.origCRLs = null;
        }
    }
}
