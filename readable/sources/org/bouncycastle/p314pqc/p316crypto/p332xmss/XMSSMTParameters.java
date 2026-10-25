package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public final class XMSSMTParameters {
    private static final Map<Integer, XMSSMTParameters> paramsLookupTable;

    /* renamed from: height */
    private final int f23627height;

    /* renamed from: layers */
    private final int f23628layers;

    /* renamed from: oid */
    private final InterfaceC6124XMSSOid f23629oid;
    private final XMSSParameters xmssParams;

    static {
        HashMap map = new HashMap();
        Integer numM18296valueOf = Integers.m18296valueOf(1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        map.put(numM18296valueOf, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(2), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(3), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(4), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(5), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(6), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(7), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(8), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier));
        Integer numM18296valueOf2 = Integers.m18296valueOf(9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        map.put(numM18296valueOf2, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(10), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(11), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(12), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(13), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(14), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(15), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(16), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier2));
        Integer numM18296valueOf3 = Integers.m18296valueOf(17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        map.put(numM18296valueOf3, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(18), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(19), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(20), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(21), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(22), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(23), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(24), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier3));
        Integer numM18296valueOf4 = Integers.m18296valueOf(25);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        map.put(numM18296valueOf4, new XMSSMTParameters(20, 2, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(26), new XMSSMTParameters(20, 4, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(27), new XMSSMTParameters(40, 2, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(28), new XMSSMTParameters(40, 4, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(29), new XMSSMTParameters(40, 8, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(30), new XMSSMTParameters(60, 3, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(31), new XMSSMTParameters(60, 6, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(32), new XMSSMTParameters(60, 12, aSN1ObjectIdentifier4));
        paramsLookupTable = Collections.unmodifiableMap(map);
    }

    public XMSSMTParameters(int i, int i2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f23627height = i;
        this.f23628layers = i2;
        this.xmssParams = new XMSSParameters(xmssTreeHeight(i, i2), aSN1ObjectIdentifier);
        this.f23629oid = DefaultXMSSMTOid.m17890lookup(getTreeDigest(), getTreeDigestSize(), getWinternitzParameter(), m17913getLen(), getHeight(), i2);
    }

    public static XMSSMTParameters lookupByOID(int i) {
        return paramsLookupTable.get(Integers.m18296valueOf(i));
    }

    private static int xmssTreeHeight(int i, int i2) {
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i % i2 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i3 = i / i2;
        if (i3 != 1) {
            return i3;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
    }

    public int getHeight() {
        return this.f23627height;
    }

    public int getLayers() {
        return this.f23628layers;
    }

    /* renamed from: getLen */
    public int m17913getLen() {
        return this.xmssParams.m17923getLen();
    }

    /* renamed from: getOid */
    public InterfaceC6124XMSSOid m17914getOid() {
        return this.f23629oid;
    }

    public String getTreeDigest() {
        return this.xmssParams.getTreeDigest();
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.xmssParams.getTreeDigestOID();
    }

    public int getTreeDigestSize() {
        return this.xmssParams.getTreeDigestSize();
    }

    public WOTSPlus getWOTSPlus() {
        return this.xmssParams.getWOTSPlus();
    }

    public int getWinternitzParameter() {
        return this.xmssParams.getWinternitzParameter();
    }

    public XMSSParameters getXMSSParameters() {
        return this.xmssParams;
    }

    public XMSSMTParameters(int i, int i2, InterfaceC5277Digest interfaceC5277Digest) {
        this(i, i2, DigestUtil.getDigestOID(interfaceC5277Digest.getAlgorithmName()));
    }
}
