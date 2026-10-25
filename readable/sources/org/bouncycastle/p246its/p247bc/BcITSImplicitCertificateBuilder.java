package org.bouncycastle.p246its.p247bc;

import org.bouncycastle.operator.p305bc.BcDigestCalculatorProvider;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.ITSImplicitCertificateBuilder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;

/* loaded from: classes2.dex */
public class BcITSImplicitCertificateBuilder extends ITSImplicitCertificateBuilder {
    public BcITSImplicitCertificateBuilder(ITSCertificate iTSCertificate, ToBeSignedCertificate.C5938Builder c5938Builder) {
        super(iTSCertificate, new BcDigestCalculatorProvider(), c5938Builder);
    }
}
