package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class OldIESEngine extends IESEngine {
    public OldIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac) {
        super(basicAgreement, derivationFunction, interfaceC5278Mac);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.IESEngine
    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        if (bArr != null) {
            AbstractC6245Pack.intToBigEndian(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }

    public OldIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac, BufferedBlockCipher bufferedBlockCipher) {
        super(basicAgreement, derivationFunction, interfaceC5278Mac, bufferedBlockCipher);
    }
}
