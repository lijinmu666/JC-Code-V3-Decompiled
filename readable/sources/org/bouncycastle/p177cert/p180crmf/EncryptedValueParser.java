package org.bouncycastle.p177cert.p180crmf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class EncryptedValueParser {

    /* renamed from: padder */
    private EncryptedValuePadder f18829padder;

    /* renamed from: value */
    private EncryptedValue f18830value;

    public EncryptedValueParser(EncryptedValue encryptedValue) {
        this.f18830value = encryptedValue;
    }

    private byte[] decryptValue(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        if (this.f18830value.getValueHint() != null) {
            throw new UnsupportedOperationException();
        }
        try {
            return unpadData(C6257Streams.m18363readAll(valueDecryptorGenerator.getValueDecryptor(this.f18830value.getKeyAlg(), this.f18830value.getSymmAlg(), this.f18830value.getEncSymmKey().getBytes()).getInputStream(new ByteArrayInputStream(this.f18830value.getEncValue().getBytes()))));
        } catch (IOException e) {
            throw new CRMFException("Cannot parse decrypted data: " + e.getMessage(), e);
        }
    }

    private byte[] unpadData(byte[] bArr) {
        EncryptedValuePadder encryptedValuePadder = this.f18829padder;
        return encryptedValuePadder != null ? encryptedValuePadder.getUnpaddedData(bArr) : bArr;
    }

    public AlgorithmIdentifier getIntendedAlg() {
        return this.f18830value.getIntendedAlg();
    }

    public X509CertificateHolder readCertificateHolder(ValueDecryptorGenerator valueDecryptorGenerator) {
        return new X509CertificateHolder(Certificate.getInstance(decryptValue(valueDecryptorGenerator)));
    }

    public char[] readPassphrase(ValueDecryptorGenerator valueDecryptorGenerator) {
        return C6250Strings.fromUTF8ByteArray(decryptValue(valueDecryptorGenerator)).toCharArray();
    }

    public PrivateKeyInfo readPrivateKeyInfo(ValueDecryptorGenerator valueDecryptorGenerator) {
        return PrivateKeyInfo.getInstance(decryptValue(valueDecryptorGenerator));
    }

    public EncryptedValueParser(EncryptedValue encryptedValue, EncryptedValuePadder encryptedValuePadder) {
        this.f18830value = encryptedValue;
        this.f18829padder = encryptedValuePadder;
    }
}
