package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes.dex */
class LazyEncodedSequence extends ASN1Sequence {

    /* renamed from: encoded */
    private byte[] f18005encoded;

    public LazyEncodedSequence(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'encoded' cannot be null");
        }
        this.f18005encoded = bArr;
    }

    /* renamed from: force */
    private synchronized void m14478force() {
        if (this.f18005encoded != null) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(this.f18005encoded, true);
            try {
                ASN1EncodableVector vector = aSN1InputStream.readVector();
                aSN1InputStream.close();
                this.elements = vector.takeElements();
                this.f18005encoded = null;
            } catch (IOException e) {
                throw new ASN1ParsingException("malformed ASN.1: " + e, e);
            }
        }
    }

    private synchronized byte[] getContents() {
        return this.f18005encoded;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        byte[] contents = getContents();
        if (contents != null) {
            aSN1OutputStream.writeEncodingDL(z, 48, contents);
        } else {
            super.toDLObject().mo14417encode(aSN1OutputStream, z);
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        byte[] contents = getContents();
        return contents != null ? ASN1OutputStream.getLengthOfEncodingDL(z, contents.length) : super.toDLObject().encodedLength(z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1Encodable getObjectAt(int i) {
        m14478force();
        return super.getObjectAt(i);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public Enumeration getObjects() {
        byte[] contents = getContents();
        return contents != null ? new LazyConstructionEnumeration(contents) : super.getObjects();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        m14478force();
        return super.hashCode();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        m14478force();
        return super.iterator();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    /* renamed from: size */
    public int mo14450size() {
        m14478force();
        return super.mo14450size();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1BitString toASN1BitString() {
        return ((ASN1Sequence) toDLObject()).toASN1BitString();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1External toASN1External() {
        return ((ASN1Sequence) toDLObject()).toASN1External();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1OctetString toASN1OctetString() {
        return ((ASN1Sequence) toDLObject()).toASN1OctetString();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public AbstractC5093ASN1Set toASN1Set() {
        return ((ASN1Sequence) toDLObject()).toASN1Set();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    /* renamed from: toArray */
    public ASN1Encodable[] mo14451toArray() {
        m14478force();
        return super.mo14451toArray();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence
    public ASN1Encodable[] toArrayInternal() {
        m14478force();
        return super.toArrayInternal();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        m14478force();
        return super.toDERObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Sequence, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        m14478force();
        return super.toDLObject();
    }
}
