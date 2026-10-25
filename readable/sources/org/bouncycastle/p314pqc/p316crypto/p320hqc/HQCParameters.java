package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p174x509.DisplayText;
import org.bouncycastle.p314pqc.p316crypto.KEMParameters;

/* loaded from: classes2.dex */
public class HQCParameters implements KEMParameters {
    static final int GF_MUL_ORDER = 255;

    /* renamed from: PARAM_M */
    static final int f23199PARAM_M = 8;

    /* renamed from: hqc128 */
    public static final HQCParameters f23200hqc128 = new HQCParameters("hqc-128", 17669, 46, 384, 16, 15, 66, 75, 4, 243079, 2241, 2321, new int[]{89, 69, 153, 116, 176, 117, 111, 75, 73, 233, 242, 233, 65, 210, 21, 139, 103, 173, 67, 118, 105, 210, 174, 110, 74, 69, 228, 82, 255, 181, 1});

    /* renamed from: hqc192 */
    public static final HQCParameters f23201hqc192 = new HQCParameters("hqc-192", 35851, 56, 640, 24, 16, 100, 114, 5, 119800, 4514, 4602, new int[]{45, 216, 239, 24, 253, 104, 27, 40, 107, 50, 163, 210, 227, 134, InterfaceC5102BERTags.f17976FLAGS, 158, 119, 13, 158, 1, 238, 164, 82, 43, 15, 232, 246, 142, 50, 189, 29, 232, 1});

    /* renamed from: hqc256 */
    public static final HQCParameters f23202hqc256 = new HQCParameters("hqc-256", 57637, 90, 640, 32, 29, 131, 149, 5, 74517, 7237, 7333, new int[]{49, 167, 49, 39, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 121, 124, 91, 240, 63, 148, 71, 150, 123, 87, 101, 32, 215, 159, 71, 201, 115, 97, 210, 186, 183, 141, 217, 123, 12, 31, 243, 180, 219, 152, 239, 99, 141, 4, 246, 191, 144, 8, 232, 47, 27, 141, 178, 130, 64, 124, 47, 39, 188, 216, 48, 199, 187, 1});

    /* renamed from: engine */
    private final HQCEngine f23203engine;

    /* renamed from: n */
    private final int f23204n;

    /* renamed from: n1 */
    private final int f23205n1;

    /* renamed from: n2 */
    private final int f23206n2;

    /* renamed from: name */
    private final String f23207name;
    private final int publicKeyBytes;
    private final int secretKeyBytes;

    private HQCParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        this.f23207name = str;
        this.f23204n = i;
        this.f23205n1 = i2;
        this.f23206n2 = i3;
        this.publicKeyBytes = i10;
        this.secretKeyBytes = i11;
        this.f23203engine = new HQCEngine(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, iArr);
    }

    public int getEncapsulationLength() {
        return this.f23203engine.getCipherTextBytes();
    }

    public HQCEngine getEngine() {
        return this.f23203engine;
    }

    public int getN1N2_BYTES() {
        return ((this.f23205n1 * this.f23206n2) + 7) / 8;
    }

    public int getN_BYTES() {
        return (this.f23204n + 7) / 8;
    }

    /* renamed from: getName */
    public String m17592getName() {
        return this.f23207name;
    }

    public int getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    public int getSALT_SIZE_BYTES() {
        return 16;
    }

    public int getSHA512_BYTES() {
        return 64;
    }

    public int getSecretKeyBytes() {
        return this.secretKeyBytes;
    }

    public int getSessionKeySize() {
        return 256;
    }
}
