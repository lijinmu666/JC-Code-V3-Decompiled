package org.bouncycastle.p281jce;

import java.security.cert.CertStoreParameters;
import java.security.cert.LDAPCertStoreParameters;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class X509LDAPCertStoreParameters implements X509StoreParameters, CertStoreParameters {
    private String aACertificateAttribute;
    private String aACertificateSubjectAttributeName;
    private String attributeAuthorityRevocationListAttribute;
    private String attributeAuthorityRevocationListIssuerAttributeName;
    private String attributeCertificateAttributeAttribute;
    private String attributeCertificateAttributeSubjectAttributeName;
    private String attributeCertificateRevocationListAttribute;
    private String attributeCertificateRevocationListIssuerAttributeName;
    private String attributeDescriptorCertificateAttribute;
    private String attributeDescriptorCertificateSubjectAttributeName;
    private String authorityRevocationListAttribute;
    private String authorityRevocationListIssuerAttributeName;

    /* renamed from: baseDN */
    private String f21961baseDN;
    private String cACertificateAttribute;
    private String cACertificateSubjectAttributeName;
    private String certificateRevocationListAttribute;
    private String certificateRevocationListIssuerAttributeName;
    private String crossCertificateAttribute;
    private String crossCertificateSubjectAttributeName;
    private String deltaRevocationListAttribute;
    private String deltaRevocationListIssuerAttributeName;
    private String ldapAACertificateAttributeName;
    private String ldapAttributeAuthorityRevocationListAttributeName;
    private String ldapAttributeCertificateAttributeAttributeName;
    private String ldapAttributeCertificateRevocationListAttributeName;
    private String ldapAttributeDescriptorCertificateAttributeName;
    private String ldapAuthorityRevocationListAttributeName;
    private String ldapCACertificateAttributeName;
    private String ldapCertificateRevocationListAttributeName;
    private String ldapCrossCertificateAttributeName;
    private String ldapDeltaRevocationListAttributeName;

    /* renamed from: ldapURL */
    private String f21962ldapURL;
    private String ldapUserCertificateAttributeName;
    private String searchForSerialNumberIn;
    private String userCertificateAttribute;
    private String userCertificateSubjectAttributeName;

    /* renamed from: org.bouncycastle.jce.X509LDAPCertStoreParameters$Builder */
    public static class C5808Builder {
        private String aACertificateAttribute;
        private String aACertificateSubjectAttributeName;
        private String attributeAuthorityRevocationListAttribute;
        private String attributeAuthorityRevocationListIssuerAttributeName;
        private String attributeCertificateAttributeAttribute;
        private String attributeCertificateAttributeSubjectAttributeName;
        private String attributeCertificateRevocationListAttribute;
        private String attributeCertificateRevocationListIssuerAttributeName;
        private String attributeDescriptorCertificateAttribute;
        private String attributeDescriptorCertificateSubjectAttributeName;
        private String authorityRevocationListAttribute;
        private String authorityRevocationListIssuerAttributeName;

        /* renamed from: baseDN */
        private String f21963baseDN;
        private String cACertificateAttribute;
        private String cACertificateSubjectAttributeName;
        private String certificateRevocationListAttribute;
        private String certificateRevocationListIssuerAttributeName;
        private String crossCertificateAttribute;
        private String crossCertificateSubjectAttributeName;
        private String deltaRevocationListAttribute;
        private String deltaRevocationListIssuerAttributeName;
        private String ldapAACertificateAttributeName;
        private String ldapAttributeAuthorityRevocationListAttributeName;
        private String ldapAttributeCertificateAttributeAttributeName;
        private String ldapAttributeCertificateRevocationListAttributeName;
        private String ldapAttributeDescriptorCertificateAttributeName;
        private String ldapAuthorityRevocationListAttributeName;
        private String ldapCACertificateAttributeName;
        private String ldapCertificateRevocationListAttributeName;
        private String ldapCrossCertificateAttributeName;
        private String ldapDeltaRevocationListAttributeName;

        /* renamed from: ldapURL */
        private String f21964ldapURL;
        private String ldapUserCertificateAttributeName;
        private String searchForSerialNumberIn;
        private String userCertificateAttribute;
        private String userCertificateSubjectAttributeName;

        public C5808Builder() {
            this("ldap://localhost:389", BuildConfig.f24315FLAVOR);
        }

        /* renamed from: build */
        public X509LDAPCertStoreParameters m16231build() {
            if (this.ldapUserCertificateAttributeName == null || this.ldapCACertificateAttributeName == null || this.ldapCrossCertificateAttributeName == null || this.ldapCertificateRevocationListAttributeName == null || this.ldapDeltaRevocationListAttributeName == null || this.ldapAuthorityRevocationListAttributeName == null || this.ldapAttributeCertificateAttributeAttributeName == null || this.ldapAACertificateAttributeName == null || this.ldapAttributeDescriptorCertificateAttributeName == null || this.ldapAttributeCertificateRevocationListAttributeName == null || this.ldapAttributeAuthorityRevocationListAttributeName == null || this.userCertificateSubjectAttributeName == null || this.cACertificateSubjectAttributeName == null || this.crossCertificateSubjectAttributeName == null || this.certificateRevocationListIssuerAttributeName == null || this.deltaRevocationListIssuerAttributeName == null || this.authorityRevocationListIssuerAttributeName == null || this.attributeCertificateAttributeSubjectAttributeName == null || this.aACertificateSubjectAttributeName == null || this.attributeDescriptorCertificateSubjectAttributeName == null || this.attributeCertificateRevocationListIssuerAttributeName == null || this.attributeAuthorityRevocationListIssuerAttributeName == null) {
                throw new IllegalArgumentException("Necessary parameters not specified.");
            }
            return new X509LDAPCertStoreParameters(this);
        }

        public C5808Builder setAACertificateAttribute(String str) {
            this.aACertificateAttribute = str;
            return this;
        }

        public C5808Builder setAACertificateSubjectAttributeName(String str) {
            this.aACertificateSubjectAttributeName = str;
            return this;
        }

        public C5808Builder setAttributeAuthorityRevocationListAttribute(String str) {
            this.attributeAuthorityRevocationListAttribute = str;
            return this;
        }

        public C5808Builder setAttributeAuthorityRevocationListIssuerAttributeName(String str) {
            this.attributeAuthorityRevocationListIssuerAttributeName = str;
            return this;
        }

        public C5808Builder setAttributeCertificateAttributeAttribute(String str) {
            this.attributeCertificateAttributeAttribute = str;
            return this;
        }

        public C5808Builder setAttributeCertificateAttributeSubjectAttributeName(String str) {
            this.attributeCertificateAttributeSubjectAttributeName = str;
            return this;
        }

        public C5808Builder setAttributeCertificateRevocationListAttribute(String str) {
            this.attributeCertificateRevocationListAttribute = str;
            return this;
        }

        public C5808Builder setAttributeCertificateRevocationListIssuerAttributeName(String str) {
            this.attributeCertificateRevocationListIssuerAttributeName = str;
            return this;
        }

        public C5808Builder setAttributeDescriptorCertificateAttribute(String str) {
            this.attributeDescriptorCertificateAttribute = str;
            return this;
        }

        public C5808Builder setAttributeDescriptorCertificateSubjectAttributeName(String str) {
            this.attributeDescriptorCertificateSubjectAttributeName = str;
            return this;
        }

        public C5808Builder setAuthorityRevocationListAttribute(String str) {
            this.authorityRevocationListAttribute = str;
            return this;
        }

        public C5808Builder setAuthorityRevocationListIssuerAttributeName(String str) {
            this.authorityRevocationListIssuerAttributeName = str;
            return this;
        }

        public C5808Builder setCACertificateAttribute(String str) {
            this.cACertificateAttribute = str;
            return this;
        }

        public C5808Builder setCACertificateSubjectAttributeName(String str) {
            this.cACertificateSubjectAttributeName = str;
            return this;
        }

        public C5808Builder setCertificateRevocationListAttribute(String str) {
            this.certificateRevocationListAttribute = str;
            return this;
        }

        public C5808Builder setCertificateRevocationListIssuerAttributeName(String str) {
            this.certificateRevocationListIssuerAttributeName = str;
            return this;
        }

        public C5808Builder setCrossCertificateAttribute(String str) {
            this.crossCertificateAttribute = str;
            return this;
        }

        public C5808Builder setCrossCertificateSubjectAttributeName(String str) {
            this.crossCertificateSubjectAttributeName = str;
            return this;
        }

        public C5808Builder setDeltaRevocationListAttribute(String str) {
            this.deltaRevocationListAttribute = str;
            return this;
        }

        public C5808Builder setDeltaRevocationListIssuerAttributeName(String str) {
            this.deltaRevocationListIssuerAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAACertificateAttributeName(String str) {
            this.ldapAACertificateAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAttributeAuthorityRevocationListAttributeName(String str) {
            this.ldapAttributeAuthorityRevocationListAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAttributeCertificateAttributeAttributeName(String str) {
            this.ldapAttributeCertificateAttributeAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAttributeCertificateRevocationListAttributeName(String str) {
            this.ldapAttributeCertificateRevocationListAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAttributeDescriptorCertificateAttributeName(String str) {
            this.ldapAttributeDescriptorCertificateAttributeName = str;
            return this;
        }

        public C5808Builder setLdapAuthorityRevocationListAttributeName(String str) {
            this.ldapAuthorityRevocationListAttributeName = str;
            return this;
        }

        public C5808Builder setLdapCACertificateAttributeName(String str) {
            this.ldapCACertificateAttributeName = str;
            return this;
        }

        public C5808Builder setLdapCertificateRevocationListAttributeName(String str) {
            this.ldapCertificateRevocationListAttributeName = str;
            return this;
        }

        public C5808Builder setLdapCrossCertificateAttributeName(String str) {
            this.ldapCrossCertificateAttributeName = str;
            return this;
        }

        public C5808Builder setLdapDeltaRevocationListAttributeName(String str) {
            this.ldapDeltaRevocationListAttributeName = str;
            return this;
        }

        public C5808Builder setLdapUserCertificateAttributeName(String str) {
            this.ldapUserCertificateAttributeName = str;
            return this;
        }

        public C5808Builder setSearchForSerialNumberIn(String str) {
            this.searchForSerialNumberIn = str;
            return this;
        }

        public C5808Builder setUserCertificateAttribute(String str) {
            this.userCertificateAttribute = str;
            return this;
        }

        public C5808Builder setUserCertificateSubjectAttributeName(String str) {
            this.userCertificateSubjectAttributeName = str;
            return this;
        }

        public C5808Builder(String str, String str2) {
            this.f21964ldapURL = str;
            if (str2 == null) {
                this.f21963baseDN = BuildConfig.f24315FLAVOR;
            } else {
                this.f21963baseDN = str2;
            }
            this.userCertificateAttribute = "userCertificate";
            this.cACertificateAttribute = "cACertificate";
            this.crossCertificateAttribute = "crossCertificatePair";
            this.certificateRevocationListAttribute = "certificateRevocationList";
            this.deltaRevocationListAttribute = "deltaRevocationList";
            this.authorityRevocationListAttribute = "authorityRevocationList";
            this.attributeCertificateAttributeAttribute = "attributeCertificateAttribute";
            this.aACertificateAttribute = "aACertificate";
            this.attributeDescriptorCertificateAttribute = "attributeDescriptorCertificate";
            this.attributeCertificateRevocationListAttribute = "attributeCertificateRevocationList";
            this.attributeAuthorityRevocationListAttribute = "attributeAuthorityRevocationList";
            this.ldapUserCertificateAttributeName = "cn";
            this.ldapCACertificateAttributeName = "cn ou o";
            this.ldapCrossCertificateAttributeName = "cn ou o";
            this.ldapCertificateRevocationListAttributeName = "cn ou o";
            this.ldapDeltaRevocationListAttributeName = "cn ou o";
            this.ldapAuthorityRevocationListAttributeName = "cn ou o";
            this.ldapAttributeCertificateAttributeAttributeName = "cn";
            this.ldapAACertificateAttributeName = "cn o ou";
            this.ldapAttributeDescriptorCertificateAttributeName = "cn o ou";
            this.ldapAttributeCertificateRevocationListAttributeName = "cn o ou";
            this.ldapAttributeAuthorityRevocationListAttributeName = "cn o ou";
            this.userCertificateSubjectAttributeName = "cn";
            this.cACertificateSubjectAttributeName = "o ou";
            this.crossCertificateSubjectAttributeName = "o ou";
            this.certificateRevocationListIssuerAttributeName = "o ou";
            this.deltaRevocationListIssuerAttributeName = "o ou";
            this.authorityRevocationListIssuerAttributeName = "o ou";
            this.attributeCertificateAttributeSubjectAttributeName = "cn";
            this.aACertificateSubjectAttributeName = "o ou";
            this.attributeDescriptorCertificateSubjectAttributeName = "o ou";
            this.attributeCertificateRevocationListIssuerAttributeName = "o ou";
            this.attributeAuthorityRevocationListIssuerAttributeName = "o ou";
            this.searchForSerialNumberIn = "uid serialNumber cn";
        }
    }

    private X509LDAPCertStoreParameters(C5808Builder c5808Builder) {
        this.f21962ldapURL = c5808Builder.f21964ldapURL;
        this.f21961baseDN = c5808Builder.f21963baseDN;
        this.userCertificateAttribute = c5808Builder.userCertificateAttribute;
        this.cACertificateAttribute = c5808Builder.cACertificateAttribute;
        this.crossCertificateAttribute = c5808Builder.crossCertificateAttribute;
        this.certificateRevocationListAttribute = c5808Builder.certificateRevocationListAttribute;
        this.deltaRevocationListAttribute = c5808Builder.deltaRevocationListAttribute;
        this.authorityRevocationListAttribute = c5808Builder.authorityRevocationListAttribute;
        this.attributeCertificateAttributeAttribute = c5808Builder.attributeCertificateAttributeAttribute;
        this.aACertificateAttribute = c5808Builder.aACertificateAttribute;
        this.attributeDescriptorCertificateAttribute = c5808Builder.attributeDescriptorCertificateAttribute;
        this.attributeCertificateRevocationListAttribute = c5808Builder.attributeCertificateRevocationListAttribute;
        this.attributeAuthorityRevocationListAttribute = c5808Builder.attributeAuthorityRevocationListAttribute;
        this.ldapUserCertificateAttributeName = c5808Builder.ldapUserCertificateAttributeName;
        this.ldapCACertificateAttributeName = c5808Builder.ldapCACertificateAttributeName;
        this.ldapCrossCertificateAttributeName = c5808Builder.ldapCrossCertificateAttributeName;
        this.ldapCertificateRevocationListAttributeName = c5808Builder.ldapCertificateRevocationListAttributeName;
        this.ldapDeltaRevocationListAttributeName = c5808Builder.ldapDeltaRevocationListAttributeName;
        this.ldapAuthorityRevocationListAttributeName = c5808Builder.ldapAuthorityRevocationListAttributeName;
        this.ldapAttributeCertificateAttributeAttributeName = c5808Builder.ldapAttributeCertificateAttributeAttributeName;
        this.ldapAACertificateAttributeName = c5808Builder.ldapAACertificateAttributeName;
        this.ldapAttributeDescriptorCertificateAttributeName = c5808Builder.ldapAttributeDescriptorCertificateAttributeName;
        this.ldapAttributeCertificateRevocationListAttributeName = c5808Builder.ldapAttributeCertificateRevocationListAttributeName;
        this.ldapAttributeAuthorityRevocationListAttributeName = c5808Builder.ldapAttributeAuthorityRevocationListAttributeName;
        this.userCertificateSubjectAttributeName = c5808Builder.userCertificateSubjectAttributeName;
        this.cACertificateSubjectAttributeName = c5808Builder.cACertificateSubjectAttributeName;
        this.crossCertificateSubjectAttributeName = c5808Builder.crossCertificateSubjectAttributeName;
        this.certificateRevocationListIssuerAttributeName = c5808Builder.certificateRevocationListIssuerAttributeName;
        this.deltaRevocationListIssuerAttributeName = c5808Builder.deltaRevocationListIssuerAttributeName;
        this.authorityRevocationListIssuerAttributeName = c5808Builder.authorityRevocationListIssuerAttributeName;
        this.attributeCertificateAttributeSubjectAttributeName = c5808Builder.attributeCertificateAttributeSubjectAttributeName;
        this.aACertificateSubjectAttributeName = c5808Builder.aACertificateSubjectAttributeName;
        this.attributeDescriptorCertificateSubjectAttributeName = c5808Builder.attributeDescriptorCertificateSubjectAttributeName;
        this.attributeCertificateRevocationListIssuerAttributeName = c5808Builder.attributeCertificateRevocationListIssuerAttributeName;
        this.attributeAuthorityRevocationListIssuerAttributeName = c5808Builder.attributeAuthorityRevocationListIssuerAttributeName;
        this.searchForSerialNumberIn = c5808Builder.searchForSerialNumberIn;
    }

    private int addHashCode(int i, Object obj) {
        return (i * 29) + (obj == null ? 0 : obj.hashCode());
    }

    private boolean checkField(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static X509LDAPCertStoreParameters getInstance(LDAPCertStoreParameters lDAPCertStoreParameters) {
        return new C5808Builder("ldap://" + lDAPCertStoreParameters.getServerName() + ":" + lDAPCertStoreParameters.getPort(), BuildConfig.f24315FLAVOR).m16231build();
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        return this;
    }

    /* renamed from: equal */
    public boolean m16230equal(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509LDAPCertStoreParameters)) {
            return false;
        }
        X509LDAPCertStoreParameters x509LDAPCertStoreParameters = (X509LDAPCertStoreParameters) obj;
        return checkField(this.f21962ldapURL, x509LDAPCertStoreParameters.f21962ldapURL) && checkField(this.f21961baseDN, x509LDAPCertStoreParameters.f21961baseDN) && checkField(this.userCertificateAttribute, x509LDAPCertStoreParameters.userCertificateAttribute) && checkField(this.cACertificateAttribute, x509LDAPCertStoreParameters.cACertificateAttribute) && checkField(this.crossCertificateAttribute, x509LDAPCertStoreParameters.crossCertificateAttribute) && checkField(this.certificateRevocationListAttribute, x509LDAPCertStoreParameters.certificateRevocationListAttribute) && checkField(this.deltaRevocationListAttribute, x509LDAPCertStoreParameters.deltaRevocationListAttribute) && checkField(this.authorityRevocationListAttribute, x509LDAPCertStoreParameters.authorityRevocationListAttribute) && checkField(this.attributeCertificateAttributeAttribute, x509LDAPCertStoreParameters.attributeCertificateAttributeAttribute) && checkField(this.aACertificateAttribute, x509LDAPCertStoreParameters.aACertificateAttribute) && checkField(this.attributeDescriptorCertificateAttribute, x509LDAPCertStoreParameters.attributeDescriptorCertificateAttribute) && checkField(this.attributeCertificateRevocationListAttribute, x509LDAPCertStoreParameters.attributeCertificateRevocationListAttribute) && checkField(this.attributeAuthorityRevocationListAttribute, x509LDAPCertStoreParameters.attributeAuthorityRevocationListAttribute) && checkField(this.ldapUserCertificateAttributeName, x509LDAPCertStoreParameters.ldapUserCertificateAttributeName) && checkField(this.ldapCACertificateAttributeName, x509LDAPCertStoreParameters.ldapCACertificateAttributeName) && checkField(this.ldapCrossCertificateAttributeName, x509LDAPCertStoreParameters.ldapCrossCertificateAttributeName) && checkField(this.ldapCertificateRevocationListAttributeName, x509LDAPCertStoreParameters.ldapCertificateRevocationListAttributeName) && checkField(this.ldapDeltaRevocationListAttributeName, x509LDAPCertStoreParameters.ldapDeltaRevocationListAttributeName) && checkField(this.ldapAuthorityRevocationListAttributeName, x509LDAPCertStoreParameters.ldapAuthorityRevocationListAttributeName) && checkField(this.ldapAttributeCertificateAttributeAttributeName, x509LDAPCertStoreParameters.ldapAttributeCertificateAttributeAttributeName) && checkField(this.ldapAACertificateAttributeName, x509LDAPCertStoreParameters.ldapAACertificateAttributeName) && checkField(this.ldapAttributeDescriptorCertificateAttributeName, x509LDAPCertStoreParameters.ldapAttributeDescriptorCertificateAttributeName) && checkField(this.ldapAttributeCertificateRevocationListAttributeName, x509LDAPCertStoreParameters.ldapAttributeCertificateRevocationListAttributeName) && checkField(this.ldapAttributeAuthorityRevocationListAttributeName, x509LDAPCertStoreParameters.ldapAttributeAuthorityRevocationListAttributeName) && checkField(this.userCertificateSubjectAttributeName, x509LDAPCertStoreParameters.userCertificateSubjectAttributeName) && checkField(this.cACertificateSubjectAttributeName, x509LDAPCertStoreParameters.cACertificateSubjectAttributeName) && checkField(this.crossCertificateSubjectAttributeName, x509LDAPCertStoreParameters.crossCertificateSubjectAttributeName) && checkField(this.certificateRevocationListIssuerAttributeName, x509LDAPCertStoreParameters.certificateRevocationListIssuerAttributeName) && checkField(this.deltaRevocationListIssuerAttributeName, x509LDAPCertStoreParameters.deltaRevocationListIssuerAttributeName) && checkField(this.authorityRevocationListIssuerAttributeName, x509LDAPCertStoreParameters.authorityRevocationListIssuerAttributeName) && checkField(this.attributeCertificateAttributeSubjectAttributeName, x509LDAPCertStoreParameters.attributeCertificateAttributeSubjectAttributeName) && checkField(this.aACertificateSubjectAttributeName, x509LDAPCertStoreParameters.aACertificateSubjectAttributeName) && checkField(this.attributeDescriptorCertificateSubjectAttributeName, x509LDAPCertStoreParameters.attributeDescriptorCertificateSubjectAttributeName) && checkField(this.attributeCertificateRevocationListIssuerAttributeName, x509LDAPCertStoreParameters.attributeCertificateRevocationListIssuerAttributeName) && checkField(this.attributeAuthorityRevocationListIssuerAttributeName, x509LDAPCertStoreParameters.attributeAuthorityRevocationListIssuerAttributeName) && checkField(this.searchForSerialNumberIn, x509LDAPCertStoreParameters.searchForSerialNumberIn);
    }

    public String getAACertificateAttribute() {
        return this.aACertificateAttribute;
    }

    public String getAACertificateSubjectAttributeName() {
        return this.aACertificateSubjectAttributeName;
    }

    public String getAttributeAuthorityRevocationListAttribute() {
        return this.attributeAuthorityRevocationListAttribute;
    }

    public String getAttributeAuthorityRevocationListIssuerAttributeName() {
        return this.attributeAuthorityRevocationListIssuerAttributeName;
    }

    public String getAttributeCertificateAttributeAttribute() {
        return this.attributeCertificateAttributeAttribute;
    }

    public String getAttributeCertificateAttributeSubjectAttributeName() {
        return this.attributeCertificateAttributeSubjectAttributeName;
    }

    public String getAttributeCertificateRevocationListAttribute() {
        return this.attributeCertificateRevocationListAttribute;
    }

    public String getAttributeCertificateRevocationListIssuerAttributeName() {
        return this.attributeCertificateRevocationListIssuerAttributeName;
    }

    public String getAttributeDescriptorCertificateAttribute() {
        return this.attributeDescriptorCertificateAttribute;
    }

    public String getAttributeDescriptorCertificateSubjectAttributeName() {
        return this.attributeDescriptorCertificateSubjectAttributeName;
    }

    public String getAuthorityRevocationListAttribute() {
        return this.authorityRevocationListAttribute;
    }

    public String getAuthorityRevocationListIssuerAttributeName() {
        return this.authorityRevocationListIssuerAttributeName;
    }

    public String getBaseDN() {
        return this.f21961baseDN;
    }

    public String getCACertificateAttribute() {
        return this.cACertificateAttribute;
    }

    public String getCACertificateSubjectAttributeName() {
        return this.cACertificateSubjectAttributeName;
    }

    public String getCertificateRevocationListAttribute() {
        return this.certificateRevocationListAttribute;
    }

    public String getCertificateRevocationListIssuerAttributeName() {
        return this.certificateRevocationListIssuerAttributeName;
    }

    public String getCrossCertificateAttribute() {
        return this.crossCertificateAttribute;
    }

    public String getCrossCertificateSubjectAttributeName() {
        return this.crossCertificateSubjectAttributeName;
    }

    public String getDeltaRevocationListAttribute() {
        return this.deltaRevocationListAttribute;
    }

    public String getDeltaRevocationListIssuerAttributeName() {
        return this.deltaRevocationListIssuerAttributeName;
    }

    public String getLdapAACertificateAttributeName() {
        return this.ldapAACertificateAttributeName;
    }

    public String getLdapAttributeAuthorityRevocationListAttributeName() {
        return this.ldapAttributeAuthorityRevocationListAttributeName;
    }

    public String getLdapAttributeCertificateAttributeAttributeName() {
        return this.ldapAttributeCertificateAttributeAttributeName;
    }

    public String getLdapAttributeCertificateRevocationListAttributeName() {
        return this.ldapAttributeCertificateRevocationListAttributeName;
    }

    public String getLdapAttributeDescriptorCertificateAttributeName() {
        return this.ldapAttributeDescriptorCertificateAttributeName;
    }

    public String getLdapAuthorityRevocationListAttributeName() {
        return this.ldapAuthorityRevocationListAttributeName;
    }

    public String getLdapCACertificateAttributeName() {
        return this.ldapCACertificateAttributeName;
    }

    public String getLdapCertificateRevocationListAttributeName() {
        return this.ldapCertificateRevocationListAttributeName;
    }

    public String getLdapCrossCertificateAttributeName() {
        return this.ldapCrossCertificateAttributeName;
    }

    public String getLdapDeltaRevocationListAttributeName() {
        return this.ldapDeltaRevocationListAttributeName;
    }

    public String getLdapURL() {
        return this.f21962ldapURL;
    }

    public String getLdapUserCertificateAttributeName() {
        return this.ldapUserCertificateAttributeName;
    }

    public String getSearchForSerialNumberIn() {
        return this.searchForSerialNumberIn;
    }

    public String getUserCertificateAttribute() {
        return this.userCertificateAttribute;
    }

    public String getUserCertificateSubjectAttributeName() {
        return this.userCertificateSubjectAttributeName;
    }

    public int hashCode() {
        return addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(0, this.userCertificateAttribute), this.cACertificateAttribute), this.crossCertificateAttribute), this.certificateRevocationListAttribute), this.deltaRevocationListAttribute), this.authorityRevocationListAttribute), this.attributeCertificateAttributeAttribute), this.aACertificateAttribute), this.attributeDescriptorCertificateAttribute), this.attributeCertificateRevocationListAttribute), this.attributeAuthorityRevocationListAttribute), this.ldapUserCertificateAttributeName), this.ldapCACertificateAttributeName), this.ldapCrossCertificateAttributeName), this.ldapCertificateRevocationListAttributeName), this.ldapDeltaRevocationListAttributeName), this.ldapAuthorityRevocationListAttributeName), this.ldapAttributeCertificateAttributeAttributeName), this.ldapAACertificateAttributeName), this.ldapAttributeDescriptorCertificateAttributeName), this.ldapAttributeCertificateRevocationListAttributeName), this.ldapAttributeAuthorityRevocationListAttributeName), this.userCertificateSubjectAttributeName), this.cACertificateSubjectAttributeName), this.crossCertificateSubjectAttributeName), this.certificateRevocationListIssuerAttributeName), this.deltaRevocationListIssuerAttributeName), this.authorityRevocationListIssuerAttributeName), this.attributeCertificateAttributeSubjectAttributeName), this.aACertificateSubjectAttributeName), this.attributeDescriptorCertificateSubjectAttributeName), this.attributeCertificateRevocationListIssuerAttributeName), this.attributeAuthorityRevocationListIssuerAttributeName), this.searchForSerialNumberIn);
    }
}
