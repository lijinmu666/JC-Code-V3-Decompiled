package org.bouncycastle.p300oer;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Sequence;

/* loaded from: classes2.dex */
public abstract class SwitchIndexer {

    public static class Asn1EncodableVectorIndexer extends SwitchIndexer {
        private final ASN1EncodableVector asn1EncodableVector;

        public Asn1EncodableVectorIndexer(ASN1EncodableVector aSN1EncodableVector) {
            this.asn1EncodableVector = aSN1EncodableVector;
        }

        @Override // org.bouncycastle.p300oer.SwitchIndexer
        /* renamed from: get */
        public ASN1Encodable mo17171get(int i) {
            return this.asn1EncodableVector.m14423get(i);
        }
    }

    public static class Asn1SequenceIndexer extends SwitchIndexer {
        private final ASN1Sequence sequence;

        public Asn1SequenceIndexer(ASN1Sequence aSN1Sequence) {
            this.sequence = aSN1Sequence;
        }

        @Override // org.bouncycastle.p300oer.SwitchIndexer
        /* renamed from: get */
        public ASN1Encodable mo17171get(int i) {
            return this.sequence.getObjectAt(i);
        }
    }

    public static class FixedValueIndexer extends SwitchIndexer {
        private final ASN1Encodable returnValue;

        public FixedValueIndexer(ASN1Encodable aSN1Encodable) {
            this.returnValue = aSN1Encodable;
        }

        @Override // org.bouncycastle.p300oer.SwitchIndexer
        /* renamed from: get */
        public ASN1Encodable mo17171get(int i) {
            return this.returnValue;
        }
    }

    /* renamed from: get */
    public abstract ASN1Encodable mo17171get(int i);
}
