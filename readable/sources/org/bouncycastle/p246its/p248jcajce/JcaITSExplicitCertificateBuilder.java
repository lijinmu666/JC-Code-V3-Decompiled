package org.bouncycastle.p246its.p248jcajce;

import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.ITSExplicitCertificateBuilder;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;

/* loaded from: classes2.dex */
public class JcaITSExplicitCertificateBuilder extends ITSExplicitCertificateBuilder {

    /* renamed from: helper */
    private JcaJceHelper f21321helper;

    public JcaITSExplicitCertificateBuilder(ITSContentSigner iTSContentSigner, ToBeSignedCertificate.C5938Builder c5938Builder) {
        this(iTSContentSigner, c5938Builder, new DefaultJcaJceHelper());
    }

    /* renamed from: build */
    public ITSCertificate m16028build(CertificateId certificateId, ECPublicKey eCPublicKey) {
        return m16029build(certificateId, eCPublicKey, (ECPublicKey) null);
    }

    public JcaITSExplicitCertificateBuilder setProvider(String str) {
        this.f21321helper = new NamedJcaJceHelper(str);
        return this;
    }

    private JcaITSExplicitCertificateBuilder(ITSContentSigner iTSContentSigner, ToBeSignedCertificate.C5938Builder c5938Builder, JcaJceHelper jcaJceHelper) {
        super(iTSContentSigner, c5938Builder);
        this.f21321helper = jcaJceHelper;
    }

    /* renamed from: build */
    public ITSCertificate m16029build(CertificateId certificateId, ECPublicKey eCPublicKey, ECPublicKey eCPublicKey2) {
        return super.m16004build(certificateId, new JcaITSPublicVerificationKey(eCPublicKey, this.f21321helper), eCPublicKey2 != null ? new JceITSPublicEncryptionKey(eCPublicKey2, this.f21321helper) : null);
    }

    public JcaITSExplicitCertificateBuilder setProvider(Provider provider) {
        this.f21321helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
