package org.bouncycastle.p133asn1;

import java.io.IOException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    private static final int DECLARED_EXPLICIT = 1;
    private static final int DECLARED_IMPLICIT = 2;
    private static final int PARSED_EXPLICIT = 3;
    private static final int PARSED_IMPLICIT = 4;
    final int explicitness;

    /* renamed from: obj */
    final ASN1Encodable f17952obj;
    final int tagClass;

    /* renamed from: tagNo */
    final int f17953tagNo;

    public ASN1TaggedObject(int i, int i2, int i3, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'obj' cannot be null");
        }
        if (i2 == 0 || (i2 & 192) != i2) {
            throw new IllegalArgumentException("invalid tag class: " + i2);
        }
        this.explicitness = aSN1Encodable instanceof ASN1Choice ? 1 : i;
        this.tagClass = i2;
        this.f17953tagNo = i3;
        this.f17952obj = aSN1Encodable;
    }

    private static ASN1TaggedObject checkInstance(Object obj) {
        if (obj != null) {
            return getInstance(obj);
        }
        throw new NullPointerException("'obj' cannot be null");
    }

    private static ASN1TaggedObject checkedCast(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: " + aSN1Primitive.getClass().getName());
    }

    public static ASN1Primitive createConstructedDL(int i, int i2, ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() == 1 ? new DLTaggedObject(3, i, i2, aSN1EncodableVector.m14423get(0)) : new DLTaggedObject(4, i, i2, DLFactory.createSequence(aSN1EncodableVector));
    }

    public static ASN1Primitive createConstructedIL(int i, int i2, ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m14424size() == 1 ? new BERTaggedObject(3, i, i2, aSN1EncodableVector.m14423get(0)) : new BERTaggedObject(4, i, i2, BERFactory.createSequence(aSN1EncodableVector));
    }

    public static ASN1Primitive createPrimitive(int i, int i2, byte[] bArr) {
        return new DLTaggedObject(4, i, i2, new DEROctetString(bArr));
    }

    public static ASN1TaggedObject getContextInstance(Object obj) {
        return ASN1Util.checkContextTagClass(checkInstance(obj));
    }

    public static ASN1TaggedObject getContextOptional(ASN1Encodable aSN1Encodable) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.hasContextTag()) {
            return null;
        }
        return optional;
    }

    public static ASN1TaggedObject getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                return (ASN1TaggedObject) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return checkedCast(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) aSN1Encodable;
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.f17953tagNo != aSN1TaggedObject.f17953tagNo || this.tagClass != aSN1TaggedObject.tagClass) {
            return false;
        }
        if (this.explicitness != aSN1TaggedObject.explicitness && isExplicit() != aSN1TaggedObject.isExplicit()) {
            return false;
        }
        ASN1Primitive aSN1Primitive2 = this.f17952obj.toASN1Primitive();
        ASN1Primitive aSN1Primitive3 = aSN1TaggedObject.f17952obj.toASN1Primitive();
        if (aSN1Primitive2 == aSN1Primitive3) {
            return true;
        }
        if (isExplicit()) {
            return aSN1Primitive2.asn1Equals(aSN1Primitive3);
        }
        try {
            return C6238Arrays.areEqual(getEncoded(), aSN1TaggedObject.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    public ASN1Object getBaseObject() {
        ASN1Encodable aSN1Encodable = this.f17952obj;
        return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    public ASN1Primitive getBaseUniversal(boolean z, int i) {
        ASN1UniversalType aSN1UniversalTypeM14463get = ASN1UniversalTypes.m14463get(i);
        if (aSN1UniversalTypeM14463get != null) {
            return getBaseUniversal(z, aSN1UniversalTypeM14463get);
        }
        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + i);
    }

    public ASN1Object getExplicitBaseObject() {
        if (!isExplicit()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        ASN1Encodable aSN1Encodable = this.f17952obj;
        return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    public ASN1TaggedObject getExplicitBaseTagged() {
        if (isExplicit()) {
            return checkedCast(this.f17952obj.toASN1Primitive());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getImplicitBaseTagged(int i, int i2) {
        if (i == 0 || (i & 192) != i) {
            throw new IllegalArgumentException("invalid base tag class: " + i);
        }
        int i3 = this.explicitness;
        if (i3 != 1) {
            return i3 != 2 ? replaceTag(i, i2) : ASN1Util.checkTag(checkedCast(this.f17952obj.toASN1Primitive()), i, i2);
        }
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public final ASN1Primitive getLoadedObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public int getTagClass() {
        return this.tagClass;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.f17953tagNo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasContextTag() {
        return this.tagClass == 128;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    /* renamed from: hasTag */
    public boolean mo14457hasTag(int i, int i2) {
        return this.tagClass == i && this.f17953tagNo == i2;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasTagClass(int i) {
        return this.tagClass == i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return this.f17952obj.toASN1Primitive().hashCode() ^ (((this.tagClass * 7919) ^ this.f17953tagNo) ^ (isExplicit() ? 15 : 240));
    }

    public boolean isExplicit() {
        int i = this.explicitness;
        return i == 1 || i == 3;
    }

    public boolean isParsed() {
        int i = this.explicitness;
        return i == 3 || i == 4;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseBaseUniversal(boolean z, int i) {
        ASN1Primitive baseUniversal = getBaseUniversal(z, i);
        return i != 3 ? i != 4 ? i != 16 ? i != 17 ? baseUniversal : ((AbstractC5093ASN1Set) baseUniversal).m14453parser() : ((ASN1Sequence) baseUniversal).m14449parser() : ((ASN1OctetString) baseUniversal).m14437parser() : ((ASN1BitString) baseUniversal).m14418parser();
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseExplicitBaseObject() {
        return getExplicitBaseObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseExplicitBaseTagged() {
        return getExplicitBaseTagged();
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i2) {
        return getImplicitBaseTagged(i, i2);
    }

    public abstract ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive);

    public abstract ASN1TaggedObject replaceTag(int i, int i2);

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicitness, this.tagClass, this.f17953tagNo, this.f17952obj);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicitness, this.tagClass, this.f17953tagNo, this.f17952obj);
    }

    public String toString() {
        return ASN1Util.getTagText(this.tagClass, this.f17953tagNo) + this.f17952obj;
    }

    public ASN1TaggedObject(boolean z, int i, int i2, ASN1Encodable aSN1Encodable) {
        this(z ? 1 : 2, i, i2, aSN1Encodable);
    }

    private static ASN1TaggedObject checkInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (!z) {
            throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
        }
        if (aSN1TaggedObject != null) {
            return aSN1TaggedObject;
        }
        throw new NullPointerException("'taggedObject' cannot be null");
    }

    public static ASN1TaggedObject getContextInstance(Object obj, int i) {
        return ASN1Util.checkContextTag(checkInstance(obj), i);
    }

    public static ASN1TaggedObject getContextOptional(ASN1Encodable aSN1Encodable, int i) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.hasContextTag(i)) {
            return null;
        }
        return optional;
    }

    public static ASN1TaggedObject getInstance(Object obj, int i) {
        return ASN1Util.checkTagClass(checkInstance(obj), i);
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable, int i) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.hasTagClass(i)) {
            return null;
        }
        return optional;
    }

    public ASN1Primitive getBaseUniversal(boolean z, ASN1UniversalType aSN1UniversalType) {
        if (z) {
            if (isExplicit()) {
                return aSN1UniversalType.checkedCast(this.f17952obj.toASN1Primitive());
            }
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        if (1 == this.explicitness) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        ASN1Primitive aSN1Primitive = this.f17952obj.toASN1Primitive();
        int i = this.explicitness;
        return i != 3 ? i != 4 ? aSN1UniversalType.checkedCast(aSN1Primitive) : aSN1Primitive instanceof ASN1Sequence ? aSN1UniversalType.fromImplicitConstructed((ASN1Sequence) aSN1Primitive) : aSN1UniversalType.fromImplicitPrimitive((DEROctetString) aSN1Primitive) : aSN1UniversalType.fromImplicitConstructed(rebuildConstructed(aSN1Primitive));
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasContextTag(int i) {
        return this.tagClass == 128 && this.f17953tagNo == i;
    }

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        this(z, 128, i, aSN1Encodable);
    }

    public static ASN1TaggedObject getInstance(Object obj, int i, int i2) {
        return ASN1Util.checkTag(checkInstance(obj), i, i2);
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable, int i, int i2) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.mo14457hasTag(i, i2)) {
            return null;
        }
        return optional;
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, int i, int i2, boolean z) {
        return ASN1Util.getExplicitBaseTagged(checkInstance(aSN1TaggedObject, z), i, i2);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, int i, boolean z) {
        return ASN1Util.getExplicitBaseTagged(checkInstance(aSN1TaggedObject, z), i);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return ASN1Util.getExplicitContextBaseTagged(checkInstance(aSN1TaggedObject, z));
    }
}
