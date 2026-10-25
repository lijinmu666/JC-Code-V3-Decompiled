package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;

/* loaded from: classes2.dex */
public class CMSAuthEnvelopedGenerator extends CMSEnvelopedGenerator {
    protected OriginatorInfo originatorInfo;
    public static final String AES128_CCM = CMSAlgorithm.AES128_CCM.m14433getId();
    public static final String AES192_CCM = CMSAlgorithm.AES192_CCM.m14433getId();
    public static final String AES256_CCM = CMSAlgorithm.AES256_CCM.m14433getId();
    public static final String AES128_GCM = CMSAlgorithm.AES128_GCM.m14433getId();
    public static final String AES192_GCM = CMSAlgorithm.AES192_GCM.m14433getId();
    public static final String AES256_GCM = CMSAlgorithm.AES256_GCM.m14433getId();
    public static final String ChaCha20Poly1305 = CMSAlgorithm.ChaCha20Poly1305.m14433getId();
    protected CMSAttributeTableGenerator authAttrsGenerator = null;
    protected CMSAttributeTableGenerator unauthAttrsGenerator = null;

    public void setAuthenticatedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.authAttrsGenerator = cMSAttributeTableGenerator;
    }

    @Override // org.bouncycastle.p191cms.CMSEnvelopedGenerator
    public void setOriginatorInfo(OriginatorInformation originatorInformation) {
        this.originatorInfo = originatorInformation.toASN1Structure();
    }

    public void setUnauthenticatedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unauthAttrsGenerator = cMSAttributeTableGenerator;
    }
}
