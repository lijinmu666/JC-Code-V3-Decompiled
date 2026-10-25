package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;

/* loaded from: classes2.dex */
public class EdDSAParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: Ed25519 */
    public static final String f21918Ed25519 = "Ed25519";

    /* renamed from: Ed448 */
    public static final String f21919Ed448 = "Ed448";
    private final String curveName;

    public EdDSAParameterSpec(String str) {
        if (!str.equalsIgnoreCase(f21918Ed25519)) {
            if (!str.equalsIgnoreCase(f21919Ed448)) {
                if (!str.equals(EdECObjectIdentifiers.id_Ed25519.m14433getId())) {
                    if (!str.equals(EdECObjectIdentifiers.id_Ed448.m14433getId())) {
                        throw new IllegalArgumentException("unrecognized curve name: " + str);
                    }
                }
            }
            this.curveName = f21919Ed448;
            return;
        }
        this.curveName = f21918Ed25519;
    }

    public String getCurveName() {
        return this.curveName;
    }
}
