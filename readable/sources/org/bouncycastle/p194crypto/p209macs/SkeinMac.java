package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p199digests.SkeinEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.SkeinParameters;

/* loaded from: classes2.dex */
public class SkeinMac implements InterfaceC5278Mac {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;

    /* renamed from: engine */
    private SkeinEngine f20500engine;

    public SkeinMac(int i, int i2) {
        this.f20500engine = new SkeinEngine(i, i2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        return this.f20500engine.m15186doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "Skein-MAC-" + (this.f20500engine.getBlockSize() * 8) + "-" + (this.f20500engine.getOutputSize() * 8);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20500engine.getOutputSize();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        SkeinParameters skeinParametersM15828build;
        if (cipherParameters instanceof SkeinParameters) {
            skeinParametersM15828build = (SkeinParameters) cipherParameters;
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("Invalid parameter passed to Skein MAC init - " + cipherParameters.getClass().getName());
            }
            skeinParametersM15828build = new SkeinParameters.C5375Builder().m15830setKey(((KeyParameter) cipherParameters).m15773getKey()).m15828build();
        }
        if (skeinParametersM15828build.m15827getKey() == null) {
            throw new IllegalArgumentException("Skein MAC requires a key parameter.");
        }
        this.f20500engine.m15187init(skeinParametersM15828build);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.f20500engine.m15188reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20500engine.m15189update(b);
    }

    public SkeinMac(SkeinMac skeinMac) {
        this.f20500engine = new SkeinEngine(skeinMac.f20500engine);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        this.f20500engine.m15190update(bArr, i, i2);
    }
}
