package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DLSequence;

/* loaded from: classes2.dex */
public class AuthenticatedSafe extends ASN1Object {

    /* renamed from: info */
    private ContentInfo[] f18460info;

    /* renamed from: isBer */
    private boolean f18461isBer;

    private AuthenticatedSafe(ASN1Sequence aSN1Sequence) {
        this.f18461isBer = true;
        this.f18460info = new ContentInfo[aSN1Sequence.mo14450size()];
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.f18460info;
            if (i == contentInfoArr.length) {
                this.f18461isBer = aSN1Sequence instanceof BERSequence;
                return;
            } else {
                contentInfoArr[i] = ContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
                i++;
            }
        }
    }

    /* renamed from: copy */
    private ContentInfo[] m14626copy(ContentInfo[] contentInfoArr) {
        int length = contentInfoArr.length;
        ContentInfo[] contentInfoArr2 = new ContentInfo[length];
        System.arraycopy(contentInfoArr, 0, contentInfoArr2, 0, length);
        return contentInfoArr2;
    }

    public static AuthenticatedSafe getInstance(Object obj) {
        if (obj instanceof AuthenticatedSafe) {
            return (AuthenticatedSafe) obj;
        }
        if (obj != null) {
            return new AuthenticatedSafe(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo[] getContentInfo() {
        return m14626copy(this.f18460info);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18461isBer ? new BERSequence(this.f18460info) : new DLSequence(this.f18460info);
    }

    public AuthenticatedSafe(ContentInfo[] contentInfoArr) {
        this.f18461isBer = true;
        this.f18460info = m14626copy(contentInfoArr);
    }
}
