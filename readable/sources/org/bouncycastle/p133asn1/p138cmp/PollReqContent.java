package org.bouncycastle.p133asn1.p138cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class PollReqContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18155content;

    public PollReqContent(BigInteger bigInteger) {
        this(new ASN1Integer(bigInteger));
    }

    public static PollReqContent getInstance(Object obj) {
        if (obj instanceof PollReqContent) {
            return (PollReqContent) obj;
        }
        if (obj != null) {
            return new PollReqContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static ASN1Integer[] intsToASN1(BigInteger[] bigIntegerArr) {
        int length = bigIntegerArr.length;
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[length];
        for (int i = 0; i != length; i++) {
            aSN1IntegerArr[i] = new ASN1Integer(bigIntegerArr[i]);
        }
        return aSN1IntegerArr;
    }

    private static DERSequence[] intsToSequence(ASN1Integer[] aSN1IntegerArr) {
        int length = aSN1IntegerArr.length;
        DERSequence[] dERSequenceArr = new DERSequence[length];
        for (int i = 0; i != length; i++) {
            dERSequenceArr[i] = new DERSequence(aSN1IntegerArr[i]);
        }
        return dERSequenceArr;
    }

    private static ASN1Integer[] sequenceToASN1IntegerArray(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            aSN1IntegerArr[i] = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    public BigInteger[] getCertReqIdValues() {
        int iMo14450size = this.f18155content.mo14450size();
        BigInteger[] bigIntegerArr = new BigInteger[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            bigIntegerArr[i] = ASN1Integer.getInstance(ASN1Sequence.getInstance(this.f18155content.getObjectAt(i)).getObjectAt(0)).getValue();
        }
        return bigIntegerArr;
    }

    public ASN1Integer[][] getCertReqIds() {
        int iMo14450size = this.f18155content.mo14450size();
        ASN1Integer[][] aSN1IntegerArr = new ASN1Integer[iMo14450size][];
        for (int i = 0; i != iMo14450size; i++) {
            aSN1IntegerArr[i] = sequenceToASN1IntegerArray((ASN1Sequence) this.f18155content.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18155content;
    }

    public PollReqContent(ASN1Integer aSN1Integer) {
        this(new DERSequence(new DERSequence(aSN1Integer)));
    }

    private PollReqContent(ASN1Sequence aSN1Sequence) {
        this.f18155content = aSN1Sequence;
    }

    public PollReqContent(BigInteger[] bigIntegerArr) {
        this(intsToASN1(bigIntegerArr));
    }

    public PollReqContent(ASN1Integer[] aSN1IntegerArr) {
        this(new DERSequence(intsToSequence(aSN1IntegerArr)));
    }
}
