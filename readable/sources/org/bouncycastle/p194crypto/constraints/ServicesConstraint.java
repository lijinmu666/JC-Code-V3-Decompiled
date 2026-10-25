package org.bouncycastle.p194crypto.constraints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import org.bouncycastle.p194crypto.CryptoServicesConstraints;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public abstract class ServicesConstraint implements CryptoServicesConstraints {

    /* renamed from: LOG */
    protected static final Logger f19264LOG = Logger.getLogger(ServicesConstraint.class.getName());
    private final Set<String> exceptions;

    public ServicesConstraint(Set<String> set) {
        if (set.isEmpty()) {
            this.exceptions = Collections.EMPTY_SET;
            return;
        }
        this.exceptions = new HashSet(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            this.exceptions.add(C6250Strings.toUpperCase(it.next().toString()));
        }
        C5287Utils.addAliases(this.exceptions);
    }

    public boolean isException(String str) {
        if (this.exceptions.isEmpty()) {
            return false;
        }
        return this.exceptions.contains(C6250Strings.toUpperCase(str));
    }
}
