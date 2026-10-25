package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;

/* loaded from: classes2.dex */
public class RainbowParameters implements CipherParameters {
    private static final int len_pkseed = 32;
    private static final int len_salt = 16;
    private static final int len_skseed = 32;
    public static final RainbowParameters rainbowIIIcircumzenithal;
    public static final RainbowParameters rainbowIIIclassic;
    public static final RainbowParameters rainbowIIIcompressed;
    public static final RainbowParameters rainbowVcircumzenithal;
    public static final RainbowParameters rainbowVclassic;
    public static final RainbowParameters rainbowVcompressed;
    private final InterfaceC5277Digest hash_algo;

    /* renamed from: m */
    private final int f24037m;

    /* renamed from: n */
    private final int f24038n;

    /* renamed from: name */
    private final String f24039name;

    /* renamed from: o1 */
    private final int f24040o1;

    /* renamed from: o2 */
    private final int f24041o2;

    /* renamed from: v1 */
    private final int f24042v1;

    /* renamed from: v2 */
    private final int f24043v2;

    /* renamed from: version */
    private final EnumC6223Version f24044version;

    static {
        EnumC6223Version enumC6223Version = EnumC6223Version.CLASSIC;
        rainbowIIIclassic = new RainbowParameters("rainbow-III-classic", 3, enumC6223Version);
        EnumC6223Version enumC6223Version2 = EnumC6223Version.CIRCUMZENITHAL;
        rainbowIIIcircumzenithal = new RainbowParameters("rainbow-III-circumzenithal", 3, enumC6223Version2);
        EnumC6223Version enumC6223Version3 = EnumC6223Version.COMPRESSED;
        rainbowIIIcompressed = new RainbowParameters("rainbow-III-compressed", 3, enumC6223Version3);
        rainbowVclassic = new RainbowParameters("rainbow-V-classic", 5, enumC6223Version);
        rainbowVcircumzenithal = new RainbowParameters("rainbow-V-circumzenithal", 5, enumC6223Version2);
        rainbowVcompressed = new RainbowParameters("rainbow-V-compressed", 5, enumC6223Version3);
    }

    private RainbowParameters(String str, int i, EnumC6223Version enumC6223Version) {
        InterfaceC5277Digest sHA384Digest;
        this.f24039name = str;
        if (i == 3) {
            this.f24042v1 = 68;
            this.f24040o1 = 32;
            this.f24041o2 = 48;
            sHA384Digest = new SHA384Digest();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException("No valid version. Please choose one of the following: 3, 5");
            }
            this.f24042v1 = 96;
            this.f24040o1 = 36;
            this.f24041o2 = 64;
            sHA384Digest = new SHA512Digest();
        }
        this.hash_algo = sHA384Digest;
        int i2 = this.f24042v1;
        int i3 = this.f24040o1;
        this.f24043v2 = i2 + i3;
        int i4 = this.f24041o2;
        this.f24038n = i2 + i3 + i4;
        this.f24037m = i3 + i4;
        this.f24044version = enumC6223Version;
    }

    public InterfaceC5277Digest getHash_algo() {
        return this.hash_algo;
    }

    public int getLen_pkseed() {
        return 32;
    }

    public int getLen_salt() {
        return 16;
    }

    public int getLen_skseed() {
        return 32;
    }

    /* renamed from: getM */
    public int m18124getM() {
        return this.f24037m;
    }

    /* renamed from: getN */
    public int m18125getN() {
        return this.f24038n;
    }

    /* renamed from: getName */
    public String m18126getName() {
        return this.f24039name;
    }

    /* renamed from: getO1 */
    public int m18127getO1() {
        return this.f24040o1;
    }

    /* renamed from: getO2 */
    public int m18128getO2() {
        return this.f24041o2;
    }

    /* renamed from: getV1 */
    public int m18129getV1() {
        return this.f24042v1;
    }

    /* renamed from: getV2 */
    public int m18130getV2() {
        return this.f24043v2;
    }

    public EnumC6223Version getVersion() {
        return this.f24044version;
    }
}
