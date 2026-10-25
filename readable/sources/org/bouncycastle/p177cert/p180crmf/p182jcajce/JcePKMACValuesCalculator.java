package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.p180crmf.CRMFException;
import org.bouncycastle.p177cert.p180crmf.PKMACValuesCalculator;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcePKMACValuesCalculator implements PKMACValuesCalculator {

    /* renamed from: digest */
    private MessageDigest f18863digest;

    /* renamed from: helper */
    private CRMFHelper f18864helper = new CRMFHelper(new DefaultJcaJceHelper());

    /* renamed from: mac */
    private Mac f18865mac;

    @Override // org.bouncycastle.p177cert.p180crmf.PKMACValuesCalculator
    public byte[] calculateDigest(byte[] bArr) {
        return this.f18863digest.digest(bArr);
    }

    @Override // org.bouncycastle.p177cert.p180crmf.PKMACValuesCalculator
    public byte[] calculateMac(byte[] bArr, byte[] bArr2) throws CRMFException, InvalidKeyException {
        try {
            this.f18865mac.init(new SecretKeySpec(bArr, this.f18865mac.getAlgorithm()));
            return this.f18865mac.doFinal(bArr2);
        } catch (GeneralSecurityException e) {
            throw new CRMFException("failure in setup: " + e.getMessage(), e);
        }
    }

    public JcePKMACValuesCalculator setProvider(String str) {
        this.f18864helper = new CRMFHelper(new NamedJcaJceHelper(str));
        return this;
    }

    @Override // org.bouncycastle.p177cert.p180crmf.PKMACValuesCalculator
    /* renamed from: setup */
    public void mo14792setup(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18863digest = this.f18864helper.createDigest(algorithmIdentifier.getAlgorithm());
        this.f18865mac = this.f18864helper.createMac(algorithmIdentifier2.getAlgorithm());
    }

    public JcePKMACValuesCalculator setProvider(Provider provider) {
        this.f18864helper = new CRMFHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
