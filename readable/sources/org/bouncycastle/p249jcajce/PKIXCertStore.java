package org.bouncycastle.p249jcajce;

import java.security.cert.Certificate;
import java.util.Collection;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public interface PKIXCertStore<T extends Certificate> extends InterfaceC6249Store<T> {
    @Override // org.bouncycastle.p361util.InterfaceC6249Store
    Collection<T> getMatches(Selector<T> selector);
}
