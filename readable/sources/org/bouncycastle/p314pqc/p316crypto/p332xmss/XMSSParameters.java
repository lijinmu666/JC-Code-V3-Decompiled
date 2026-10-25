package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public final class XMSSParameters {
    private static final Map<Integer, XMSSParameters> paramsLookupTable;

    /* renamed from: height */
    private final int f23652height;

    /* renamed from: k */
    private final int f23653k;

    /* renamed from: oid */
    private final InterfaceC6124XMSSOid f23654oid;
    private final String treeDigest;
    private final ASN1ObjectIdentifier treeDigestOID;
    private final int treeDigestSize;
    private final int winternitzParameter;
    private final WOTSPlusParameters wotsPlusParams;

    static {
        HashMap map = new HashMap();
        Integer numM18296valueOf = Integers.m18296valueOf(1);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        map.put(numM18296valueOf, new XMSSParameters(10, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(2), new XMSSParameters(16, aSN1ObjectIdentifier));
        map.put(Integers.m18296valueOf(3), new XMSSParameters(20, aSN1ObjectIdentifier));
        Integer numM18296valueOf2 = Integers.m18296valueOf(4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha512;
        map.put(numM18296valueOf2, new XMSSParameters(10, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(5), new XMSSParameters(16, aSN1ObjectIdentifier2));
        map.put(Integers.m18296valueOf(6), new XMSSParameters(20, aSN1ObjectIdentifier2));
        Integer numM18296valueOf3 = Integers.m18296valueOf(7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_shake128;
        map.put(numM18296valueOf3, new XMSSParameters(10, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(8), new XMSSParameters(16, aSN1ObjectIdentifier3));
        map.put(Integers.m18296valueOf(9), new XMSSParameters(20, aSN1ObjectIdentifier3));
        Integer numM18296valueOf4 = Integers.m18296valueOf(10);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_shake256;
        map.put(numM18296valueOf4, new XMSSParameters(10, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(11), new XMSSParameters(16, aSN1ObjectIdentifier4));
        map.put(Integers.m18296valueOf(12), new XMSSParameters(20, aSN1ObjectIdentifier4));
        paramsLookupTable = Collections.unmodifiableMap(map);
    }

    public XMSSParameters(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (i < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        if (aSN1ObjectIdentifier == null) {
            throw new NullPointerException("digest == null");
        }
        this.f23652height = i;
        this.f23653k = determineMinK();
        String digestName = DigestUtil.getDigestName(aSN1ObjectIdentifier);
        this.treeDigest = digestName;
        this.treeDigestOID = aSN1ObjectIdentifier;
        WOTSPlusParameters wOTSPlusParameters = new WOTSPlusParameters(aSN1ObjectIdentifier);
        this.wotsPlusParams = wOTSPlusParameters;
        int treeDigestSize = wOTSPlusParameters.getTreeDigestSize();
        this.treeDigestSize = treeDigestSize;
        int winternitzParameter = wOTSPlusParameters.getWinternitzParameter();
        this.winternitzParameter = winternitzParameter;
        this.f23654oid = DefaultXMSSOid.m17892lookup(digestName, treeDigestSize, winternitzParameter, wOTSPlusParameters.m17903getLen(), i);
    }

    private int determineMinK() {
        int i = 2;
        while (true) {
            int i2 = this.f23652height;
            if (i > i2) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i2 - i) % 2 == 0) {
                return i;
            }
            i++;
        }
    }

    public static XMSSParameters lookupByOID(int i) {
        return paramsLookupTable.get(Integers.m18296valueOf(i));
    }

    public int getHeight() {
        return this.f23652height;
    }

    /* renamed from: getK */
    public int m17922getK() {
        return this.f23653k;
    }

    /* renamed from: getLen */
    public int m17923getLen() {
        return this.wotsPlusParams.m17903getLen();
    }

    /* renamed from: getOid */
    public InterfaceC6124XMSSOid m17924getOid() {
        return this.f23654oid;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigestOID;
    }

    public int getTreeDigestSize() {
        return this.treeDigestSize;
    }

    public WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }

    public XMSSParameters(int i, InterfaceC5277Digest interfaceC5277Digest) {
        this(i, DigestUtil.getDigestOID(interfaceC5277Digest.getAlgorithmName()));
    }
}
