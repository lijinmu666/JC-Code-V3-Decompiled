package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.util.concurrent.atomic.AtomicBoolean;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SecretWithEncapsulationImpl implements SecretWithEncapsulation {
    private final byte[] cipher_text;
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);
    private final byte[] sessionKey;

    public SecretWithEncapsulationImpl(byte[] bArr, byte[] bArr2) {
        this.sessionKey = bArr;
        this.cipher_text = bArr2;
    }

    public void checkDestroyed() {
        if (isDestroyed()) {
            throw new IllegalStateException("data has been destroyed");
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true)) {
            return;
        }
        C6238Arrays.m18227clear(this.sessionKey);
        C6238Arrays.m18227clear(this.cipher_text);
    }

    @Override // org.bouncycastle.p194crypto.SecretWithEncapsulation
    public byte[] getEncapsulation() {
        byte[] bArrM18231clone = C6238Arrays.m18231clone(this.cipher_text);
        checkDestroyed();
        return bArrM18231clone;
    }

    @Override // org.bouncycastle.p194crypto.SecretWithEncapsulation
    public byte[] getSecret() {
        byte[] bArrM18231clone = C6238Arrays.m18231clone(this.sessionKey);
        checkDestroyed();
        return bArrM18231clone;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }
}
