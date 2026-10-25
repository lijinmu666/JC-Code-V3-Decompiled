package org.bouncycastle.p358tsp.p360ers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bouncycastle.operator.DigestCalculator;

/* loaded from: classes2.dex */
public class ERSFileData extends ERSCachingData {

    /* renamed from: content */
    private final File f24186content;

    public ERSFileData(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("directory not allowed as ERSFileData");
        }
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath() + " does not exist");
        }
        if (file.canRead()) {
            this.f24186content = file;
            return;
        }
        throw new FileNotFoundException(file.getAbsolutePath() + " is not readable");
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSCachingData
    public byte[] calculateHash(DigestCalculator digestCalculator, byte[] bArr) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f24186content);
            byte[] bArrCalculateDigest = C6236ERSUtil.calculateDigest(digestCalculator, fileInputStream);
            fileInputStream.close();
            return bArr != null ? C6236ERSUtil.concatPreviousHashes(digestCalculator, bArr, bArrCalculateDigest) : bArrCalculateDigest;
        } catch (IOException unused) {
            throw new IllegalStateException("unable to process " + this.f24186content.getAbsolutePath());
        }
    }
}
