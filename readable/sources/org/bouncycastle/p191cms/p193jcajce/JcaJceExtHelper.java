package org.bouncycastle.p191cms.p193jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceKTSKeyUnwrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
interface JcaJceExtHelper extends JcaJceHelper {
    JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey);

    JceKTSKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey, byte[] bArr, byte[] bArr2);

    AsymmetricKeyUnwrapper createKEMUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey);

    SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey);
}
