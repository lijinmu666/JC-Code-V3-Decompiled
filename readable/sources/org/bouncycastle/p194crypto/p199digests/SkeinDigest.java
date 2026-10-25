package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.p213params.SkeinParameters;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SkeinDigest implements ExtendedDigest, Memoable {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;

    /* renamed from: engine */
    private SkeinEngine f19567engine;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19568purpose;

    public SkeinDigest(int i, int i2) {
        this(i, i2, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SkeinDigest(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return this.f19567engine.m15186doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "Skein-" + (this.f19567engine.getBlockSize() * 8) + "-" + (this.f19567engine.getOutputSize() * 8);
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.f19567engine.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.f19567engine.getOutputSize();
    }

    /* renamed from: init */
    public void m15180init(SkeinParameters skeinParameters) {
        this.f19567engine.m15187init(skeinParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19567engine.m15188reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.f19567engine.m15189update(b);
    }

    public SkeinDigest(int i, int i2, CryptoServicePurpose cryptoServicePurpose) {
        this.f19567engine = new SkeinEngine(i, i2);
        this.f19568purpose = cryptoServicePurpose;
        m15180init(null);
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize() * 4, cryptoServicePurpose));
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        this.f19567engine.mo14824reset(((SkeinDigest) memoable).f19567engine);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        this.f19567engine.m15190update(bArr, i, i2);
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.f19567engine = new SkeinEngine(skeinDigest.f19567engine);
        CryptoServicePurpose cryptoServicePurpose = skeinDigest.f19568purpose;
        this.f19568purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, skeinDigest.getDigestSize() * 4, cryptoServicePurpose));
    }
}
