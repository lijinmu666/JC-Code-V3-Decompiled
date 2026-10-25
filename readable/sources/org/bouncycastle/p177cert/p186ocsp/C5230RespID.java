package org.bouncycastle.p177cert.p186ocsp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p164ocsp.ResponderID;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* renamed from: org.bouncycastle.cert.ocsp.RespID */
/* loaded from: classes2.dex */
public class C5230RespID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1, C5103DERNull.INSTANCE);

    /* renamed from: id */
    ResponderID f18896id;

    public C5230RespID(ResponderID responderID) {
        this.f18896id = responderID;
    }

    /* renamed from: equals */
    public boolean m14821equals(Object obj) {
        if (obj instanceof C5230RespID) {
            return this.f18896id.mo14431equals(((C5230RespID) obj).f18896id);
        }
        return false;
    }

    public int hashCode() {
        return this.f18896id.hashCode();
    }

    public ResponderID toASN1Primitive() {
        return this.f18896id;
    }

    public C5230RespID(X500Name x500Name) {
        this.f18896id = new ResponderID(x500Name);
    }

    public C5230RespID(SubjectPublicKeyInfo subjectPublicKeyInfo, DigestCalculator digestCalculator) throws IOException, OCSPException {
        try {
            if (!digestCalculator.getAlgorithmIdentifier().mo14431equals(HASH_SHA1)) {
                throw new IllegalArgumentException("only SHA-1 can be used with RespID - found: " + digestCalculator.getAlgorithmIdentifier().getAlgorithm());
            }
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            outputStream.close();
            this.f18896id = new ResponderID(new DEROctetString(digestCalculator.getDigest()));
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }
}
