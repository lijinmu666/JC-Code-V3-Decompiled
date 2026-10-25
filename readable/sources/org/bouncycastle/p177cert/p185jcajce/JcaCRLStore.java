package org.bouncycastle.p177cert.p185jcajce;

import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p361util.CollectionStore;

/* loaded from: classes2.dex */
public class JcaCRLStore extends CollectionStore {
    public JcaCRLStore(Collection collection) {
        super(convertCRLs(collection));
    }

    private static Collection convertCRLs(Collection collection) throws CRLException {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj instanceof X509CRL) {
                try {
                    arrayList.add(new X509CRLHolder(((X509CRL) obj).getEncoded()));
                } catch (IOException e) {
                    throw new CRLException("cannot read encoding: " + e.getMessage());
                }
            } else {
                arrayList.add((X509CRLHolder) obj);
            }
        }
        return arrayList;
    }
}
