package org.bouncycastle.p246its.p248jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.ITSPublicVerificationKey;
import org.bouncycastle.p246its.operator.ITSContentVerifierProvider;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.VerificationKeyIndicator;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JcaITSContentVerifierProvider implements ITSContentVerifierProvider {
    private AlgorithmIdentifier digestAlgo;

    /* renamed from: helper */
    private final JcaJceHelper f21316helper;

    /* renamed from: issuer */
    private final ITSCertificate f21317issuer;
    private final byte[] parentData;
    private ECPublicKey pubParams;
    private int sigChoice;

    /* renamed from: org.bouncycastle.its.jcajce.JcaITSContentVerifierProvider$Builder */
    public static class C5459Builder {

        /* renamed from: helper */
        private JcaJceHelper f21320helper = new DefaultJcaJceHelper();

        /* renamed from: build */
        public JcaITSContentVerifierProvider m16026build(ITSCertificate iTSCertificate) {
            return new JcaITSContentVerifierProvider(iTSCertificate, this.f21320helper);
        }

        public C5459Builder setProvider(String str) {
            this.f21320helper = new NamedJcaJceHelper(str);
            return this;
        }

        /* renamed from: build */
        public JcaITSContentVerifierProvider m16027build(ITSPublicVerificationKey iTSPublicVerificationKey) {
            return new JcaITSContentVerifierProvider(iTSPublicVerificationKey, this.f21320helper);
        }

        public C5459Builder setProvider(Provider provider) {
            this.f21320helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    private JcaITSContentVerifierProvider(ITSCertificate iTSCertificate, JcaJceHelper jcaJceHelper) {
        this.f21317issuer = iTSCertificate;
        this.f21316helper = jcaJceHelper;
        try {
            this.parentData = iTSCertificate.getEncoded();
            VerificationKeyIndicator verifyKeyIndicator = iTSCertificate.toASN1Structure().getToBeSigned().getVerifyKeyIndicator();
            if (!(verifyKeyIndicator.getVerificationKeyIndicator() instanceof PublicVerificationKey)) {
                throw new IllegalArgumentException("not public verification key");
            }
            initForPvi(PublicVerificationKey.getInstance(verifyKeyIndicator.getVerificationKeyIndicator()), jcaJceHelper);
        } catch (IOException e) {
            throw new IllegalStateException("unable to extract parent data: " + e.getMessage());
        }
    }

    private void initForPvi(PublicVerificationKey publicVerificationKey, JcaJceHelper jcaJceHelper) {
        AlgorithmIdentifier algorithmIdentifier;
        this.sigChoice = publicVerificationKey.getChoice();
        int choice = publicVerificationKey.getChoice();
        if (choice == 0 || choice == 1) {
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        } else {
            if (choice != 2) {
                throw new IllegalArgumentException("unknown key type");
            }
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        this.digestAlgo = algorithmIdentifier;
        this.pubParams = (ECPublicKey) new JcaITSPublicVerificationKey(publicVerificationKey, jcaJceHelper).m16031getKey();
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    /* renamed from: get */
    public ContentVerifier mo16014get(int i) throws OperatorCreationException, IOException {
        byte[] digest;
        JcaJceHelper jcaJceHelper;
        String str;
        if (this.sigChoice != i) {
            throw new OperatorCreationException("wrong verifier for algorithm: " + i);
        }
        try {
            final DigestCalculator digestCalculatorMo14763get = new JcaDigestCalculatorProviderBuilder().setHelper(this.f21316helper).m17397build().mo14763get(this.digestAlgo);
            try {
                final OutputStream outputStream = digestCalculatorMo14763get.getOutputStream();
                byte[] bArr = this.parentData;
                if (bArr != null) {
                    outputStream.write(bArr, 0, bArr.length);
                }
                final byte[] digest2 = digestCalculatorMo14763get.getDigest();
                ITSCertificate iTSCertificate = this.f21317issuer;
                if (iTSCertificate == null || !iTSCertificate.getIssuer().m17232isSelf()) {
                    digest = null;
                } else {
                    byte[] byteArray = OEREncoder.toByteArray(this.f21317issuer.toASN1Structure().getToBeSigned(), IEEE1609dot2.ToBeSignedCertificate.m17146build());
                    outputStream.write(byteArray, 0, byteArray.length);
                    digest = digestCalculatorMo14763get.getDigest();
                }
                final byte[] bArr2 = digest;
                int i2 = this.sigChoice;
                if (i2 == 0 || i2 == 1) {
                    jcaJceHelper = this.f21316helper;
                    str = "SHA256withECDSA";
                } else {
                    if (i2 != 2) {
                        throw new IllegalArgumentException("choice " + this.sigChoice + " not supported");
                    }
                    jcaJceHelper = this.f21316helper;
                    str = "SHA384withECDSA";
                }
                final Signature signatureCreateSignature = jcaJceHelper.createSignature(str);
                return new ContentVerifier(this) { // from class: org.bouncycastle.its.jcajce.JcaITSContentVerifierProvider.1

                    /* renamed from: this$0 */
                    final /* synthetic */ JcaITSContentVerifierProvider f21318this$0;

                    {
                        this.f21318this$0 = this;
                    }

                    @Override // org.bouncycastle.operator.ContentVerifier
                    public AlgorithmIdentifier getAlgorithmIdentifier() {
                        return null;
                    }

                    @Override // org.bouncycastle.operator.ContentVerifier
                    public OutputStream getOutputStream() {
                        return outputStream;
                    }

                    @Override // org.bouncycastle.operator.ContentVerifier
                    /* renamed from: verify */
                    public boolean mo16015verify(byte[] bArr3) throws SignatureException, InvalidKeyException {
                        byte[] digest3 = digestCalculatorMo14763get.getDigest();
                        try {
                            signatureCreateSignature.initVerify(this.f21318this$0.pubParams);
                            signatureCreateSignature.update(digest3);
                            byte[] bArr4 = bArr2;
                            if (bArr4 == null || !C6238Arrays.areEqual(digest3, bArr4)) {
                                signatureCreateSignature.update(digest2);
                            } else {
                                signatureCreateSignature.update(digestCalculatorMo14763get.getDigest());
                            }
                            return signatureCreateSignature.verify(bArr3);
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    }
                };
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        } catch (Exception e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    public ITSCertificate getAssociatedCertificate() {
        return this.f21317issuer;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    public boolean hasAssociatedCertificate() {
        return this.f21317issuer != null;
    }

    private JcaITSContentVerifierProvider(ITSPublicVerificationKey iTSPublicVerificationKey, JcaJceHelper jcaJceHelper) {
        this.f21317issuer = null;
        this.parentData = null;
        this.f21316helper = jcaJceHelper;
        initForPvi(iTSPublicVerificationKey.toASN1Structure(), jcaJceHelper);
    }
}
