package org.bouncycastle.p249jcajce.provider.keystore.p276util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p249jcajce.BCLoadStoreParameter;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.p278util.DigestFactory;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class JKSKeyStoreSpi extends KeyStoreSpi {
    private static final String NOT_IMPLEMENTED_MESSAGE = "BC JKS store is read-only and only supports certificate entries";
    private final Hashtable<String, BCJKSTrustedCertEntry> certificateEntries = new Hashtable<>();

    /* renamed from: helper */
    private final JcaJceHelper f21768helper;

    public static final class BCJKSTrustedCertEntry {

        /* renamed from: cert */
        final Certificate f21769cert;

        /* renamed from: date */
        final Date f21770date;

        public BCJKSTrustedCertEntry(Date date, Certificate certificate) {
            this.f21770date = date;
            this.f21769cert = certificate;
        }
    }

    public static final class ErasableByteStream extends ByteArrayInputStream {
        public ErasableByteStream(byte[] bArr, int i, int i2) {
            super(bArr, i, i2);
        }

        /* renamed from: erase */
        public void m16171erase() {
            C6238Arrays.m18249fill(((ByteArrayInputStream) this).buf, (byte) 0);
        }
    }

    public JKSKeyStoreSpi(JcaJceHelper jcaJceHelper) {
        this.f21768helper = jcaJceHelper;
    }

    private void addPassword(InterfaceC5277Digest interfaceC5277Digest, char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            interfaceC5277Digest.mo14969update((byte) (cArr[i] >> '\b'));
            interfaceC5277Digest.mo14969update((byte) cArr[i]);
        }
        interfaceC5277Digest.mo14970update(C6250Strings.toByteArray("Mighty Aphrodite"), 0, 16);
    }

    private CertificateFactory createCertFactory(String str) throws CertificateException {
        JcaJceHelper jcaJceHelper = this.f21768helper;
        if (jcaJceHelper == null) {
            return CertificateFactory.getInstance(str);
        }
        try {
            return jcaJceHelper.createCertificateFactory(str);
        } catch (NoSuchProviderException e) {
            throw new CertificateException(e.toString());
        }
    }

    private ErasableByteStream validateStream(InputStream inputStream, char[] cArr) throws IOException {
        InterfaceC5277Digest digest = DigestFactory.getDigest("SHA-1");
        byte[] bArrM18363readAll = C6257Streams.m18363readAll(inputStream);
        if (cArr == null) {
            return new ErasableByteStream(bArrM18363readAll, 0, bArrM18363readAll.length - digest.getDigestSize());
        }
        addPassword(digest, cArr);
        digest.mo14970update(bArrM18363readAll, 0, bArrM18363readAll.length - digest.getDigestSize());
        int digestSize = digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        digest.mo14967doFinal(bArr, 0);
        byte[] bArr2 = new byte[digestSize];
        System.arraycopy(bArrM18363readAll, bArrM18363readAll.length - digestSize, bArr2, 0, digestSize);
        if (C6238Arrays.constantTimeAreEqual(bArr, bArr2)) {
            return new ErasableByteStream(bArrM18363readAll, 0, bArrM18363readAll.length - digestSize);
        }
        C6238Arrays.m18249fill(bArrM18363readAll, (byte) 0);
        throw new IOException("password incorrect or store tampered with");
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        Enumeration<String> enumerationKeys;
        synchronized (this.certificateEntries) {
            enumerationKeys = this.certificateEntries.keys();
        }
        return enumerationKeys;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        boolean zContainsKey;
        if (str == null) {
            throw new NullPointerException("alias value is null");
        }
        synchronized (this.certificateEntries) {
            zContainsKey = this.certificateEntries.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        synchronized (this.certificateEntries) {
            try {
                BCJKSTrustedCertEntry bCJKSTrustedCertEntry = this.certificateEntries.get(str);
                if (bCJKSTrustedCertEntry == null) {
                    return null;
                }
                return bCJKSTrustedCertEntry.f21769cert;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        synchronized (this.certificateEntries) {
            try {
                for (Map.Entry<String, BCJKSTrustedCertEntry> entry : this.certificateEntries.entrySet()) {
                    if (entry.getValue().f21769cert.equals(certificate)) {
                        return entry.getKey();
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        synchronized (this.certificateEntries) {
            try {
                BCJKSTrustedCertEntry bCJKSTrustedCertEntry = this.certificateEntries.get(str);
                if (bCJKSTrustedCertEntry == null) {
                    return null;
                }
                return bCJKSTrustedCertEntry.f21770date;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        boolean zContainsKey;
        synchronized (this.certificateEntries) {
            zContainsKey = this.certificateEntries.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
        Hashtable hashtable;
        if (inputStream == null) {
            return;
        }
        ErasableByteStream erasableByteStreamValidateStream = validateStream(inputStream, cArr);
        synchronized (this.certificateEntries) {
            try {
                DataInputStream dataInputStream = new DataInputStream(erasableByteStreamValidateStream);
                int i = dataInputStream.readInt();
                int i2 = dataInputStream.readInt();
                if (i == -17957139) {
                    CertificateFactory certificateFactoryCreateCertFactory = null;
                    int i3 = 2;
                    if (i2 == 1) {
                        hashtable = null;
                        certificateFactoryCreateCertFactory = createCertFactory("X.509");
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("unable to discern store version");
                        }
                        hashtable = new Hashtable();
                    }
                    int i4 = dataInputStream.readInt();
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = dataInputStream.readInt();
                        if (i6 == 1) {
                            throw new IOException(NOT_IMPLEMENTED_MESSAGE);
                        }
                        if (i6 != i3) {
                            throw new IllegalStateException("unable to discern entry type");
                        }
                        String utf = dataInputStream.readUTF();
                        Date date = new Date(dataInputStream.readLong());
                        if (i2 == i3) {
                            String utf2 = dataInputStream.readUTF();
                            if (hashtable.containsKey(utf2)) {
                                certificateFactoryCreateCertFactory = (CertificateFactory) hashtable.get(utf2);
                            } else {
                                CertificateFactory certificateFactoryCreateCertFactory2 = createCertFactory(utf2);
                                hashtable.put(utf2, certificateFactoryCreateCertFactory2);
                                certificateFactoryCreateCertFactory = certificateFactoryCreateCertFactory2;
                            }
                        }
                        int i7 = dataInputStream.readInt();
                        byte[] bArr = new byte[i7];
                        dataInputStream.readFully(bArr);
                        ErasableByteStream erasableByteStream = new ErasableByteStream(bArr, 0, i7);
                        try {
                            Certificate certificateGenerateCertificate = certificateFactoryCreateCertFactory.generateCertificate(erasableByteStream);
                            if (erasableByteStream.available() != 0) {
                                throw new IOException("password incorrect or store tampered with");
                            }
                            erasableByteStream.m16171erase();
                            this.certificateEntries.put(utf, new BCJKSTrustedCertEntry(date, certificateGenerateCertificate));
                            i5++;
                            i3 = 2;
                        } catch (Throwable th) {
                            erasableByteStream.m16171erase();
                            throw th;
                        }
                    }
                }
                if (erasableByteStreamValidateStream.available() != 0) {
                    throw new IOException("password incorrect or store tampered with");
                }
                erasableByteStreamValidateStream.m16171erase();
            } catch (Throwable th2) {
                erasableByteStreamValidateStream.m16171erase();
                throw th2;
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineProbe(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int i = dataInputStream.readInt();
        int i2 = dataInputStream.readInt();
        return i == -17957139 && (i2 == 1 || i2 == 2);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.certificateEntries.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        throw new IOException(NOT_IMPLEMENTED_MESSAGE);
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
        } else {
            if (loadStoreParameter instanceof BCLoadStoreParameter) {
                engineLoad(((BCLoadStoreParameter) loadStoreParameter).getInputStream(), ParameterUtil.extractPassword(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }
}
