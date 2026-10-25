package org.bouncycastle.operator.p306jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.ExtendedContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSASSAPSSparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.CompositePrivateKey;
import org.bouncycastle.p249jcajce.p250io.OutputStreamFactory;
import org.bouncycastle.p249jcajce.p279spec.CompositeAlgorithmSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSigParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class JcaContentSignerBuilder {
    private static final DefaultSignatureAlgorithmIdentifierFinder SIGNATURE_ALGORITHM_IDENTIFIER_FINDER;
    private static final Set isAlgIdFromPrivate;

    /* renamed from: helper */
    private OperatorHelper f22886helper;

    /* renamed from: random */
    private SecureRandom f22887random;
    private AlgorithmIdentifier sigAlgId;
    private AlgorithmParameterSpec sigAlgSpec;
    private final String signatureAlgorithm;
    private final AlgorithmIdentifier signatureDigestAlgorithm;

    static {
        HashSet hashSet = new HashSet();
        isAlgIdFromPrivate = hashSet;
        SIGNATURE_ALGORITHM_IDENTIFIER_FINDER = new DefaultSignatureAlgorithmIdentifierFinder();
        hashSet.add("COMPOSITE");
        hashSet.add("DILITHIUM");
        hashSet.add("SPHINCS+");
        hashSet.add("SPHINCSPlus");
        hashSet.add("ML-DSA");
        hashSet.add("SLH-DSA");
        hashSet.add("HASH-ML-DSA");
        hashSet.add("HASH-SLH-DSA");
    }

    public JcaContentSignerBuilder(String str) {
        this(str, (AlgorithmIdentifier) null);
    }

    private ContentSigner buildComposite(CompositePrivateKey compositePrivateKey) throws OperatorCreationException, IOException, InvalidKeyException {
        try {
            List<PrivateKey> privateKeys = compositePrivateKey.getPrivateKeys();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(this.sigAlgId.getParameters());
            int iMo14450size = aSN1Sequence.mo14450size();
            Signature[] signatureArr = new Signature[iMo14450size];
            for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
                Signature signatureCreateSignature = this.f22886helper.createSignature(AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i)));
                signatureArr[i] = signatureCreateSignature;
                if (this.f22887random != null) {
                    signatureCreateSignature.initSign(privateKeys.get(i), this.f22887random);
                } else {
                    signatureCreateSignature.initSign(privateKeys.get(i));
                }
            }
            OutputStream outputStreamCreateStream = OutputStreamFactory.createStream(signatureArr[0]);
            int i2 = 1;
            while (i2 != iMo14450size) {
                TeeOutputStream teeOutputStream = new TeeOutputStream(outputStreamCreateStream, OutputStreamFactory.createStream(signatureArr[i2]));
                i2++;
                outputStreamCreateStream = teeOutputStream;
            }
            return new ContentSigner(this, outputStreamCreateStream, signatureArr) { // from class: org.bouncycastle.operator.jcajce.JcaContentSignerBuilder.3

                /* renamed from: stream */
                OutputStream f22893stream;

                /* renamed from: this$0 */
                final /* synthetic */ JcaContentSignerBuilder f22894this$0;
                final /* synthetic */ OutputStream val$sigStream;
                final /* synthetic */ Signature[] val$sigs;

                {
                    this.val$sigStream = outputStreamCreateStream;
                    this.val$sigs = signatureArr;
                    this.f22894this$0 = this;
                    this.f22893stream = outputStreamCreateStream;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return this.f22894this$0.sigAlgId;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public OutputStream getOutputStream() {
                    return this.f22893stream;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public byte[] getSignature() {
                    try {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        for (int i3 = 0; i3 != this.val$sigs.length; i3++) {
                            aSN1EncodableVector.m14420add(new DERBitString(this.val$sigs[i3].sign()));
                        }
                        return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER);
                    } catch (IOException e) {
                        throw new RuntimeOperatorException("exception encoding signature: " + e.getMessage(), e);
                    } catch (SignatureException e2) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e2.getMessage(), e2);
                    }
                }
            };
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create signer: " + e.getMessage(), e);
        }
    }

    private static ASN1Sequence createCompParams(CompositeAlgorithmSpec compositeAlgorithmSpec) {
        DefaultSignatureAlgorithmIdentifierFinder defaultSignatureAlgorithmIdentifierFinder = new DefaultSignatureAlgorithmIdentifierFinder();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        List<String> algorithmNames = compositeAlgorithmSpec.getAlgorithmNames();
        List<AlgorithmParameterSpec> parameterSpecs = compositeAlgorithmSpec.getParameterSpecs();
        for (int i = 0; i != algorithmNames.size(); i++) {
            AlgorithmParameterSpec algorithmParameterSpec = parameterSpecs.get(i);
            if (algorithmParameterSpec == null) {
                aSN1EncodableVector.m14420add(defaultSignatureAlgorithmIdentifierFinder.mo17384find(algorithmNames.get(i)));
            } else {
                if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
                    throw new IllegalArgumentException("unrecognized parameterSpec");
                }
                aSN1EncodableVector.m14420add(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_RSASSA_PSS, createPSSParams((PSSParameterSpec) algorithmParameterSpec)));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private static RSASSAPSSparams createPSSParams(PSSParameterSpec pSSParameterSpec) {
        DefaultDigestAlgorithmIdentifierFinder defaultDigestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
        AlgorithmIdentifier algorithmIdentifierMo17380find = defaultDigestAlgorithmIdentifierFinder.mo17380find(pSSParameterSpec.getDigestAlgorithm());
        if (algorithmIdentifierMo17380find.getParameters() == null) {
            algorithmIdentifierMo17380find = new AlgorithmIdentifier(algorithmIdentifierMo17380find.getAlgorithm(), C5103DERNull.INSTANCE);
        }
        AlgorithmIdentifier algorithmIdentifierMo17380find2 = defaultDigestAlgorithmIdentifierFinder.mo17380find(((MGF1ParameterSpec) pSSParameterSpec.getMGFParameters()).getDigestAlgorithm());
        if (algorithmIdentifierMo17380find2.getParameters() == null) {
            algorithmIdentifierMo17380find2 = new AlgorithmIdentifier(algorithmIdentifierMo17380find2.getAlgorithm(), C5103DERNull.INSTANCE);
        }
        return new RSASSAPSSparams(algorithmIdentifierMo17380find, new AlgorithmIdentifier(PKCSObjectIdentifiers.f18498id_mgf1, algorithmIdentifierMo17380find2), ASN1Integer.m14429valueOf(pSSParameterSpec.getSaltLength()), ASN1Integer.m14429valueOf(pSSParameterSpec.getTrailerField()));
    }

    private AlgorithmIdentifier getSigAlgId(PrivateKey privateKey) {
        if (!isAlgIdFromPrivate.contains(C6250Strings.toUpperCase(this.signatureAlgorithm))) {
            return SIGNATURE_ALGORITHM_IDENTIFIER_FINDER.mo17384find(this.signatureAlgorithm);
        }
        AlgorithmIdentifier algorithmIdentifierMo17384find = SIGNATURE_ALGORITHM_IDENTIFIER_FINDER.mo17384find(privateKey.getAlgorithm());
        return algorithmIdentifierMo17384find == null ? PrivateKeyInfo.getInstance(privateKey.getEncoded()).getPrivateKeyAlgorithm() : algorithmIdentifierMo17384find;
    }

    private static AlgorithmIdentifier getSigDigAlgId(PublicKey publicKey) {
        SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
        if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_hss_lms_hashsig)) {
            return new AlgorithmIdentifier(LMSigParameters.getParametersForType(AbstractC6245Pack.bigEndianToInt(subjectPublicKeyInfo.getPublicKeyData().getOctets(), 4)).getDigestOID());
        }
        return null;
    }

    /* renamed from: build */
    public ContentSigner m17392build(PrivateKey privateKey) {
        if (privateKey instanceof CompositePrivateKey) {
            CompositePrivateKey compositePrivateKey = (CompositePrivateKey) privateKey;
            if (compositePrivateKey.getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) MiscObjectIdentifiers.id_composite_key)) {
                return buildComposite(compositePrivateKey);
            }
        }
        try {
            if (this.sigAlgSpec == null) {
                this.sigAlgId = getSigAlgId(privateKey);
            }
            AlgorithmIdentifier algorithmIdentifier = this.sigAlgId;
            Signature signatureCreateSignature = this.f22886helper.createSignature(algorithmIdentifier);
            SecureRandom secureRandom = this.f22887random;
            if (secureRandom != null) {
                signatureCreateSignature.initSign(privateKey, secureRandom);
            } else {
                signatureCreateSignature.initSign(privateKey);
            }
            ContentSigner contentSigner = new ContentSigner(this, signatureCreateSignature, algorithmIdentifier) { // from class: org.bouncycastle.operator.jcajce.JcaContentSignerBuilder.1

                /* renamed from: stream */
                private OutputStream f22888stream;

                /* renamed from: this$0 */
                final /* synthetic */ JcaContentSignerBuilder f22889this$0;

                /* renamed from: val$sig */
                final /* synthetic */ Signature f22890val$sig;
                final /* synthetic */ AlgorithmIdentifier val$signatureAlgId;

                {
                    this.f22890val$sig = signatureCreateSignature;
                    this.val$signatureAlgId = algorithmIdentifier;
                    this.f22889this$0 = this;
                    this.f22888stream = OutputStreamFactory.createStream(signatureCreateSignature);
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return this.val$signatureAlgId;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public OutputStream getOutputStream() {
                    return this.f22888stream;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public byte[] getSignature() {
                    try {
                        return this.f22890val$sig.sign();
                    } catch (SignatureException e) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                    }
                }
            };
            return this.signatureDigestAlgorithm != null ? new ExtendedContentSigner(this, contentSigner) { // from class: org.bouncycastle.operator.jcajce.JcaContentSignerBuilder.2
                private final AlgorithmIdentifier digestAlgorithm;

                /* renamed from: signer */
                private final ContentSigner f22891signer;

                /* renamed from: this$0 */
                final /* synthetic */ JcaContentSignerBuilder f22892this$0;
                final /* synthetic */ ContentSigner val$contentSigner;

                {
                    this.val$contentSigner = contentSigner;
                    this.f22892this$0 = this;
                    this.digestAlgorithm = this.signatureDigestAlgorithm;
                    this.f22891signer = contentSigner;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return this.f22891signer.getAlgorithmIdentifier();
                }

                @Override // org.bouncycastle.operator.ExtendedContentSigner
                public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
                    return this.digestAlgorithm;
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public OutputStream getOutputStream() {
                    return this.f22891signer.getOutputStream();
                }

                @Override // org.bouncycastle.operator.ContentSigner
                public byte[] getSignature() {
                    return this.f22891signer.getSignature();
                }
            } : contentSigner;
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create signer: " + e.getMessage(), e);
        }
    }

    public JcaContentSignerBuilder setProvider(String str) {
        this.f22886helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcaContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f22887random = secureRandom;
        return this;
    }

    public JcaContentSignerBuilder(String str, PublicKey publicKey) {
        this(str, getSigDigAlgId(publicKey));
    }

    public JcaContentSignerBuilder setProvider(Provider provider) {
        this.f22886helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcaContentSignerBuilder(String str, AlgorithmParameterSpec algorithmParameterSpec) {
        this(str, algorithmParameterSpec, null);
    }

    public JcaContentSignerBuilder(String str, AlgorithmParameterSpec algorithmParameterSpec, AlgorithmIdentifier algorithmIdentifier) {
        AlgorithmIdentifier algorithmIdentifier2;
        this.f22886helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.signatureAlgorithm = str;
        this.signatureDigestAlgorithm = algorithmIdentifier;
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
            this.sigAlgSpec = pSSParameterSpec;
            algorithmIdentifier2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_RSASSA_PSS, createPSSParams(pSSParameterSpec));
        } else {
            if (!(algorithmParameterSpec instanceof CompositeAlgorithmSpec)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unknown sigParamSpec: ");
                sb.append(algorithmParameterSpec == null ? "null" : algorithmParameterSpec.getClass().getName());
                throw new IllegalArgumentException(sb.toString());
            }
            CompositeAlgorithmSpec compositeAlgorithmSpec = (CompositeAlgorithmSpec) algorithmParameterSpec;
            this.sigAlgSpec = compositeAlgorithmSpec;
            algorithmIdentifier2 = new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite, createCompParams(compositeAlgorithmSpec));
        }
        this.sigAlgId = algorithmIdentifier2;
    }

    public JcaContentSignerBuilder(String str, AlgorithmIdentifier algorithmIdentifier) {
        this.f22886helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.signatureAlgorithm = str;
        this.signatureDigestAlgorithm = algorithmIdentifier;
    }
}
