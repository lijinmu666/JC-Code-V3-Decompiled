package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p194crypto.p201engines.GOST28147Engine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GOST28147ParameterSpec implements AlgorithmParameterSpec {
    private static Map oidMappings;

    /* renamed from: iv */
    private byte[] f21921iv;

    /* renamed from: sBox */
    private byte[] f21922sBox;

    static {
        HashMap map = new HashMap();
        oidMappings = map;
        map.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
        oidMappings.put(RosstandartObjectIdentifiers.id_tc26_gost_28147_param_Z, "Param-Z");
    }

    public GOST28147ParameterSpec(String str) {
        this.f21921iv = null;
        this.f21922sBox = null;
        this.f21922sBox = GOST28147Engine.m15311getSBox(str);
    }

    /* renamed from: getName */
    private static String m16190getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) oidMappings.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown OID: " + aSN1ObjectIdentifier);
    }

    /* renamed from: getIV */
    public byte[] m16191getIV() {
        return C6238Arrays.m18231clone(this.f21921iv);
    }

    /* renamed from: getSBox */
    public byte[] m16192getSBox() {
        return C6238Arrays.m18231clone(this.f21922sBox);
    }

    /* renamed from: getSbox */
    public byte[] m16193getSbox() {
        return C6238Arrays.m18231clone(this.f21922sBox);
    }

    public GOST28147ParameterSpec(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.f21921iv = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public GOST28147ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this(m16190getName(aSN1ObjectIdentifier));
        this.f21921iv = C6238Arrays.m18231clone(bArr);
    }

    public GOST28147ParameterSpec(byte[] bArr) {
        this.f21921iv = null;
        this.f21922sBox = null;
        byte[] bArr2 = new byte[bArr.length];
        this.f21922sBox = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public GOST28147ParameterSpec(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.f21921iv = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }
}
