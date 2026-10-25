package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class DilithiumParameters {
    public static final DilithiumParameters dilithium2 = new DilithiumParameters("dilithium2", 2, false);
    public static final DilithiumParameters dilithium3 = new DilithiumParameters("dilithium3", 3, false);
    public static final DilithiumParameters dilithium5 = new DilithiumParameters("dilithium5", 5, false);

    /* renamed from: k */
    private final int f23084k;

    /* renamed from: name */
    private final String f23085name;

    @Deprecated
    private final boolean usingAES;

    private DilithiumParameters(String str, int i, boolean z) {
        this.f23085name = str;
        this.f23084k = i;
        this.usingAES = z;
    }

    public DilithiumEngine getEngine(SecureRandom secureRandom) {
        return new DilithiumEngine(this.f23084k, secureRandom, this.usingAES);
    }

    /* renamed from: getName */
    public String m17515getName() {
        return this.f23085name;
    }
}
