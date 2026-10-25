package org.bouncycastle.p191cms;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.SignedData;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.Encodable;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class CMSSignedData implements Encodable {
    ContentInfo contentInfo;

    /* renamed from: hashes */
    private Map f18986hashes;
    CMSTypedData signedContent;
    SignedData signedData;
    SignerInformationStore signerInfoStore;

    /* renamed from: HELPER */
    private static final CMSSignedHelper f18985HELPER = CMSSignedHelper.INSTANCE;
    private static final DefaultDigestAlgorithmIdentifierFinder DIGEST_ALG_ID_FINDER = new DefaultDigestAlgorithmIdentifierFinder();

    public CMSSignedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public static CMSSignedData addDigestAlgorithm(CMSSignedData cMSSignedData, AlgorithmIdentifier algorithmIdentifier) {
        return addDigestAlgorithm(cMSSignedData, algorithmIdentifier, DIGEST_ALG_ID_FINDER);
    }

    private static void compareAndReplaceAlgIds(AlgorithmIdentifier[] algorithmIdentifierArr, AlgorithmIdentifier[] algorithmIdentifierArr2) {
        for (int i = 0; i != algorithmIdentifierArr2.length; i++) {
            AlgorithmIdentifier algorithmIdentifier = algorithmIdentifierArr2[i];
            for (int i2 = 0; i2 != algorithmIdentifierArr.length; i2++) {
                AlgorithmIdentifier algorithmIdentifier2 = algorithmIdentifierArr[i2];
                if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm()) && (algorithmIdentifier.getParameters() == null || C5103DERNull.INSTANCE.m14445equals(algorithmIdentifier.getParameters()))) {
                    algorithmIdentifierArr2[i] = algorithmIdentifier2;
                    break;
                }
            }
        }
    }

    private SignedData getSignedData() throws CMSException {
        try {
            return SignedData.getInstance(this.contentInfo.getContent());
        } catch (ClassCastException e) {
            throw new CMSException("Malformed content.", e);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("Malformed content.", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CMSSignedData replaceCertificatesAndCRLs(CMSSignedData cMSSignedData, InterfaceC6249Store interfaceC6249Store, InterfaceC6249Store interfaceC6249Store2, InterfaceC6249Store interfaceC6249Store3) {
        AbstractC5093ASN1Set abstractC5093ASN1Set;
        AbstractC5093ASN1Set abstractC5093ASN1Set2;
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        if (interfaceC6249Store != null || interfaceC6249Store2 != null) {
            ArrayList arrayList = new ArrayList();
            if (interfaceC6249Store != null) {
                arrayList.addAll(CMSUtils.getCertificatesFromStore(interfaceC6249Store));
            }
            if (interfaceC6249Store2 != null) {
                arrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(interfaceC6249Store2));
            }
            AbstractC5093ASN1Set abstractC5093ASN1SetCreateBerSetFromList = CMSUtils.createBerSetFromList(arrayList);
            abstractC5093ASN1Set = abstractC5093ASN1SetCreateBerSetFromList.m14454size() != 0 ? abstractC5093ASN1SetCreateBerSetFromList : null;
        }
        if (interfaceC6249Store3 != null) {
            AbstractC5093ASN1Set abstractC5093ASN1SetCreateBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(interfaceC6249Store3));
            abstractC5093ASN1Set2 = abstractC5093ASN1SetCreateBerSetFromList2.m14454size() != 0 ? abstractC5093ASN1SetCreateBerSetFromList2 : null;
        }
        cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), abstractC5093ASN1Set, abstractC5093ASN1Set2, cMSSignedData.signedData.getSignerInfos());
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore) {
        return replaceSigners(cMSSignedData, signerInformationStore, DIGEST_ALG_ID_FINDER);
    }

    private boolean verifyCounterSignature(SignerInformation signerInformation, SignerInformationVerifierProvider signerInformationVerifierProvider) {
        if (!signerInformation.m14902verify(signerInformationVerifierProvider.m14905get(signerInformation.m14901getSID()))) {
            return false;
        }
        Iterator<SignerInformation> it = signerInformation.getCounterSignatures().getSigners().iterator();
        while (it.hasNext()) {
            if (!verifyCounterSignature(it.next(), signerInformationVerifierProvider)) {
                return false;
            }
        }
        return true;
    }

    public InterfaceC6249Store<X509AttributeCertificateHolder> getAttributeCertificates() {
        return f18985HELPER.getAttributeCertificates(this.signedData.getCertificates());
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store<X509CRLHolder> m14867getCRLs() {
        return f18985HELPER.m14876getCRLs(this.signedData.m14553getCRLs());
    }

    public InterfaceC6249Store<X509CertificateHolder> getCertificates() {
        return f18985HELPER.getCertificates(this.signedData.getCertificates());
    }

    public Set<AlgorithmIdentifier> getDigestAlgorithmIDs() {
        HashSet hashSet = new HashSet();
        Enumeration objects = this.signedData.getDigestAlgorithms().getObjects();
        while (objects.hasMoreElements()) {
            hashSet.add(AlgorithmIdentifier.getInstance(objects.nextElement()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public InterfaceC6249Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f18985HELPER.getOtherRevocationInfo(aSN1ObjectIdentifier, this.signedData.m14553getCRLs());
    }

    public CMSTypedData getSignedContent() {
        return this.signedContent;
    }

    public String getSignedContentTypeOID() {
        return this.signedData.getEncapContentInfo().getContentType().m14433getId();
    }

    public SignerInformationStore getSignerInfos() {
        Map map;
        Object algorithm;
        if (this.signerInfoStore == null) {
            AbstractC5093ASN1Set signerInfos = this.signedData.getSignerInfos();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != signerInfos.m14454size(); i++) {
                SignerInfo signerInfo = SignerInfo.getInstance(signerInfos.getObjectAt(i));
                ASN1ObjectIdentifier contentType = this.signedData.getEncapContentInfo().getContentType();
                Map map2 = this.f18986hashes;
                if (map2 == null) {
                    arrayList.add(new SignerInformation(signerInfo, contentType, this.signedContent, null));
                } else {
                    if (map2.keySet().iterator().next() instanceof String) {
                        map = this.f18986hashes;
                        algorithm = signerInfo.getDigestAlgorithm().getAlgorithm().m14433getId();
                    } else {
                        map = this.f18986hashes;
                        algorithm = signerInfo.getDigestAlgorithm().getAlgorithm();
                    }
                    arrayList.add(new SignerInformation(signerInfo, contentType, null, (byte[]) map.get(algorithm)));
                }
            }
            this.signerInfoStore = new SignerInformationStore(arrayList);
        }
        return this.signerInfoStore;
    }

    public int getVersion() {
        return this.signedData.getVersion().intValueExact();
    }

    public boolean isCertificateManagementMessage() {
        return this.signedData.getEncapContentInfo().getContent() == null && this.signedData.getSignerInfos().m14454size() == 0;
    }

    public boolean isDetachedSignature() {
        return this.signedData.getEncapContentInfo().getContent() == null && this.signedData.getSignerInfos().m14454size() > 0;
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider) {
        return verifySignatures(signerInformationVerifierProvider, false);
    }

    public CMSSignedData(Map map, ContentInfo contentInfo) {
        this.f18986hashes = map;
        this.contentInfo = contentInfo;
        this.signedData = getSignedData();
    }

    public static CMSSignedData addDigestAlgorithm(CMSSignedData cMSSignedData, AlgorithmIdentifier algorithmIdentifier, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        Set<AlgorithmIdentifier> digestAlgorithmIDs = cMSSignedData.getDigestAlgorithmIDs();
        AlgorithmIdentifier algorithmIdentifierFixDigestAlgID = f18985HELPER.fixDigestAlgID(algorithmIdentifier, digestAlgorithmIdentifierFinder);
        if (digestAlgorithmIDs.contains(algorithmIdentifierFixDigestAlgID)) {
            return cMSSignedData;
        }
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        HashSet hashSet = new HashSet();
        Iterator<AlgorithmIdentifier> it = digestAlgorithmIDs.iterator();
        while (it.hasNext()) {
            hashSet.add(f18985HELPER.fixDigestAlgID(it.next(), digestAlgorithmIdentifierFinder));
        }
        hashSet.add(algorithmIdentifierFixDigestAlgID);
        AbstractC5093ASN1Set abstractC5093ASN1SetConvertToDlSet = CMSUtils.convertToDlSet(hashSet);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.toASN1Primitive();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(aSN1Sequence.mo14450size());
        aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector.m14420add(abstractC5093ASN1SetConvertToDlSet);
        for (int i = 2; i != aSN1Sequence.mo14450size(); i++) {
            aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(i));
        }
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        cMSSignedData2.signerInfoStore = signerInformationStore;
        HashSet hashSet = new HashSet();
        Collection<SignerInformation> signers = signerInformationStore.getSigners();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(signers.size());
        for (SignerInformation signerInformation : signers) {
            CMSUtils.addDigestAlgs(hashSet, signerInformation, digestAlgorithmIdentifierFinder);
            aSN1EncodableVector.m14420add(signerInformation.toASN1Structure());
        }
        Set<AlgorithmIdentifier> digestAlgorithmIDs = cMSSignedData.getDigestAlgorithmIDs();
        AlgorithmIdentifier[] algorithmIdentifierArr = (AlgorithmIdentifier[]) digestAlgorithmIDs.toArray(new AlgorithmIdentifier[digestAlgorithmIDs.size()]);
        AlgorithmIdentifier[] algorithmIdentifierArr2 = (AlgorithmIdentifier[]) hashSet.toArray(new AlgorithmIdentifier[hashSet.size()]);
        compareAndReplaceAlgIds(algorithmIdentifierArr, algorithmIdentifierArr2);
        C5105DLSet c5105DLSet = new C5105DLSet(algorithmIdentifierArr2);
        C5105DLSet c5105DLSet2 = new C5105DLSet(aSN1EncodableVector);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.toASN1Primitive();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(aSN1Sequence.mo14450size());
        aSN1EncodableVector2.m14420add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector2.m14420add(c5105DLSet);
        for (int i = 2; i != aSN1Sequence.mo14450size() - 1; i++) {
            aSN1EncodableVector2.m14420add(aSN1Sequence.getObjectAt(i));
        }
        aSN1EncodableVector2.m14420add(c5105DLSet2);
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector2));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public byte[] getEncoded(String str) {
        return this.contentInfo.getEncoded(str);
    }

    public boolean verifySignatures(SignerInformationVerifierProvider signerInformationVerifierProvider, boolean z) throws CMSException {
        for (SignerInformation signerInformation : getSignerInfos().getSigners()) {
            try {
                if (!signerInformation.m14902verify(signerInformationVerifierProvider.m14905get(signerInformation.m14901getSID()))) {
                    return false;
                }
                if (!z) {
                    Iterator<SignerInformation> it = signerInformation.getCounterSignatures().getSigners().iterator();
                    while (it.hasNext()) {
                        if (!verifyCounterSignature(it.next(), signerInformationVerifierProvider)) {
                            return false;
                        }
                    }
                }
            } catch (OperatorCreationException e) {
                throw new CMSException("failure in verifier provider: " + e.getMessage(), e);
            }
        }
        return true;
    }

    public CMSSignedData(Map map, byte[] bArr) {
        this(map, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(ContentInfo contentInfo) throws CMSException {
        this.contentInfo = contentInfo;
        SignedData signedData = getSignedData();
        this.signedData = signedData;
        ASN1Encodable content = signedData.getEncapContentInfo().getContent();
        if (content != null) {
            this.signedContent = content instanceof ASN1OctetString ? new CMSProcessableByteArray(this.signedData.getEncapContentInfo().getContentType(), ((ASN1OctetString) content).getOctets()) : new PKCS7ProcessableObject(this.signedData.getEncapContentInfo().getContentType(), content);
        } else {
            this.signedContent = null;
        }
    }

    public CMSSignedData(CMSProcessable cMSProcessable, InputStream inputStream) {
        this(cMSProcessable, CMSUtils.readContentInfo((InputStream) new ASN1InputStream(inputStream)));
    }

    public CMSSignedData(final CMSProcessable cMSProcessable, ContentInfo contentInfo) {
        if (cMSProcessable instanceof CMSTypedData) {
            this.signedContent = (CMSTypedData) cMSProcessable;
        } else {
            this.signedContent = new CMSTypedData(this) { // from class: org.bouncycastle.cms.CMSSignedData.1

                /* renamed from: this$0 */
                final /* synthetic */ CMSSignedData f18987this$0;

                {
                    this.f18987this$0 = this;
                }

                @Override // org.bouncycastle.p191cms.CMSProcessable
                public Object getContent() {
                    return cMSProcessable.getContent();
                }

                @Override // org.bouncycastle.p191cms.CMSTypedData
                public ASN1ObjectIdentifier getContentType() {
                    return this.f18987this$0.signedData.getEncapContentInfo().getContentType();
                }

                @Override // org.bouncycastle.p191cms.CMSProcessable
                /* renamed from: write */
                public void mo14759write(OutputStream outputStream) {
                    cMSProcessable.mo14759write(outputStream);
                }
            };
        }
        this.contentInfo = contentInfo;
        this.signedData = getSignedData();
    }

    public CMSSignedData(CMSProcessable cMSProcessable, byte[] bArr) {
        this(cMSProcessable, CMSUtils.readContentInfo(bArr));
    }

    private CMSSignedData(CMSSignedData cMSSignedData) {
        this.signedData = cMSSignedData.signedData;
        this.contentInfo = cMSSignedData.contentInfo;
        this.signedContent = cMSSignedData.signedContent;
        this.signerInfoStore = cMSSignedData.signerInfoStore;
    }

    public CMSSignedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }
}
