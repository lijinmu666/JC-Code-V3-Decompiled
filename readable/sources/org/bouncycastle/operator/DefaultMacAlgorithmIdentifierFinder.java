package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class DefaultMacAlgorithmIdentifierFinder implements MacAlgorithmIdentifierFinder {
    private static Map macNameToAlgIds;

    static {
        HashMap map = new HashMap();
        macNameToAlgIds = map;
        map.put("HMACSHA1", new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1));
        Map map2 = macNameToAlgIds;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA224;
        C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
        map2.put("HMACSHA224", new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull));
        macNameToAlgIds.put("HMACSHA256", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, c5103DERNull));
        macNameToAlgIds.put("HMACSHA384", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, c5103DERNull));
        macNameToAlgIds.put("HMACSHA512", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, c5103DERNull));
        macNameToAlgIds.put("HMACSHA512-224", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512_224, c5103DERNull));
        macNameToAlgIds.put("HMACSHA512-256", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512_256, c5103DERNull));
        macNameToAlgIds.put("HMACSHA3-224", new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_224));
        macNameToAlgIds.put("HMACSHA3-256", new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_256));
        macNameToAlgIds.put("HMACSHA3-384", new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_384));
        macNameToAlgIds.put("HMACSHA3-512", new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512));
    }

    @Override // org.bouncycastle.operator.MacAlgorithmIdentifierFinder
    /* renamed from: find */
    public AlgorithmIdentifier mo17383find(String str) {
        return (AlgorithmIdentifier) macNameToAlgIds.get(C6250Strings.toUpperCase(str));
    }
}
