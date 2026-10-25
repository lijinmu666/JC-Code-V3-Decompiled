package org.bouncycastle.p191cms.p192bc;

import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.PasswordRecipient;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
public abstract class BcPasswordRecipient implements PasswordRecipient {
    private final char[] password;
    private int schemeID = 1;

    public BcPasswordRecipient(char[] cArr) {
        this.password = cArr;
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public byte[] calculateDerivedKey(int i, AlgorithmIdentifier algorithmIdentifier, int i2) throws CMSException {
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(algorithmIdentifier.getParameters());
        char[] cArr = this.password;
        byte[] bArrPKCS5PasswordToBytes = i == 0 ? PBEParametersGenerator.PKCS5PasswordToBytes(cArr) : PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        try {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(EnvelopedDataHelper.m14915getPRF(pBKDF2Params.m14634getPrf()));
            pKCS5S2ParametersGenerator.m14982init(bArrPKCS5PasswordToBytes, pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue());
            return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(i2)).m15773getKey();
        } catch (Exception e) {
            throw new CMSException("exception creating derived key: " + e.getMessage(), e);
        }
    }

    public KeyParameter extractSecretKey(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws CMSException {
        InterfaceC5283Wrapper interfaceC5283WrapperCreateRFC3211Wrapper = EnvelopedDataHelper.createRFC3211Wrapper(algorithmIdentifier.getAlgorithm());
        interfaceC5283WrapperCreateRFC3211Wrapper.mo14995init(false, new ParametersWithIV(new KeyParameter(bArr), ASN1OctetString.getInstance(algorithmIdentifier.getParameters()).getOctets()));
        try {
            return new KeyParameter(interfaceC5283WrapperCreateRFC3211Wrapper.mo14996unwrap(bArr2, 0, bArr2.length));
        } catch (InvalidCipherTextException e) {
            throw new CMSException("unable to unwrap key: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public char[] getPassword() {
        return this.password;
    }

    @Override // org.bouncycastle.p191cms.PasswordRecipient
    public int getPasswordConversionScheme() {
        return this.schemeID;
    }

    public BcPasswordRecipient setPasswordConversionScheme(int i) {
        this.schemeID = i;
        return this;
    }
}
