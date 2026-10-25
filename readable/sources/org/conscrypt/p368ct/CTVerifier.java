package org.conscrypt.p368ct;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.NativeCrypto;
import org.conscrypt.OpenSSLX509Certificate;
import org.conscrypt.p368ct.SignedCertificateTimestamp;
import org.conscrypt.p368ct.VerifiedSCT;

/* loaded from: classes2.dex */
public class CTVerifier {

    /* renamed from: store */
    private final CTLogStore f24469store;

    public CTVerifier(CTLogStore cTLogStore) {
        this.f24469store = cTLogStore;
    }

    private List<SignedCertificateTimestamp> getSCTsFromOCSPResponse(byte[] bArr, OpenSSLX509Certificate[] openSSLX509CertificateArr) {
        if (bArr == null || openSSLX509CertificateArr.length < 2) {
            return Collections.emptyList();
        }
        byte[] bArr2 = NativeCrypto.get_ocsp_single_extension(bArr, CTConstants.OCSP_SCT_LIST_OID, openSSLX509CertificateArr[0].getContext(), openSSLX509CertificateArr[0], openSSLX509CertificateArr[1].getContext(), openSSLX509CertificateArr[1]);
        if (bArr2 == null) {
            return Collections.emptyList();
        }
        try {
            return getSCTsFromSCTList(Serialization.readDEROctetString(Serialization.readDEROctetString(bArr2)), SignedCertificateTimestamp.EnumC6340Origin.OCSP_RESPONSE);
        } catch (SerializationException unused) {
            return Collections.emptyList();
        }
    }

    private static List<SignedCertificateTimestamp> getSCTsFromSCTList(byte[] bArr, SignedCertificateTimestamp.EnumC6340Origin enumC6340Origin) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        try {
            byte[][] list = Serialization.readList(bArr, 2, 2);
            ArrayList arrayList = new ArrayList();
            for (byte[] bArr2 : list) {
                try {
                    arrayList.add(SignedCertificateTimestamp.m18528decode(bArr2, enumC6340Origin));
                } catch (SerializationException unused) {
                }
            }
            return arrayList;
        } catch (SerializationException unused2) {
            return Collections.emptyList();
        }
    }

    private List<SignedCertificateTimestamp> getSCTsFromTLSExtension(byte[] bArr) {
        return getSCTsFromSCTList(bArr, SignedCertificateTimestamp.EnumC6340Origin.TLS_EXTENSION);
    }

    private List<SignedCertificateTimestamp> getSCTsFromX509Extension(OpenSSLX509Certificate openSSLX509Certificate) {
        byte[] extensionValue = openSSLX509Certificate.getExtensionValue(CTConstants.X509_SCT_LIST_OID);
        if (extensionValue == null) {
            return Collections.emptyList();
        }
        try {
            return getSCTsFromSCTList(Serialization.readDEROctetString(Serialization.readDEROctetString(extensionValue)), SignedCertificateTimestamp.EnumC6340Origin.EMBEDDED);
        } catch (SerializationException unused) {
            return Collections.emptyList();
        }
    }

    private void markSCTsAsInvalid(List<SignedCertificateTimestamp> list, CTVerificationResult cTVerificationResult) {
        Iterator<SignedCertificateTimestamp> it = list.iterator();
        while (it.hasNext()) {
            cTVerificationResult.m18515add(new VerifiedSCT(it.next(), VerifiedSCT.EnumC6342Status.INVALID_SCT));
        }
    }

    private void verifyEmbeddedSCTs(List<SignedCertificateTimestamp> list, OpenSSLX509Certificate[] openSSLX509CertificateArr, CTVerificationResult cTVerificationResult) throws NoSuchAlgorithmException {
        CertificateEntry certificateEntryCreateForPrecertificate;
        if (list.isEmpty()) {
            return;
        }
        if (openSSLX509CertificateArr.length >= 2) {
            try {
                certificateEntryCreateForPrecertificate = CertificateEntry.createForPrecertificate(openSSLX509CertificateArr[0], openSSLX509CertificateArr[1]);
            } catch (CertificateException unused) {
            }
        } else {
            certificateEntryCreateForPrecertificate = null;
        }
        if (certificateEntryCreateForPrecertificate == null) {
            markSCTsAsInvalid(list, cTVerificationResult);
            return;
        }
        for (SignedCertificateTimestamp signedCertificateTimestamp : list) {
            cTVerificationResult.m18515add(new VerifiedSCT(signedCertificateTimestamp, verifySingleSCT(signedCertificateTimestamp, certificateEntryCreateForPrecertificate)));
        }
    }

    private void verifyExternalSCTs(List<SignedCertificateTimestamp> list, OpenSSLX509Certificate openSSLX509Certificate, CTVerificationResult cTVerificationResult) {
        if (list.isEmpty()) {
            return;
        }
        try {
            CertificateEntry certificateEntryCreateForX509Certificate = CertificateEntry.createForX509Certificate(openSSLX509Certificate);
            for (SignedCertificateTimestamp signedCertificateTimestamp : list) {
                cTVerificationResult.m18515add(new VerifiedSCT(signedCertificateTimestamp, verifySingleSCT(signedCertificateTimestamp, certificateEntryCreateForX509Certificate)));
            }
        } catch (CertificateException unused) {
            markSCTsAsInvalid(list, cTVerificationResult);
        }
    }

    private VerifiedSCT.EnumC6342Status verifySingleSCT(SignedCertificateTimestamp signedCertificateTimestamp, CertificateEntry certificateEntry) {
        CTLogInfo knownLog = this.f24469store.getKnownLog(signedCertificateTimestamp.getLogID());
        return knownLog == null ? VerifiedSCT.EnumC6342Status.UNKNOWN_LOG : knownLog.verifySingleSCT(signedCertificateTimestamp, certificateEntry);
    }

    public CTVerificationResult verifySignedCertificateTimestamps(List<X509Certificate> list, byte[] bArr, byte[] bArr2) {
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[list.size()];
        Iterator<X509Certificate> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            openSSLX509CertificateArr[i] = OpenSSLX509Certificate.fromCertificate(it.next());
            i++;
        }
        return verifySignedCertificateTimestamps(openSSLX509CertificateArr, bArr, bArr2);
    }

    public CTVerificationResult verifySignedCertificateTimestamps(OpenSSLX509Certificate[] openSSLX509CertificateArr, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        if (openSSLX509CertificateArr.length != 0) {
            OpenSSLX509Certificate openSSLX509Certificate = openSSLX509CertificateArr[0];
            CTVerificationResult cTVerificationResult = new CTVerificationResult();
            verifyExternalSCTs(getSCTsFromTLSExtension(bArr), openSSLX509Certificate, cTVerificationResult);
            verifyExternalSCTs(getSCTsFromOCSPResponse(bArr2, openSSLX509CertificateArr), openSSLX509Certificate, cTVerificationResult);
            verifyEmbeddedSCTs(getSCTsFromX509Extension(openSSLX509CertificateArr[0]), openSSLX509CertificateArr, cTVerificationResult);
            return cTVerificationResult;
        }
        throw new IllegalArgumentException("Chain of certificates mustn't be empty.");
    }
}
