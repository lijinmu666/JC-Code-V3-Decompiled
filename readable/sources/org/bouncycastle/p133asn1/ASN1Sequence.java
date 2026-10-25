package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Iterable;

/* loaded from: classes.dex */
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17938TYPE = new ASN1UniversalType(ASN1Sequence.class, 16) { // from class: org.bouncycastle.asn1.ASN1Sequence.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence;
        }
    };
    ASN1Encodable[] elements;

    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Sequence) {
                return (ASN1Sequence) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1Sequence) f17938TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Sequence getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Sequence) f17938TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
        int iMo14450size = mo14450size();
        if (aSN1Sequence.mo14450size() != iMo14450size) {
            return false;
        }
        for (int i = 0; i < iMo14450size; i++) {
            ASN1Primitive aSN1Primitive2 = this.elements[i].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = aSN1Sequence.elements[i].toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.asn1Equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return true;
    }

    public ASN1BitString[] getConstructedBitStrings() {
        int iMo14450size = mo14450size();
        ASN1BitString[] aSN1BitStringArr = new ASN1BitString[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            aSN1BitStringArr[i] = ASN1BitString.getInstance(this.elements[i]);
        }
        return aSN1BitStringArr;
    }

    public ASN1OctetString[] getConstructedOctetStrings() {
        int iMo14450size = mo14450size();
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            aSN1OctetStringArr[i] = ASN1OctetString.getInstance(this.elements[i]);
        }
        return aSN1OctetStringArr;
    }

    public ASN1Encodable getObjectAt(int i) {
        return this.elements[i];
    }

    public Enumeration getObjects() {
        return new Enumeration() { // from class: org.bouncycastle.asn1.ASN1Sequence.2

            /* renamed from: pos */
            private int f17939pos = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f17939pos < ASN1Sequence.this.elements.length;
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                int i = this.f17939pos;
                ASN1Encodable[] aSN1EncodableArr = ASN1Sequence.this.elements;
                if (i >= aSN1EncodableArr.length) {
                    throw new NoSuchElementException();
                }
                this.f17939pos = i + 1;
                return aSN1EncodableArr[i];
            }
        };
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        int length = this.elements.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ this.elements[length].toASN1Primitive().hashCode();
        }
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new C6238Arrays.Iterator(this.elements);
    }

    /* renamed from: parser */
    public ASN1SequenceParser m14449parser() {
        final int iMo14450size = mo14450size();
        return new ASN1SequenceParser(this) { // from class: org.bouncycastle.asn1.ASN1Sequence.3

            /* renamed from: pos */
            private int f17941pos = 0;

            /* renamed from: this$0 */
            final /* synthetic */ ASN1Sequence f17942this$0;

            {
                this.f17942this$0 = this;
            }

            @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
            public ASN1Primitive getLoadedObject() {
                return this.f17942this$0;
            }

            @Override // org.bouncycastle.p133asn1.ASN1SequenceParser
            public ASN1Encodable readObject() {
                int i = iMo14450size;
                int i2 = this.f17941pos;
                if (i == i2) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = this.f17942this$0.elements;
                this.f17941pos = i2 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
                return aSN1Encodable instanceof ASN1Sequence ? ((ASN1Sequence) aSN1Encodable).m14449parser() : aSN1Encodable instanceof AbstractC5093ASN1Set ? ((AbstractC5093ASN1Set) aSN1Encodable).m14453parser() : aSN1Encodable;
            }

            @Override // org.bouncycastle.p133asn1.ASN1Encodable
            public ASN1Primitive toASN1Primitive() {
                return this.f17942this$0;
            }
        };
    }

    /* renamed from: size */
    public int mo14450size() {
        return this.elements.length;
    }

    public abstract ASN1BitString toASN1BitString();

    public abstract ASN1External toASN1External();

    public abstract ASN1OctetString toASN1OctetString();

    public abstract AbstractC5093ASN1Set toASN1Set();

    /* renamed from: toArray */
    public ASN1Encodable[] mo14451toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
    }

    public String toString() {
        int iMo14450size = mo14450size();
        if (iMo14450size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            sb.append(this.elements[i]);
            i++;
            if (i >= iMo14450size) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
        }
    }

    public ASN1Sequence(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.elements = new ASN1Encodable[]{aSN1Encodable};
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Sequence) f17938TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public ASN1Sequence(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element1' cannot be null");
        }
        if (aSN1Encodable2 == null) {
            throw new NullPointerException("'element2' cannot be null");
        }
        this.elements = new ASN1Encodable[]{aSN1Encodable, aSN1Encodable2};
    }

    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.elements = aSN1EncodableVector.takeElements();
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        if (C6238Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        this.elements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        this.elements = z ? ASN1EncodableVector.cloneElements(aSN1EncodableArr) : aSN1EncodableArr;
    }
}
