package org.conscrypt.p368ct;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class SignedCertificateTimestamp {
    private final byte[] extensions;

    /* renamed from: logId */
    private final byte[] f24485logId;

    /* renamed from: origin */
    private final EnumC6340Origin f24486origin;
    private final DigitallySigned signature;
    private final long timestamp;

    /* renamed from: version */
    private final EnumC6341Version f24487version;

    /* renamed from: org.conscrypt.ct.SignedCertificateTimestamp$Origin */
    public enum EnumC6340Origin {
        EMBEDDED,
        TLS_EXTENSION,
        OCSP_RESPONSE
    }

    public enum SignatureType {
        CERTIFICATE_TIMESTAMP,
        TREE_HASH
    }

    /* renamed from: org.conscrypt.ct.SignedCertificateTimestamp$Version */
    public enum EnumC6341Version {
        V1
    }

    public SignedCertificateTimestamp(EnumC6341Version enumC6341Version, byte[] bArr, long j, byte[] bArr2, DigitallySigned digitallySigned, EnumC6340Origin enumC6340Origin) {
        this.f24487version = enumC6341Version;
        this.f24485logId = bArr;
        this.timestamp = j;
        this.extensions = bArr2;
        this.signature = digitallySigned;
        this.f24486origin = enumC6340Origin;
    }

    /* renamed from: decode */
    public static SignedCertificateTimestamp m18527decode(InputStream inputStream, EnumC6340Origin enumC6340Origin) throws SerializationException {
        int number = Serialization.readNumber(inputStream, 1);
        EnumC6341Version enumC6341Version = EnumC6341Version.V1;
        if (number == enumC6341Version.ordinal()) {
            return new SignedCertificateTimestamp(enumC6341Version, Serialization.readFixedBytes(inputStream, 32), Serialization.readLong(inputStream, 8), Serialization.readVariableBytes(inputStream, 2), DigitallySigned.m18519decode(inputStream), enumC6340Origin);
        }
        throw new SerializationException("Unsupported SCT version " + number);
    }

    public void encodeTBS(OutputStream outputStream, CertificateEntry certificateEntry) throws IOException, SerializationException {
        Serialization.writeNumber(outputStream, this.f24487version.ordinal(), 1);
        Serialization.writeNumber(outputStream, SignatureType.CERTIFICATE_TIMESTAMP.ordinal(), 1);
        Serialization.writeNumber(outputStream, this.timestamp, 8);
        certificateEntry.m18516encode(outputStream);
        Serialization.writeVariableBytes(outputStream, this.extensions, 2);
    }

    public byte[] getExtensions() {
        return this.extensions;
    }

    public byte[] getLogID() {
        return this.f24485logId;
    }

    public EnumC6340Origin getOrigin() {
        return this.f24486origin;
    }

    public DigitallySigned getSignature() {
        return this.signature;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public EnumC6341Version getVersion() {
        return this.f24487version;
    }

    public byte[] encodeTBS(CertificateEntry certificateEntry) throws IOException, SerializationException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encodeTBS(byteArrayOutputStream, certificateEntry);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: decode */
    public static SignedCertificateTimestamp m18528decode(byte[] bArr, EnumC6340Origin enumC6340Origin) {
        return m18527decode(new ByteArrayInputStream(bArr), enumC6340Origin);
    }
}
