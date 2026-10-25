package org.bouncycastle.p191cms;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KEKRecipientId extends RecipientId {
    private byte[] keyIdentifier;

    public KEKRecipientId(byte[] bArr) {
        super(1);
        this.keyIdentifier = bArr;
    }

    @Override // org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new KEKRecipientId(this.keyIdentifier);
    }

    /* renamed from: equals */
    public boolean m14883equals(Object obj) {
        if (obj instanceof KEKRecipientId) {
            return C6238Arrays.areEqual(this.keyIdentifier, ((KEKRecipientId) obj).keyIdentifier);
        }
        return false;
    }

    public byte[] getKeyIdentifier() {
        return C6238Arrays.m18231clone(this.keyIdentifier);
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.keyIdentifier);
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        if (obj instanceof byte[]) {
            return C6238Arrays.areEqual(this.keyIdentifier, (byte[]) obj);
        }
        if (obj instanceof KEKRecipientInformation) {
            return ((KEKRecipientInformation) obj).m14893getRID().equals(this);
        }
        return false;
    }
}
