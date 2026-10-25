package org.bouncycastle.p177cert.p188path;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class CertPathValidationContext implements Memoable {
    private Set criticalExtensions;
    private boolean endEntity;
    private Set handledExtensions = new HashSet();

    /* renamed from: index */
    private int f18899index;

    public CertPathValidationContext(Set set) {
        this.criticalExtensions = set;
    }

    public void addHandledExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.handledExtensions.add(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        CertPathValidationContext certPathValidationContext = new CertPathValidationContext(new HashSet(this.criticalExtensions));
        certPathValidationContext.handledExtensions = new HashSet(this.handledExtensions);
        certPathValidationContext.endEntity = this.endEntity;
        certPathValidationContext.f18899index = this.f18899index;
        return certPathValidationContext;
    }

    public Set getUnhandledCriticalExtensionOIDs() {
        HashSet hashSet = new HashSet(this.criticalExtensions);
        hashSet.removeAll(this.handledExtensions);
        return hashSet;
    }

    public boolean isEndEntity() {
        return this.endEntity;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        CertPathValidationContext certPathValidationContext = (CertPathValidationContext) memoable;
        this.criticalExtensions = new HashSet(certPathValidationContext.criticalExtensions);
        this.handledExtensions = new HashSet(certPathValidationContext.handledExtensions);
        this.endEntity = certPathValidationContext.endEntity;
        this.f18899index = certPathValidationContext.f18899index;
    }

    public void setIsEndEntity(boolean z) {
        this.endEntity = z;
    }
}
