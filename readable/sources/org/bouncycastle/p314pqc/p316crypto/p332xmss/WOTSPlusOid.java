package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class WOTSPlusOid implements InterfaceC6124XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable;

    /* renamed from: oid */
    private final int f23610oid;
    private final String stringRepresentation;

    static {
        HashMap map = new HashMap();
        map.put(createKey(XMSSKeyParameters.f23621SHA_256, 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        map.put(createKey(XMSSKeyParameters.f23622SHA_512, 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        map.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        map.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(map);
    }

    private WOTSPlusOid(int i, String str) {
        this.f23610oid = i;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i, int i2, int i3) {
        if (str == null) {
            throw new NullPointerException("algorithmName == null");
        }
        return str + "-" + i + "-" + i2 + "-" + i3;
    }

    /* renamed from: lookup */
    public static WOTSPlusOid m17902lookup(String str, int i, int i2, int i3) {
        if (str != null) {
            return oidLookupTable.get(createKey(str, i, i2, i3));
        }
        throw new NullPointerException("algorithmName == null");
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.InterfaceC6124XMSSOid
    /* renamed from: getOid */
    public int mo17891getOid() {
        return this.f23610oid;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.InterfaceC6124XMSSOid
    public String toString() {
        return this.stringRepresentation;
    }
}
