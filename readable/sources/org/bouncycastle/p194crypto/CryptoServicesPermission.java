package org.bouncycastle.p194crypto;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class CryptoServicesPermission extends Permission {
    public static final String CONSTRAINTS = "constraints";
    public static final String DEFAULT_RANDOM = "defaultRandomConfig";
    public static final String GLOBAL_CONFIG = "globalConfig";
    public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";

    /* renamed from: actions */
    private final Set<String> f19129actions;

    public CryptoServicesPermission(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f19129actions = hashSet;
        hashSet.add(str);
    }

    /* renamed from: equals */
    public boolean m14962equals(Object obj) {
        return (obj instanceof CryptoServicesPermission) && this.f19129actions.equals(((CryptoServicesPermission) obj).f19129actions);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f19129actions.toString();
    }

    public int hashCode() {
        return this.f19129actions.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof CryptoServicesPermission)) {
            return false;
        }
        CryptoServicesPermission cryptoServicesPermission = (CryptoServicesPermission) permission;
        return getName().equals(cryptoServicesPermission.getName()) || this.f19129actions.containsAll(cryptoServicesPermission.f19129actions);
    }
}
