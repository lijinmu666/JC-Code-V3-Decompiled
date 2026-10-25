package org.bouncycastle.p358tsp.p360ers;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p169tsp.ArchiveTimeStamp;
import org.bouncycastle.p133asn1.p169tsp.ArchiveTimeStampSequence;
import org.bouncycastle.p133asn1.p169tsp.C5186TSTInfo;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;
import org.bouncycastle.p358tsp.TSPException;
import org.bouncycastle.p358tsp.TimeStampRequest;
import org.bouncycastle.p358tsp.TimeStampRequestGenerator;
import org.bouncycastle.p358tsp.TimeStampResponse;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ERSArchiveTimeStampGenerator {

    /* renamed from: digCalc */
    private final DigestCalculator f24177digCalc;
    private byte[] previousChainHash;
    private List<InterfaceC6235ERSData> dataObjects = new ArrayList();
    private ERSRootNodeCalculator rootNodeCalculator = new BinaryTreeRootCalculator();

    public ERSArchiveTimeStampGenerator(DigestCalculator digestCalculator) {
        this.f24177digCalc = digestCalculator;
    }

    private IndexedPartialHashtree[] getPartialHashtrees() {
        List<IndexedHash> listBuildIndexedHashList = C6236ERSUtil.buildIndexedHashList(this.f24177digCalc, this.dataObjects, this.previousChainHash);
        IndexedPartialHashtree[] indexedPartialHashtreeArr = new IndexedPartialHashtree[listBuildIndexedHashList.size()];
        HashSet hashSet = new HashSet();
        for (int i = 0; i != this.dataObjects.size(); i++) {
            if (this.dataObjects.get(i) instanceof ERSDataGroup) {
                hashSet.add((ERSDataGroup) this.dataObjects.get(i));
            }
        }
        for (int i2 = 0; i2 != listBuildIndexedHashList.size(); i2++) {
            byte[] bArr = listBuildIndexedHashList.get(i2).f24187digest;
            InterfaceC6235ERSData interfaceC6235ERSData = this.dataObjects.get(listBuildIndexedHashList.get(i2).f24188order);
            if (interfaceC6235ERSData instanceof ERSDataGroup) {
                List<byte[]> hashes = ((ERSDataGroup) interfaceC6235ERSData).getHashes(this.f24177digCalc, this.previousChainHash);
                indexedPartialHashtreeArr[i2] = new IndexedPartialHashtree(listBuildIndexedHashList.get(i2).f24188order, (byte[][]) hashes.toArray(new byte[hashes.size()][]));
            } else {
                indexedPartialHashtreeArr[i2] = new IndexedPartialHashtree(listBuildIndexedHashList.get(i2).f24188order, bArr);
            }
        }
        return indexedPartialHashtreeArr;
    }

    public void addAllData(List<InterfaceC6235ERSData> list) {
        this.dataObjects.addAll(list);
    }

    /* renamed from: addData */
    public void m18211addData(InterfaceC6235ERSData interfaceC6235ERSData) {
        this.dataObjects.add(interfaceC6235ERSData);
    }

    public void addPreviousChains(ArchiveTimeStampSequence archiveTimeStampSequence) throws IOException {
        OutputStream outputStream = this.f24177digCalc.getOutputStream();
        outputStream.write(archiveTimeStampSequence.getEncoded(ASN1Encoding.f17902DER));
        outputStream.close();
        this.previousChainHash = this.f24177digCalc.getDigest();
    }

    public ERSArchiveTimeStamp generateArchiveTimeStamp(TimeStampResponse timeStampResponse) throws ERSException, TSPException {
        IndexedPartialHashtree[] partialHashtrees = getPartialHashtrees();
        if (partialHashtrees.length != 1) {
            throw new ERSException("multiple reduced hash trees found");
        }
        byte[] bArrComputeRootHash = this.rootNodeCalculator.computeRootHash(this.f24177digCalc, partialHashtrees);
        if (timeStampResponse.getStatus() != 0) {
            throw new TSPException("TSP response error status: " + timeStampResponse.getStatusString());
        }
        C5186TSTInfo aSN1Structure = timeStampResponse.getTimeStampToken().getTimeStampInfo().toASN1Structure();
        if (!aSN1Structure.getMessageImprint().getHashAlgorithm().mo14431equals(this.f24177digCalc.getAlgorithmIdentifier())) {
            throw new ERSException("time stamp imprint for wrong algorithm");
        }
        if (C6238Arrays.areEqual(aSN1Structure.getMessageImprint().getHashedMessage(), bArrComputeRootHash)) {
            return partialHashtrees[0].getValueCount() == 1 ? new ERSArchiveTimeStamp(new ArchiveTimeStamp(null, null, timeStampResponse.getTimeStampToken().toCMSSignedData().toASN1Structure()), this.f24177digCalc) : new ERSArchiveTimeStamp(new ArchiveTimeStamp(this.f24177digCalc.getAlgorithmIdentifier(), partialHashtrees, timeStampResponse.getTimeStampToken().toCMSSignedData().toASN1Structure()), this.f24177digCalc);
        }
        throw new ERSException("time stamp imprint for wrong root hash");
    }

    public List<ERSArchiveTimeStamp> generateArchiveTimeStamps(TimeStampResponse timeStampResponse) throws ERSException, TSPException {
        IndexedPartialHashtree[] partialHashtrees = getPartialHashtrees();
        byte[] bArrComputeRootHash = this.rootNodeCalculator.computeRootHash(this.f24177digCalc, partialHashtrees);
        if (timeStampResponse.getStatus() != 0) {
            throw new TSPException("TSP response error status: " + timeStampResponse.getStatusString());
        }
        C5186TSTInfo aSN1Structure = timeStampResponse.getTimeStampToken().getTimeStampInfo().toASN1Structure();
        if (!aSN1Structure.getMessageImprint().getHashAlgorithm().mo14431equals(this.f24177digCalc.getAlgorithmIdentifier())) {
            throw new ERSException("time stamp imprint for wrong algorithm");
        }
        if (!C6238Arrays.areEqual(aSN1Structure.getMessageImprint().getHashedMessage(), bArrComputeRootHash)) {
            throw new ERSException("time stamp imprint for wrong root hash");
        }
        ContentInfo aSN1Structure2 = timeStampResponse.getTimeStampToken().toCMSSignedData().toASN1Structure();
        ArrayList arrayList = new ArrayList();
        if (partialHashtrees.length == 1 && partialHashtrees[0].getValueCount() == 1) {
            arrayList.add(new ERSArchiveTimeStamp(new ArchiveTimeStamp(null, null, aSN1Structure2), this.f24177digCalc));
        } else {
            ERSArchiveTimeStamp[] eRSArchiveTimeStampArr = new ERSArchiveTimeStamp[partialHashtrees.length];
            for (int i = 0; i != partialHashtrees.length; i++) {
                eRSArchiveTimeStampArr[partialHashtrees[i].f24178order] = new ERSArchiveTimeStamp(new ArchiveTimeStamp(this.f24177digCalc.getAlgorithmIdentifier(), this.rootNodeCalculator.computePathToRoot(this.f24177digCalc, partialHashtrees[i], i), aSN1Structure2), this.f24177digCalc);
            }
            for (int i2 = 0; i2 != partialHashtrees.length; i2++) {
                arrayList.add(eRSArchiveTimeStampArr[i2]);
            }
        }
        return arrayList;
    }

    public TimeStampRequest generateTimeStampRequest(TimeStampRequestGenerator timeStampRequestGenerator) {
        return timeStampRequestGenerator.generate(this.f24177digCalc.getAlgorithmIdentifier(), this.rootNodeCalculator.computeRootHash(this.f24177digCalc, getPartialHashtrees()));
    }

    public static class IndexedPartialHashtree extends PartialHashtree {

        /* renamed from: order */
        final int f24178order;

        private IndexedPartialHashtree(int i, byte[] bArr) {
            super(bArr);
            this.f24178order = i;
        }

        private IndexedPartialHashtree(int i, byte[][] bArr) {
            super(bArr);
            this.f24178order = i;
        }
    }

    public TimeStampRequest generateTimeStampRequest(TimeStampRequestGenerator timeStampRequestGenerator, BigInteger bigInteger) {
        return timeStampRequestGenerator.generate(this.f24177digCalc.getAlgorithmIdentifier(), this.rootNodeCalculator.computeRootHash(this.f24177digCalc, getPartialHashtrees()), bigInteger);
    }
}
