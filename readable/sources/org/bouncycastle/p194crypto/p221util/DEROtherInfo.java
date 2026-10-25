package org.bouncycastle.p194crypto.p221util;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class DEROtherInfo {
    private final DERSequence sequence;

    /* renamed from: org.bouncycastle.crypto.util.DEROtherInfo$Builder */
    public static final class C5403Builder {
        private final AlgorithmIdentifier algorithmID;
        private final ASN1OctetString partyUInfo;
        private final ASN1OctetString partyVInfo;
        private ASN1TaggedObject suppPrivInfo;
        private ASN1TaggedObject suppPubInfo;

        public C5403Builder(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
            this.algorithmID = algorithmIdentifier;
            this.partyUInfo = C5404DerUtil.getOctetString(bArr);
            this.partyVInfo = C5404DerUtil.getOctetString(bArr2);
        }

        /* renamed from: build */
        public DEROtherInfo m15924build() {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.m14420add(this.algorithmID);
            aSN1EncodableVector.m14420add(this.partyUInfo);
            aSN1EncodableVector.m14420add(this.partyVInfo);
            ASN1TaggedObject aSN1TaggedObject = this.suppPubInfo;
            if (aSN1TaggedObject != null) {
                aSN1EncodableVector.m14420add(aSN1TaggedObject);
            }
            ASN1TaggedObject aSN1TaggedObject2 = this.suppPrivInfo;
            if (aSN1TaggedObject2 != null) {
                aSN1EncodableVector.m14420add(aSN1TaggedObject2);
            }
            return new DEROtherInfo(new DERSequence(aSN1EncodableVector));
        }

        public C5403Builder withSuppPrivInfo(byte[] bArr) {
            this.suppPrivInfo = new DERTaggedObject(false, 1, (ASN1Encodable) C5404DerUtil.getOctetString(bArr));
            return this;
        }

        public C5403Builder withSuppPubInfo(byte[] bArr) {
            this.suppPubInfo = new DERTaggedObject(false, 0, (ASN1Encodable) C5404DerUtil.getOctetString(bArr));
            return this;
        }
    }

    private DEROtherInfo(DERSequence dERSequence) {
        this.sequence = dERSequence;
    }

    public byte[] getEncoded() {
        return this.sequence.getEncoded();
    }
}
