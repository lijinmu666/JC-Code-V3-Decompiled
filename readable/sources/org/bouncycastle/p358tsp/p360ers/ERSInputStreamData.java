package org.bouncycastle.p358tsp.p360ers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class ERSInputStreamData extends ERSCachingData {
    private final byte[] contentBytes;
    private final File contentFile;

    public ERSInputStreamData(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("directory not allowed");
        }
        if (file.exists()) {
            this.contentBytes = null;
            this.contentFile = file;
        } else {
            throw new FileNotFoundException(file + " not found");
        }
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSCachingData
    public byte[] calculateHash(DigestCalculator digestCalculator, byte[] bArr) throws IOException {
        byte[] bArrCalculateDigest;
        byte[] bArr2 = this.contentBytes;
        if (bArr2 != null) {
            bArrCalculateDigest = C6236ERSUtil.calculateDigest(digestCalculator, bArr2);
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.contentFile);
                bArrCalculateDigest = C6236ERSUtil.calculateDigest(digestCalculator, fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                throw C6237ExpUtil.createIllegalState("unable to open content: " + e.getMessage(), e);
            }
        }
        return bArr != null ? C6236ERSUtil.concatPreviousHashes(digestCalculator, bArr, bArrCalculateDigest) : bArrCalculateDigest;
    }

    public ERSInputStreamData(InputStream inputStream) {
        try {
            this.contentBytes = C6257Streams.m18363readAll(inputStream);
            this.contentFile = null;
        } catch (IOException e) {
            throw C6237ExpUtil.createIllegalState("unable to open content: " + e.getMessage(), e);
        }
    }
}
