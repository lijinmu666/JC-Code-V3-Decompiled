package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.EncodedKeySpec;

/* loaded from: classes2.dex */
public class OpenSSHPrivateKeySpec extends EncodedKeySpec {

    /* renamed from: format */
    private final String f21938format;

    public OpenSSHPrivateKeySpec(byte[] bArr) {
        String str;
        super(bArr);
        byte b = bArr[0];
        if (b == 48) {
            str = "ASN.1";
        } else {
            if (b != 111) {
                throw new IllegalArgumentException("unknown byte encoding");
            }
            str = "OpenSSH";
        }
        this.f21938format = str;
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return this.f21938format;
    }
}
