package com.p038google.p061crypto.p062tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class KeyTemplates {
    private KeyTemplates() {
    }

    /* renamed from: get */
    public static KeyTemplate m3346get(String str) throws GeneralSecurityException {
        KeyTemplate keyTemplate = Registry.keyTemplateMap().get(str);
        if (keyTemplate != null) {
            return keyTemplate;
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }
}
