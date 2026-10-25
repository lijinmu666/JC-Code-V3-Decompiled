package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class CMSPatchKit {

    public static class DLSignerInformation extends SignerInformation {
        public DLSignerInformation(SignerInformation signerInformation) {
            super(signerInformation);
        }

        @Override // org.bouncycastle.p191cms.SignerInformation
        public byte[] getEncodedSignedAttributes() {
            return this.signedAttributeSet.getEncoded(ASN1Encoding.f17903DL);
        }
    }

    public static class ModEncAlgSignerInformation extends SignerInformation {
        public ModEncAlgSignerInformation(SignerInformation signerInformation, AlgorithmIdentifier algorithmIdentifier) {
            super(signerInformation, editEncAlg(signerInformation.f19041info, algorithmIdentifier));
        }

        private static SignerInfo editEncAlg(SignerInfo signerInfo, AlgorithmIdentifier algorithmIdentifier) {
            return new SignerInfo(signerInfo.m14556getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), algorithmIdentifier, signerInfo.getEncryptedDigest(), signerInfo.getUnauthenticatedAttributes());
        }
    }

    public static SignerInformation createNonDERSignerInfo(SignerInformation signerInformation) {
        return new DLSignerInformation(signerInformation);
    }

    public static SignerInformation createWithSignatureAlgorithm(SignerInformation signerInformation, AlgorithmIdentifier algorithmIdentifier) {
        return new ModEncAlgSignerInformation(signerInformation, algorithmIdentifier);
    }
}
