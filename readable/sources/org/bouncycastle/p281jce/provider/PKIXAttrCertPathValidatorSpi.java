package org.bouncycastle.p281jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.util.Date;
import java.util.HashSet;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p366x509.ExtendedPKIXParameters;
import org.bouncycastle.p366x509.X509AttributeCertStoreSelector;

/* loaded from: classes2.dex */
public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {

    /* renamed from: helper */
    private final JcaJceHelper f22023helper = new BCJcaJceHelper();

    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParametersM16080build;
        if (!(certPathParameters instanceof ExtendedPKIXParameters) && !(certPathParameters instanceof PKIXExtendedParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + ExtendedPKIXParameters.class.getName() + " instance.");
        }
        new HashSet();
        new HashSet();
        new HashSet();
        new HashSet();
        if (certPathParameters instanceof PKIXParameters) {
            PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder((PKIXParameters) certPathParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                c5483Builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                c5483Builder.setValidityModel(extendedPKIXParameters.getValidityModel());
                extendedPKIXParameters.getAttrCertCheckers();
                extendedPKIXParameters.getProhibitedACAttributes();
                extendedPKIXParameters.getNecessaryACAttributes();
            }
            pKIXExtendedParametersM16080build = c5483Builder.m16080build();
        } else {
            pKIXExtendedParametersM16080build = (PKIXExtendedParameters) certPathParameters;
        }
        CertPathValidatorUtilities.getValidityDate(pKIXExtendedParametersM16080build, new Date());
        pKIXExtendedParametersM16080build.getTargetConstraints();
        throw new InvalidAlgorithmParameterException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
    }
}
