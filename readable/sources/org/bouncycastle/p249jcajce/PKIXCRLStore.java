package org.bouncycastle.p249jcajce;

import java.security.cert.CRL;
import java.util.Collection;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public interface PKIXCRLStore<T extends CRL> extends InterfaceC6249Store<T> {
    @Override // org.bouncycastle.p361util.InterfaceC6249Store
    Collection<T> getMatches(Selector<T> selector);
}
