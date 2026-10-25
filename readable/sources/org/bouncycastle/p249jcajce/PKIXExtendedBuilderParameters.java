package org.bouncycastle.p249jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;

/* loaded from: classes2.dex */
public class PKIXExtendedBuilderParameters implements CertPathParameters {
    private final PKIXExtendedParameters baseParameters;
    private final Set<X509Certificate> excludedCerts;
    private final int maxPathLength;

    /* renamed from: org.bouncycastle.jcajce.PKIXExtendedBuilderParameters$Builder */
    public static class C5481Builder {
        private final PKIXExtendedParameters baseParameters;
        private Set<X509Certificate> excludedCerts;
        private int maxPathLength;

        public C5481Builder(PKIXBuilderParameters pKIXBuilderParameters) {
            this.maxPathLength = 5;
            this.excludedCerts = new HashSet();
            this.baseParameters = new PKIXExtendedParameters.C5483Builder(pKIXBuilderParameters).m16080build();
            this.maxPathLength = pKIXBuilderParameters.getMaxPathLength();
        }

        public C5481Builder addExcludedCerts(Set<X509Certificate> set) {
            this.excludedCerts.addAll(set);
            return this;
        }

        /* renamed from: build */
        public PKIXExtendedBuilderParameters m16078build() {
            return new PKIXExtendedBuilderParameters(this);
        }

        public C5481Builder setMaxPathLength(int i) {
            if (i < -1) {
                throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
            }
            this.maxPathLength = i;
            return this;
        }

        public C5481Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.maxPathLength = 5;
            this.excludedCerts = new HashSet();
            this.baseParameters = pKIXExtendedParameters;
        }
    }

    private PKIXExtendedBuilderParameters(C5481Builder c5481Builder) {
        this.baseParameters = c5481Builder.baseParameters;
        this.excludedCerts = Collections.unmodifiableSet(c5481Builder.excludedCerts);
        this.maxPathLength = c5481Builder.maxPathLength;
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }

    public PKIXExtendedParameters getBaseParameters() {
        return this.baseParameters;
    }

    public Set getExcludedCerts() {
        return this.excludedCerts;
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }
}
