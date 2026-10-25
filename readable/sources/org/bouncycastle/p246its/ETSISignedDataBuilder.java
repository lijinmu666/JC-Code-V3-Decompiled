package org.bouncycastle.p246its;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p246its.operator.ECDSAEncoder;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.C5929Opaque;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Certificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.HashedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.HeaderInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Data;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SequenceOfCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SignedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SignedDataPayload;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SignerIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5954Psid;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5970Time64;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;

/* loaded from: classes2.dex */
public class ETSISignedDataBuilder {

    /* renamed from: def */
    private static final C5887Element f21287def = IEEE1609dot2.ToBeSignedData.m17146build();

    /* renamed from: data */
    private Ieee1609Dot2Data f21288data;
    private HashedData extDataHash;
    private final HeaderInfo headerInfo;

    private ETSISignedDataBuilder(HeaderInfo headerInfo) {
        this.headerInfo = headerInfo;
    }

    /* renamed from: builder */
    public static ETSISignedDataBuilder m15996builder(HeaderInfo headerInfo) {
        return new ETSISignedDataBuilder(headerInfo);
    }

    private ToBeSignedData getToBeSignedData() {
        return ToBeSignedData.m17253builder().setPayload(new SignedDataPayload(this.f21288data, this.extDataHash)).setHeaderInfo(this.headerInfo).createToBeSignedData();
    }

    /* renamed from: write */
    private static void m15998write(OutputStream outputStream, byte[] bArr) throws IOException {
        try {
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: build */
    public ETSISignedData m15999build(ITSContentSigner iTSContentSigner) throws IOException {
        ToBeSignedData toBeSignedData = getToBeSignedData();
        m15998write(iTSContentSigner.getOutputStream(), OEREncoder.toByteArray(toBeSignedData, f21287def));
        return new ETSISignedData(SignedData.m17242builder().setHashId(ITSAlgorithmUtils.getHashAlgorithm(iTSContentSigner.getDigestAlgorithm().getAlgorithm())).setTbsData(toBeSignedData).setSigner(SignerIdentifier.m17247self()).setSignature(ECDSAEncoder.m16041toITS(iTSContentSigner.getCurveID(), iTSContentSigner.getSignature())).createSignedData());
    }

    /* renamed from: setData */
    public ETSISignedDataBuilder m16002setData(Ieee1609Dot2Content ieee1609Dot2Content) {
        this.f21288data = Ieee1609Dot2Data.m17230builder().setProtocolVersion(new C5976UINT8(3)).setContent(ieee1609Dot2Content).createIeee1609Dot2Data();
        return this;
    }

    public ETSISignedDataBuilder setExtDataHash(HashedData hashedData) {
        this.extDataHash = hashedData;
        return this;
    }

    public ETSISignedDataBuilder setUnsecuredData(byte[] bArr) {
        this.f21288data = Ieee1609Dot2Data.m17230builder().setProtocolVersion(new C5976UINT8(3)).setContent(Ieee1609Dot2Content.unsecuredData(new C5929Opaque(bArr))).createEtsiTs103097Data();
        return this;
    }

    private ETSISignedDataBuilder(C5954Psid c5954Psid) {
        this(HeaderInfo.m17227builder().m17229setPsid(c5954Psid).setGenerationTime(C5970Time64.m17344now()).createHeaderInfo());
    }

    /* renamed from: builder */
    public static ETSISignedDataBuilder m15997builder(C5954Psid c5954Psid) {
        return new ETSISignedDataBuilder(c5954Psid);
    }

    /* renamed from: build */
    public ETSISignedData m16000build(ITSContentSigner iTSContentSigner, List<ITSCertificate> list) throws IOException {
        ToBeSignedData toBeSignedData = getToBeSignedData();
        m15998write(iTSContentSigner.getOutputStream(), OEREncoder.toByteArray(toBeSignedData, f21287def));
        ArrayList arrayList = new ArrayList();
        Iterator<ITSCertificate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Certificate.getInstance((Object) it.next().toASN1Structure()));
        }
        return new ETSISignedData(SignedData.m17242builder().setHashId(ITSAlgorithmUtils.getHashAlgorithm(iTSContentSigner.getDigestAlgorithm().getAlgorithm())).setTbsData(toBeSignedData).setSigner(SignerIdentifier.certificate(new SequenceOfCertificate(arrayList))).setSignature(ECDSAEncoder.m16041toITS(iTSContentSigner.getCurveID(), iTSContentSigner.getSignature())).createSignedData());
    }

    /* renamed from: build */
    public ETSISignedData m16001build(ITSContentSigner iTSContentSigner, HashedId8 hashedId8) throws IOException {
        ToBeSignedData toBeSignedData = getToBeSignedData();
        m15998write(iTSContentSigner.getOutputStream(), OEREncoder.toByteArray(toBeSignedData, f21287def));
        return new ETSISignedData(SignedData.m17242builder().setHashId(ITSAlgorithmUtils.getHashAlgorithm(iTSContentSigner.getDigestAlgorithm().getAlgorithm())).setTbsData(toBeSignedData).setSigner(SignerIdentifier.m17246digest(hashedId8)).setSignature(ECDSAEncoder.m16041toITS(iTSContentSigner.getCurveID(), iTSContentSigner.getSignature())).createSignedData());
    }
}
