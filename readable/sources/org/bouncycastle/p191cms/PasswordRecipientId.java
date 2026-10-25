package org.bouncycastle.p191cms;

/* loaded from: classes2.dex */
public class PasswordRecipientId extends RecipientId {
    public PasswordRecipientId() {
        super(3);
    }

    @Override // org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new PasswordRecipientId();
    }

    /* renamed from: equals */
    public boolean m14889equals(Object obj) {
        return obj instanceof PasswordRecipientId;
    }

    public int hashCode() {
        return 3;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return obj instanceof PasswordRecipientInformation;
    }
}
