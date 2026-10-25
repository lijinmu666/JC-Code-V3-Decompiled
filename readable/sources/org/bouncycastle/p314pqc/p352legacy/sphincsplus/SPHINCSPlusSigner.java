package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SPHINCSPlusSigner implements MessageSigner {

    /* renamed from: privKey */
    private SPHINCSPlusPrivateKeyParameters f24136privKey;

    /* renamed from: pubKey */
    private SPHINCSPlusPublicKeyParameters f24137pubKey;

    /* renamed from: random */
    private SecureRandom f24138random;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        SPHINCSPlusEngine engine = this.f24136privKey.getParameters().getEngine();
        engine.mo18163init(this.f24136privKey.f24133pk.f24087seed);
        int i = engine.f24100N;
        byte[] bArr2 = new byte[i];
        SecureRandom secureRandom = this.f24138random;
        int i2 = 0;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        } else {
            System.arraycopy(this.f24136privKey.f24133pk.f24087seed, 0, bArr2, 0, i);
        }
        C6225Fors c6225Fors = new C6225Fors(engine);
        byte[] bArrMo18161PRF_msg = engine.mo18161PRF_msg(this.f24136privKey.f24134sk.f24093prf, bArr2, bArr);
        C6227PK c6227pk = this.f24136privKey.f24133pk;
        IndexedDigest indexedDigestMo18159H_msg = engine.mo18159H_msg(bArrMo18161PRF_msg, c6227pk.f24087seed, c6227pk.f24086root, bArr);
        byte[] bArr3 = indexedDigestMo18159H_msg.f24085digest;
        long j = indexedDigestMo18159H_msg.idx_tree;
        int i3 = indexedDigestMo18159H_msg.idx_leaf;
        C6224ADRS c6224adrs = new C6224ADRS();
        c6224adrs.setTypeAndClear(3);
        c6224adrs.setTreeAddress(j);
        c6224adrs.setKeyPairAddress(i3);
        SPHINCSPlusPrivateKeyParameters sPHINCSPlusPrivateKeyParameters = this.f24136privKey;
        SIG_FORS[] sig_forsArrM18144sign = c6225Fors.m18144sign(bArr3, sPHINCSPlusPrivateKeyParameters.f24134sk.f24094seed, sPHINCSPlusPrivateKeyParameters.f24133pk.f24087seed, c6224adrs);
        C6224ADRS c6224adrs2 = new C6224ADRS();
        c6224adrs2.setTypeAndClear(3);
        c6224adrs2.setTreeAddress(j);
        c6224adrs2.setKeyPairAddress(i3);
        byte[] bArrPkFromSig = c6225Fors.pkFromSig(sig_forsArrM18144sign, bArr3, this.f24136privKey.f24133pk.f24087seed, c6224adrs2);
        new C6224ADRS().setTypeAndClear(2);
        byte[] bArrM18145sign = new C6226HT(engine, this.f24136privKey.m18177getSeed(), this.f24136privKey.getPublicSeed()).m18145sign(bArrPkFromSig, j, i3);
        int length = sig_forsArrM18144sign.length;
        byte[][] bArr4 = new byte[length + 2][];
        bArr4[0] = bArrMo18161PRF_msg;
        while (i2 != sig_forsArrM18144sign.length) {
            int i4 = i2 + 1;
            SIG_FORS sig_fors = sig_forsArrM18144sign[i2];
            bArr4[i4] = C6238Arrays.concatenate(sig_fors.f24090sk, C6238Arrays.concatenate(sig_fors.authPath));
            i2 = i4;
        }
        bArr4[length + 1] = bArrM18145sign;
        return C6238Arrays.concatenate(bArr4);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f24137pubKey = (SPHINCSPlusPublicKeyParameters) cipherParameters;
        } else {
            if (!(cipherParameters instanceof ParametersWithRandom)) {
                this.f24136privKey = (SPHINCSPlusPrivateKeyParameters) cipherParameters;
                return;
            }
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f24136privKey = (SPHINCSPlusPrivateKeyParameters) parametersWithRandom.getParameters();
            this.f24138random = parametersWithRandom.getRandom();
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        SPHINCSPlusEngine engine = this.f24137pubKey.getParameters().getEngine();
        engine.mo18163init(this.f24137pubKey.m18179getSeed());
        C6224ADRS c6224adrs = new C6224ADRS();
        C6228SIG c6228sig = new C6228SIG(engine.f24100N, engine.f24099K, engine.f24095A, engine.f24096D, engine.f24098H_PRIME, engine.WOTS_LEN, bArr2);
        byte[] bArrM18155getR = c6228sig.m18155getR();
        SIG_FORS[] sig_fors = c6228sig.getSIG_FORS();
        SIG_XMSS[] sig_ht = c6228sig.getSIG_HT();
        IndexedDigest indexedDigestMo18159H_msg = engine.mo18159H_msg(bArrM18155getR, this.f24137pubKey.m18179getSeed(), this.f24137pubKey.m18178getRoot(), bArr);
        byte[] bArr3 = indexedDigestMo18159H_msg.f24085digest;
        long j = indexedDigestMo18159H_msg.idx_tree;
        int i = indexedDigestMo18159H_msg.idx_leaf;
        c6224adrs.setTypeAndClear(3);
        c6224adrs.setLayerAddress(0);
        c6224adrs.setTreeAddress(j);
        c6224adrs.setKeyPairAddress(i);
        byte[] bArrPkFromSig = new C6225Fors(engine).pkFromSig(sig_fors, bArr3, this.f24137pubKey.m18179getSeed(), c6224adrs);
        c6224adrs.setTypeAndClear(2);
        c6224adrs.setLayerAddress(0);
        c6224adrs.setTreeAddress(j);
        c6224adrs.setKeyPairAddress(i);
        return new C6226HT(engine, null, this.f24137pubKey.m18179getSeed()).m18146verify(bArrPkFromSig, sig_ht, this.f24137pubKey.m18179getSeed(), j, i, this.f24137pubKey.m18178getRoot());
    }
}
