package org.bouncycastle.p177cert.p180crmf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.KeyWrapper;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p307pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class EncryptedValueBuilder {
    private OutputEncryptor encryptor;

    /* renamed from: padder */
    private EncryptedValuePadder f18827padder;

    /* renamed from: wrapper */
    private KeyWrapper f18828wrapper;

    public EncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor) {
        this(keyWrapper, outputEncryptor, null);
    }

    private EncryptedValue encryptData(byte[] bArr) throws CRMFException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream outputStream = this.encryptor.getOutputStream(byteArrayOutputStream);
        try {
            outputStream.write(bArr);
            outputStream.close();
            AlgorithmIdentifier algorithmIdentifier = this.encryptor.getAlgorithmIdentifier();
            try {
                this.f18828wrapper.generateWrappedKey(this.encryptor.mo14795getKey());
                return new EncryptedValue(null, algorithmIdentifier, new DERBitString(this.f18828wrapper.generateWrappedKey(this.encryptor.mo14795getKey())), this.f18828wrapper.getAlgorithmIdentifier(), null, new DERBitString(byteArrayOutputStream.toByteArray()));
            } catch (OperatorException e) {
                throw new CRMFException("cannot wrap key: " + e.getMessage(), e);
            }
        } catch (IOException e2) {
            throw new CRMFException("cannot process data: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: padData */
    private byte[] m14782padData(byte[] bArr) {
        EncryptedValuePadder encryptedValuePadder = this.f18827padder;
        return encryptedValuePadder != null ? encryptedValuePadder.getPaddedData(bArr) : bArr;
    }

    /* renamed from: build */
    public EncryptedValue m14783build(PrivateKeyInfo privateKeyInfo) throws CRMFException, IOException {
        try {
            return new EncryptedValue(privateKeyInfo.getPrivateKeyAlgorithm(), this.encryptor.getAlgorithmIdentifier(), new DERBitString(this.f18828wrapper.generateWrappedKey(this.encryptor.mo14795getKey())), this.f18828wrapper.getAlgorithmIdentifier(), null, new DERBitString(new PKCS8EncryptedPrivateKeyInfoBuilder(privateKeyInfo).m17414build(this.encryptor).getEncryptedData()));
        } catch (IllegalStateException e) {
            throw new CRMFException("cannot encode key: " + e.getMessage(), e);
        } catch (OperatorException e2) {
            throw new CRMFException("cannot wrap key: " + e2.getMessage(), e2);
        }
    }

    public EncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor, EncryptedValuePadder encryptedValuePadder) {
        this.f18828wrapper = keyWrapper;
        this.encryptor = outputEncryptor;
        this.f18827padder = encryptedValuePadder;
    }

    /* renamed from: build */
    public EncryptedValue m14784build(X509CertificateHolder x509CertificateHolder) throws CRMFException {
        try {
            return encryptData(m14782padData(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new CRMFException("cannot encode certificate: " + e.getMessage(), e);
        }
    }

    /* renamed from: build */
    public EncryptedValue m14785build(char[] cArr) {
        return encryptData(m14782padData(C6250Strings.toUTF8ByteArray(cArr)));
    }
}
