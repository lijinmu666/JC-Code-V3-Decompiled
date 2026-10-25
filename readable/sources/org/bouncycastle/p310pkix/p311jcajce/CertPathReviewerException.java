package org.bouncycastle.p310pkix.p311jcajce;

import java.security.cert.CertPath;
import org.bouncycastle.p310pkix.p312util.ErrorBundle;
import org.bouncycastle.p310pkix.p312util.LocalizedException;

/* loaded from: classes2.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;

    /* renamed from: index */
    private int f22978index;

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
        this.f22978index = -1;
        this.certPath = null;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.f22978index;
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle, th);
        this.f22978index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th, CertPath certPath, int i) {
        super(errorBundle, th);
        this.f22978index = -1;
        this.certPath = null;
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        }
        if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.f22978index = i;
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath, int i) {
        super(errorBundle);
        this.f22978index = -1;
        this.certPath = null;
        if (certPath == null || i == -1) {
            throw new IllegalArgumentException();
        }
        if (i < -1 || i >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.f22978index = i;
    }
}
