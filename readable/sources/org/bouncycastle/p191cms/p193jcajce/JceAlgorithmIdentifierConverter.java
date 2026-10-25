package org.bouncycastle.p191cms.p193jcajce;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;

/* loaded from: classes2.dex */
public class JceAlgorithmIdentifierConverter {

    /* renamed from: helper */
    private EnvelopedDataHelper f19069helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());

    /* renamed from: random */
    private SecureRandom f19070random;

    public AlgorithmParameters getAlgorithmParameters(AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        if (algorithmIdentifier.getParameters() == null) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f19069helper.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
            CMSUtils.loadParameters(algorithmParametersCreateAlgorithmParameters, algorithmIdentifier.getParameters());
            return algorithmParametersCreateAlgorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find parameters for algorithm", e);
        } catch (NoSuchProviderException e2) {
            throw new CMSException("can't find provider for algorithm", e2);
        }
    }

    public JceAlgorithmIdentifierConverter setProvider(String str) {
        this.f19069helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceAlgorithmIdentifierConverter setProvider(Provider provider) {
        this.f19069helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
