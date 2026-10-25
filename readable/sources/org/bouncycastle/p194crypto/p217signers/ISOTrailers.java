package org.bouncycastle.p194crypto.p217signers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class ISOTrailers {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_SHA512_224 = 14796;
    public static final int TRAILER_SHA512_256 = 15052;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private static final Map<String, Integer> trailerMap;

    static {
        HashMap map = new HashMap();
        map.put("RIPEMD128", Integers.m18296valueOf(13004));
        map.put("RIPEMD160", Integers.m18296valueOf(12748));
        map.put("SHA-1", Integers.m18296valueOf(13260));
        map.put("SHA-224", Integers.m18296valueOf(14540));
        map.put(XMSSKeyParameters.f23621SHA_256, Integers.m18296valueOf(13516));
        map.put("SHA-384", Integers.m18296valueOf(14028));
        map.put(XMSSKeyParameters.f23622SHA_512, Integers.m18296valueOf(13772));
        map.put("SHA-512/224", Integers.m18296valueOf(TRAILER_SHA512_224));
        map.put(SPHINCSKeyParameters.SHA512_256, Integers.m18296valueOf(TRAILER_SHA512_256));
        map.put("Whirlpool", Integers.m18296valueOf(14284));
        trailerMap = Collections.unmodifiableMap(map);
    }

    public static Integer getTrailer(InterfaceC5277Digest interfaceC5277Digest) {
        return trailerMap.get(interfaceC5277Digest.getAlgorithmName());
    }

    public static boolean noTrailerAvailable(InterfaceC5277Digest interfaceC5277Digest) {
        return !trailerMap.containsKey(interfaceC5277Digest.getAlgorithmName());
    }
}
