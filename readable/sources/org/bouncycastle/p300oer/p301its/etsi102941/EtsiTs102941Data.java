package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.C5916Version;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.C5929Opaque;

/* loaded from: classes2.dex */
public class EtsiTs102941Data extends ASN1Object {

    /* renamed from: content */
    private final EtsiTs102941DataContent f22597content;

    /* renamed from: version */
    private final C5916Version f22598version;

    private EtsiTs102941Data(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22598version = C5916Version.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22597content = EtsiTs102941DataContent.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static EtsiTs102941Data getInstance(Object obj) {
        if (obj instanceof EtsiTs102941Data) {
            return (EtsiTs102941Data) obj;
        }
        if (obj != null) {
            return obj instanceof C5929Opaque ? new EtsiTs102941Data(ASN1Sequence.getInstance(((C5929Opaque) obj).getContent())) : new EtsiTs102941Data(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs102941DataContent getContent() {
        return this.f22597content;
    }

    public C5916Version getVersion() {
        return this.f22598version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22598version, this.f22597content});
    }

    public EtsiTs102941Data(C5916Version c5916Version, EtsiTs102941DataContent etsiTs102941DataContent) {
        this.f22598version = c5916Version;
        this.f22597content = etsiTs102941DataContent;
    }
}
