package org.bouncycastle.p300oer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encodable;

/* loaded from: classes2.dex */
public class OEREncoder {
    public static byte[] toByteArray(ASN1Encodable aSN1Encodable, C5887Element c5887Element) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new OEROutputStream(byteArrayOutputStream).m17168write(aSN1Encodable, c5887Element);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
