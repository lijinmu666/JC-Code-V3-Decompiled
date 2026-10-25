package org.bouncycastle.p246its.p247bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.p305bc.BcDefaultDigestProvider;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.DSADigestSigner;
import org.bouncycastle.p194crypto.p217signers.ECDSASigner;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.operator.ITSContentVerifierProvider;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.VerificationKeyIndicator;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BcITSContentVerifierProvider implements ITSContentVerifierProvider {
    private final AlgorithmIdentifier digestAlgo;

    /* renamed from: issuer */
    private final ITSCertificate f21304issuer;
    private final byte[] parentData;
    private final ECPublicKeyParameters pubParams;
    private final int sigChoice;

    public BcITSContentVerifierProvider(ITSCertificate iTSCertificate) {
        AlgorithmIdentifier algorithmIdentifier;
        this.f21304issuer = iTSCertificate;
        this.parentData = iTSCertificate.getEncoded();
        VerificationKeyIndicator verifyKeyIndicator = iTSCertificate.toASN1Structure().getToBeSigned().getVerifyKeyIndicator();
        if (!(verifyKeyIndicator.getVerificationKeyIndicator() instanceof PublicVerificationKey)) {
            throw new IllegalStateException("not public verification key");
        }
        PublicVerificationKey publicVerificationKey = PublicVerificationKey.getInstance(verifyKeyIndicator.getVerificationKeyIndicator());
        this.sigChoice = publicVerificationKey.getChoice();
        int choice = publicVerificationKey.getChoice();
        if (choice == 0 || choice == 1) {
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        } else {
            if (choice != 2) {
                throw new IllegalStateException("unknown key type");
            }
            algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        this.digestAlgo = algorithmIdentifier;
        this.pubParams = (ECPublicKeyParameters) new BcITSPublicVerificationKey(publicVerificationKey).m16019getKey();
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    /* renamed from: get */
    public ContentVerifier mo16014get(int i) throws OperatorCreationException, IOException {
        if (this.sigChoice != i) {
            throw new OperatorCreationException("wrong verifier for algorithm: " + i);
        }
        final ExtendedDigest extendedDigestMo14916get = BcDefaultDigestProvider.INSTANCE.mo14916get(this.digestAlgo);
        final byte[] bArr = new byte[extendedDigestMo14916get.getDigestSize()];
        byte[] bArr2 = this.parentData;
        extendedDigestMo14916get.mo14970update(bArr2, 0, bArr2.length);
        extendedDigestMo14916get.mo14967doFinal(bArr, 0);
        final byte[] bArr3 = this.f21304issuer.getIssuer().m17232isSelf() ? new byte[extendedDigestMo14916get.getDigestSize()] : null;
        if (bArr3 != null) {
            byte[] byteArray = OEREncoder.toByteArray(this.f21304issuer.toASN1Structure().getToBeSigned(), IEEE1609dot2.ToBeSignedCertificate.m17146build());
            extendedDigestMo14916get.mo14970update(byteArray, 0, byteArray.length);
            extendedDigestMo14916get.mo14967doFinal(bArr3, 0);
        }
        final OutputStream outputStream = new OutputStream(this) { // from class: org.bouncycastle.its.bc.BcITSContentVerifierProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BcITSContentVerifierProvider f21305this$0;

            {
                this.f21305this$0 = this;
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                extendedDigestMo14916get.mo14969update((byte) i2);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr4) {
                extendedDigestMo14916get.mo14970update(bArr4, 0, bArr4.length);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr4, int i2, int i3) {
                extendedDigestMo14916get.mo14970update(bArr4, i2, i3);
            }
        };
        return new ContentVerifier(this) { // from class: org.bouncycastle.its.bc.BcITSContentVerifierProvider.2

            /* renamed from: signer */
            final DSADigestSigner f21306signer;

            /* renamed from: this$0 */
            final /* synthetic */ BcITSContentVerifierProvider f21307this$0;

            {
                this.f21307this$0 = this;
                this.f21306signer = new DSADigestSigner(new ECDSASigner(), BcDefaultDigestProvider.INSTANCE.mo14916get(this.digestAlgo));
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
            public boolean mo16015verify(byte[] bArr4) {
                int digestSize = extendedDigestMo14916get.getDigestSize();
                byte[] bArr5 = new byte[digestSize];
                extendedDigestMo14916get.mo14967doFinal(bArr5, 0);
                this.f21306signer.mo14987init(false, this.f21307this$0.pubParams);
                this.f21306signer.mo14990update(bArr5, 0, digestSize);
                byte[] bArr6 = bArr3;
                if (bArr6 == null || !C6238Arrays.areEqual(bArr5, bArr6)) {
                    DSADigestSigner dSADigestSigner = this.f21306signer;
                    byte[] bArr7 = bArr;
                    dSADigestSigner.mo14990update(bArr7, 0, bArr7.length);
                } else {
                    int digestSize2 = extendedDigestMo14916get.getDigestSize();
                    byte[] bArr8 = new byte[digestSize2];
                    extendedDigestMo14916get.mo14967doFinal(bArr8, 0);
                    this.f21306signer.mo14990update(bArr8, 0, digestSize2);
                }
                return this.f21306signer.verifySignature(bArr4);
            }
        };
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    public ITSCertificate getAssociatedCertificate() {
        return this.f21304issuer;
    }

    @Override // org.bouncycastle.p246its.operator.ITSContentVerifierProvider
    public boolean hasAssociatedCertificate() {
        return this.f21304issuer != null;
    }
}
