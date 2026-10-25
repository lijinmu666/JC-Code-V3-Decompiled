package org.bouncycastle.p133asn1.p138cmp;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p174x509.AttributeCertificate;
import org.bouncycastle.p133asn1.p174x509.Certificate;

/* renamed from: org.bouncycastle.asn1.cmp.OOBCert */
/* loaded from: classes.dex */
public class C5113OOBCert extends CMPCertificate {
    public C5113OOBCert(int i, ASN1Object aSN1Object) {
        super(i, aSN1Object);
    }

    public static C5113OOBCert getInstance(Object obj) {
        if (obj == null || (obj instanceof C5113OOBCert)) {
            return (C5113OOBCert) obj;
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
                throw new IllegalArgumentException("Invalid encoding in OOBCert");
            }
        }
        if (obj instanceof ASN1Sequence) {
            return new C5113OOBCert(Certificate.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(obj);
            return new C5113OOBCert(contextInstance.getTagNo(), contextInstance.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public C5113OOBCert(AttributeCertificate attributeCertificate) {
        super(1, attributeCertificate);
    }

    public static C5113OOBCert getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (aSN1TaggedObject == null) {
            return null;
        }
        if (z) {
            return getInstance((Object) aSN1TaggedObject.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("tag must be explicit");
    }

    public C5113OOBCert(Certificate certificate) {
        super(certificate);
    }
}
