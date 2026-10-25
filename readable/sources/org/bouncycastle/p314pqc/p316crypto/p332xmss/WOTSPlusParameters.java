package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
final class WOTSPlusParameters {
    private final int digestSize;

    /* renamed from: len */
    private final int f23611len;

    /* renamed from: len1 */
    private final int f23612len1;

    /* renamed from: len2 */
    private final int f23613len2;

    /* renamed from: oid */
    private final InterfaceC6124XMSSOid f23614oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter;

    public WOTSPlusParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier == null) {
            throw new NullPointerException("treeDigest == null");
        }
        this.treeDigest = aSN1ObjectIdentifier;
        InterfaceC5277Digest digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
        int digestSize = XMSSUtil.getDigestSize(digest);
        this.digestSize = digestSize;
        this.winternitzParameter = 16;
        int iCeil = (int) Math.ceil((digestSize * 8) / XMSSUtil.m17931log2(16));
        this.f23612len1 = iCeil;
        int iFloor = ((int) Math.floor(XMSSUtil.m17931log2((16 - 1) * iCeil) / XMSSUtil.m17931log2(16))) + 1;
        this.f23613len2 = iFloor;
        int i = iCeil + iFloor;
        this.f23611len = i;
        WOTSPlusOid wOTSPlusOidM17902lookup = WOTSPlusOid.m17902lookup(digest.getAlgorithmName(), digestSize, 16, i);
        this.f23614oid = wOTSPlusOidM17902lookup;
        if (wOTSPlusOidM17902lookup != null) {
            return;
        }
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + digest.getAlgorithmName());
    }

    /* renamed from: getLen */
    public int m17903getLen() {
        return this.f23611len;
    }

    /* renamed from: getLen1 */
    public int m17904getLen1() {
        return this.f23612len1;
    }

    /* renamed from: getLen2 */
    public int m17905getLen2() {
        return this.f23613len2;
    }

    /* renamed from: getOid */
    public InterfaceC6124XMSSOid m17906getOid() {
        return this.f23614oid;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int getTreeDigestSize() {
        return this.digestSize;
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
