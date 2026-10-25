package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.InvalidKeyException;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.ARIAEngine;
import org.bouncycastle.p194crypto.p201engines.CamelliaEngine;
import org.bouncycastle.p194crypto.p201engines.RFC3394WrapEngine;
import org.bouncycastle.p194crypto.p201engines.RFC5649WrapEngine;
import org.bouncycastle.p194crypto.p201engines.SEEDEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class WrapUtil {
    public static InterfaceC5283Wrapper getKeyUnwrapper(KTSParameterSpec kTSParameterSpec, byte[] bArr) {
        InterfaceC5283Wrapper wrapper = getWrapper(kTSParameterSpec.getKeyAlgorithmName());
        wrapper.mo14995init(false, kTSParameterSpec.getKdfAlgorithm() == null ? new KeyParameter(bArr, 0, (kTSParameterSpec.getKeySize() + 7) / 8) : new KeyParameter(makeKeyBytes(kTSParameterSpec, bArr)));
        return wrapper;
    }

    public static InterfaceC5283Wrapper getKeyWrapper(KTSParameterSpec kTSParameterSpec, byte[] bArr) {
        InterfaceC5283Wrapper wrapper = getWrapper(kTSParameterSpec.getKeyAlgorithmName());
        wrapper.mo14995init(true, kTSParameterSpec.getKdfAlgorithm() == null ? new KeyParameter(C6238Arrays.copyOfRange(bArr, 0, (kTSParameterSpec.getKeySize() + 7) / 8)) : new KeyParameter(makeKeyBytes(kTSParameterSpec, bArr)));
        return wrapper;
    }

    public static InterfaceC5283Wrapper getWrapper(String str) {
        if (str.equalsIgnoreCase("AESWRAP") || str.equalsIgnoreCase("AES")) {
            return new RFC3394WrapEngine(AESEngine.newInstance());
        }
        if (str.equalsIgnoreCase("ARIA")) {
            return new RFC3394WrapEngine(new ARIAEngine());
        }
        if (str.equalsIgnoreCase("Camellia")) {
            return new RFC3394WrapEngine(new CamelliaEngine());
        }
        if (str.equalsIgnoreCase("SEED")) {
            return new RFC3394WrapEngine(new SEEDEngine());
        }
        if (str.equalsIgnoreCase("AES-KWP")) {
            return new RFC5649WrapEngine(AESEngine.newInstance());
        }
        if (str.equalsIgnoreCase("Camellia-KWP")) {
            return new RFC5649WrapEngine(new CamelliaEngine());
        }
        if (str.equalsIgnoreCase("ARIA-KWP")) {
            return new RFC5649WrapEngine(new ARIAEngine());
        }
        throw new UnsupportedOperationException("unknown key algorithm: " + str);
    }

    private static byte[] makeKeyBytes(KTSParameterSpec kTSParameterSpec, byte[] bArr) throws InvalidKeyException {
        try {
            return C5620KdfUtil.makeKeyBytes(kTSParameterSpec.getKdfAlgorithm(), bArr, kTSParameterSpec.getOtherInfo(), kTSParameterSpec.getKeySize());
        } catch (IllegalArgumentException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    public static byte[] trimSecret(String str, byte[] bArr) {
        return str.equals("SEED") ? C6238Arrays.copyOfRange(bArr, 0, 16) : bArr;
    }
}
