package org.bouncycastle.p358tsp.p360ers;

import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;

/* loaded from: classes2.dex */
public interface ERSRootNodeCalculator {
    PartialHashtree[] computePathToRoot(DigestCalculator digestCalculator, PartialHashtree partialHashtree, int i);

    byte[] computeRootHash(DigestCalculator digestCalculator, PartialHashtree[] partialHashtreeArr);

    byte[] recoverRootHash(DigestCalculator digestCalculator, PartialHashtree[] partialHashtreeArr);
}
