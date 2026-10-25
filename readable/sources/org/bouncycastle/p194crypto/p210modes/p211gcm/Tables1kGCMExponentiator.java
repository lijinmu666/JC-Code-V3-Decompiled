package org.bouncycastle.p194crypto.p210modes.p211gcm;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Tables1kGCMExponentiator implements GCMExponentiator {
    private List lookupPowX2;

    private long[] getPowX2(int i) {
        int size = this.lookupPowX2.size() - 1;
        if (size < i) {
            long[] jArr = (long[]) this.lookupPowX2.get(size);
            while (true) {
                long[] jArr2 = new long[2];
                AbstractC5369GCMUtil.m15630square(jArr, jArr2);
                this.lookupPowX2.add(jArr2);
                size++;
                if (size >= i) {
                    break;
                }
                jArr = jArr2;
            }
        }
        return (long[]) this.lookupPowX2.get(i);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        long[] jArrOneAsLongs = AbstractC5369GCMUtil.oneAsLongs();
        int i = 0;
        while (j > 0) {
            if ((1 & j) != 0) {
                AbstractC5369GCMUtil.multiply(jArrOneAsLongs, getPowX2(i));
            }
            i++;
            j >>>= 1;
        }
        AbstractC5369GCMUtil.m15619asBytes(jArrOneAsLongs, bArr);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.p211gcm.GCMExponentiator
    /* renamed from: init */
    public void mo15616init(byte[] bArr) {
        long[] jArrM15625asLongs = AbstractC5369GCMUtil.m15625asLongs(bArr);
        List list = this.lookupPowX2;
        if (list == null || 0 == AbstractC5369GCMUtil.areEqual(jArrM15625asLongs, (long[]) list.get(0))) {
            ArrayList arrayList = new ArrayList(8);
            this.lookupPowX2 = arrayList;
            arrayList.add(jArrM15625asLongs);
        }
    }
}
