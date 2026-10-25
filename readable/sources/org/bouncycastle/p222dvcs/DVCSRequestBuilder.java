package org.bouncycastle.p222dvcs;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p142dvcs.C5124Data;
import org.bouncycastle.p133asn1.p142dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequest;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p191cms.CMSSignedDataGenerator;

/* loaded from: classes2.dex */
public abstract class DVCSRequestBuilder {
    protected final DVCSRequestInformationBuilder requestInformationBuilder;
    private final ExtensionsGenerator extGenerator = new ExtensionsGenerator();
    private final CMSSignedDataGenerator signedDataGen = new CMSSignedDataGenerator();

    public DVCSRequestBuilder(DVCSRequestInformationBuilder dVCSRequestInformationBuilder) {
        this.requestInformationBuilder = dVCSRequestInformationBuilder;
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws DVCSException {
        try {
            this.extGenerator.addExtension(aSN1ObjectIdentifier, z, aSN1Encodable);
        } catch (IOException e) {
            throw new DVCSException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    public DVCSRequest createDVCRequest(C5124Data c5124Data) {
        if (!this.extGenerator.m14688isEmpty()) {
            this.requestInformationBuilder.setExtensions(this.extGenerator.generate());
        }
        return new DVCSRequest(new ContentInfo(DVCSObjectIdentifiers.id_ct_DVCSRequestData, new DVCSRequest(this.requestInformationBuilder.m14585build(), c5124Data)));
    }

    /* renamed from: setDVCS */
    public void m15940setDVCS(GeneralName generalName) {
        this.requestInformationBuilder.m14586setDVCS(generalName);
    }

    public void setDataLocations(GeneralName generalName) {
        this.requestInformationBuilder.setDataLocations(generalName);
    }

    public void setNonce(BigInteger bigInteger) {
        this.requestInformationBuilder.setNonce(bigInteger);
    }

    public void setRequester(GeneralName generalName) {
        this.requestInformationBuilder.setRequester(generalName);
    }

    /* renamed from: setDVCS */
    public void m15941setDVCS(GeneralNames generalNames) {
        this.requestInformationBuilder.m14587setDVCS(generalNames);
    }

    public void setDataLocations(GeneralNames generalNames) {
        this.requestInformationBuilder.setDataLocations(generalNames);
    }
}
