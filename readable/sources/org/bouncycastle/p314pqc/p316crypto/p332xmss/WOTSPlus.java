package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
final class WOTSPlus {

    /* renamed from: khf */
    private final KeyedHashFunctions f23608khf;

    /* renamed from: params */
    private final WOTSPlusParameters f23609params;
    private byte[] publicSeed;
    private byte[] secretKeySeed;

    public WOTSPlus(WOTSPlusParameters wOTSPlusParameters) {
        if (wOTSPlusParameters == null) {
            throw new NullPointerException("params == null");
        }
        this.f23609params = wOTSPlusParameters;
        int treeDigestSize = wOTSPlusParameters.getTreeDigestSize();
        this.f23608khf = new KeyedHashFunctions(wOTSPlusParameters.getTreeDigest(), treeDigestSize);
        this.secretKeySeed = new byte[treeDigestSize];
        this.publicSeed = new byte[treeDigestSize];
    }

    /* renamed from: chain */
    private byte[] m17899chain(byte[] bArr, int i, int i2, OTSHashAddress oTSHashAddress) {
        int treeDigestSize = this.f23609params.getTreeDigestSize();
        if (bArr == null) {
            throw new NullPointerException("startHash == null");
        }
        if (bArr.length != treeDigestSize) {
            throw new IllegalArgumentException("startHash needs to be " + treeDigestSize + "bytes");
        }
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        if (oTSHashAddress.toByteArray() == null) {
            throw new NullPointerException("otsHashAddress byte array == null");
        }
        int i3 = i + i2;
        if (i3 > this.f23609params.getWinternitzParameter() - 1) {
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        if (i2 == 0) {
            return bArr;
        }
        byte[] bArrM17899chain = m17899chain(bArr, i, i2 - 1, oTSHashAddress);
        OTSHashAddress oTSHashAddress2 = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(i3 - 1).withKeyAndMask(0).mo17893build();
        byte[] bArrM17898PRF = this.f23608khf.m17898PRF(this.publicSeed, oTSHashAddress2.toByteArray());
        byte[] bArrM17898PRF2 = this.f23608khf.m17898PRF(this.publicSeed, ((OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress2.getLayerAddress()).withTreeAddress(oTSHashAddress2.getTreeAddress()).withOTSAddress(oTSHashAddress2.getOTSAddress()).withChainAddress(oTSHashAddress2.getChainAddress()).withHashAddress(oTSHashAddress2.getHashAddress()).withKeyAndMask(1).mo17893build()).toByteArray());
        byte[] bArr2 = new byte[treeDigestSize];
        for (int i4 = 0; i4 < treeDigestSize; i4++) {
            bArr2[i4] = (byte) (bArrM17899chain[i4] ^ bArrM17898PRF2[i4]);
        }
        return this.f23608khf.m17895F(bArrM17898PRF, bArr2);
    }

    private List<Integer> convertToBaseW(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("msg == null");
        }
        if (i != 4 && i != 16) {
            throw new IllegalArgumentException("w needs to be 4 or 16");
        }
        int iM17931log2 = XMSSUtil.m17931log2(i);
        if (i2 > (bArr.length * 8) / iM17931log2) {
            throw new IllegalArgumentException("outLength too big");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 : bArr) {
            for (int i4 = 8 - iM17931log2; i4 >= 0; i4 -= iM17931log2) {
                arrayList.add(Integer.valueOf((i3 >> i4) & (i - 1)));
                if (arrayList.size() == i2) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    private byte[] expandSecretKeySeed(int i) {
        if (i < 0 || i >= this.f23609params.m17903getLen()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return this.f23608khf.m17898PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian(i, 32));
    }

    /* renamed from: getKhf */
    public KeyedHashFunctions m17900getKhf() {
        return this.f23608khf;
    }

    public WOTSPlusParameters getParams() {
        return this.f23609params;
    }

    public WOTSPlusPrivateKeyParameters getPrivateKey() {
        int iM17903getLen = this.f23609params.m17903getLen();
        byte[][] bArr = new byte[iM17903getLen][];
        for (int i = 0; i < iM17903getLen; i++) {
            bArr[i] = expandSecretKeySeed(i);
        }
        return new WOTSPlusPrivateKeyParameters(this.f23609params, bArr);
    }

    public WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress oTSHashAddress) {
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        byte[][] bArr = new byte[this.f23609params.m17903getLen()][];
        for (int i = 0; i < this.f23609params.m17903getLen(); i++) {
            oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask()).mo17893build();
            bArr[i] = m17899chain(expandSecretKeySeed(i), 0, this.f23609params.getWinternitzParameter() - 1, oTSHashAddress);
        }
        return new WOTSPlusPublicKeyParameters(this.f23609params, bArr);
    }

    public WOTSPlusPublicKeyParameters getPublicKeyFromSignature(byte[] bArr, WOTSPlusSignature wOTSPlusSignature, OTSHashAddress oTSHashAddress) {
        if (bArr == null) {
            throw new NullPointerException("messageDigest == null");
        }
        if (bArr.length != this.f23609params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        if (wOTSPlusSignature == null) {
            throw new NullPointerException("signature == null");
        }
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        List<Integer> listConvertToBaseW = convertToBaseW(bArr, this.f23609params.getWinternitzParameter(), this.f23609params.m17904getLen1());
        int winternitzParameter = 0;
        for (int i = 0; i < this.f23609params.m17904getLen1(); i++) {
            winternitzParameter += (this.f23609params.getWinternitzParameter() - 1) - listConvertToBaseW.get(i).intValue();
        }
        listConvertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(winternitzParameter << (8 - ((this.f23609params.m17905getLen2() * XMSSUtil.m17931log2(this.f23609params.getWinternitzParameter())) % 8)), (int) Math.ceil((this.f23609params.m17905getLen2() * XMSSUtil.m17931log2(this.f23609params.getWinternitzParameter())) / 8.0d)), this.f23609params.getWinternitzParameter(), this.f23609params.m17905getLen2()));
        byte[][] bArr2 = new byte[this.f23609params.m17903getLen()][];
        for (int i2 = 0; i2 < this.f23609params.m17903getLen(); i2++) {
            oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i2).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask()).mo17893build();
            bArr2[i2] = m17899chain(wOTSPlusSignature.toByteArray()[i2], listConvertToBaseW.get(i2).intValue(), (this.f23609params.getWinternitzParameter() - 1) - listConvertToBaseW.get(i2).intValue(), oTSHashAddress);
        }
        return new WOTSPlusPublicKeyParameters(this.f23609params, bArr2);
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.publicSeed);
    }

    public byte[] getSecretKeySeed() {
        return C6238Arrays.m18231clone(this.secretKeySeed);
    }

    public byte[] getWOTSPlusSecretKey(byte[] bArr, OTSHashAddress oTSHashAddress) {
        return this.f23608khf.m17898PRF(bArr, ((OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(oTSHashAddress.getOTSAddress()).mo17893build()).toByteArray());
    }

    public void importKeys(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("secretKeySeed == null");
        }
        if (bArr.length != this.f23609params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        }
        if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        }
        if (bArr2.length != this.f23609params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        this.secretKeySeed = bArr;
        this.publicSeed = bArr2;
    }

    /* renamed from: sign */
    public WOTSPlusSignature m17901sign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr == null) {
            throw new NullPointerException("messageDigest == null");
        }
        if (bArr.length != this.f23609params.getTreeDigestSize()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        List<Integer> listConvertToBaseW = convertToBaseW(bArr, this.f23609params.getWinternitzParameter(), this.f23609params.m17904getLen1());
        int winternitzParameter = 0;
        for (int i = 0; i < this.f23609params.m17904getLen1(); i++) {
            winternitzParameter += (this.f23609params.getWinternitzParameter() - 1) - listConvertToBaseW.get(i).intValue();
        }
        listConvertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(winternitzParameter << (8 - ((this.f23609params.m17905getLen2() * XMSSUtil.m17931log2(this.f23609params.getWinternitzParameter())) % 8)), (int) Math.ceil((this.f23609params.m17905getLen2() * XMSSUtil.m17931log2(this.f23609params.getWinternitzParameter())) / 8.0d)), this.f23609params.getWinternitzParameter(), this.f23609params.m17905getLen2()));
        byte[][] bArr2 = new byte[this.f23609params.m17903getLen()][];
        for (int i2 = 0; i2 < this.f23609params.m17903getLen(); i2++) {
            oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i2).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask()).mo17893build();
            bArr2[i2] = m17899chain(expandSecretKeySeed(i2), 0, listConvertToBaseW.get(i2).intValue(), oTSHashAddress);
        }
        return new WOTSPlusSignature(this.f23609params, bArr2);
    }
}
