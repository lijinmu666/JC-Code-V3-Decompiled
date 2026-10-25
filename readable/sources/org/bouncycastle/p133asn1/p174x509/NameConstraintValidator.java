package org.bouncycastle.p133asn1.p174x509;

/* loaded from: classes2.dex */
public interface NameConstraintValidator {
    void addExcludedSubtree(GeneralSubtree generalSubtree);

    void checkExcluded(GeneralName generalName);

    void checkPermitted(GeneralName generalName);

    void intersectEmptyPermittedSubtree(int i);

    void intersectPermittedSubtree(GeneralSubtree generalSubtree);

    void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr);
}
