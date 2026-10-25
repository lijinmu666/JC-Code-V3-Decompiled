package org.bouncycastle.p307pkcs;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.C5136MacData;
import org.bouncycastle.p133asn1.p166pkcs.C5137Pfx;
import org.bouncycastle.p133asn1.p166pkcs.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PKCS12PfxPdu {

    /* renamed from: pfx */
    private C5137Pfx f22929pfx;

    public PKCS12PfxPdu(C5137Pfx c5137Pfx) {
        this.f22929pfx = c5137Pfx;
    }

    private static C5137Pfx parseBytes(byte[] bArr) throws PKCSIOException {
        try {
            return C5137Pfx.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new PKCSIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new PKCSIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public ContentInfo[] getContentInfos() {
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(ASN1OctetString.getInstance(this.f22929pfx.getAuthSafe().getContent()).getOctets());
        ContentInfo[] contentInfoArr = new ContentInfo[aSN1Sequence.mo14450size()];
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            contentInfoArr[i] = ContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return contentInfoArr;
    }

    public byte[] getEncoded() {
        return toASN1Structure().getEncoded();
    }

    public AlgorithmIdentifier getMacAlgorithmID() {
        C5136MacData macData = this.f22929pfx.getMacData();
        if (macData != null) {
            return macData.m14631getMac().getAlgorithmId();
        }
        return null;
    }

    /* renamed from: hasMac */
    public boolean m17409hasMac() {
        return this.f22929pfx.getMacData() != null;
    }

    public boolean isMacValid(PKCS12MacCalculatorBuilderProvider pKCS12MacCalculatorBuilderProvider, char[] cArr) throws PKCSException {
        ASN1Encodable pKCS12PBEParams;
        C5136MacData macData = this.f22929pfx.getMacData();
        if (macData == null) {
            throw new IllegalStateException("no MAC present on PFX");
        }
        AlgorithmIdentifier algorithmId = macData.m14631getMac().getAlgorithmId();
        ASN1ObjectIdentifier algorithm = algorithmId.getAlgorithm();
        if (PKCSObjectIdentifiers.id_PBMAC1.m14446equals((ASN1Primitive) algorithm)) {
            pKCS12PBEParams = PBMAC1Params.getInstance(algorithmId.getParameters());
            if (pKCS12PBEParams == null) {
                throw new PKCSException("If the DigestAlgorithmIdentifier is id-PBMAC1, then the parameters field must contain valid PBMAC1-params parameters.");
            }
        } else {
            pKCS12PBEParams = new PKCS12PBEParams(macData.m14632getSalt(), BigIntegers.intValueExact(macData.getIterationCount()));
        }
        try {
            return C6238Arrays.constantTimeAreEqual(new MacDataGenerator(pKCS12MacCalculatorBuilderProvider.mo17408get(new AlgorithmIdentifier(algorithm, pKCS12PBEParams))).m17403build(cArr, ASN1OctetString.getInstance(this.f22929pfx.getAuthSafe().getContent()).getOctets()).getEncoded(), macData.getEncoded());
        } catch (IOException e) {
            throw new PKCSException("unable to process AuthSafe: " + e.getMessage());
        }
    }

    public C5137Pfx toASN1Structure() {
        return this.f22929pfx;
    }

    public PKCS12PfxPdu(byte[] bArr) {
        this(parseBytes(bArr));
    }

    public byte[] getEncoded(String str) {
        return toASN1Structure().getEncoded(str);
    }
}
