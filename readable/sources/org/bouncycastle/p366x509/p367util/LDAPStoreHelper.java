package org.bouncycastle.p366x509.p367util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificatePair;
import org.bouncycastle.p281jce.X509LDAPCertStoreParameters;
import org.bouncycastle.p281jce.provider.X509AttrCertParser;
import org.bouncycastle.p281jce.provider.X509CRLParser;
import org.bouncycastle.p281jce.provider.X509CertPairParser;
import org.bouncycastle.p281jce.provider.X509CertParser;
import org.bouncycastle.p283ldap.LDAPUtils;
import org.bouncycastle.p361util.StoreException;
import org.bouncycastle.p366x509.X509AttributeCertStoreSelector;
import org.bouncycastle.p366x509.X509AttributeCertificate;
import org.bouncycastle.p366x509.X509CRLStoreSelector;
import org.bouncycastle.p366x509.X509CertPairStoreSelector;
import org.bouncycastle.p366x509.X509CertStoreSelector;
import org.bouncycastle.p366x509.X509CertificatePair;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class LDAPStoreHelper {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private static int cacheSize = 32;
    private static long lifeTime = 60000;
    private Map cacheMap = new HashMap(cacheSize);

    /* renamed from: params */
    private X509LDAPCertStoreParameters f24302params;

    public LDAPStoreHelper(X509LDAPCertStoreParameters x509LDAPCertStoreParameters) {
        this.f24302params = x509LDAPCertStoreParameters;
    }

    private synchronized void addToCache(String str, List list) {
        try {
            Date date = new Date(System.currentTimeMillis());
            ArrayList arrayList = new ArrayList();
            arrayList.add(date);
            arrayList.add(list);
            if (!this.cacheMap.containsKey(str) && this.cacheMap.size() >= cacheSize) {
                long time = date.getTime();
                Object key = null;
                for (Map.Entry entry : this.cacheMap.entrySet()) {
                    long time2 = ((Date) ((List) entry.getValue()).get(0)).getTime();
                    if (time2 < time) {
                        key = entry.getKey();
                        time = time2;
                    }
                }
                this.cacheMap.remove(key);
            }
            Map map = this.cacheMap;
            map.put(str, arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List attrCertSubjectSerialSearch(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        Principal[] entityNames;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        String name = null;
        if (x509AttributeCertStoreSelector.getHolder() == null) {
            entityNames = null;
        } else {
            if (x509AttributeCertStoreSelector.getHolder().getSerialNumber() != null) {
                hashSet.add(x509AttributeCertStoreSelector.getHolder().getSerialNumber().toString());
            }
            if (x509AttributeCertStoreSelector.getHolder().getEntityNames() != null) {
                entityNames = x509AttributeCertStoreSelector.getHolder().getEntityNames();
            }
        }
        if (x509AttributeCertStoreSelector.getAttributeCert() != null) {
            if (x509AttributeCertStoreSelector.getAttributeCert().getHolder().getEntityNames() != null) {
                entityNames = x509AttributeCertStoreSelector.getAttributeCert().getHolder().getEntityNames();
            }
            hashSet.add(x509AttributeCertStoreSelector.getAttributeCert().getSerialNumber().toString());
        }
        if (entityNames != null) {
            Principal principal = entityNames[0];
            name = principal instanceof X500Principal ? ((X500Principal) principal).getName("RFC1779") : principal.getName();
        }
        if (x509AttributeCertStoreSelector.getSerialNumber() != null) {
            hashSet.add(x509AttributeCertStoreSelector.getSerialNumber().toString());
        }
        if (name != null) {
            for (String str : strArr3) {
                arrayList.addAll(m18406search(strArr2, "*" + LDAPUtils.m16292parseDN(name, str) + "*", strArr));
            }
        }
        if (hashSet.size() > 0 && this.f24302params.getSearchForSerialNumberIn() != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList.addAll(m18406search(splitString(this.f24302params.getSearchForSerialNumberIn()), (String) it.next(), strArr));
            }
        }
        if (hashSet.size() == 0 && name == null) {
            arrayList.addAll(m18406search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private List cRLIssuerSearch(X509CRLStoreSelector x509CRLStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (x509CRLStoreSelector.getIssuers() != null) {
            hashSet.addAll(x509CRLStoreSelector.getIssuers());
        }
        if (x509CRLStoreSelector.getCertificateChecking() != null) {
            hashSet.add(getCertificateIssuer(x509CRLStoreSelector.getCertificateChecking()));
        }
        if (x509CRLStoreSelector.getAttrCertificateChecking() != null) {
            for (Principal principal : x509CRLStoreSelector.getAttrCertificateChecking().getIssuer().getPrincipals()) {
                if (principal instanceof X500Principal) {
                    hashSet.add(principal);
                }
            }
        }
        Iterator it = hashSet.iterator();
        String name = null;
        while (it.hasNext()) {
            name = ((X500Principal) it.next()).getName("RFC1779");
            for (String str : strArr3) {
                arrayList.addAll(m18406search(strArr2, "*" + LDAPUtils.m16292parseDN(name, str) + "*", strArr));
            }
        }
        if (name == null) {
            arrayList.addAll(m18406search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private List certSubjectSerialSearch(X509CertStoreSelector x509CertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws IOException {
        ArrayList arrayList = new ArrayList();
        String subjectAsString = getSubjectAsString(x509CertStoreSelector);
        String string = x509CertStoreSelector.getSerialNumber() != null ? x509CertStoreSelector.getSerialNumber().toString() : null;
        if (x509CertStoreSelector.getCertificate() != null) {
            subjectAsString = x509CertStoreSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
            string = x509CertStoreSelector.getCertificate().getSerialNumber().toString();
        }
        if (subjectAsString != null) {
            for (String str : strArr3) {
                arrayList.addAll(m18406search(strArr2, "*" + LDAPUtils.m16292parseDN(subjectAsString, str) + "*", strArr));
            }
        }
        if (string != null && this.f24302params.getSearchForSerialNumberIn() != null) {
            arrayList.addAll(m18406search(splitString(this.f24302params.getSearchForSerialNumberIn()), string, strArr));
        }
        if (string == null && subjectAsString == null) {
            arrayList.addAll(m18406search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private DirContext connectLDAP() {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", LDAP_PROVIDER);
        properties.setProperty("java.naming.batchsize", "0");
        properties.setProperty("java.naming.provider.url", this.f24302params.getLdapURL());
        properties.setProperty("java.naming.factory.url.pkgs", URL_CONTEXT_PREFIX);
        properties.setProperty("java.naming.referral", REFERRALS_IGNORE);
        properties.setProperty("java.naming.security.authentication", SEARCH_SECURITY_LEVEL);
        return new InitialDirContext(properties);
    }

    private Set createAttributeCertificates(List list, X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509AttrCertParser x509AttrCertParser = new X509AttrCertParser();
        while (it.hasNext()) {
            try {
                x509AttrCertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) x509AttrCertParser.engineRead();
                if (x509AttributeCertStoreSelector.mo14742match(x509AttributeCertificate)) {
                    hashSet.add(x509AttributeCertificate);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    private Set createCRLs(List list, X509CRLStoreSelector x509CRLStoreSelector) {
        HashSet hashSet = new HashSet();
        X509CRLParser x509CRLParser = new X509CRLParser();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                x509CRLParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509CRL x509crl = (X509CRL) x509CRLParser.engineRead();
                if (x509CRLStoreSelector.mo14742match((Object) x509crl)) {
                    hashSet.add(x509crl);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    private Set createCerts(List list, X509CertStoreSelector x509CertStoreSelector) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509CertParser x509CertParser = new X509CertParser();
        while (it.hasNext()) {
            try {
                x509CertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509Certificate x509Certificate = (X509Certificate) x509CertParser.engineRead();
                if (x509CertStoreSelector.mo14742match((Object) x509Certificate)) {
                    hashSet.add(x509Certificate);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    private Set createCrossCertificatePairs(List list, X509CertPairStoreSelector x509CertPairStoreSelector) {
        X509CertificatePair x509CertificatePair;
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < list.size()) {
            try {
                try {
                    X509CertPairParser x509CertPairParser = new X509CertPairParser();
                    x509CertPairParser.engineInit(new ByteArrayInputStream((byte[]) list.get(i)));
                    x509CertificatePair = (X509CertificatePair) x509CertPairParser.engineRead();
                } catch (IOException | CertificateParsingException unused) {
                }
            } catch (StreamParsingException unused2) {
                int i2 = i + 1;
                i = i2;
                x509CertificatePair = new X509CertificatePair(new CertificatePair(Certificate.getInstance(new ASN1InputStream((byte[]) list.get(i)).readObject()), Certificate.getInstance(new ASN1InputStream((byte[]) list.get(i2)).readObject())));
            }
            if (x509CertPairStoreSelector.mo14742match(x509CertificatePair)) {
                hashSet.add(x509CertificatePair);
            }
            i++;
        }
        return hashSet;
    }

    private List crossCertificatePairSubjectSearch(X509CertPairStoreSelector x509CertPairStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        ArrayList arrayList = new ArrayList();
        String subjectAsString = x509CertPairStoreSelector.getForwardSelector() != null ? getSubjectAsString(x509CertPairStoreSelector.getForwardSelector()) : null;
        if (x509CertPairStoreSelector.getCertPair() != null && x509CertPairStoreSelector.getCertPair().getForward() != null) {
            subjectAsString = x509CertPairStoreSelector.getCertPair().getForward().getSubjectX500Principal().getName("RFC1779");
        }
        if (subjectAsString != null) {
            for (String str : strArr3) {
                arrayList.addAll(m18406search(strArr2, "*" + LDAPUtils.m16292parseDN(subjectAsString, str) + "*", strArr));
            }
        }
        if (subjectAsString == null) {
            arrayList.addAll(m18406search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private X500Principal getCertificateIssuer(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal();
    }

    private List getFromCache(String str) {
        List list = (List) this.cacheMap.get(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list == null || ((Date) list.get(0)).getTime() < jCurrentTimeMillis - lifeTime) {
            return null;
        }
        return (List) list.get(1);
    }

    private String getSubjectAsString(X509CertStoreSelector x509CertStoreSelector) throws IOException {
        try {
            byte[] subjectAsBytes = x509CertStoreSelector.getSubjectAsBytes();
            if (subjectAsBytes != null) {
                return new X500Principal(subjectAsBytes).getName("RFC1779");
            }
            return null;
        } catch (IOException e) {
            throw new StoreException("exception processing name: " + e.getMessage(), e);
        }
    }

    /* renamed from: search */
    private List m18406search(String[] strArr, String str, String[] strArr2) {
        String str2;
        DirContext dirContextConnectLDAP = null;
        if (strArr == null) {
            str2 = null;
        } else {
            if (str.equals("**")) {
                str = "*";
            }
            String str3 = BuildConfig.f24315FLAVOR;
            for (String str4 : strArr) {
                str3 = str3 + "(" + str4 + "=" + str + ")";
            }
            str2 = "(|" + str3 + ")";
        }
        String str5 = BuildConfig.f24315FLAVOR;
        for (String str6 : strArr2) {
            str5 = str5 + "(" + str6 + "=*)";
        }
        String str7 = "(|" + str5 + ")";
        String str8 = "(&" + str2 + BuildConfig.f24315FLAVOR + str7 + ")";
        if (str2 != null) {
            str7 = str8;
        }
        List fromCache = getFromCache(str7);
        if (fromCache != null) {
            return fromCache;
        }
        ArrayList arrayList = new ArrayList();
        try {
            dirContextConnectLDAP = connectLDAP();
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(2);
            searchControls.setCountLimit(0L);
            searchControls.setReturningAttributes(strArr2);
            NamingEnumeration namingEnumerationSearch = dirContextConnectLDAP.search(this.f24302params.getBaseDN(), str7, searchControls);
            while (namingEnumerationSearch.hasMoreElements()) {
                NamingEnumeration all = ((Attribute) ((SearchResult) namingEnumerationSearch.next()).getAttributes().getAll().next()).getAll();
                while (all.hasMore()) {
                    arrayList.add(all.next());
                }
            }
            addToCache(str7, arrayList);
        } catch (NamingException unused) {
            if (dirContextConnectLDAP != null) {
            }
        } catch (Throwable th) {
            if (dirContextConnectLDAP != null) {
                try {
                    dirContextConnectLDAP.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            dirContextConnectLDAP.close();
        } catch (Exception unused3) {
        }
        return arrayList;
    }

    private String[] splitString(String str) {
        return str.split("\\s+");
    }

    public Collection getAACertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAACertificateAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAACertificateAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAACertificateSubjectAttributeName());
        Set setCreateAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector);
        if (setCreateAttributeCertificates.size() == 0) {
            setCreateAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector));
        }
        return setCreateAttributeCertificates;
    }

    public Collection getAttributeAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAttributeAuthorityRevocationListAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAttributeAuthorityRevocationListAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAttributeAuthorityRevocationListIssuerAttributeName());
        Set setCreateCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector);
        if (setCreateCRLs.size() == 0) {
            setCreateCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector));
        }
        return setCreateCRLs;
    }

    public Collection getAttributeCertificateAttributes(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAttributeCertificateAttributeAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAttributeCertificateAttributeAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAttributeCertificateAttributeSubjectAttributeName());
        Set setCreateAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector);
        if (setCreateAttributeCertificates.size() == 0) {
            setCreateAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector));
        }
        return setCreateAttributeCertificates;
    }

    public Collection getAttributeCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAttributeCertificateRevocationListAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAttributeCertificateRevocationListAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAttributeCertificateRevocationListIssuerAttributeName());
        Set setCreateCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector);
        if (setCreateCRLs.size() == 0) {
            setCreateCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector));
        }
        return setCreateCRLs;
    }

    public Collection getAttributeDescriptorCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAttributeDescriptorCertificateAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAttributeDescriptorCertificateAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAttributeDescriptorCertificateSubjectAttributeName());
        Set setCreateAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector);
        if (setCreateAttributeCertificates.size() == 0) {
            setCreateAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509AttributeCertStoreSelector));
        }
        return setCreateAttributeCertificates;
    }

    public Collection getAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getAuthorityRevocationListAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapAuthorityRevocationListAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getAuthorityRevocationListIssuerAttributeName());
        Set setCreateCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector);
        if (setCreateCRLs.size() == 0) {
            setCreateCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector));
        }
        return setCreateCRLs;
    }

    public Collection getCACertificates(X509CertStoreSelector x509CertStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getCACertificateAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapCACertificateAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getCACertificateSubjectAttributeName());
        Set setCreateCerts = createCerts(certSubjectSerialSearch(x509CertStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertStoreSelector);
        if (setCreateCerts.size() == 0) {
            setCreateCerts.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertStoreSelector));
        }
        return setCreateCerts;
    }

    public Collection getCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getCertificateRevocationListAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapCertificateRevocationListAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getCertificateRevocationListIssuerAttributeName());
        Set setCreateCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector);
        if (setCreateCRLs.size() == 0) {
            setCreateCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector));
        }
        return setCreateCRLs;
    }

    public Collection getCrossCertificatePairs(X509CertPairStoreSelector x509CertPairStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getCrossCertificateAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapCrossCertificateAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getCrossCertificateSubjectAttributeName());
        Set setCreateCrossCertificatePairs = createCrossCertificatePairs(crossCertificatePairSubjectSearch(x509CertPairStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertPairStoreSelector);
        if (setCreateCrossCertificatePairs.size() == 0) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            X509CertPairStoreSelector x509CertPairStoreSelector2 = new X509CertPairStoreSelector();
            x509CertPairStoreSelector2.setForwardSelector(x509CertStoreSelector);
            x509CertPairStoreSelector2.setReverseSelector(x509CertStoreSelector);
            setCreateCrossCertificatePairs.addAll(createCrossCertificatePairs(crossCertificatePairSubjectSearch(x509CertPairStoreSelector2, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertPairStoreSelector));
        }
        return setCreateCrossCertificatePairs;
    }

    public Collection getDeltaCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getDeltaRevocationListAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapDeltaRevocationListAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getDeltaRevocationListIssuerAttributeName());
        Set setCreateCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector);
        if (setCreateCRLs.size() == 0) {
            setCreateCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CRLStoreSelector));
        }
        return setCreateCRLs;
    }

    public Collection getUserCertificates(X509CertStoreSelector x509CertStoreSelector) {
        String[] strArrSplitString = splitString(this.f24302params.getUserCertificateAttribute());
        String[] strArrSplitString2 = splitString(this.f24302params.getLdapUserCertificateAttributeName());
        String[] strArrSplitString3 = splitString(this.f24302params.getUserCertificateSubjectAttributeName());
        Set setCreateCerts = createCerts(certSubjectSerialSearch(x509CertStoreSelector, strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertStoreSelector);
        if (setCreateCerts.size() == 0) {
            setCreateCerts.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), strArrSplitString, strArrSplitString2, strArrSplitString3), x509CertStoreSelector));
        }
        return setCreateCerts;
    }
}
