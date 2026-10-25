package org.bouncycastle.p226est;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ESTException extends IOException {
    private static final long MAX_ERROR_BODY = 8192;

    /* renamed from: body */
    private InputStream f21176body;

    /* renamed from: cause */
    private Throwable f21177cause;
    private int statusCode;

    public ESTException(String str) {
        this(str, null);
    }

    /* renamed from: getBody */
    public InputStream m15958getBody() {
        InputStream inputStream = this.f21176body;
        return inputStream == null ? new InputStream() { // from class: org.bouncycastle.est.ESTException.1
            @Override // java.io.InputStream
            public int read() {
                return -1;
            }
        } : inputStream;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f21177cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " HTTP Status Code: " + this.statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ESTException(String str, Throwable th) {
        super(str);
        this.f21177cause = th;
        this.f21176body = null;
        this.statusCode = 0;
    }

    public ESTException(String str, Throwable th, int i, InputStream inputStream) throws IOException {
        super(str);
        this.f21177cause = th;
        this.statusCode = i;
        if (inputStream == null) {
            this.f21176body = null;
            return;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    break;
                }
                if (byteArrayOutputStream.size() + i2 > MAX_ERROR_BODY) {
                    byteArrayOutputStream.write(bArr, 0, 8192 - byteArrayOutputStream.size());
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (Exception unused) {
                return;
            }
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        this.f21176body = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        inputStream.close();
    }
}
