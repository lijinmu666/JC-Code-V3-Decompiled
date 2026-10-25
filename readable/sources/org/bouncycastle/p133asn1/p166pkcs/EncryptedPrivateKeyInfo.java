package org.bouncycastle.p133asn1.p166pkcs;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EncryptedPrivateKeyInfo extends ASN1Object {

    /* renamed from: algId */
    private AlgorithmIdentifier f18474algId;

    /* renamed from: data */
    private ASN1OctetString f18475data;

    private EncryptedPrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18474algId = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.f18475data = ASN1OctetString.getInstance(objects.nextElement());
    }

    public static EncryptedPrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof EncryptedPrivateKeyInfo) {
            return (EncryptedPrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new EncryptedPrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getEncryptedData() {
        return C6238Arrays.m18231clone(this.f18475data.getOctets());
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.f18474algId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18474algId, this.f18475data);
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f18474algId = algorithmIdentifier;
        this.f18475data = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }
}
