package org.bouncycastle.p310pkix;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralSubtree;
import org.bouncycastle.p133asn1.p174x509.NameConstraintValidatorException;

/* loaded from: classes2.dex */
public class PKIXNameConstraintValidator {
    ASN1PKIXNameConstraintValidator validator = new ASN1PKIXNameConstraintValidator();

    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        this.validator.addExcludedSubtree(generalSubtree);
    }

    public void checkExcluded(GeneralName generalName) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcluded(generalName);
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    public void checkExcludedDN(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcludedDN(X500Name.getInstance(aSN1Sequence));
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    public void checkExcludedEmail(String str) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcludedEmail(str);
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    public void checkPermitted(GeneralName generalName) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermitted(generalName);
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    public void checkPermittedDN(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermittedDN(X500Name.getInstance(aSN1Sequence));
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    public void checkPermittedEmail(String str) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermittedEmail(str);
        } catch (NameConstraintValidatorException e) {
            throw new PKIXNameConstraintValidatorException(e.getMessage(), e);
        }
    }

    /* renamed from: equals */
    public boolean m17436equals(Object obj) {
        if (obj instanceof PKIXNameConstraintValidator) {
            return this.validator.m17435equals(((PKIXNameConstraintValidator) obj).validator);
        }
        return false;
    }

    public int hashCode() {
        return this.validator.hashCode();
    }

    public void intersectEmptyPermittedSubtree(int i) {
        this.validator.intersectEmptyPermittedSubtree(i);
    }

    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        this.validator.intersectPermittedSubtree(generalSubtree);
    }

    public String toString() {
        return this.validator.toString();
    }

    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        this.validator.intersectPermittedSubtree(generalSubtreeArr);
    }
}
