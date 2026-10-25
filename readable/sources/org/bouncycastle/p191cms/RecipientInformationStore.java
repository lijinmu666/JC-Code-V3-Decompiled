package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p361util.Iterable;

/* loaded from: classes2.dex */
public class RecipientInformationStore implements Iterable<RecipientInformation> {

    /* renamed from: all */
    private final List f19037all;

    /* renamed from: table */
    private final Map f19038table;

    public RecipientInformationStore(Collection<RecipientInformation> collection) {
        this.f19038table = new HashMap();
        for (RecipientInformation recipientInformation : collection) {
            RecipientId recipientIdM14893getRID = recipientInformation.m14893getRID();
            ArrayList arrayList = (ArrayList) this.f19038table.get(recipientIdM14893getRID);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f19038table.put(recipientIdM14893getRID, arrayList);
            }
            arrayList.add(recipientInformation);
        }
        this.f19037all = new ArrayList(collection);
    }

    /* renamed from: get */
    public RecipientInformation m14894get(RecipientId recipientId) {
        Collection<RecipientInformation> recipients = getRecipients(recipientId);
        if (recipients.size() == 0) {
            return null;
        }
        return recipients.iterator().next();
    }

    public Collection<RecipientInformation> getRecipients() {
        return new ArrayList(this.f19037all);
    }

    @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
    public Iterator<RecipientInformation> iterator() {
        return getRecipients().iterator();
    }

    /* renamed from: size */
    public int m14895size() {
        return this.f19037all.size();
    }

    public RecipientInformationStore(RecipientInformation recipientInformation) {
        HashMap map = new HashMap();
        this.f19038table = map;
        ArrayList arrayList = new ArrayList(1);
        this.f19037all = arrayList;
        arrayList.add(recipientInformation);
        map.put(recipientInformation.m14893getRID(), arrayList);
    }

    public Collection<RecipientInformation> getRecipients(RecipientId recipientId) {
        if (recipientId instanceof PKIXRecipientId) {
            PKIXRecipientId pKIXRecipientId = (PKIXRecipientId) recipientId;
            X500Name issuer = pKIXRecipientId.getIssuer();
            byte[] subjectKeyIdentifier = pKIXRecipientId.getSubjectKeyIdentifier();
            if (issuer != null && subjectKeyIdentifier != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) this.f19038table.get(new PKIXRecipientId(pKIXRecipientId.m14891getType(), issuer, pKIXRecipientId.getSerialNumber(), null));
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
                ArrayList arrayList3 = (ArrayList) this.f19038table.get(new PKIXRecipientId(pKIXRecipientId.m14891getType(), null, null, subjectKeyIdentifier));
                if (arrayList3 != null) {
                    arrayList.addAll(arrayList3);
                }
                return arrayList;
            }
        }
        ArrayList arrayList4 = (ArrayList) this.f19038table.get(recipientId);
        return arrayList4 == null ? new ArrayList() : new ArrayList(arrayList4);
    }
}
