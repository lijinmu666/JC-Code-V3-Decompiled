package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.p174x509.DigestInfo;

/* loaded from: classes2.dex */
public class MessageImprint {
    private final DigestInfo messageImprint;

    public MessageImprint(DigestInfo digestInfo) {
        this.messageImprint = digestInfo;
    }

    /* renamed from: equals */
    public boolean m15942equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MessageImprint) {
            return this.messageImprint.mo14431equals(((MessageImprint) obj).messageImprint);
        }
        return false;
    }

    public int hashCode() {
        return this.messageImprint.hashCode();
    }

    public DigestInfo toASN1Structure() {
        return this.messageImprint;
    }
}
