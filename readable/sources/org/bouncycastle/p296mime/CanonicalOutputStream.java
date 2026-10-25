package org.bouncycastle.p296mime;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p296mime.p297smime.SMimeParserContext;

/* loaded from: classes2.dex */
public class CanonicalOutputStream extends FilterOutputStream {

    /* renamed from: newline */
    protected static byte[] f22499newline = {13, 10};

    /* renamed from: is7Bit */
    private final boolean f22500is7Bit;

    /* renamed from: lastb */
    protected int f22501lastb;

    public CanonicalOutputStream(SMimeParserContext sMimeParserContext, C5880Headers c5880Headers, OutputStream outputStream) {
        super(outputStream);
        this.f22501lastb = -1;
        this.f22500is7Bit = c5880Headers.getContentType() != null ? (c5880Headers.getContentType() == null || c5880Headers.getContentType().equals("binary")) ? false : true : sMimeParserContext.getDefaultContentTransferEncoding().equals("7bit");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(int i) throws IOException {
        if (!this.f22500is7Bit) {
            ((FilterOutputStream) this).out.write(i);
        } else if (i == 13) {
            ((FilterOutputStream) this).out.write(f22499newline);
        } else if (i == 10) {
            if (this.f22501lastb != 13) {
                ((FilterOutputStream) this).out.write(f22499newline);
            }
        }
        this.f22501lastb = i;
    }

    /* renamed from: writeln */
    public void m17110writeln() throws IOException {
        ((FilterOutputStream) this).out.write(f22499newline);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 != i + i2; i3++) {
            write(bArr[i3]);
        }
    }
}
