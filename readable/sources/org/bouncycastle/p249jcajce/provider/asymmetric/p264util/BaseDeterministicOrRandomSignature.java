package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p249jcajce.p279spec.ContextParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public abstract class BaseDeterministicOrRandomSignature extends SignatureSpi {
    protected AlgorithmParameters engineParams;
    protected AsymmetricKeyParameter keyParams;
    protected ContextParameterSpec paramSpec;

    /* renamed from: helper */
    private final JcaJceHelper f21638helper = new BCJcaJceHelper();
    protected boolean isInitState = true;
    private final AlgorithmParameterSpec originalSpec = ContextParameterSpec.EMPTY_CONTEXT_SPEC;

    public BaseDeterministicOrRandomSignature(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.bouncycastle.crypto.params.ParametersWithContext] */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.bouncycastle.crypto.params.ParametersWithContext] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.bouncycastle.crypto.params.ParametersWithRandom] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.security.SignatureSpi, org.bouncycastle.jcajce.provider.asymmetric.util.BaseDeterministicOrRandomSignature] */
    /* renamed from: reInit */
    private void m16138reInit() {
        boolean z;
        AsymmetricKeyParameter parametersWithContext = this.keyParams;
        if (parametersWithContext.isPrivate()) {
            SecureRandom secureRandom = ((SignatureSpi) this).appRandom;
            if (secureRandom != null) {
                parametersWithContext = new ParametersWithRandom(parametersWithContext, secureRandom);
            }
            ContextParameterSpec contextParameterSpec = this.paramSpec;
            if (contextParameterSpec != null) {
                parametersWithContext = new ParametersWithContext(parametersWithContext, contextParameterSpec.getContext());
            }
            z = true;
        } else {
            ContextParameterSpec contextParameterSpec2 = this.paramSpec;
            if (contextParameterSpec2 != null) {
                parametersWithContext = new ParametersWithContext(parametersWithContext, contextParameterSpec2.getContext());
            }
            z = false;
        }
        reInitialize(z, parametersWithContext);
    }

    @Override // java.security.SignatureSpi
    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("GetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public final AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        ContextParameterSpec contextParameterSpec;
        if (this.engineParams == null && (contextParameterSpec = this.paramSpec) != null && contextParameterSpec != ContextParameterSpec.EMPTY_CONTEXT_SPEC) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21638helper.createAlgorithmParameters("CONTEXT");
                this.engineParams = algorithmParametersCreateAlgorithmParameters;
                algorithmParametersCreateAlgorithmParameters.init(this.paramSpec);
            } catch (Exception e) {
                throw Exceptions.illegalStateException(e.toString(), e);
            }
        }
        return this.engineParams;
    }

    @Override // java.security.SignatureSpi
    public final void engineInitSign(PrivateKey privateKey) {
        signInit(privateKey, null);
        this.paramSpec = ContextParameterSpec.EMPTY_CONTEXT_SPEC;
        this.isInitState = true;
        m16138reInit();
    }

    @Override // java.security.SignatureSpi
    public final void engineInitVerify(PublicKey publicKey) {
        verifyInit(publicKey);
        this.paramSpec = ContextParameterSpec.EMPTY_CONTEXT_SPEC;
        this.isInitState = true;
        m16138reInit();
    }

    @Override // java.security.SignatureSpi
    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("SetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public final void engineUpdate(byte b) {
        this.isInitState = false;
        updateEngine(b);
    }

    public abstract void reInitialize(boolean z, CipherParameters cipherParameters);

    public abstract void signInit(PrivateKey privateKey, SecureRandom secureRandom);

    public abstract void updateEngine(byte b);

    public abstract void updateEngine(byte[] bArr, int i, int i2);

    public abstract void verifyInit(PublicKey publicKey);

    @Override // java.security.SignatureSpi
    public final void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) {
        signInit(privateKey, secureRandom);
        this.paramSpec = ContextParameterSpec.EMPTY_CONTEXT_SPEC;
        this.isInitState = true;
        m16138reInit();
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null && (algorithmParameterSpec = this.originalSpec) == null) {
            return;
        }
        if (!this.isInitState) {
            throw new ProviderException("cannot call setParameter in the middle of update");
        }
        if (algorithmParameterSpec instanceof ContextParameterSpec) {
            this.paramSpec = (ContextParameterSpec) algorithmParameterSpec;
        } else {
            byte[] contextFrom = SpecUtil.getContextFrom(algorithmParameterSpec);
            if (contextFrom == null) {
                throw new InvalidAlgorithmParameterException("unknown AlgorithmParameterSpec in signature");
            }
            this.paramSpec = new ContextParameterSpec(contextFrom);
        }
        m16138reInit();
    }

    @Override // java.security.SignatureSpi
    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.isInitState = false;
        updateEngine(bArr, i, i2);
    }
}
