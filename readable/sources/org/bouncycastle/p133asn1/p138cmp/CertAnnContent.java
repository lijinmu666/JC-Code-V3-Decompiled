package org.bouncycastle.p133asn1.p138cmp;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p174x509.AttributeCertificate;
import org.bouncycastle.p133asn1.p174x509.Certificate;

/* loaded from: classes.dex */
public class CertAnnContent extends CMPCertificate {
    public CertAnnContent(int i, ASN1Object aSN1Object) {
        super(i, aSN1Object);
    }

    public static CertAnnContent getInstance(Object obj) {
        if (obj == null || (obj instanceof CertAnnContent)) {
            return (CertAnnContent) obj;
        }
        if (obj instanceof CMPCertificate) {
            try {
                return getInstance((Object) ((CMPCertificate) obj).getEncoded());
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        if (obj instanceof byte[]) {
            try {
                obj = ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Invalid encoding in CertAnnContent");
            }
        }
        if (obj instanceof ASN1Sequence) {
            return new CertAnnContent(Certificate.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(obj);
            return new CertAnnContent(contextInstance.getTagNo(), contextInstance.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertAnnContent(AttributeCertificate attributeCertificate) {
        super(attributeCertificate);
    }

    public static CertAnnContent getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (aSN1TaggedObject == null) {
            return null;
        }
        if (z) {
            return getInstance((Object) aSN1TaggedObject.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("tag must be explicit");
    }

    public CertAnnContent(Certificate certificate) {
        super(certificate);
    }
}
