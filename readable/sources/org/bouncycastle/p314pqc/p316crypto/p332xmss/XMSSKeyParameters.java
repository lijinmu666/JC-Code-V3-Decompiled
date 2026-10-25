package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class XMSSKeyParameters extends AsymmetricKeyParameter {
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";

    /* renamed from: SHA_256 */
    public static final String f23621SHA_256 = "SHA-256";

    /* renamed from: SHA_512 */
    public static final String f23622SHA_512 = "SHA-512";
    private final String treeDigest;

    public XMSSKeyParameters(boolean z, String str) {
        super(z);
        this.treeDigest = str;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
