package org.bouncycastle.p191cms.p193jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.crypto.Cipher;
import org.bouncycastle.operator.InputAEADDecryptor;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.InputStreamWithMAC;
import org.bouncycastle.p249jcajce.p250io.CipherInputStream;

/* loaded from: classes2.dex */
class CMSInputAEADDecryptor implements InputAEADDecryptor {
    private final AlgorithmIdentifier contentEncryptionAlgorithm;
    private final Cipher dataCipher;
    private InputStream inputStream;

    public CMSInputAEADDecryptor(AlgorithmIdentifier algorithmIdentifier, Cipher cipher) {
        this.contentEncryptionAlgorithm = algorithmIdentifier;
        this.dataCipher = cipher;
    }

    private static boolean checkForAEAD() {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.cms.jcajce.CMSInputAEADDecryptor.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Boolean.valueOf(Cipher.class.getMethod("updateAAD", byte[].class) != null);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    @Override // org.bouncycastle.operator.AADProcessor
    public OutputStream getAADStream() {
        if (checkForAEAD()) {
            return new JceAADStream(this.dataCipher);
        }
        return null;
    }

    @Override // org.bouncycastle.operator.InputDecryptor
    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.contentEncryptionAlgorithm;
    }

    @Override // org.bouncycastle.operator.InputDecryptor
    public InputStream getInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return new CipherInputStream(inputStream, this.dataCipher);
    }

    @Override // org.bouncycastle.operator.AADProcessor
    /* renamed from: getMAC */
    public byte[] mo14908getMAC() {
        InputStream inputStream = this.inputStream;
        if (inputStream instanceof InputStreamWithMAC) {
            return ((InputStreamWithMAC) inputStream).m14882getMAC();
        }
        return null;
    }
}
