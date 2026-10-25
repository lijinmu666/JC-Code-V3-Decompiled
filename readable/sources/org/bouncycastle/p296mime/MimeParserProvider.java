package org.bouncycastle.p296mime;

import java.io.InputStream;

/* loaded from: classes2.dex */
public interface MimeParserProvider {
    MimeParser createParser(InputStream inputStream);

    MimeParser createParser(C5880Headers c5880Headers, InputStream inputStream);
}
