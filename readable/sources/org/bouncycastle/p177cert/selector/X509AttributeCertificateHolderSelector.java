package org.bouncycastle.p177cert.selector;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import org.bouncycastle.p133asn1.p174x509.C5192Target;
import org.bouncycastle.p133asn1.p174x509.C5193Targets;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.TargetInformation;
import org.bouncycastle.p177cert.AttributeCertificateHolder;
import org.bouncycastle.p177cert.AttributeCertificateIssuer;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class X509AttributeCertificateHolderSelector implements Selector {
    private final X509AttributeCertificateHolder attributeCert;
    private final Date attributeCertificateValid;

    /* renamed from: holder */
    private final AttributeCertificateHolder f18920holder;

    /* renamed from: issuer */
    private final AttributeCertificateIssuer f18921issuer;
    private final BigInteger serialNumber;
    private final Collection targetGroups;
    private final Collection targetNames;

    public X509AttributeCertificateHolderSelector(AttributeCertificateHolder attributeCertificateHolder, AttributeCertificateIssuer attributeCertificateIssuer, BigInteger bigInteger, Date date, X509AttributeCertificateHolder x509AttributeCertificateHolder, Collection collection, Collection collection2) {
        this.f18920holder = attributeCertificateHolder;
        this.f18921issuer = attributeCertificateIssuer;
        this.serialNumber = bigInteger;
        this.attributeCertificateValid = date;
        this.attributeCert = x509AttributeCertificateHolder;
        this.targetNames = collection;
        this.targetGroups = collection2;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new X509AttributeCertificateHolderSelector(this.f18920holder, this.f18921issuer, this.serialNumber, this.attributeCertificateValid, this.attributeCert, this.targetNames, this.targetGroups);
    }

    public X509AttributeCertificateHolder getAttributeCert() {
        return this.attributeCert;
    }

    public Date getAttributeCertificateValid() {
        if (this.attributeCertificateValid != null) {
            return new Date(this.attributeCertificateValid.getTime());
        }
        return null;
    }

    public AttributeCertificateHolder getHolder() {
        return this.f18920holder;
    }

    public AttributeCertificateIssuer getIssuer() {
        return this.f18921issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public Collection getTargetGroups() {
        return this.targetGroups;
    }

    public Collection getTargetNames() {
        return this.targetNames;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        Extension extension;
        C5193Targets[] targetsObjects;
        if (!(obj instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        X509AttributeCertificateHolder x509AttributeCertificateHolder = (X509AttributeCertificateHolder) obj;
        X509AttributeCertificateHolder x509AttributeCertificateHolder2 = this.attributeCert;
        if (x509AttributeCertificateHolder2 != null && !x509AttributeCertificateHolder2.m14745equals(x509AttributeCertificateHolder)) {
            return false;
        }
        if (this.serialNumber != null && !x509AttributeCertificateHolder.getSerialNumber().equals(this.serialNumber)) {
            return false;
        }
        if (this.f18920holder != null && !x509AttributeCertificateHolder.getHolder().m14741equals(this.f18920holder)) {
            return false;
        }
        if (this.f18921issuer != null && !x509AttributeCertificateHolder.getIssuer().m14743equals(this.f18921issuer)) {
            return false;
        }
        Date date = this.attributeCertificateValid;
        if (date != null && !x509AttributeCertificateHolder.isValidOn(date)) {
            return false;
        }
        if ((!this.targetNames.isEmpty() || !this.targetGroups.isEmpty()) && (extension = x509AttributeCertificateHolder.getExtension(Extension.targetInformation)) != null) {
            try {
                targetsObjects = TargetInformation.getInstance(extension.getParsedValue()).getTargetsObjects();
                if (!this.targetNames.isEmpty()) {
                    boolean z = false;
                    for (C5193Targets c5193Targets : targetsObjects) {
                        C5192Target[] targets = c5193Targets.getTargets();
                        int i = 0;
                        while (true) {
                            if (i >= targets.length) {
                                break;
                            }
                            if (this.targetNames.contains(GeneralName.getInstance(targets[i].getTargetName()))) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            if (!this.targetGroups.isEmpty()) {
                boolean z2 = false;
                for (C5193Targets c5193Targets2 : targetsObjects) {
                    C5192Target[] targets2 = c5193Targets2.getTargets();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= targets2.length) {
                            break;
                        }
                        if (this.targetGroups.contains(GeneralName.getInstance(targets2[i2].getTargetGroup()))) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    return false;
                }
            }
        }
        return true;
    }
}
