package org.bouncycastle.p249jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p249jcajce.PKIXCertStoreSelector;

/* loaded from: classes2.dex */
public class PKIXExtendedParameters implements CertPathParameters {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    private final PKIXParameters baseParameters;

    /* renamed from: date */
    private final Date f21369date;
    private final List<PKIXCRLStore> extraCRLStores;
    private final List<PKIXCertStore> extraCertStores;
    private final Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
    private final Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
    private final boolean revocationEnabled;
    private final PKIXCertStoreSelector targetConstraints;
    private final Set<TrustAnchor> trustAnchors;
    private final boolean useDeltas;
    private final Date validityDate;
    private final int validityModel;

    /* renamed from: org.bouncycastle.jcajce.PKIXExtendedParameters$Builder */
    public static class C5483Builder {
        private final PKIXParameters baseParameters;

        /* renamed from: date */
        private final Date f21370date;
        private List<PKIXCRLStore> extraCRLStores;
        private List<PKIXCertStore> extraCertStores;
        private Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
        private Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
        private boolean revocationEnabled;
        private PKIXCertStoreSelector targetConstraints;
        private Set<TrustAnchor> trustAnchors;
        private boolean useDeltas;
        private final Date validityDate;
        private int validityModel;

        public C5483Builder(PKIXParameters pKIXParameters) {
            this.extraCertStores = new ArrayList();
            this.namedCertificateStoreMap = new HashMap();
            this.extraCRLStores = new ArrayList();
            this.namedCRLStoreMap = new HashMap();
            this.validityModel = 0;
            this.useDeltas = false;
            this.baseParameters = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.targetConstraints = new PKIXCertStoreSelector.C5479Builder(targetCertConstraints).m16077build();
            }
            Date date = pKIXParameters.getDate();
            this.validityDate = date;
            this.f21370date = date == null ? new Date() : date;
            this.revocationEnabled = pKIXParameters.isRevocationEnabled();
            this.trustAnchors = pKIXParameters.getTrustAnchors();
        }

        public C5483Builder addCRLStore(PKIXCRLStore pKIXCRLStore) {
            this.extraCRLStores.add(pKIXCRLStore);
            return this;
        }

        public C5483Builder addCertificateStore(PKIXCertStore pKIXCertStore) {
            this.extraCertStores.add(pKIXCertStore);
            return this;
        }

        public C5483Builder addNamedCRLStore(GeneralName generalName, PKIXCRLStore pKIXCRLStore) {
            this.namedCRLStoreMap.put(generalName, pKIXCRLStore);
            return this;
        }

        public C5483Builder addNamedCertificateStore(GeneralName generalName, PKIXCertStore pKIXCertStore) {
            this.namedCertificateStoreMap.put(generalName, pKIXCertStore);
            return this;
        }

        /* renamed from: build */
        public PKIXExtendedParameters m16080build() {
            return new PKIXExtendedParameters(this);
        }

        public void setRevocationEnabled(boolean z) {
            this.revocationEnabled = z;
        }

        public C5483Builder setTargetConstraints(PKIXCertStoreSelector pKIXCertStoreSelector) {
            this.targetConstraints = pKIXCertStoreSelector;
            return this;
        }

        public C5483Builder setTrustAnchor(TrustAnchor trustAnchor) {
            this.trustAnchors = Collections.singleton(trustAnchor);
            return this;
        }

        public C5483Builder setTrustAnchors(Set<TrustAnchor> set) {
            this.trustAnchors = set;
            return this;
        }

        public C5483Builder setUseDeltasEnabled(boolean z) {
            this.useDeltas = z;
            return this;
        }

        public C5483Builder setValidityModel(int i) {
            this.validityModel = i;
            return this;
        }

