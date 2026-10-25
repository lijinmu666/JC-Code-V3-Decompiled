package org.bouncycastle.p226est;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: org.bouncycastle.est.Source */
/* loaded from: classes2.dex */
public interface InterfaceC5444Source<T> {
    /* renamed from: close */
    void mo15977close();

    InputStream getInputStream();

    OutputStream getOutputStream();

    T getSession();
}
