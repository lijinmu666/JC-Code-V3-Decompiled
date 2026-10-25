package org.bouncycastle.p249jcajce.p279spec;

import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class PBKDF2KeySpec extends PBEKeySpec {
    private static final AlgorithmIdentifier defaultPRF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, C5103DERNull.INSTANCE);

    /* renamed from: prf */
    private AlgorithmIdentifier f21940prf;

    public PBKDF2KeySpec(char[] cArr, byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        super(cArr, bArr, i, i2);
        this.f21940prf = algorithmIdentifier;
    }

    /* renamed from: getPrf */
    public AlgorithmIdentifier m16212getPrf() {
        return this.f21940prf;
    }

    public boolean isDefaultPrf() {
        return defaultPRF.mo14431equals(this.f21940prf);
    }
}
