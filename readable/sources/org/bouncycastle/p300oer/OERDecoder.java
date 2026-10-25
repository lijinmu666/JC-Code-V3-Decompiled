package org.bouncycastle.p300oer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1Encodable;

/* loaded from: classes2.dex */
public class OERDecoder {
    /* renamed from: decode */
    public static ASN1Encodable m17124decode(InputStream inputStream, C5887Element c5887Element) {
        return new OERInputStream(inputStream).m17161parse(c5887Element);
    }

    /* renamed from: decode */
    public static ASN1Encodable m17125decode(byte[] bArr, C5887Element c5887Element) {
        return m17124decode(new ByteArrayInputStream(bArr), c5887Element);
    }
}
