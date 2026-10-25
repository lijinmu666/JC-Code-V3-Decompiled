package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Iterable;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.asn1.ASN1Set */
/* loaded from: classes.dex */
public abstract class AbstractC5093ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17943TYPE = new ASN1UniversalType(AbstractC5093ASN1Set.class, 17) { // from class: org.bouncycastle.asn1.ASN1Set.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1Set();
        }
    };
    protected final ASN1Encodable[] elements;
    protected ASN1Encodable[] sortedElements;

    public AbstractC5093ASN1Set() {
        ASN1Encodable[] aSN1EncodableArr = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.elements = aSN1EncodableArr;
        this.sortedElements = aSN1EncodableArr;
    }

    private static byte[] getDEREncoded(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static AbstractC5093ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof AbstractC5093ASN1Set)) {
            return (AbstractC5093ASN1Set) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof AbstractC5093ASN1Set) {
                return (AbstractC5093ASN1Set) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (AbstractC5093ASN1Set) f17943TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static AbstractC5093ASN1Set getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (AbstractC5093ASN1Set) f17943TYPE.getTagged(aSN1TaggedObject, z);
    }

    private static boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        int i = bArr[0] & 223;
        int i2 = bArr2[0] & 223;
        if (i != i2) {
            return i < i2;
        }
        int iMin = Math.min(bArr.length, bArr2.length) - 1;
        for (int i3 = 1; i3 < iMin; i3++) {
            byte b = bArr[i3];
            byte b2 = bArr2[i3];
            if (b != b2) {
                return (b & C1126UByte.MAX_VALUE) < (b2 & C1126UByte.MAX_VALUE);
            }
        }
        return (bArr[iMin] & C1126UByte.MAX_VALUE) <= (bArr2[iMin] & C1126UByte.MAX_VALUE);
    }

    /* renamed from: sort */
    private static void m14452sort(ASN1Encodable[] aSN1EncodableArr) {
        int i;
        int length = aSN1EncodableArr.length;
        if (length < 2) {
            return;
        }
        ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
        ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
        byte[] dEREncoded = getDEREncoded(aSN1Encodable);
        byte[] dEREncoded2 = getDEREncoded(aSN1Encodable2);
        if (lessThanOrEqual(dEREncoded2, dEREncoded)) {
            aSN1Encodable2 = aSN1Encodable;
            aSN1Encodable = aSN1Encodable2;
            dEREncoded2 = dEREncoded;
            dEREncoded = dEREncoded2;
        }
        for (int i2 = 2; i2 < length; i2++) {
            ASN1Encodable aSN1Encodable3 = aSN1EncodableArr[i2];
            byte[] dEREncoded3 = getDEREncoded(aSN1Encodable3);
            if (lessThanOrEqual(dEREncoded2, dEREncoded3)) {
                aSN1EncodableArr[i2 - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable2;
                dEREncoded = dEREncoded2;
                aSN1Encodable2 = aSN1Encodable3;
                dEREncoded2 = dEREncoded3;
            } else if (lessThanOrEqual(dEREncoded, dEREncoded3)) {
                aSN1EncodableArr[i2 - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable3;
                dEREncoded = dEREncoded3;
            } else {
                int i3 = i2 - 1;
                while (true) {
                    i = i3 - 1;
                    if (i <= 0) {
                        break;
                    }
                    ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i3 - 2];
                    if (lessThanOrEqual(getDEREncoded(aSN1Encodable4), dEREncoded3)) {
                        break;
                    }
                    aSN1EncodableArr[i] = aSN1Encodable4;
                    i3 = i;
                }
                aSN1EncodableArr[i] = aSN1Encodable3;
            }
        }
        aSN1EncodableArr[length - 2] = aSN1Encodable;
        aSN1EncodableArr[length - 1] = aSN1Encodable2;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof AbstractC5093ASN1Set)) {
            return false;
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = (AbstractC5093ASN1Set) aSN1Primitive;
        int iM14454size = m14454size();
        if (abstractC5093ASN1Set.m14454size() != iM14454size) {
            return false;
        }
        C5104DERSet c5104DERSet = (C5104DERSet) toDERObject();
        C5104DERSet c5104DERSet2 = (C5104DERSet) abstractC5093ASN1Set.toDERObject();
        for (int i = 0; i < iM14454size; i++) {
            ASN1Primitive aSN1Primitive2 = c5104DERSet.elements[i].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = c5104DERSet2.elements[i].toASN1Primitive();
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

    public ASN1Encodable getObjectAt(int i) {
        return this.elements[i];
    }

    public Enumeration getObjects() {
        return new Enumeration() { // from class: org.bouncycastle.asn1.ASN1Set.2

            /* renamed from: pos */
            private int f17944pos = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f17944pos < AbstractC5093ASN1Set.this.elements.length;
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                int i = this.f17944pos;
                ASN1Encodable[] aSN1EncodableArr = AbstractC5093ASN1Set.this.elements;
                if (i >= aSN1EncodableArr.length) {
                    throw new NoSuchElementException();
                }
                this.f17944pos = i + 1;
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
            iHashCode += this.elements[length].toASN1Primitive().hashCode();
        }
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new C6238Arrays.Iterator(m14455toArray());
    }

    /* renamed from: parser */
    public ASN1SetParser m14453parser() {
        final int iM14454size = m14454size();
        return new ASN1SetParser(this) { // from class: org.bouncycastle.asn1.ASN1Set.3

            /* renamed from: pos */
            private int f17946pos = 0;

            /* renamed from: this$0 */
            final /* synthetic */ AbstractC5093ASN1Set f17947this$0;

            {
                this.f17947this$0 = this;
            }

            @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
            public ASN1Primitive getLoadedObject() {
                return this.f17947this$0;
            }

            @Override // org.bouncycastle.p133asn1.ASN1SetParser
            public ASN1Encodable readObject() {
                int i = iM14454size;
                int i2 = this.f17946pos;
                if (i == i2) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = this.f17947this$0.elements;
                this.f17946pos = i2 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
                return aSN1Encodable instanceof ASN1Sequence ? ((ASN1Sequence) aSN1Encodable).m14449parser() : aSN1Encodable instanceof AbstractC5093ASN1Set ? ((AbstractC5093ASN1Set) aSN1Encodable).m14453parser() : aSN1Encodable;
            }

            @Override // org.bouncycastle.p133asn1.ASN1Encodable
            public ASN1Primitive toASN1Primitive() {
                return this.f17947this$0;
            }
        };
    }

    /* renamed from: size */
    public int m14454size() {
        return this.elements.length;
    }

    /* renamed from: toArray */
    public ASN1Encodable[] m14455toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        if (this.sortedElements == null) {
            ASN1Encodable[] aSN1EncodableArr = (ASN1Encodable[]) this.elements.clone();
            this.sortedElements = aSN1EncodableArr;
            m14452sort(aSN1EncodableArr);
        }
        return new C5104DERSet(true, this.sortedElements);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new C5105DLSet(this.elements, this.sortedElements);
    }

    public String toString() {
        int iM14454size = m14454size();
        if (iM14454size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            sb.append(this.elements[i]);
            i++;
            if (i >= iM14454size) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
        }
    }

    public AbstractC5093ASN1Set(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        ASN1Encodable[] aSN1EncodableArr = {aSN1Encodable};
        this.elements = aSN1EncodableArr;
        this.sortedElements = aSN1EncodableArr;
    }

    public static AbstractC5093ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (AbstractC5093ASN1Set) f17943TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public AbstractC5093ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        ASN1Encodable[] aSN1EncodableArrTakeElements;
        if (aSN1EncodableVector == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        if (!z || aSN1EncodableVector.m14424size() < 2) {
            aSN1EncodableArrTakeElements = aSN1EncodableVector.takeElements();
        } else {
            aSN1EncodableArrTakeElements = aSN1EncodableVector.copyElements();
            m14452sort(aSN1EncodableArrTakeElements);
        }
        this.elements = aSN1EncodableArrTakeElements;
        if (!z && aSN1EncodableArrTakeElements.length >= 2) {
            aSN1EncodableArrTakeElements = null;
        }
        this.sortedElements = aSN1EncodableArrTakeElements;
    }

    public AbstractC5093ASN1Set(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        this.elements = aSN1EncodableArr;
        if (!z && aSN1EncodableArr.length >= 2) {
            aSN1EncodableArr = null;
        }
        this.sortedElements = aSN1EncodableArr;
    }

    public AbstractC5093ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        if (C6238Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        ASN1Encodable[] aSN1EncodableArrCloneElements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
        if (z && aSN1EncodableArrCloneElements.length >= 2) {
            m14452sort(aSN1EncodableArrCloneElements);
        }
        this.elements = aSN1EncodableArrCloneElements;
        if (!z && aSN1EncodableArrCloneElements.length >= 2) {
            aSN1EncodableArr = null;
        }
        this.sortedElements = aSN1EncodableArr;
    }

    public AbstractC5093ASN1Set(ASN1Encodable[] aSN1EncodableArr, ASN1Encodable[] aSN1EncodableArr2) {
        this.elements = aSN1EncodableArr;
        this.sortedElements = aSN1EncodableArr2;
    }
}
