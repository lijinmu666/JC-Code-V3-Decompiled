package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p133asn1.p157kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
class SEEDUtil {
    public static AlgorithmIdentifier determineKeyEncAlg() {
        return new AlgorithmIdentifier(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap);
    }
}
