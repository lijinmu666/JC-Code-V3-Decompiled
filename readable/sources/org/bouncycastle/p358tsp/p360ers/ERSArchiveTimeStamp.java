package org.bouncycastle.p358tsp.p360ers;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.p169tsp.ArchiveTimeStamp;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.SignerInformationVerifier;
import org.bouncycastle.p358tsp.TimeStampToken;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class ERSArchiveTimeStamp {
    private final ArchiveTimeStamp archiveTimeStamp;

    /* renamed from: digCalc */
    private final DigestCalculator f24176digCalc;
    private final byte[] previousChainsDigest;
    private ERSRootNodeCalculator rootNodeCalculator;
    private final TimeStampToken timeStampToken;

    public ERSArchiveTimeStamp(ArchiveTimeStamp archiveTimeStamp, DigestCalculator digestCalculator) throws ERSException {
        this.rootNodeCalculator = new BinaryTreeRootCalculator();
        this.previousChainsDigest = null;
        try {
            this.archiveTimeStamp = archiveTimeStamp;
            this.timeStampToken = new TimeStampToken(archiveTimeStamp.getTimeStamp());
            this.f24176digCalc = digestCalculator;
        } catch (IOException e) {
            throw new ERSException(e.getMessage(), e);
        }
    }

    public static ERSArchiveTimeStamp fromTimeStampToken(TimeStampToken timeStampToken, DigestCalculatorProvider digestCalculatorProvider) {
        return new ERSArchiveTimeStamp(new ArchiveTimeStamp(timeStampToken.toCMSSignedData().toASN1Structure()), digestCalculatorProvider);
    }

    public void checkContainsHashValue(boolean z, byte[] bArr, DigestCalculator digestCalculator) throws ArchiveTimeStampValidationException {
        PartialHashtree[] reducedHashTree = this.archiveTimeStamp.getReducedHashTree();
        if (reducedHashTree == null) {
            if (!C6238Arrays.areEqual(bArr, this.timeStampToken.getTimeStampInfo().getMessageImprintDigest())) {
                throw new ArchiveTimeStampValidationException("object hash not found in wrapped timestamp");
            }
            return;
        }
        PartialHashtree partialHashtree = reducedHashTree[0];
        if (z || !partialHashtree.containsHash(bArr)) {
            if (partialHashtree.getValueCount() <= 1 || !C6238Arrays.areEqual(bArr, C6236ERSUtil.calculateBranchHash(digestCalculator, partialHashtree.getValues()))) {
                throw new ArchiveTimeStampValidationException("object hash not found");
            }
        }
    }

    public void checkTimeStampValid(TimeStampToken timeStampToken, byte[] bArr) throws ArchiveTimeStampValidationException {
        if (bArr != null && !C6238Arrays.areEqual(bArr, timeStampToken.getTimeStampInfo().getMessageImprintDigest())) {
            throw new ArchiveTimeStampValidationException("timestamp hash does not match root");
        }
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.archiveTimeStamp.getDigestAlgorithmIdentifier();
    }

    public byte[] getEncoded() {
        return this.archiveTimeStamp.getEncoded();
    }

    public Date getExpiryTime() {
        X509CertificateHolder signingCertificate = getSigningCertificate();
        if (signingCertificate != null) {
            return signingCertificate.getNotAfter();
        }
        return null;
    }

    public Date getGenTime() {
        return this.timeStampToken.getTimeStampInfo().getGenTime();
    }

    public X509CertificateHolder getSigningCertificate() {
        InterfaceC6249Store<X509CertificateHolder> certificates = this.timeStampToken.getCertificates();
        if (certificates == null) {
            return null;
        }
        Collection<X509CertificateHolder> matches = certificates.getMatches(this.timeStampToken.m18207getSID());
        if (matches.isEmpty()) {
            return null;
        }
        return matches.iterator().next();
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public boolean isContaining(InterfaceC6235ERSData interfaceC6235ERSData, Date date) throws ArchiveTimeStampValidationException {
        if (this.timeStampToken.getTimeStampInfo().getGenTime().after(date)) {
            throw new ArchiveTimeStampValidationException("timestamp generation time is in the future");
        }
        try {
            validatePresent(interfaceC6235ERSData, date);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArchiveTimeStamp toASN1Structure() {
        return this.archiveTimeStamp;
    }

    public void validate(SignerInformationVerifier signerInformationVerifier) {
        this.timeStampToken.validate(signerInformationVerifier);
    }

    public void validatePresent(InterfaceC6235ERSData interfaceC6235ERSData, Date date) throws ArchiveTimeStampValidationException {
        validatePresent(interfaceC6235ERSData instanceof ERSDataGroup, interfaceC6235ERSData.mo18212getHash(this.f24176digCalc, this.previousChainsDigest), date);
    }

    public ERSArchiveTimeStamp(ArchiveTimeStamp archiveTimeStamp, DigestCalculatorProvider digestCalculatorProvider) throws ERSException {
        this.rootNodeCalculator = new BinaryTreeRootCalculator();
        this.previousChainsDigest = null;
        try {
            this.archiveTimeStamp = archiveTimeStamp;
            this.timeStampToken = new TimeStampToken(archiveTimeStamp.getTimeStamp());
            this.f24176digCalc = digestCalculatorProvider.mo14763get(archiveTimeStamp.getDigestAlgorithmIdentifier());
        } catch (IOException e) {
            throw new ERSException(e.getMessage(), e);
        } catch (OperatorCreationException e2) {
            throw new ERSException(e2.getMessage(), e2);
        }
    }

    public void validatePresent(boolean z, byte[] bArr, Date date) throws ArchiveTimeStampValidationException {
        if (this.timeStampToken.getTimeStampInfo().getGenTime().after(date)) {
            throw new ArchiveTimeStampValidationException("timestamp generation time is in the future");
        }
        checkContainsHashValue(z, bArr, this.f24176digCalc);
        if (this.archiveTimeStamp.getReducedHashTree() != null) {
            bArr = this.rootNodeCalculator.recoverRootHash(this.f24176digCalc, this.archiveTimeStamp.getReducedHashTree());
        }
        checkTimeStampValid(this.timeStampToken, bArr);
    }

    public ERSArchiveTimeStamp(byte[] bArr, ArchiveTimeStamp archiveTimeStamp, DigestCalculatorProvider digestCalculatorProvider) throws ERSException {
        this.rootNodeCalculator = new BinaryTreeRootCalculator();
        this.previousChainsDigest = bArr;
        try {
            this.archiveTimeStamp = archiveTimeStamp;
            this.timeStampToken = new TimeStampToken(archiveTimeStamp.getTimeStamp());
            this.f24176digCalc = digestCalculatorProvider.mo14763get(archiveTimeStamp.getDigestAlgorithmIdentifier());
        } catch (IOException e) {
            throw new ERSException(e.getMessage(), e);
        } catch (OperatorCreationException e2) {
            throw new ERSException(e2.getMessage(), e2);
        }
    }

    public ERSArchiveTimeStamp(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) {
        this(ArchiveTimeStamp.getInstance(bArr), digestCalculatorProvider);
    }
}
