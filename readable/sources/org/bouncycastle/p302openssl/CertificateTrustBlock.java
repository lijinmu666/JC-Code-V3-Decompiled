package org.bouncycastle.p302openssl;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DERUTF8String;

/* loaded from: classes2.dex */
public class CertificateTrustBlock {

    /* renamed from: alias */
    private String f22820alias;
    private ASN1Sequence prohibitions;

    /* renamed from: uses */
    private ASN1Sequence f22821uses;

    public CertificateTrustBlock(String str, Set<ASN1ObjectIdentifier> set) {
        this(str, set, null);
    }

    private ASN1Sequence toSequence(Set<ASN1ObjectIdentifier> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator<ASN1ObjectIdentifier> it = set.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(it.next());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: toSet */
    private Set<ASN1ObjectIdentifier> m17358toSet(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(aSN1Sequence.mo14450size());
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            hashSet.add(ASN1ObjectIdentifier.getInstance(objects.nextElement()));
        }
        return hashSet;
    }

    public String getAlias() {
        return this.f22820alias;
    }

    public Set<ASN1ObjectIdentifier> getProhibitions() {
        return m17358toSet(this.prohibitions);
    }

    /* renamed from: getUses */
    public Set<ASN1ObjectIdentifier> m17359getUses() {
        return m17358toSet(this.f22821uses);
    }

    public ASN1Sequence toASN1Sequence() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Sequence aSN1Sequence = this.f22821uses;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        ASN1Sequence aSN1Sequence2 = this.prohibitions;
        if (aSN1Sequence2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) aSN1Sequence2));
        }
        if (this.f22820alias != null) {
            aSN1EncodableVector.m14420add(new DERUTF8String(this.f22820alias));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificateTrustBlock(String str, Set<ASN1ObjectIdentifier> set, Set<ASN1ObjectIdentifier> set2) {
        this.f22820alias = str;
        this.f22821uses = toSequence(set);
        this.prohibitions = toSequence(set2);
    }

    public CertificateTrustBlock(Set<ASN1ObjectIdentifier> set) {
        this(null, set, null);
    }

    public CertificateTrustBlock(byte[] bArr) {
        Enumeration objects = ASN1Sequence.getInstance(bArr).getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable instanceof ASN1Sequence) {
                this.f22821uses = ASN1Sequence.getInstance(aSN1Encodable);
            } else if (aSN1Encodable instanceof ASN1TaggedObject) {
                this.prohibitions = ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Encodable, false);
            } else if (aSN1Encodable instanceof ASN1UTF8String) {
                this.f22820alias = ASN1UTF8String.getInstance(aSN1Encodable).getString();
            }
        }
    }
}
