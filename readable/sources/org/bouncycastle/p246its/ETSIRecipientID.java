package org.bouncycastle.p246its;

import org.bouncycastle.p300oer.p301its.ieee1609dot2.PKRecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class ETSIRecipientID implements Selector<ETSIRecipientInfo> {

    /* renamed from: id */
    private final HashedId8 f21285id;

    public ETSIRecipientID(HashedId8 hashedId8) {
        this.f21285id = hashedId8;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return this;
    }

    /* renamed from: equals */
    public boolean m15994equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ETSIRecipientID eTSIRecipientID = (ETSIRecipientID) obj;
        HashedId8 hashedId8 = this.f21285id;
        return hashedId8 != null ? hashedId8.mo14431equals(eTSIRecipientID.f21285id) : eTSIRecipientID.f21285id == null;
    }

    public int hashCode() {
        HashedId8 hashedId8 = this.f21285id;
        if (hashedId8 != null) {
            return hashedId8.hashCode();
        }
        return 0;
    }

    public ETSIRecipientID(byte[] bArr) {
        this(new HashedId8(bArr));
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo14742match(ETSIRecipientInfo eTSIRecipientInfo) {
        if (eTSIRecipientInfo.getRecipientInfo().getChoice() == 2) {
            return C6238Arrays.areEqual(PKRecipientInfo.getInstance(eTSIRecipientInfo.getRecipientInfo().getRecipientInfo()).getRecipientId().getHashBytes(), this.f21285id.getHashBytes());
        }
        return false;
    }
}
