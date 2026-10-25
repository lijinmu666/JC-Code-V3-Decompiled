package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr = this.encodingTable;
        bArr[bArr.length - 2] = 45;
        bArr[bArr.length - 1] = 95;
        this.f24211padding = (byte) 46;
        initialiseDecodingTable();
    }
}
