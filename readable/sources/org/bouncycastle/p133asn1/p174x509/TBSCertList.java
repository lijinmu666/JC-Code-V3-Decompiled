package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class TBSCertList extends ASN1Object {
    Extensions crlExtensions;

    /* renamed from: issuer */
    X500Name f18683issuer;
    C5194Time nextUpdate;
    ASN1Sequence revokedCertificates;
    AlgorithmIdentifier signature;
    C5194Time thisUpdate;

    /* renamed from: version */
    ASN1Integer f18684version;

    public static class CRLEntry extends ASN1Object {
        Extensions crlEntryExtensions;

        /* renamed from: seq */
        ASN1Sequence f18685seq;

        private CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.mo14450size() >= 2 && aSN1Sequence.mo14450size() <= 3) {
                this.f18685seq = aSN1Sequence;
                return;
            }
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }

        public static CRLEntry getInstance(Object obj) {
            if (obj instanceof CRLEntry) {
                return (CRLEntry) obj;
            }
            if (obj != null) {
                return new CRLEntry(ASN1Sequence.getInstance(obj));
            }
            return null;
        }

        public Extensions getExtensions() {
            if (this.crlEntryExtensions == null && this.f18685seq.mo14450size() == 3) {
                this.crlEntryExtensions = Extensions.getInstance(this.f18685seq.getObjectAt(2));
            }
            return this.crlEntryExtensions;
        }

        public C5194Time getRevocationDate() {
            return C5194Time.getInstance(this.f18685seq.getObjectAt(1));
        }

        public ASN1Integer getUserCertificate() {
            return ASN1Integer.getInstance(this.f18685seq.getObjectAt(0));
        }

        public boolean hasExtensions() {
            return this.f18685seq.mo14450size() == 3;
        }

        @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.f18685seq;
        }
    }

    public static class EmptyEnumeration implements Enumeration {
        private EmptyEnumeration() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public static class RevokedCertificatesEnumeration implements Enumeration {

        /* renamed from: en */
        private final Enumeration f18686en;

        public RevokedCertificatesEnumeration(Enumeration enumeration) {
            this.f18686en = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f18686en.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return CRLEntry.getInstance(this.f18686en.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 3 || aSN1Sequence.mo14450size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.f18684version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.f18684version = null;
        }
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        this.f18683issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(i + 1));
        int i2 = i + 3;
        this.thisUpdate = C5194Time.getInstance(aSN1Sequence.getObjectAt(i + 2));
        if (i2 < aSN1Sequence.mo14450size() && ((aSN1Sequence.getObjectAt(i2) instanceof ASN1UTCTime) || (aSN1Sequence.getObjectAt(i2) instanceof ASN1GeneralizedTime) || (aSN1Sequence.getObjectAt(i2) instanceof C5194Time))) {
            this.nextUpdate = C5194Time.getInstance(aSN1Sequence.getObjectAt(i2));
            i2 = i + 4;
        }
        if (i2 < aSN1Sequence.mo14450size() && !(aSN1Sequence.getObjectAt(i2) instanceof ASN1TaggedObject)) {
            this.revokedCertificates = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i2));
            i2++;
        }
        if (i2 >= aSN1Sequence.mo14450size() || !(aSN1Sequence.getObjectAt(i2) instanceof ASN1TaggedObject)) {
            return;
        }
        this.crlExtensions = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), true));
    }

    public static TBSCertList getInstance(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        if (obj != null) {
            return new TBSCertList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.crlExtensions;
    }

    public X500Name getIssuer() {
        return this.f18683issuer;
    }

    public C5194Time getNextUpdate() {
        return this.nextUpdate;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        return aSN1Sequence == null ? new EmptyEnumeration() : new RevokedCertificatesEnumeration(aSN1Sequence.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence == null) {
            return new CRLEntry[0];
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CRLEntry[] cRLEntryArr = new CRLEntry[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            cRLEntryArr[i] = CRLEntry.getInstance(this.revokedCertificates.getObjectAt(i));
        }
        return cRLEntryArr;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public C5194Time getThisUpdate() {
        return this.thisUpdate;
    }

    public ASN1Integer getVersion() {
        return this.f18684version;
    }

    public int getVersionNumber() {
        ASN1Integer aSN1Integer = this.f18684version;
        if (aSN1Integer == null) {
            return 1;
        }
        return aSN1Integer.intValueExact() + 1;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        ASN1Integer aSN1Integer = this.f18684version;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        aSN1EncodableVector.m14420add(this.signature);
        aSN1EncodableVector.m14420add(this.f18683issuer);
        aSN1EncodableVector.m14420add(this.thisUpdate);
        C5194Time c5194Time = this.nextUpdate;
        if (c5194Time != null) {
            aSN1EncodableVector.m14420add(c5194Time);
        }
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        Extensions extensions = this.crlExtensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static TBSCertList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
