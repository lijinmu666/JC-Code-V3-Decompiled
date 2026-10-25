package org.bouncycastle.p191cms;

import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;

/* loaded from: classes2.dex */
public interface RecipientInfoGenerator {
    RecipientInfo generate(GenericKey genericKey);
}
