package org.bouncycastle.p296mime;

import java.io.InputStream;

/* loaded from: classes2.dex */
public interface MimeParserListener {
    MimeContext createContext(MimeParserContext mimeParserContext, C5880Headers c5880Headers);

    /* renamed from: object */
    void mo15966object(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InputStream inputStream);
}
