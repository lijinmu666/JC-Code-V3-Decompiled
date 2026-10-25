package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p210modes.GCFBBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;
import org.bouncycastle.p194crypto.p213params.ParametersWithUKM;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class CryptoProWrapEngine extends GOST28147WrapEngine {
    /* renamed from: bitSet */
    private static boolean m15294bitSet(byte b, int i) {
        return (b & (1 << i)) != 0;
    }

    private static byte[] cryptoProDiversify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i != 8; i++) {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 != 8; i4++) {
                int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i4 * 4);
                if (m15294bitSet(bArr2[i], i4)) {
                    i2 += iLittleEndianToInt;
                } else {
                    i3 += iLittleEndianToInt;
                }
            }
            byte[] bArr4 = new byte[8];
            AbstractC6245Pack.intToLittleEndian(i2, bArr4, 0);
            AbstractC6245Pack.intToLittleEndian(i3, bArr4, 4);
            GCFBBlockCipher gCFBBlockCipher = new GCFBBlockCipher(new GOST28147Engine());
            gCFBBlockCipher.mo14946init(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(bArr), bArr3), bArr4));
            gCFBBlockCipher.processBlock(bArr, 0, bArr, 0);
            gCFBBlockCipher.processBlock(bArr, 8, bArr, 8);
            gCFBBlockCipher.processBlock(bArr, 16, bArr, 16);
            gCFBBlockCipher.processBlock(bArr, 24, bArr, 24);
        }
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.GOST28147WrapEngine, org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: init */
    public void mo14995init(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        byte[] bArrM15802getSBox;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        if (parametersWithUKM.getParameters() instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) parametersWithUKM.getParameters()).getParameters();
            bArrM15802getSBox = ((ParametersWithSBox) parametersWithUKM.getParameters()).m15802getSBox();
        } else {
            keyParameter = (KeyParameter) parametersWithUKM.getParameters();
            bArrM15802getSBox = null;
        }
        KeyParameter keyParameter2 = new KeyParameter(cryptoProDiversify(keyParameter.m15773getKey(), parametersWithUKM.m15804getUKM(), bArrM15802getSBox));
        super.mo14995init(z, bArrM15802getSBox != null ? new ParametersWithUKM(new ParametersWithSBox(keyParameter2, bArrM15802getSBox), parametersWithUKM.m15804getUKM()) : new ParametersWithUKM(keyParameter2, parametersWithUKM.m15804getUKM()));
    }
}
