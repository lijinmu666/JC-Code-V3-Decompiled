package org.bouncycastle.p133asn1.p169tsp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class Accuracy extends ASN1Object {
    protected static final int MAX_MICROS = 999;
    protected static final int MAX_MILLIS = 999;
    protected static final int MIN_MICROS = 1;
    protected static final int MIN_MILLIS = 1;

    /* renamed from: micros */
    private final ASN1Integer f18546micros;

    /* renamed from: millis */
    private final ASN1Integer f18547millis;

    /* renamed from: seconds */
    private final ASN1Integer f18548seconds;

    public Accuracy() {
        this.f18548seconds = null;
        this.f18547millis = null;
        this.f18546micros = null;
    }

    public static Accuracy getInstance(Object obj) {
        if (obj instanceof Accuracy) {
            return (Accuracy) obj;
        }
        if (obj != null) {
            return new Accuracy(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static Accuracy getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new Accuracy(ASN1Sequence.getTagged(aSN1TaggedObject, z));
    }

    private void validate() {
        int iIntValueExact;
        ASN1Integer aSN1Integer = this.f18547millis;
        if (aSN1Integer != null && ((iIntValueExact = aSN1Integer.intValueExact()) < 1 || iIntValueExact > 999)) {
            throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
        }
        ASN1Integer aSN1Integer2 = this.f18546micros;
        if (aSN1Integer2 != null) {
            int iIntValueExact2 = aSN1Integer2.intValueExact();
            if (iIntValueExact2 < 1 || iIntValueExact2 > 999) {
                throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
            }
        }
    }

    public ASN1Integer getMicros() {
        return this.f18546micros;
    }

    public ASN1Integer getMillis() {
        return this.f18547millis;
    }

    public ASN1Integer getSeconds() {
        return this.f18548seconds;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        ASN1Integer aSN1Integer = this.f18548seconds;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        ASN1Integer aSN1Integer2 = this.f18547millis;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) aSN1Integer2));
        }
        ASN1Integer aSN1Integer3 = this.f18546micros;
        if (aSN1Integer3 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1Integer3));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public Accuracy(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3) {
        this.f18548seconds = aSN1Integer;
        this.f18547millis = aSN1Integer2;
        this.f18546micros = aSN1Integer3;
        validate();
    }

    public static Accuracy getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new Accuracy(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Accuracy(ASN1Sequence aSN1Sequence) {
        ASN1Integer aSN1Integer;
        int i;
        ASN1Integer aSN1Integer2;
        ASN1TaggedObject contextOptional;
        ASN1TaggedObject contextOptional2;
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size < 0 || iMo14450size > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + iMo14450size);
        }
        ASN1Integer aSN1Integer3 = null;
        if (iMo14450size > 0) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
            if (objectAt instanceof ASN1Integer) {
                aSN1Integer = (ASN1Integer) objectAt;
                i = 1;
            } else {
                aSN1Integer = null;
                i = 0;
            }
        }
        this.f18548seconds = aSN1Integer;
        if (i >= iMo14450size || (contextOptional2 = ASN1TaggedObject.getContextOptional(aSN1Sequence.getObjectAt(i), 0)) == null) {
            aSN1Integer2 = null;
        } else {
            i++;
            aSN1Integer2 = ASN1Integer.getInstance(contextOptional2, false);
        }
        this.f18547millis = aSN1Integer2;
        if (i < iMo14450size && (contextOptional = ASN1TaggedObject.getContextOptional(aSN1Sequence.getObjectAt(i), 1)) != null) {
            i++;
            aSN1Integer3 = ASN1Integer.getInstance(contextOptional, false);
        }
        this.f18546micros = aSN1Integer3;
        if (i != iMo14450size) {
            throw new IllegalArgumentException("Unexpected elements in sequence");
        }
        validate();
    }
}
