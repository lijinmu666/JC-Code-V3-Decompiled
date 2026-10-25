package org.bouncycastle.p177cert.selector;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p177cert.AttributeCertificateHolder;
import org.bouncycastle.p177cert.AttributeCertificateIssuer;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;

/* loaded from: classes2.dex */
public class X509AttributeCertificateHolderSelectorBuilder {
    private X509AttributeCertificateHolder attributeCert;
    private Date attributeCertificateValid;

    /* renamed from: holder */
    private AttributeCertificateHolder f18922holder;

    /* renamed from: issuer */
    private AttributeCertificateIssuer f18923issuer;
    private BigInteger serialNumber;
    private Collection targetNames = new HashSet();
    private Collection targetGroups = new HashSet();

    private Set extractGeneralNames(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            hashSet.add(GeneralName.getInstance(it.next()));
        }
        return hashSet;
    }

    public void addTargetGroup(GeneralName generalName) {
        this.targetGroups.add(generalName);
    }

    public void addTargetName(GeneralName generalName) {
        this.targetNames.add(generalName);
    }

    /* renamed from: build */
    public X509AttributeCertificateHolderSelector m14840build() {
        return new X509AttributeCertificateHolderSelector(this.f18922holder, this.f18923issuer, this.serialNumber, this.attributeCertificateValid, this.attributeCert, Collections.unmodifiableCollection(new HashSet(this.targetNames)), Collections.unmodifiableCollection(new HashSet(this.targetGroups)));
    }

    public void setAttributeCert(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        this.attributeCert = x509AttributeCertificateHolder;
    }

    public void setAttributeCertificateValid(Date date) {
        if (date != null) {
            this.attributeCertificateValid = new Date(date.getTime());
        } else {
            this.attributeCertificateValid = null;
        }
    }

    public void setHolder(AttributeCertificateHolder attributeCertificateHolder) {
        this.f18922holder = attributeCertificateHolder;
    }

    public void setIssuer(AttributeCertificateIssuer attributeCertificateIssuer) {
        this.f18923issuer = attributeCertificateIssuer;
    }

    public void setSerialNumber(BigInteger bigInteger) {
        this.serialNumber = bigInteger;
    }

    public void setTargetGroups(Collection collection) {
        this.targetGroups = extractGeneralNames(collection);
    }

    public void setTargetNames(Collection collection) {
        this.targetNames = extractGeneralNames(collection);
    }
}
