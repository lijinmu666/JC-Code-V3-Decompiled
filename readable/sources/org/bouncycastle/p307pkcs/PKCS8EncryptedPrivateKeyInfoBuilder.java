package org.bouncycastle.p307pkcs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;

/* loaded from: classes2.dex */
public class PKCS8EncryptedPrivateKeyInfoBuilder {
    private PrivateKeyInfo privateKeyInfo;

    public PKCS8EncryptedPrivateKeyInfoBuilder(PrivateKeyInfo privateKeyInfo) {
        this.privateKeyInfo = privateKeyInfo;
    }

    /* renamed from: build */
    public PKCS8EncryptedPrivateKeyInfo m17414build(OutputEncryptor outputEncryptor) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStream = outputEncryptor.getOutputStream(byteArrayOutputStream);
            outputStream.write(this.privateKeyInfo.getEncoded());
            outputStream.close();
            return new PKCS8EncryptedPrivateKeyInfo(new EncryptedPrivateKeyInfo(outputEncryptor.getAlgorithmIdentifier(), byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode privateKeyInfo");
        }
    }

    public PKCS8EncryptedPrivateKeyInfoBuilder(byte[] bArr) {
        this(PrivateKeyInfo.getInstance(bArr));
    }
}
