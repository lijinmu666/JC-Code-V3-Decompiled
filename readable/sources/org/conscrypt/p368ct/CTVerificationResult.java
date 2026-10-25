package org.conscrypt.p368ct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.p368ct.VerifiedSCT;

/* loaded from: classes2.dex */
public class CTVerificationResult {
    private final ArrayList<VerifiedSCT> validSCTs = new ArrayList<>();
    private final ArrayList<VerifiedSCT> invalidSCTs = new ArrayList<>();

    /* renamed from: add */
    public void m18515add(VerifiedSCT verifiedSCT) {
        if (verifiedSCT.f24493status == VerifiedSCT.EnumC6342Status.VALID) {
            this.validSCTs.add(verifiedSCT);
        } else {
            this.invalidSCTs.add(verifiedSCT);
        }
    }

    public List<VerifiedSCT> getInvalidSCTs() {
        return Collections.unmodifiableList(this.invalidSCTs);
    }

    public List<VerifiedSCT> getValidSCTs() {
        return Collections.unmodifiableList(this.validSCTs);
    }
}
