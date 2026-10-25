package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p361util.Iterable;

/* loaded from: classes2.dex */
public class SignerInformationStore implements Iterable<SignerInformation> {

    /* renamed from: all */
    private List f19043all;

    /* renamed from: table */
    private Map f19044table = new HashMap();

    public SignerInformationStore(Collection<SignerInformation> collection) {
        this.f19043all = new ArrayList();
        for (SignerInformation signerInformation : collection) {
            SignerId signerIdM14901getSID = signerInformation.m14901getSID();
            ArrayList arrayList = (ArrayList) this.f19044table.get(signerIdM14901getSID);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f19044table.put(signerIdM14901getSID, arrayList);
            }
            arrayList.add(signerInformation);
        }
        this.f19043all = new ArrayList(collection);
    }

    /* renamed from: get */
    public SignerInformation m14903get(SignerId signerId) {
        Collection<SignerInformation> signers = getSigners(signerId);
        if (signers.size() == 0) {
            return null;
        }
        return signers.iterator().next();
    }

    public Collection<SignerInformation> getSigners() {
        return new ArrayList(this.f19043all);
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<SignerInformation> iterator() {
        return getSigners().iterator();
    }

    /* renamed from: size */
    public int m14904size() {
        return this.f19043all.size();
    }

    public SignerInformationStore(SignerInformation signerInformation) {
        this.f19043all = new ArrayList();
        ArrayList arrayList = new ArrayList(1);
        this.f19043all = arrayList;
        arrayList.add(signerInformation);
        this.f19044table.put(signerInformation.m14901getSID(), this.f19043all);
    }

    public Collection<SignerInformation> getSigners(SignerId signerId) {
        if (signerId.getIssuer() == null || signerId.getSubjectKeyIdentifier() == null) {
            ArrayList arrayList = (ArrayList) this.f19044table.get(signerId);
            return arrayList == null ? new ArrayList() : new ArrayList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Collection<SignerInformation> signers = getSigners(new SignerId(signerId.getIssuer(), signerId.getSerialNumber()));
        if (signers != null) {
            arrayList2.addAll(signers);
        }
        Collection<SignerInformation> signers2 = getSigners(new SignerId(signerId.getSubjectKeyIdentifier()));
        if (signers2 != null) {
            arrayList2.addAll(signers2);
        }
        return arrayList2;
    }
}
