package org.bouncycastle.p177cert.p183dane;

import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DANEEntry {
    static final int CERT_USAGE = 0;
    public static final int CERT_USAGE_ACCEPT = 3;
    public static final int CERT_USAGE_CA = 0;
    public static final int CERT_USAGE_PKIX_VALIDATE = 1;
    public static final int CERT_USAGE_TRUST_ANCHOR = 2;
    static final int MATCHING_TYPE = 2;
    static final int SELECTOR = 1;
    private final X509CertificateHolder certHolder;
    private final String domainName;

    /* renamed from: flags */
    private final byte[] f18866flags;

    public DANEEntry(String str, byte[] bArr) {
        this(str, C6238Arrays.copyOfRange(bArr, 0, 3), new X509CertificateHolder(C6238Arrays.copyOfRange(bArr, 3, bArr.length)));
    }

    public static boolean isValidCertificate(byte[] bArr) {
        byte b = bArr[0];
        return (b >= 0 || b <= 3) && bArr[1] == 0 && bArr[2] == 0;
    }

    public X509CertificateHolder getCertificate() {
        return this.certHolder;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public byte[] getFlags() {
        return C6238Arrays.m18231clone(this.f18866flags);
    }

    public byte[] getRDATA() {
        byte[] encoded = this.certHolder.getEncoded();
        byte[] bArr = this.f18866flags;
        byte[] bArr2 = new byte[bArr.length + encoded.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(encoded, 0, bArr2, this.f18866flags.length, encoded.length);
        return bArr2;
    }

    public DANEEntry(String str, byte[] bArr, X509CertificateHolder x509CertificateHolder) {
        this.f18866flags = bArr;
        this.domainName = str;
        this.certHolder = x509CertificateHolder;
    }
}
