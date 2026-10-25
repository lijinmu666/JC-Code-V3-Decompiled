package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;

/* loaded from: classes2.dex */
public class XDHParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: X25519 */
    public static final String f21951X25519 = "X25519";

    /* renamed from: X448 */
    public static final String f21952X448 = "X448";
    private final String curveName;

    public XDHParameterSpec(String str) {
        if (!str.equalsIgnoreCase(f21951X25519)) {
            if (!str.equalsIgnoreCase(f21952X448)) {
                if (!str.equals(EdECObjectIdentifiers.id_X25519.m14433getId())) {
                    if (!str.equals(EdECObjectIdentifiers.f21248id_X448.m14433getId())) {
                        throw new IllegalArgumentException("unrecognized curve name: " + str);
                    }
                }
            }
            this.curveName = f21952X448;
            return;
        }
        this.curveName = f21951X25519;
    }

    public String getCurveName() {
        return this.curveName;
    }
}
