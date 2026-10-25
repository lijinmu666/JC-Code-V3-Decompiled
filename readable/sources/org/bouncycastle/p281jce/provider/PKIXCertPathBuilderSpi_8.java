package org.bouncycastle.p281jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p249jcajce.PKIXCertStore;
import org.bouncycastle.p249jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.CertificateFactory;
import org.bouncycastle.p366x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.p366x509.ExtendedPKIXParameters;

/* loaded from: classes2.dex */
public class PKIXCertPathBuilderSpi_8 extends CertPathBuilderSpi {
    private Exception certPathException;

    /* renamed from: helper */
    private final JcaJceHelper f22024helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathBuilderSpi_8() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* renamed from: build */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CertPathBuilderResult m16249build(X509Certificate x509Certificate, PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters, List list) throws AnnotatedException {
        CertificateFactory certificateFactory;
        PKIXCertPathValidatorSpi_8 pKIXCertPathValidatorSpi_8;
        CertPathBuilderResult certPathBuilderResultM16249build = null;
        if (list.contains(x509Certificate) || pKIXExtendedBuilderParameters.getExcludedCerts().contains(x509Certificate)) {
            return null;
        }
        if (pKIXExtendedBuilderParameters.getMaxPathLength() != -1 && list.size() - 1 > pKIXExtendedBuilderParameters.getMaxPathLength()) {
            return null;
        }
        list.add(x509Certificate);
        try {
            try {
                certificateFactory = new CertificateFactory();
                pKIXCertPathValidatorSpi_8 = new PKIXCertPathValidatorSpi_8(this.isForCRLCheck);
            } catch (Exception unused) {
                throw new RuntimeException("Exception creating support classes.");
            }
        } catch (AnnotatedException e) {
            this.certPathException = e;
        }
        if (CertPathValidatorUtilities.isIssuerTrustAnchor(x509Certificate, pKIXExtendedBuilderParameters.getBaseParameters().getTrustAnchors(), pKIXExtendedBuilderParameters.getBaseParameters().getSigProvider())) {
            try {
                CertPath certPathEngineGenerateCertPath = certificateFactory.engineGenerateCertPath(list);
                try {
                    PKIXCertPathValidatorResult pKIXCertPathValidatorResult = (PKIXCertPathValidatorResult) pKIXCertPathValidatorSpi_8.engineValidate(certPathEngineGenerateCertPath, pKIXExtendedBuilderParameters);
                    return new PKIXCertPathBuilderResult(certPathEngineGenerateCertPath, pKIXCertPathValidatorResult.getTrustAnchor(), pKIXCertPathValidatorResult.getPolicyTree(), pKIXCertPathValidatorResult.getPublicKey());
                } catch (Exception e2) {
                    throw new AnnotatedException("Certification path could not be validated.", e2);
                }
            } catch (Exception e3) {
                throw new AnnotatedException("Certification path could not be constructed from certificate list.", e3);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(pKIXExtendedBuilderParameters.getBaseParameters().getCertificateStores());
        try {
            arrayList.addAll(CertPathValidatorUtilities.getAdditionalStoresFromAltNames(x509Certificate.getExtensionValue(Extension.issuerAlternativeName.m14433getId()), pKIXExtendedBuilderParameters.getBaseParameters().getNamedCertificateStoreMap()));
            HashSet hashSet = new HashSet();
            try {
                hashSet.addAll(CertPathValidatorUtilities.findIssuerCerts(x509Certificate, pKIXExtendedBuilderParameters.getBaseParameters().getCertStores(), arrayList));
                if (hashSet.isEmpty()) {
                    throw new AnnotatedException("No issuer certificate for certificate in certification path found.");
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext() && certPathBuilderResultM16249build == null) {
                    certPathBuilderResultM16249build = m16249build((X509Certificate) it.next(), pKIXExtendedBuilderParameters, list);
                }
                if (certPathBuilderResultM16249build == null) {
                    list.remove(x509Certificate);
                }
                return certPathBuilderResultM16249build;
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Cannot find issuer certificate for certificate in certification path.", e4);
            }
        } catch (CertificateParsingException e5) {
            throw new AnnotatedException("No additional X.509 stores can be added from certificate locations.", e5);
        }
        this.certPathException = e;
        if (certPathBuilderResultM16249build == null) {
        }
        return certPathBuilderResultM16249build;
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, AnnotatedException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParametersM16078build;
        Exception exc;
        PKIXExtendedBuilderParameters.C5481Builder c5481Builder;
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXBuilderParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                Iterator it = extendedPKIXBuilderParameters.getAdditionalStores().iterator();
                while (it.hasNext()) {
                    c5483Builder.addCertificateStore((PKIXCertStore) it.next());
                }
                c5481Builder = new PKIXExtendedBuilderParameters.C5481Builder(c5483Builder.m16080build());
                c5481Builder.addExcludedCerts(extendedPKIXBuilderParameters.getExcludedCerts());
                c5481Builder.setMaxPathLength(extendedPKIXBuilderParameters.getMaxPathLength());
            } else {
                c5481Builder = new PKIXExtendedBuilderParameters.C5481Builder(pKIXBuilderParameters);
            }
            pKIXExtendedBuilderParametersM16078build = c5481Builder.m16078build();
        } else {
            if (!(certPathParameters instanceof PKIXExtendedBuilderParameters)) {
                throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + PKIXExtendedBuilderParameters.class.getName() + ".");
            }
            pKIXExtendedBuilderParametersM16078build = (PKIXExtendedBuilderParameters) certPathParameters;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = CertPathValidatorUtilities.findTargets(pKIXExtendedBuilderParametersM16078build).iterator();
        CertPathBuilderResult certPathBuilderResultM16249build = null;
        while (it2.hasNext() && certPathBuilderResultM16249build == null) {
            certPathBuilderResultM16249build = m16249build((X509Certificate) it2.next(), pKIXExtendedBuilderParametersM16078build, arrayList);
        }
        if (certPathBuilderResultM16249build == null && (exc = this.certPathException) != null) {
            if (exc instanceof AnnotatedException) {
                throw new CertPathBuilderException(this.certPathException.getMessage(), this.certPathException.getCause());
            }
            throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
        }
        if (certPathBuilderResultM16249build == null && this.certPathException == null) {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        }
        return certPathBuilderResultM16249build;
    }

    public PKIXCertPathBuilderSpi_8(boolean z) {
        this.f22024helper = new BCJcaJceHelper();
        this.isForCRLCheck = z;
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new ProvRevocationChecker(this.f22024helper);
    }
}
