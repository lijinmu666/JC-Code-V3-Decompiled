package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p314pqc.p316crypto.KEMParameters;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPS2048509;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPS2048677;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPS40961229;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPS4096821;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSS1373;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSS701;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;

/* loaded from: classes2.dex */
public class NTRUParameters implements KEMParameters {

    /* renamed from: name */
    private final String f23382name;
    private final NTRUParameterSet parameterSet;
    public static final NTRUParameters ntruhps2048509 = new NTRUParameters("ntruhps2048509", new NTRUHPS2048509());
    public static final NTRUParameters ntruhps2048677 = new NTRUParameters("ntruhps2048677", new NTRUHPS2048677());
    public static final NTRUParameters ntruhps4096821 = new NTRUParameters("ntruhps4096821", new NTRUHPS4096821());
    public static final NTRUParameters ntruhps40961229 = new NTRUParameters("ntruhps40961229", new NTRUHPS40961229());
    public static final NTRUParameters ntruhrss701 = new NTRUParameters("ntruhrss701", new NTRUHRSS701());
    public static final NTRUParameters ntruhrss1373 = new NTRUParameters("ntruhrss1373", new NTRUHRSS1373());

    private NTRUParameters(String str, NTRUParameterSet nTRUParameterSet) {
        this.f23382name = str;
        this.parameterSet = nTRUParameterSet;
    }

    public int getEncapsulationLength() {
        return getParameterSet().ntruCiphertextBytes();
    }

    /* renamed from: getName */
    public String m17762getName() {
        return this.f23382name;
    }

    public NTRUParameterSet getParameterSet() {
        return this.parameterSet;
    }

    public int getPrivateKeyLength() {
        return getParameterSet().ntruSecretKeyBytes();
    }

    public int getPublicKeyLength() {
        return getParameterSet().ntruPublicKeyBytes();
    }

    public int getSessionKeySize() {
        return this.parameterSet.sharedKeyBytes() * 8;
    }
}
