package org.bouncycastle.p358tsp.p360ers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* renamed from: org.bouncycastle.tsp.ers.ERSUtil */
/* loaded from: classes2.dex */
class C6236ERSUtil {
    private static final Comparator<byte[]> hashComp = new ByteArrayComparator();

    private C6236ERSUtil() {
    }

    public static List<byte[]> buildHashList(DigestCalculator digestCalculator, List<InterfaceC6235ERSData> list, byte[] bArr) {
        SortedHashList sortedHashList = new SortedHashList();
        for (int i = 0; i != list.size(); i++) {
            sortedHashList.m18217add(list.get(i).mo18212getHash(digestCalculator, bArr));
        }
        return sortedHashList.m18219toList();
    }

    public static List<IndexedHash> buildIndexedHashList(DigestCalculator digestCalculator, List<InterfaceC6235ERSData> list, byte[] bArr) {
        SortedIndexedHashList sortedIndexedHashList = new SortedIndexedHashList();
        for (int i = 0; i != list.size(); i++) {
            sortedIndexedHashList.m18220add(new IndexedHash(i, list.get(i).mo18212getHash(digestCalculator, bArr)));
        }
        return sortedIndexedHashList.m18222toList();
    }

    public static byte[] calculateBranchHash(DigestCalculator digestCalculator, byte[] bArr, byte[] bArr2) {
        return hashComp.compare(bArr, bArr2) <= 0 ? calculateDigest(digestCalculator, bArr, bArr2) : calculateDigest(digestCalculator, bArr2, bArr);
    }

    public static byte[] calculateDigest(DigestCalculator digestCalculator, InputStream inputStream) throws IOException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            C6257Streams.m18361pipeAll(inputStream, outputStream);
            outputStream.close();
            return digestCalculator.getDigest();
        } catch (IOException e) {
            throw C6237ExpUtil.createIllegalState("unable to calculate hash: " + e.getMessage(), e);
        }
    }

    public static byte[] computeNodeHash(DigestCalculator digestCalculator, PartialHashtree partialHashtree) {
        byte[][] values = partialHashtree.getValues();
        return values.length > 1 ? calculateDigest(digestCalculator, buildIndexedHashList(values).iterator()) : values[0];
    }

    public static byte[] concatPreviousHashes(DigestCalculator digestCalculator, byte[] bArr, byte[] bArr2) throws IOException {
        if (bArr == null) {
            return bArr2;
        }
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(bArr2);
            outputStream.write(bArr);
            outputStream.close();
            return digestCalculator.getDigest();
        } catch (IOException unused) {
            throw new IllegalStateException("unable to hash data");
        }
    }

    public static List<byte[]> buildIndexedHashList(byte[][] bArr) {
        SortedHashList sortedHashList = new SortedHashList();
        for (int i = 0; i != bArr.length; i++) {
            sortedHashList.m18217add(bArr[i]);
        }
        return sortedHashList.m18219toList();
    }

    public static byte[] calculateBranchHash(DigestCalculator digestCalculator, byte[][] bArr) {
        return bArr.length == 2 ? calculateBranchHash(digestCalculator, bArr[0], bArr[1]) : calculateDigest(digestCalculator, buildIndexedHashList(bArr).iterator());
    }

    public static byte[] calculateDigest(DigestCalculator digestCalculator, Iterator<byte[]> it) throws IOException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            while (it.hasNext()) {
                outputStream.write(it.next());
            }
            outputStream.close();
            return digestCalculator.getDigest();
        } catch (IOException e) {
            throw C6237ExpUtil.createIllegalState("unable to calculate hash: " + e.getMessage(), e);
        }
    }

    public static byte[] calculateDigest(DigestCalculator digestCalculator, byte[] bArr) throws IOException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            return digestCalculator.getDigest();
        } catch (IOException e) {
            throw C6237ExpUtil.createIllegalState("unable to calculate hash: " + e.getMessage(), e);
        }
    }

    public static byte[] calculateDigest(DigestCalculator digestCalculator, byte[] bArr, byte[] bArr2) throws IOException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(bArr);
            outputStream.write(bArr2);
            outputStream.close();
            return digestCalculator.getDigest();
        } catch (IOException e) {
            throw C6237ExpUtil.createIllegalState("unable to calculate hash: " + e.getMessage(), e);
        }
    }
}
