package org.bouncycastle.p177cert.p183dane;

import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class DANEEntrySelector implements Selector {
    private final String domainName;

    public DANEEntrySelector(String str) {
        this.domainName = str;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return this;
    }

    public String getDomainName() {
        return this.domainName;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return ((DANEEntry) obj).getDomainName().equals(this.domainName);
    }
}
