package org.bouncycastle.p296mime;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.bouncycastle.p361util.C6250Strings;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
class LineReader {

    /* renamed from: lastC */
    private int f22505lastC = -1;

    /* renamed from: src */
    private final InputStream f22506src;

    public LineReader(InputStream inputStream) {
        this.f22506src = inputStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001a, code lost:
    
        r1 = r4.f22506src.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readLine() {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = this.f22505lastC;
        if (i2 != -1) {
            if (i2 == 13) {
                return BuildConfig.f24315FLAVOR;
            }
            this.f22505lastC = -1;
            while (i2 >= 0 && i2 != 13 && i2 != 10) {
                byteArrayOutputStream.write(i2);
            }
            if (i2 == 13 && (i = this.f22506src.read()) != 10 && i >= 0) {
                this.f22505lastC = i;
            }
            if (i2 < 0) {
                return null;
            }
            return C6250Strings.fromUTF8ByteArray(byteArrayOutputStream.toByteArray());
        }
        i2 = this.f22506src.read();
    }
}