        public C5483Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.extraCertStores = new ArrayList();
            this.namedCertificateStoreMap = new HashMap();
            this.extraCRLStores = new ArrayList();
            this.namedCRLStoreMap = new HashMap();
            this.validityModel = 0;
            this.useDeltas = false;
            this.baseParameters = pKIXExtendedParameters.baseParameters;
            this.validityDate = pKIXExtendedParameters.validityDate;
            this.f21370date = pKIXExtendedParameters.f21369date;
            this.targetConstraints = pKIXExtendedParameters.targetConstraints;
            this.extraCertStores = new ArrayList(pKIXExtendedParameters.extraCertStores);
            this.namedCertificateStoreMap = new HashMap(pKIXExtendedParameters.namedCertificateStoreMap);
            this.extraCRLStores = new ArrayList(pKIXExtendedParameters.extraCRLStores);
            this.namedCRLStoreMap = new HashMap(pKIXExtendedParameters.namedCRLStoreMap);
            this.useDeltas = pKIXExtendedParameters.useDeltas;
            this.validityModel = pKIXExtendedParameters.validityModel;
            this.revocationEnabled = pKIXExtendedParameters.isRevocationEnabled();
            this.trustAnchors = pKIXExtendedParameters.getTrustAnchors();
        }
    }

    private PKIXExtendedParameters(C5483Builder c5483Builder) {
        this.baseParameters = c5483Builder.baseParameters;
        this.validityDate = c5483Builder.validityDate;
        this.f21369date = c5483Builder.f21370date;
        this.extraCertStores = Collections.unmodifiableList(c5483Builder.extraCertStores);
        this.namedCertificateStoreMap = Collections.unmodifiableMap(new HashMap(c5483Builder.namedCertificateStoreMap));
        this.extraCRLStores = Collections.unmodifiableList(c5483Builder.extraCRLStores);
        this.namedCRLStoreMap = Collections.unmodifiableMap(new HashMap(c5483Builder.namedCRLStoreMap));
        this.targetConstraints = c5483Builder.targetConstraints;
        this.revocationEnabled = c5483Builder.revocationEnabled;
        this.useDeltas = c5483Builder.useDeltas;
        this.validityModel = c5483Builder.validityModel;
        this.trustAnchors = Collections.unmodifiableSet(c5483Builder.trustAnchors);
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }

    public List<PKIXCRLStore> getCRLStores() {
        return this.extraCRLStores;
    }

    public List getCertPathCheckers() {
        return this.baseParameters.getCertPathCheckers();
    }

    public List<CertStore> getCertStores() {
        return this.baseParameters.getCertStores();
    }

    public List<PKIXCertStore> getCertificateStores() {
        return this.extraCertStores;
    }

    /* renamed from: getDate */
    public Date m16079getDate() {
        return new Date(this.f21369date.getTime());
    }

    public Set getInitialPolicies() {
        return this.baseParameters.getInitialPolicies();
    }

    public Map<GeneralName, PKIXCRLStore> getNamedCRLStoreMap() {
        return this.namedCRLStoreMap;
    }

    public Map<GeneralName, PKIXCertStore> getNamedCertificateStoreMap() {
        return this.namedCertificateStoreMap;
    }

    public boolean getPolicyQualifiersRejected() {
        return this.baseParameters.getPolicyQualifiersRejected();
    }

    public String getSigProvider() {
        return this.baseParameters.getSigProvider();
    }

    public PKIXCertStoreSelector getTargetConstraints() {
        return this.targetConstraints;
    }

    public Set getTrustAnchors() {
        return this.trustAnchors;
    }

    public Date getValidityDate() {
        if (this.validityDate == null) {
            return null;
        }
        return new Date(this.validityDate.getTime());
    }

    public int getValidityModel() {
        return this.validityModel;
    }

    public boolean isAnyPolicyInhibited() {
        return this.baseParameters.isAnyPolicyInhibited();
    }

    public boolean isExplicitPolicyRequired() {
        return this.baseParameters.isExplicitPolicyRequired();
    }

    public boolean isPolicyMappingInhibited() {
        return this.baseParameters.isPolicyMappingInhibited();
    }

    public boolean isRevocationEnabled() {
        return this.revocationEnabled;
    }

    public boolean isUseDeltasEnabled() {
        return this.useDeltas;
    }
}
