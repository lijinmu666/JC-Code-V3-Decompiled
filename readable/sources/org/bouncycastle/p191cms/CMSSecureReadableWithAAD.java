package org.bouncycastle.p191cms;

import java.io.OutputStream;

/* loaded from: classes2.dex */
interface CMSSecureReadableWithAAD extends CMSSecureReadable {
    OutputStream getAADStream();

    /* renamed from: getMAC */
    byte[] mo14845getMAC();

    void setAADStream(OutputStream outputStream);
}
