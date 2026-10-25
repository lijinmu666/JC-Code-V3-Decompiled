package org.bouncycastle.p310pkix.p311jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import org.bouncycastle.p249jcajce.PKIXCRLStore;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Iterable;
import org.bouncycastle.p361util.Selector;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
class CrlCache {
    private static final int DEFAULT_TIMEOUT = 15000;

    /* renamed from: cache */
    private static Map<URI, WeakReference<PKIXCRLStore>> f22979cache = Collections.synchronizedMap(new WeakHashMap());

    public static class LocalCRLStore<T extends CRL> implements PKIXCRLStore, Iterable<CRL> {

        /* renamed from: _local */
        private Collection<CRL> f22980_local;

        public LocalCRLStore(InterfaceC6249Store<CRL> interfaceC6249Store) {
            this.f22980_local = new ArrayList(interfaceC6249Store.getMatches(null));
        }

        @Override // org.bouncycastle.p249jcajce.PKIXCRLStore, org.bouncycastle.p361util.InterfaceC6249Store
        public Collection getMatches(Selector selector) {
            if (selector == null) {
                return new ArrayList(this.f22980_local);
            }
            ArrayList arrayList = new ArrayList();
            for (CRL crl : this.f22980_local) {
                if (selector.mo14742match(crl)) {
                    arrayList.add(crl);
                }
            }
            return arrayList;
        }

        @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
        public Iterator<CRL> iterator() {
            return getMatches(null).iterator();
        }
    }

    /* renamed from: getCrl */
    public static synchronized PKIXCRLStore m17440getCrl(CertificateFactory certificateFactory, Date date, URI uri) {
        try {
            WeakReference<PKIXCRLStore> weakReference = f22979cache.get(uri);
            PKIXCRLStore pKIXCRLStore = weakReference != null ? weakReference.get() : null;
            if (pKIXCRLStore != null) {
                Iterator it = pKIXCRLStore.getMatches(null).iterator();
                while (it.hasNext()) {
                    Date nextUpdate = ((X509CRL) it.next()).getNextUpdate();
                    if (nextUpdate == null || !nextUpdate.before(date)) {
                    }
                }
                return pKIXCRLStore;
            }
            LocalCRLStore localCRLStore = new LocalCRLStore(new CollectionStore(uri.getScheme().equals("ldap") ? getCrlsFromLDAP(certificateFactory, uri) : m17441getCrls(certificateFactory, uri)));
            f22979cache.put(uri, new WeakReference<>(localCRLStore));
            return localCRLStore;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: getCrls */
    private static Collection m17441getCrls(CertificateFactory certificateFactory, URI uri) throws IOException, CRLException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setConnectTimeout(DEFAULT_TIMEOUT);
        httpURLConnection.setReadTimeout(DEFAULT_TIMEOUT);
        InputStream inputStream = httpURLConnection.getInputStream();
        Collection<? extends CRL> collectionGenerateCRLs = certificateFactory.generateCRLs(inputStream);
        inputStream.close();
        return collectionGenerateCRLs;
    }

    private static Collection getCrlsFromLDAP(CertificateFactory certificateFactory, URI uri) throws CRLException {
        Hashtable hashtable = new Hashtable();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", uri.toString());
        try {
            byte[] bArr = (byte[]) new InitialDirContext(hashtable).getAttributes(BuildConfig.f24315FLAVOR).get("certificateRevocationList;binary").get();
            if (bArr != null && bArr.length != 0) {
                return certificateFactory.generateCRLs(new ByteArrayInputStream(bArr));
            }
            throw new CRLException("no CRL returned from: " + uri);
        } catch (NamingException e) {
            throw new CRLException("issue connecting to: " + uri.toString(), e);
        }
    }
}
