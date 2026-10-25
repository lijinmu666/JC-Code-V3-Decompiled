package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.Destroyable;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HybridValueParameterSpec implements AlgorithmParameterSpec, Destroyable {
    private volatile AlgorithmParameterSpec baseSpec;
    private final boolean doPrepend;
    private final AtomicBoolean hasBeenDestroyed;

    /* renamed from: t */
    private volatile byte[] f21925t;

    public HybridValueParameterSpec(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) {
        this(bArr, false, algorithmParameterSpec);
    }

    private void checkDestroyed() {
        if (isDestroyed()) {
            throw new IllegalStateException("spec has been destroyed");
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true)) {
            return;
        }
        C6238Arrays.m18227clear(this.f21925t);
        this.f21925t = null;
        this.baseSpec = null;
    }

    public AlgorithmParameterSpec getBaseParameterSpec() {
        AlgorithmParameterSpec algorithmParameterSpec = this.baseSpec;
        checkDestroyed();
        return algorithmParameterSpec;
    }

    /* renamed from: getT */
    public byte[] m16201getT() {
        byte[] bArr = this.f21925t;
        checkDestroyed();
        return bArr;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }

    public boolean isPrependedT() {
        return this.doPrepend;
    }

    public HybridValueParameterSpec(byte[] bArr, boolean z, AlgorithmParameterSpec algorithmParameterSpec) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.f21925t = bArr;
        this.baseSpec = algorithmParameterSpec;
        this.doPrepend = z;
    }
}
