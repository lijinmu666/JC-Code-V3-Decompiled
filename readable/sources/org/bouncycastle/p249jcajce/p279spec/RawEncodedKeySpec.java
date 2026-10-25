package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.EncodedKeySpec;

/* loaded from: classes2.dex */
public class RawEncodedKeySpec extends EncodedKeySpec {
    public RawEncodedKeySpec(byte[] bArr) {
        super(bArr);
    }

    @Override // java.security.spec.EncodedKeySpec
    public String getFormat() {
        return "RAW";
    }
}
