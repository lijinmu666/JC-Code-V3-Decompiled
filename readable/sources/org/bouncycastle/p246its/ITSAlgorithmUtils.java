package org.bouncycastle.p246its;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashAlgorithm;

/* loaded from: classes2.dex */
public class ITSAlgorithmUtils {

    /* renamed from: algoMap */
    private static final Map<Object, HashAlgorithm> f21289algoMap;

    static {
        HashMap map = new HashMap();
        f21289algoMap = map;
        map.put(NISTObjectIdentifiers.id_sha256, HashAlgorithm.f22730sha256);
        map.put(NISTObjectIdentifiers.id_sha384, HashAlgorithm.f22731sha384);
    }

    public static HashAlgorithm getHashAlgorithm(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f21289algoMap.get(aSN1ObjectIdentifier);
    }
}
