package org.bouncycastle.p177cert.p186ocsp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1Exception;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p164ocsp.BasicOCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.p133asn1.p164ocsp.OCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.ResponseBytes;
import org.bouncycastle.p177cert.CertIOException;

/* loaded from: classes2.dex */
public class OCSPResp {
    public static final int INTERNAL_ERROR = 2;
    public static final int MALFORMED_REQUEST = 1;
    public static final int SIG_REQUIRED = 5;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_LATER = 3;
    public static final int UNAUTHORIZED = 6;

    /* renamed from: resp */
    private OCSPResponse f18893resp;

    public OCSPResp(InputStream inputStream) {
        this(new ASN1InputStream(inputStream));
    }

    /* renamed from: equals */
    public boolean m14819equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OCSPResp) {
            return this.f18893resp.mo14431equals(((OCSPResp) obj).f18893resp);
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.f18893resp.getEncoded();
    }

    public Object getResponseObject() throws OCSPException {
        ResponseBytes responseBytes = this.f18893resp.getResponseBytes();
        if (responseBytes == null) {
            return null;
        }
        if (!responseBytes.getResponseType().m14446equals((ASN1Primitive) OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
            return responseBytes.getResponse();
        }
        try {
            return new BasicOCSPResp(BasicOCSPResponse.getInstance(ASN1Primitive.fromByteArray(responseBytes.getResponse().getOctets())));
        } catch (Exception e) {
            throw new OCSPException("problem decoding object: " + e, e);
        }
    }

    public int getStatus() {
        return this.f18893resp.getResponseStatus().getIntValue();
    }

    public int hashCode() {
        return this.f18893resp.hashCode();
    }

    public OCSPResponse toASN1Structure() {
        return this.f18893resp;
    }

    private OCSPResp(ASN1InputStream aSN1InputStream) throws CertIOException {
        try {
            OCSPResponse oCSPResponse = OCSPResponse.getInstance(aSN1InputStream.readObject());
            this.f18893resp = oCSPResponse;
            if (oCSPResponse == null) {
                throw new CertIOException("malformed response: no response data found");
            }
        } catch (ClassCastException e) {
            throw new CertIOException("malformed response: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed response: " + e2.getMessage(), e2);
        } catch (ASN1Exception e3) {
            throw new CertIOException("malformed response: " + e3.getMessage(), e3);
        }
    }

    public OCSPResp(OCSPResponse oCSPResponse) {
        this.f18893resp = oCSPResponse;
    }

    public OCSPResp(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
