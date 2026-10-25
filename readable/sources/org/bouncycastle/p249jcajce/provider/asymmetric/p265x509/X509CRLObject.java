package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.IOException;
import java.security.cert.CRLException;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.IssuingDistributionPoint;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class X509CRLObject extends X509CRLImpl {
    private final Object cacheLock;
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CRLInternal internalCRLValue;

    public static class X509CRLException extends CRLException {

        /* renamed from: cause */
        private final Throwable f21656cause;

        public X509CRLException(String str, Throwable th) {
            super(str);
            this.f21656cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f21656cause;
        }

        public X509CRLException(Throwable th) {
            this.f21656cause = th;
        }
    }

    public X509CRLObject(JcaJceHelper jcaJceHelper, CertificateList certificateList) {
        super(jcaJceHelper, certificateList, createSigAlgName(certificateList), createSigAlgParams(certificateList), isIndirectCRL(certificateList));
        this.cacheLock = new Object();
    }

    private static String createSigAlgName(CertificateList certificateList) throws X509CRLException {
        try {
            return X509SignatureUtil.getSignatureName(certificateList.getSignatureAlgorithm());
        } catch (Exception e) {
            throw new X509CRLException("CRL contents invalid: " + e.getMessage(), e);
        }
    }

    private static byte[] createSigAlgParams(CertificateList certificateList) throws CRLException {
        try {
            ASN1Encodable parameters = certificateList.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER);
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private X509CRLInternal getInternalCRL() {
        byte[] encoded;
        X509CRLException x509CRLException;
        X509CRLInternal x509CRLInternal;
        synchronized (this.cacheLock) {
            try {
                X509CRLInternal x509CRLInternal2 = this.internalCRLValue;
                if (x509CRLInternal2 != null) {
                    return x509CRLInternal2;
                }
                try {
                    x509CRLException = null;
                    encoded = this.f21652c.getEncoded(ASN1Encoding.f17902DER);
                } catch (IOException e) {
                    encoded = null;
                    x509CRLException = new X509CRLException(e);
                }
                X509CRLInternal x509CRLInternal3 = new X509CRLInternal(this.bcHelper, this.f21652c, this.sigAlgName, this.sigAlgParams, this.isIndirect, encoded, x509CRLException);
                synchronized (this.cacheLock) {
                    try {
                        if (this.internalCRLValue == null) {
                            this.internalCRLValue = x509CRLInternal3;
                        }
                        x509CRLInternal = this.internalCRLValue;
                    } finally {
                    }
                }
                return x509CRLInternal;
            } finally {
            }
        }
    }

    private static boolean isIndirectCRL(CertificateList certificateList) throws ExtCRLException {
        try {
            byte[] extensionOctets = X509CRLImpl.getExtensionOctets(certificateList, Extension.issuingDistributionPoint);
            if (extensionOctets == null) {
                return false;
            }
            return IssuingDistributionPoint.getInstance(extensionOctets).isIndirectCRL();
        } catch (Exception e) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }

    @Override // java.security.cert.X509CRL
    public boolean equals(Object obj) {
        X509CRLInternal internalCRL;
        ASN1BitString signature;
        if (this == obj) {
            return true;
        }
        if (obj instanceof X509CRLObject) {
            X509CRLObject x509CRLObject = (X509CRLObject) obj;
            if (this.hashValueSet && x509CRLObject.hashValueSet) {
                if (this.hashValue != x509CRLObject.hashValue) {
                    return false;
                }
            } else if ((this.internalCRLValue == null || x509CRLObject.internalCRLValue == null) && (signature = this.f21652c.getSignature()) != null && !signature.m14446equals((ASN1Primitive) x509CRLObject.f21652c.getSignature())) {
                return false;
            }
            internalCRL = getInternalCRL();
            obj = x509CRLObject.getInternalCRL();
        } else {
            internalCRL = getInternalCRL();
        }
        return internalCRL.equals(obj);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(getInternalCRL().getEncoded());
    }

    @Override // java.security.cert.X509CRL
    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCRL().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }
}
