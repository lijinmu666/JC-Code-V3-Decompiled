package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ExtendedKeyUsage extends ASN1Object {

    /* renamed from: seq */
    ASN1Sequence f18650seq;
    Hashtable usageTable = new Hashtable();

    public ExtendedKeyUsage(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(vector.size());
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            KeyPurposeId keyPurposeId = KeyPurposeId.getInstance(enumerationElements.nextElement());
            aSN1EncodableVector.m14420add(keyPurposeId);
            this.usageTable.put(keyPurposeId, keyPurposeId);
        }
        this.f18650seq = new DERSequence(aSN1EncodableVector);
    }

    public static ExtendedKeyUsage fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.extendedKeyUsage));
    }

    public static ExtendedKeyUsage getInstance(Object obj) {
        if (obj instanceof ExtendedKeyUsage) {
            return (ExtendedKeyUsage) obj;
        }
        if (obj != null) {
            return new ExtendedKeyUsage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public KeyPurposeId[] getUsages() {
        KeyPurposeId[] keyPurposeIdArr = new KeyPurposeId[this.f18650seq.mo14450size()];
        Enumeration objects = this.f18650seq.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            keyPurposeIdArr[i] = KeyPurposeId.getInstance(objects.nextElement());
            i++;
        }
        return keyPurposeIdArr;
    }

    public boolean hasKeyPurposeId(KeyPurposeId keyPurposeId) {
        return this.usageTable.get(keyPurposeId) != null;
    }

    /* renamed from: size */
    public int m14685size() {
        return this.usageTable.size();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18650seq;
    }

    private ExtendedKeyUsage(ASN1Sequence aSN1Sequence) {
        this.f18650seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (!(aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier)) {
                throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
            }
            this.usageTable.put(aSN1Encodable, aSN1Encodable);
        }
    }

    public static ExtendedKeyUsage getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ExtendedKeyUsage(KeyPurposeId keyPurposeId) {
        this.f18650seq = new DERSequence(keyPurposeId);
        this.usageTable.put(keyPurposeId, keyPurposeId);
    }

    public ExtendedKeyUsage(KeyPurposeId[] keyPurposeIdArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(keyPurposeIdArr.length);
        for (int i = 0; i != keyPurposeIdArr.length; i++) {
            aSN1EncodableVector.m14420add(keyPurposeIdArr[i]);
            Hashtable hashtable = this.usageTable;
            KeyPurposeId keyPurposeId = keyPurposeIdArr[i];
            hashtable.put(keyPurposeId, keyPurposeId);
        }
        this.f18650seq = new DERSequence(aSN1EncodableVector);
    }
}
