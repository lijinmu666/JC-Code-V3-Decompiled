package org.bouncycastle.p361util.p362io.p363pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6253Base64;

/* loaded from: classes2.dex */
public class PemWriter extends BufferedWriter {
    private static final int LINE_LENGTH = 64;

    /* renamed from: buf */
    private char[] f24258buf;
    private final int nlLength;

    public PemWriter(Writer writer) {
        super(writer);
        this.f24258buf = new char[64];
        String strLineSeparator = C6250Strings.lineSeparator();
        this.nlLength = strLineSeparator != null ? strLineSeparator.length() : 2;
    }

    private void writeEncoded(byte[] bArr) throws IOException {
        char[] cArr;
        int i;
        byte[] bArrM18331encode = C6253Base64.m18331encode(bArr);
        int length = 0;
        while (length < bArrM18331encode.length) {
            int i2 = 0;
            while (true) {
                cArr = this.f24258buf;
                if (i2 == cArr.length || (i = length + i2) >= bArrM18331encode.length) {
                    break;
                }
                cArr[i2] = (char) bArrM18331encode[i];
                i2++;
            }
            write(cArr, 0, i2);
            newLine();
            length += this.f24258buf.length;
        }
    }

    private void writePostEncapsulationBoundary(String str) throws IOException {
        write("-----END " + str + "-----");
        newLine();
    }

    private void writePreEncapsulationBoundary(String str) throws IOException {
        write("-----BEGIN " + str + "-----");
        newLine();
    }

    public int getOutputSize(PemObject pemObject) {
        int length = ((pemObject.m18367getType().length() + 10 + this.nlLength) * 2) + 10;
        if (!pemObject.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                length += pemHeader.m18366getName().length() + 2 + pemHeader.getValue().length() + this.nlLength;
            }
            length += this.nlLength;
        }
        int length2 = ((pemObject.getContent().length + 2) / 3) * 4;
        return length + length2 + (((length2 + 63) / 64) * this.nlLength);
    }

    public void writeObject(PemObjectGenerator pemObjectGenerator) throws IOException {
        PemObject pemObjectGenerate = pemObjectGenerator.generate();
        writePreEncapsulationBoundary(pemObjectGenerate.m18367getType());
        if (!pemObjectGenerate.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObjectGenerate.getHeaders()) {
                write(pemHeader.m18366getName());
                write(": ");
                write(pemHeader.getValue());
                newLine();
            }
            newLine();
        }
        writeEncoded(pemObjectGenerate.getContent());
        writePostEncapsulationBoundary(pemObjectGenerate.m18367getType());
    }
}
