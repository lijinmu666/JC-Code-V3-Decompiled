package org.bouncycastle.p246its;

import org.bouncycastle.p300oer.p301its.ieee1609dot2.PKRecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.RecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class ETSIRecipientInfoBuilder {
    private final ETSIKeyWrapper keyWrapper;
    private final byte[] recipientID;

    public ETSIRecipientInfoBuilder(ETSIKeyWrapper eTSIKeyWrapper, byte[] bArr) {
        this.keyWrapper = eTSIKeyWrapper;
        this.recipientID = bArr;
    }

    /* renamed from: build */
    public RecipientInfo m15995build(byte[] bArr) {
        try {
            return RecipientInfo.certRecipInfo(PKRecipientInfo.m17235builder().setRecipientId(new HashedId8(this.recipientID)).setEncKey(this.keyWrapper.mo15993wrap(bArr)).createPKRecipientInfo());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
