package com.p038google.p061crypto.p062tink;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class KmsClients {
    private static List<KmsClient> autoClients;

    /* renamed from: clients */
    private static final CopyOnWriteArrayList<KmsClient> f3007clients = new CopyOnWriteArrayList<>();

    private KmsClients() {
    }

    /* renamed from: add */
    public static void m3374add(KmsClient kmsClient) {
        f3007clients.add(kmsClient);
    }

    /* renamed from: get */
    public static KmsClient m3375get(String str) throws GeneralSecurityException {
        Iterator<KmsClient> it = f3007clients.iterator();
        while (it.hasNext()) {
            KmsClient next = it.next();
            if (next.doesSupport(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }

    public static synchronized KmsClient getAutoLoaded(String str) {
        KmsClient next;
        try {
            if (autoClients == null) {
                autoClients = loadAutoKmsClients();
            }
            Iterator<KmsClient> it = autoClients.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.doesSupport(str)) {
                }
            }
            throw new GeneralSecurityException("No KMS client does support: " + str);
        } catch (Throwable th) {
            throw th;
        }
        return next;
    }

    private static List<KmsClient> loadAutoKmsClients() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(KmsClient.class).iterator();
        while (it.hasNext()) {
            arrayList.add((KmsClient) it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: reset */
    public static void m3376reset() {
        f3007clients.clear();
    }
}
