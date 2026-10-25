package org.bouncycastle.p281jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p249jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.StoreException;
import org.bouncycastle.p366x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.p366x509.ExtendedPKIXParameters;
import org.bouncycastle.p366x509.X509AttributeCertStoreSelector;
import org.bouncycastle.p366x509.X509AttributeCertificate;

/* loaded from: classes2.dex */
public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi {
    private Exception certPathException;

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fd  */
    /* renamed from: build */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CertPathBuilderResult m16247build(X509AttributeCertificate x509AttributeCertificate, X509Certificate x509Certificate, PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters, List list) throws NoSuchAlgorithmException, AnnotatedException, CertificateException, NoSuchProviderException {
        PKIXExtendedParameters baseParameters;
        CertPathBuilderResult certPathBuilderResultM16247build = null;
        if (list.contains(x509Certificate) || pKIXExtendedBuilderParameters.getExcludedCerts().contains(x509Certificate)) {
            return null;
        }
        if (pKIXExtendedBuilderParameters.getMaxPathLength() != -1 && list.size() - 1 > pKIXExtendedBuilderParameters.getMaxPathLength()) {
            return null;
        }
        list.add(x509Certificate);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
            CertPathValidator certPathValidator = CertPathValidator.getInstance("RFC3281", BouncyCastleProvider.PROVIDER_NAME);
            try {
                baseParameters = pKIXExtendedBuilderParameters.getBaseParameters();
            } catch (AnnotatedException e) {
                this.certPathException = new AnnotatedException("No valid certification path could be build.", e);
            }
            if (CertPathValidatorUtilities.isIssuerTrustAnchor(x509Certificate, baseParameters.getTrustAnchors(), baseParameters.getSigProvider())) {
                try {
                    CertPath certPathGenerateCertPath = certificateFactory.generateCertPath((List<? extends Certificate>) list);
                    try {
                        PKIXCertPathValidatorResult pKIXCertPathValidatorResult = (PKIXCertPathValidatorResult) certPathValidator.validate(certPathGenerateCertPath, pKIXExtendedBuilderParameters);
                        return new PKIXCertPathBuilderResult(certPathGenerateCertPath, pKIXCertPathValidatorResult.getTrustAnchor(), pKIXCertPathValidatorResult.getPolicyTree(), pKIXCertPathValidatorResult.getPublicKey());
                    } catch (Exception e2) {
                        throw new AnnotatedException("Certification path could not be validated.", e2);
                    }
                } catch (Exception e3) {
                    throw new AnnotatedException("Certification path could not be constructed from certificate list.", e3);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(baseParameters.getCertificateStores());
            try {
                arrayList.addAll(CertPathValidatorUtilities.getAdditionalStoresFromAltNames(x509Certificate.getExtensionValue(Extension.issuerAlternativeName.m14433getId()), baseParameters.getNamedCertificateStoreMap()));
                HashSet hashSet = new HashSet();
                try {
                    hashSet.addAll(CertPathValidatorUtilities.findIssuerCerts(x509Certificate, baseParameters.getCertStores(), arrayList));
                    if (hashSet.isEmpty()) {
                        throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext() && certPathBuilderResultM16247build == null) {
                        X509Certificate x509Certificate2 = (X509Certificate) it.next();
                        if (!x509Certificate2.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) {
                            certPathBuilderResultM16247build = m16247build(x509AttributeCertificate, x509Certificate2, pKIXExtendedBuilderParameters, list);
                        }
                    }
                    if (certPathBuilderResultM16247build == null) {
                        list.remove(x509Certificate);
                    }
                    return certPathBuilderResultM16247build;
                } catch (AnnotatedException e4) {
                    throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", e4);
                }
            } catch (CertificateParsingException e5) {
                throw new AnnotatedException("No additional X.509 stores can be added from certificate locations.", e5);
            }
            this.certPathException = new AnnotatedException("No valid certification path could be build.", e);
            if (certPathBuilderResultM16247build == null) {
            }
            return certPathBuilderResultM16247build;
        } catch (Exception unused) {
            throw new RuntimeException("Exception creating support classes.");
        }
    }

    public static Collection findCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof InterfaceC6249Store) {
                try {
                    hashSet.addAll(((InterfaceC6249Store) obj).getMatches(x509AttributeCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParametersM16078build;
        boolean z = certPathParameters instanceof PKIXBuilderParameters;
        if (!z && !(certPathParameters instanceof ExtendedPKIXBuilderParameters) && !(certPathParameters instanceof PKIXExtendedBuilderParameters)) {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + PKIXExtendedBuilderParameters.class.getName() + ".");
        }
        new ArrayList();
        if (z) {
            PKIXExtendedBuilderParameters.C5481Builder c5481Builder = new PKIXExtendedBuilderParameters.C5481Builder((PKIXBuilderParameters) certPathParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                c5481Builder.addExcludedCerts(extendedPKIXBuilderParameters.getExcludedCerts());
                c5481Builder.setMaxPathLength(extendedPKIXBuilderParameters.getMaxPathLength());
                extendedPKIXBuilderParameters.getStores();
            }
            pKIXExtendedBuilderParametersM16078build = c5481Builder.m16078build();
        } else {
            pKIXExtendedBuilderParametersM16078build = (PKIXExtendedBuilderParameters) certPathParameters;
        }
        new ArrayList();
        pKIXExtendedBuilderParametersM16078build.getBaseParameters().getTargetConstraints();
        throw new CertPathBuilderException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
    }
}
