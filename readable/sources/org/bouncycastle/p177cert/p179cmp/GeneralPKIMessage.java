package org.bouncycastle.p177cert.p179cmp;

import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.PKIHeader;
import org.bouncycastle.p133asn1.p138cmp.PKIMessage;
import org.bouncycastle.p177cert.CertIOException;

/* loaded from: classes2.dex */
public class GeneralPKIMessage {
    private final PKIMessage pkiMessage;

    public GeneralPKIMessage(PKIMessage pKIMessage) {
        this.pkiMessage = pKIMessage;
    }

    private static PKIMessage parseBytes(byte[] bArr) throws CertIOException {
        try {
            return PKIMessage.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: getBody */
    public C5114PKIBody m14761getBody() {
        return this.pkiMessage.m14521getBody();
    }

    public PKIHeader getHeader() {
        return this.pkiMessage.getHeader();
    }

    public boolean hasProtection() {
        return this.pkiMessage.getProtection() != null;
    }

    public PKIMessage toASN1Structure() {
        return this.pkiMessage;
    }

    public GeneralPKIMessage(byte[] bArr) {
        this(parseBytes(bArr));
    }
}
