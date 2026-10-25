package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class DefaultKemEncapsulationLengthProvider implements KemEncapsulationLengthProvider {
    private static Map<ASN1ObjectIdentifier, Integer> kemEncapsulationLengths;

    static {
        HashMap map = new HashMap();
        kemEncapsulationLengths = map;
        map.put(NISTObjectIdentifiers.id_alg_ml_kem_512, Integers.m18296valueOf(768));
        kemEncapsulationLengths.put(NISTObjectIdentifiers.id_alg_ml_kem_768, Integers.m18296valueOf(1088));
        kemEncapsulationLengths.put(NISTObjectIdentifiers.id_alg_ml_kem_1024, Integers.m18296valueOf(1568));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhps2048509, Integers.m18296valueOf(699));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhps2048677, Integers.m18296valueOf(930));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhps4096821, Integers.m18296valueOf(1230));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhps40961229, Integers.m18296valueOf(1842));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhrss701, Integers.m18296valueOf(1138));
        kemEncapsulationLengths.put(BCObjectIdentifiers.ntruhrss1373, Integers.m18296valueOf(2401));
        kemEncapsulationLengths.put(BCObjectIdentifiers.f18023hqc128, Integers.m18296valueOf(4433));
        kemEncapsulationLengths.put(BCObjectIdentifiers.f18024hqc192, Integers.m18296valueOf(8978));
        kemEncapsulationLengths.put(BCObjectIdentifiers.f18025hqc256, Integers.m18296valueOf(14421));
    }

    @Override // org.bouncycastle.operator.KemEncapsulationLengthProvider
    public int getEncapsulationLength(AlgorithmIdentifier algorithmIdentifier) {
        return kemEncapsulationLengths.get(algorithmIdentifier.getAlgorithm()).intValue();
    }
}
