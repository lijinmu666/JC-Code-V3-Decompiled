package org.bouncycastle.p191cms.p193jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceKTSKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceSymmetricKeyUnwrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;

/* loaded from: classes2.dex */
class DefaultJcaJceExtHelper extends DefaultJcaJceHelper implements JcaJceExtHelper {
    @Override // org.bouncycastle.p191cms.p193jcajce.JcaJceExtHelper
    public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return new JceAsymmetricKeyUnwrapper(algorithmIdentifier, CMSUtils.cleanPrivateKey(privateKey));
    }

    @Override // org.bouncycastle.p191cms.p193jcajce.JcaJceExtHelper
    public AsymmetricKeyUnwrapper createKEMUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return new JceCMSKEMKeyUnwrapper(algorithmIdentifier, privateKey);
    }

    @Override // org.bouncycastle.p191cms.p193jcajce.JcaJceExtHelper
    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return new JceSymmetricKeyUnwrapper(algorithmIdentifier, secretKey);
    }

    @Override // org.bouncycastle.p191cms.p193jcajce.JcaJceExtHelper
    public JceKTSKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return new JceKTSKeyUnwrapper(algorithmIdentifier, CMSUtils.cleanPrivateKey(privateKey), bArr, bArr2);
    }
}
