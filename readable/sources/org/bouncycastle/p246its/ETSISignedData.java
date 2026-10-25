package org.bouncycastle.p246its;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.p246its.operator.ECDSAEncoder;
import org.bouncycastle.p246its.operator.ITSContentVerifierProvider;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.OERInputStream;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSigned;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.C5929Opaque;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SignedData;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;

/* loaded from: classes2.dex */
public class ETSISignedData {

    /* renamed from: oerDef */
    private static final C5887Element f21286oerDef = EtsiTs103097Module.EtsiTs103097Data_Signed.m17146build();
    private final SignedData signedData;

    public ETSISignedData(InputStream inputStream) {
        Ieee1609Dot2Content content = EtsiTs103097DataSigned.getInstance((Object) (inputStream instanceof OERInputStream ? (OERInputStream) inputStream : new OERInputStream(inputStream)).m17161parse(f21286oerDef)).getContent();
        if (content.getChoice() != 1) {
            throw new IllegalStateException("EtsiTs103097Data-Signed did not have signed data content");
        }
        this.signedData = SignedData.getInstance(content.getIeee1609Dot2Content());
    }

    public byte[] getEncoded() {
        return OEREncoder.toByteArray(new EtsiTs103097DataSigned(Ieee1609Dot2Content.signedData(this.signedData)), EtsiTs103097Module.EtsiTs103097Data_Signed.m17146build());
    }

    public SignedData getSignedData() {
        return this.signedData;
    }

    public boolean signatureValid(ITSContentVerifierProvider iTSContentVerifierProvider) throws IOException {
        ContentVerifier contentVerifierMo16014get = iTSContentVerifierProvider.mo16014get(this.signedData.getSignature().getChoice());
        OutputStream outputStream = contentVerifierMo16014get.getOutputStream();
        outputStream.write(OEREncoder.toByteArray(this.signedData.getTbsData(), IEEE1609dot2.ToBeSignedData.m17146build()));
        outputStream.close();
        return contentVerifierMo16014get.mo16015verify(ECDSAEncoder.m16042toX962(this.signedData.getSignature()));
    }

    public ETSISignedData(EtsiTs103097DataSigned etsiTs103097DataSigned) {
        if (etsiTs103097DataSigned.getContent().getChoice() != 1) {
            throw new IllegalStateException("EtsiTs103097Data-Signed did not have signed data content");
        }
        this.signedData = SignedData.getInstance(etsiTs103097DataSigned.getContent());
    }

    public ETSISignedData(C5929Opaque c5929Opaque) {
        this(c5929Opaque.getInputStream());
    }

    public ETSISignedData(SignedData signedData) {
        this.signedData = signedData;
    }

    public ETSISignedData(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
