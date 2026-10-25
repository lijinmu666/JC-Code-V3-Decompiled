package org.bouncycastle.p222dvcs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.CertEtcToken;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.p133asn1.p142dvcs.DVCSTime;
import org.bouncycastle.p133asn1.p142dvcs.ServiceType;
import org.bouncycastle.p133asn1.p142dvcs.TargetEtcChain;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class VPKCRequestBuilder extends DVCSRequestBuilder {

    /* renamed from: chains */
    private List f21148chains;

    public VPKCRequestBuilder() {
        super(new DVCSRequestInformationBuilder(ServiceType.f18321VPKC));
        this.f21148chains = new ArrayList();
    }

    public void addTargetChain(Extension extension) {
        this.f21148chains.add(new TargetEtcChain(new CertEtcToken(extension)));
    }

    /* renamed from: build */
    public DVCSRequest m15945build() {
        List list = this.f21148chains;
        return createDVCRequest(new C5124Data((TargetEtcChain[]) list.toArray(new TargetEtcChain[list.size()])));
    }

    public void setRequestTime(Date date) {
        this.requestInformationBuilder.setRequestTime(new DVCSTime(date));
    }

    public void addTargetChain(X509CertificateHolder x509CertificateHolder) {
        this.f21148chains.add(new TargetEtcChain(new CertEtcToken(0, x509CertificateHolder.toASN1Structure())));
    }

    public void addTargetChain(TargetChain targetChain) {
        this.f21148chains.add(targetChain.toASN1Structure());
    }
}
