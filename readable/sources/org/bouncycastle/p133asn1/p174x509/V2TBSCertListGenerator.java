package org.bouncycastle.p133asn1.p174x509;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class V2TBSCertListGenerator {

    /* renamed from: reasons */
    private static final ASN1Sequence[] f18706reasons = {createReasonExtension(0), createReasonExtension(1), createReasonExtension(2), createReasonExtension(3), createReasonExtension(4), createReasonExtension(5), createReasonExtension(6), createReasonExtension(7), createReasonExtension(8), createReasonExtension(9), createReasonExtension(10)};

    /* renamed from: issuer */
    private X500Name f18707issuer;
    private AlgorithmIdentifier signature;
    private C5194Time thisUpdate;

    /* renamed from: version */
    private ASN1Integer f18708version = ASN1Integer.f17918ONE;
    private C5194Time nextUpdate = null;
    private Extensions extensions = null;
    private ASN1EncodableVector crlentries = new ASN1EncodableVector();

    private static ASN1Sequence createInvalidityDateExtension(ASN1GeneralizedTime aSN1GeneralizedTime) {
        try {
            return new DERSequence(Extension.invalidityDate, new DEROctetString(aSN1GeneralizedTime.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("error encoding reason: " + e);
        }
    }

    private static ASN1Sequence createReasonExtension(int i) {
        try {
            return new DERSequence(Extension.reasonCode, new DEROctetString(CRLReason.m14676lookup(i).getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("error encoding reason: " + e);
        }
    }

    private ASN1Sequence generateTBSCertStructure() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.m14420add(this.f18708version);
        AlgorithmIdentifier algorithmIdentifier = this.signature;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.m14420add(algorithmIdentifier);
        }
        aSN1EncodableVector.m14420add(this.f18707issuer);
        aSN1EncodableVector.m14420add(this.thisUpdate);
        C5194Time c5194Time = this.nextUpdate;
        if (c5194Time != null) {
            aSN1EncodableVector.m14420add(c5194Time);
        }
        if (this.crlentries.m14424size() != 0) {
            aSN1EncodableVector.m14420add(new DERSequence(this.crlentries));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private void internalAddCRLEntry(ASN1Integer aSN1Integer, C5194Time c5194Time, ASN1Sequence aSN1Sequence) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(aSN1Integer);
        aSN1EncodableVector.m14420add(c5194Time);
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, ASN1UTCTime aSN1UTCTime, int i) {
        addCRLEntry(aSN1Integer, new C5194Time(aSN1UTCTime), i);
    }

    public ASN1Sequence generatePreTBSCertList() {
        if (this.signature != null) {
            throw new IllegalStateException("signature should not be set in PreTBSCertList generator");
        }
        if (this.f18707issuer == null || this.thisUpdate == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 PreTBSCertList generator");
        }
        return generateTBSCertStructure();
    }

    public TBSCertList generateTBSCertList() {
        if (this.signature == null || this.f18707issuer == null || this.thisUpdate == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 TBSCertList generator");
        }
        return new TBSCertList(generateTBSCertStructure());
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public void setIssuer(X500Name x500Name) {
        this.f18707issuer = x500Name;
    }

    public void setNextUpdate(ASN1UTCTime aSN1UTCTime) {
        this.nextUpdate = new C5194Time(aSN1UTCTime);
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setThisUpdate(ASN1UTCTime aSN1UTCTime) {
        this.thisUpdate = new C5194Time(aSN1UTCTime);
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, C5194Time c5194Time, int i) {
        addCRLEntry(aSN1Integer, c5194Time, i, null);
    }

    @Deprecated
    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.f18707issuer = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setNextUpdate(C5194Time c5194Time) {
        this.nextUpdate = c5194Time;
    }

    public void setThisUpdate(C5194Time c5194Time) {
        this.thisUpdate = c5194Time;
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, C5194Time c5194Time, int i, ASN1GeneralizedTime aSN1GeneralizedTime) {
        DERSequence dERSequence;
        ASN1Sequence aSN1SequenceCreateReasonExtension;
        if (i != 0) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
            ASN1Sequence[] aSN1SequenceArr = f18706reasons;
            if (i >= aSN1SequenceArr.length) {
                aSN1SequenceCreateReasonExtension = createReasonExtension(i);
            } else {
                if (i < 0) {
                    throw new IllegalArgumentException("invalid reason value: " + i);
                }
                aSN1SequenceCreateReasonExtension = aSN1SequenceArr[i];
            }
            aSN1EncodableVector.m14420add(aSN1SequenceCreateReasonExtension);
            if (aSN1GeneralizedTime != null) {
                aSN1EncodableVector.m14420add(createInvalidityDateExtension(aSN1GeneralizedTime));
            }
            dERSequence = new DERSequence(aSN1EncodableVector);
        } else {
            if (aSN1GeneralizedTime == null) {
                addCRLEntry(aSN1Integer, c5194Time, (Extensions) null);
                return;
            }
            dERSequence = new DERSequence(createInvalidityDateExtension(aSN1GeneralizedTime));
        }
        internalAddCRLEntry(aSN1Integer, c5194Time, dERSequence);
    }

    public void addCRLEntry(ASN1Integer aSN1Integer, C5194Time c5194Time, Extensions extensions) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(aSN1Integer);
        aSN1EncodableVector.m14420add(c5194Time);
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        addCRLEntry(new DERSequence(aSN1EncodableVector));
    }

    public void addCRLEntry(ASN1Sequence aSN1Sequence) {
        this.crlentries.m14420add(aSN1Sequence);
    }
}
