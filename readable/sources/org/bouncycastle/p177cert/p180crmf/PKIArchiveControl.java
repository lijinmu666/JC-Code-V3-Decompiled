package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p141crmf.CRMFObjectIdentifiers;
import org.bouncycastle.p133asn1.p141crmf.EncryptedKey;
import org.bouncycastle.p133asn1.p141crmf.PKIArchiveOptions;
import org.bouncycastle.p191cms.CMSEnvelopedData;
import org.bouncycastle.p191cms.CMSException;

/* loaded from: classes2.dex */
public class PKIArchiveControl implements InterfaceC5223Control {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;

    /* renamed from: type */
    private static final ASN1ObjectIdentifier f18831type = CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions;
    private final PKIArchiveOptions pkiArchiveOptions;

    public PKIArchiveControl(PKIArchiveOptions pKIArchiveOptions) {
        this.pkiArchiveOptions = pKIArchiveOptions;
    }

    public int getArchiveType() {
        return this.pkiArchiveOptions.m14565getType();
    }

    public CMSEnvelopedData getEnvelopedData() throws CRMFException {
        try {
            return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, EnvelopedData.getInstance(EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).getValue())));
        } catch (CMSException e) {
            throw new CRMFException("CMS parsing error: " + e.getMessage(), e.getCause());
        } catch (Exception e2) {
            throw new CRMFException("CRMF parsing error: " + e2.getMessage(), e2);
        }
    }

    @Override // org.bouncycastle.p177cert.p180crmf.InterfaceC5223Control
    /* renamed from: getType */
    public ASN1ObjectIdentifier mo14777getType() {
        return f18831type;
    }

    @Override // org.bouncycastle.p177cert.p180crmf.InterfaceC5223Control
    public ASN1Encodable getValue() {
        return this.pkiArchiveOptions;
    }

    public boolean isEnvelopedData() {
        return !EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).isEncryptedValue();
    }
}
