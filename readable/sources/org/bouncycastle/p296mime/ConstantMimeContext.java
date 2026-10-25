package org.bouncycastle.p296mime;

import java.io.InputStream;

/* loaded from: classes2.dex */
public class ConstantMimeContext implements MimeContext, MimeMultipartContext {
    public static final ConstantMimeContext Instance = new ConstantMimeContext();

    @Override // org.bouncycastle.p296mime.MimeContext
    public InputStream applyContext(C5880Headers c5880Headers, InputStream inputStream) {
        return inputStream;
    }

    @Override // org.bouncycastle.p296mime.MimeMultipartContext
    public MimeContext createContext(int i) {
        return this;
    }
}
