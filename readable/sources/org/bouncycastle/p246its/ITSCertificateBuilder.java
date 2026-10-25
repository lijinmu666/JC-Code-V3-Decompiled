package org.bouncycastle.p246its;

import org.bouncycastle.p300oer.p301its.ieee1609dot2.PsidGroupPermissions;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SequenceOfPsidGroupPermissions;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5955PsidSsp;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.CrlSeries;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId3;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfPsidSsp;

/* loaded from: classes2.dex */
public class ITSCertificateBuilder {

    /* renamed from: cracaId */
    protected HashedId3 f21290cracaId;
    protected CrlSeries crlSeries;

    /* renamed from: issuer */
    protected final ITSCertificate f21291issuer;
    protected final ToBeSignedCertificate.C5938Builder tbsCertificateBuilder;

    /* renamed from: version */
    protected C5976UINT8 f21292version;

    public ITSCertificateBuilder(ITSCertificate iTSCertificate, ToBeSignedCertificate.C5938Builder c5938Builder) {
        this.f21292version = new C5976UINT8(3);
        this.f21290cracaId = new HashedId3(new byte[3]);
        this.crlSeries = new CrlSeries(0);
        this.f21291issuer = iTSCertificate;
        this.tbsCertificateBuilder = c5938Builder;
        c5938Builder.setCracaId(this.f21290cracaId);
        c5938Builder.setCrlSeries(this.crlSeries);
    }

    public ITSCertificate getIssuer() {
        return this.f21291issuer;
    }

    public ITSCertificateBuilder setAppPermissions(C5955PsidSsp... c5955PsidSspArr) {
        SequenceOfPsidSsp.C5964Builder c5964BuilderM17329builder = SequenceOfPsidSsp.m17329builder();
        for (int i = 0; i != c5955PsidSspArr.length; i++) {
            c5964BuilderM17329builder.m17330setItem(c5955PsidSspArr[i]);
        }
        this.tbsCertificateBuilder.setAppPermissions(c5964BuilderM17329builder.createSequenceOfPsidSsp());
        return this;
    }

    public ITSCertificateBuilder setCertIssuePermissions(PsidGroupPermissions... psidGroupPermissionsArr) {
        this.tbsCertificateBuilder.setCertIssuePermissions(SequenceOfPsidGroupPermissions.m17240builder().addGroupPermission(psidGroupPermissionsArr).createSequenceOfPsidGroupPermissions());
        return this;
    }

    public ITSCertificateBuilder setCracaId(byte[] bArr) {
        HashedId3 hashedId3 = new HashedId3(bArr);
        this.f21290cracaId = hashedId3;
        this.tbsCertificateBuilder.setCracaId(hashedId3);
        return this;
    }

    public ITSCertificateBuilder setCrlSeries(int i) {
        CrlSeries crlSeries = new CrlSeries(i);
        this.crlSeries = crlSeries;
        this.tbsCertificateBuilder.setCrlSeries(crlSeries);
        return this;
    }

    public ITSCertificateBuilder setValidityPeriod(ITSValidityPeriod iTSValidityPeriod) {
        this.tbsCertificateBuilder.setValidityPeriod(iTSValidityPeriod.toASN1Structure());
        return this;
    }

    public ITSCertificateBuilder setVersion(int i) {
        this.f21292version = new C5976UINT8(i);
        return this;
    }

    public ITSCertificateBuilder(ToBeSignedCertificate.C5938Builder c5938Builder) {
        this(null, c5938Builder);
    }
}
